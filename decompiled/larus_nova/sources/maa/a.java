package maa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f512720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f512721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f512722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f512723d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f512720a == r101.f512720a) goto L12;
        return false;
    L12:
        if (this.f512721b == r101.f512721b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f512722c, r101.f512722c) == true) goto L18;
        return false;
    L18:
        if (this.f512723d == r101.f512723d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f512720a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f512721b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        String r105 = this.f512722c;
        if (r105 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r104 + r106) * 31;
        if (this.f512723d == true) goto L19;
        r100 = 1237;
    L19:
        return r107 + r100;
    L13:
        r106 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AutoMicHandleResult(handled=" + this.f512720a + ", shouldSend=" + this.f512721b + ", sendText=" + this.f512722c + ", checkSecondLevel=" + this.f512723d + ')';
    }

    public /* synthetic */ a(boolean r100) {
        this(r100, false, null);
    }

    public a(boolean r100, boolean r101, String r102) {
        this.f512720a = r100;
        this.f512721b = r101;
        this.f512722c = r102;
        this.f512723d = false;
    }
}
