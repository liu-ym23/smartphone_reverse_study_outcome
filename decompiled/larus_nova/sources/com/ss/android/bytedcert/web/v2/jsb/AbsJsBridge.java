package com.ss.android.bytedcert.web.v2.jsb;

import android.app.Activity;
import android.content.Intent;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import com.ss.android.cert.manager.web.jsb.IJsBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public abstract class AbsJsBridge implements IJsBridge {
    private static final long serialVersionUID = 8794599078409965681L;

    public AbsJsBridge() {
    }

    @Override // com.ss.android.cert.manager.web.jsb.IJsBridge
    public void onActivityResult(Activity r100, int r101, int r102, Intent r103) {
    }

    @Override // com.ss.android.cert.manager.web.jsb.IJsBridge
    public void onDestroy(Activity r100) {
    }

    public void transparentMsgToJs(IBridgeContext r100, CertResponse r101) {
        transparentMsgToJs(r100, r101, null);
    }

    public void transparentMsgToJs(IBridgeContext r100, CertResponse r101, JSONObject r102) {
        if (r100 == null) goto L15;
        if (r102 == null) goto L13;
    L7:
        if (r102 != null) goto L9;
        r102 = new JSONObject();     // Catch: Exception -> L5
    L9:
        r102.put("status_code", r101.errorCode);     // Catch: Exception -> L5
        r102.put("description", r101.errorMsg);     // Catch: Exception -> L5
        r102.put("detail_error_code", r101.detailErrorCode);     // Catch: Exception -> L5
        r102.put("detail_error_message", r101.detailErrorMsg);     // Catch: Exception -> L5
        r100.onSuccess(r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        r102 = r101.jsonBody;     // Catch: Exception -> L5
        goto L7
    }
}
