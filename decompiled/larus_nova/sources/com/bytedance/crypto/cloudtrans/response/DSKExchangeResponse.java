package com.bytedance.crypto.cloudtrans.response;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.crypto.cloudtrans.CloudDskBody;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DSKExchangeResponse {
    private static String DSK_BOE_URL = "https://ocean-secret-boe.bytedance.net/api/device/sharedKey/ex";
    private static String DSK_RESULT_BOE_URL = "https://ocean-secret-boe.bytedance.net/api/device/sharedKey/exResult";
    private static String DSK_RESULT_URL = "https://ocean-secret.oceancloudapi.com/api/device/sharedKey/exResult";
    private static String DSK_URL = "https://ocean-secret.oceancloudapi.com/api/device/sharedKey/ex";
    public static String SIGN_PUBLIC_KEY_BOE = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEveLhMZvIaKypKND3AGzpwpAVWXHh\nhaiHQN6/WMgq2jE4vBR/6L0gO7ubgoU1Q1Yh9Q/qwz0+w6RN5rp0j13RiQ==\n-----END PUBLIC KEY-----";
    public static String SIGN_PUBLIC_KEY_PRO = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEKALR6oZdBB8SHBCGj4XZDseXEIHo\nIIcL77rmRu6i97Ui5NDAFtTjjbyQPn7WayyZ0uTlMUIGyzdfIg1LLP1SZg==\n-----END PUBLIC KEY-----";
    public static final int STATUS_FAILED = 2;
    public static final int STATUS_SUCCESS = 1;
    private static final String TAG = "DSKExchangeResponse";
    private final String publicKey;
    private final String resultUrl;
    private final String url;

    public DSKExchangeResponse() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L5;
        this.url = DSK_BOE_URL;
        this.resultUrl = DSK_RESULT_BOE_URL;
        String r100 = SIGN_PUBLIC_KEY_BOE;
    L6:
        this.publicKey = r100;
        return;
    L5:
        this.url = DSK_URL;
        this.resultUrl = DSK_RESULT_URL;
        r100 = SIGN_PUBLIC_KEY_PRO;
        goto L6
    }

    public String constructBodyJson(String r100, String r101, long r102, int r103) {
        JSONObject r104 = new JSONObject();
        r104.put("app_id", r100);     // Catch: Exception -> L6
        r104.put(a.KEY_DID, r101);     // Catch: Exception -> L6
        r104.put("key_version", r102);     // Catch: Exception -> L6
        r104.put("status", r103);     // Catch: Exception -> L6
        return r104.toString();
    L6:
        e = move-exception;
        throw new CloudTransException("constructBodyJson failed, " + e.getMessage());
    }

    public String dskExchangeByCert(String r100) {
        Response r101 = new OkHttpClient().newCall(new Request.Builder().url(this.url).addHeader("Content-Type", "application/json").addHeader("x-att-certchain", r100).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), SliceInitService.DEFAULT_SWITCH)).build()).execute();     // Catch: Exception -> L13
        if (r101.isSuccessful() == false) goto L12;
        if (r101.body() != null) goto L8;
        return null;
    L8:
        return r101.body().string();
    L12:
        throw new IOException("Unexpected code " + r101);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeByTempKey(String r100, String r101) {
        Response r102 = new OkHttpClient().newCall(new Request.Builder().url(this.url).addHeader("Content-Type", "application/json").addHeader("x-client-pubkey", r100).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), r101)).build()).execute();     // Catch: Exception -> L13
        if (r102.isSuccessful() == true) goto L6;
        LogUtils.d(TAG, "responseBody:" + r102.body().string());     // Catch: Exception -> L13
        throw new IOException("Unexpected code " + r102);     // Catch: Exception -> L13
    L6:
        if (r102.body() != null) goto L8;
        return null;
    L8:
        return r102.body().string();
    L13:
        e = move-exception;
        throw new CloudTransException("dskExchange failed, " + e.getMessage());
    }

    public String dskExchangeResult(String r100) {
        Response r101 = new OkHttpClient().newCall(new Request.Builder().url(this.resultUrl).addHeader("Content-Type", "application/json").post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), r100)).build()).execute();     // Catch: Exception -> L13
        if (r101.isSuccessful() == false) goto L12;
        if (r101.body() != null) goto L8;
        return null;
    L8:
        return r101.body().string();
    L12:
        throw new IOException("Unexpected code " + r101);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        throw new CloudTransException("dskExchangeResult failed, " + e.getMessage());
    }

    public String getPlublicKey() {
        return this.publicKey;
    }

    public CloudDskBody jsonParsing(String r100) {
        CloudDskBody r101 = new CloudDskBody();
        r101.bodyJson = r100;
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L8
        int r103 = JSONObjectProtectorUtils.getInt(r102, "code");     // Catch: Exception -> L8
        r101.code = r103;     // Catch: Exception -> L8
        if (r103 != 200) goto L7;
        r101.msg = JSONObjectProtectorUtils.getString(r102, "msg");     // Catch: Exception -> L8
        r101.logId = JSONObjectProtectorUtils.getString(r102, "log_id");     // Catch: Exception -> L8
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r102, "data");     // Catch: Exception -> L8
        r101.data.cloudPublicKey = JSONObjectProtectorUtils.getString(r104, "cloud_public_key");     // Catch: Exception -> L8
        r101.data.sharedKeyHash = JSONObjectProtectorUtils.getString(r104, "shared_key_hash");     // Catch: Exception -> L8
        r101.data.keyVersion = JSONObjectProtectorUtils.getLong(r104, "key_version");     // Catch: Exception -> L8
        r101.data.expectExpiryTime = JSONObjectProtectorUtils.getLong(r104, "expect_expiry_time");     // Catch: Exception -> L8
        r101.data.signature = JSONObjectProtectorUtils.getString(r104, "signature");     // Catch: Exception -> L8
    L7:
        return r101;
    L8:
        e = move-exception;
        r101.code = -1;
        throw new CloudTransException("parse body json failed, " + e.getMessage());
    }
}
