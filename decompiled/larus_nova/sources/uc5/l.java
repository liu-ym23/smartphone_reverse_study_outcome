package uc5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.DocumentListInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class l extends com.bytedance.ee.bear.list.u {
    public l() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo a(String r100) {
        this.f229803a = new DocumentListInfo();
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L15
        int r102 = r101.optInt("code");     // Catch: JSONException -> L15
        this.f229803a.setCode(r102);     // Catch: JSONException -> L15
        if (r102 != 0) goto L6;
    L9:
        JSONObject r103 = r101.optJSONObject("data");     // Catch: JSONException -> L15
        if (r103 != null) goto L13;
        tt5.a.h("FolderDeleteParser", "parse()...data is null");     // Catch: JSONException -> L15
        return this.f229803a;
    L13:
        e(this.f229803a, r103);     // Catch: JSONException -> L15
        f(this.f229803a, r103);     // Catch: JSONException -> L15
    L17:
        return this.f229803a;
    L6:
        if (r102 == 4) goto L9;
        tt5.a.h("FolderDeleteParser", "parse()...error code = " + r102);     // Catch: JSONException -> L15
        return this.f229803a;
    L15:
        tt5.a.d("FolderDeleteParser", "new mainObj exception");
        goto L17
    }

    @Override // com.bytedance.ee.bear.list.u, com.bytedance.ee.bear.contract.NetService.c
    public final /* bridge */ /* synthetic */ Result parse(String r100) throws NetService.ParseException {
        return a(r100);
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo e(DocumentListInfo r100, JSONObject r101) {
        if (r101.optJSONArray("node_list") != null) goto L6;
        return r100;
    L6:
        return super.e(r100, r101);
    }
}
