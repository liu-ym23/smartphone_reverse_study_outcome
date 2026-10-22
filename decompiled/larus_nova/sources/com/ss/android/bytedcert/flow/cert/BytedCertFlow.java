package com.ss.android.bytedcert.flow.cert;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import ata.a;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.bytedcert.callback.H5CallBack;
import com.ss.android.bytedcert.callback.IWebEventCallback;
import com.ss.android.bytedcert.callback.ProgressCallback;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.dialog.controller.video.VideoRecordController;
import com.ss.android.bytedcert.flow.face.FaceDetectFlow;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.ablity.ICertLoadingDialog;
import com.ss.android.cert.manager.callback.CertResultCallback;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.model.CertResult;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import osa.b;

/* JADX INFO: loaded from: classes34.dex */
public class BytedCertFlow extends FaceDetectFlow {
    public static final String TAG = "bytedcert";
    private CertResultCallback mCertResultCallback;
    private H5CallBack mH5CallBack;
    private ProgressCallback mProgressCallback;
    private long mStartTimestamp;
    private VideoRecordController mVideoRecordController;
    protected String mWebContainerType;
    protected IWebEventCallback mWebEventCallback;

    public List<a.InterfaceC0226a> getBridgeFactories() {
        return null;
    }

    public IWebEventCallback getWebEventCallback() {
        IWebEventCallback r100 = this.mWebEventCallback;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return BytedCertManager.getInstance().getWebEventCallback();
    }

    public void onDestroy() {
        VideoRecordController r100 = this.mVideoRecordController;
        if (r100 == null) goto L6;
        r100.onDestroy();
        return;
    }

    public BytedCertFlow() {
    }

    public VideoRecordController getRecordController() {
        return this.mVideoRecordController;
    }

