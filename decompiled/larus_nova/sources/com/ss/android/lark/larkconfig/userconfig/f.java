package com.ss.android.lark.larkconfig.userconfig;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes36.dex */
public abstract class f<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f431151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<b> f431152b;

    public interface a {
    }

    public static class b<K, V> {
    }

    public f() {
        this.f431151a = new ConcurrentHashMap();
        new AtomicInteger(0);
        new AtomicInteger(0);
        this.f431152b = new LinkedBlockingQueue();
    }
}
