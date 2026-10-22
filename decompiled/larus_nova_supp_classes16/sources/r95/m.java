package r95;

import com.bytedance.ee.bear.drive.view.preview.imageviewer.PhotoViewContainer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class m implements bm5.b {
    public final /* synthetic */ PhotoViewContainer a;

    public /* synthetic */ m(PhotoViewContainer r1) {
        this.a = r1;
    }

    public final void a(float r4, float r5) {
        PhotoViewContainer r0 = this.a;
        PreviewViewModel r1 = r0.f;
        if (r1 == null) goto L10;
        float r6 = r5 - r4;
        if (r6 >= 0.0f) goto L8;
        r1.liveInnerReportMsg().a(new a0(17));
        goto L10
    L8:
        if (r6 <= 0.0f) goto L10;
        r1.liveInnerReportMsg().a(new a0(18));
    L10:
        r0.e();
    }
}
