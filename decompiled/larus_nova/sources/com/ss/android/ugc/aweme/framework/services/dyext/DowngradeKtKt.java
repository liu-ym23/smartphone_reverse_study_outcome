package com.ss.android.ugc.aweme.framework.services.dyext;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public class DowngradeKtKt {
    public DowngradeKtKt() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "getOrNull()", imports = {}))
    public static <T> T getOrNull(KClass<T> r100) {
        return (T) ServiceManagerExt.internalGetOrNull(JvmClassMappingKt.getJavaClass(r100));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "getOrNull()", imports = {}))
    public static <T> T getOrNull(Class<T> r100) {
        return (T) ServiceManagerExt.internalGetOrNull(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "getOrDefault(default)", imports = {}))
    public static <T> T getOrDefault(KClass<T> r100, T r101) {
        return (T) ServiceManagerExt.internalGetOrDefault(JvmClassMappingKt.getJavaClass(r100), r101);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "getOrElse(defaultGetter)", imports = {}))
    public static <T> T getOrElse(KClass<T> r100, Function0<T> r101) {
        return (T) ServiceManagerExt.internalGetOrElse(JvmClassMappingKt.getJavaClass(r100), r101);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "getOrNull(clz)", imports = {}))
    public static <T> T getOrNull(ServiceManager r100, Class<T> r101) {
        return (T) ServiceManagerExt.internalGetOrNull(r101);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "getOrDefault(default)", imports = {}))
    public static <T> T getOrDefault(Class<T> r100, T r101) {
        return (T) ServiceManagerExt.internalGetOrDefault(r100, r101);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "getOrElse(defaultGetter)", imports = {}))
    public static <T> T getOrElse(Class<T> r100, Function0<T> r101) {
        return (T) ServiceManagerExt.internalGetOrElse(r100, r101);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "getOrDefault(clz, default)", imports = {}))
    public static <T> T getOrDefault(ServiceManager r100, Class<T> r101, T r102) {
        return (T) ServiceManagerExt.internalGetOrDefault(r101, r102);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "getOrDefault(clz, defaultGetter)", imports = {}))
    public static <T> T getOrDefault(ServiceManager r100, Class<T> r101, Function0<T> r102) {
        return (T) ServiceManagerExt.internalGetOrElse(r101, r102);
    }
}
