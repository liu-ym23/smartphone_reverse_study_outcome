package vb1;

import android.graphics.RectF;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.uikit.imageview.imagezoom.ImageViewTouch;
import com.bytedance.android.live.uikit.imageview.imagezoom.ImageViewTouchBase;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f554004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f554005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double f554006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f554007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ double f554008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ double f554009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ImageViewTouchBase f554010g;

    public final void a() {
        double r100 = Math.min(this.f554006c, System.currentTimeMillis() - this.f554007d);
        wb1.a r101 = this.f554010g.f102221a;
        double r102 = this.f554008e;
        double r103 = this.f554006c;
        r101.getClass();
        double r104 = (r100 / r103) - 1.0d;
        double r105 = (r102 * (((r104 * r104) * r104) + 1.0d)) + AudioStats.AUDIO_AMPLITUDE_NONE;
        wb1.a r106 = this.f554010g.f102221a;
        double r107 = this.f554009f;
        double r110 = this.f554006c;
        r106.getClass();
        double r111 = (r100 / r110) - 1.0d;
        double r108 = (r107 * (((r111 * r111) * r111) + 1.0d)) + AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f554010g.m(r105 - this.f554004a, r108 - this.f554005b);
        this.f554004a = r105;
        this.f554005b = r108;
        if (r100 >= this.f554006c) goto L5;
        this.f554010g.f102224d.post(this);
        return;
    L5:
        ImageViewTouchBase r109 = this.f554010g;
        RectF r112 = r109.d(r109.f102223c);
        float r113 = r112.left;
        if (r113 == 0.0f) goto L8;
    L9:
        this.f554010g.m(r113, r112.top);
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
        this.f554010g = r100;
        this.f554006c = 300.0d;
        this.f554007d = r101;
        this.f554008e = r102;
        this.f554009f = r103;
        this.f554004a = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f554005b = AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
