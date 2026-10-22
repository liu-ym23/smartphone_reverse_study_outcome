package com.bytedance.tools.kcp.modelx.runtime.internal.reflect;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.slice.SliceInitService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a implements InvocationHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f270984b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient f f270985a;

    /* JADX INFO: renamed from: com.bytedance.tools.kcp.modelx.runtime.internal.reflect.a$a, reason: collision with other inner class name */
    public static final class C3798a {
    }

    static {
        f270984b = vh7.c.class.getDeclaredMethod("castTo", new Class[]{Class.class});
    }

    public a(f r100) {
        this.f270985a = r100;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) {
        Intrinsics.checkNotNullParameter(r100, "proxy");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        f r103 = this.f270985a;
        if (r103 == null) goto L7;
        Pair<Boolean, Object> r104 = r103.a(this, r100, r101, r102);
        boolean r105 = r104.component1().booleanValue();
        Object r106 = r104.component2();
        if (r105 == false) goto L7;
        return r106;
    L7:
        e r107 = (e) this;
        Intrinsics.checkNotNullParameter(r100, "proxy");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        if (b.a(r101, f270984b, true) == false) goto L47;
        if (r102 == null) goto L46;
        Object r108 = r102[0];
        if (r108 == null) goto L44;
        Class r109 = (Class) r108;
        if (r109.isInterface() == false) goto L19;
        Class[] r110 = new Class[1];
        Object r111 = r102[0];
        if (r111 == null) goto L18;
        r110[0] = (Class) r111;
        return ModelXReflections.g(r110, r107.f270985a);
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L19:
        Class<?> r112 = ModelXReflections.a(r109);
        if (vh7.e.class.isAssignableFrom(r109) == false) goto L35;
        Constructor r113 = r109.getConstructor(new Class[]{r112});
        Object[] r114 = new Object[1];
        if ((r100 instanceof vh7.e) == false) goto L29;
        Object r115 = ((vh7.e) r100).getFlexInstance();
        if (r115 == null) goto L27;
        vh7.c r116 = (vh7.c) r115;
    L31:
        r114[0] = r116;
        return r113.newInstance(r114);
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>");
    L29:
        if ((r100 instanceof vh7.c) == false) goto L33;
        r116 = (vh7.c) r100;
        goto L31
    L33:
        throw new IllegalStateException("Check failed.".toString());
    L35:
        if (vh7.c.class.isAssignableFrom(r109) == false) goto L42;
        if (r112.isAssignableFrom(r109) == false) goto L40;
        return r109.getConstructor(new Class[0]).newInstance(new Object[0]);
    L40:
        throw new IllegalStateException(("cannot cast flex type to another: " + r109 + ", " + r112).toString());
    L42:
        throw new IllegalStateException(("type must be FlexModel: " + r109).toString());
    L44:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L46:
        throw new IllegalStateException(("args must not be null for method: " + r101).toString());
    L47:
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Class<?> r117 = r101.getReturnType();
        if (r117 == null) goto L122;
        if (Intrinsics.areEqual(r117, Void.class) == true) goto L122;
        if (Intrinsics.areEqual(r117, Void.TYPE) == true) goto L122;
        if (Intrinsics.areEqual(r117, null) == true) goto L122;
        if (Intrinsics.areEqual(r117, Unit.class) == true) goto L122;
        if (Intrinsics.areEqual(r117, Boolean.TYPE) == true) goto L138;
        if (Intrinsics.areEqual(r117, Boolean.class) == true) goto L138;
        if (Intrinsics.areEqual(r117, Character.TYPE) == true) goto L137;
        if (Intrinsics.areEqual(r117, Character.class) == true) goto L137;
        if (Intrinsics.areEqual(r117, Byte.TYPE) == true) goto L136;
        if (Intrinsics.areEqual(r117, Byte.class) == true) goto L136;
        if (Intrinsics.areEqual(r117, Short.TYPE) == true) goto L135;
        if (Intrinsics.areEqual(r117, Short.class) == true) goto L135;
        if (Intrinsics.areEqual(r117, Integer.TYPE) == true) goto L134;
        if (Intrinsics.areEqual(r117, Integer.class) == true) goto L134;
        if (Intrinsics.areEqual(r117, Long.TYPE) == true) goto L133;
        if (Intrinsics.areEqual(r117, Long.class) == true) goto L133;
        if (Intrinsics.areEqual(r117, Float.TYPE) == true) goto L132;
        if (Intrinsics.areEqual(r117, Float.class) == true) goto L132;
        if (Intrinsics.areEqual(r117, Double.TYPE) == true) goto L131;
        if (Intrinsics.areEqual(r117, Double.class) == true) goto L131;
        if (Intrinsics.areEqual(r117, String.class) == false) goto L104;
        return "";
    L104:
        if (Collection.class.isAssignableFrom(r117) == false) goto L107;
        return ModelXReflections.f(r117, "[]", false);
    L107:
        if (Map.class.isAssignableFrom(r117) == false) goto L110;
        return ModelXReflections.f(r117, SliceInitService.DEFAULT_SWITCH, false);
    L110:
        if (r117.isInterface() == false) goto L130;
        return ModelXReflections.g(new Class[]{r117}, f.a.f270991b);
    L130:
        return ModelXReflections.f(r117, SliceInitService.DEFAULT_SWITCH, true);
    L131:
        return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L132:
        return Float.valueOf(0.0f);
    L133:
        return 0L;
    L134:
        return 0;
    L135:
        return Short.valueOf((short) 0);
    L136:
        return Byte.valueOf(ByteCompanionObject.MIN_VALUE);
    L137:
        return (char) 0;
    L138:
        return Boolean.FALSE;
    L122:
        return null;
    }
}
