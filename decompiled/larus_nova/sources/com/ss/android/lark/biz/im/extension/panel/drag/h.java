package com.ss.android.lark.biz.im.extension.panel.drag;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f410547a;

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.a
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.f410547a, ((h) r100).f410547a) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f410547a);
    }

    public final String toString() {
        return "FixedHeightStyle(rate=" + this.f410547a + ')';
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.a
    public final float a() {
        return this.f410547a;
    }

    public h(float r100) {
        this.f410547a = r100;
    }
}
