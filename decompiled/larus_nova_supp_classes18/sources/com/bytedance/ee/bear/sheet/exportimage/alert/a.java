package com.bytedance.ee.bear.sheet.exportimage.alert;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import io.reactivex.functions.Consumer;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ScreenshotImageAlertFragment a;
    public final /* synthetic */ ShareItemModel b;

    public a(ScreenshotImageAlertFragment r1, ShareItemModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        File r7 = (File) r6;
        int r0 = ScreenshotImageAlertFragment.w;
        tt5.a.d("ScreenshotImageAlertFragment", "handleCustomShare, getImageInner success");
        ScreenshotImageAlertFragment r1 = this.a;
        ShareItemModel r2 = this.b;
        Intrinsics.checkNotNull(r7);
        ScreenshotImageAlertViewModel r3 = r1.i;
        if (r3 == null) goto L5;
        boolean r8 = r3.doShareToCustom(r2, r7);
    L6:
        tt5.a.h("ScreenshotImageAlertFragment", "doShareImageToCustom, consumed: " + r8 + ", shareType: " + r2.getSrcTint());
        if (r8 == true) goto L15;
        ShareType r9 = r2.getType();
        if (r9 == null) goto L16;
        ScreenshotImageAlertViewModel r4 = r1.i;
        if (r4 == null) goto L13;
        r4.onShareToExternalApp(r9);
    L13:
        r1.da0(r9);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r8 = false;
        goto L6
    }
}
