package rm5;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.sheet.exportimage.preview.SheetImagePreviewPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements com.bytedance.ee.bear.share.export.m {
    public final /* synthetic */ o.b a;

    @Override // com.bytedance.ee.bear.share.export.m
    public final void onSuccess() {
        o.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSuccess();
        return;
    }

    @Override // com.bytedance.ee.bear.share.export.m
    public final void onFailed(String r2) {
        o.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFail(r2);
        return;
    }

    public n(SheetImagePreviewPlugin.t r1, ShareType r2) {
        this.a = r1;
    }
}
