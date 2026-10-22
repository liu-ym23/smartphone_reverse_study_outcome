package k95;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.Request;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.decode.ImageWrapper;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.ProgressivePhotoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Consumer<ImageWrapper<Object, Object>> {
    public final /* synthetic */ h a;

    public c(h r1) {
        this.a = r1;
    }

    public final void accept(Object r5) throws Exception {
        ImageWrapper r6 = (ImageWrapper) r5;
        if (this.a.c != null) goto L5;
        return;
    L5:
        if (r6.getType() != ImageWrapper.Type.DECODED) goto L18;
        Object r0 = this.a.c;
        o95.c<D> r1 = r6.b;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.b r2 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.b) r0;
        if (r6.a == false) goto L9;
        r2.getClass();
        r2.h = Request.Status.COMPLETE;
        r2.i.a.c = null;
    L9:
        r2.b();
        r2.j = r1;
        Object r7 = r2.e;
        if (r7 == null) goto L17;
        Object r3 = r1.get();
        ImageView r4 = ((p95.a) r2.b).a;
        ProgressivePhotoView.a r8 = (ProgressivePhotoView.a) r7;
        Bitmap r9 = (Bitmap) r3;
        ProgressivePhotoView r10 = r8.a;
        if (r10.e == true) goto L16;
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r11 = r10.d;
        if (r11 == null) goto L16;
        r11.a("progressive_image");
    L16:
        r8.a.e = true;
    L17:
        Object r12 = r2.b;
        Object r13 = r1.get();
        p95.a r14 = (p95.a) r12;
        r14.getClass();
        Bitmap r16 = (Bitmap) r13;
        tt5.a.h("ProgressiveImageLoader", "target set resource, resource = " + r16.toString());
        r14.a.setImageBitmap(r16);
        return;
    L18:
        Object r17 = this.a.c;
        o95.c<E> r18 = r6.c;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.b r19 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.b) r17;
        o95.c<E> r20 = r19.k;
        if (r20 == 0) goto L21;
        r20.recycle();
        r19.k = null;
    L21:
        r19.k = r18;
        Object r21 = r19.e;
        if (r21 == null) goto L29;
        ProgressivePhotoView.a r22 = (ProgressivePhotoView.a) r21;
        byte[] r23 = (byte[]) r18.get();
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r24 = r22.a.d;
        if (r24 == null) goto L26;
        r24.onCompleted();
    L26:
        PreviewViewModel r26 = r22.a.f;
        if (r26 == null) goto L29;
        r26.liveInnerSaveCache().postValue(r23);
    L29:
        r18.recycle();
    }
}
