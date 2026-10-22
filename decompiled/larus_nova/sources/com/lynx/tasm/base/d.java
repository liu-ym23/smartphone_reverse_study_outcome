package com.lynx.tasm.base;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Long, Object> f381866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f381867b;

    public d() {
        this.f381866a = new ConcurrentHashMap();
        this.f381867b = new AtomicLong(0);
    }
}
