package me7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeDefaultValue;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes22.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, f> f513548a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Class<? extends IDLXBridgeMethod>> f513549b = null;

    static {
        new LinkedHashMap();
        f513548a = new ConcurrentHashMap();
        f513549b = new ConcurrentHashMap();
    }

    public static Class a(Class r100, Class r101) {
        Class r102 = r100.getSuperclass();     // Catch: Throwable -> L30
        if (r102 == null) goto L20;
        Class<?>[] r103 = r102.getDeclaredClasses();     // Catch: Throwable -> L30
        if (r103 == null) goto L20;
        int r104 = r103.length;     // Catch: Throwable -> L30
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L16;
        Class<?> r106 = r103[r105];     // Catch: Throwable -> L30
        if (r106.getAnnotation(r101) == null) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == true) goto L17;
        r105 = r105 + 1;     // Catch: Throwable -> L30
    L17:
        if (r106 == null) goto L20;
        return r106;
    L12:
        r107 = false;
        goto L13
    L16:
        r106 = null;
    L20:
        Class<?>[] r108 = r100.getDeclaredClasses();     // Catch: Throwable -> L30
        int r109 = r108.length;     // Catch: Throwable -> L30
        int r110 = 0;
    L21:
        if (r110 >= r109) goto L39;
        Class<?> r111 = r108[r110];     // Catch: Throwable -> L30
        if (r111.getAnnotation(r101) == null) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == true) goto L37;
        r110 = r110 + 1;
        goto L21
    L37:
        return r111;
    L25:
        r112 = false;
        goto L26
    L39:
        return null;
    L38:
        return null;
    }

    public static g b(Class r210, HashMap r310) {
        Method[] r100 = r210.getDeclaredMethods();
        g r101 = new g(null);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L31;
        Method r104 = r100[r103];
        XBridgeParamField r105 = (XBridgeParamField) r104.getAnnotation(XBridgeParamField.class);
        if (r105 == null) goto L30;
        XBridgeDefaultValue r106 = r105.defaultValue();
        XBridgeStringEnum r107 = (XBridgeStringEnum) r104.getAnnotation(XBridgeStringEnum.class);
        XBridgeIntEnum r108 = (XBridgeIntEnum) r104.getAnnotation(XBridgeIntEnum.class);
        KClass r110 = Reflection.getOrCreateKotlinClass(r105.nestedClassType());
        String r111 = r105.keyPath();
        if (Intrinsics.areEqual(r110, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == false) goto L9;
    L13:
        boolean r112 = r105.required();
        KClass r113 = Reflection.getOrCreateKotlinClass(r105.primitiveClassType());
        boolean r114 = r105.isEnum();
        boolean r115 = r105.isGetter();
        h r211 = new h(r106.type(), r106.doubleValue(), r106.stringValue(), r106.intValue(), r106.boolValue(), r106.longValue());
        Class<?> r116 = r104.getReturnType();
        if (r107 == null) goto L19;
        String[] r109 = r107.option();
        if (r109 == null) goto L19;
        List r117 = ArraysKt.toList(r109);
        if (r117 == null) goto L19;
    L20:
        List r212 = r117;
        if (r108 == null) goto L26;
        int[] r118 = r108.option();
        if (r118 == null) goto L26;
        List r119 = ArraysKt.toList(r118);
        if (r119 == null) goto L26;
    L27:
        i r120 = new i(r112, r111, r110, r113, r114, r115, r211, r116, r212, r119);
        r101.f513529a.put(r104, r120);
        if (r105.isGetter() == false) goto L30;
        r101.f513530b.put(r111, r120);
    L26:
        r119 = CollectionsKt.emptyList();
    L19:
        r117 = CollectionsKt.emptyList();
        goto L20
    L9:
        if (r310.containsKey(JvmClassMappingKt.getJavaClass(r110)) == true) goto L13;
        if (r101.f513530b.containsKey(r111) == true) goto L13;
        r310.put(JvmClassMappingKt.getJavaClass(r110), b(JvmClassMappingKt.getJavaClass(r110), r310));
    L30:
        r103 = r103 + 1;
        goto L3
    L31:
        return r101;
    }
}
