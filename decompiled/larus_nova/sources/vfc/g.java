package vfc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.mosaic.v2.MosaicViewV2;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MosaicViewV2 f554646a;

    public final void a() {
        MosaicViewV2 r100 = this.f554646a;
        r100.f449384u.set(r100.getImageRect());
        MosaicViewV2 r101 = this.f554646a;
        r101.f449381r.set(r101.f449384u);
        MosaicViewV2 r102 = this.f554646a;
        r102.f449372i = new RectF(0.0f, 0.0f, this.f554646a.f449384u.width(), this.f554646a.f449384u.height());
        MosaicViewV2 r103 = this.f554646a;
        r103.f449374k = Bitmap.createBitmap((int) r103.f449372i.width(), (int) this.f554646a.f449372i.height(), Bitmap.Config.ARGB_4444);
        MosaicViewV2 r104 = this.f554646a;
        r104.f449375l = new Canvas(this.f554646a.f449374k);
        MosaicViewV2 r105 = this.f554646a;
        r105.f449368e = Bitmap.createScaledBitmap(r105.f449367d, (int) r105.f449384u.width(), (int) this.f554646a.f449384u.height(), true);
        MosaicViewV2 r106 = this.f554646a;
        r106.f449369f = new Canvas(this.f554646a.f449368e);
        MosaicViewV2 r107 = this.f554646a;
        r107.f449370g = Bitmap.createBitmap(r107.f449368e);
        MosaicViewV2 r108 = this.f554646a;
        r108.f449371h = new Canvas(this.f554646a.f449370g);
        MosaicViewV2 r109 = this.f554646a;
        r109.setStrategy(r109.f449366c);
        MosaicViewV2.j(this.f554646a);
        this.f554646a.n();
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

    public g(MosaicViewV2 r100) {
        this.f554646a = r100;
    }
}
