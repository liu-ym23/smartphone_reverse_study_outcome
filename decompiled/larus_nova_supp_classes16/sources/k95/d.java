package k95;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.Request;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.ProgressivePhotoView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Consumer<Throwable> {
    public final /* synthetic */ h a;

    public d(h r1) {
        this.a = r1;
    }

    public final void accept(Object r5) throws Exception {
        Throwable r6 = (Throwable) r5;
        h r0 = this.a;
        r0.a.a(r0.f);
        Object r1 = this.a.c;
        if (r1 == null) goto L10;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.b r2 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.b) r1;
        r2.h = Request.Status.FAILED;
        r2.i.a.c = null;
        Object r3 = r2.e;
        if (r3 == null) goto L11;
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r4 = ((ProgressivePhotoView.a) r3).a.d;
        if (r4 == null) goto L12;
        r4.b("progressive_image", r6, true, false);
        return;
    L12:
        return;
    L11:
        return;
    }
}
