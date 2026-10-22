package r95;

import android.graphics.BitmapFactory;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ h.a a;

    public /* synthetic */ g(h.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.a r0 = this.a;
        View r1 = (View) r0.a.getParent();
        h r2 = r0.a;
        BitmapFactory.Options r3 = r2.G2.e;
        r0.a.setDrivePhotoViewDoubleTapZoomScale(i75.m.a(r1.getHeight(), r1.getWidth(), r3.outHeight * r2.getMinScale(), r3.outWidth * r0.a.getMinScale()));
        r0.a.setDoubleTapZoomDuration(200);
        r0.a.a(1.0f, false);
    }
}
