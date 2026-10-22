package com.larus.platform.model.chat;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f365572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f365573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f365574c;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f365572a == r101.f365572a) goto L12;
        return false;
    L12:
        if (this.f365573b == r101.f365573b) goto L15;
        return false;
    L15:
        if (this.f365574c == r101.f365574c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f365572a == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.f365573b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        if (this.f365574c == true) goto L11;
        r100 = 1237;
    L11:
        return r103 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BDImageXUploadOptConfig(enable=" + this.f365572a + ", sdkTimeout=" + this.f365573b + ", enableLogPrint=" + this.f365574c + ')';
    }

    public /* synthetic */ c(int r100) {
        this(false, 60000, false);
    }

    public c(boolean r100, long r101, boolean r102) {
        this.f365572a = r100;
        this.f365573b = r101;
        this.f365574c = r102;
    }
}
