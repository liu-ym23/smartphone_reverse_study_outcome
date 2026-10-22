package uc5;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e1 extends com.bytedance.ee.bear.list.u {
    public final String c;

    public e1(String r1) {
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
    public final DocumentListInfo e(DocumentListInfo r7, JSONObject r8) {
        DocumentListInfo r9 = super.e(r7, r8);
        JSONObject r0 = r8.optJSONObject("entities");
        JSONObject r1 = r0.optJSONObject("nodes");
        JSONObject r2 = r0.optJSONObject("users");
        JSONArray r10 = r8.optJSONArray("path");
        Document r3 = null;
        if (r10 == null) goto L22;
        if (r1 == null) goto L22;
        JSONObject r11 = r1.optJSONObject((String) r10.get(r10.length() - 1));     // Catch: Exception -> L18 JSONException -> L20
        if (r11 == null) goto L23;
        if (r2 != null) goto L12;
        JSONObject r4 = null;
    L13:
        if (r2 != null) goto L15;
        JSONObject r5 = null;
    L16:
        r3 = d(r11, r4, r5, false);     // Catch: Exception -> L18 JSONException -> L20
    L15:
        r5 = r2.optJSONObject(r11.optString("sharer_id"));     // Catch: Exception -> L18 JSONException -> L20
        goto L16
    L12:
        r4 = r2.optJSONObject(r11.optString("owner_id"));     // Catch: Exception -> L18 JSONException -> L20
    L23:
        r9.setParent(r3);
        return r9;
    L20:
        e = move-exception;
        tt5.a.e("FolderListParser", "parseParentNode()... JSONException:", e, false);
    L18:
        e = move-exception;
        tt5.a.e("FolderListParser", "parseParentNode()... exception: ", e, false);
    L22:
        tt5.a.h("FolderListParser", "parseParentNode()...null pathArray  or nodes ");
        goto L23
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
        Document r5 = super.d(r1, r2, r3, r4);
        if (r5 == null) goto L5;
        r5.t = this.c;
    L5:
        return r5;
    }
}
