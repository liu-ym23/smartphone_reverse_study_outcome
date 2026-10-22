package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class c implements z2b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f412464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f412465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f412466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f412467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f412468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f412469f;

    public final d c() {
        return new d(this.f412465b.size(), this.f412466c.get(), this.f412467d.get(), this.f412468e.get(), this.f412469f.get());
    }

    public c() {
        this.f412464a = true;
        this.f412465b = new ConcurrentHashMap(0);
        this.f412466c = new AtomicInteger(0);
        this.f412467d = new AtomicInteger(0);
        this.f412468e = new AtomicInteger(0);
        this.f412469f = new AtomicInteger(0);
    }

    public final void d(AtomicInteger r100) {
        Intrinsics.checkNotNullParameter(r100, "counter");
        if (this.f412464a == true) goto L5;
        return;
    L5:
        r100.getAndIncrement();
    }

    public final void e(String r100) {
        if (this.f412464a == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
        return;
    L13:
        this.f412465b.put(r100, Boolean.TRUE);
        return;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    }
}
