package tfc;

import android.graphics.Canvas;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.mosaic.MosaicView;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MosaicView f545826a;

    public final void a() {
        MosaicView r100 = this.f545826a;
        r100.f449296k.set(r100.getImageRect());
        MosaicView r101 = this.f545826a;
        r101.f449293h.set(r101.f449296k);
        MosaicView r102 = this.f545826a;
        r102.f449290e = r102.j(r102.f449289d);
        MosaicView r103 = this.f545826a;
        r103.f449291f = new Canvas(this.f545826a.f449290e);
        MosaicView r104 = this.f545826a;
        r104.setStrategy(r104.f449288c);
        this.f545826a.l();
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

    public i(MosaicView r100) {
        this.f545826a = r100;
    }
}
