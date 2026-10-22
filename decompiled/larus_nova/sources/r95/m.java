package r95;

import com.bytedance.ee.bear.drive.view.preview.imageviewer.PhotoViewContainer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class m implements bm5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoViewContainer f536724a;

    public /* synthetic */ m(PhotoViewContainer r100) {
        this.f536724a = r100;
    }

    public final void a(float r100, float r101) {
        PhotoViewContainer r102 = this.f536724a;
        PreviewViewModel r103 = r102.f225009f;
        if (r103 == null) goto L10;
        float r104 = r101 - r100;
        if (r104 >= 0.0f) goto L8;
        r103.liveInnerReportMsg().a(new a0(17));
        goto L10
    L8:
        if (r104 <= 0.0f) goto L10;
        r103.liveInnerReportMsg().a(new a0(18));
    L10:
        r102.e();
    }
}
