package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class f implements m6b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f416470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f416471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m6b.b f416472c;

    public interface a {
        void a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.chat.service.impl.b] */
    @Inject
    public f(m6b.b r100) {
        this.f416470a = new CopyOnWriteArrayList();
        this.f416471b = new b();
        this.f416472c = r100;
    }

    @Override // m6b.a
    public final void L7(a r100) {
        if (((CopyOnWriteArrayList) this.f416470a).contains(r100) == false) goto L5;
        return;
    L5:
        com.ss.android.lark.sdk.f.a(this.f416470a, r100, new com.ss.android.lark.chat.service.impl.a(this));
    }

    @Override // m6b.a
    public final void Oe(a r100) {
        com.ss.android.lark.sdk.f.b(this.f416470a, r100, new c(this));
    }
}
