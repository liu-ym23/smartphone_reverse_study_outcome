package com.bytedance.kmp.image.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes19.dex */
public final class a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutexImpl f252181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<K, Deferred<V>> f252182b;

    public a() {
        this.f252181a = kotlinx.coroutines.sync.b.a();
        this.f252182b = new LinkedHashMap();
    }
}
