package si2;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements zk.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f542141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f542142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f542143c;

    @Override // zk.b
    public final String getCouponId() {
        return null;
    }

    @Override // zk.b
    public final String entryName() {
        if (TextUtils.isEmpty(this.f542143c) == false) goto L6;
        return "live_shopping_cart";
    L6:
        return this.f542143c;
    }

    public b(String r100, boolean r101, boolean r102) {
        this.f542143c = r100;
        this.f542141a = r101;
        this.f542142b = r102;
    }
}
