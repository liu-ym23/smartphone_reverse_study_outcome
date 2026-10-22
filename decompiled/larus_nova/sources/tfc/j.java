package tfc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.mosaic.MosaicView;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f545827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MosaicView f545828b;

    public final void a() {
        MosaicView r100 = this.f545828b;
        r100.f449296k.set(r100.getImageRect());
        MosaicView r101 = this.f545828b;
        r101.f449293h.set(r101.f449296k);
        MosaicView r102 = this.f545828b;
        r102.f449290e = r102.j(this.f545827a);
        MosaicView r103 = this.f545828b;
        r103.f449291f = new Canvas(this.f545828b.f449290e);
        MosaicView r104 = this.f545828b;
        r104.setStrategy(r104.f449288c);
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

    public j(MosaicView r100, Bitmap r101) {
        this.f545828b = r100;
        this.f545827a = r101;
    }
}
