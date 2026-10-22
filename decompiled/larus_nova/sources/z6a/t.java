package z6a;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes32.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f570615b;

    public final int hashCode() {
        return (this.f570614a * 31) + Float.floatToIntBits(this.f570615b);
    }

    public t(ReadableArray r100) {
        this.f570615b = (float) r100.getDouble(0);
        this.f570614a = r100.getInt(1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (t.class != r100.getClass()) goto L17;
        t r101 = (t) r100;
        if (this.f570615b == r101.f570615b) goto L13;
    L15:
        return false;
    L13:
        if (this.f570614a != r101.f570614a) goto L15;
        return true;
    }
}
