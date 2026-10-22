package com.ss.android.bytedcert.web.v2.jsb.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.model.CertResult;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f407962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBridgeContext f407963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f407964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FaceLiveJsb f407965d;

    public final void a() {
        FaceLiveJsb.access$102(this.f407965d, true);
        FaceLiveJsb.access$200(this.f407965d).onH5Close(this.f407962a);
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L5
        r100.put("status_code", 0);     // Catch: Exception -> L5
        this.f407963b.onSuccess(r100);     // Catch: Exception -> L5
    L7:
        int r101 = this.f407962a.optInt("error_code", -1);
        String r102 = this.f407962a.optString("error_msg", "");
        JSONObject r103 = this.f407962a.optJSONObject("ext_data");
        FaceLiveJsb.access$300(this.f407965d, r101, r102, r103);
        if (FaceLiveJsb.access$400(this.f407965d) != null) goto L10;
        FaceLiveJsb.access$402(this.f407965d, new CertResult());
    L10:
        FaceLiveJsb.access$400(this.f407965d).setCode(r101);
        FaceLiveJsb.access$400(this.f407965d).setMessage(r102);
        FaceLiveJsb.access$400(this.f407965d).setExtra(this.f407962a);
        FaceLiveJsb.access$200(this.f407965d).onCertResult(FaceLiveJsb.access$400(this.f407965d));
        Activity r104 = this.f407963b.getActivity();
        if (r104 != null) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(this.f407964c) == true) goto L17;
        JSONObject r105 = new JSONObject();
        r105.put("url", this.f407964c);     // Catch: JSONException -> L19
    L16:
        FaceLiveJsb.access$500(this.f407965d, null, r104, SendEventContainerMethodParamModel.EventKinds.openPage, r105);
    L17:
        r104.finish();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(FaceLiveJsb r100, JSONObject r101, IBridgeContext r102, String r103) {
        this.f407965d = r100;
        this.f407962a = r101;
        this.f407963b = r102;
        this.f407964c = r103;
    }
}
