package iq5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s extends com.bytedance.ee.bear.list.u {
    public s() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo e(DocumentListInfo r10, JSONObject r11) {
        JSONArray r0 = r11.optJSONArray("path");
        JSONObject r12 = r11.optJSONObject("entities");
        JSONObject r1 = r12.optJSONObject("nodes");
        JSONObject r13 = r12.optJSONObject("users");
        int r2 = 0;
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        boolean r5 = false;
    L8:
        if (r5 == false) goto L10;
        return r10;
    L10:
        ArrayList<Document> r6 = new ArrayList();
    L12:
        if (r2 >= r0.length()) goto L28;
        JSONArray r7 = r0.optJSONArray(r2);
        JSONObject r8 = r1.optJSONObject(r7.optString(r7.length() - 1));
        JSONObject r9 = null;
        if (r13 != null) goto L16;
        JSONObject r14 = null;
    L17:
        if (r13 == null) goto L20;
        r9 = r13.optJSONObject(r8.optString("sharer_id"));
    L20:
        Document r15 = d(r8, r14, r9, true);
        if (r15 != null) goto L23;
    L26:
        tt5.a.h("DocumentListParser", "parseList()...temp is null or type != folder");
    L27:
        r2 = r2 + 1;
        goto L12
    L23:
        if (r15.getType() != sbb.e.f.b) goto L26;
        r6.add(r15);
        goto L27
    L16:
        r14 = r13.optJSONObject(r8.optString("owner_id"));
        goto L17
    L28:
        r10.setDocumentList(r6);
        return r10;
    L7:
        tt5.a.h("DocumentListParser", "parseNodes()...null");
        r5 = true;
        goto L8
    }
}
