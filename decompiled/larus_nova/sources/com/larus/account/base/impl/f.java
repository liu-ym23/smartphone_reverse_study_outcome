package com.larus.account.base.impl;

import com.larus.account.base.model.LoginPlatform;
import com.larus.login.impl.u3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends com.ss.android.account.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.h f286163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoginPlatform f286164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f286165c;

    @Override // com.ss.android.account.l
    public final void a(ua7.h r110) {
        m38.a.f511783a.getClass();
        n38.h r100 = this.f286163a;
        LoginPlatform r101 = this.f286164b;
        if (r110 == null) goto L5;
        int r102 = r110.f549253g;
    L6:
        if (r110 == null) goto L8;
        String r111 = r110.f549255i;
    L9:
        n38.h.a.a(r100, r101, r102, r111, this.f286165c, null, null, null, null, 480);
        return;
    L8:
        r111 = null;
        goto L9
    L5:
        r102 = -1;
        goto L6
    }

    @Override // com.ss.android.account.l
    public final void c(ua7.h r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        com.ss.android.account.d r101 = r100.f549279p;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.f541366g != true) goto L7;
    L8:
        m38.a r103 = m38.a.f511783a;
        r103.getClass();
        m38.a.f511785c = r102;
        String r104 = this.f286165c;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        m38.a.c(r103, r104, this.f286164b);
        this.f286163a.b(this.f286164b, this.f286165c, Boolean.valueOf(r102));
        return;
    L7:
        r102 = false;
        goto L8
    }

    public f(u3 r100, LoginPlatform r101) {
        this.f286163a = r100;
        this.f286164b = r101;
        this.f286165c = "VerificationCodeFragment";
    }

    @Override // com.ss.android.account.l
    public final void b(ua7.h r110, String r111, String r112, String r113) {
        m38.a.f511783a.getClass();
        n38.h r100 = this.f286163a;
        LoginPlatform r101 = this.f286164b;
        if (r110 == null) goto L5;
        int r102 = r110.f549253g;
    L6:
        if (r110 == null) goto L8;
        String r114 = r110.f549280q;
    L9:
        n38.h.a.a(r100, r101, r102, r114, this.f286165c, null, null, null, null, 480);
        return;
    L8:
        r114 = null;
        goto L9
    L5:
        r102 = -1;
        goto L6
    }
}
