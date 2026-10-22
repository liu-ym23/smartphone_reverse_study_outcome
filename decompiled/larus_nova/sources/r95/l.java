package r95;

import android.graphics.RectF;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.PhotoViewContainer;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class l implements bm5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoViewContainer f536723a;

    public /* synthetic */ l(PhotoViewContainer r100) {
        this.f536723a = r100;
    }

    public final void a(RectF r100) {
        PhotoViewContainer r101 = this.f536723a;
        float r102 = r101.f225012i.getMinimumScale();
        float r103 = 1.0f;
        if (r102 > 0.0f) goto L5;
        r102 = 1.0f;
    L5:
        float r104 = r101.f225012i.getScale();
        if (r104 <= 0.0f) goto L9;
        r103 = r104;
    L9:
        r101.f225007d.e(r100, r103 / r102);
        r101.e();
    }
}
