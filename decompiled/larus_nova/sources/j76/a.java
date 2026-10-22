package j76;

import androidx.camera.video.AudioStats;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f497585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f497586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f497587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f497588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f497589e;

    public final float a() {
        double r100 = this.f497589e;
        if (this.f497587c <= 0) goto L5;
        double r101 = ArraysKt.sum(this.f497586b);
        double r102 = this.f497589e;
        int r103 = this.f497588d;
        r100 = (r101 + (r102 * ((double) (r103 - this.f497587c)))) / ((double) r103);
    L5:
        this.f497585a = 0;
        boolean r104 = false;
        this.f497587c = 0;
        this.f497588d = 0;
        this.f497589e = AudioStats.AUDIO_AMPLITUDE_NONE;
        float r105 = (float) r100;
        if (r105 != 0.0f) goto L8;
        r104 = true;
    L8:
        if (r104 == false) goto L11;
        return 0.0f;
    L11:
        return 1000000000 / r105;
    }

    public a() {
        this.f497586b = new long[100];
    }
}
