package uc5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l extends com.bytedance.ee.bear.list.u {
    public l() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo a(String r5) {
        this.a = new DocumentListInfo();
        JSONObject r2 = new JSONObject(r5);     // Catch: JSONException -> L15
        int r6 = r2.optInt("code");     // Catch: JSONException -> L15
        this.a.setCode(r6);     // Catch: JSONException -> L15
        if (r6 != 0) goto L6;
    L9:
        JSONObject r7 = r2.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L15
        if (r7 != null) goto L13;
        tt5.a.h("FolderDeleteParser", "parse()...data is null");     // Catch: JSONException -> L15
        return this.a;
    L13:
        e(this.a, r7);     // Catch: JSONException -> L15
        f(this.a, r7);     // Catch: JSONException -> L15
    L17:
        return this.a;
    L6:
        if (r6 == 4) goto L9;
        tt5.a.h("FolderDeleteParser", "parse()...error code = " + r6);     // Catch: JSONException -> L15
        return this.a;
    L15:
        tt5.a.d("FolderDeleteParser", "new mainObj exception");
        goto L17
    }

    @Override // com.bytedance.ee.bear.list.u
    public final /* bridge */ /* synthetic */ Result parse(String r1) throws NetService.ParseException {
        return a(r1);
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo e(DocumentListInfo r2, JSONObject r3) {
        if (r3.optJSONArray("node_list") != null) goto L6;
        return r2;
    L6:
        return super.e(r2, r3);
    }
}
