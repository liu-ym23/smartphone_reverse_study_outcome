package x2a;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes32.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f562334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f562335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f562336c;

    public q() {
    }

    public final double b() {
        long r100 = this.f562334a;
        if (r100 > 0) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return this.f562335b / r100;
    }

    public final void a(double r100) {
        if (Double.isInfinite(r100) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return;
    L10:
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        this.f562334a++;
        this.f562335b += r100;
        this.f562336c = Math.max(this.f562336c, r100);
        return;
    L15:
        return;
    L5:
        if (Double.isNaN(r100) == true) goto L7;
        r101 = true;
        goto L8
    }
}
