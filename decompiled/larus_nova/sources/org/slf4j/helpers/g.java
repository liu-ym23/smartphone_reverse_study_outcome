package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes42.dex */
public final class g implements ywc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f526233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f526234b;

    @Override // ywc.e
    public final void initialize() {
    }

    @Override // ywc.e
    public final String c() {
        throw new UnsupportedOperationException();
    }

    public g() {
        this.f526233a = new f();
        new ConcurrentHashMap();
        this.f526234b = new a();
    }

    @Override // ywc.e
    public final xwc.a a() {
        return this.f526233a;
    }

    @Override // ywc.e
    public final ywc.c b() {
        return this.f526234b;
    }
}
