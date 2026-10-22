package com.bytedance.ee.bear.sheet.exportimage.alert;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import io.reactivex.functions.Consumer;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotImageAlertFragment f237508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShareItemModel f237509b;

    public a(ScreenshotImageAlertFragment r100, ShareItemModel r101) {
        this.f237508a = r100;
        this.f237509b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        File r101 = (File) r100;
        int r102 = ScreenshotImageAlertFragment.f237478w;
        tt5.a.d("ScreenshotImageAlertFragment", "handleCustomShare, getImageInner success");
        ScreenshotImageAlertFragment r103 = this.f237508a;
        ShareItemModel r104 = this.f237509b;
        Intrinsics.checkNotNull(r101);
        ScreenshotImageAlertViewModel r105 = r103.f237480i;
        if (r105 == null) goto L5;
        boolean r106 = r105.doShareToCustom(r104, r101);
    L6:
        tt5.a.h("ScreenshotImageAlertFragment", "doShareImageToCustom, consumed: " + r106 + ", shareType: " + r104.getSrcTint());
        if (r106 == true) goto L15;
        ShareType r107 = r104.getType();
        if (r107 == null) goto L16;
        ScreenshotImageAlertViewModel r108 = r103.f237480i;
        if (r108 == null) goto L13;
        r108.onShareToExternalApp(r107);
    L13:
        r103.da0(r107);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r106 = false;
        goto L6
    }
}
