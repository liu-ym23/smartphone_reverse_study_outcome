package com.bytedance.ee.bear.operation.check;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SuiteInfoRequester {
    public final NetService a;

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

        public final Result<SuiteInfoResult> parse(String r4) {
            Result<SuiteInfoResult> r0 = new Result();
            r0.data = new SuiteInfoResult();
            JSONObject r5 = new JSONObject(r4).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: JSONException -> L7
            if (r5 == null) goto L9;
            ((SuiteInfoResult) r0.data).suiteType = r5.optInt("suite_type");     // Catch: JSONException -> L7
        L9:
            return r0;
        L7:
            e = move-exception;
            tt5.a.d("SuiteInfoRequester", "SuiteInfoResultParser() exception = " + e);
            goto L9
        }
    }

    public SuiteInfoRequester(NetService r1) {
        this.a = r1;
    }
}
