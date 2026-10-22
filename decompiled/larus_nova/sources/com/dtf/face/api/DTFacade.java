package com.dtf.face.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.bef.effectsdk.RequirementDefine;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.dtf.face.config.FaceConfig;
import com.dtf.face.config.GuideConfig;
import com.dtf.face.config.IConstValues;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.dtf.face.network.model.NetworkEnv;
import com.dtf.face.ui.LandFaceLoadingActivity;
import com.dtf.face.ui.LandOpaqueFaceLoadingActivity;
import com.dtf.face.ui.PortFaceLoadingActivity;
import com.dtf.face.ui.PortOpaqueFaceLoadingActivity;
import com.dtf.face.utils.ClientConfigUtil;
import com.dtf.face.verify.IVerifyResultCallBack;
import com.heytap.mcssdk.constant.b;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import faceverify.q;
import hs7.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import qs7.c;
import ws7.g;
import ws7.h;
import ws7.j;
import ws7.o;
import ws7.p;
import ws7.r;
import ws7.s;

/* JADX INFO: loaded from: classes3.dex */
public class DTFacade {
    private static String deviceToken;
    private static boolean isInited;
    private static boolean sDelayInited;
    private Context ctx;
    private long flowStartTime;
    private IDTCallback zimCallback;

    /* JADX INFO: renamed from: com.dtf.face.api.DTFacade$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes22.dex */
    public class AnonymousClass2 implements IVerifyResultCallBack {
        public final /* synthetic */ DTFacade this$0;

        public AnonymousClass2(DTFacade r100) {
            this.this$0 = r100;
        }

