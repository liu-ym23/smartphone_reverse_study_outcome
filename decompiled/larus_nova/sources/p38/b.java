package p38;

import com.larus.login.impl.w;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import n38.m;
import xa7.i;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends va7.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f527597a;

    public b(w r100) {
        this.f527597a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        i r101 = (i) r100;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("checkSafeEnvBeforeInputOldMobile safe:");
        if (r101 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r101.f563090q);
    L6:
        r103.append(r104);
        r103.append(" ticket:");
        if (r101 == null) goto L9;
        String r105 = r101.f563089p;
    L10:
        r103.append(r105);
        r102.i("ChangePhoneManager", r103.toString());
        if (r101 == null) goto L15;
        boolean r106 = true;
        if (r101.f563090q != true) goto L15;
    L16:
        if (r106 == true) goto L18;
    L20:
        m r107 = this.f527597a;
        if (r101 == null) goto L23;
        int r108 = r101.f549253g;
    L24:
        if (r101 == null) goto L26;
        String r109 = r101.f549255i;
    L27:
        r107.a(r108, r109, null, null);
        return;
    L26:
        r109 = null;
        goto L27
    L23:
        r108 = -1;
        goto L24
    L18:
        if (o0.d(r101.f563089p) == false) goto L20;
        this.f527597a.onSuccess(r101.f563089p);
        return;
    L15:
        r106 = false;
        goto L16
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        i r102 = (i) r100;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("checkSafeEnvBeforeInputOldMobile error:");
        r104.append(r101);
        r104.append(':');
        if (r102 == null) goto L5;
        String r105 = r102.f549255i;
    L6:
        r104.append(r105);
        r103.w("ChangePhoneManager", r104.toString());
        m r106 = this.f527597a;
        if (r102 == null) goto L9;
        int r107 = r102.f549253g;
    L10:
        if (r102 == null) goto L12;
        String r108 = r102.f549255i;
    L13:
        r106.a(r107, r108, null, null);
        return;
    L12:
        r108 = null;
        goto L13
    L9:
        r107 = -1;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
