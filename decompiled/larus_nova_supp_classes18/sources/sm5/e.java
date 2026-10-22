package sm5;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertFragment;
import com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertViewModel;
import rm5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements o.b {
    public final /* synthetic */ ScreenshotImageAlertFragment a;

    @Override // rm5.o.b
    public final void onFail(String r1) {
    }

    @Override // rm5.o.b
    public final void onSuccess() {
        ScreenshotImageAlertViewModel r0 = this.a.i;
        if (r0 == null) goto L6;
        r0.onShareSuccess(ShareType.Download);
        return;
    }

    public e(ScreenshotImageAlertFragment r1) {
        this.a = r1;
    }
}
