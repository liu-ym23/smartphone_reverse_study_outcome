package com.ss.android.account.group_onekey;

import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends ua7.a<xa7.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseAccountGroupAuthActivity f406297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f406298b;

    @Override // ua7.a
    public final void onResponse(ua7.b r100) {
        xa7.c r101 = (xa7.c) r100;
        String r102 = this.f406297a.f406253a;
        StringBuilder r103 = new StringBuilder("getRequestGetTokenCallback(), onResponse, success=");
        if (r101 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r101.f549249c);
    L6:
        r103.append(r104);
        r103.append(", error=");
        if (r101 == null) goto L9;
        Integer r105 = Integer.valueOf(r101.f549253g);
    L10:
        r103.append(r105);
        r103.append(", errorMsg=");
        if (r101 == null) goto L13;
        String r106 = r101.f549255i;
    L14:
        r103.append(r106);
        tb7.a.d(r102, r103.toString());
        this.f406297a.f406270r = System.currentTimeMillis();
        this.f406297a.f406264l = SystemClock.elapsedRealtime() - this.f406298b;
        this.f406297a.c();
        int r107 = -3;
        if (r101 == null) goto L31;
        boolean r108 = true;
        if (r101.f549249c != true) goto L31;
        JSONObject r109 = r101.f563072z;
        if (r109 == null) goto L31;
        String r110 = r109.optString("token");
        if (r110 != null) goto L25;
        r110 = "";
    L25:
        if (r110.length() > 0) goto L28;
        r108 = false;
    L28:
        if (r108 == false) goto L30;
        BaseAccountGroupAuthActivity.b(this.f406297a, r110, 0, null, 12);
        return;
    L30:
        BaseAccountGroupAuthActivity.b(this.f406297a, "", -3, "authToken is null", 8);
        return;
    L31:
        StringBuilder r111 = new StringBuilder("server error:");
        if (r101 == null) goto L34;
        int r112 = r101.f549253g;
    L35:
        r111.append(r112);
        r111.append(',');
        if (r101 == null) goto L40;
        String r113 = r101.f549255i;
        if (r113 == null) goto L40;
    L41:
        r111.append(r113);
        String r114 = r111.toString();
        BaseAccountGroupAuthActivity r115 = this.f406297a;
        if (r101 == null) goto L44;
        r107 = r101.f549253g;
    L44:
        BaseAccountGroupAuthActivity.b(r115, "", r107, r114, 8);
        return;
    L40:
        r113 = "unknown";
        goto L41
    L34:
        r112 = -1;
        goto L35
    L13:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public d(BaseAccountGroupAuthActivity r100, long r101) {
        this.f406297a = r100;
        this.f406298b = r101;
    }
}
