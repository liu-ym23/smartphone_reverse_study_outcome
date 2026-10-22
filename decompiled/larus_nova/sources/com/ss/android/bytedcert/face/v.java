package com.ss.android.bytedcert.face;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.constants.ErrorConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class v implements SDKCallBack.CommonRequestCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SDKCallBack.CommonRequestCallback f407508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f407509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f407510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FaceDetectionRecorder f407511d;

    @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
    public final void onRequestFinish(BDResponse r110) {
        if (r110 != null) goto L4;
        r110 = new BDResponse(ErrorConstant.Client.ERROR_VIDEO_RECORD_UPLOAD_FAIL);
    L4:
        SDKCallBack.CommonRequestCallback r100 = this.f407508a;
        if (r100 == null) goto L7;
        r100.onRequestFinish(r110);
    L7:
        FaceDetectionRecorder r101 = this.f407511d;
        String r102 = this.f407509b;
        long r103 = this.f407510c;
        r101.getClass();
        String r104 = "success";
        JSONObject r105 = new JSONObject();
        int r106 = r101.f407328b;     // Catch: Exception -> L31
        if (r106 <= 0) goto L13;
        r105.put("record_policy", r106);     // Catch: Exception -> L31
    L16:
        if (r110.success == false) goto L18;
        Object r107 = "success";
    L19:
        r105.put("upload_result", r107);     // Catch: Exception -> L31
        if (r110.success == true) goto L22;
        r105.put("fail_reason", r110.detailErrorMsg);     // Catch: Exception -> L31
    L22:
        r105.put("duration", System.currentTimeMillis() - r103);     // Catch: Exception -> L31
        r105.put("file_size", new PolarisFileWrapper(r102).length());     // Catch: Exception -> L31
        goto L23
    L18:
        r107 = "fail";
        goto L19
    L13:
        if (r101.f407329c == false) goto L16;
        r105.put("record_policy", 4);     // Catch: Exception -> L31
    L23:
        r101.f407330d.onEvent("face_detection_record_upload", r105);
        JSONObject r108 = new JSONObject();
        if (r110.success == true) goto L28;
        r104 = "fail";
    L28:
        r108.put("result", r104);     // Catch: JSONException -> L32
    L29:
        rsa.c.a(new rsa.c.a("flow_step", a.b("record", "upload_e", r108)));
    }

    public v(FaceDetectionRecorder r100, u r101, String r102, long r103) {
        this.f407511d = r100;
        this.f407508a = r101;
        this.f407509b = r102;
        this.f407510c = r103;
    }
}
