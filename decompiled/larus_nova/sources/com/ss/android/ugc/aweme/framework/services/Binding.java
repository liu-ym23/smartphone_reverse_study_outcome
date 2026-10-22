package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Binding<T> {
    Class<T> klass;
    ServiceManager serviceManager;
    ServiceProvider<T> serviceProvider;

    public Binding<T> asSingleton() {
        Set r100 = this.serviceManager.classServiceProviderConcurrentHashMap.get(this.klass);
        ServiceProvider<T> r101 = this.serviceProvider;
        if ((r101 instanceof SingletonProvider) == true) goto L5;
        r100.remove(r101);
        SingletonProvider r102 = new SingletonProvider(this.serviceProvider);
        this.serviceProvider = r102;
        r100.add(r102);
    L5:
        return this;
    }

    public Binding(ServiceManager r100, Class<T> r101, ServiceProvider<T> r102) {
        this.serviceManager = r100;
        this.klass = r101;
        this.serviceProvider = r102;
        Set<ServiceProvider<?>> r103 = r100.classServiceProviderConcurrentHashMap.get(r101);
        if (r103 != null) goto L5;
        Set<ServiceProvider<?>> r104 = Collections.synchronizedSet(new LinkedHashSet());
        r104.add(r102);
        r100.classServiceProviderConcurrentHashMap.put(r101, r104);
        return;
    L5:
        r103.add(r102);
    }
}
