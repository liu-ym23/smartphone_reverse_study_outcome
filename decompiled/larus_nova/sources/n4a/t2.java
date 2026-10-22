package n4a;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes32.dex */
public class t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f517747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f517748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f517749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f517750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f517751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f517752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f517753g;

    public t2() {
        this.f517747a = 0;
        this.f517748b = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517749c = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517750d = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f517751e = 0.0f;
        this.f517752f = 0.0f;
        this.f517753g = 0.0f;
    }

    public final double a(u2 r110) {
        if (r110 == null) goto L5;
        double r100 = this.f517749c;
        double r101 = this.f517748b;
        double r102 = r110.f517749c;
        double r103 = r110.f517748b;
        double r111 = (((90.0d - r101) * 21412.0d) / 90.0d) + 6356725.0d;
        double r104 = (r102 * 0.01745329238474369d) - (r100 * 0.01745329238474369d);
        double r105 = r104 * (Math.cos((3.1415927410125732d * r101) / 180.0d) * r111);
        double r106 = ((r103 * 0.01745329238474369d) - (r101 * 0.01745329238474369d)) * r111;
        return Math.pow((r105 * r105) + (r106 * r106), 0.5d);
    L5:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
