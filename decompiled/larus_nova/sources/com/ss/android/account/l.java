package com.ss.android.account;

/* JADX INFO: loaded from: classes34.dex */
public abstract class l extends ua7.a<ua7.h> {
    public abstract void a(ua7.h r100);

    public abstract void b(ua7.h r100, String r101, String r102, String r103);

    public abstract void c(ua7.h r100);

    public l() {
    }

    @Override // ua7.a
    public final void onResponse(ua7.b r100) {
        ua7.h r101 = (ua7.h) r100;
        if (r101.f549249c == false) goto L5;
        c(r101);
        return;
    L5:
        int r102 = r101.f549253g;
        if (r102 != 1030) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L17;
        String r104 = r101.f549282s;
        if (r104 == null) goto L16;
        b(r101, r101.f549280q, r101.f549281r, r104);
        return;
    L16:
        a(r101);
        return;
    L17:
        a(r101);
        return;
    L8:
        if (r102 == 1041) goto L11;
        r103 = false;
        goto L12
    }
}
