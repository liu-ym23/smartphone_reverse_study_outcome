package mg5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.google.gson.Gson;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements NetService.c<EmbededDocumentInfo> {
    public b() {
    }

    public final Result parse(String r9) throws NetService.ParseException {
        JSONObject r2 = new JSONObject(r9);     // Catch: Exception -> L21
        if (r2.optInt("code") != 0) goto L33;
        EmbededDocumentInfo r10 = new EmbededDocumentInfo();     // Catch: Exception -> L21
        EmbededDocumentInfo.EmbededData r3 = (EmbededDocumentInfo.EmbededData) new Gson().fromJson(r2.optString(WikiFolderPushPlugin.DATA), EmbededDocumentInfo.EmbededData.class);     // Catch: Exception -> L21
        if (r3.getResult() != null) goto L9;
    L19:
        r10.setResult(r3);     // Catch: Exception -> L21
        r10.setSuccess(true);     // Catch: Exception -> L21
        r3.setDataSuccess(true);     // Catch: Exception -> L21
        return r10;
    L9:
        if (r3.getResult().size() <= 0) goto L19;
        Iterator<EmbededDocumentInfo.NodeInfo> r4 = r3.getResult().iterator();     // Catch: Exception -> L21
    L12:
        if (r4.hasNext() == false) goto L19;
        EmbededDocumentInfo.NodeInfo r5 = r4.next();     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r5.getToken()) == true) goto L18;
        if (r5.getToken().startsWith("wik") == false) goto L18;
        r5.setWiki(true);     // Catch: Exception -> L21
    L18:
        r5.setWiki(false);     // Catch: Exception -> L21
        goto L12
    L33:
        return null;
    L21:
        e = move-exception;
        tt5.a.f("EmbededDocumentParser", e, false);
        return null;
    }
}
