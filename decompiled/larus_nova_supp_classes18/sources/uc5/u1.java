package uc5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.folder.GetDocumentExternalPermResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u1 implements NetService.c<GetDocumentExternalPermResult> {
    public u1() {
    }

    public final Result parse(String r7) throws NetService.ParseException {
        GetDocumentExternalPermResult r0 = new GetDocumentExternalPermResult();
        HashMap<String, Boolean> r1 = new HashMap();
        r0.setPermMap(r1);
        JSONObject r2 = new JSONObject(r7).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L8
        Iterator<String> r3 = r2.keys();     // Catch: JSONException -> L8
    L5:
        if (r3.hasNext() == false) goto L10;
        String r4 = r3.next();     // Catch: JSONException -> L8
        r1.put(r4, Boolean.valueOf(r2.optBoolean(r4, true)));     // Catch: JSONException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        tt5.a.e("GetDocumentExternalPermParser", "parse()...json = " + r7, e, false);
        goto L10
    }
}
