package cq9;

import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f465017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f465018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f465019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f465020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f465021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f465022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f465023g;

    public a() {
        this(0, 0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f465017a == r101.f465017a) goto L12;
        return false;
    L12:
        if (this.f465018b == r101.f465018b) goto L15;
        return false;
    L15:
        if (this.f465019c == r101.f465019c) goto L18;
        return false;
    L18:
        if (this.f465020d == r101.f465020d) goto L21;
        return false;
    L21:
        if (Double.compare(this.f465021e, r101.f465021e) == 0) goto L24;
        return false;
    L24:
        if (Double.compare(this.f465022f, r101.f465022f) == 0) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f465023g, r101.f465023g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f465017a * 31) + this.f465018b) * 31) + this.f465019c) * 31) + this.f465020d) * 31;
        long r101 = Double.doubleToLongBits(this.f465021e);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f465022f);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Integer r105 = this.f465023g;
        if (r105 != null) goto L5;
        int r106 = 0;
    L7:
        return r104 + r106;
    L5:
        r106 = r105.hashCode();
        goto L7
    }

    public final String toString() {
        return "CreationMultiReferenceLogSummary(imageCount=" + this.f465017a + ", videoCount=" + this.f465018b + ", audioCount=" + this.f465019c + ", unknownCount=" + this.f465020d + ", videoDurationSeconds=" + this.f465021e + ", audioDurationSeconds=" + this.f465022f + ", entityCount=" + this.f465023g + ')';
    }

    public /* synthetic */ a(int r110, int r111, int r112, int r113, double r114, double r115, int r210) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r210 & 16) == 0) goto L21;
        double r104 = 0.0d;
    L23:
        if ((r210 & 32) == 0) goto L25;
        double r105 = 0.0d;
    L26:
        this(r100, r101, r102, r103, r104, r105, null);
        return;
    L25:
        r105 = r115;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public a(int r100, int r101, int r102, int r103, double r104, double r105, Integer r106) {
        this.f465017a = r100;
        this.f465018b = r101;
        this.f465019c = r102;
        this.f465020d = r103;
        this.f465021e = r104;
        this.f465022f = r105;
        this.f465023g = r106;
    }
}
