package iq5;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class s extends com.bytedance.ee.bear.list.u {
    public s() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo e(DocumentListInfo r110, JSONObject r111) {
        JSONArray r100 = r111.optJSONArray("path");
        JSONObject r112 = r111.optJSONObject("entities");
        JSONObject r101 = r112.optJSONObject("nodes");
        JSONObject r113 = r112.optJSONObject("users");
        int r102 = 0;
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        return r110;
    L10:
        ArrayList<Document> r104 = new ArrayList();
    L12:
        if (r102 >= r100.length()) goto L28;
        JSONArray r105 = r100.optJSONArray(r102);
        JSONObject r106 = r101.optJSONObject(r105.optString(r105.length() - 1));
        JSONObject r107 = null;
        if (r113 != null) goto L16;
        JSONObject r108 = null;
    L17:
        if (r113 == null) goto L20;
        r107 = r113.optJSONObject(r106.optString("sharer_id"));
    L20:
        Document r109 = d(r106, r108, r107, true);
        if (r109 != null) goto L23;
    L26:
        tt5.a.h("DocumentListParser", "parseList()...temp is null or type != folder");
    L27:
        r102 = r102 + 1;
        goto L12
    L23:
        if (r109.getType() != sbb.e.f541295f.f541317b) goto L26;
        r104.add(r109);
        goto L27
    L16:
        r108 = r113.optJSONObject(r106.optString("owner_id"));
        goto L17
    L28:
        r110.setDocumentList(r104);
        return r110;
    L7:
        tt5.a.h("DocumentListParser", "parseNodes()...null");
        r103 = true;
        goto L8
    }
}
