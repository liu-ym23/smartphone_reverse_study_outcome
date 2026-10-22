package uc5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k2 extends com.bytedance.ee.bear.list.u {
    public k2() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final void f(DocumentListInfo r1, JSONObject r2) {
        super.f(r1, r2);
        if (hu5.a.d(r1.getDocumentList()) == false) goto L5;
        int r3 = 0;
    L6:
        r1.setTotal(r3);
        return;
    L5:
        r3 = r1.getDocumentList().size();
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.u
    public final Document d(JSONObject r1, JSONObject r2, JSONObject r3, boolean r4) {
        Document r5 = super.d(r1, r2, r3, true);
        if (r5 == null) goto L5;
        r5.t = "";
    L5:
        return r5;
    }
}
