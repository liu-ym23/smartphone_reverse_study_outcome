package rm5;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements com.bytedance.ee.bear.share.export.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o.b f538564a;

    @Override // com.bytedance.ee.bear.share.export.m
    public final void onSuccess() {
        o.b r100 = this.f538564a;
        if (r100 == null) goto L6;
        r100.onSuccess();
        return;
    }

    public m(ShareType r100) {
        this.f538564a = null;
    }

    @Override // com.bytedance.ee.bear.share.export.m
    public final void onFailed(String r100) {
        o.b r101 = this.f538564a;
        if (r101 == null) goto L6;
        r101.onFail(r100);
        return;
    }
}
