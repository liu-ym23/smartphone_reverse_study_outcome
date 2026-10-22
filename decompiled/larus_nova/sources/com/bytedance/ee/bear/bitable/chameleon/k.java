package com.bytedance.ee.bear.bitable.chameleon;

import kotlin.Result;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements bn4.a.InterfaceC0319a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bn4.a f209655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f209656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> f209657c;

    @Override // bn4.a.InterfaceC0319a
    public final void onResult(boolean r100) {
        Boolean r101 = this.f209655a.d(this.f209656b);
        if (r101 != null) goto L6;
        tt5.a.k("BitableWikiChecker", "check BaseApp result is unconfirmed, callback=" + r100);
    L6:
        if (this.f209657c.isActive() == false) goto L9;
        this.f209657c.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }

    public k(bn4.a r100, String r101, kotlinx.coroutines.j r102) {
        this.f209655a = r100;
        this.f209656b = r101;
        this.f209657c = r102;
    }
}
