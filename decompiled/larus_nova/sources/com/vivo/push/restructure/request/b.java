package com.vivo.push.restructure.request;

import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
public final class b<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a<I, O> f462499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c<O> f462500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f462501c;

    public final a a() {
        return this.f462499a;
    }

    public final c b() {
        return this.f462500b;
    }

    public final long c() {
        return this.f462501c;
    }

    private b(a<I, O> r100) {
        this.f462501c = 5000;
        this.f462499a = r100;
        if (r100 != null) goto L6;
        t.a(8100, "Command object is null, please construct command first");
        return;
    }

    private b(a<I, O> r100, c<O> r101) {
        this(r100);
        this.f462500b = r101;
    }

    public b(a<I, O> r100, c<O> r101, long r102) {
        this(r100, r101);
        this.f462501c = r102;
    }
}
