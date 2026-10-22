package uc5;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f1 extends com.bytedance.ee.bear.list.u {
    public final String c;

    public f1(String r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.list.u
    public final void c(DocumentListInfo r10, JSONObject r11) {
        if (r10 == null) goto L25;
        if (r11 == null) goto L25;
        JSONObject r12 = r11.optJSONObject("entities");
        JSONObject r1 = r12.optJSONObject("nodes");
        JSONObject r13 = r12.optJSONObject(OperationName.OPERATION_OFFLINE_AVAILABLE);
        HashMap<String, Document> r2 = null;
        if (r13 != null) goto L27;
        tt5.a.h("FolderListParser", "parseOfflineList()... offlineNode is null ");
    L23:
        r10.setFakeTokenMap(r2);
        return;
    L27:
        HashMap<String, Document> r4 = new HashMap();     // Catch: Exception -> L19 JSONException -> L21
        Iterator<String> r5 = r13.keys();     // Catch: Exception -> L19 JSONException -> L21
    L11:
        if (r5.hasNext() == false) goto L18;
        String r6 = r5.next();     // Catch: Exception -> L19 JSONException -> L21
        Document r7 = d(JSONObjectProtectorUtils.getJSONObject(r1, r13.optString(r6)), null, null, true);     // Catch: Exception -> L19 JSONException -> L21
        if (r7 == null) goto L15;
        r7.u = r6;     // Catch: Exception -> L19 JSONException -> L21
        r4.put(r6, r7);     // Catch: Exception -> L19 JSONException -> L21
        goto L11
    L15:
        tt5.a.d("FolderListParser", "parseOfflineList: documentObj is null");     // Catch: Exception -> L19 JSONException -> L21
        goto L11
    L18:
        r2 = r4;
        goto L23
    L21:
        e = move-exception;
        tt5.a.e("FolderListParser", "parseOfflineList:", e, false);
    L19:
        e = move-exception;
        tt5.a.e("FolderListParser", "parseOfflineList: ", e, false);
    L25:
        tt5.a.h("FolderListParser", "parseCustomData()... null");
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo e(DocumentListInfo r6, JSONObject r7) {
        DocumentListInfo r8 = super.e(r6, r7);
        JSONObject r9 = r7.optJSONObject("entities");
        JSONObject r0 = r9.optJSONObject("nodes");
        JSONObject r10 = r9.optJSONObject("users");
        Document r3 = null;
        if (TextUtils.isEmpty(this.c) == true) goto L19;
        if (r0 == null) goto L19;
        JSONObject r1 = r0.optJSONObject(this.c);     // Catch: Exception -> L17
        if (r1 == null) goto L20;
        if (r10 != null) goto L11;
        JSONObject r2 = null;
    L12:
        if (r10 != null) goto L14;
        JSONObject r11 = null;
    L15:
        r3 = d(r1, r2, r11, true);     // Catch: Exception -> L17
        goto L20
    L14:
        r11 = r10.optJSONObject(r1.optString("sharer_id"));     // Catch: Exception -> L17
        goto L15
    L11:
        r2 = r10.optJSONObject(r1.optString("owner_id"));     // Catch: Exception -> L17
    L20:
        r8.setParent(r3);
        return r8;
    L17:
        e = move-exception;
        tt5.a.e("FolderListParser", "parseParentNode()... exception: ", e, false);
    L19:
        tt5.a.h("FolderListParser", "parseParentNode()...null path  or nodes ");
        goto L20
    }

    @Override // com.bytedance.ee.bear.list.u
    public final void f(DocumentListInfo r1, JSONObject r2) {
        super.f(r1, r2);
        if (TextUtils.isEmpty(this.c) == true) goto L5;
        return;
    L5:
        if (hu5.a.d(r1.getDocumentList()) == false) goto L7;
        int r3 = 0;
    L8:
        r1.setTotal(r3);
        return;
    L7:
        r3 = r1.getDocumentList().size();
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.u
    public final Document d(JSONObject r1, JSONObject r2, JSONObject r3, boolean r4) {
        Document r5 = super.d(r1, r2, r3, true);
        if (r5 == null) goto L5;
        r5.t = this.c;
    L5:
        return r5;
    }
}
