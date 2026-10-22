package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteScene;

/* JADX INFO: loaded from: classes34.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f406748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f406749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f406750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f406751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f406752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f406753f;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406754a = null;

        static {
            int[] r100 = new int[AINoteScene.values().length];
            r100[AINoteScene.Meeting.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AINoteScene.Record.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AINoteScene.Hardware.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AINoteScene.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f406754a = r100;
        }
    }

    public g0() {
        boolean r100 = false;
        this(r100, r100, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (this.f406748a == r101.f406748a) goto L12;
        return false;
    L12:
        if (this.f406749b == r101.f406749b) goto L15;
        return false;
    L15:
        if (this.f406750c == r101.f406750c) goto L18;
        return false;
    L18:
        if (this.f406751d == r101.f406751d) goto L21;
        return false;
    L21:
        if (this.f406752e == r101.f406752e) goto L24;
        return false;
    L24:
        if (this.f406753f == r101.f406753f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f406748a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f406749b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f406750c;
        int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f406751d) * 31;
        int r106 = 1231;
        if (this.f406752e == false) goto L5;
        int r107 = 1231;
    L6:
        int r108 = (r105 + r107) * 31;
        if (this.f406753f == true) goto L11;
        r106 = 1237;
    L11:
        return r108 + r106;
    L5:
        r107 = 1237;
        goto L6
    }

    public final String toString() {
        return "AINoteRuntimeConfig(autoSaveIntervalMs=" + this.f406748a + ", idleSaveTimeoutMs=" + this.f406749b + ", markThrottleIntervalMs=" + this.f406750c + ", maxImageCountPerDocument=" + this.f406751d + ", recordingLiveRewritingEnabled=" + this.f406752e + ", meetingLiveRewritingEnabled=" + this.f406753f + ')';
    }

    public /* synthetic */ g0(boolean r110, boolean r111, int r112) {
        long r100 = 0;
        if ((r112 & 1) == 0) goto L5;
        long r101 = 1000;
    L7:
        if ((r112 & 2) == 0) goto L9;
        long r102 = 60000;
    L11:
        if ((r112 & 4) == 0) goto L13;
        r100 = 2000;
    L13:
        long r113 = r100;
        if ((r112 & 8) == 0) goto L16;
        int r114 = 15;
    L18:
        if ((r112 & 16) == 0) goto L20;
        boolean r115 = true;
    L22:
        if ((r112 & 32) == 0) goto L24;
        boolean r116 = true;
    L25:
        this(r101, r102, r113, r114, r115, r116);
        return;
    L24:
        r116 = r111;
        goto L25
    L20:
        r115 = r110;
        goto L22
    L16:
        r114 = 0;
        goto L18
    L9:
        r102 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L7
    }

    public g0(long r100, long r101, long r102, int r103, boolean r104, boolean r105) {
        this.f406748a = r100;
        this.f406749b = r101;
        this.f406750c = r102;
        this.f406751d = r103;
        this.f406752e = r104;
        this.f406753f = r105;
    }
}
