package com.ss.android.lark.translate.service.impl;

import com.ss.android.lark.biz.im.api.m0;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class n implements com.ss.android.lark.translate.service.impl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nyb.b f444342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f444343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<m0> f444344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a> f444345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.translate.service.impl.b f444346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f444347f;

    public interface a {
        void a();
    }

    public interface b {
        void g0(fcb.a r100);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.lark.translate.service.impl.f] */
    @Inject
    public n(com.ss.android.lark.translate.service.impl.b r100) {
        this.f444343b = new CopyOnWriteArrayList();
        this.f444344c = new CopyOnWriteArrayList();
        this.f444345d = new CopyOnWriteArrayList();
        this.f444347f = new f();
        this.f444346e = r100;
        this.f444342a = new nyb.b();
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void Q6(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.a(this.f444343b, r100, new h(this));
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void X6(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<a> r101 = this.f444345d;
        final com.ss.android.lark.translate.service.impl.b r102 = this.f444346e;
        Objects.requireNonNull(r102);
        com.ss.android.lark.sdk.f.b(r101, r100, new d(r102));
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void addPushTranslateLanguageSettingListener(m0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.a(this.f444344c, r100, new c(this));
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void ee(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.ss.android.lark.sdk.f.a(this.f444345d, r100, new e(this));
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void ef(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<b> r101 = this.f444343b;
        final com.ss.android.lark.translate.service.impl.b r102 = this.f444346e;
        Objects.requireNonNull(r102);
        com.ss.android.lark.sdk.f.b(r101, r100, new i(r102));
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void g0(fcb.a r100) {
        if (r100 == null) goto L7;
        Iterator r101 = ((CopyOnWriteArrayList) this.f444343b).iterator();
    L5:
        if (r101.hasNext() == false) goto L9;
        ((b) r101.next()).g0(r100);
        goto L5
    L9:
        return;
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void removePushTranslateLanguageSettingListener(m0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<m0> r101 = this.f444344c;
        final com.ss.android.lark.translate.service.impl.b r102 = this.f444346e;
        Objects.requireNonNull(r102);
        com.ss.android.lark.sdk.f.b(r101, r100, new g(r102));
    }
}
