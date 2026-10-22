package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import androidx.collection.MutableKeys;
import com.ss.android.ugc.aweme.framework.services.plugin.PluginInstaller;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ServiceManager {
    final ConcurrentHashMap<Class<?>, Set<ServiceProvider<?>>> classServiceProviderConcurrentHashMap;
    public volatile boolean enableDynamicProxyDefault;
    final Map<Class<?>, Map<String, ServiceProvider<?>>> groupServiceProviderConcurrentHashMap;
    final Set<String> legacyServiceSet;
    final Set<Class<?>> resolvedClasses;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.framework.services.ServiceManager$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Holder {
        private static final ServiceManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new ServiceManager(null);
        }

        public static /* synthetic */ ServiceManager access$000() {
            return INSTANCE;
        }
    }

    private ServiceManager() {
        this.classServiceProviderConcurrentHashMap = new ConcurrentHashMap();
        this.groupServiceProviderConcurrentHashMap = Collections.synchronizedMap(new HashMap());
        this.legacyServiceSet = Collections.synchronizedSet(new HashSet());
        this.enableDynamicProxyDefault = true;
        this.resolvedClasses = Collections.synchronizedSet(new HashSet());
    }

    public static ServiceManager get() {
        return Holder.access$000();
    }

    public Map<Class<?>, Map<String, ServiceProvider<?>>> getGroupServiceProviderMap() {
        return this.groupServiceProviderConcurrentHashMap;
    }

    public ConcurrentHashMap getServiceProviderMap() {
        return this.classServiceProviderConcurrentHashMap;
    }

    public /* synthetic */ ServiceManager(AnonymousClass1 r100) {
        this();
    }

    private <T> T getLegacyService(Class<T> r100) {
        if (this.legacyServiceSet.contains(r100.getName()) == true) goto L5;
        return null;
    L5:
        Iterator r101 = ConfigLoader.iterator(r100);
        if (r101.hasNext() == true) goto L8;
        return null;
    L8:
        return (T) r101.next();
    }

    private void markResolved(Class r100) {
        this.resolvedClasses.add(r100);
    }

    public void addLegacyService(String r100) {
        this.legacyServiceSet.add(r100);
    }

    public boolean downgradeComponent(String r100) {
        return downgradeComponent(r100, false);
    }

    public <T> Set<T> getLegacyServices(Class<T> r100) {
        MutableKeys r101 = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        if (this.legacyServiceSet.contains(r100.getName()) == true) goto L5;
        return r101;
    L5:
        Iterator r102 = ConfigLoader.iterator(r100);
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(r102.next());
        goto L7
    L9:
        return r101;
    }

    public <T> T getService(Class<T> r100) {
        return (T) getService(r100, false);
    }

    public <T> T getServiceForReal(Class<T> r100) {
        return (T) getService(r100, false, this.enableDynamicProxyDefault, true);
    }

    public <T> Set<T> getServices(Class<T> r100) {
        return getServices(r100, false);
    }

    public boolean onPluginInstall(String r100) {
        return PluginInstaller.INSTANCE.onPluginInstall(r100);
    }

    public void setDynamicProxyEnableDefault(boolean r100) {
        this.enableDynamicProxyDefault = r100;
    }

    public void addLegacyService(Set<String> r100) {
        this.legacyServiceSet.addAll(r100);
    }

    public <T> Binding bind(Class<T> r100, ServiceProvider<T> r101) {
        return new Binding(this, r100, r101);
    }

    public <T> void bindDowngradeImpl(Class<T> r100, ServiceProvider<T> r101) {
        bindDowngradeImpl(r100, r101, true);
    }

    public boolean downgradeComponent(String r100, boolean r101) {
        if (r101 == true) goto L12;
        Map<String, String> r102 = DowngradeImplManager.getInstance().componentsMap;
        Iterator<String> r103 = r102.keySet().iterator();
    L5:
        if (r103.hasNext() == false) goto L12;
        String r104 = r103.next();
        if (this.resolvedClasses.contains(r104) == false) goto L5;
        if (TextUtils.equals(r102.get(r104), r100) == false) goto L5;
        return false;
    L12:
        DowngradeImplManager.getInstance().downgradeComponent(r100);
        return true;
    }

    public <T> T getService(Class<T> r100, boolean r101) {
        return (T) getService(r100, r101, this.enableDynamicProxyDefault);
    }

    public <T> T getServiceByGroup(Class<T> r100, String r101) {
        Map<String, ServiceProvider<?>> r102 = this.groupServiceProviderConcurrentHashMap.get(r100);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.containsKey(r101) == true) goto L8;
        return null;
    L8:
        return (T) r102.get(r101).get();
    }

    public <T> Set<T> getServices(Class<T> r100, boolean r101) {
        Set<ServiceProvider<?>> r102 = this.classServiceProviderConcurrentHashMap.get(r100);
        if (r102 != null) goto L5;
    L17:
        Set<T> r103 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(r100);
        if (r103 == null) goto L23;
        if (r103.isEmpty() == true) goto L23;
        return r103;
    L23:
        return getLegacyServices(r100);
    L5:
        if (r102.isEmpty() == true) goto L17;
        MutableKeys r104 = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        Object[] r105 = r102.toArray();
        int r106 = r105.length;
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L10;
        r104.add(((ServiceProvider) r105[r107]).get());
        r107 = r107 + 1;
        goto L8
    L10:
        if (r101 == false) goto L16;
        Set<T> r108 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(r100);
        if (r108 == null) goto L16;
        if (r108.isEmpty() == true) goto L16;
        r104.addAll(r108);
    L16:
        return r104;
    }

    public <T> GroupBinding bind(Class<T> r100, String r101, ServiceProvider<T> r102) {
        return new GroupBinding(this.groupServiceProviderConcurrentHashMap, r100, r101, r102);
    }

    public <T> void bindDowngradeImpl(Class<T> r100, ServiceProvider<T> r101, boolean r102) {
        if (r102 == false) goto L4;
        r101 = new SingletonProvider(r101);
    L4:
        DowngradeImplManager.getInstance().bindDowngradeImpl(r100, r101);
    }

    public <T> T getService(Class<T> r100, boolean r101, boolean r102) {
        return (T) getService(r100, r101, r102, false);
    }

    public <T> T getService(Class<T> r100, boolean r101, boolean r102, boolean r110) {
        if (r110 == false) goto L5;
    L10:
        T r103 = null;
        boolean r104 = false;
    L11:
        Set<ServiceProvider<?>> r105 = this.classServiceProviderConcurrentHashMap.get(r100);
        if (r105 != null) goto L14;
    L19:
        if (r103 == null) goto L22;
        markResolved(r100);
        return r103;
    L22:
        T r106 = (T) StaticServiceImplManager.getInstance().getStaticServiceImpl(r100);
        if (r106 == null) goto L26;
        markResolved(r100);
        return r106;
    L26:
        if (r110 == false) goto L28;
        return null;
    L28:
        T r107 = (T) getLegacyService(r100);
        if (r107 == null) goto L32;
        markResolved(r100);
        return r107;
    L32:
        if (r104 == true) goto L34;
        r107 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(r100);
    L34:
        if (r107 != null) goto L38;
        if (r102 == false) goto L39;
        new DynamicProxy();
        return (T) DynamicProxy.get(r100);
    L39:
        return r107;
    L38:
        return r107;
    L14:
        if (r105.isEmpty() == true) goto L19;
        if (r101 == true) goto L19;
        Object[] r108 = r105.toArray();
        if (r108.length <= 0) goto L19;
        r103 = (T) ((ServiceProvider) r108[0]).get();
        goto L19
    L5:
        if (DowngradeImplManager.getInstance().isServiceForceDowngrade(r100) == false) goto L10;
        r103 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(r100);
        if (r103 == null) goto L9;
        return r103;
    L9:
        r104 = true;
        goto L11
    }
}
