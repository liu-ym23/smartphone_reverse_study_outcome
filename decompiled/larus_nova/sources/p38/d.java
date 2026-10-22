package p38;

import com.larus.login.impl.a0;
import com.larus.utils.logger.FLogger;
import n38.m;

/* JADX INFO: loaded from: classes24.dex */
public final class d extends ua7.a<xa7.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f527599a;

    public d(a0.a r100) {
        this.f527599a = r100;
    }

    @Override // ua7.a
    public final void onResponse(ua7.b r100) {
        xa7.c r101 = (xa7.c) r100;
        FLogger.f375446a.i("ChangePhoneManager", "doAuthVerify response:" + r101);
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.f549249c != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        this.f527599a.onSuccess(r101.f563072z.optString("ticket"));
        return;
    L10:
        m r103 = this.f527599a;
        if (r101 == null) goto L13;
        int r104 = r101.f549253g;
    L15:
        if (r101 == null) goto L17;
        String r105 = r101.f549255i;
    L18:
        r103.a(r104, r105, null, null);
        return;
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = -1;
    L7:
        r102 = false;
        goto L8
    }
}
