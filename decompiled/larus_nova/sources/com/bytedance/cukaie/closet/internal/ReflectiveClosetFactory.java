package com.bytedance.cukaie.closet.internal;

import com.bytedance.cukaie.closet.IllegalInvocationException;
import com.bytedance.cukaie.closet.annotation.Closet;
import com.bytedance.cukaie.closet.annotation.In;
import com.bytedance.cukaie.closet.annotation.Out;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/cukaie/closet/internal/ReflectiveClosetFactory;", "", "", "closetName", "Lgj4/a;", ComplianceConstants.ComplianceRequest.MARKET_STORE, "createCloset", "Lcom/bytedance/cukaie/closet/annotation/Closet;", "closetAnnotation", "Lcom/bytedance/cukaie/closet/annotation/Closet;", "Ljava/lang/Class;", "clazz", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "cukaie-closet-base_release"}, k = 1, mv = {1, 4, 0})
public final class ReflectiveClosetFactory {
    private final Class<?> clazz;
    private final Closet closetAnnotation;

    public static final class a implements InvocationHandler {
        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r110) {
            In r102 = (In) r101.getAnnotation(In.class);
            Out r103 = (Out) r101.getAnnotation(Out.class);
            boolean r104 = true;
            if (r102 == null) goto L108;
            if (r110 == null) goto L107;
            if (r110.length != 1) goto L107;
            Class<?> r105 = r101.getParameterTypes()[0];
            r102.value();
            Object r106 = r110[0];
            if (r106 == null) goto L10;
        L40:
            r104 = false;
        L41:
            if (r104 == false) goto L43;
            throw null;
        L43:
            if (r105.isAssignableFrom(Integer.TYPE) == false) goto L45;
        L100:
            if (r106 == null) goto L104;
            ((Integer) r106).intValue();
            throw null;
        L104:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        L45:
            if (r105.isAssignableFrom(Integer.class) == true) goto L100;
            if (r105.isAssignableFrom(Float.TYPE) == false) goto L50;
        L95:
            if (r106 == null) goto L99;
            ((Float) r106).floatValue();
            throw null;
        L99:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        L50:
            if (r105.isAssignableFrom(Float.class) == true) goto L95;
            if (r105.isAssignableFrom(Boolean.TYPE) == false) goto L55;
        L90:
            if (r106 == null) goto L94;
            ((Boolean) r106).booleanValue();
            throw null;
        L94:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
        L55:
            if (r105.isAssignableFrom(Boolean.class) == true) goto L90;
            if (r105.isAssignableFrom(Long.TYPE) == false) goto L60;
        L85:
            if (r106 == null) goto L89;
            ((Long) r106).longValue();
            throw null;
        L89:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
        L60:
            if (r105.isAssignableFrom(Long.class) == true) goto L85;
            if (r105.isAssignableFrom(String.class) == false) goto L70;
            if ((r106 instanceof String) == true) goto L67;
            r106 = null;
        L67:
            String r107 = (String) r106;
            throw null;
        L70:
            if (r105.isAssignableFrom(byte[].class) == false) goto L77;
            if ((r106 instanceof byte[]) == true) goto L74;
            r106 = null;
        L74:
            byte[] r108 = (byte[]) r106;
            throw null;
        L77:
            if (r105.isAssignableFrom(Set.class) == false) goto L84;
            if ((r106 instanceof Set) == true) goto L81;
            r106 = null;
        L81:
            Set r109 = (Set) r106;
            throw null;
        L84:
            throw new IllegalInvocationException("Method " + r101.getName() + " with @In annotation has incompatible parameter type " + r105.getCanonicalName() + '.');
        L10:
            if (r105.isAssignableFrom(Integer.TYPE) == false) goto L12;
        L21:
            boolean r111 = true;
        L22:
            if (r111 == false) goto L24;
        L37:
            boolean r112 = true;
        L38:
            if (r112 == false) goto L40;
        L24:
            if (r105.isAssignableFrom(Integer.class) == false) goto L26;
        L33:
            boolean r113 = true;
        L34:
            if (r113 == true) goto L37;
            r112 = false;
            goto L38
        L26:
            if (r105.isAssignableFrom(Float.class) == true) goto L33;
            if (r105.isAssignableFrom(Boolean.class) == true) goto L33;
            if (r105.isAssignableFrom(Long.class) == true) goto L33;
            r113 = false;
            goto L34
        L12:
            if (r105.isAssignableFrom(Float.TYPE) == true) goto L21;
            if (r105.isAssignableFrom(Boolean.TYPE) == true) goto L21;
            if (r105.isAssignableFrom(Long.TYPE) == true) goto L21;
            if (r105.isAssignableFrom(Long.class) == true) goto L21;
            r111 = false;
        L107:
            throw new IllegalInvocationException("Method " + r101.getName() + " with @In annotation should have at least and only One parameter.");
        L108:
            if (r103 == null) goto L187;
            if (r110 != null) goto L111;
        L121:
            if (r110 == null) goto L123;
            Object r114 = ArraysKt.getOrNull(r110, 0);
        L124:
            Class<?> r115 = r101.getReturnType();
            if (r115.isAssignableFrom(Integer.TYPE) == false) goto L127;
        L182:
            if (r114 == null) goto L185;
            r103.value();
            ((Integer) r114).intValue();
            throw null;
        L185:
            r103.value();
            throw null;
        L127:
            if (r115.isAssignableFrom(Integer.class) == true) goto L182;
            if (r115.isAssignableFrom(Float.TYPE) == false) goto L132;
        L177:
            if (r114 == null) goto L180;
            r103.value();
            ((Float) r114).floatValue();
            throw null;
        L180:
            r103.value();
            throw null;
        L132:
            if (r115.isAssignableFrom(Float.class) == true) goto L177;
            if (r115.isAssignableFrom(Boolean.TYPE) == false) goto L137;
        L172:
            if (r114 == null) goto L175;
            r103.value();
            ((Boolean) r114).booleanValue();
            throw null;
        L175:
            r103.value();
            throw null;
        L137:
            if (r115.isAssignableFrom(Boolean.class) == true) goto L172;
            if (r115.isAssignableFrom(Long.TYPE) == false) goto L142;
        L167:
            if (r114 == null) goto L170;
            r103.value();
            ((Long) r114).longValue();
            throw null;
        L170:
            r103.value();
            throw null;
        L142:
            if (r115.isAssignableFrom(Long.class) == true) goto L167;
            if (r115.isAssignableFrom(String.class) == false) goto L152;
            if (r114 == null) goto L149;
            r103.value();
            String r116 = (String) r114;
            throw null;
        L149:
            r103.value();
            throw null;
        L152:
            if (r115.isAssignableFrom(byte[].class) == false) goto L159;
            if (r114 == null) goto L156;
            r103.value();
            byte[] r117 = (byte[]) r114;
            throw null;
        L156:
            r103.value();
            throw null;
        L159:
            if (r115.isAssignableFrom(Set.class) == false) goto L166;
            if (r114 == null) goto L163;
            r103.value();
            Set r118 = (Set) r114;
            throw null;
        L163:
            r103.value();
            throw null;
        L166:
            throw new IllegalInvocationException("Method " + r101.getName() + " with @Out annotation has incompatible return type " + r115.getCanonicalName() + '.');
        L123:
            r114 = null;
            goto L124
        L111:
            if (r110.length != 0) goto L113;
            boolean r119 = true;
        L115:
            if ((!r119) == false) goto L121;
            if (r110.length == 1) goto L121;
            throw new IllegalInvocationException("Method " + r101.getName() + " with @Out annotation should have One or Zero parameter.");
        L113:
            r119 = false;
            goto L115
        L187:
            return null;
        }
    }

    public String closetName() {
        return this.closetAnnotation.value();
    }

    public ReflectiveClosetFactory(Class<?> r100) {
        this.clazz = r100;
        Closet r101 = (Closet) r100.getAnnotation(Closet.class);
        if (r101 == null) goto L7;
        this.closetAnnotation = r101;
        return;
    L7:
        throw new IllegalInvocationException("Couldn't find @Closet annotation on class " + r100.getCanonicalName());
    }

    public Object createCloset(gj4.a r100) {
        return Proxy.newProxyInstance(this.clazz.getClassLoader(), new Class[]{this.clazz}, new a());
    }
}