        @Override // com.dtf.face.verify.IVerifyResultCallBack
        public void sendResAndExit(final String r100, final String r101) {
            if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
            this.this$0.sendResponse(a.h().f486989a, r100);
            return;
        L5:
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this, r100, r101));
        }
    }

    public void release() {
    }

    public DTFacade(Context r100) {
        this.zimCallback = null;
        this.flowStartTime = 0;
        a r101 = a.h();
        WeakReference<Context> r102 = r101.H;
        if (r102 == null) goto L5;
        r102.clear();
    L5:
        r101.H = new WeakReference(r100);
        if (r100 == null) goto L8;
        r100 = r100.getApplicationContext();
    L8:
        this.ctx = r100;
    }

    public static /* synthetic */ String access$002(String r100) {
        deviceToken = r100;
        return r100;
    }

    public static /* synthetic */ Context access$100(DTFacade r100) {
        return r100.ctx;
    }

    private static boolean delayInit(final Context r100) {
        boolean r101 = true;
        if (sDelayInited == false) goto L5;
        return true;
    L5:
        sDelayInited = true;
        a.h().S = EventConstant.Value.ALIYUN;
        RecordService.getInstance().resetLogFilePath();
        RecordService.getInstance().reportLogs();
        initSgomInfo(r100);
        deviceToken = DTFacadeExt.initApdid(r100, new AnonymousClass4(r100));
        NetworkEnv r102 = a.h().f487008t;
        if (r102 == null) goto L8;
        r101 = r102.isIPv6;
    L8:
        DTFacadeFaceExt.initOthers(r100, r101);
        p.o(r100);
        return false;
    }

    private static void initSgomInfo(Context r100) {
        SgomInfoManager.setContext(r100, new AnonymousClass3());
        SgomInfoManager.initEnv();
    }

    public void updateContext(Context r100) {
        a r101 = a.h();     // Catch: Throwable -> L7
        WeakReference<Context> r102 = r101.H;     // Catch: Throwable -> L7
        if (r102 == null) goto L5;
        r102.clear();     // Catch: Throwable -> L7
    L5:
        r101.H = new WeakReference(r100);     // Catch: Throwable -> L7
        return;
    }

    public static String getMetaInfo(Context r100, Map<String, Object> r101) {
        if (r100 != null) goto L4;
    L6:
        if (r100 == null) goto L8;
        r100 = r100.getApplicationContext();
    L8:
        delayInit(r100);
        JSONObject r102 = new JSONObject();
        if (TextUtils.isEmpty(deviceToken) == false) goto L11;
        deviceToken = SgomInfoManager.getTokenResult(r100);
    L11:
        r102.put2("apdidToken", deviceToken);
        String r103 = "";
        if (r100 != null) goto L14;
        String r104 = "";
    L15:
        r102.put2("appName", r104);
        r103 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionName;     // Catch: Throwable -> L18
    L19:
        r102.put2("appVersion", r103);
        r102.put2("deviceModel", Build.MODEL);
        r102.put2(IConstValues.DEVICE_TYPE, "android");
        r102.put2("osVersion", Build.VERSION.RELEASE);
        r102.put2("bioMetaInfo", DTFacadeExt.TOYGER_BIO_META_INFO);
        r102.put2("zimVer", "1.0.0");
        r102.put2(b.C, "2.3.43");
        if (r100.getPackageManager().hasSystemFeature("android.hardware.nfc") == false) goto L22;
        String r105 = "Y";
    L23:
        r102.put2("nfcSupport", r105);
        r102.put2("sessionId", RecordService.getInstance().getSessionId());
        r102.put2("voiceSdkVersion", "1.0.0");     // Catch: Throwable -> L26
    L28:
        String r106 = SgomInfoManager.initEnv();
        if (TextUtils.isEmpty(r106) == true) goto L36;
        r102.put2("securityVersion", r106);
        if (TextUtils.isEmpty(SgomInfoManager.getDeepSecVersion()) == true) goto L33;
        r102.put2("deepSecVersion", SgomInfoManager.getDeepSecVersion());
    L33:
        String r107 = SgomInfoManager.getSecChannel();
        if (TextUtils.isEmpty(r107) == true) goto L36;
        r102.put2("securityChannel", r107);
    L36:
        String r108 = DTFacadeFaceExt.getFaceGuardVersion();
        if (TextUtils.isEmpty(r108) == true) goto L40;
        r102.put2("guardVersion", r108);
    L40:
        if (TextUtils.isEmpty(a.h().f486989a) == true) goto L42;
        r102.put2("guardToken", a.h().g());
    L42:
        String r109 = r102.toJSONString();
        a.h().f486990b = r109;
        return r109;
    L26:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L28
    L22:
        r105 = "N";
        goto L23
    L14:
        r104 = r100.getPackageName();
        goto L15
    L4:
        if (isInited == true) goto L6;
        init(r100, r101);
        goto L6
    }

    public static int init(Context r100, Map<String, Object> r101) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        Context r102 = r100.getApplicationContext();
        a.h().q(r102);
        if (h.f561075a != null) goto L9;
        h.f561075a = r102.getSharedPreferences("dtf_prefs", 0);
    L9:
        if (isInited == false) goto L11;
        return 0;
    L11:
        a.h().S = EventConstant.Value.ALIYUN;
        RecordService.getInstance().resetLogFilePath();
        if (r101 != null) goto L14;
    L18:
        boolean r103 = true;
    L19:
        DTFacadeExt.initNetwork(r103);
        DTFacadeExt.initNetworkProxy(r102);
        String r104 = r102.getPackageName();
        RecordService.getInstance().initSDK(r102, r104);
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L22
        r105.append("com.dtf.face.");     // Catch: Throwable -> L22
        r105.append("api.");     // Catch: Throwable -> L22
        r105.append("IDTCrashCallback");     // Catch: Throwable -> L22
        r.a(r105.toString());     // Catch: Throwable -> L22
        r105.setLength(0);     // Catch: Throwable -> L22
        r105.append("com.dtf.face.");     // Catch: Throwable -> L22
        r105.append("network.");     // Catch: Throwable -> L22
        r105.append("APICallback");     // Catch: Throwable -> L22
        r.a(r105.toString());     // Catch: Throwable -> L22
        r105.setLength(0);     // Catch: Throwable -> L22
        r105.append("com.dtf.face.");     // Catch: Throwable -> L22
        r105.append("config.");     // Catch: Throwable -> L22
        r105.append("DeviceSetting");     // Catch: Throwable -> L22
        r.a(r105.toString());     // Catch: Throwable -> L22
        String r106 = "";
    L25:
        if (TextUtils.isEmpty(r106) == true) goto L29;
        return -3;
    L29:
        if (TextUtils.isEmpty(DTFacadeExt.validateSdk()) == true) goto L32;
        return -2;
    L32:
        isInited = true;
        return 0;
    L22:
        th = move-exception;
        r106 = th.getMessage();
        goto L25
    L14:
        if (r101.containsKey("isIPv6") == false) goto L18;
        Object r107 = r101.get("isIPv6");
        if ((r107 instanceof Boolean) == false) goto L18;
        r103 = ((Boolean) r107).booleanValue();
        goto L19
    }

    public void sendResponse(String r110, String r111) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        String r100 = "Z1000";
    L7:
        if (this.zimCallback == null) goto L134;
        DTResponse r101 = new DTResponse();
        r101.reason = r100;
        r101.msg = r110;
        r101.f273631id = r110;
        r101.deviceToken = a.h().f486993e;
        a r102 = a.h();
        r102.getClass();
        if (r100.startsWith("VerifyError|") == false) goto L11;
        String r112 = r100.replace("VerifyError|", "");
    L12:
        String r113 = (String) ((HashMap) a.h().F).get(r112);
        if (TextUtils.isEmpty(r113) == true) goto L163;
    L28:
        r101.retMessageSub = r113;
        DTFacadeFaceExt.updateResult(r101);
        if (IDTResponseCode.ZIM_NET_VERIFY_SUCCESS.equals(r100) == false) goto L31;
    L90:
        r101.code = 1000;
    L91:
        ArrayList r103 = new ArrayList();
        r103.add("code");
        r103.add(String.valueOf(r101.code));
        r103.add("reason");
        r103.add(r101.reason);
        r103.add("msg");
        r103.add(r101.msg);
        r103.add("retMessageSub");
        r103.add(r101.retMessageSub);
        Context r104 = this.ctx;
        Map<String, CopyOnWriteArrayList<APICallback<String>>> r105 = o.f561081a;
        AssetFileDescriptor r106 = r104.getAssets().openFd(q.ASSET_FACE);     // Catch: Throwable -> L155
        if (r106 == null) goto L96;
        r106.close();     // Catch: Throwable -> L154
    L95:
        boolean r107 = true;
    L97:
        if (r107 == true) goto L105;
        String r108 = h.a("faceModelURL", null);
        if (r108 != null) goto L104;
        File r109 = o.d(this.ctx, "fd4ddd72c85fd5fe2913be520df32ed0", false);
        if (r109 == null) goto L103;
        r108 = r109.getAbsolutePath();
        goto L104
    L103:
        r108 = "faceModelURL";
    L104:
        r103.add("faceModelURL");
        r103.add(r108);
    L105:
        r103.add("encrypted");
        if (a.h().f487011w == false) goto L108;
        String r114 = "1";
    L109:
        r103.add(r114);
        r103.add("timeCost");
        r103.add(String.valueOf(System.currentTimeMillis() - this.flowStartTime));
        a r115 = a.h();
        if (TextUtils.isEmpty(r115.O) == false) goto L112;
        r115.O = "init";
    L112:
        String r116 = r115.O;
        if (r101.reason.startsWith("Z51") == false) goto L119;
        if (a.h().m() == false) goto L117;
        r116 = "nfcVerify";
        goto L119
    L117:
        r116 = RequirementDefine.REQUIREMENT_FACE_VERIFY_TAG;
    L119:
        if (a.h().m() == false) goto L122;
        r103.add("nfcReadCount");
        r103.add(a.h().P);
    L122:
        if (a.h().f486997i == null) goto L130;
        String r117 = a.h().R;
        if (TextUtils.isEmpty(r117) == true) goto L126;
        r103.add("multifactorCurrent");
        r103.add(r117);
    L126:
        String r118 = a.h().Q;
        if (TextUtils.isEmpty(r118) == true) goto L130;
        r103.add("multifactorTotal");
        r103.add(r118);
    L130:
        if (TextUtils.isEmpty(r116) == true) goto L132;
        r103.add("flowCode");
        r103.add(String.valueOf(r116));
    L132:
        RecordService.getInstance().recordEvent(2, "finalResult", (String[]) r103.toArray(new String[r103.size()]));
        this.zimCallback.response(r101);
        goto L134
    L108:
        r114 = "0";
    L96:
        r107 = false;
        goto L97
    L31:
        if (IDTResponseCode.ZIM_NET_CONFIRM_SUCCESS.equals(r100) == true) goto L90;
        if (r100.startsWith("VerifyError|") == false) goto L36;
    L86:
        String[] r119 = r100.split("\\|");
        if (2 != r119.length) goto L89;
        r101.reason = r119[1];
    L89:
        r101.code = 2006;
        goto L91
    L36:
        if (r100.equals(IDTResponseCode.ZIM_NET_WAITING_FOR_RESULT) == true) goto L86;
        if ("Z1025".equals(r100) == false) goto L41;
    L85:
        r101.code = 2002;
        goto L91
    L41:
        if ("Z1026".equals(r100) == true) goto L85;
        if ("Z1027".equals(r100) == true) goto L85;
        if ("Z1011".equals(r100) == true) goto L85;
        if ("Z1012".equals(r100) == true) goto L85;
        if ("Z1028".equals(r100) == true) goto L85;
        if (Integer.toString(2002).equals(r100) == true) goto L85;
        if ("Z1040".equals(r100) == true) goto L85;
        if ("Z1042".equals(r100) == true) goto L85;
        if ("Z1043".equals(r100) == true) goto L85;
        if ("Z5116".equals(r100) == true) goto L85;
        if ("Z6002".equals(r100) == true) goto L85;
        if ("Z1008".equals(r100) == false) goto L66;
    L84:
        r101.code = 1003;
        goto L91
    L66:
        if ("Z1009".equals(r100) == true) goto L84;
        if ("Z1005".equals(r100) == true) goto L84;
        if ("Z1006".equals(r100) == true) goto L84;
        if ("Z1013".equals(r100) == true) goto L84;
        if ("Z1041".equals(r100) == true) goto L84;
        if ("Z1044".equals(r100) == true) goto L84;
        if ("Z3001".equals(r100) == true) goto L84;
        if (IDTResponseCode.ZIM_RESPONSE_CLIENT_TIME_INVALID.equals(r100) == false) goto L83;
        r101.code = CastIntegerProtector.parseInt(IDTResponseCode.ZIM_RESPONSE_CLIENT_TIME_INVALID);
        goto L91
    L83:
        r101.code = 1001;
        goto L91
    L163:
        JSONObject r120 = JSON.parseObject(g.a(r102.f486991c.getResources().getAssets().open("dtf_code_config.json")));     // Catch: Throwable -> L27
        if (r120.containsKey(r112) == false) goto L21;
        String r121 = r120.getString(r112) + "（" + r112 + ")";     // Catch: Throwable -> L27
    L19:
        r113 = r121;
        goto L28
    L21:
        if (r120.containsKey(r112 + "-Android") == false) goto L25;
        r121 = r120.getString(r112 + "-Android") + "（" + r112 + ")";     // Catch: Throwable -> L27
        goto L19
    L25:
        RecordService.getInstance().recordEvent(4, "errConfigParseError", new String[]{"msg", r112 + "'s reason is not exist."});     // Catch: Throwable -> L27
        goto L28
    L11:
        r112 = r100;
    L134:
        if (((CopyOnWriteArrayList) c.f534677g).size() <= 0) goto L136;
        boolean r122 = true;
        RecordService.getInstance().recordEvent(2, "VerifyTask", new String[]{"leftTask", String.valueOf(((CopyOnWriteArrayList) c.f534677g).size())});
    L137:
        ((CopyOnWriteArrayList) c.f534677g).clear();
        RecordService.getInstance().zimEnd();
        SgomInfoManager.release();
        DTFacadeFaceExt.release();
        this.zimCallback = null;
        a r123 = a.h();
        r123.f487007s = null;
        r123.f487005q = null;
        r123.f487006r = null;
        r123.f487001m = null;
        r123.f487014z = null;
        r123.f487012x = null;
        r123.f487004p = null;
        r123.f487003o = null;
        r123.f486997i = null;
        FaceConfig r124 = ws7.c.f561062a;
        ws7.c.f561063b = new GuideConfig();
        ws7.c.f561062a = new FaceConfig();
        new JSONObject();
        new JSONObject();
        ((HashMap) r123.F).clear();
        WeakReference<Context> r125 = r123.H;     // Catch: Throwable -> L156
        if (r125 == null) goto L141;
        r125.clear();     // Catch: Throwable -> L156
    L141:
        ClientConfigUtil.f273682a = -1;
        ClientConfigUtil.f273683b = 0;
        ClientConfigUtil.f273684c = 0;
        ClientConfigUtil.f273685d = -1;
        ClientConfigUtil.f273687f = 0;
        ClientConfigUtil.f273690i = -1;
        r123.E = false;
        r123.G = false;
        r123.f486989a = "";
        r123.I = -1;
        r123.K = -1;
        r123.M = null;
        r123.O = "";
        r123.P = "0";
        r123.Q = "0";
        r123.R = "0";
        r123.f486995g = null;
        us7.h r126 = us7.h.f551544b;
        if (((CopyOnWriteArrayList) r126.f551545a).size() > 0) goto L145;
        r122 = false;
    L145:
        if (r122 == true) goto L147;
        p.f561088a = null;
        p.f561090c = null;
        p.f561093f = null;
        p.f561091d = false;
        p.f561092e = "";
    L147:
        Handler r127 = ts7.c.b();
        if (r127 == null) goto L151;
        ts7.c.a r128 = ts7.c.f547420f;
        r127.removeCallbacks(r128);
        r127.postDelayed(r128, 300000);
    L151:
        if ("Z1045".equals(r100) == false) goto L164;
        r126.a();
        return;
    L164:
        return;
    L136:
        r122 = true;
        goto L137
    L5:
        r100 = r111;
        goto L7
    }

    public static void preload(Context r100, Map<String, Object> r101, APICallback<String> r102) {
        Object r103 = null;
        if (r100 != null) goto L7;
        if (r102 == null) goto L27;
        r102.onError("NULL-PARAMS", RecordService.getInstance().getSessionId(), null);
        return;
    L27:
        return;
    L7:
        a.h().q(r100.getApplicationContext());
        if (h.f561075a != null) goto L10;
        h.f561075a = r100.getSharedPreferences("dtf_prefs", 0);
    L10:
        if (r101 == null) goto L12;
        Object r104 = r101.get("modelURL");
    L13:
        ArrayList r105 = new ArrayList();
        if (r104 != null) goto L16;
    L18:
        if (r101 == null) goto L20;
        r103 = r101.get(IDTFacade.ZIM_EXT_PARAMS_KEY_PRELOAD_QUALITY_MODEL_URL);
    L20:
        ArrayList r106 = new ArrayList();
        if (r103 != null) goto L23;
    L25:
        o.c(r100, r105, r106, true, r102);
        p.b(r101, "preload");
        p.o(r100);
        return;
    L23:
        if ((r103 instanceof String) == false) goto L25;
        r106.add((String) r104);
        goto L25
    L16:
        if ((r104 instanceof String) == false) goto L18;
        r105.add((String) r104);
        goto L18
    L12:
        r104 = null;
        goto L13
    }

    public void verify(String r110, boolean r111, HashMap<String, String> r112, IDTCallback r210) {
        this.zimCallback = r210;
        if (this.ctx != null) goto L6;
        sendResponse(r110, "Z1035");
        return;
    L6:
        us7.h r100 = us7.h.f551544b;
        if (((CopyOnWriteArrayList) r100.f551545a).size() <= 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        sendResponse(r110, "Z1024");
        r100.a();
        DTFacadeFaceExt.initWorkState();
        return;
    L13:
        HashMap r102 = new HashMap();
        r102.put("toyger_circle_progress_foreground", Integer.valueOf(R.color.toyger_circle_progress_foreground));     // Catch: Throwable -> L16
    L221:
        r102.put("dtf_audio_on", Integer.valueOf(R.mipmap.dtf_audio_on));     // Catch: Throwable -> L21
    L231:
        r102.put("comm_stage_icon", Integer.valueOf(R.mipmap.comm_stage_icon));     // Catch: Throwable -> L36
        r102.put("comm_stage_finish_icon", Integer.valueOf(R.mipmap.comm_stage_finish_icon));     // Catch: Throwable -> L36
        r102.put("dtf_ocr_icon_notice", Integer.valueOf(R.mipmap.dtf_ocr_icon_notice));     // Catch: Throwable -> L36
        r102.put("ocr_take_photo_confirm", Integer.valueOf(R.mipmap.ocr_take_photo_confirm));     // Catch: Throwable -> L36
        r102.put("dtf_ocr_theme", Integer.valueOf(R.color.dtf_ocr_theme));     // Catch: Throwable -> L36
        r102.put("dtf_ocr_notice_bg", Integer.valueOf(R.color.dtf_ocr_notice_bg));     // Catch: Throwable -> L36
    L229:
        r102.put("dtf_color_signal", Integer.valueOf(R.color.dtf_color_signal));     // Catch: Throwable -> L57
        r102.put("dtf_color_signal_gray", Integer.valueOf(R.color.dtf_color_signal_gray));     // Catch: Throwable -> L57
        r102.put("dtf_color_reading_signal_gray", Integer.valueOf(R.color.dtf_color_reading_signal_gray));     // Catch: Throwable -> L57
        r102.put("dtf_color_nfc_main_color", Integer.valueOf(R.color.dtf_color_nfc_main_color));     // Catch: Throwable -> L57
        r102.put("dtf_read_success", Integer.valueOf(R.mipmap.dtf_read_success));     // Catch: Throwable -> L57
        r102.put("dtf_read_error", Integer.valueOf(R.mipmap.dtf_read_error));     // Catch: Throwable -> L57
        r102.put("dtf_finger", Integer.valueOf(R.mipmap.dtf_finger));     // Catch: Throwable -> L57
        r102.put("dtf_idcard", Integer.valueOf(R.mipmap.dtf_idcard));     // Catch: Throwable -> L57
        r102.put("dtf_nfc_reading_bg", Integer.valueOf(R.mipmap.dtf_nfc_reading_bg));     // Catch: Throwable -> L57
    L59:
        s.f561104a = r102;
        a.h().S = EventConstant.Value.ALIYUN;
        RecordService.getInstance().resetLogFilePath();
        RecordService.getInstance().init(this.ctx, r110);
        r.a("com.dtf.face.network.model.NetworkEnv");     // Catch: Throwable -> L62
        String r103 = "";
    L65:
        if (TextUtils.isEmpty(r103) == false) goto L68;
        r103 = DTFacadeExt.checkClass();
    L68:
        if (TextUtils.isEmpty(r103) == true) goto L71;
        RecordService.getInstance().recordEvent(2, "proguardCheck", new String[]{"classNotFoundException", r103});
        sendResponse(r110, "Z1056");
        return;
    L71:
        String r104 = DTFacadeExt.validateSdk();
        if (TextUtils.isEmpty(r104) == true) goto L76;
        sendResponse(r110, r104);
        return;
    L76:
        if (isInited == true) goto L79;
        sendResponse(r110, "Z1036");
        return;
    L79:
        if (r110 != null) goto L81;
    L215:
        sendResponse(r110, "Z1037");
        return;
    L81:
        if (r110.isEmpty() == true) goto L215;
        initSgomInfo(this.ctx);
        if (delayInit(this.ctx) == false) goto L86;
    L87:
        deviceToken = DTFacadeExt.initApdid(this.ctx, new AnonymousClass1(this));
    L88:
        DTFacadeExt.verifyInit();
        DTFacadeFaceExt.init();
        DTFacadeWishExt.init();
        DTFacadeExt.initNetworkProxy(this.ctx);
        DTFacadeFaceExt.initWorkState();
        FaceDataFrameInfo.info_cache = r110;
        ArrayList r105 = new ArrayList();
        r105.add("status");
        String r106 = deviceToken;
        if (TextUtils.isEmpty(r106) == false) goto L91;
        r105.add("false");
    L92:
        r105.add("token");
        if (TextUtils.isEmpty(r106) == false) goto L95;
        r106 = "NULL";
    L95:
        r105.add(r106);
        r105.add("archABI");
        r105.add(Build.CPU_ABI);
        if (r112 == null) goto L104;
        Iterator<String> r107 = r112.keySet().iterator();
    L99:
        if (r107.hasNext() == false) goto L104;
        String r108 = r107.next();
        r105.add(r108);
        String r109 = r112.get(r108);
        if (TextUtils.isEmpty(r109) == true) goto L102;
        r105.add(r109);
        goto L99
    L102:
        r105.add("NULL");
    L104:
        RecordService.getInstance().recordEvent(2, "verifyGetSession", (String[]) r105.toArray(new String[0]));
        a.h().p(null);
        a.h().f486989a = r110;
        a.h().q(this.ctx);
        SgomInfoManager.updateSgomInfo(1544293176, null);
        FaceDataFrameInfo.info_got = false;
        a.h().f487000l = r111;
        int r113 = 20;
        if (r112 != null) goto L107;
        us7.g.f551538a = null;
        us7.g.f551539b = "";
        us7.g.f551540c = false;
        us7.g.f551541d = false;
        a.h().f487009u = 20;
        a.h().f487010v = 20;
        a.h().f487014z = j.b();
    L191:
        String r114 = getMetaInfo(this.ctx, null);
        Context r115 = a.h().j();
        if (r115 != null) goto L195;
        r115 = this.ctx;
    L195:
        if (r112 == null) goto L206;
        if (r112.containsKey("ext_params_key_screen_orientation") == false) goto L206;
        if (r112.get("ext_params_key_screen_orientation").equals("ext_params_val_screen_land") == false) goto L206;
        if (Build.VERSION.SDK_INT != 26) goto L203;
        Intent r116 = new Intent(r115, LandOpaqueFaceLoadingActivity.class);
    L204:
        r116.putExtra("ext_params_key_screen_orientation", r112.get("ext_params_key_screen_orientation"));
        a.h().f487013y = true;
    L210:
        r116.putExtra("toyger_meta_info", r114);
        if ((r115 instanceof Activity) == true) goto L213;
        r116.addFlags(268435456);
    L213:
        r116.putExtra("comeFrom", DTFacade.class.getName());
        a.h().f487006r = new AnonymousClass2(this);
        DTFacadeFaceExt.initCallBack(this, r112, r116);
        this.flowStartTime = System.currentTimeMillis();
        r115.startActivity(r116);
        return;
    L203:
        r116 = new Intent(r115, LandFaceLoadingActivity.class);
    L206:
        if (Build.VERSION.SDK_INT != 26) goto L208;
        r116 = new Intent(r115, PortOpaqueFaceLoadingActivity.class);
    L209:
        a.h().f487013y = false;
        goto L210
    L208:
        r116 = new Intent(r115, PortFaceLoadingActivity.class);
        goto L209
    L107:
        if (r112.containsKey("ext_params_key_ocr_bottom_button_color") == false) goto L114;
        String r117 = r112.get("ext_params_key_ocr_bottom_button_color");
        if (TextUtils.isEmpty(r117) == true) goto L114;
        Color.parseColor(r117);     // Catch: Exception -> L112
    L114:
        if (r112.containsKey("ext_params_key_face_progress_color") == false) goto L122;
        String r118 = r112.get("ext_params_key_face_progress_color");
        if (TextUtils.isEmpty(r118) == false) goto L227;
        us7.g.f551538a = null;
        goto L122
    L227:
        Color.parseColor(r118);     // Catch: Exception -> L119
        us7.g.f551538a = r118;     // Catch: Exception -> L119
    L119:
        us7.g.f551538a = null;
    L122:
        if (r112.containsKey("ext_params_key_top_tip_index") == false) goto L130;
        String r119 = r112.get("ext_params_key_top_tip_index");
        if (TextUtils.isEmpty(r119) == true) goto L130;
        if (r119 == null) goto L130;
        if ("ext_params_key_tip_index_tt".equals(r119) == false) goto L130;
        us7.g.f551539b = p.k(a.h().j(), "scanCompare", R.string.dtf_tantan_top_tip_text);
    L130:
        if (r112.containsKey("ext_params_key_open_webview_render") == true) goto L132;
        us7.g.f551540c = false;
    L137:
        if (r112.containsKey("params_key_need_permission_toast") == false) goto L148;
        us7.g.f551542e = 2000;
        if ("true".equals(r112.get("params_key_need_permission_toast")) == true) goto L235;
        us7.g.f551541d = false;
    L150:
        if (r112.containsKey("params_key_need_face_notice") == false) goto L152;
        us7.g.f551543f = "true".equals(r112.get("params_key_need_face_notice"));
    L154:
        if (r112.containsKey("ext_params_key_timeout_for_init") == true) goto L233;
        a.h().f487009u = 20;
    L165:
        if (r112.containsKey("ext_params_key_timeout_for_verify") == true) goto L225;
        a.h().f487010v = 20;
    L176:
        if (r112.containsKey("ext_params_key_open_fullscreen") == false) goto L181;
        if ("false".equals(r112.get("ext_params_key_open_fullscreen")) == false) goto L181;
        a.h().G = true;
    L181:
        if (r112.containsKey(IDTFacade.ZIM_EXT_PARAMS_KEY_LANGUAGE) == false) goto L184;
        HashMap r120 = new HashMap();
        r120.put(IDTFacade.ZIM_EXT_PARAMS_KEY_LANGUAGE, r112.get(IDTFacade.ZIM_EXT_PARAMS_KEY_LANGUAGE));
        p.b(r120, "verify");
    L184:
        if (r112.containsKey("ext_params_key_ok_http_opt") == false) goto L191;
        boolean r121 = Boolean.parseBoolean(r112.get("ext_params_key_ok_http_opt"));     // Catch: Throwable -> L187
    L189:
        a.h().N = r121;
    L187:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "errMsg", new String[]{Log.getStackTraceString(th)});
        r121 = false;
        goto L189
    L225:
        r113 = Math.max(1, CastIntegerProtector.parseInt(r112.get("ext_params_key_timeout_for_verify")));     // Catch: NumberFormatException -> L169
    L170:
        a r122 = a.h();
        if (r113 <= 0) goto L173;
        r122.f487010v = r113;
        goto L176
    L173:
        r122.getClass();
        goto L176
    L233:
        int r123 = Math.max(1, CastIntegerProtector.parseInt(r112.get("ext_params_key_timeout_for_init")));     // Catch: NumberFormatException -> L158
    L159:
        a r124 = a.h();
        if (r123 <= 0) goto L162;
        r124.f487009u = r123;
        goto L165
    L162:
        r124.getClass();
    L158:
        r123 = 20;
        goto L159
    L152:
        us7.g.f551543f = false;
        goto L154
    L235:
    L144:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L146:
        us7.g.f551541d = true;
        goto L150
    L141:
        if (TextUtils.isEmpty(r112.get("params_key_need_permission_toast_duration")) == true) goto L146;
        us7.g.f551542e = Long.parseLong(r112.get("params_key_need_permission_toast_duration"));     // Catch: Throwable -> L144
        goto L146
    L148:
        us7.g.f551541d = false;
        goto L150
    L132:
        if ("true".equals(r112.get("ext_params_key_open_webview_render")) == false) goto L134;
        us7.g.f551540c = true;
        goto L137
    L134:
        us7.g.f551540c = false;
        goto L137
    L91:
        r105.add("true");
        goto L92
    L86:
        if (TextUtils.isEmpty(deviceToken) == false) goto L88;
    L62:
        th = move-exception;
        r103 = th.getMessage();
    L57:
        th = move-exception;
        RecordService.getInstance().recordEvent(2, "resourceEx", new String[]{"errMsg", Log.getStackTraceString(th)});
    L36:
        th = move-exception;
        RecordService.getInstance().recordEvent(2, "resourceEx", new String[]{"errMsg", Log.getStackTraceString(th)});
    L21:
        th = move-exception;
        RecordService.getInstance().recordEvent(2, "resourceEx", new String[]{"errMsg", Log.getStackTraceString(th)});
    L16:
        th = move-exception;
        RecordService.getInstance().recordEvent(2, "resourceEx", new String[]{"errMsg", Log.getStackTraceString(th)});
        goto L221
    L9:
        r101 = false;
        goto L10
    }
}
