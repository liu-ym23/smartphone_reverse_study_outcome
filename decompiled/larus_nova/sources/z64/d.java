package z64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f570459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f570461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f570462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f570463e;

    public final int hashCode() {
        String r100 = this.f570459a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f570460b) * 31;
        String r104 = this.f570461c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f570462d;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f570463e;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BadgerRequestImpl(challengeKey=" + this.f570459a + ", sceneId=" + this.f570460b + ", deviceId=" + this.f570461c + ", timestamp=" + this.f570462d + ", triggerPath=" + this.f570463e + ")";
    }

    @Override // z64.c
    public final String a() {
        return this.f570463e;
    }

    @Override // z64.c
    public final String b() {
        return this.f570459a;
    }

    @Override // z64.c
    public final String getDeviceId() {
        return this.f570461c;
    }

    @Override // z64.c
    public final int getSceneId() {
        return this.f570460b;
    }

    @Override // z64.c
    public final long getTimestamp() {
        return this.f570462d;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L24:
        return true;
    L5:
        if ((r100 instanceof d) == false) goto L23;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f570459a, r101.f570459a) == false) goto L23;
        if (this.f570460b != r101.f570460b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L23;
        if (Intrinsics.areEqual(this.f570461c, r101.f570461c) == false) goto L23;
        if (this.f570462d != r101.f570462d) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L23;
        if (Intrinsics.areEqual(this.f570463e, r101.f570463e) == false) goto L23;
    L18:
        r103 = false;
        goto L19
    L11:
        r102 = false;
    L23:
        return false;
    }

    public d(String r100, int r101, String r102, String r103, int r104) {
        if ((r104 & 8) == 0) goto L5;
        long r105 = System.currentTimeMillis();
    L7:
        if ((r104 & 16) == 0) goto L9;
        r103 = "";
    L9:
        this.f570459a = r100;
        this.f570460b = r101;
        this.f570461c = r102;
        this.f570462d = r105;
        this.f570463e = r103;
        return;
    L5:
        r105 = 0;
        goto L7
    }
}
