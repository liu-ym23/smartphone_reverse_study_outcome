package com.bytedance.ee.bear.imageviewer;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f3 implements Observer<c3.g> {
    public final /* synthetic */ DownloadRequestInfo.DownloadType a;
    public final /* synthetic */ LargeImageView b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ImageData.Image e;
    public final /* synthetic */ FrameLayout f;
    public final /* synthetic */ c3 g;

    public final void onChanged(Object r16) {
        c3.g r17 = (c3.g) r16;
        if (r17 == null) goto L18;
        int r0 = r17.a;
        if (r0 != 1) goto L7;
        this.g.u.setEnabled(false);
        return;
    L7:
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L22;
        this.g.L(ay4.d.a().z(r17.b), this.b, this.e, this.f);
        return;
    L22:
        return;
    L13:
        if (this.a != DownloadRequestInfo.DownloadType.IMG) goto L15;
        this.g.q(this.b, this.c, this.d, DownloadRequestInfo.DownloadType.COVER, this.e, this.f);
        return;
    L15:
        c3.c(this.g, this.c, this.d, this.b, this.e, this.f);
        return;
    }

    public f3(c3 r1, DownloadRequestInfo.DownloadType r2, LargeImageView r3, String r4, String r5, ImageData.Image r6, FrameLayout r7) {
        this.g = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