    public static /* synthetic */ b access$100(BytedCertFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ String access$1000(BytedCertFlow r100) {
        return r100.mFlowId;
    }

    public static /* synthetic */ long access$200(BytedCertFlow r100) {
        return r100.mStartTimestamp;
    }

    public static /* synthetic */ b access$300(BytedCertFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ b access$400(BytedCertFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ b access$500(BytedCertFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ b access$600(BytedCertFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ String access$700(BytedCertFlow r100) {
        return r100.mFlowId;
    }

    public static /* synthetic */ String access$800(BytedCertFlow r100) {
        return r100.mFlowId;
    }

    public static /* synthetic */ String access$900(BytedCertFlow r100) {
        return r100.mFlowId;
    }

    @Override // com.ss.android.bytedcert.flow.face.FaceDetectFlow, com.ss.android.bytedcert.flow.base.AbsCertFlow
    public JSONObject appendEventParams(JSONObject r100) {
        JSONObject r101 = super.appendEventParams(r100);
        if (TextUtils.isEmpty(this.mWebContainerType) == true) goto L6;
        r101.put("web_container_type", this.mWebContainerType);     // Catch: Exception -> L7
    L6:
        return r101;
    }

    public void onCertResult(CertResult r100) {
        if (this.mCertResultCallback == null) goto L8;
        if (r100 == null) goto L6;
        r100.setTicket(this.mCertInfo.f526568b);
    L6:
        this.mCertResultCallback.onCertResult(r100);
        return;
    }

    public void onH5Close(JSONObject r100) {
        int r101 = 0;
        if (r100 == null) goto L18;
        int r102 = r100.optInt("error_code");
        String r103 = r100.optString("error_msg");
        JSONObject r104 = r100.optJSONObject("ext_data");
        boolean r105 = true;
        if (TextUtils.equals(r103, BytedCertConstant.CertValue.CERTIFICATE_SUCCESS) == false) goto L7;
        BDResponse r106 = new BDResponse(new CertResponse(true));
    L8:
        if (r104 != null) goto L10;
        int r107 = 0;
    L11:
        if (r104 != null) goto L13;
        String r108 = "";
    L14:
        if (r107 == 1) goto L17;
        r105 = false;
    L17:
        onAuthVerifyEndEvent(r106, r105, r108);
    L19:
        H5CallBack r109 = this.mH5CallBack;
        if (r109 == null) goto L26;
        if (r100 == null) goto L26;
        if (TextUtils.isEmpty(getFaceLiveManager().f520424c) == false) goto L43;
    L25:
        this.mH5CallBack.onH5Close(r100);
        this.mH5CallBack = null;
        CertLog.d("#h5callback", fyb.a.KEY_DATA + r100);
    L30:
        if (this.mProgressCallback == null) goto L40;
        if (r100 == null) goto L40;
        if (r104 == null) goto L34;
        r101 = r104.optInt("mode");
    L39:
        this.mProgressCallback.progressFinish(r101, r100);
        goto L40
    L34:
        String r110 = this.mCertInfo.f526569c;
        if (r110 == null) goto L39;
        if (TextUtils.isDigitsOnly(r110) == false) goto L39;
        r101 = CastIntegerProtector.parseInt(this.mCertInfo.f526569c);
    L40:
        BytedCertManager.getInstance().stopFlow(this.mFlowId);
        return;
    L43:
        r100.put("video_path", getFaceLiveManager().f520424c);     // Catch: JSONException -> L42
    L26:
        if (r109 != null) goto L28;
        CertLog.d("#h5callback", "call back is null");
        goto L30
    L28:
        CertLog.d("#h5callback", "data is null");
        goto L30
    L13:
        r108 = r104.optString(EventConstant.Key.ALL_MODULE);
        goto L14
    L10:
        r107 = r104.optInt(EventConstant.Key.IS_FINISH);
        goto L11
    L7:
        r106 = new BDResponse(new Pair(Integer.valueOf(r102), r103));
        goto L8
    L18:
        r104 = null;
        goto L19
    }

    public void startBytedCertFlow(BytedCertFlowParams r100) {
        if (start(r100) == true) goto L5;
        return;
    L5:
        this.mH5CallBack = r100.getH5CallBack();
        this.mCertResultCallback = r100.getCertResultCallback();
        this.mWebEventCallback = r100.getWebEventCallback();
        this.mProgressCallback = r100.getProgressCallback();
        this.mStartTimestamp = System.currentTimeMillis();
        ICertLoadingDialog r101 = createCertLoadingDialog(r100);
        if (getThemeConfig().isInitNeedLoading() == false) goto L8;
    L9:
        rsa.b.c(r101);
    L10:
        setStartTimestamp(EventConstant.Key.FULL_FLOW_TIMESTAMP);
        BytedCertManager.getInstance().reportBadger();
        initSDKInternal(r100.getContext(), r101);
        return;
    L8:
        if (r100.isShowLoading() == false) goto L10;
        goto L9
    }

    public static /* synthetic */ void access$000(BytedCertFlow r100, BDResponse r101) {
        r100.parseJSONToCertInfo(r101);
    }

    private void authInitRequest(Context r100, final SDKCallBack.CommonRequestCallback r101) {
        BDResponse r102 = initCheck(r100);
        if (r102 == null) goto L6;
        r101.onRequestFinish(r102);
        return;
    L6:
        boolean r103 = this.mCertInfo.f526577k;
        HashMap r104 = new HashMap();
        r104.put(BytedCertConstant.CertKey.DEVICE_SUPPORT_NFC, String.valueOf(isSupportedNFC(r100)));
        r104.put(BytedCertConstant.CertKey.DEVICE_SUPPORT_CN_NET_AUTH, String.valueOf(isSupportCnNetAuth()));
        String r105 = UrlConstant.getSdkInitPath(r103);
        getRequestUtils().c(new AnonymousClass1(this, r101), "POST", r105, appendCommonRequestParams(r104));
    }

    private void callbackH5Failed(Context r100, BDResponse r101) {
        if (r101 == null) goto L13;
    L4:
        final int r102 = r101.errorCode;     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r101.detailErrorMsg) == false) goto L7;
        final String r103 = r100.getApplicationContext().getString(R.string.byted_check_network);     // Catch: Exception -> L10
    L8:
        final JSONObject r104 = new JSONObject();     // Catch: Exception -> L10
        r104.put("error_code", r102);     // Catch: Exception -> L10
        r104.put("error_msg", r103);     // Catch: Exception -> L10
        showErrDialog(r100, r103, new AnonymousClass3(this, r104, r102, r103));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        r103 = r101.detailErrorMsg;     // Catch: Exception -> L10
        goto L8
    L13:
        r101 = new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN);     // Catch: Exception -> L10
        goto L4
    }

    private void initSDKInternal(final Context r100, final ICertLoadingDialog r101) {
        authInitRequest(r100, new AnonymousClass2(this, r101, r100));
    }

    public static /* synthetic */ void access$1100(BytedCertFlow r100, Context r101, BDResponse r102) {
        r100.callbackH5Failed(r101, r102);
    }

    public void startVideoRecord(Context r100, Map<String, String> r101, String r102, String r110, SDKCallBack.VideoRecordCallback r111) {
        if (TextUtils.isEmpty(this.mFlowId) == false) goto L10;
        String r103 = UUID.randomUUID().toString();
    L6:
        if (BytedCertManager.getInstance().getFlowMap().containsKey(r103) == false) goto L8;
        r103 = UUID.randomUUID().toString();
        goto L6
    L8:
        BytedCertManager.getInstance().getFlowMap().put(r103, this);
        this.mFlowId = r103;
    L10:
        if (this.mVideoRecordController != null) goto L13;
        this.mVideoRecordController = new VideoRecordController(this);
    L13:
        if (TextUtils.isEmpty(r110) == false) goto L15;
        r110 = this.mLanguage;
    L15:
        VideoRecordController r104 = this.mVideoRecordController;
        r104.startVideoRecord(r100, r101, r102, r110, r111);
    }
}
