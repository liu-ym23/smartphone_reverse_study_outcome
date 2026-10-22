package uc5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class k2 extends com.bytedance.ee.bear.list.u {
    public k2() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final void f(DocumentListInfo r100, JSONObject r101) {
        super.f(r100, r101);
        if (hu5.a.d(r100.getDocumentList()) == false) goto L5;
        int r102 = 0;
    L6:
        r100.setTotal(r102);
        return;
    L5:
        r102 = r100.getDocumentList().size();
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.u
    public final Document d(JSONObject r100, JSONObject r101, JSONObject r102, boolean r103) {
        Document r104 = super.d(r100, r101, r102, true);
        if (r104 == null) goto L5;
        r104.f227898t = "";
    L5:
        return r104;
    }
}
