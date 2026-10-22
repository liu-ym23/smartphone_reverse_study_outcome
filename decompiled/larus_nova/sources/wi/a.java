package wi;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f559728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f559729b;

    public a() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public final String toString() {
        return "lat=" + this.f559728a + ",long=" + this.f559729b;
    }

    public a(double r100, double r101) {
        this.f559728a = r100;
        this.f559729b = r101;
    }
}
