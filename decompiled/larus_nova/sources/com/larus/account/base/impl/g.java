package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import com.larus.login.impl.v3;

/* JADX INFO: loaded from: classes24.dex */
public final class g extends yb7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f286166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoginPlatform f286167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n38.h f286168c;

    public final void b(ua7.e<wb7.a> r100) {
        if (r100 == null) goto L10;
        wb7.a r101 = (wb7.a) r100.f549264p;
        if (r101 == null) goto L10;
        com.ss.android.account.d r102 = r101.f559009e;
        if (r102 == null) goto L10;
        boolean r103 = true;
        if (r102.f541366g != true) goto L10;
    L11:
        m38.a r104 = m38.a.f511783a;
        r104.getClass();
        m38.a.f511785c = r103;
        String r105 = this.f286166a;
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        m38.a.c(r104, r105, this.f286167b);
        this.f286168c.b(this.f286167b, this.f286166a, Boolean.valueOf(r103));
        return;
    L10:
        r103 = false;
        goto L11
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
        b((ua7.e) r100);
    }

    public g(LoginPlatform r100, v3 r101) {
        this.f286166a = "VerificationCodeFragment";
        this.f286167b = r100;
        this.f286168c = r101;
    }

    public final void a(ua7.e<wb7.a> r110, int r111) {
        m38.a.f511783a.getClass();
        n38.h r100 = this.f286168c;
        LoginPlatform r101 = this.f286167b;
        if (r110 == null) goto L5;
        int r102 = r110.f549253g;
    L6:
        if (r110 == null) goto L8;
        String r112 = r110.f549255i;
    L9:
        n38.h.a.a(r100, r101, r102, r112, this.f286166a, null, null, null, null, 480);
        return;
    L8:
        r112 = null;
        goto L9
    L5:
        r102 = -1;
        goto L6
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
        a((ua7.e) r100, r101);
    }
}
