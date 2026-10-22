package com.bytedance.crypto.network;

import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ChallengeManager {
    private static final String GET_CHALLENGE_URL = "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
    private static final String GET_CHALLENGE_URL_BOE = "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    private static final String JSON_TAG_CODE = "code";
    private static final String JSON_TAG_DATA = "data";
    private static final String JSON_TAG_NONCE = "nonce";
    private static final String TAG = "ChallengeManager";

    public ChallengeManager() {
    }

    private static String getChallenge(String r100) {
        return JSONObjectProtectorUtils.getString(new JSONObject(JSONObjectProtectorUtils.getString(new JSONObject(r100), "data")), "nonce");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getChallenge exception:" + e.getMessage());
        return "";
    }

    private static String getChallengeFromServer() {
        OkHttpClient r100 = new OkHttpClient();
        Request r101 = new Request.Builder().url(getRequestUrl()).get().build();
        String r102 = TAG;
        LogUtils.i(r102, "Request:" + r101.toString());
        LogUtils.d(r102, "Request body:" + r101.body());
        Response r103 = r100.newCall(r101).execute();     // Catch: Exception -> L8
        if (r103.isSuccessful() == false) goto L6;
        String r104 = r103.body().string();     // Catch: Exception -> L8
        LogUtils.i(r102, "response:" + r103.toString());     // Catch: Exception -> L8
        LogUtils.d(r102, "response body:" + r104);     // Catch: Exception -> L8
        return parseChallenge(r104);
    L6:
        LogUtils.i(r102, "newCall failed!! response:" + r103.toString());     // Catch: Exception -> L8
        LogUtils.i(r102, "newCall failed!! response body:" + r103.body().string());     // Catch: Exception -> L8
    L10:
        return "";
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    private static String getRequestUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L6;
        return GET_CHALLENGE_URL_BOE;
    L6:
        return GET_CHALLENGE_URL;
    }

    private static int getResponseCode(String r100) {
        return JSONObjectProtectorUtils.getInt(new JSONObject(r100), "code");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseCode exception:" + e.getMessage());
        return 400;
    }

    private static String parseChallenge(String r100) {
        int r101 = getResponseCode(r100);
        if (r101 >= 200) goto L5;
    L10:
        return "";
    L5:
        if (r101 >= 300) goto L10;
        return getChallenge(r100);
    L8:
        e = move-exception;
        LogUtils.e(TAG, "parseChallenge exception:" + e.getMessage());
        goto L10
    }

    public static String requestChallenge() {
        return getChallengeFromServer();
    }
}
