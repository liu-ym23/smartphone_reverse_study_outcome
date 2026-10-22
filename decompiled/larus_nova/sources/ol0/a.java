package ol0;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements IMiddlewareHostBusiness.TemplateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d8a.b.a f524115a;

    public a(d8a.b.a r100) {
        this.f524115a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.TemplateCallback
    public final void onFailed(String r100) {
        d8a.b.a r101 = this.f524115a;
        if (r101 == null) goto L6;
        r101.onFailed(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.TemplateCallback
    public final void onSuccess(byte[] r100) {
        d8a.b.a r101 = this.f524115a;
        if (r101 == null) goto L6;
        r101.onSuccess(r100);
        return;
    }
}
