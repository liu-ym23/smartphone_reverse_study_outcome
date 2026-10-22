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

/* JADX INFO: loaded from: classes18.dex */
public final class f1 extends com.bytedance.ee.bear.list.u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f549496c;

    public f1(String r100) {
        this.f549496c = r100;
    }

    @Override // com.bytedance.ee.bear.list.u
    public final void c(DocumentListInfo r110, JSONObject r111) {
        if (r110 == null) goto L25;
        if (r111 == null) goto L25;
        JSONObject r112 = r111.optJSONObject("entities");
        JSONObject r100 = r112.optJSONObject("nodes");
        JSONObject r113 = r112.optJSONObject(OperationName.OPERATION_OFFLINE_AVAILABLE);
        HashMap<String, Document> r101 = null;
        if (r113 != null) goto L27;
        tt5.a.h("FolderListParser", "parseOfflineList()... offlineNode is null ");
    L23:
        r110.setFakeTokenMap(r101);
        return;
    L27:
        HashMap<String, Document> r102 = new HashMap();     // Catch: Exception -> L19 JSONException -> L21
        Iterator<String> r103 = r113.keys();     // Catch: Exception -> L19 JSONException -> L21
    L11:
        if (r103.hasNext() == false) goto L18;
        String r104 = r103.next();     // Catch: Exception -> L19 JSONException -> L21
        Document r105 = d(JSONObjectProtectorUtils.getJSONObject(r100, r113.optString(r104)), null, null, true);     // Catch: Exception -> L19 JSONException -> L21
        if (r105 == null) goto L15;
        r105.f227899u = r104;     // Catch: Exception -> L19 JSONException -> L21
        r102.put(r104, r105);     // Catch: Exception -> L19 JSONException -> L21
        goto L11
    L15:
        tt5.a.d("FolderListParser", "parseOfflineList: documentObj is null");     // Catch: Exception -> L19 JSONException -> L21
        goto L11
    L18:
        r101 = r102;
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
    public final DocumentListInfo e(DocumentListInfo r100, JSONObject r101) {
        DocumentListInfo r102 = super.e(r100, r101);
        JSONObject r103 = r101.optJSONObject("entities");
        JSONObject r104 = r103.optJSONObject("nodes");
        JSONObject r105 = r103.optJSONObject("users");
        Document r106 = null;
        if (TextUtils.isEmpty(this.f549496c) == true) goto L19;
        if (r104 == null) goto L19;
        JSONObject r107 = r104.optJSONObject(this.f549496c);     // Catch: Exception -> L17
        if (r107 == null) goto L20;
        if (r105 != null) goto L11;
        JSONObject r108 = null;
    L12:
        if (r105 != null) goto L14;
        JSONObject r109 = null;
    L15:
        r106 = d(r107, r108, r109, true);     // Catch: Exception -> L17
        goto L20
    L14:
        r109 = r105.optJSONObject(r107.optString("sharer_id"));     // Catch: Exception -> L17
        goto L15
    L11:
        r108 = r105.optJSONObject(r107.optString("owner_id"));     // Catch: Exception -> L17
    L20:
        r102.setParent(r106);
        return r102;
    L17:
        e = move-exception;
        tt5.a.e("FolderListParser", "parseParentNode()... exception: ", e, false);
    L19:
        tt5.a.h("FolderListParser", "parseParentNode()...null path  or nodes ");
        goto L20
    }

    @Override // com.bytedance.ee.bear.list.u
    public final void f(DocumentListInfo r100, JSONObject r101) {
        super.f(r100, r101);
        if (TextUtils.isEmpty(this.f549496c) == true) goto L5;
        return;
    L5:
        if (hu5.a.d(r100.getDocumentList()) == false) goto L7;
        int r102 = 0;
    L8:
        r100.setTotal(r102);
        return;
    L7:
        r102 = r100.getDocumentList().size();
        goto L8
    }

    @Override // com.bytedance.ee.bear.list.u
    public final Document d(JSONObject r100, JSONObject r101, JSONObject r102, boolean r103) {
        Document r104 = super.d(r100, r101, r102, true);
        if (r104 == null) goto L5;
        r104.f227898t = this.f549496c;
    L5:
        return r104;
    }
}
