package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class GroupBinding<T> {
    Map<Class<?>, Map<String, ServiceProvider<?>>> classProviderMaps;
    String groupName;
    Class<T> klass;
    ServiceProvider<T> serviceProvider;

    public GroupBinding<T> asSingleton() {
        if ((this.serviceProvider instanceof SingletonProvider) == true) goto L5;
        Map r100 = this.classProviderMaps.get(this.klass);
        r100.remove(this.serviceProvider);
        SingletonProvider r101 = new SingletonProvider(this.serviceProvider);
        this.serviceProvider = r101;
        r100.put(this.groupName, r101);
    L5:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GroupBinding(Map<Class<?>, Map<String, ServiceProvider<?>>> r100, Class<T> r101, String r102, ServiceProvider<T> r103) {
        this.classProviderMaps = r100;
        this.groupName = r102;
        this.klass = r101;
        this.serviceProvider = r103;
        Map<String, ServiceProvider<?>> r104 = r100.get(r101);
        if (r104 != null) goto L5;
        r104 = Collections.synchronizedMap(new HashMap());
        this.classProviderMaps.put(r101, r104);
    L5:
        r104.put(r102, r103);
    }
}
