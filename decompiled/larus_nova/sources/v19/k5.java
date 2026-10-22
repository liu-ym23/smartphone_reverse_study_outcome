package v19;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes27.dex */
public class k5 implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f552575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f552576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f552577c;

    public static final class a {
        public static double a(double r110, double r111, double r112) {
            double r100 = ((double) 1) - r110;
            double r101 = r110 * r110;
            double r102 = r100 * r100;
            double r113 = 3;
            return ((((r102 * r100) * AudioStats.AUDIO_AMPLITUDE_NONE) + (((r102 * r113) * r110) * r111)) + (((r113 * r100) * r101) * r112)) + ((r101 * r110) * 1.0d);
        }
    }

    static {
    }

    public k5() {
        this.f552576b = new PointF();
        this.f552577c = new PointF();
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        int r101 = this.f552575a;
        float r102 = r100;
    L4:
        if (r101 >= 4096) goto L9;
        r102 = (r101 * 1.0f) / 4096;
        if (a.a(r102, this.f552576b.x, this.f552577c.x) >= r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        this.f552575a = r101;
    L9:
        double r103 = a.a(r102, this.f552576b.y, this.f552577c.y);
        if (r103 <= 0.999d) goto L13;
        this.f552575a = 0;
        r103 = 1.0d;
    L13:
        return (float) r103;
    }
}
