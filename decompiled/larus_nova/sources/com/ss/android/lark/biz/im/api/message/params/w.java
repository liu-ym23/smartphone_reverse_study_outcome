package com.ss.android.lark.biz.im.api.message.params;

/* JADX INFO: loaded from: classes34.dex */
public final class w implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f410388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f410389b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Float.compare(this.f410388a, r101.f410388a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f410389b, r101.f410389b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f410388a) * 31) + Float.floatToIntBits(this.f410389b);
    }

    public final String toString() {
        return "StickerContentBlockParam(radius=" + this.f410388a + ", maxSizeDp=" + this.f410389b + ')';
    }

    public w() {
        this.f410388a = 8.0f;
        this.f410389b = 128.0f;
    }
}
