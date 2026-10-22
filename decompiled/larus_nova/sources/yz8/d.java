package yz8;

import com.larus.account.base.impl.o;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.phone.PhoneLogin;

/* JADX INFO: loaded from: classes27.dex */
public final class d extends va7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.h f569560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhoneLogin f569561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f569562c;

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.g r101 = (xa7.g) r100;
        if (r101 == null) goto L9;
        com.ss.android.account.d r102 = r101.f563088v;
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.f541366g != true) goto L9;
    L10:
        n38.h r104 = this.f569560a;
        this.f569561b.getClass();
        r104.b(LoginPlatform.PHONE, this.f569562c, Boolean.valueOf(r103));
        return;
    L9:
        r103 = false;
        goto L10
    }

    public d(o r100, PhoneLogin r101) {
        this.f569560a = r100;
        this.f569561b = r101;
        this.f569562c = "PhoneLoginAccountDiscoveryActivity";
    }

    @Override // sa7.h
    public final void onError(ua7.b r110, int r111) {
        xa7.g r112 = (xa7.g) r110;
        n38.h r100 = this.f569560a;
        this.f569561b.getClass();
        LoginPlatform r101 = LoginPlatform.PHONE;
        if (r112 == null) goto L5;
        String r113 = r112.f549255i;
    L6:
        if (r113 != null) goto L8;
        r113 = "";
    L8:
        n38.h.a.a(r100, r101, r111, r113, this.f569562c, null, null, null, null, 480);
        return;
    L5:
        r113 = null;
        goto L6
    }
}
