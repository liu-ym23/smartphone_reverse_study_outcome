package uo4;

import com.bytedance.ee.bear.bitable.baseadd.model.SubmitRecordStatus;
import com.bytedance.ee.bear.bitable.baseadd.model.SubmitRecordStatusResponse;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements NetService.c<SubmitRecordStatusResponse> {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
    L11:
        e = move-exception;
        tt5.a.e("BaseAddSubmitStatusParser", "parse err ", e, false);
        throw new NetService.ParseException();
    L4:
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        JSONObject r101 = new JSONObject(r100).optJSONObject("data");     // Catch: Exception -> L11
        if (r101 != null) goto L9;
        r101 = new JSONObject();     // Catch: Exception -> L11
    L9:
        return new SubmitRecordStatusResponse(new SubmitRecordStatus(r101.optInt("status", -1), r101.optString("recordShareToken", "")));
    }
}
