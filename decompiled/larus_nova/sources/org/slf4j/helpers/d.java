package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes42.dex */
public final class d implements ywc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f526221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f526222b;

    @Override // ywc.e
    public final String c() {
        return "2.0.99";
    }

    @Override // ywc.e
    public final void initialize() {
    }

    public d() {
        this.f526221a = new b();
        new ConcurrentHashMap();
        this.f526222b = new c();
    }

    @Override // ywc.e
    public final xwc.a a() {
        return this.f526221a;
    }

    @Override // ywc.e
    public final ywc.c b() {
        return this.f526222b;
    }
}
