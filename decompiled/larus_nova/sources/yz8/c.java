package yz8;

import com.larus.account.base.impl.o;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.phone.PhoneLogin;
import wb7.j;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends yb7.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.h f569557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhoneLogin f569558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f569559c;

    public final void b(ua7.e<j> r100) {
        if (r100 == null) goto L10;
        j r101 = (j) r100.f549264p;
        if (r101 == null) goto L10;
        com.ss.android.account.d r102 = r101.f559025e;
        if (r102 == null) goto L10;
        boolean r103 = true;
        if (r102.f541366g != true) goto L10;
    L11:
        n38.h r104 = this.f569557a;
        this.f569558b.getClass();
        r104.b(LoginPlatform.PHONE, this.f569559c, Boolean.valueOf(r103));
        return;
    L10:
        r103 = false;
        goto L11
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
        b((ua7.e) r100);
    }

    public c(o r100, PhoneLogin r101) {
        this.f569557a = r100;
        this.f569558b = r101;
        this.f569559c = "PhoneLoginAccountDiscoveryActivity";
    }

    public final void a(ua7.e<j> r110, int r111) {
        n38.h r100 = this.f569557a;
        this.f569558b.getClass();
        LoginPlatform r101 = LoginPlatform.PHONE;
        if (r110 == null) goto L5;
        String r112 = r110.f549255i;
    L6:
        if (r112 != null) goto L8;
        r112 = "";
    L8:
        n38.h.a.a(r100, r101, r111, r112, this.f569559c, null, null, null, null, 480);
        return;
    L5:
        r112 = null;
        goto L6
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
        a((ua7.e) r100, r101);
    }
}
