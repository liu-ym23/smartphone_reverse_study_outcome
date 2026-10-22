package com.ss.android.ugc.aweme.framework.services.dyext;

import com.ss.android.ugc.aweme.framework.services.dyext.api.IPluginInitListener;
import com.ss.android.ugc.aweme.framework.services.dyext.api.IPluginInitializer;
import com.ss.android.ugc.aweme.framework.services.dyext.utils.SpiExtLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0001\u001a%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\b\u0018\u001a\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0005\u001a\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\",\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u0003X\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u001e"}, d2 = {"LABEL", "", "pluginInitListenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/ss/android/ugc/aweme/framework/services/dyext/api/IPluginInitListener;", "getPluginInitListenerMap$ServiceManagerExt__PluginInitManagerKt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setPluginInitListenerMap$ServiceManagerExt__PluginInitManagerKt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "pluginInitializerMap", "Lcom/ss/android/ugc/aweme/framework/services/dyext/PluginInitializerList;", "getPluginInitializerMap$ServiceManagerExt__PluginInitManagerKt", "setPluginInitializerMap$ServiceManagerExt__PluginInitManagerKt", "getPluginInitListeners", "", "packageName", "getPluginInitializers", "internalRegisterPluginInitializer", "", "pluginInitializer", "Lcom/ss/android/ugc/aweme/framework/services/dyext/api/IPluginInitializer;", "isHeadInit", "", "internalRegisterPluginInitializer$ServiceManagerExt__PluginInitManagerKt", "registerHeadPluginInitializer", "registerPluginInitListener", "pluginInitListener", "registerPluginInitializer", "unregisterPluginInitializer", "dy-ext-spi_release"}, k = 5, mv = {1, 1, 15}, xs = "com/ss/android/ugc/aweme/framework/services/dyext/ServiceManagerExt")
final /* synthetic */ class ServiceManagerExt__PluginInitManagerKt {
    private static final String LABEL = "PluginInitManager";
    private static ConcurrentHashMap<String, List<IPluginInitListener>> pluginInitListenerMap;
    private static ConcurrentHashMap<String, PluginInitializerList> pluginInitializerMap;

    static {
        pluginInitializerMap = new ConcurrentHashMap();
        pluginInitListenerMap = new ConcurrentHashMap();
    }

    private static final ConcurrentHashMap<String, List<IPluginInitListener>> getPluginInitListenerMap$ServiceManagerExt__PluginInitManagerKt() {
        return pluginInitListenerMap;
    }

    private static final ConcurrentHashMap<String, PluginInitializerList> getPluginInitializerMap$ServiceManagerExt__PluginInitManagerKt() {
        return pluginInitializerMap;
    }

    public static final List<IPluginInitListener> getPluginInitListeners(String r100) {
        return pluginInitListenerMap.get(r100);
    }

    public static final PluginInitializerList getPluginInitializers(String r100) {
        return pluginInitializerMap.get(r100);
    }

    private static final void setPluginInitListenerMap$ServiceManagerExt__PluginInitManagerKt(ConcurrentHashMap<String, List<IPluginInitListener>> r100) {
        pluginInitListenerMap = r100;
    }

    private static final void setPluginInitializerMap$ServiceManagerExt__PluginInitManagerKt(ConcurrentHashMap<String, PluginInitializerList> r100) {
        pluginInitializerMap = r100;
    }

    public static final void unregisterPluginInitializer(String r100) {
        SpiExtLogger.INSTANCE.d(LABEL, "unregisterPluginInitializer: " + r100, true);
        pluginInitializerMap.remove(r100);
    }

    public static final void registerHeadPluginInitializer(String r100, IPluginInitializer r101) {
        internalRegisterPluginInitializer$ServiceManagerExt__PluginInitManagerKt(r100, r101, true);
    }

    public static final void registerPluginInitListener(String r100, IPluginInitListener r101) {
        SpiExtLogger.d$default(SpiExtLogger.INSTANCE, LABEL, "registerPluginInitListener: " + r101, false, 4, null);
        List<IPluginInitListener> r102 = pluginInitListenerMap.get(r100);
        if (r102 != null) goto L6;
        r102 = new CopyOnWriteArrayList();
    L6:
        r102.add(r101);
        pluginInitListenerMap.put(r100, r102);
    }

    public static final void registerPluginInitializer(String r100, IPluginInitializer r101) {
        internalRegisterPluginInitializer$ServiceManagerExt__PluginInitManagerKt(r100, r101, false);
    }

    private static final void internalRegisterPluginInitializer$ServiceManagerExt__PluginInitManagerKt(String r100, IPluginInitializer r101, boolean r102) {
        SpiExtLogger.INSTANCE.d(LABEL, "registerPluginInitializer: plugin: '" + r100 + "', initializer: " + r101 + ",  isHeadInit: " + r102, true);
        PluginInitializerList r103 = pluginInitializerMap.get(r100);
        if (r103 != null) goto L6;
        r103 = new PluginInitializerList();
    L6:
        if (r102 == false) goto L8;
        r103.add(0, r101);
    L9:
        pluginInitializerMap.put(r100, r103);
        return;
    L8:
        r103.add(r101);
        goto L9
    }
}
