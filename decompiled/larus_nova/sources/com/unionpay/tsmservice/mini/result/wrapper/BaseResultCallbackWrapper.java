package com.unionpay.tsmservice.mini.result.wrapper;

import android.os.Bundle;
import com.unionpay.tsmservice.mini.ITsmCallback;
import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public abstract class BaseResultCallbackWrapper extends ITsmCallback.Stub {
    protected int interfaceId;
    protected ITsmCallback target;

    public BaseResultCallbackWrapper(int r100, ITsmCallback r101) {
        this.target = r101;
        this.interfaceId = r100;
    }

    public abstract Bundle convertResult(Bundle r100);

    @Override // com.unionpay.tsmservice.mini.ITsmCallback
    public void onError(String r100, String r101) {
        ITsmCallback r102 = this.target;
        if (r102 == null) goto L6;
        r102.onError(r100, r101);
        return;
    }

    @Override // com.unionpay.tsmservice.mini.ITsmCallback
    public void onResult(Bundle r100) {
        convertResult(r100);     // Catch: JSONException -> L5
        r100.remove("interfaceId");     // Catch: JSONException -> L5
    L8:
        if ("10000".equalsIgnoreCase(r100.getString("errorCode")) == false) goto L13;
        ITsmCallback r101 = this.target;
        if (r101 == null) goto L19;
        r101.onResult(r100);
        return;
    L19:
        return;
    L13:
        ITsmCallback r102 = this.target;
        if (r102 == null) goto L20;
        r102.onError(r100.getString("errorCode"), r100.getString("errorDesc"));
        return;
    L20:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r100.putString("errorCode", this.interfaceId + "00001");
        goto L8
    }
}
