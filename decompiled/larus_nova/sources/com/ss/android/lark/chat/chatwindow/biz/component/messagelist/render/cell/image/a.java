package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f412205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f412206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f412207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f412208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f412209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f412210f;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f412205a == r101.f412205a) goto L12;
        return false;
    L12:
        if (this.f412206b == r101.f412206b) goto L15;
        return false;
    L15:
        if (this.f412207c == r101.f412207c) goto L18;
        return false;
    L18:
        if (this.f412208d == r101.f412208d) goto L21;
        return false;
    L21:
        if (this.f412209e == r101.f412209e) goto L24;
        return false;
    L24:
        if (this.f412210f == r101.f412210f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f412205a * 31) + this.f412206b) * 31) + this.f412207c) * 31) + this.f412208d) * 31;
        int r101 = 1231;
        if (this.f412209e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f412210f == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageSizeInfo(viewWidth=" + this.f412205a + ", viewHeight=" + this.f412206b + ", imageWidth=" + this.f412207c + ", imageHeight=" + this.f412208d + ", isLargeImage=" + this.f412209e + ", isSmallImage=" + this.f412210f + ')';
    }

    public /* synthetic */ a(int r100) {
        this(0, 0, 0, 0, false, false);
    }

    public a(int r100, int r101, int r102, int r103, boolean r104, boolean r105) {
        this.f412205a = r100;
        this.f412206b = r101;
        this.f412207c = r102;
        this.f412208d = r103;
        this.f412209e = r104;
        this.f412210f = r105;
    }
}
