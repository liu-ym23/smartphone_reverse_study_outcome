package g46;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes19.dex */
public class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f480001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f480002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f480003c;

    public static double a(double r110, double r111, double r112) {
        double r100 = 1.0d - r110;
        double r101 = r110 * r110;
        double r102 = r100 * r100;
        return ((((r102 * r100) * AudioStats.AUDIO_AMPLITUDE_NONE) + (((r102 * 3.0d) * r110) * r111)) + (((r100 * 3.0d) * r101) * r112)) + ((r101 * r110) * 1.0d);
    }

    public a() {
        this.f480001a = 0;
        this.f480002b = new PointF();
        this.f480003c = new PointF();
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        int r101 = this.f480001a;
        float r102 = r100;
    L4:
        if (r101 >= 4096) goto L9;
        r102 = (r101 * 1.0f) / 4096.0f;
        if (a(r102, this.f480002b.x, this.f480003c.x) >= r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        this.f480001a = r101;
    L9:
        double r103 = a(r102, this.f480002b.y, this.f480003c.y);
        if (r103 <= 0.999d) goto L13;
        this.f480001a = 0;
        r103 = 1.0d;
    L13:
        return (float) r103;
    }
}
