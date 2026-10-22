package uc5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.folder.GetDocumentExternalPermResult;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class u1 implements NetService.c<GetDocumentExternalPermResult> {
    public u1() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        GetDocumentExternalPermResult r101 = new GetDocumentExternalPermResult();
        HashMap<String, Boolean> r102 = new HashMap();
        r101.setPermMap(r102);
        JSONObject r103 = new JSONObject(r100).optJSONObject("data");     // Catch: JSONException -> L8
        Iterator<String> r104 = r103.keys();     // Catch: JSONException -> L8
    L5:
        if (r104.hasNext() == false) goto L10;
        String r105 = r104.next();     // Catch: JSONException -> L8
        r102.put(r105, Boolean.valueOf(r103.optBoolean(r105, true)));     // Catch: JSONException -> L8
    L10:
        return r101;
    L8:
        e = move-exception;
        tt5.a.e("GetDocumentExternalPermParser", "parse()...json = " + r100, e, false);
        goto L10
    }
}
