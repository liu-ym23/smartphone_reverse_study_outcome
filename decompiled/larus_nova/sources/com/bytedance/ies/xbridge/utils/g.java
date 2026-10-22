package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.annotation.XBridgeIntEnum;
import com.bytedance.ies.xbridge.annotation.XBridgeParamField;
import com.bytedance.ies.xbridge.annotation.XBridgeStringEnum;
import com.bytedance.ies.xbridge.exception.IllegalInputParamException;
import com.bytedance.ies.xbridge.exception.IllegalOperationException;
import com.bytedance.ies.xbridge.exception.IllegalOutputParamException;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f249558a = 0;

    public static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Object> f249559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class<Object> f249560b;

        public a(Class<Object> r100) {
            this.f249560b = r100;
            this.f249559a = new LinkedHashMap();
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r110, Method r210, Object[] r211) {
            Intrinsics.checkNotNullParameter(r210, com.alipay.sdk.m.p.e.f25671s);
            Map<Class<? extends IDLXBridgeMethod>, String> r100 = com.bytedance.ies.xbridge.i.f249500a;
            Class<Object> r101 = this.f249560b;
            Intrinsics.checkNotNullParameter(r101, "resultModelClazz");
            Class<?> r102 = com.bytedance.ies.xbridge.i.f249502c.get(r101);
            if (r102 != null) goto L5;
            com.bytedance.ies.xbridge.c r103 = null;
        L7:
            if (r103 != null) goto L9;
            System.out.println("idl Model->Map. no cache");
            if (Intrinsics.areEqual(r210.getName(), "convert") == false) goto L281;
            int r104 = g.f249558a;
            Class<Object> r105 = this.f249560b;
            Map<String, Object> r106 = this.f249559a;
            Method[] r107 = r105.getDeclaredMethods();
            ArrayList r108 = new ArrayList();
            int r109 = r107.length;
            int r111 = 0;
        L147:
            if (r111 >= r109) goto L158;
            Method r112 = r107[r111];
            XBridgeParamField r113 = (XBridgeParamField) r112.getAnnotation(XBridgeParamField.class);
            if (r113 == null) goto L154;
            if (r113.isGetter() != true) goto L154;
            boolean r114 = true;
        L155:
            if (r114 == false) goto L157;
            r108.add(r112);
        L157:
            r111 = r111 + 1;
        L154:
            r114 = false;
            goto L155
        L158:
            Iterator r115 = r108.iterator();
        L160:
            if (r115.hasNext() == false) goto L280;
            Method r116 = (Method) r115.next();
            XBridgeParamField r117 = (XBridgeParamField) r116.getAnnotation(XBridgeParamField.class);
            String r118 = r117.keyPath();
            boolean r119 = r117.required();
            Class<?> r120 = r116.getReturnType();
            boolean r121 = r117.isEnum();
            if (r121 == true) goto L164;
        L166:
            if (r121 == true) goto L168;
        L170:
            if (r121 == true) goto L172;
        L179:
            if (r121 == true) goto L181;
        L188:
            Annotation r122 = null;
        L189:
            LinkedHashMap r123 = (LinkedHashMap) r106;
            Object r124 = r123.get(r118);
            if (r124 != null) goto L195;
            if (r119 == false) goto L195;
            throw new IllegalOutputParamException(r118 + " is missing from output");
        L195:
            boolean r125 = Intrinsics.areEqual(r120, Number.class);
            int r126 = g.f249558a;
            if (r125 == false) goto L211;
            if (r124 == null) goto L278;
            g.a(r121, r122, r124, r118);
            if ((r124 instanceof Integer) == true) goto L278;
            if ((r124 instanceof Double) == true) goto L278;
            if ((r124 instanceof Long) == true) goto L278;
            if ((r124 instanceof Float) == true) goto L278;
            throw new IllegalOutputParamException(r118 + " is of invalid return type");
        L278:
            r123.put(r117.keyPath(), g.d(r124, XBaseModel.class, r120));
            goto L160
        L211:
            if (Intrinsics.areEqual(r120, String.class) == false) goto L224;
            if (r124 != null) goto L217;
            if (r119 == false) goto L217;
            throw new IllegalOutputParamException(r118 + " is missing from output");
        L217:
            if (r124 == null) goto L278;
            g.a(r121, r122, r124, r118);
            if ((r124 instanceof String) == true) goto L278;
            throw new IllegalOutputParamException(r118 + " is of invalid return type");
        L224:
            if (Intrinsics.areEqual(r120, Boolean.class) == false) goto L226;
            boolean r127 = true;
        L227:
            if (r127 == false) goto L240;
            if (r124 != null) goto L233;
            if (r119 == false) goto L233;
            throw new IllegalOutputParamException(r118 + " is missing from output");
        L233:
            if (r124 == null) goto L278;
            if ((r124 instanceof Boolean) == true) goto L278;
            throw new IllegalOutputParamException(r118 + " is of invalid return type");
        L240:
            if (Intrinsics.areEqual(r120, List.class) == false) goto L253;
            if (r124 != null) goto L246;
            if (r119 == false) goto L246;
            throw new IllegalOutputParamException(r118 + " is missing from output");
        L246:
            if (r124 == null) goto L278;
            if ((r124 instanceof List) == false) goto L251;
            g.a(r121, r122, r124, r118);
            goto L278
        L251:
            throw new IllegalOutputParamException(r118 + " is of invalid return type");
        L253:
            if (Intrinsics.areEqual(r120, Map.class) == false) goto L266;
            if (r124 != null) goto L259;
            if (r119 == false) goto L259;
            throw new IllegalOutputParamException(r118 + " is missing from output");
        L259:
            if (r124 == null) goto L278;
            if ((r124 instanceof Map) == false) goto L264;
            g.a(r121, r122, ((Map) r124).values(), r118);
            goto L278
        L264:
            throw new IllegalOutputParamException(r118 + " is of invalid return type");
        L266:
            if (Intrinsics.areEqual(r120, Object.class) == false) goto L272;
            if (r124 != null) goto L278;
            if (r119 == false) goto L278;
            throw new IllegalOutputParamException(r118 + " is missing from output");
        L272:
            if (r124 == null) goto L278;
            if ((r124 instanceof XBaseModel) == true) goto L278;
            throw new IllegalInputParamException("Failed to parse type " + r120.getName() + ',' + r124 + " must be sub class of XBaseModel");
        L226:
            r127 = Intrinsics.areEqual(r120, Boolean.TYPE);
            goto L227
        L181:
            if (Intrinsics.areEqual(r120, Map.class) == false) goto L188;
            KClass r128 = Reflection.getOrCreateKotlinClass(r117.primitiveClassType());
            if (Intrinsics.areEqual(r128, Reflection.getOrCreateKotlinClass(Number.class)) == false) goto L186;
            r122 = r116.getAnnotation(XBridgeIntEnum.class);
            goto L189
        L186:
            if (Intrinsics.areEqual(r128, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L188;
            r122 = r116.getAnnotation(XBridgeStringEnum.class);
            goto L189
        L172:
            if (Intrinsics.areEqual(r120, List.class) == false) goto L179;
            KClass r129 = Reflection.getOrCreateKotlinClass(r117.primitiveClassType());
            if (Intrinsics.areEqual(r129, Reflection.getOrCreateKotlinClass(Number.class)) == false) goto L177;
            r122 = r116.getAnnotation(XBridgeIntEnum.class);
            goto L189
        L177:
            if (Intrinsics.areEqual(r129, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L188;
            r122 = r116.getAnnotation(XBridgeStringEnum.class);
            goto L189
        L168:
            if (Intrinsics.areEqual(r120, String.class) == false) goto L170;
            r122 = r116.getAnnotation(XBridgeStringEnum.class);
            goto L189
        L164:
            if (Intrinsics.areEqual(r120, Number.class) == false) goto L166;
            r122 = r116.getAnnotation(XBridgeIntEnum.class);
            goto L189
        L280:
            return this.f249559a;
        L281:
            XBridgeParamField r130 = (XBridgeParamField) r210.getAnnotation(XBridgeParamField.class);
            if (r130 != null) goto L284;
        L287:
            if (r130 == null) goto L295;
            XBridgeParamField r131 = (XBridgeParamField) r210.getAnnotation(XBridgeParamField.class);
            if (r211 == null) goto L291;
            Object r132 = ArraysKt.firstOrNull(r211);
        L292:
            this.f249559a.put(r131.keyPath(), r132);
            return Unit.INSTANCE;
        L291:
            r132 = null;
            goto L292
        L295:
            throw new IllegalOperationException("Unsupported method invocation in result model");
        L284:
            if (r130.isGetter() == false) goto L287;
            XBridgeParamField r133 = (XBridgeParamField) r210.getAnnotation(XBridgeParamField.class);
            return ((LinkedHashMap) this.f249559a).get(r133.keyPath());
        L9:
            if (Intrinsics.areEqual(r210.getName(), "convert") == false) goto L132;
            int r134 = h.f249561a;
            Map<String, Object> r135 = this.f249559a;
            Intrinsics.checkNotNullParameter(r103, "pool");
            Intrinsics.checkNotNullParameter(r135, "contentMap");
            Iterator<Map.Entry<String, com.bytedance.ies.xbridge.f>> r136 = r103.f249461d.f249465b.entrySet().iterator();
        L12:
            if (r136.hasNext() == false) goto L131;
            com.bytedance.ies.xbridge.f r137 = r136.next().getValue();
            String r138 = r137.f249486b;
            boolean r139 = r137.f249485a;
            Class<?> r140 = r137.f249492h;
            boolean r141 = r137.f249489e;
            if (r141 == true) goto L16;
        L18:
            if (r141 == true) goto L20;
        L22:
            if (r141 == true) goto L24;
        L31:
            if (r141 == true) goto L33;
        L40:
            List r142 = null;
        L41:
            LinkedHashMap r143 = (LinkedHashMap) r135;
            Object r144 = r143.get(r138);
            if (r144 != null) goto L47;
            if (r139 == false) goto L47;
            throw new IllegalOutputParamException(r138 + " is missing from output");
        L47:
            boolean r145 = Intrinsics.areEqual(r140, Number.class);
            int r146 = h.f249561a;
            if (r145 == false) goto L62;
            if (r144 == null) goto L129;
            h.a(r141, r142, r144, r138);
            if ((r144 instanceof Integer) == true) goto L129;
            if ((r144 instanceof Double) == true) goto L129;
            if ((r144 instanceof Long) == true) goto L129;
            if ((r144 instanceof Float) == true) goto L129;
            throw new IllegalOutputParamException(r138 + " is of invalid return type");
        L129:
            r143.put(r137.f249486b, h.b(r144, XBaseModel.class, r140));
            goto L12
        L62:
            if (Intrinsics.areEqual(r140, String.class) == false) goto L75;
            if (r144 != null) goto L68;
            if (r139 == false) goto L68;
            throw new IllegalOutputParamException(r138 + " is missing from output");
        L68:
            if (r144 == null) goto L129;
            h.a(r141, r142, r144, r138);
            if ((r144 instanceof String) == true) goto L129;
            throw new IllegalOutputParamException(r138 + " is of invalid return type");
        L75:
            if (Intrinsics.areEqual(r140, Boolean.class) == false) goto L77;
            boolean r147 = true;
        L78:
            if (r147 == false) goto L91;
            if (r144 != null) goto L84;
            if (r139 == false) goto L84;
            throw new IllegalOutputParamException(r138 + " is missing from output");
        L84:
            if (r144 == null) goto L129;
            if ((r144 instanceof Boolean) == true) goto L129;
            throw new IllegalOutputParamException(r138 + " is of invalid return type");
        L91:
            if (Intrinsics.areEqual(r140, List.class) == false) goto L104;
            if (r144 != null) goto L97;
            if (r139 == false) goto L97;
            throw new IllegalOutputParamException(r138 + " is missing from output");
        L97:
            if (r144 == null) goto L129;
            if ((r144 instanceof List) == false) goto L102;
            h.a(r141, r142, r144, r138);
            goto L129
        L102:
            throw new IllegalOutputParamException(r138 + " is of invalid return type");
        L104:
            if (Intrinsics.areEqual(r140, Map.class) == false) goto L117;
            if (r144 != null) goto L110;
            if (r139 == false) goto L110;
            throw new IllegalOutputParamException(r138 + " is missing from output");
        L110:
            if (r144 == null) goto L129;
            if ((r144 instanceof Map) == false) goto L115;
            h.a(r141, r142, ((Map) r144).values(), r138);
            goto L129
        L115:
            throw new IllegalOutputParamException(r138 + " is of invalid return type");
        L117:
            if (Intrinsics.areEqual(r140, Object.class) == false) goto L123;
            if (r144 != null) goto L129;
            if (r139 == false) goto L129;
            throw new IllegalOutputParamException(r138 + " is missing from output");
        L123:
            if (r144 == null) goto L129;
            if ((r144 instanceof XBaseModel) == true) goto L129;
            throw new IllegalInputParamException("Failed to parse type " + r140.getName() + ',' + r144 + " must be sub class of XBaseModel");
        L77:
            r147 = Intrinsics.areEqual(r140, Boolean.TYPE);
            goto L78
        L33:
            if (Intrinsics.areEqual(r140, Map.class) == false) goto L40;
            KClass<? extends Object> r148 = r137.f249488d;
            if (Intrinsics.areEqual(r148, Reflection.getOrCreateKotlinClass(Number.class)) == false) goto L38;
            r142 = r137.f249494j;
            goto L41
        L38:
            if (Intrinsics.areEqual(r148, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L40;
            r142 = r137.f249493i;
            goto L41
        L24:
            if (Intrinsics.areEqual(r140, List.class) == false) goto L31;
            KClass<? extends Object> r149 = r137.f249488d;
            if (Intrinsics.areEqual(r149, Reflection.getOrCreateKotlinClass(Number.class)) == false) goto L29;
            r142 = r137.f249494j;
            goto L41
        L29:
            if (Intrinsics.areEqual(r149, Reflection.getOrCreateKotlinClass(String.class)) == false) goto L40;
            r142 = r137.f249493i;
            goto L41
        L20:
            if (Intrinsics.areEqual(r140, String.class) == false) goto L22;
            r142 = r137.f249493i;
            goto L41
        L16:
            if (Intrinsics.areEqual(r140, Number.class) == false) goto L18;
            r142 = r137.f249494j;
            goto L41
        L131:
            return this.f249559a;
        L132:
            int r150 = h.f249561a;
            Map<String, Object> r151 = this.f249559a;
            Intrinsics.checkNotNullParameter(r103, "pool");
            Intrinsics.checkNotNullParameter(r151, "contentMap");
            Intrinsics.checkNotNullParameter(r210, com.alipay.sdk.m.p.e.f25671s);
            com.bytedance.ies.xbridge.f r152 = r103.f249461d.f249464a.get(r210);
            if (r152 == null) goto L143;
            if (r152.f249490f == true) goto L342;
            if (r211 == null) goto L139;
            Object r153 = ArraysKt.firstOrNull(r211);
        L140:
            r151.put(r152.f249486b, r153);
            return Unit.INSTANCE;
        L139:
            r153 = null;
            goto L140
        L342:
            return ((LinkedHashMap) r151).get(r152.f249486b);
        L143:
            throw new IllegalOperationException("Unsupported method invocation in result model");
        L5:
            r103 = com.bytedance.ies.xbridge.i.f249501b.get(r102);
            goto L7
        }
    }

    static {
    }

    public static XBaseModel c(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new a(r100));
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type T of com.bytedance.ies.xbridge.utils.XBridgeResultModelArguments.createModel");
        return (XBaseModel) r101;
    }

    public static boolean b(Annotation r100, Object r101) {
        if ((r100 instanceof XBridgeStringEnum) == false) goto L8;
        if (ArraysKt.contains(((XBridgeStringEnum) r100).option(), r101) == false) goto L13;
    L12:
        return false;
    L13:
        return true;
    L8:
        if ((r100 instanceof XBridgeIntEnum) == false) goto L13;
        int[] r102 = ((XBridgeIntEnum) r100).option();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        if (ArraysKt.contains(r102, ((Integer) r101).intValue()) == true) goto L12;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
    public static Object d(Object r100, Class r101, Class r102) {
        if (Intrinsics.areEqual(r102, Object.class) == false) goto L8;
        if ((r100 instanceof b) == false) goto L8;
        return ((b) r100).getValue();
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
        r104.add(d(r105.next(), r101, r102));
    L47:
        return r104;
    L25:
        if ((r100 instanceof Map) == false) goto L31;
        Map r106 = (Map) r100;
        r104 = new LinkedHashMap(MapsKt.mapCapacity(r106.size()));
        Iterator r107 = r106.entrySet().iterator();
    L28:
        if (r107.hasNext() == false) goto L47;
        Map.Entry r108 = (Map.Entry) r107.next();
        r104.put(r108.getKey(), d(r108.getValue(), r101, r102));
        goto L28
    L31:
        if ((r100 instanceof JSONObject) == false) goto L33;
        return r100;
    L33:
        if ((r100 instanceof JSONArray) == true) goto L51;
        XBaseModel r109 = (XBaseModel) r101.cast(r100);
        if (r109 != null) goto L49;
        return null;
    L49:
        return r109.convert();
    L51:
        return r100;
    L46:
        return r100;
    }

    public static void a(boolean r100, Annotation r101, Object r102, String r103) {
        if (r100 == true) goto L4;
        return;
    L4:
        if ((r102 instanceof Collection) == false) goto L17;
        Iterable r104 = (Iterable) r102;
        if ((r104 instanceof Collection) == true) goto L8;
    L10:
        Iterator r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        if (b(r101, r105.next()) == false) goto L12;
        boolean r106 = true;
    L18:
        if (r106 == true) goto L21;
        return;
    L21:
        throw new IllegalOutputParamException(r103 + " is not valid");
    L16:
        r106 = false;
        goto L18
    L8:
        if (((Collection) r104).isEmpty() == false) goto L10;
    L17:
        r106 = b(r101, r102);
        goto L18
    }
}
