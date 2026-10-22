package com.ss.android.cert.aliyun;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.face.api.ZIMFacade;
import com.alipay.face.api.ZIMFacadeBuilder;
import com.alipay.face.api.ZIMResponse;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.api.IAliyunCert;
import com.ss.android.cert.manager.callback.CertCallback;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import face.security.device.api.FaceSecDevice;
import face.security.device.api.FaceSecSession;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AliyunCertImpl implements IAliyunCert {
    protected static final String CERT_ID_KEY = "certifyId";
    protected static final String USE_MSG_BOX_KEY = "useMsgBox";
    private volatile boolean setup;
    private boolean startup;

    public static /* synthetic */ boolean a(AliyunCertImpl r100, CertCallback r101, ZIMResponse r102) {
        return r100.lambda$doFaceLiveness$0(r101, r102);
    }

    @Override // com.ss.android.cert.manager.api.IPlugin
    public boolean installPlugin(Context r100) {
        return true;
    }

    @Override // com.ss.android.cert.manager.api.IAliyunCert
    public JSONObject getSession() {
        JSONObject r100 = new JSONObject();
        FaceSecSession r101 = FaceSecDevice.f476085a.a();
        if (r101 != null) goto L7;
    L5:
        return r100;
    L7:
        r100.put("code", r101.f476087a);     // Catch: JSONException -> L6
        r100.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, r101.f476088b);     // Catch: JSONException -> L6
        goto L5
    }

    public AliyunCertImpl() {
        CertManager.getInstance().registerAliyunCert(this);
    }

    private JSONObject parseResponse(ZIMResponse r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L7;
    L5:
        return r101;
    L7:
        r101.put("code", r100.code);     // Catch: JSONException -> L6
        r101.put("reason", r100.reason);     // Catch: JSONException -> L6
        r101.put("msg", r100.msg);     // Catch: JSONException -> L6
        r101.put("deviceToken", r100.deviceToken);     // Catch: JSONException -> L6
        r101.put("videoFilePath", r100.videoFilePath);     // Catch: JSONException -> L6
        goto L5
    }

    @Override // com.ss.android.cert.manager.api.IAliyunCert
    public String getMetaInfos(Context r100) {
        init(r100);
        return ZIMFacade.getMetaInfos(r100);
    }

    @Override // com.ss.android.cert.manager.api.IAliyunCert
    public void init(Context r100) {
        if (this.setup == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.setup == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L10:
        ZIMFacade.install(r100);     // Catch: Throwable -> L13
        this.setup = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    private /* synthetic */ boolean lambda$doFaceLiveness$0(CertCallback r100, ZIMResponse r101) {
        boolean r102 = false;
        this.startup = false;
        JSONObject r103 = parseResponse(r101);
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L9;
        CertResponse r104 = new CertResponse(true, r103);
    L13:
        r100.callback(r104);
        return true;
    L9:
        CertResponse r105 = new CertResponse(ErrorConstant.Client.ERROR_FACE_LIVE_FAIL);
        if (r101 == null) goto L12;
        r105.detailErrorCode = r101.code;
        r105.detailErrorMsg = r101.reason;
    L12:
        r104 = r105;
        goto L13
    L5:
        if (r101.code != 1000) goto L7;
        r102 = true;
        goto L7
    }

    @Override // com.ss.android.cert.manager.api.IAliyunCert
    public void doFaceLiveness(Context r100, Map<String, String> r101, final CertCallback r102) {
        if (r101 != null) goto L6;
        r102.callback(new CertResponse(ErrorConstant.Client.ERROR_UNKNOWN));
        return;
    L6:
        if (this.startup == false) goto L9;
        r102.callback(new CertResponse(ErrorConstant.Client.ERROR_CERT_IS_START));
        return;
    L9:
        String r103 = r101.remove(CERT_ID_KEY);
        boolean r104 = TextUtils.equals(r101.remove(USE_MSG_BOX_KEY), "true");
        HashMap<String, String> r105 = new HashMap();
        if (r101.size() <= 0) goto L12;
        r105.putAll(r101);
    L12:
        ZIMFacade r106 = ZIMFacadeBuilder.create(r100);
        r106.setCustomUIConfig(0, "{\"guideConfig\": {\"loadingPageColor\": \"#00ffffff\"}}");
        r106.verify(r103, r104, r105, new a(this, r102));
        this.startup = true;
    }
}
