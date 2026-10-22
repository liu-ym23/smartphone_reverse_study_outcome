package com.ss.android.bytedcert.web.v2.jsb.impl;

import android.text.TextUtils;
import com.ss.android.bytedcert.callback.H5CallBack;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements H5CallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBridgeContext f407966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FaceLiveJsb f407967b;

    @Override // com.ss.android.bytedcert.callback.H5CallBack
    public final void onH5Close(JSONObject r100) {
        if (r100.has("step") == false) goto L13;
        int r101 = r100.optInt("step");
        if (r101 == 1) goto L13;
        if (r101 < 0) goto L13;
        if (r101 < 2) goto L16;
        r101 = r101 - 1;
    L16:
        r100.put("step", r101);     // Catch: JSONException -> L15
    L12:
        FaceLiveJsb.access$600(this.f407967b, this.f407966a, r100, null);
    L13:
        FaceLiveJsb.access$700(this.f407967b, this.f407966a, new CertResponse(TextUtils.equals(r100.optString("error_msg", ""), BytedCertConstant.CertValue.CERTIFICATE_SUCCESS), r100));
    }

    public c(FaceLiveJsb r100, IBridgeContext r101) {
        this.f407967b = r100;
        this.f407966a = r101;
    }
}
