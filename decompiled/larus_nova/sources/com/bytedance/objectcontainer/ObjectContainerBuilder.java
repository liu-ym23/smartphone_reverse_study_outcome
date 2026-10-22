package com.bytedance.objectcontainer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class ObjectContainerBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectContainer.Name f266122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObjectContainer f266123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<ServiceKey, Provider<?>> f266124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<? extends FactoryArg>, Factory<?, ?>> f266125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Object, Map<?, Provider<?>>> f266126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Object, Set<Provider<?>>> f266127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Object, List<Provider<?>>> f266128g;

    public ObjectContainerBuilder(StringName r100, ObjectContainer r101) {
        this.f266124c = new LinkedHashMap();
        this.f266125d = new LinkedHashMap();
        this.f266126e = new LinkedHashMap();
        this.f266127f = new LinkedHashMap();
        this.f266128g = new LinkedHashMap();
        this.f266122a = r100;
        this.f266123b = r101;
        if (r101 == null) goto L6;
        ObjectContainer.Name r102 = r101.f266107a;
        r100.getClass();
        return;
    }
}
