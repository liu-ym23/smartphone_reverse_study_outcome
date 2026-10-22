package vfc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.mosaic.v2.MosaicPhotoEditorPluginV2;
import com.ss.android.photoeditor.mosaic.v2.MosaicViewV2;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f554642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MosaicViewV2 f554643b;

    public class a extends pfc.g.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f554644a;

        public a(f r100) {
            this.f554644a = r100;
        }

        @Override // pfc.g.d
        public final void a(RectF r100) {
            this.f554644a.f554643b.f449381r.set(r100);
            MosaicViewV2 r101 = this.f554644a.f554643b;
            r101.f449372i.set(0.0f, 0.0f, r101.f449384u.width(), this.f554644a.f554643b.f449384u.height());
            this.f554644a.f554643b.invalidate();
        }
    }

    public class b implements pfc.g.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f554645a;

        public b(f r100) {
            this.f554645a = r100;
        }

        @Override // pfc.g.e
        public final void a(MotionEvent r100) {
            if (this.f554645a.f554643b.f449366c == null) goto L6;
            sfc.a.f541747a.getClass();
            sfc.a.f541749c = true;
            this.f554645a.f554643b.f449366c.b(r100);
            return;
        }
    }

    public final void a() {
        MosaicViewV2 r100 = this.f554643b;
        r100.f449384u = r100.getImageRect();
        MosaicViewV2 r101 = this.f554643b;
        r101.f449381r = new RectF(this.f554643b.f449384u);
        MosaicViewV2 r102 = this.f554643b;
        r102.f449372i = new RectF(0.0f, 0.0f, this.f554643b.f449384u.width(), this.f554643b.f449384u.height());
        MosaicViewV2 r103 = this.f554643b;
        r103.f449368e = Bitmap.createScaledBitmap(r103.f449367d, (int) r103.f449384u.width(), (int) this.f554643b.f449384u.height(), true);
        MosaicViewV2 r104 = this.f554643b;
        r104.f449369f = new Canvas(this.f554643b.f449368e);
        MosaicViewV2 r105 = this.f554643b;
        r105.f449370g = Bitmap.createBitmap(r105.f449368e);
        MosaicViewV2 r106 = this.f554643b;
        r106.f449371h = new Canvas(this.f554643b.f449370g);
        MosaicViewV2 r107 = this.f554643b;
        r107.f449383t = new pfc.g(r107.f449384u, r107.f449381r, new a(this), new b(this));
        this.f554643b.f449385v = true;
        Runnable r108 = this.f554642a;
        if (r108 == null) goto L5;
        r108.run();
    L5:
        pfc.f.b r109 = pfc.f.i().d();
        MosaicViewV2 r110 = this.f554643b;
        vfc.a r111 = new vfc.a();
        r110.f449373j = r111;
        r111.f554632a = new RectF(r109.f529058a);
        vfc.a r112 = this.f554643b.f449373j;
        r112.f554633b = new RectF(r109.f529059b);
        vfc.a r113 = this.f554643b.f449373j;
        r113.f554634c = r109.f529060c;
        r113.f554635d = new RectF(this.f554643b.f449372i);
        this.f554643b.n();
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

    public f(MosaicViewV2 r100, MosaicPhotoEditorPluginV2.b r101) {
        this.f554643b = r100;
        this.f554642a = r101;
    }
}
