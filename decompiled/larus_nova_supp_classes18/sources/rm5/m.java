package rm5;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements com.bytedance.ee.bear.share.export.m {
    public final /* synthetic */ o.b a;

    @Override // com.bytedance.ee.bear.share.export.m
    public final void onSuccess() {
        o.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSuccess();
        return;
    }

    public m(ShareType r1) {
        this.a = null;
    }

    @Override // com.bytedance.ee.bear.share.export.m
    public final void onFailed(String r2) {
        o.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFail(r2);
        return;
    }
}
