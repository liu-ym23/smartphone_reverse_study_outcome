package com.relax.relaxframework;

/* JADX INFO: loaded from: classes34.dex */
public final class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f405016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f405017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f405018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f405019d;

    public b3() {
        this.f405016a = 0;
        this.f405017b = 0;
        this.f405018c = 0;
        this.f405019d = 0;
    }

    public final boolean a(int r100) {
        int r101 = r100 >> 6;
        int r102 = com.bytedance.rts.foundation.d.f267577a;
        long r103 = 1 << (r100 & 63);
        if (r101 == 0) goto L23;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L11;
        return false;
    L11:
        if ((this.f405019d & r103) == 0) goto L26;
        return true;
    L26:
        return false;
    L15:
        if ((this.f405018c & r103) == 0) goto L27;
        return true;
    L27:
        return false;
    L19:
        if ((this.f405017b & r103) == 0) goto L28;
        return true;
    L28:
        return false;
    L23:
        if ((this.f405016a & r103) == 0) goto L29;
        return true;
    L29:
        return false;
    }
}
