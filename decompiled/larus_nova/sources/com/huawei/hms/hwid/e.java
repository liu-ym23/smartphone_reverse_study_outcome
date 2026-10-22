package com.huawei.hms.hwid;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class e extends HuaweiApi<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api<a> f277506a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f277507c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f277508b;

    public static class a implements Api.ApiOptions.Optional {
        public a() {
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    static {
        f277506a = new Api(HuaweiApiAvailability.HMS_API_NAME_GAME);
        f277507c = new a();
    }

    public void a() {
        as.b("AccountSignInNoticeClientImpl", "request Jos Notice.", true);
        String r100 = HiAnalyticsClient.reportEntry(getContext(), CoreNaming.GETNOTICE, 60900100);
        JSONObject r101 = new JSONObject();
        r101.put("noticeType", 1);     // Catch: JSONException -> L6
        r101.put("hmsSdkVersionName", "6.11.0.301");     // Catch: JSONException -> L6
        r101.put("cpId", Util.getCpId(this.f277508b));     // Catch: JSONException -> L6
        doWrite(new k(CoreNaming.GETNOTICE, r101.toString(), r100));
        return;
    L6:
        as.c("AccountSignInNoticeClientImpl", "createParams Notice request meet JSONException.", true);
    }

    public e(Context r100) {
        super(r100, f277506a, f277507c, new d());
        this.f277508b = r100;
    }
}
