package si2;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements zk.b {
    public final boolean a;
    public final boolean b;
    public final String c;

    public final String getCouponId() {
        return null;
    }

    public final String entryName() {
        if (TextUtils.isEmpty(this.c) == false) goto L6;
        return "live_shopping_cart";
    L6:
        return this.c;
    }

    public b(String r1, boolean r2, boolean r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
