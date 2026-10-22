package com.ss.videoarch.strategy.network;

import android.text.TextUtils;
import android.util.Pair;
import com.alipay.sdk.m.n.a;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.videoarch.strategy.network.model.HttpResponseException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class HttpApi {
    private final String apiHost;
    private final List<Pair<String, String>> commonParams;
    private final IHttpExecutor executor;

    public HttpApi(LSSDKConfig r100) {
        this.apiHost = r100.mApiHost;
        this.executor = r100.mHttpExecutor;
        this.commonParams = r100.mCommonParams;
    }

    private JSONObject doGetJson(String r100) throws Exception {
        return new JSONObject(this.executor.executeGet(addParams(this.apiHost + r100, this.commonParams)));
    }

    private JSONObject handleGetResponse(JSONObject r100) throws Exception {
        if (r100 == null) goto L6;
        return JSONObjectProtectorUtils.getJSONObject(r100, "Result");
    L6:
        throw new HttpResponseException(0);
    }

    private JSONObject handlePostResponse(JSONObject r100) throws Exception {
        if (r100 == null) goto L6;
        return JSONObjectProtectorUtils.getJSONObject(r100, "Result");
    L6:
        throw new HttpResponseException(0);
    }

    public JSONObject getJson(String r100) throws Exception {
        return doGetJson(r100);
    }

    private static String addParams(String r100, List<Pair<String, String>> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        StringBuilder r102 = new StringBuilder(r100);
        if (r100.indexOf(63) < 0) goto L8;
        r102.append("&");
    L11:
        int r103 = 0;
    L13:
        if (r103 >= r101.size()) goto L18;
        if (r103 <= 0) goto L16;
        r102.append("&");
    L16:
        Pair r104 = (Pair) ListProtector.get(r101, r103);
        r102.append((String) r104.first);
        r102.append(a.f25612h);
        r102.append(encode((String) r104.second, "UTF-8"));
        r103 = r103 + 1;
        goto L13
    L18:
        return r102.toString();
    L8:
        if (r101.size() <= 0) goto L11;
        r102.append("?");
        goto L11
    }

    private JSONObject doPostJson(String r100, Object r101) throws Exception {
        return new JSONObject(this.executor.executePost(addParams(this.apiHost + r100, this.commonParams), r101.toString().getBytes("UTF-8"), DownloadHelper.GZIP, "application/json; charset=utf-8"));
    }

    private static String encode(String r100, String r101) {
        return URLEncoder.encode(r100, r101);
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public JSONObject postJson(String r100, Object r101) throws Exception {
        return doPostJson(r100, r101);
    }
}
