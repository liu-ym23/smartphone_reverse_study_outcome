package gx0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f483084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f483085c;

    public a() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f483083a, r101.f483083a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f483084b, r101.f483084b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f483085c, r101.f483085c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f483083a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f483084b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f483085c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ExchangeCommonLog(exchangeReason=" + this.f483083a + ", eventModule=" + this.f483084b + ", popupType=" + this.f483085c + ")";
    }

    public a(String r100, int r101) {
        String r102 = "";
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        String r103 = null;
        if ((r101 & 2) != 0) goto L10;
        r102 = null;
    L10:
        if ((r101 & 4) == 0) goto L12;
        r103 = "insufficient_balance_popup";
    L12:
        Intrinsics.checkNotNullParameter(r100, "exchangeReason");
        Intrinsics.checkNotNullParameter(r102, "eventModule");
        Intrinsics.checkNotNullParameter(r103, "popupType");
        this.f483083a = r100;
        this.f483084b = r102;
        this.f483085c = r103;
    }
}
