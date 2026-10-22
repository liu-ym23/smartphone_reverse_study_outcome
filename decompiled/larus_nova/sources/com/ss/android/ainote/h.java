package com.ss.android.ainote;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f406755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f406756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f406757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f406758d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f406755a == r101.f406755a) goto L12;
        return false;
    L12:
        if (this.f406756b == r101.f406756b) goto L15;
        return false;
    L15:
        if (this.f406757c == r101.f406757c) goto L18;
        return false;
    L18:
        if (this.f406758d == r101.f406758d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f406755a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f406756b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f406757c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f406758d;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "AINoteCreateTime(clientCreateTimeMs=" + this.f406755a + ", createRelMeetingTimeMs=" + this.f406756b + ", createRelAudioTimeMs=" + this.f406757c + ", audioLocationTime=" + this.f406758d + ')';
    }

    public /* synthetic */ h(long r110, long r111, long r112) {
        this(r110, r111, r112, 0);
    }

    public h(long r100, long r101, long r102, long r103) {
        this.f406755a = r100;
        this.f406756b = r101;
        this.f406757c = r102;
        this.f406758d = r103;
    }
}
