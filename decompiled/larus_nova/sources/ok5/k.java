package ok5;

import com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements CommonAttachmentPanel.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gk5.a f523676a;

    public k(p r100) {
        this.f523676a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel.e
    public final void a(String r100) {
        gk5.a r101 = this.f523676a;
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L5;
        r102.put("token", r100);
    L5:
        r101.onSuccess(r102);
    }

    @Override // com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel.e
    public final void b(int r100, String r101) {
        gk5.a r102 = this.f523676a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.onFailure(r100, r101);
    }
}
