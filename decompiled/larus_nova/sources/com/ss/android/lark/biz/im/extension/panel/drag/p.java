package com.ss.android.lark.biz.im.extension.panel.drag;

/* JADX INFO: loaded from: classes34.dex */
public final class p implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f410563a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.f410563a, ((p) r100).f410563a) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f410563a);
    }

    public final String toString() {
        return "WrapCoerceAtMost(rate=" + this.f410563a + ')';
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.a
    public final float a() {
        return this.f410563a;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.a
    public final boolean b() {
        return this instanceof h;
    }

    public p(float r100) {
        this.f410563a = r100;
    }
}
