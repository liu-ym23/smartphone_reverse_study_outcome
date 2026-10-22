package com.ss.android.bytedcert.flow.face;

import android.content.Context;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.callback.FaceLiveInterruptListener;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.camera.refactor.mi.MiSecCamService;
import com.ss.android.bytedcert.dialog.MessageDialog;
import com.ss.android.bytedcert.dialog.controller.base.ICameraController;
import com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity;
import com.ss.android.bytedcert.face.ui.FaceDetectFullActivity;
import com.ss.android.bytedcert.face.ui.FaceDetectPercentActivity;
import com.ss.android.bytedcert.flow.base.AbsCertFlow;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.model.LiveInfo;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.BytedCertSdkInitParam;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.ablity.ICertLoadingDialog;
import com.ss.android.cert.manager.callback.CertCallback;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.permission.PermissionHelper;
import com.ss.android.cert.manager.permission.PermissionRequest;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.LocaleHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jsa.g;
import jsa.m;
import nsa.a;
import nsa.b;
import org.json.JSONException;
import org.json.JSONObject;
import rsa.d;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class FaceDetectFlow extends AbsCertFlow implements ICameraController {
    private static final String TAG = "FaceDetectFlow";
    private int cameraStartType;
    private final a faceLiveManager;
    protected osa.a mActionInfo;
    private ICertDialogDepend mCertDialogDepend;
    private long mFaceInitTime;
    private SDKCallBack.FaceLiveCallback mFaceLiveCallback;
    private FaceLiveInitDurationHelper mFaceLiveInitDurationHelper;
    private FaceLiveInterruptListener mFaceLiveInterruptListener;
    private long mFaceLiveTime;
    private long mFaceStartTime;
    private LiveInfo mLiveInfo;
    private final b monitorManager;
    private boolean openLiveOpt;
    private boolean sGLPause;
    private boolean sLiveSDKRunning;

    private void startBytedFaceLive(Context r100, ICertLoadingDialog r101, Map<String, String> r102) {
    }

    public Map<String, String> createSubmitLiveParams() {
        HashMap r100 = new HashMap();
        if (TextUtils.isEmpty(this.mCertInfo.f526571e) == true) goto L6;
        r100.put(BytedCertConstant.CertKey.IDENTITY_CODE, this.mCertInfo.f526571e);
    L6:
        if (TextUtils.isEmpty(this.mCertInfo.f526572f) == true) goto L9;
        r100.put(BytedCertConstant.CertKey.IDENTITY_NAME, this.mCertInfo.f526572f);
    L9:
        if (TextUtils.isEmpty(this.mCertInfo.f526574h) == true) goto L11;
        r100.put(BytedCertConstant.CertKey.LIVE_TYPE, this.mCertInfo.f526574h);
    L11:
        StringBuilder r101 = new StringBuilder(BytedCertConstant.LiveType.DEFAULT_TYPES);
        if (TextUtils.equals(this.mCertInfo.L, "dialog_face") == true) goto L14;
        r101.append(",motion_with_reflection");
    L14:
        r100.put(BytedCertConstant.CertKey.SUPPORT_LIVENESS_TYPES, r101.toString());
        r100.put("protocol_ver", "1");
        return r100;
    }

    public String getLiveType() {
        LiveInfo r100 = this.mLiveInfo;
        if (r100 != null) goto L5;
        return BytedCertConstant.LiveType.LIVE_TYPE_ACTION;
    L5:
        if (TextUtils.isEmpty(r100.f407582g) == false) goto L8;
        return BytedCertConstant.LiveType.LIVE_TYPE_ACTION;
    L8:
        return this.mLiveInfo.f407582g;
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public boolean isLiveSdkPaused() {
        return !this.sLiveSDKRunning;
    }

    public FaceDetectFlow() {
        this.monitorManager = new b();
        this.faceLiveManager = new a();
    }

    public osa.a getActionInfo() {
        return this.mActionInfo;
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public int getCameraStartType() {
        return this.cameraStartType;
    }

    public ICertDialogDepend getCertDialogDepend() {
        return this.mCertDialogDepend;
    }

    public long getFaceInitTime() {
        return this.mFaceInitTime;
    }

    public a getFaceLiveManager() {
        return this.faceLiveManager;
    }

    public long getFaceLiveTime() {
        return this.mFaceLiveTime;
    }

    public long getFaceStartTime() {
        return this.mFaceStartTime;
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public LiveInfo getLiveInfo() {
        return this.mLiveInfo;
    }

    public b getMonitorManager() {
        return this.monitorManager;
    }

    @Override // com.ss.android.bytedcert.dialog.controller.base.ICameraController
    public boolean isGLPause() {
        return this.sGLPause;
    }

    public boolean isOpenLiveOpt() {
        return this.openLiveOpt;
    }

    public static /* synthetic */ osa.b access$1100(FaceDetectFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ FaceLiveInterruptListener access$1300(FaceDetectFlow r100) {
        return r100.mFaceLiveInterruptListener;
    }

    public static /* synthetic */ osa.b access$1600(FaceDetectFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ long access$1800(FaceDetectFlow r100) {
        return r100.mFaceStartTime;
    }

    public static /* synthetic */ String access$1900(FaceDetectFlow r100) {
        return r100.mFlowId;
    }

    public static /* synthetic */ osa.b access$200(FaceDetectFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ a access$2400(FaceDetectFlow r100) {
        return r100.faceLiveManager;
    }

    public static /* synthetic */ String access$2500(FaceDetectFlow r100) {
        return r100.mFlowId;
    }

    public static /* synthetic */ osa.b access$300(FaceDetectFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ osa.b access$400(FaceDetectFlow r100) {
        return r100.mCertInfo;
    }

    public static /* synthetic */ LiveInfo access$700(FaceDetectFlow r100) {
        return r100.mLiveInfo;
    }

    public static /* synthetic */ String access$800(FaceDetectFlow r100) {
        return r100.mFlowId;
    }

    private void enableLivenessOpt(BDResponse r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r101 = r100.jsonData;
        if (r101 != null) goto L7;
        r101 = new JSONObject();
    L7:
        JSONObject r102 = r101.optJSONObject(BytedCertConstant.CertKey.BACKEND_DECISION);
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.optString(BytedCertConstant.CertKey.LIVE_DETECT_OPTIMIZE).equalsIgnoreCase("all") == false) goto L12;
    L15:
        boolean r103 = true;
    L16:
        this.openLiveOpt = r103;
        return;
    L12:
        if (r102.optString(BytedCertConstant.CertKey.LIVE_DETECT_OPTIMIZE).equalsIgnoreCase(BytedCertConstant.CertKey.ONLY_CLIENT) == true) goto L15;
        r103 = false;
        goto L16
    }

    private void onCertStartFaceLiveEvent(BDResponse r100) {
        JSONObject r101 = new JSONObject();
        r101.put(EventConstant.Key.DURING_QUERY_INIT, this.mFaceInitTime);     // Catch: Exception -> L21
        if (r100 == null) goto L19;
        if (r100.success == false) goto L8;
        String r102 = "1";
    L9:
        r101.put("result", r102);     // Catch: Exception -> L21
        r101.put("error_code", String.valueOf(r100.errorCode));     // Catch: Exception -> L21
        String r103 = "";
        if (TextUtils.isEmpty(r100.errorMsg) == false) goto L13;
        String r104 = "";
    L14:
        r101.put("fail_reason", r104);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r100.detailErrorMsg) == true) goto L18;
        r103 = r100.detailErrorMsg;     // Catch: Exception -> L21
    L18:
        r101.put("error_stack", r103);     // Catch: Exception -> L21
        goto L19
    L13:
        r104 = r100.errorMsg;     // Catch: Exception -> L21
        goto L14
    L8:
        r102 = "0";
    L19:
        onEvent(EventConstant.Event.CERT_START_FACE_LIVE, r101);
    }

    private void onFaceLiveReqEvent(boolean r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == false) goto L6;
        String r102 = EventConstant.Value.WEB_REQ_SUCCESS;
    L11:
        r101.put(EventConstant.Key.WEB_REQ_RESULT, r102);     // Catch: Exception -> L10
    L8:
        onEvent(EventConstant.Event.FACE_DETECTION_START_WEB_REQ, r101);
        return;
    L6:
        r102 = EventConstant.Value.WEB_REQ_FAIL;
        goto L11
    }

    private void reportFaceLiveTime(BDResponse r100) {
        JSONObject r101 = new JSONObject();
        if (isBytedCertFlow() == false) goto L5;
        String r102 = EventConstant.Event.CERT_START_FACE_LIVE_INTERNAL;
    L30:
    L26:
        e = move-exception;
        e.printStackTrace();
    L28:
        onEvent(r102, r101);
        return;
    L7:
        if (isBytedCertFlow() == true) goto L9;
        r101.put(EventConstant.Key.DURING_QUERY_INIT, this.mFaceInitTime);     // Catch: Exception -> L26
    L9:
        r101.put(EventConstant.Key.DURING_QUERY_LIVE, this.mFaceLiveTime);     // Catch: Exception -> L26
        if (r100 == null) goto L28;
        if (r100.success == false) goto L14;
        String r103 = "1";
    L15:
        r101.put("result", r103);     // Catch: Exception -> L26
        r101.put("error_code", String.valueOf(r100.errorCode));     // Catch: Exception -> L26
        String r104 = "";
        if (TextUtils.isEmpty(r100.errorMsg) == false) goto L19;
        String r105 = "";
    L20:
        r101.put("fail_reason", r105);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r100.detailErrorMsg) == true) goto L24;
        r104 = r100.detailErrorMsg;     // Catch: Exception -> L26
    L24:
        r101.put("error_stack", r104);     // Catch: Exception -> L26
        goto L28
    L19:
        r105 = r100.errorMsg;     // Catch: Exception -> L26
        goto L20
    L14:
        r103 = "0";
        goto L15
    L5:
        r102 = EventConstant.Event.CERT_START_FACE_LIVE;
        goto L30
    }

    @Override // com.ss.android.bytedcert.flow.base.AbsCertFlow
    public JSONObject appendEventParams(JSONObject r100) {
        JSONObject r101 = super.appendEventParams(r100);
        LiveInfo r102 = this.mLiveInfo;     // Catch: Exception -> L21
        if (r102 == null) goto L18;
        int r103 = 1;
        if (r102.f407586k == false) goto L8;
        int r104 = 1;
    L9:
        r101.put("voice_guide_server", r104);     // Catch: Exception -> L21
        if (this.mLiveInfo.f407587l == true) goto L13;
        r103 = 0;
    L13:
        r101.put("voice_guide_user", r103);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(this.mLiveInfo.f407582g) == true) goto L16;
        r101.put(EventConstant.Key.VERIFY_DETECTION_TYPE, this.mLiveInfo.f407582g);     // Catch: Exception -> L21
    L16:
        r101.put(EventConstant.Key.REQUIRE_LIST, this.mLiveInfo.f());     // Catch: Exception -> L21
        r101.put(EventConstant.Key.FALLBACK_MOTION_TYPES, this.mLiveInfo.c());     // Catch: Exception -> L21
        goto L18
    L8:
        r104 = 0;
    L18:
        if (TextUtils.isEmpty(this.mCertInfo.L) == true) goto L20;
        r101.put(EventConstant.Key.FACE_DETECTION_VIEW_TYPE, this.mCertInfo.L);     // Catch: Exception -> L21
    L20:
        return r101;
    }

    public void doFaceLive(FaceDetectFlowParams r100) {
        if (start(r100) == true) goto L5;
        return;
    L5:
        this.mFaceLiveCallback = r100.getFaceLiveCallback();
        this.mFaceLiveInterruptListener = r100.getFaceLiveInterruptListener();
        this.mCertDialogDepend = r100.getCertDialogDepend();
        setStartTimestamp(EventConstant.Key.FACE_DETECT_TIMESTAMP);
        this.mFaceStartTime = System.currentTimeMillis();
        if (r100.isOffline() == false) goto L9;
        doOfflineFaceLive(r100.getContext(), r100.getBitmap());
        return;
    L9:
        ICertLoadingDialog r101 = createCertLoadingDialog(r100);
        if (getThemeConfig().isInitNeedLoading() == false) goto L12;
    L15:
        rsa.b.c(r101);
    L16:
        doFaceInit(r100.getContext(), r101);
        return;
    L12:
        if (r100.isShowLoading() == true) goto L15;
        if (TextUtils.equals(this.mCertInfo.L, "dialog_face") == false) goto L16;
        goto L15
    }

    public void onFaceLiveFinish(BDResponse r100) {
        boolean r101 = r100.success;
        onFaceLiveFinish(r100, r101, r101, null);
    }

    public void onInitModuleStart(String r100) {
        FaceLiveInitDurationHelper r101 = this.mFaceLiveInitDurationHelper;
        if (r101 == null) goto L6;
        r101.onStart(r100);
        return;
    }

    public void setCameraStartType(int r100) {
        this.cameraStartType = r100;
    }

    public void setGLPause(boolean r100) {
        this.sGLPause = r100;
    }

    public void setLiveInfo(LiveInfo r100) {
        this.mLiveInfo = r100;
    }

    public void setLiveSDKRunning(boolean r100) {
        this.sLiveSDKRunning = r100;
    }

    public static /* synthetic */ void access$000(FaceDetectFlow r100, BDResponse r101) {
        r100.enableLivenessOpt(r101);
    }

    public static /* synthetic */ void access$100(FaceDetectFlow r100, BDResponse r101) {
        r100.parseJSONToCertInfo(r101);
    }

    public static /* synthetic */ void access$1200(FaceDetectFlow r100, BDResponse r101) {
        r100.reportFaceLiveTime(r101);
    }

    public static /* synthetic */ long access$1702(FaceDetectFlow r100, long r101) {
        r100.mFaceLiveTime = r101;
        return r101;
    }

    public static /* synthetic */ void access$600(FaceDetectFlow r100, boolean r101) {
        r100.onFaceLiveReqEvent(r101);
    }

    public static /* synthetic */ LiveInfo access$702(FaceDetectFlow r100, LiveInfo r101) {
        r100.mLiveInfo = r101;
        return r101;
    }

    private void callbackOriginalFailed(Context r100, final BDResponse r101) {
        if (r101 != null) goto L5;
        r101 = new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN);
    L5:
        if (TextUtils.isEmpty(r101.detailErrorMsg) == false) goto L7;
        String r102 = getMultiLanguageString(r100.getApplicationContext(), R.string.byted_check_network);
    L8:
        List<Integer> r103 = this.mCertInfo.E;
        if (r103 == null) goto L14;
        ArrayList r104 = (ArrayList) r103;
        if (r104.contains(Integer.valueOf(r101.errorCode)) == false) goto L14;
        onFaceLiveFinish(r101);
        return;
    L14:
        showErrDialog(r100, r102, new AnonymousClass10(this, r101));
        return;
    L7:
        r102 = r101.detailErrorMsg;
        goto L8
    }

    private void doFaceInit(final Context r100, final ICertLoadingDialog r101) {
        BDResponse r102 = initCheck(r100);
        if (r102 == null) goto L13;
        rsa.b.b(r101);
        FaceLiveInterruptListener r103 = this.mFaceLiveInterruptListener;
        if (r103 != null) goto L7;
    L10:
        reportFaceLiveTime(r102);
        onFaceLiveReqEvent(false);
        onFaceLiveFinish(r102);
        return;
    L7:
        if (r103.shouldInterrupt() == false) goto L10;
        reportFaceLiveTime(r102);
        onFaceLiveFinish(new BDResponse(ErrorConstant.Client.ERROR_FACE_LIVE_INTERRUPT));
        return;
    L13:
        if (isBytedCertFlow() == true) goto L15;
        BytedCertManager.getInstance().reportBadger();
    L15:
        final Map<String, String> r104 = createSubmitLiveParams();
        r104.put(BytedCertConstant.CertKey.DEVICE_SUPPORT_NFC, String.valueOf(isSupportedNFC(r100)));
        r104.put(BytedCertConstant.CertKey.DEVICE_SUPPORT_CN_NET_AUTH, String.valueOf(isSupportCnNetAuth()));
        String r105 = CertManager.getInstance().getAliyunMetaInfos(r100);
        if (TextUtils.isEmpty(r105) == true) goto L18;
        r104.put("meta_info", r105);
        String r106 = "byte,aliCloud";
    L19:
        r104.put(BytedCertConstant.CertKey.SUPPORT_CHANNELS, r106);
        getRequestUtils().c(new AnonymousClass1(this, r100, r101, r104), "POST", UrlConstant.getFaceInitPath(), appendCommonRequestParams(r104));
        return;
    L18:
        r106 = "byte";
        goto L19
    }

    private void doOfflineFaceLive(Context r100, Bitmap r110) {
        if (r100 == null) goto L19;
        if (r110 == null) goto L19;
        BDResponse r101 = BytedCertManager.getInstance().checkModelAvailable(BytedCertManager.OFFLINE_MODEL_PRE, OperationName.OPERATION_OFFLINE_AVAILABLE);
        if (r101 == null) goto L9;
        onFaceLiveFinish(r101);
        return;
    L9:
        int r102 = 0;
        this.sGLPause = false;
        this.sLiveSDKRunning = false;
        LiveInfo r103 = new LiveInfo(this.mFlowId);
        r103.f407579d = true;
        r103.f407580e = 5;
        r103.f407581f = r110;
        int r111 = this.mCertInfo.f526575i;
        if (r111 > 0) goto L12;
    L17:
        this.mLiveInfo = r103;
        launchFaceLiveActivity(r100, null);
        return;
    L12:
        if (r111 > 3) goto L17;
        ArrayList r104 = new ArrayList(Arrays.asList(new Integer[]{0, 2, 3}));
        Collections.shuffle(r104);
        r103.f407592q = new int[r111];
    L15:
        if (r102 >= r111) goto L17;
        r103.f407592q[r102] = ((Integer) ListProtector.get(r104, r102)).intValue();
        r102 = r102 + 1;
    L19:
        onFaceLiveFinish(new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN));
    }

    private void launchFaceLiveActivity(Context r110, final ICertLoadingDialog r111) {
        MiSecCamService r100 = MiSecCamService.b.f407309a;
        r100.getClass();
        if (Build.MANUFACTURER.equalsIgnoreCase(DimLocationCheckUtil.XIAOMI) == false) goto L5;
        r100.f407306d = MiSecCamService.Status.CONNECTING;
        r100.f407303a = r110.getApplicationContext();
        ThreadPlus.submitRunnable(new com.ss.android.bytedcert.camera.refactor.mi.a(r100));
    L5:
        int r101 = 0;
        this.sGLPause = false;
        this.sLiveSDKRunning = true;
        boolean r102 = TextUtils.equals("video", this.mCertInfo.f526574h);
        FaceLiveInitDurationHelper r103 = new FaceLiveInitDurationHelper(this);
        this.mFaceLiveInitDurationHelper = r103;
        r103.onStart(FaceLiveInitDurationHelper.Module.CHECK_PERMISSION);
        PermissionHelper.PermissionRequestCallback r112 = new AnonymousClass5(this, r111);
        PermissionHelper.OnPermissionEventListener r104 = new AnonymousClass6(this);
        CertLog.d(TAG, "check camera permission");
        if (TextUtils.equals(this.mCertInfo.L, "dialog_face") == false) goto L17;
        LiveInfo r105 = this.mLiveInfo;
        int[] r106 = r105.f407592q;
        if (r106 != null) goto L10;
    L15:
        r105.a(EventConstant.Key.FACE_DETECTION_VIEW_TYPE, this.mCertInfo.L);
        String r107 = getLanguage();
        String r108 = this.mFlowId;
        boolean r109 = this.mCertInfo.f526589w;
        String r113 = getLanguage();
        int r114 = FaceDetectDialogActivity.f407433x;
        BytedCertSdkAbsActivity.y1(r110, -1, r107, new jsa.a(r108, r109, r113, r102), r104, r112);
        return;
    L10:
        if (r106.length == 0) goto L15;
        if (r106.length != 1) goto L17;
        if (r106[0] == 0) goto L15;
    L17:
        osa.b r115 = this.mCertInfo;
        r115.L = BytedCertConstant.CertValue.TYPE_FULL_FACE;
        double r116 = r115.f526566J;
        if (r116 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
        double r117 = r115.K;
        if (r117 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
        float r118 = (float) r116;
        float r119 = (float) r117;
    L55:
        if (this.mCertInfo.I <= 0) goto L65;
        WindowManager r120 = (WindowManager) r110.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r120 != null) goto L59;
        int r121 = i.e(r110);
    L60:
        osa.b r122 = this.mCertInfo;
        int r123 = (r122.I * 100) / r121;
        if (r123 < 60) goto L64;
        if (r123 >= 100) goto L64;
        r122.L = BytedCertConstant.CertValue.TYPE_PERCENT_FACE;
        this.mLiveInfo.a(EventConstant.Key.FACE_DETECTION_VIEW_TYPE, BytedCertConstant.CertValue.TYPE_PERCENT_FACE);
        String r124 = getLanguage();
        String r125 = this.mFlowId;
        osa.b r126 = this.mCertInfo;
        boolean r127 = r126.f526589w;
        int r128 = r126.I;
        String r129 = getLanguage();
        int r130 = FaceDetectPercentActivity.I;
        BytedCertSdkAbsActivity.y1(r110, -1, r124, new m(r125, r118, r119, r128, r127, r129, r102), r104, r112);
        return;
    L64:
        String r131 = getLanguage();
        String r132 = this.mFlowId;
        boolean r133 = this.mCertInfo.f526589w;
        String r134 = this.mLanguage;
        int r135 = FaceDetectFullActivity.H;
        BytedCertSdkAbsActivity.y1(r110, -1, r131, new g(r132, r118, r119, r133, r134, r102), r104, r112);
        return;
    L59:
        Point r136 = new Point();
        r120.getDefaultDisplay().getRealSize(r136);
        r121 = r136.y;
        goto L60
    L65:
        String r137 = getLanguage();
        String r138 = this.mFlowId;
        boolean r139 = this.mCertInfo.f526589w;
        String r140 = this.mLanguage;
        int r141 = FaceDetectFullActivity.H;
        BytedCertSdkAbsActivity.y1(r110, -1, r137, new g(r138, r118, r119, r139, r140, r102), r104, r112);
        return;
    L22:
        List<BytedCertSdkInitParam.FaceDetectCycleConfig> r142 = BytedCertSdkManager.getInstance().getFaceDetectCycleConfig();
        if (r142 != null) goto L25;
    L53:
        r118 = 0.0f;
        r119 = 0.0f;
        goto L55
    L25:
        if (r142.size() <= 0) goto L53;
        WindowManager r143 = (WindowManager) r110.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r144 = new DisplayMetrics();
        r143.getDefaultDisplay().getMetrics(r144);
        int r145 = r144.widthPixels;
        int r146 = r144.heightPixels;
        int r147 = Math.min(r145, r146);
        int r148 = Math.max(r145, r146);
        if (r145 <= r146) goto L29;
        float r149 = r147 * 0.25f;
    L31:
        if (r142.size() > 0) goto L33;
    L51:
        float r150 = 0.0f;
    L52:
        Pair r151 = new Pair(Float.valueOf(r149), Float.valueOf(r150));
        float r152 = ((Float) r151.second).floatValue();
        r119 = ((Float) r151.first).floatValue();
        r118 = r152;
    L33:
        if (r101 >= r142.size()) goto L51;
        BytedCertSdkInitParam.FaceDetectCycleConfig r153 = (BytedCertSdkInitParam.FaceDetectCycleConfig) ListProtector.get(r142, r101);
        if (r144.densityDpi >= r153.getBaseDpi()) goto L37;
        r101 = r101 + 1;
        goto L33
    L37:
        if ((-0.3f) <= r153.getOffsetYScale()) goto L39;
    L41:
        r150 = 0.0f;
    L43:
        if (r153.getRadiusScale() >= 0.2f) goto L45;
    L48:
        float r154 = r147;
        float r155 = 0.3f;
    L49:
        r149 = r154 * r155;
        goto L52
    L45:
        if (r153.getRadiusScale() >= 0.38f) goto L48;
        r154 = r147;
        r155 = r153.getRadiusScale();
        goto L49
    L39:
        if (r153.getOffsetYScale() > 0.25f) goto L41;
        r150 = (-r148) * r153.getOffsetYScale();
        goto L43
    L29:
        r149 = (r147 * 0.75910366f) / 2.0f;
        goto L31
    }

    private void onCameraPermissionEvent(Map<String, PermissionEntity> r100, String r101) {
        if (r100 == null) goto L4;
        boolean r102 = r100.containsKey("android.permission.CAMERA");
    L12:
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L11
        if (r102 == false) goto L8;
        String r104 = EventConstant.Value.HAS_PERMISSION;
    L9:
        r103.put(EventConstant.Key.CAMERA_PERMIT, r104);     // Catch: Exception -> L11
        r103.put("grant_type", r101);     // Catch: Exception -> L11
        onEvent(EventConstant.Event.FACE_DETECTION_CAMERA_PERMIT, r103);     // Catch: Exception -> L11
        return;
    L8:
        r104 = "no_permission";
    L14:
        return;
    L4:
        r102 = false;
        goto L12
    }

    private void onFaceInitRequestEvent(boolean r100, boolean r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L12
        r102.put("duration", System.currentTimeMillis() - this.mFaceStartTime);     // Catch: Exception -> L12
        if (r100 == false) goto L5;
        int r103 = 1;
    L6:
        r102.put("is_merge", r103);     // Catch: Exception -> L12
        if (r101 == false) goto L9;
        String r104 = "success";
    L10:
        r102.put("result", r104);     // Catch: Exception -> L12
        onEvent(EventConstant.Event.EVENT_FACE_DETECTION_INIT_REQUEST, r102);     // Catch: Exception -> L12
        return;
    L9:
        r104 = "fail";
        goto L10
    L5:
        r103 = 0;
    }

    private void processVoiceConfig(final Context r100, final ICertLoadingDialog r101) {
        rsa.b.b(r101);
        if (this.mLiveInfo.f407586k == false) goto L5;
        CertLog.d(TAG, "startBytedFaceLive with voice");
        new MessageDialog.Builder(r100).setMessage(getMultiLanguageString(r100.getApplicationContext(), R.string.byted_voice_prompt_tip)).setCancelable(false).setNegativeButton(getMultiLanguageString(r100.getApplicationContext(), R.string.byted_voice_prompt_off), new AnonymousClass4(this, r100, r101)).setPositiveButton(getMultiLanguageString(r100.getApplicationContext(), R.string.byted_voice_prompt_on), new AnonymousClass3(this, r100, r101)).show();
        return;
    L5:
        CertLog.d(TAG, "startBytedFaceLive without voice");
        if (this.mCertInfo.F == false) goto L8;
        this.mLiveInfo.f407587l = true;
    L8:
        launchFaceLiveActivity(r100, r101);
    }

    public void onInitModuleEnd(String r100, boolean r101) {
        FaceLiveInitDurationHelper r102 = this.mFaceLiveInitDurationHelper;
        if (r102 == null) goto L6;
        r102.onEnd(r100, r101);
        return;
    }

    public void uploadVideoRecord(String r100, SDKCallBack.CommonRequestCallback r101) {
        uploadVideoRecord(r100, UrlConstant.getSaveCertVideoPath(), r101);
    }

    public static /* synthetic */ void access$1400(FaceDetectFlow r100, Context r101, BDResponse r102) {
        r100.callbackOriginalFailed(r101, r102);
    }

    public static /* synthetic */ void access$1500(FaceDetectFlow r100, boolean r101, boolean r102) {
        r100.onFaceInitRequestEvent(r101, r102);
    }

    public static /* synthetic */ void access$2000(FaceDetectFlow r100, Context r101, ICertLoadingDialog r102) {
        r100.launchFaceLiveActivity(r101, r102);
    }

    public static /* synthetic */ void access$2100(FaceDetectFlow r100, Map r101, String r102) {
        r100.onCameraPermissionEvent(r101, r102);
    }

    public static /* synthetic */ void access$900(FaceDetectFlow r100, Context r101, ICertLoadingDialog r102) {
        r100.processVoiceConfig(r101, r102);
    }

    private void onFinalResultEvent(BDResponse r100, boolean r110, HashMap<String, String> r111) {
        JSONObject r101 = new JSONObject();
        String r102 = "success";
        if (r100.success == false) goto L7;
        Object r103 = "success";
    L8:
        r101.put("result", r103);     // Catch: Exception -> L40
        if (r100.success == false) goto L13;
    L17:
        r101.put("error_code", String.valueOf(r100.detailErrorCode));     // Catch: Exception -> L40
        if (r110 == true) goto L21;
        r102 = "fail";
    L21:
        r101.put(EventConstant.Key.SDK_RESULT, r102);     // Catch: Exception -> L40
        JSONObject r112 = r100.jsonData;     // Catch: Exception -> L40
        if (r112 != null) goto L24;
    L29:
        if (r111 == null) goto L37;
        Iterator<Map.Entry<String, String>> r104 = r111.entrySet().iterator();     // Catch: Exception -> L40
    L32:
        if (r104.hasNext() == false) goto L37;
        Map.Entry<String, String> r113 = r104.next();     // Catch: Exception -> L40
        if (TextUtils.isEmpty(r113.getValue()) == true) goto L32;
        r101.put(r113.getKey(), r113.getValue());     // Catch: Exception -> L40
    L37:
        r101.put(EventConstant.Key.FULL_FLOW_TIMESTAMP, getTimestampMap(EventConstant.Key.FACE_DETECT_TIMESTAMP).toString());     // Catch: Exception -> L40
        goto L38
    L24:
        if (r112.has(EventConstant.Key.CERT_CODE) == false) goto L27;
        r101.put(EventConstant.Key.CERT_CODE, r100.jsonData.optString(EventConstant.Key.CERT_CODE));     // Catch: Exception -> L40
    L27:
        if (r100.jsonData.has(EventConstant.Key.CERT_SUB_CODE) == false) goto L29;
        r101.put(EventConstant.Key.CERT_SUB_CODE, r100.jsonData.optString(EventConstant.Key.CERT_SUB_CODE));     // Catch: Exception -> L40
        goto L29
    L13:
        if (TextUtils.isEmpty(r100.detailErrorMsg) == false) goto L15;
        r101.put("fail_reason", "");     // Catch: Exception -> L40
        r101.put(EventConstant.Key.RAW_DATA, r100.toString());     // Catch: Exception -> L40
    L16:
        r101.put("error_code", String.valueOf(r100.detailErrorCode));     // Catch: Exception -> L40
        goto L17
    L15:
        r101.put("fail_reason", r100.detailErrorMsg);     // Catch: Exception -> L40
        goto L16
    L7:
        r103 = "fail";
    L38:
        onEvent(EventConstant.Event.FACE_DETECTION_FINAL_RESULT, r101);
    }

    private void startAliyunFaceLive(final Context r110, ICertLoadingDialog r111, final BDResponse r112) {
        this.mFaceLiveTime = System.currentTimeMillis() - this.mFaceStartTime;
        rsa.b.b(r111);
        onFaceLiveReqEvent(true);
        final int r100 = this.mCertInfo.f526581o;
        final CertCallback r101 = new AnonymousClass7(this, r100);
        PermissionHelper.checkRequestPermissions(r110, AbsCertFlow.getPermissionLocalStrings(r110, getLanguage()), new AnonymousClass8(this), new PermissionRequest().addEntity(PermissionEntity.getCameraEntity(r110, LocaleHelper.getMultiLanguageString(r110, getLanguage(), R.string.byted_permission_camera))).setCallback(new AnonymousClass9(this, r112, r100, r110, r101)));
    }

    public void onInitModuleFinish(String r100, boolean r101, boolean r102) {
        FaceLiveInitDurationHelper r103 = this.mFaceLiveInitDurationHelper;
        if (r103 == null) goto L6;
        r103.onFinish(r100, r101, r102);
        this.mFaceLiveInitDurationHelper = null;
        return;
    }

    public void uploadVideoRecord(String r100, String r101, SDKCallBack.CommonRequestCallback r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r102.onRequestFinish(new BDResponse(ErrorConstant.Client.ERROR_VIDEO_RECORD_UN_EXISTS));
        return;
    L6:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100);
        if (r103.exists() == true) goto L10;
        r102.onRequestFinish(new BDResponse(ErrorConstant.Client.ERROR_VIDEO_RECORD_UN_EXISTS));
        return;
    L10:
        HashMap r104 = new HashMap();
        r104.put("video_data", new Pair(r103.getName(), d.i(r103)));
        psa.a r105 = getRequestUtils();
        Map<String, String> r106 = appendCommonRequestParams(null);
        r105.getClass();
        new psa.d(r105, r106, r101, r104, r102).start();
    }

    public static /* synthetic */ void access$2200(FaceDetectFlow r100, BDResponse r101, boolean r102, String r103) {
        r100.onAuthVerifyEndEvent(r101, r102, r103);
    }

    public static /* synthetic */ void access$2300(FaceDetectFlow r100, BDResponse r101, boolean r102, HashMap r103) {
        r100.onFinalResultEvent(r101, r102, r103);
    }

    public static /* synthetic */ void access$500(FaceDetectFlow r100, Context r101, ICertLoadingDialog r102, BDResponse r103) {
        r100.startAliyunFaceLive(r101, r102, r103);
    }

    public void onFaceLiveFinish(BDResponse r100, boolean r101, boolean r110, String r111) {
        this.sLiveSDKRunning = false;
        int r102 = 1;
        this.sGLPause = true;
        r100.ticket = this.mCertInfo.f526568b;
        a r103 = this.faceLiveManager;
        r100.sdkData = r103.f520422a;
        r100.videoPath = r103.f520424c;
        SDKCallBack.FaceLiveCallback r104 = this.mFaceLiveCallback;
        if (r104 == null) goto L5;
        r104.onFaceLiveFinish(r100);
        this.mFaceLiveCallback = null;
    L5:
        b r105 = this.monitorManager;
        r105.f520431b = r100.success;
        r105.f520433d = r100.errorCode;
        r105.f520432c = r100.errorMsg;
        JSONObject r106 = new JSONObject();
        StringBuilder r107 = new StringBuilder();     // Catch: JSONException -> L16
        Iterator<String> r108 = r105.f520430a.iterator();     // Catch: JSONException -> L16
    L8:
        if (r108.hasNext() == false) goto L10;
        r107.append(r108.next());     // Catch: JSONException -> L16
        r107.append(",");     // Catch: JSONException -> L16
        goto L8
    L10:
        r106.put(EventConstant.Key.SKD_PROCESS, r107.toString());     // Catch: JSONException -> L16
        r106.put("fail_reason", r105.f520432c);     // Catch: JSONException -> L16
        r106.put("error_code", r105.f520433d);     // Catch: JSONException -> L16
        if (r105.f520431b == true) goto L14;
        r102 = 2;
    L14:
        r106.put("result", r102);     // Catch: JSONException -> L16
    L18:
        onEvent(EventConstant.Event.SDK_FINAL_RESULT, r106);
        onFinalResultEvent(r100, r101, null);
        if (isBytedCertFlow() == true) goto L21;
        onAuthVerifyEndEvent(r100, r110, r111);
        BytedCertManager.getInstance().stopFlow(this.mFlowId);
    L21:
        MiSecCamService r109 = MiSecCamService.b.f407309a;
        if (r109.f407304b == null) goto L25;
        ThreadPlus.submitRunnable(new com.ss.android.bytedcert.camera.refactor.mi.b(r109));
    L25:
        ServiceConnection r112 = r109.f407305c;
        if (r112 == null) goto L30;
        Context r113 = r109.f407303a;
        if (r113 == null) goto L30;
        r113.unbindService(r112);
        r109.f407305c = null;
        r109.f407304b = null;
        r109.f407303a = null;
    L30:
        r109.f407306d = MiSecCamService.Status.NONE;
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    private void liveDetect(final Context r100, Map<String, String> r110, final Runnable r111, final Runnable r112, final boolean r113) {
        psa.a r101 = getRequestUtils();
        SDKCallBack.CommonRequestCallback r102 = new AnonymousClass2(this, r112, r111, r113, r100);
        boolean r103 = this.mCertInfo.f526576j;
        Map<String, String> r114 = appendCommonRequestParams(r110);
        r101.getClass();
        r101.c(r102, "GET", UrlConstant.getLiveDetectPath(r103, TextUtils.equals("video", r114.get(BytedCertConstant.CertKey.LIVE_TYPE))), r114);
    }

    public static /* synthetic */ void access$1000(FaceDetectFlow r100, Context r101, Map r102, Runnable r103, Runnable r104, boolean r105) {
        r100.liveDetect(r101, r102, r103, r104, r105);
    }
}
