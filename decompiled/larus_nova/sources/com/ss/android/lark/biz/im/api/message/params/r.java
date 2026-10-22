package com.ss.android.lark.biz.im.api.message.params;

/* JADX INFO: loaded from: classes34.dex */
public final class r implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f410377a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.f410377a, ((r) r100).f410377a) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f410377a);
    }

    public final String toString() {
        return "NestedBubbleParam(verticalMarginDp=" + this.f410377a + ')';
    }

    public r() {
        this.f410377a = 4.0f;
    }
}
