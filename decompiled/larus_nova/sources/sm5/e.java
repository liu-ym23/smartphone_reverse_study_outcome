package sm5;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertFragment;
import com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertViewModel;
import rm5.o;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements o.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotImageAlertFragment f542578a;

    @Override // rm5.o.b
    public final void onFail(String r100) {
    }

    @Override // rm5.o.b
    public final void onSuccess() {
        ScreenshotImageAlertViewModel r100 = this.f542578a.f237480i;
        if (r100 == null) goto L6;
        r100.onShareSuccess(ShareType.Download);
        return;
    }

    public e(ScreenshotImageAlertFragment r100) {
        this.f542578a = r100;
    }
}
