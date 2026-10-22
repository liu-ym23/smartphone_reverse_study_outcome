package k95;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.Request;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.decode.ImageWrapper;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.ProgressivePhotoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Consumer<ImageWrapper<Object, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f502142a;

    public c(h r100) {
        this.f502142a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(ImageWrapper<Object, Object> r100) throws Exception {
        ImageWrapper<Object, Object> r101 = r100;
        if (this.f502142a.f502150c != null) goto L5;
        return;
    L5:
        if (r101.getType() != ImageWrapper.Type.DECODED) goto L18;
        Object r102 = this.f502142a.f502150c;
        o95.c r103 = r101.f224977b;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.b r104 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.b) r102;
        if (r101.f224976a == false) goto L9;
        r104.getClass();
        r104.f224930h = Request.Status.COMPLETE;
        r104.f224931i.f224922a.f502150c = null;
    L9:
        r104.b();
        r104.f224932j = r103;
        Object r105 = r104.f224927e;
        if (r105 == null) goto L17;
        Object r106 = r103.get();
        ImageView r107 = ((p95.a) r104.f224924b).f528303a;
        ProgressivePhotoView.a r108 = (ProgressivePhotoView.a) r105;
        Bitmap r109 = (Bitmap) r106;
        ProgressivePhotoView r110 = r108.f225033a;
        if (r110.f225030e == true) goto L16;
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r111 = r110.f225029d;
        if (r111 == null) goto L16;
        r111.a("progressive_image");
    L16:
        r108.f225033a.f225030e = true;
    L17:
        Object r112 = r104.f224924b;
        Object r113 = r103.get();
        p95.a r114 = (p95.a) r112;
        r114.getClass();
        Bitmap r115 = (Bitmap) r113;
        tt5.a.h("ProgressiveImageLoader", "target set resource, resource = " + r115.toString());
        r114.f528303a.setImageBitmap(r115);
        return;
    L18:
        Object r116 = this.f502142a.f502150c;
        o95.c r117 = r101.f224978c;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.b r118 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.b) r116;
        o95.c<E> r119 = r118.f224933k;
        if (r119 == 0) goto L21;
        r119.recycle();
        r118.f224933k = null;
    L21:
        r118.f224933k = r117;
        Object r120 = r118.f224927e;
        if (r120 == null) goto L29;
        ProgressivePhotoView.a r121 = (ProgressivePhotoView.a) r120;
        byte[] r122 = (byte[]) r117.get();
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r123 = r121.f225033a.f225029d;
        if (r123 == null) goto L26;
        r123.onCompleted();
    L26:
        PreviewViewModel r124 = r121.f225033a.f225031f;
        if (r124 == null) goto L29;
        r124.liveInnerSaveCache().postValue(r122);
    L29:
        r117.recycle();
    }
}
