package ok5;

import com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements CommonAttachmentPanel.e {
    public final /* synthetic */ gk5.a a;

    public k(p r1) {
        this.a = r1;
    }

    public final void a(String r4) {
        gk5.a r0 = this.a;
        JSONObject r1 = new JSONObject();
        if (r4 == null) goto L5;
        r1.put(ResourceData.KEY_TOKEN, r4);
    L5:
        r0.onSuccess(r1);
    }

    public final void b(int r2, String r3) {
        gk5.a r0 = this.a;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.onFailure(r2, r3);
    }
}
