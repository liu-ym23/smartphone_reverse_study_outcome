package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f459670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f459671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f459672c;

    public boolean isValid() {
        if (this.f459670a == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.f459671b != (-1)) goto L8;
        return false;
    }

    public y() {
        this.f459670a = -1;
        this.f459671b = -1;
        this.f459672c = -1.0f;
    }
}
