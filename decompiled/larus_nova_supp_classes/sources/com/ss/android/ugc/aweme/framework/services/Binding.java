package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class Binding<T> {
    Class<T> klass;
    ServiceManager serviceManager;
    ServiceProvider<T> serviceProvider;

    public Binding<T> asSingleton() {
        Set r0 = this.serviceManager.classServiceProviderConcurrentHashMap.get(this.klass);
        ServiceProvider<T> r1 = this.serviceProvider;
        if ((r1 instanceof SingletonProvider) == true) goto L5;
        r0.remove(r1);
        SingletonProvider r2 = new SingletonProvider(this.serviceProvider);
        this.serviceProvider = r2;
        r0.add(r2);
    L5:
        return this;
    }

    public Binding(ServiceManager r2, Class<T> r3, ServiceProvider<T> r4) {
        this.serviceManager = r2;
        this.klass = r3;
        this.serviceProvider = r4;
        Set<ServiceProvider<?>> r0 = r2.classServiceProviderConcurrentHashMap.get(r3);
        if (r0 != null) goto L5;
        Set<ServiceProvider<?>> r1 = Collections.synchronizedSet(new LinkedHashSet());
        r1.add(r4);
        r2.classServiceProviderConcurrentHashMap.put(r3, r1);
        return;
    L5:
        r0.add(r4);
    }
}
