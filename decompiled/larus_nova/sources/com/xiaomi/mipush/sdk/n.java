package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f463074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f181a;

    public n() {
        this.f463074a = 0;
        this.f181a = "";
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if ((r100 instanceof n) == false) goto L13;
        n r101 = (n) r100;
        if (TextUtils.isEmpty(r101.f181a) == false) goto L8;
        return false;
    L8:
        if (r101.f181a.equals(this.f181a) == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }
}
