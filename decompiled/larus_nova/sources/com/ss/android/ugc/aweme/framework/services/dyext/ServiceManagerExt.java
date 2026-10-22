package com.ss.android.ugc.aweme.framework.services.dyext;

import android.os.Handler;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.dyext.api.IPluginInitListener;
import com.ss.android.ugc.aweme.framework.services.dyext.api.IPluginInitializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"com/ss/android/ugc/aweme/framework/services/dyext/ServiceManagerExt__DowngradeCallerKt", "com/ss/android/ugc/aweme/framework/services/dyext/ServiceManagerExt__LoadOrDowngradeCallerKt", "com/ss/android/ugc/aweme/framework/services/dyext/ServiceManagerExt__LoadPluginCallerKt", "com/ss/android/ugc/aweme/framework/services/dyext/ServiceManagerExt__PluginInitManagerKt"}, k = 4, mv = {1, 1, 15})
public final class ServiceManagerExt {
    public static final LoadPluginFuture loadPlugin(String r100) {
        return loadPlugin$default(r100, null, 2, null);
    }

    public static final <T> T getOrDowngrade(Class<T> r100) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrDowngrade(r100);
    }

    public static final <T> T getOrNull(Class<T> r100) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrNull(r100);
    }

    public static final List<IPluginInitListener> getPluginInitListeners(String r100) {
        return ServiceManagerExt__PluginInitManagerKt.getPluginInitListeners(r100);
    }

    public static final PluginInitializerList getPluginInitializers(String r100) {
        return ServiceManagerExt__PluginInitManagerKt.getPluginInitializers(r100);
    }

    public static final <T> T internalGetOrDowngrade(Class<T> r100) {
        return (T) ServiceManagerExt__DowngradeCallerKt.internalGetOrDowngrade(r100);
    }

    public static final <T> T internalGetOrNull(Class<T> r100) {
        return (T) ServiceManagerExt__DowngradeCallerKt.internalGetOrNull(r100);
    }

    public static final <T> T internalLoadOrDowngrade(Class<T> r100) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.internalLoadOrDowngrade(r100);
    }

    public static final <T> T internalLoadOrNull(Class<T> r100) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.internalLoadOrNull(r100);
    }

    public static final <T> T loadOrDowngrade(Class<T> r100) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrDowngrade(r100);
    }

    public static final <T> T loadOrNull(Class<T> r100) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrNull(r100);
    }

    public static final boolean loadPluginIfInstalled(String r100) {
        return ServiceManagerExt__LoadPluginCallerKt.loadPluginIfInstalled(r100);
    }

    public static final void unregisterPluginInitializer(String r100) {
        ServiceManagerExt__PluginInitManagerKt.unregisterPluginInitializer(r100);
    }

    public static final <T> T getOrDowngrade(KClass<T> r100) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrDowngrade(r100);
    }

    public static final <T> T getOrNull(KClass<T> r100) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrNull(r100);
    }

    public static final <T> T loadOrDowngrade(KClass<T> r100) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrDowngrade(r100);
    }

    public static final <T> T loadOrNull(KClass<T> r100) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrNull(r100);
    }

    public static final <T> T getOrDefault(Class<T> r100, T r101) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrDefault(r100, r101);
    }

    public static final <T> T getOrDowngrade(ServiceManager r100, Class<T> r101) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrDowngrade(r100, r101);
    }

    public static final <T> T getOrElse(Class<T> r100, Function0<? extends T> r101) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrElse(r100, r101);
    }

    public static final <T> T getOrNull(ServiceManager r100, Class<T> r101) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrNull(r100, r101);
    }

    public static final <T> T internalGetOrDefault(Class<T> r100, T r101) {
        return (T) ServiceManagerExt__DowngradeCallerKt.internalGetOrDefault(r100, r101);
    }

    public static final <T> T internalGetOrElse(Class<T> r100, Function0<? extends T> r101) {
        return (T) ServiceManagerExt__DowngradeCallerKt.internalGetOrElse(r100, r101);
    }

    public static final <T> T internalLoadOrDefault(Class<T> r100, T r101) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.internalLoadOrDefault(r100, r101);
    }

    public static final <T> T internalLoadOrElse(Class<T> r100, Function0<? extends T> r101) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.internalLoadOrElse(r100, r101);
    }

    public static final <T> T loadOrDefault(Class<T> r100, T r101) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrDefault(r100, r101);
    }

    public static final <T> T loadOrDowngrade(ServiceManager r100, Class<T> r101) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrDowngrade(r100, r101);
    }

    public static final <T> T loadOrElse(Class<T> r100, Function0<? extends T> r101) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrElse(r100, r101);
    }

    public static final <T> T loadOrNull(ServiceManager r100, Class<T> r101) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrNull(r100, r101);
    }

    public static final LoadPluginFuture loadPlugin(String r100, Handler r101) {
        return ServiceManagerExt__LoadPluginCallerKt.loadPlugin(r100, r101);
    }

    public static final void registerHeadPluginInitializer(String r100, IPluginInitializer r101) {
        ServiceManagerExt__PluginInitManagerKt.registerHeadPluginInitializer(r100, r101);
    }

    public static final void registerPluginInitListener(String r100, IPluginInitListener r101) {
        ServiceManagerExt__PluginInitManagerKt.registerPluginInitListener(r100, r101);
    }

    public static final void registerPluginInitializer(String r100, IPluginInitializer r101) {
        ServiceManagerExt__PluginInitManagerKt.registerPluginInitializer(r100, r101);
    }

    public static final <T> T getOrDefault(KClass<T> r100, T r101) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrDefault(r100, r101);
    }

    public static final <T> T getOrElse(KClass<T> r100, Function0<? extends T> r101) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrElse(r100, r101);
    }

    public static final <T> T loadOrDefault(KClass<T> r100, T r101) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrDefault(r100, r101);
    }

    public static final <T> T loadOrElse(KClass<T> r100, Function0<? extends T> r101) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrElse(r100, r101);
    }

    public static final <T> T getOrDefault(ServiceManager r100, Class<T> r101, T r102) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrDefault(r100, r101, r102);
    }

    public static final <T> T getOrElse(ServiceManager r100, Class<T> r101, Function0<? extends T> r102) {
        return (T) ServiceManagerExt__DowngradeCallerKt.getOrElse(r100, r101, r102);
    }

    public static final <T> T loadOrDefault(ServiceManager r100, Class<T> r101, T r102) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrDefault(r100, r101, r102);
    }

    public static final <T> T loadOrElse(ServiceManager r100, Class<T> r101, Function0<? extends T> r102) {
        return (T) ServiceManagerExt__LoadOrDowngradeCallerKt.loadOrElse(r100, r101, r102);
    }

    public static /* synthetic */ LoadPluginFuture loadPlugin$default(String r100, Handler r101, int r102, Object r103) {
        return ServiceManagerExt__LoadPluginCallerKt.loadPlugin$default(r100, r101, r102, r103);
    }
}
