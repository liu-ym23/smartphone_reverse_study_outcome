package com.ss.android.lark.chat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class k2 implements m6b.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f416533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f416534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m6b.r f416535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e2 f416536d;

    public interface a {
        void a();
    }

    public interface b {
        void a(JSONObject r100);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.service.impl.e2] */
    @Inject
    public k2(m6b.r r100) {
        this.f416533a = new CopyOnWriteArrayList();
        this.f416534b = new CopyOnWriteArrayList();
        this.f416536d = new e2();
        this.f416535c = r100;
    }

    @Override // m6b.q
    public final void G1(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.a(this.f416533a, r100, new d2(this));
    }

    @Override // m6b.q
    public final void Ia(b r100) {
        List<b> r101 = this.f416533a;
        m6b.r r102 = this.f416535c;
        Objects.requireNonNull(r102);
        if (r100 == null) goto L28;
        monitor-enter(r101);
        r101.remove(r100);     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        if (r101.isEmpty() == false) goto L19;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (r101.isEmpty() == false) goto L14;
        r102.d();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L19:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // m6b.q
    public final void be(a r100) {
        List<a> r101 = this.f416534b;
        final m6b.r r102 = this.f416535c;
        Objects.requireNonNull(r102);
        com.ss.android.lark.sdk.f.b(r101, r100, new c2(r102));
    }

    @Override // m6b.q
    public final void je(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.a(this.f416534b, r100, new f2(this));
    }
}
