package nh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpCheckResult;
import com.google.gson.Gson;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements NetService.c<DlpCheckResult> {
    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) throws NetService.ParseException {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L21
        if (r101.optInt("code") != 0) goto L32;
        DlpCheckResult r102 = (DlpCheckResult) new Gson().fromJson(r101.optString("data"), DlpCheckResult.class);     // Catch: Exception -> L21
        if (r102 == null) goto L33;
        if (r102.getResultMap() == null) goto L33;
        if (r102.getResultMap().size() <= 0) goto L33;
        Iterator<DlpCheckResult.DlpResult> r103 = r102.getResultMap().values().iterator();     // Catch: Exception -> L21
    L14:
        if (r103.hasNext() == false) goto L33;
        DlpCheckResult.DlpResult r104 = r103.next();     // Catch: Exception -> L21
        if (r104 == null) goto L14;
        r104.setScsUpdateTime(System.currentTimeMillis());     // Catch: Exception -> L21
    L33:
        return r102;
    L32:
        return null;
    L21:
        e = move-exception;
        tt5.a.f("DlpCheckResultParser", e, false);
        return null;
    }
}
