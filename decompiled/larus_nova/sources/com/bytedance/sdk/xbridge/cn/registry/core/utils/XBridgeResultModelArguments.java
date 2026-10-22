package com.bytedance.sdk.xbridge.cn.registry.core.utils;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalOperationException;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalOutputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import me7.f;
import me7.i;
import me7.o;
import ne7.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J6\u0010\r\u001a\u00020\u0004\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0002J#\u0010\u0014\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011¢\u0006\u0002\u0010\u0015J0\u0010\u0016\u001a\u0004\u0018\u00010\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00112\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeResultModelArguments;", "", "()V", "checkEnum", "", "isEnum", "", "enumModel", "", "actualFieldValue", "keyPath", "", "checkEnumBasic", "convertToMap", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "clazz", "Ljava/lang/Class;", "contentMap", "", "createModel", "(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "getValue", "arg", "objectInstance", "returnType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class XBridgeResultModelArguments {
    public static final XBridgeResultModelArguments INSTANCE = null;

    public static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Object> f270090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class<T> f270091b;

        public a(Class<T> r100) {
            this.f270091b = r100;
            this.f270090a = new LinkedHashMap();
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r110, Method r111, Object[] r112) {
            Intrinsics.checkNotNullParameter(r111, e.f25671s);
            ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, f> r100 = o.f513548a;
            GenericDeclaration r101 = this.f270091b;
            Intrinsics.checkNotNullParameter(r101, "resultModelClazz");
            Class<? extends IDLXBridgeMethod> r102 = o.f513549b.get(r101);
            Object r103 = null;
            if (r102 != null) goto L5;
            f r104 = null;
        L7:
            if (r104 == null) goto L144;
            if (Intrinsics.areEqual(r111.getName(), "convert") == false) goto L132;
            int r113 = ne7.f.f518890a;
            Map<String, Object> r114 = this.f270090a;
            Intrinsics.checkNotNullParameter(r104, "pool");
            Intrinsics.checkNotNullParameter(r114, "contentMap");
            Iterator<Map.Entry<String, i>> r115 = r104.f513527d.f513530b.entrySet().iterator();
        L12:
            if (r115.hasNext() == false) goto L131;
            i r116 = r115.next().getValue();
            String r105 = r116.f513538b;
            boolean r106 = r116.f513537a;
            Class<?> r107 = r116.f513544h;
            boolean r108 = r116.f513541e;
            if (r108 == true) goto L16;
        L18:
            if (r108 == true) goto L20;
        L22:
            if (r108 == true) goto L24;
        L31:
            if (r108 == true) goto L33;
        L40:
            List r109 = null;
        L41:
            LinkedHashMap r117 = (LinkedHashMap) r114;
            Object r118 = r117.get(r105);
            if (r118 != null) goto L47;
            if (r106 == false) goto L47;
            throw new IllegalOutputParamException(r105 + " is missing from output");
        L47:
            boolean r119 = Intrinsics.areEqual(r107, Number.class);
            int r120 = ne7.f.f518890a;
            if (r119 == false) goto L62;
            if (r118 == null) goto L129;
            ne7.f.a(r108, r109, r118, r105);
            if ((r118 instanceof Integer) == true) goto L129;
            if ((r118 instanceof Double) == true) goto L129;
            if ((r118 instanceof Long) == true) goto L129;
            if ((r118 instanceof Float) == true) goto L129;
            throw new IllegalOutputParamException(r105 + " is of invalid return type");
        L129:
            r117.put(r116.f513538b, ne7.f.b(r118, XBaseModel.class, r107));
            goto L12
        L62:
            if (Intrinsics.areEqual(r107, String.class) == false) goto L75;
            if (r118 != null) goto L68;
            if (r106 == false) goto L68;
            throw new IllegalOutputParamException(r105 + " is missing from output");
        L68:
            if (r118 == null) goto L129;
            ne7.f.a(r108, r109, r118, r105);
            if ((r118 instanceof String) == true) goto L129;
            throw new IllegalOutputParamException(r105 + " is of invalid return type");
        L75:
            if (Intrinsics.areEqual(r107, Boolean.class) == false) goto L77;
            boolean r121 = true;
        L78:
            if (r121 == false) goto L91;
            if (r118 != null) goto L84;
            if (r106 == false) goto L84;
            throw new IllegalOutputParamException(r105 + " is missing from output");
        L84:
            if (r118 == null) goto L129;
            if ((r118 instanceof Boolean) == true) goto L129;
            throw new IllegalOutputParamException(r105 + " is of invalid return type");
        L91:
            if (Intrinsics.areEqual(r107, List.class) == false) goto L104;
            if (r118 != null) goto L97;
            if (r106 == false) goto L97;
            throw new IllegalOutputParamException(r105 + " is missing from output");
        L97:
            if (r118 == null) goto L129;
            if ((r118 instanceof List) == false) goto L102;
            ne7.f.a(r108, r109, r118, r105);
            goto L129
        L102:
            throw new IllegalOutputParamException(r105 + " is of invalid return type");
        L104:
            if (Intrinsics.areEqual(r107, Map.class) == false) goto L117;
            if (r118 != null) goto L110;
            if (r106 == false) goto L110;
            throw new IllegalOutputParamException(r105 + " is missing from output");
        L110:
            if (r118 == null) goto L129;
            if ((r118 instanceof Map) == false) goto L115;
            ne7.f.a(r108, r109, ((Map) r118).values(), r105);
            goto L129
        L115:
            throw new IllegalOutputParamException(r105 + " is of invalid return type");
        L117:
            if (Intrinsics.areEqual(r107, Object.class) == false) goto L123;
            if (r118 != null) goto L129;
            if (r106 == false) goto L129;
            throw new IllegalOutputParamException(r105 + " is missing from output");
        L123:
            if (r118 == null) goto L129;
            if ((r118 instanceof XBaseModel) == true) goto L129;
            throw new IllegalInputParamException("Failed to parse type " + r107.getName() + ',' + r118 + " must be sub class of XBaseModel");
        L77:
            r121 = Intrinsics.areEqual(r107, Boolean.TYPE);
            goto L78
        L33:
            if (Intrinsics.areEqual(r107, Map.class) == false) goto L40;
            KClass<? extends Object> r122 = r116.f513540d;
            if (Intrinsics.areEqual(r122, Reflection.getOrCreateKotlinClass(Number.class)) == false) goto L38;
            r109 = r116.f513546j;
            goto L41
        L38:
            if (Intrinsics.areEqual(r122, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L40;
            r109 = r116.f513545i;
            goto L41
        L24:
            if (Intrinsics.areEqual(r107, List.class) == false) goto L31;
            KClass<? extends Object> r123 = r116.f513540d;
            if (Intrinsics.areEqual(r123, Reflection.getOrCreateKotlinClass(Number.class)) == false) goto L29;
            r109 = r116.f513546j;
            goto L41
        L29:
            if (Intrinsics.areEqual(r123, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L40;
            r109 = r116.f513545i;
            goto L41
        L20:
            if (Intrinsics.areEqual(r107, String.class) == false) goto L22;
            r109 = r116.f513545i;
            goto L41
        L16:
            if (Intrinsics.areEqual(r107, Number.class) == false) goto L18;
            r109 = r116.f513546j;
            goto L41
        L131:
            return this.f270090a;
        L132:
            int r124 = ne7.f.f518890a;
            Map<String, Object> r125 = this.f270090a;
            Intrinsics.checkNotNullParameter(r104, "pool");
            Intrinsics.checkNotNullParameter(r125, "contentMap");
            Intrinsics.checkNotNullParameter(r111, e.f25671s);
            i r126 = r104.f513527d.f513529a.get(r111);
            if (r126 == null) goto L142;
            if (r126.f513542f == true) goto L191;
            if (r112 == null) goto L139;
            r103 = ArraysKt.firstOrNull(r112);
        L139:
            r125.put(r126.f513538b, r103);
            return Unit.INSTANCE;
        L191:
            return ((LinkedHashMap) r125).get(r126.f513538b);
        L142:
            throw new IllegalOperationException("Unsupported method invocation in result model");
        L144:
            if (Intrinsics.areEqual(r111.getName(), "convert") == false) goto L147;
            XBridgeResultModelArguments.access$convertToMap(XBridgeResultModelArguments.INSTANCE, this.f270091b, this.f270090a);
            return this.f270090a;
        L147:
            XBridgeParamField r127 = (XBridgeParamField) r111.getAnnotation(XBridgeParamField.class);
            if (r127 != null) goto L150;
        L153:
            if (r127 == null) goto L160;
            XBridgeParamField r128 = (XBridgeParamField) r111.getAnnotation(XBridgeParamField.class);
            if (r112 == null) goto L157;
            r103 = ArraysKt.firstOrNull(r112);
        L157:
            this.f270090a.put(r128.keyPath(), r103);
            return Unit.INSTANCE;
        L160:
            throw new IllegalOperationException("Unsupported method invocation in result model");
        L150:
            if (r127.isGetter() == false) goto L153;
            XBridgeParamField r129 = (XBridgeParamField) r111.getAnnotation(XBridgeParamField.class);
            return ((LinkedHashMap) this.f270090a).get(r129.keyPath());
        L5:
            r104 = o.f513548a.get(r102);
            goto L7
        }
    }

    static {
        INSTANCE = new XBridgeResultModelArguments();
    }

    private XBridgeResultModelArguments() {
    }

    public final <T extends XBaseModel> T createModel(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new a(r100));
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type T of com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments.createModel");
        return (T) r101;
    }

    private final boolean checkEnumBasic(Annotation r100, Object r101) {
        if ((r100 instanceof XBridgeStringEnum) == false) goto L8;
        if (ArraysKt.contains(((XBridgeStringEnum) r100).option(), r101) == true) goto L13;
    L11:
        return true;
    L13:
        return false;
    L8:
        if ((r100 instanceof XBridgeIntEnum) == false) goto L11;
        int[] r102 = ((XBridgeIntEnum) r100).option();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        if (ArraysKt.contains(r102, ((Integer) r101).intValue()) == false) goto L11;
        return false;
    }

    private final <T extends XBaseModel> void convertToMap(Class<T> r110, Map<String, Object> r111) {
        Method[] r112 = r110.getDeclaredMethods();
        ArrayList r100 = new ArrayList();
        int r101 = r112.length;
        int r102 = 0;
    L3:
        boolean r103 = true;
        if (r102 >= r101) goto L14;
        Method r104 = r112[r102];
        XBridgeParamField r105 = (XBridgeParamField) r104.getAnnotation(XBridgeParamField.class);
        if (r105 != null) goto L8;
    L10:
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        r100.add(r104);
    L13:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r105.isGetter() != true) goto L10;
    L14:
        Iterator r113 = r100.iterator();
    L16:
        if (r113.hasNext() == false) goto L135;
        Method r106 = (Method) r113.next();
        XBridgeParamField r107 = (XBridgeParamField) r106.getAnnotation(XBridgeParamField.class);
        String r108 = r107.keyPath();
        boolean r109 = r107.required();
        Class<?> r114 = r106.getReturnType();
        boolean r115 = r107.isEnum();
        if (r115 == true) goto L20;
    L22:
        if (r115 == false) goto L27;
        if (Intrinsics.areEqual(r114, String.class) == false) goto L27;
        Annotation r116 = r106.getAnnotation(XBridgeStringEnum.class);
    L46:
        Object r117 = r111.get(r108);
        if (r117 != null) goto L53;
        if (r109 == false) goto L53;
        throw new IllegalOutputParamException(r108 + " is missing from output");
    L53:
        if (Intrinsics.areEqual(r114, Number.class) == false) goto L67;
        if (r117 == null) goto L134;
        INSTANCE.checkEnum(r115, r116, r117, r108);
        if ((r117 instanceof Integer) == true) goto L134;
        if ((r117 instanceof Double) == true) goto L134;
        if ((r117 instanceof Long) == true) goto L134;
        if ((r117 instanceof Float) == true) goto L134;
        throw new IllegalOutputParamException(r108 + " is of invalid return type");
    L134:
        r111.put(r107.keyPath(), INSTANCE.getValue(r117, XBaseModel.class, r114));
        goto L16
    L67:
        if (Intrinsics.areEqual(r114, String.class) == false) goto L80;
        if (r117 != null) goto L73;
        if (r109 == false) goto L73;
        throw new IllegalOutputParamException(r108 + " is missing from output");
    L73:
        if (r117 == null) goto L134;
        INSTANCE.checkEnum(r115, r116, r117, r108);
        if ((r117 instanceof String) == true) goto L134;
        throw new IllegalOutputParamException(r108 + " is of invalid return type");
    L80:
        if (Intrinsics.areEqual(r114, Boolean.class) == false) goto L82;
        boolean r118 = true;
    L83:
        if (r118 == false) goto L96;
        if (r117 != null) goto L89;
        if (r109 == false) goto L89;
        throw new IllegalOutputParamException(r108 + " is missing from output");
    L89:
        if (r117 == null) goto L134;
        if ((r117 instanceof Boolean) == true) goto L134;
        throw new IllegalOutputParamException(r108 + " is of invalid return type");
    L96:
        if (Intrinsics.areEqual(r114, List.class) == false) goto L109;
        if (r117 != null) goto L102;
        if (r109 == false) goto L102;
        throw new IllegalOutputParamException(r108 + " is missing from output");
    L102:
        if (r117 == null) goto L134;
        if ((r117 instanceof List) == false) goto L107;
        INSTANCE.checkEnum(r115, r116, r117, r108);
        goto L134
    L107:
        throw new IllegalOutputParamException(r108 + " is of invalid return type");
    L109:
        if (Intrinsics.areEqual(r114, Map.class) == false) goto L122;
        if (r117 != null) goto L115;
        if (r109 == false) goto L115;
        throw new IllegalOutputParamException(r108 + " is missing from output");
    L115:
        if (r117 == null) goto L134;
        if ((r117 instanceof Map) == false) goto L120;
        INSTANCE.checkEnum(r115, r116, ((Map) r117).values(), r108);
        goto L134
    L120:
        throw new IllegalOutputParamException(r108 + " is of invalid return type");
    L122:
        if (Intrinsics.areEqual(r114, Object.class) == false) goto L128;
        if (r117 != null) goto L134;
        if (r109 == false) goto L134;
        throw new IllegalOutputParamException(r108 + " is missing from output");
    L128:
        if (r117 == null) goto L134;
        if ((r117 instanceof XBaseModel) == true) goto L134;
        throw new IllegalInputParamException("Failed to parse type " + r114.getName() + ',' + r117 + " must be sub class of XBaseModel");
    L82:
        r118 = Intrinsics.areEqual(r114, Boolean.TYPE);
    L27:
        if (r115 == true) goto L29;
    L36:
        if (r115 == true) goto L38;
    L45:
        r116 = null;
        goto L46
    L38:
        if (Intrinsics.areEqual(r114, Map.class) == false) goto L45;
        KClass r119 = Reflection.getOrCreateKotlinClass(r107.primitiveClassType());
        if (Intrinsics.areEqual(r119, Reflection.getOrCreateKotlinClass(Number.class)) == false) goto L43;
        r116 = r106.getAnnotation(XBridgeIntEnum.class);
        goto L46
    L43:
        if (Intrinsics.areEqual(r119, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L45;
        r116 = r106.getAnnotation(XBridgeStringEnum.class);
        goto L46
    L29:
        if (Intrinsics.areEqual(r114, List.class) == false) goto L36;
        KClass r120 = Reflection.getOrCreateKotlinClass(r107.primitiveClassType());
        if (Intrinsics.areEqual(r120, Reflection.getOrCreateKotlinClass(Number.class)) == false) goto L34;
        r116 = r106.getAnnotation(XBridgeIntEnum.class);
        goto L46
    L34:
        if (Intrinsics.areEqual(r120, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L45;
        r116 = r106.getAnnotation(XBridgeStringEnum.class);
        goto L46
    L20:
        if (Intrinsics.areEqual(r114, Number.class) == false) goto L22;
        r116 = r106.getAnnotation(XBridgeIntEnum.class);
        goto L46
    }

    public static final /* synthetic */ void access$convertToMap(XBridgeResultModelArguments r100, Class r101, Map r102) {
        r100.convertToMap(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.ArrayList, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    private final Object getValue(Object r100, Class<? extends XBaseModel> r101, Class<?> r102) {
        if (Intrinsics.areEqual(r102, Object.class) == false) goto L8;
        if ((r100 instanceof c) == false) goto L8;
        return ((c) r100).getValue();
    L8:
        if ((r100 instanceof Integer) == false) goto L10;
        return r100;
    L10:
        if ((r100 instanceof String) == false) goto L12;
        return r100;
    L12:
        if ((r100 instanceof Number) == false) goto L14;
        return r100;
    L14:
        if ((r100 instanceof Boolean) == true) goto L46;
        if (r100 != null) goto L18;
        return r100;
    L18:
        if ((r100 instanceof List) == false) goto L25;
        Iterable r103 = (Iterable) r100;
        ?? r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L21:
        if (r105.hasNext() == false) goto L47;
        Object r106 = r105.next();
        r104.add(INSTANCE.getValue(r106, r101, r102));
    L47:
        return r104;
    L25:
        if ((r100 instanceof Map) == false) goto L31;
        Map r107 = (Map) r100;
        r104 = new LinkedHashMap(MapsKt.mapCapacity(r107.size()));
        Iterator r108 = r107.entrySet().iterator();
    L28:
        if (r108.hasNext() == false) goto L47;
        Map.Entry r109 = (Map.Entry) r108.next();
        r104.put(r109.getKey(), INSTANCE.getValue(r109.getValue(), r101, r102));
        goto L28
    L31:
        if ((r100 instanceof JSONObject) == false) goto L33;
        return r100;
    L33:
        if ((r100 instanceof JSONArray) == true) goto L51;
        XBaseModel r110 = r101.cast(r100);
        if (r110 != null) goto L49;
        return null;
    L49:
        return r110.convert();
    L51:
        return r100;
    L46:
        return r100;
    }

    private final void checkEnum(boolean r100, Annotation r101, Object r102, String r103) {
        if (r100 == true) goto L4;
        return;
    L4:
        if ((r102 instanceof Collection) == false) goto L16;
        Iterable r104 = (Iterable) r102;
        boolean r105 = false;
        if ((r104 instanceof Collection) == true) goto L8;
    L10:
        Iterator r106 = r104.iterator();
    L12:
        if (r106.hasNext() == false) goto L17;
        if (INSTANCE.checkEnumBasic(r101, r106.next()) == false) goto L12;
        r105 = true;
    L17:
        if (r105 == true) goto L20;
        return;
    L20:
        throw new IllegalOutputParamException(r103 + " is not valid");
    L8:
        if (((Collection) r104).isEmpty() == false) goto L10;
    L16:
        r105 = checkEnumBasic(r101, r102);
        goto L17
    }
}
