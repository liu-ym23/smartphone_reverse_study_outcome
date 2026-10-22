package mg5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.google.gson.Gson;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements NetService.c<EmbededDocumentInfo> {
    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L21
        if (r101.optInt("code") != 0) goto L33;
        EmbededDocumentInfo r102 = new EmbededDocumentInfo();     // Catch: Exception -> L21
        EmbededDocumentInfo.EmbededData r103 = (EmbededDocumentInfo.EmbededData) new Gson().fromJson(r101.optString("data"), EmbededDocumentInfo.EmbededData.class);     // Catch: Exception -> L21
        if (r103.getResult() != null) goto L9;
    L19:
        r102.setResult(r103);     // Catch: Exception -> L21
        r102.setSuccess(true);     // Catch: Exception -> L21
        r103.setDataSuccess(true);     // Catch: Exception -> L21
        return r102;
    L9:
        if (r103.getResult().size() <= 0) goto L19;
        Iterator<EmbededDocumentInfo.NodeInfo> r104 = r103.getResult().iterator();     // Catch: Exception -> L21
    L12:
        if (r104.hasNext() == false) goto L19;
        EmbededDocumentInfo.NodeInfo r105 = r104.next();     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r105.getToken()) == true) goto L18;
        if (r105.getToken().startsWith("wik") == false) goto L18;
        r105.setWiki(true);     // Catch: Exception -> L21
    L18:
        r105.setWiki(false);     // Catch: Exception -> L21
        goto L12
    L33:
        return null;
    L21:
        e = move-exception;
        tt5.a.f("EmbededDocumentParser", e, false);
        return null;
    }
}
