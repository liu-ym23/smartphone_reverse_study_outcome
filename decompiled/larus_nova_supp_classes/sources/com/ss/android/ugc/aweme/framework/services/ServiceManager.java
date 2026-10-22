package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.framework.services.plugin.PluginInstaller;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ServiceManager {
    final ConcurrentHashMap<Class<?>, Set<ServiceProvider<?>>> classServiceProviderConcurrentHashMap;
    public volatile boolean enableDynamicProxyDefault;
    final Map<Class<?>, Map<String, ServiceProvider<?>>> groupServiceProviderConcurrentHashMap;
    final Set<String> legacyServiceSet;
    final Set<Class<?>> resolvedClasses;

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

    public /* synthetic */ ServiceManager(1 r1) {
        this();
    }

    private <T> T getLegacyService(Class<T> r3) {
        if (this.legacyServiceSet.contains(r3.getName()) == true) goto L5;
        return null;
    L5:
        Iterator r4 = ConfigLoader.iterator(r3);
        if (r4.hasNext() == true) goto L8;
        return null;
    L8:
        return (T) r4.next();
    }

    private void markResolved(Class r2) {
        this.resolvedClasses.add(r2);
    }

    public void addLegacyService(String r2) {
        this.legacyServiceSet.add(r2);
    }

    public boolean downgradeComponent(String r2) {
        return downgradeComponent(r2, false);
    }

    public <T> Set<T> getLegacyServices(Class<T> r4) {
        NavigableSet r0 = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        if (this.legacyServiceSet.contains(r4.getName()) == true) goto L5;
        return r0;
    L5:
        Iterator r5 = ConfigLoader.iterator(r4);
    L7:
        if (r5.hasNext() == false) goto L9;
        r0.add(r5.next());
        goto L7
    L9:
        return r0;
    }

    public <T> T getService(Class<T> r2) {
        return (T) getService(r2, false);
    }

    public <T> T getServiceForReal(Class<T> r4) {
        return (T) getService(r4, false, this.enableDynamicProxyDefault, true);
    }

    public <T> Set<T> getServices(Class<T> r2) {
        return getServices(r2, false);
    }

    public boolean onPluginInstall(String r2) {
        return PluginInstaller.INSTANCE.onPluginInstall(r2);
    }

    public void setDynamicProxyEnableDefault(boolean r1) {
        this.enableDynamicProxyDefault = r1;
    }

    public void addLegacyService(Set<String> r2) {
        this.legacyServiceSet.addAll(r2);
    }

    public <T> Binding bind(Class<T> r2, ServiceProvider<T> r3) {
        return new Binding(this, r2, r3);
    }

    public <T> void bindDowngradeImpl(Class<T> r2, ServiceProvider<T> r3) {
        bindDowngradeImpl(r2, r3, true);
    }

    public boolean downgradeComponent(String r4, boolean r5) {
        if (r5 == true) goto L12;
        Map<String, String> r6 = DowngradeImplManager.getInstance().componentsMap;
        Iterator<String> r0 = r6.keySet().iterator();
    L5:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        if (this.resolvedClasses.contains(r1) == false) goto L5;
        if (TextUtils.equals(r6.get(r1), r4) == false) goto L5;
        return false;
    L12:
        DowngradeImplManager.getInstance().downgradeComponent(r4);
        return true;
    }

    public <T> T getService(Class<T> r2, boolean r3) {
        return (T) getService(r2, r3, this.enableDynamicProxyDefault);
    }

    public <T> T getServiceByGroup(Class<T> r2, String r3) {
        Map<String, ServiceProvider<?>> r4 = this.groupServiceProviderConcurrentHashMap.get(r2);
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.containsKey(r3) == true) goto L8;
        return null;
    L8:
        return (T) r4.get(r3).get();
    }

    public <T> Set<T> getServices(Class<T> r6, boolean r7) {
        Set<ServiceProvider<?>> r0 = this.classServiceProviderConcurrentHashMap.get(r6);
        if (r0 != null) goto L5;
    L17:
        Set<T> r8 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(r6);
        if (r8 == null) goto L23;
        if (r8.isEmpty() == true) goto L23;
        return r8;
    L23:
        return getLegacyServices(r6);
    L5:
        if (r0.isEmpty() == true) goto L17;
        NavigableSet r1 = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        Object[] r2 = r0.toArray();
        int r3 = r2.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        r1.add(((ServiceProvider) r2[r4]).get());
        r4 = r4 + 1;
        goto L8
    L10:
        if (r7 == false) goto L16;
        Set<T> r9 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(r6);
        if (r9 == null) goto L16;
        if (r9.isEmpty() == true) goto L16;
        r1.addAll(r9);
    L16:
        return r1;
    }

    public <T> GroupBinding bind(Class<T> r3, String r4, ServiceProvider<T> r5) {
        return new GroupBinding(this.groupServiceProviderConcurrentHashMap, r3, r4, r5);
    }

    public <T> void bindDowngradeImpl(Class<T> r1, ServiceProvider<T> r2, boolean r3) {
        if (r3 == false) goto L4;
        r2 = new SingletonProvider(r2);
    L4:
        DowngradeImplManager.getInstance().bindDowngradeImpl(r1, r2);
    }

    public <T> T getService(Class<T> r2, boolean r3, boolean r4) {
        return (T) getService(r2, r3, r4, false);
    }

    public <T> T getService(Class<T> r7, boolean r8, boolean r9, boolean r10) {
        if (r10 == false) goto L5;
    L10:
        T r2 = null;
        boolean r3 = false;
    L11:
        Set<ServiceProvider<?>> r4 = this.classServiceProviderConcurrentHashMap.get(r7);
        if (r4 != null) goto L14;
    L19:
        if (r2 == null) goto L22;
        markResolved(r7);
        return r2;
    L22:
        T r11 = (T) StaticServiceImplManager.getInstance().getStaticServiceImpl(r7);
        if (r11 == null) goto L26;
        markResolved(r7);
        return r11;
    L26:
        if (r10 == false) goto L28;
        return null;
    L28:
        T r12 = (T) getLegacyService(r7);
        if (r12 == null) goto L32;
        markResolved(r7);
        return r12;
    L32:
        if (r3 == true) goto L34;
        r12 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(r7);
    L34:
        if (r12 != null) goto L38;
        if (r9 == false) goto L39;
        new DynamicProxy();
        return (T) DynamicProxy.get(r7);
    L39:
        return r12;
    L38:
        return r12;
    L14:
        if (r4.isEmpty() == true) goto L19;
        if (r8 == true) goto L19;
        Object[] r13 = r4.toArray();
        if (r13.length <= 0) goto L19;
        r2 = (T) ((ServiceProvider) r13[0]).get();
        goto L19
    L5:
        if (DowngradeImplManager.getInstance().isServiceForceDowngrade(r7) == false) goto L10;
        r2 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(r7);
        if (r2 == null) goto L9;
        return r2;
    L9:
        r3 = true;
        goto L11
    }
}
