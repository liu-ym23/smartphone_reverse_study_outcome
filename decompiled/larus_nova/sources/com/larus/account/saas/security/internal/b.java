package com.larus.account.saas.security.internal;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends sa7.h<xa7.c> {
    public b() {
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.c r101 = (xa7.c) r100;
        String r102 = null;
        j.b("/passport/doubao/safety_alert/confirm/", true, null, null);
        com.larus.account.saas.runtime.internal.delegate.a r103 = com.larus.account.saas.runtime.internal.delegate.a.f286466a;
        StringBuilder r104 = new StringBuilder("confirm success, msg=");
        if (r101 == null) goto L5;
        r102 = r101.f549255i;
    L5:
        r104.append(r102);
        r103.d("AccountSecurityConfirm", r104.toString());
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.c r102 = (xa7.c) r100;
        int r103 = j.f286510a;
        Integer r104 = Integer.valueOf(r101);
        String r105 = null;
        if (r102 == null) goto L6;
        String r106 = r102.f549255i;
        if (r106 == null) goto L6;
    L9:
        j.b("/passport/doubao/safety_alert/confirm/", false, r104, r106);
        com.larus.account.saas.runtime.internal.delegate.a r107 = com.larus.account.saas.runtime.internal.delegate.a.f286466a;
        StringBuilder r108 = new StringBuilder("confirm failed, code=");
        r108.append(r101);
        r108.append(", msg=");
        if (r102 == null) goto L12;
        r105 = r102.f549255i;
    L12:
        r108.append(r105);
        r107.f("AccountSecurityConfirm", r108.toString());
        return;
    L6:
        if (r102 == null) goto L8;
        r106 = r102.f549256j;
        goto L9
    L8:
        r106 = null;
        goto L9
    }
}
