package com.larus.dora.impl.device.settings.gesture.wakeup;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureWakeupType f334535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f334536b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f334535a == r101.f334535a) goto L12;
        return false;
    L12:
        if (this.f334536b == r101.f334536b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        GestureWakeupType r100 = this.f334535a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f334536b;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "GestureWakeupSideType(type=" + this.f334535a + ", side=" + this.f334536b + ')';
    }

    public final GestureWakeupType getType() {
        return this.f334535a;
    }

    public h(GestureWakeupType r100, int r101) {
        this.f334535a = r100;
        this.f334536b = r101;
    }
}
