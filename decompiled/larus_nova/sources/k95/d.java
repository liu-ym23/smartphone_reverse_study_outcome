package k95;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.Request;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.ProgressivePhotoView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f502143a;

    public d(h r100) {
        this.f502143a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Throwable r101 = r100;
        h r102 = this.f502143a;
        r102.f502148a.a(r102.f502153f);
        Object r103 = this.f502143a.f502150c;
        if (r103 == null) goto L10;
        com.bytedance.ee.bear.drive.view.preview.image.progressloader.b r104 = (com.bytedance.ee.bear.drive.view.preview.image.progressloader.b) r103;
        r104.f224930h = Request.Status.FAILED;
        r104.f224931i.f224922a.f502150c = null;
        Object r105 = r104.f224927e;
        if (r105 == null) goto L11;
        com.bytedance.ee.bear.drive.view.preview.imageviewer.b r106 = ((ProgressivePhotoView.a) r105).f225033a.f225029d;
        if (r106 == null) goto L12;
        r106.b("progressive_image", r101, true, false);
        return;
    L12:
        return;
    L11:
        return;
    }
}
