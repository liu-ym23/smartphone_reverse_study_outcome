package r95;

import android.graphics.RectF;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.PhotoViewContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class l implements bm5.a {
    public final /* synthetic */ PhotoViewContainer a;

    public /* synthetic */ l(PhotoViewContainer r1) {
        this.a = r1;
    }

    public final void a(RectF r6) {
        PhotoViewContainer r0 = this.a;
        float r1 = r0.i.getMinimumScale();
        float r2 = 1.0f;
        if (r1 > 0.0f) goto L5;
        r1 = 1.0f;
    L5:
        float r4 = r0.i.getScale();
        if (r4 <= 0.0f) goto L9;
        r2 = r4;
    L9:
        r0.d.e(r6, r2 / r1);
        r0.e();
    }
}
