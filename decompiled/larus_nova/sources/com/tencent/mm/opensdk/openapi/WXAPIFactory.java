package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        throw new RuntimeException("WXAPIFactory should not be instantiated");
    }

    public static IWXAPI createWXAPI(Context r100, String r101) {
        return createWXAPI(r100, r101, true);
    }

    public static IWXAPI createWXAPI(Context r100, String r101, boolean r102) {
        Log.d(TAG, "createWXAPI, appId = " + r101 + ", checkSignature = " + r102);
        return createWXAPI(r100, r101, r102, 2);
    }

    public static IWXAPI createWXAPI(Context r100, String r101, boolean r102, int r103) {
        Log.d(TAG, "createWXAPI, appId = " + r101 + ", checkSignature = " + r102 + ", launchMode = " + r103);
        return new WXApiImplV10(r100, r101, r102, r103);
    }
}
