package gl3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes14.dex */
public class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f481581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f481582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f481583c;

    public static double a(double r110, double r111, double r112) {
        double r100 = 1.0d - r110;
        double r101 = r110 * r110;
        double r102 = r100 * r100;
        return ((((r102 * r100) * AudioStats.AUDIO_AMPLITUDE_NONE) + (((r102 * 3.0d) * r110) * r111)) + (((r100 * 3.0d) * r101) * r112)) + ((r101 * r110) * 1.0d);
    }

    public a() {
        this.f481581a = 0;
        this.f481582b = new PointF();
        this.f481583c = new PointF();
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        int r101 = this.f481581a;
        float r102 = r100;
    L4:
        if (r101 >= 4096) goto L9;
        r102 = (r101 * 1.0f) / 4096.0f;
        if (a(r102, this.f481582b.x, this.f481583c.x) >= r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        this.f481581a = r101;
    L9:
        double r103 = a(r102, this.f481582b.y, this.f481583c.y);
        if (r103 <= 0.999d) goto L13;
        this.f481581a = 0;
        r103 = 1.0d;
    L13:
        return (float) r103;
    }
}
