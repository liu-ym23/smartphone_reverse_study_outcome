package p38;

import com.larus.login.impl.y3;
import com.larus.utils.logger.FLogger;
import n38.o;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends va7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f527596a;

    public a(y3 r100) {
        this.f527596a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.b r101 = (xa7.b) r100;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("checkOldPhoneUnusable isMnoSupport:");
        String r104 = null;
        if (r101 == null) goto L5;
        Boolean r105 = Boolean.valueOf(r101.f563070r);
    L6:
        r103.append(r105);
        r103.append(" isUnusable:");
        if (r101 == null) goto L9;
        Boolean r106 = Boolean.valueOf(r101.f563068p);
    L10:
        r103.append(r106);
        r103.append(" isVerified:");
        if (r101 == null) goto L13;
        Boolean r107 = Boolean.valueOf(r101.f563069q);
    L14:
        r103.append(r107);
        r103.append(" getTicket:");
        if (r101 == null) goto L17;
        String r108 = r101.f563071s;
    L18:
        r103.append(r108);
        r102.i("ChangePhoneManager", r103.toString());
        o r109 = this.f527596a;
        boolean r110 = false;
        if (r101 == null) goto L21;
        boolean r111 = r101.f563070r;
    L22:
        if (r101 == null) goto L24;
        r110 = r101.f563068p;
    L24:
        if (r101 == null) goto L26;
        r104 = r101.f563071s;
    L26:
        r109.onSuccess(r111, r110, r104);
        return;
    L21:
        r111 = false;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.b r102 = (xa7.b) r100;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("checkOldPhoneUnusable error:");
        r104.append(r101);
        r104.append(':');
        if (r102 == null) goto L5;
        String r105 = r102.f549255i;
    L6:
        r104.append(r105);
        r103.w("ChangePhoneManager", r104.toString());
        this.f527596a.onFailed();
        return;
    L5:
        r105 = null;
        goto L6
    }
}
