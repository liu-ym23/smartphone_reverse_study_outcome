package yz8;

import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.phone.PhoneLogin;

/* JADX INFO: loaded from: classes27.dex */
public final class i extends yb7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.h f569570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhoneLogin f569571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f569572c;

    public final void b(ua7.e<wb7.h> r100) {
        n38.h r101 = this.f569570a;
        this.f569571b.getClass();
        r101.b(LoginPlatform.PHONE, this.f569572c, Boolean.TRUE);
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
        b((ua7.e) r100);
    }

    public final void a(ua7.e<wb7.h> r110, int r111) {
        n38.h r100 = this.f569570a;
        this.f569571b.getClass();
        LoginPlatform r101 = LoginPlatform.PHONE;
        if (r110 == null) goto L6;
        String r112 = r110.f549255i;
        if (r112 == null) goto L6;
    L7:
        n38.h.a.a(r100, r101, r111, r112, this.f569572c, null, null, null, null, 480);
        return;
    L6:
        r112 = "";
        goto L7
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
        a((ua7.e) r100, r101);
    }

    public i(n38.h r100, PhoneLogin r101, String r102) {
        this.f569570a = r100;
        this.f569571b = r101;
        this.f569572c = r102;
    }
}
