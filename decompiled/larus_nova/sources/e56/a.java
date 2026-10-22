package e56;

import android.graphics.RectF;
import androidx.camera.video.AudioStats;
import com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouch;
import com.bytedance.ies.uikit.imageview.imagezoom.ImageViewTouchBase;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f471054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f471055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double f471056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f471057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ double f471058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ double f471059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ImageViewTouchBase f471060g;

    public final void a() {
        double r100 = Math.min(this.f471056c, System.currentTimeMillis() - this.f471057d);
        f56.a r101 = this.f471060g.f248983a;
        double r102 = this.f471058e;
        double r103 = this.f471056c;
        r101.getClass();
        double r104 = (r100 / r103) - 1.0d;
        double r105 = (r102 * (((r104 * r104) * r104) + 1.0d)) + AudioStats.AUDIO_AMPLITUDE_NONE;
        f56.a r106 = this.f471060g.f248983a;
        double r107 = this.f471059f;
        double r110 = this.f471056c;
        r106.getClass();
        double r111 = (r100 / r110) - 1.0d;
        double r108 = (r107 * (((r111 * r111) * r111) + 1.0d)) + AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f471060g.m(r105 - this.f471054a, r108 - this.f471055b);
        this.f471054a = r105;
        this.f471055b = r108;
        if (r100 >= this.f471056c) goto L5;
        this.f471060g.f248986d.post(this);
        return;
    L5:
        ImageViewTouchBase r109 = this.f471060g;
        RectF r112 = r109.d(r109.f248985c);
        float r113 = r112.left;
        if (r113 == 0.0f) goto L8;
    L9:
        this.f471060g.m(r113, r112.top);
        return;
    L8:
        if (r112.top != 0.0f) goto L9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(ImageViewTouch r100, long r101, double r102, double r103) {
        this.f471060g = r100;
        this.f471056c = 300.0d;
        this.f471057d = r101;
        this.f471058e = r102;
        this.f471059f = r103;
        this.f471054a = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f471055b = AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
