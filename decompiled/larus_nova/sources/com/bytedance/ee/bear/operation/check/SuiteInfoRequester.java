package com.bytedance.ee.bear.operation.check;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class SuiteInfoRequester {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f236206a;

    public static class SuiteInfoResult implements Serializable {
        public int suiteType;

        public SuiteInfoResult() {
        }

        public String toString() {
            return "BusinessInfoResult{suiteType='" + this.suiteType + "'}";
        }
    }

    public static class a implements NetService.c<Result<SuiteInfoResult>> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<SuiteInfoResult> parse(String r100) {
            Result<SuiteInfoResult> r101 = new Result();
            r101.data = new SuiteInfoResult();
            JSONObject r102 = new JSONObject(r100).optJSONObject("data");     // Catch: JSONException -> L7
            if (r102 == null) goto L9;
            ((SuiteInfoResult) r101.data).suiteType = r102.optInt("suite_type");     // Catch: JSONException -> L7
        L9:
            return r101;
        L7:
            e = move-exception;
            tt5.a.d("SuiteInfoRequester", "SuiteInfoResultParser() exception = " + e);
            goto L9
        }
    }

    public SuiteInfoRequester(NetService r100) {
        this.f236206a = r100;
    }
}
