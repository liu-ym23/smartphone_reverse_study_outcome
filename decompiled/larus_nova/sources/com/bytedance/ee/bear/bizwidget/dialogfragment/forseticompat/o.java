package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

/* JADX INFO: loaded from: classes16.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f216476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f216477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f216478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f216479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f216480e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f216481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f216482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f216483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f216484d;

        public final o a() {
            return new o(this.f216481a, this.f216482b, this.f216483c, this.f216484d);
        }

        public a() {
            this.f216481a = true;
            this.f216482b = true;
            this.f216483c = true;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f216476a == r101.f216476a) goto L12;
        return false;
    L12:
        if (this.f216477b == r101.f216477b) goto L15;
        return false;
    L15:
        if (this.f216478c == r101.f216478c) goto L18;
        return false;
    L18:
        if (this.f216479d == r101.f216479d) goto L21;
        return false;
    L21:
        if (this.f216480e == r101.f216480e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f216476a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f216477b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f216478c == true) goto L15;
        r100 = 1237;
    L15:
        return ((((r104 + r100) * 31) + this.f216479d) * 31) + this.f216480e;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "InsetsConfig(consumeStatusBar=" + this.f216476a + ", consumeNavBar=" + this.f216477b + ", consumeIme=" + this.f216478c + ", statusBarColor=" + this.f216479d + ", navBarColor=" + this.f216480e + ')';
    }

    public o(boolean r100, boolean r101, boolean r102, int r103) {
        this.f216476a = r100;
        this.f216477b = r101;
        this.f216478c = r102;
        this.f216479d = 0;
        this.f216480e = r103;
    }
}
