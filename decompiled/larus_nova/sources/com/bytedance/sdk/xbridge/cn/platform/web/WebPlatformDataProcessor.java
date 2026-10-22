package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.sdk.xbridge.cn.protocol.g;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import id7.e;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import me7.f;
import me7.l;
import me7.o;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class WebPlatformDataProcessor implements g<JSONObject, JSONObject> {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f270019a = null;

        static {
            int[] r100 = new int[DefaultType.values().length];
            r100[DefaultType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DefaultType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DefaultType.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f270019a = r100;
        }
    }

    public static final class b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebPlatformDataProcessor f270020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class<? extends XBaseModel> f270021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f270022c;

        public b(WebPlatformDataProcessor r100, Class<? extends XBaseModel> r101, JSONObject r102) {
            this.f270020a = r100;
            this.f270021b = r101;
            this.f270022c = r102;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            if (Intrinsics.areEqual(r101.getName(), "toJSON") == true) goto L5;
            XBridgeParamField r103 = (XBridgeParamField) r101.getAnnotation(XBridgeParamField.class);
            Object r104 = this.f270022c.opt(r103.keyPath());
            return WebPlatformDataProcessor.e(this.f270020a, r104, r103);
        L5:
            return this.f270020a.g(this.f270021b, this.f270022c);
        }
    }

    public WebPlatformDataProcessor() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final Map d(JSONObject r100) {
        JSONObject r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        return ConvertUtils.INSTANCE.jsonToMap(r101);
    }

    public final int f(Object r100) {
        if ((r100 instanceof Number) == true) goto L5;
        if (r100 != null) goto L10;
        throw new IllegalInputParamException("the key is null");
    L10:
        throw new IllegalInputParamException("the key is not a number");
    L5:
        return ((Number) r100).intValue();
    }

    public static Map h(JSONObject r100, Function1 r101) {
        HashMap r102 = new HashMap();
        Iterator<String> r103 = r100.keys();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = r103.next();
        r102.put(r104, r101.invoke(new Pair(r104, r100.opt(r104))));
        goto L4
    L6:
        return r102;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final /* bridge */ /* synthetic */ Map b(JSONObject r100, Class r101) {
        return l(r100, r101);
    }

    public final JSONObject g(Class<? extends XBaseModel> r100, JSONObject r101) {
        if (r100 == null) goto L16;
        Method[] r102 = r100.getDeclaredMethods();
        if (r102 == null) goto L16;
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L17;
        Method r106 = r102[r105];
        XBridgeParamField r107 = (XBridgeParamField) r106.getAnnotation(XBridgeParamField.class);
        if (r107 == null) goto L12;
        boolean r108 = true;
        if (r107.isGetter() != true) goto L12;
    L13:
        if (r108 == false) goto L15;
        r103.add(r106);
    L15:
        r105 = r105 + 1;
    L12:
        r108 = false;
    L17:
        if (r103 == null) goto L39;
        JSONObject r109 = new JSONObject();
        Iterator r110 = r103.iterator();
    L20:
        if (r110.hasNext() == false) goto L47;
        Method r111 = (Method) r110.next();
        XBridgeParamField r112 = (XBridgeParamField) r111.getAnnotation(XBridgeParamField.class);
        Object r113 = r101.opt(r112.keyPath());
        if (r113 == null) goto L24;
    L26:
        final KClass r114 = Reflection.getOrCreateKotlinClass(r112.nestedClassType());
        String r115 = r112.keyPath();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r112.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L32;
        if ((r113 instanceof JSONObject) == false) goto L32;
        Object r116 = g(JvmClassMappingKt.getJavaClass(r114), (JSONObject) r113);
    L37:
        r109.put(r115, r116);
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r112.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == false) goto L34;
    L36:
        r116 = r101.opt(r112.keyPath());
        goto L37
    L34:
        if ((r113 instanceof JSONArray) == false) goto L36;
        r116 = com.bytedance.sdk.xbridge.cn.utils.b.a((JSONArray) r113, new WebPlatformDataProcessor$getMapWithDefault$1$1(this, r114));
        goto L37
    L24:
        if (r112.defaultValue().type() == DefaultType.NONE) goto L26;
        Object r117 = i(r111, r112);
        r101.put(r112.keyPath(), r117);
        goto L26
    L47:
        return r109;
    L39:
        return new JSONObject();
    L16:
        r103 = null;
        goto L17
    }

    public final Object i(Method r100, XBridgeParamField r101) {
        Class<?> r102 = r100.getReturnType();
        boolean r103 = true;
        if (Intrinsics.areEqual(r102, Number.class) == false) goto L15;
        DefaultType r104 = r101.defaultValue().type();
        int r105 = a.f270019a[r104.ordinal()];
        if (r105 == 1) goto L25;
        if (r105 == 2) goto L24;
        if (r105 == 3) goto L23;
        return Integer.valueOf(r101.defaultValue().intValue());
    L23:
        return Integer.valueOf(r101.defaultValue().intValue());
    L24:
        return Long.valueOf(r101.defaultValue().longValue());
    L25:
        return Double.valueOf(r101.defaultValue().doubleValue());
    L15:
        if (Intrinsics.areEqual(r102, Boolean.TYPE) == true) goto L18;
        r103 = Intrinsics.areEqual(r102, Boolean.class);
    L18:
        if (r103 == false) goto L21;
        return Boolean.valueOf(r101.defaultValue().boolValue());
    L21:
        return r101.defaultValue().stringValue();
    }

    public final HashMap<String, Pair<Method, XBridgeParamField>> j(Class<? extends XBaseModel> r100, JSONObject r110) {
        if (r100 == null) goto L116;
        Method[] r101 = r100.getDeclaredMethods();
        if (r101 == null) goto L156;
        HashMap<String, Pair<Method, XBridgeParamField>> r102 = new HashMap();
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        Method r105 = r101[r104];
        XBridgeParamField r106 = (XBridgeParamField) r105.getAnnotation(XBridgeParamField.class);
        if (r106 == null) goto L10;
        r102.put(r106.keyPath(), new Pair(r105, r106));
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator<Map.Entry<String, Pair<Method, XBridgeParamField>>> r108 = r102.entrySet().iterator();
    L12:
        boolean r109 = true;
        if (r108.hasNext() == false) goto L22;
        Map.Entry<String, Pair<Method, XBridgeParamField>> r111 = r108.next();
        if (r110.has(r111.getKey()) == false) goto L17;
    L19:
        r109 = false;
    L20:
        if (r109 == false) goto L12;
        r107.put(r111.getKey(), r111.getValue());
        goto L12
    L17:
        if (r111.getValue().getSecond().defaultValue().type() == DefaultType.NONE) goto L19;
    L22:
        Iterator r112 = r107.entrySet().iterator();
    L24:
        if (r112.hasNext() == false) goto L26;
        Map.Entry r113 = (Map.Entry) r112.next();
        r110.put((String) r113.getKey(), i((Method) ((Pair) r113.getValue()).getFirst(), (XBridgeParamField) ((Pair) r113.getValue()).getSecond()));
        goto L24
    L26:
        Iterator<Map.Entry<String, Pair<Method, XBridgeParamField>>> r114 = r102.entrySet().iterator();
    L28:
        if (r114.hasNext() == false) goto L115;
        final Map.Entry<String, Pair<Method, XBridgeParamField>> r115 = r114.next();
        XBridgeParamField r116 = r115.getValue().getSecond();
        Method r117 = r115.getValue().getFirst();
        final Object r118 = r110.opt(r115.getKey());
        if (r116.required() == false) goto L37;
        if (r118 == null) goto L36;
        if (Intrinsics.areEqual(r118, JSONObject.NULL) == false) goto L37;
    L36:
        throw new IllegalInputParamException(r115.getKey() + " param is missing from input");
    L37:
        Class<?> r119 = r117.getReturnType();
        if (Intrinsics.areEqual(r119, String.class) == false) goto L48;
        if (r118 != null) goto L41;
    L90:
        if (r118 == null) goto L28;
        if (r116.isEnum() == false) goto L28;
        Class<?> r120 = r117.getReturnType();
        if (Intrinsics.areEqual(r120, String.class) == true) goto L95;
        if (Intrinsics.areEqual(r120, Number.class) == true) goto L102;
        if (Intrinsics.areEqual(r120, Map.class) == false) goto L28;
        XBridgeStringEnum r121 = (XBridgeStringEnum) r117.getAnnotation(XBridgeStringEnum.class);
        if (r121 != null) goto L111;
        XBridgeIntEnum r122 = (XBridgeIntEnum) r117.getAnnotation(XBridgeIntEnum.class);
        if (r122 == null) goto L28;
        final int[] r123 = r122.option();
        h((JSONObject) r118, new WebPlatformDataProcessor$checkValue$1$2(r123, this, r115, r118));
        goto L28
    L111:
        final String[] r124 = r121.option();
        h((JSONObject) r118, new WebPlatformDataProcessor$checkValue$1$1(r124, r115, r118));
        goto L28
    L102:
        int[] r125 = ((XBridgeIntEnum) r117.getAnnotation(XBridgeIntEnum.class)).option();
        if (ArraysKt.contains(r125, f(r118)) == true) goto L28;
        throw new IllegalInputParamException(r115.getKey() + " has wrong value.should be one of " + ArraysKt.asList(r125) + " but got " + r118);
    L95:
        String[] r126 = ((XBridgeStringEnum) r117.getAnnotation(XBridgeStringEnum.class)).option();
        if (ArraysKt.contains(r126, r118) == true) goto L28;
        throw new IllegalInputParamException(r115.getKey() + " has wrong type.should be one of " + ArraysKt.asList(r126) + " but got " + r118);
    L41:
        if ((r118 instanceof String) == true) goto L90;
        if (Intrinsics.areEqual(r118, JSONObject.NULL) == true) goto L90;
        throw new IllegalInputParamException(r115.getKey() + " param has wrong declared type. except string,but " + r118.getClass());
    L48:
        if (Intrinsics.areEqual(r119, Number.class) == false) goto L58;
        if (r118 == null) goto L90;
        if ((r118 instanceof Number) == true) goto L90;
        if (Intrinsics.areEqual(r118, JSONObject.NULL) == true) goto L90;
        throw new IllegalInputParamException(r115.getKey() + " param has wrong declared type. except number,but " + r118.getClass());
    L58:
        if (Intrinsics.areEqual(r119, Boolean.class) == false) goto L60;
        boolean r127 = true;
    L61:
        if (r127 == false) goto L71;
        if (r118 == null) goto L90;
        if ((r118 instanceof Boolean) == true) goto L90;
        if (Intrinsics.areEqual(r118, JSONObject.NULL) == true) goto L90;
        throw new IllegalInputParamException(r115.getKey() + " param has wrong declared type. except boolean,but " + r118.getClass());
    L71:
        if (Intrinsics.areEqual(r119, List.class) == false) goto L81;
        if (r118 == null) goto L90;
        if (Intrinsics.areEqual(r118, JSONObject.NULL) == true) goto L90;
        if ((r118 instanceof JSONArray) == true) goto L90;
        throw new IllegalInputParamException(r115.getKey() + " param has wrong declared type. except List ,but " + r118.getClass());
    L81:
        if (Intrinsics.areEqual(r119, Map.class) == false) goto L90;
        if (r118 == null) goto L90;
        if (Intrinsics.areEqual(r118, JSONObject.NULL) == true) goto L90;
        if ((r118 instanceof JSONObject) == true) goto L90;
        throw new IllegalInputParamException(r115.getKey() + " param has wrong declared type. except Map ,but " + r118.getClass());
    L60:
        r127 = Intrinsics.areEqual(r119, Boolean.TYPE);
        goto L61
    L115:
        return r102;
    L156:
        return null;
    L116:
        return null;
    }

    public final Object k(Class<? extends XBaseModel> r100, JSONObject r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (j(r100, r101) != null) goto L9;
        return null;
    L9:
        return Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new b(this, r100, r101));
    }

    public final Map<String, Object> l(JSONObject r100, Class<? extends IDLXBridgeMethod> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        final f r102 = o.f513548a.get(r101);
        if (r102 == null) goto L9;
        int r103 = WebProcessorForMap.f270023a;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "clazz");
        final me7.g r104 = WebProcessorForMap.e(r102.f513526c, r100);
        if (r104 != null) goto L8;
        return null;
    L8:
        return WebProcessorForMap.c(r100, new WebProcessorForMap$getJavaOnlyMapParams$1(r104, r102));
    L9:
        Class<? extends XBaseModel> r105 = l.a(r101);
        if (r105 != null) goto L14;
        r105 = e.c(r101);
        if (r105 != null) goto L14;
        return null;
    L14:
        final HashMap<String, Pair<Method, XBridgeParamField>> r106 = j(r105, r100);
        if (r106 != null) goto L18;
        return null;
    L18:
        return h(r100, new WebPlatformDataProcessor$getJsonObjectParams$1(r106, this));
    }

    public static final Object e(final WebPlatformDataProcessor r100, Object r101, final XBridgeParamField r102) {
        r100.getClass();
        boolean r103 = r101 instanceof JSONObject;
        boolean r104 = false;
        Class<? extends XBaseModel> r105 = null;
        if (r103 == false) goto L10;
        if (r102 == null) goto L6;
        KClass r106 = Reflection.getOrCreateKotlinClass(r102.nestedClassType());
    L8:
        if (Intrinsics.areEqual(r106, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L15;
        if (r102 == null) goto L14;
        r105 = r102.nestedClassType();
    L14:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type org.json.JSONObject");
        return r100.k(r105, (JSONObject) r101);
    L15:
        boolean r108 = r101 instanceof JSONArray;
        if (r108 == false) goto L23;
        if (r102 == null) goto L19;
        KClass r109 = Reflection.getOrCreateKotlinClass(r102.nestedClassType());
    L21:
        if (Intrinsics.areEqual(r109, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L23;
        r104 = true;
        goto L23
    L19:
        r109 = null;
    L23:
        if (r104 == false) goto L25;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type org.json.JSONArray");
        return com.bytedance.sdk.xbridge.cn.utils.b.a((JSONArray) r101, new WebPlatformDataProcessor$convertValueWithAnnotation$1(r100, r102));
    L25:
        if (r108 == true) goto L35;
        if (r103 == false) goto L30;
        return ConvertUtils.INSTANCE.jsonToMap((JSONObject) r101);
    L30:
        if (Intrinsics.areEqual(r101, JSONObject.NULL) == true) goto L32;
        return r101;
    L32:
        return null;
    L35:
        return ConvertUtils.INSTANCE.jsonToList((JSONArray) r101);
    L6:
        r106 = null;
    L10:
        r107 = false;
        goto L11
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final JSONObject a(Map r100, Class r101, le7.a<JSONObject> r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Object r103 = r100.get("__jsb2__data__");
        if (r103 != null) goto L10;
        if (r102 == null) goto L7;
        int r104 = r102.H;
    L9:
        return ConvertUtils.INSTANCE.mapToJSON(r100, r104);
    L7:
        r104 = 0;
        goto L9
    L10:
        return (JSONObject) r103;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final Map c(JSONObject r100, Class r101, String r102) {
        JSONObject r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "nameSpace");
        if (Intrinsics.areEqual(r102, "webcast") == false) goto L16;
        Iterator<String> r104 = r103.keys();
        JSONObject r105 = new JSONObject();
    L6:
        if (r104.hasNext() == false) goto L26;
        String r106 = r104.next();
        if (r103.opt(r106) == null) goto L6;
        if (Intrinsics.areEqual(r103.opt(r106).toString(), "null") == true) goto L6;
        Object r107 = r103.opt(r106);
        if (r107 == null) goto L6;
        r105.put(r106, r107);
        goto L6
    L26:
        return l(r105, r101);
    L16:
        return l(r103, r101);
    }
}
