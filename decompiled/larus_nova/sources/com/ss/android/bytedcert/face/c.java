package com.ss.android.bytedcert.face;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.camera.common.CameraFactory$WhiteBalanceType;
import com.ss.android.bytedcert.camera.common.gl.STGLRenderer;
import com.ss.android.bytedcert.cvlibrary.FaceVerify;
import com.ss.android.bytedcert.cvlibrary.StillLiveness;
import com.ss.android.bytedcert.dialog.CommonDialog;
import com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity;
import com.ss.android.bytedcert.face.ui.FaceDetectFullActivity;
import com.ss.android.bytedcert.flow.face.FaceDetectFlow;
import com.ss.android.bytedcert.flow.face.FaceLiveInitDurationHelper;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.model.LiveInfo;
import com.ss.android.bytedcert.model.LivenessEnum;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.utils.Accelerometer;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements rsa.c.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f407346v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final isa.b f407347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FaceDetectFlow f407348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LiveInfo f407349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public bsa.a f407350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Accelerometer f407351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f407352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile LivenessEnum f407353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f407354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f407355i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StringBuilder f407356j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f407357k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f407358l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f407359m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.android.bytedcert.face.a f407360n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f407361o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CameraStateDetector f407362p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FaceVerify f407363q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public StillLiveness f407364r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f407365s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f407366t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f407367u;

    public class a implements CommonDialog.OnDialogClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ICertDialogDepend.AlertDialogParams f407368a;

        public a(ICertDialogDepend.AlertDialogParams r100) {
            this.f407368a = r100;
        }

        @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
        public final void onCancel(DialogInterface r100) {
            this.f407368a.negativeListener.onClick(r100, -2);
        }

        @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
        public final void onConfirm(DialogInterface r100) {
            this.f407368a.positiveListener.onClick(r100, -1);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f407370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f407371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f407372d;

        @Override // java.lang.Runnable
        public final void run() {
            c.b(this.f407372d, this.f407369a, this.f407370b, this.f407371c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(c r100, String r101, String r102, int r103) {
            this.f407372d = r100;
            this.f407369a = r101;
            this.f407370b = r102;
            this.f407371c = r103;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.bytedcert.face.c$c, reason: collision with other inner class name */
    public class C4711c implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f407374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f407375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f407376d;

        /* JADX INFO: renamed from: com.ss.android.bytedcert.face.c$c$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BDResponse f407377a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C4711c f407378b;

            /* JADX INFO: renamed from: com.ss.android.bytedcert.face.c$c$a$a, reason: collision with other inner class name */
            public class RunnableC4712a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f407379a;

                @Override // java.lang.Runnable
                public final void run() {
                    a r100 = this.f407379a;     // Catch: Throwable -> L4
                    C4711c r101 = r100.f407378b;     // Catch: Throwable -> L4
                    r101.a(r100.f407377a, r101.f407373a, r101.f407374b, r101.f407375c);     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }

                public RunnableC4712a(a r100) {
                    this.f407379a = r100;
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.c(this.f407378b.f407376d, LivenessEnum.LIVENESS_DETECT);     // Catch: Throwable -> L4
                this.f407378b.f407376d.f407352f.post(new RunnableC4712a(this));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(C4711c r100, BDResponse r101) {
                this.f407378b = r100;
                this.f407377a = r101;
            }
        }

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            this.f407376d.f407347a.hideLoading();
            this.f407376d.f407347a.V0();
            CertLog.d("FaceDetectFlow", "live_detect result:" + r100);
            if (LivenessEnum.SHOW_RETAIN_DIALOG.equals(this.f407376d.f407353g) == false) goto L5;
            ThreadPlus.submitRunnable(new a(this, r100));
            return;
        L5:
            a(r100, this.f407373a, this.f407374b, this.f407375c);
        }

        public C4711c(c r100, String r101, String r102, int r103) {
            this.f407376d = r100;
            this.f407373a = r101;
            this.f407374b = r102;
            this.f407375c = r103;
        }

        public final void a(BDResponse r100, String r101, String r102, int r103) {
            if (r100.success == false) goto L12;
            c r104 = this.f407376d;
            String r105 = r104.f407348b.getFlowId();
            LiveInfo r106 = this.f407376d.f407349c;
            if (r106.f407595t == true) goto L8;
            r106 = null;
        L8:
            r104.f407349c = new LiveInfo(r100, r105, r106);
            if (this.f407376d.f407348b.getCertInfo().F == false) goto L11;
            this.f407376d.f407349c.f407587l = true;
        L11:
            c r107 = this.f407376d;
            r107.f407348b.setLiveInfo(r107.f407349c);
            c.b(this.f407376d, r101, r102, r103);
            return;
        L12:
            this.f407376d.e(r100, false);
            this.f407376d.f407347a.finish();
        }
    }

    public class d implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f407380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f407381b;

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            Pair<Integer, String> r101 = this.f407380a;
            if (r101 != null) goto L5;
            r101 = ErrorConstant.Client.ERROR_FACE_LIVE_RETURN;
        L5:
            BDResponse r102 = new BDResponse(r101);
            r102.jsonBody = r100.jsonBody;
            CertLog.d("FaceDetectFlow", "return with query:" + r102);
            this.f407381b.e(r102, false);
            this.f407381b.f407347a.finish();
        }

        public d(c r100, Pair r101) {
            this.f407381b = r100;
            this.f407380a = r101;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rsa.c.a f407382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f407383b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f407383b.f407360n.a((JSONObject) this.f407382a.f539153b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(c r100, rsa.c.a r101) {
            this.f407383b = r100;
            this.f407382a = r101;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f407384a;

        public class a implements rsa.g.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f407385a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f407386b;

            public a(f r100, Runnable r101) {
                this.f407386b = r100;
                this.f407385a = r101;
            }

            public final void a(boolean r100, String r101) {
                if (r100 == false) goto L10;
                LiveInfo r102 = this.f407386b.f407384a.f407349c;
                if (r102 == null) goto L15;
                r102.a("is_screen_recording", "1");
                if (TextUtils.isEmpty(r101) == false) goto L9;
                this.f407386b.f407384a.f407349c.a("current_share_screen_app", "unknown");
                return;
            L9:
                this.f407386b.f407384a.f407349c.a("current_share_screen_app", r101);
                return;
            L15:
                return;
            L10:
                LiveInfo r103 = this.f407386b.f407384a.f407349c;
                if (r103 == null) goto L13;
                r103.a("is_screen_recording", "0");
            L13:
                this.f407386b.f407384a.f407352f.postDelayed(this.f407385a, 1000);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Activity r100 = this.f407384a.f407347a.getActivity();     // Catch: Throwable -> L4
            a r101 = new a(this, this);     // Catch: Throwable -> L4
            Object r102 = rsa.g.f539157a;     // Catch: Throwable -> L4
            ThreadMethodProxy.start(new PthreadThreadV2(new rsa.f(r100, r101), "RecordCheckUtils"));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(c r100) {
            this.f407384a = r100;
        }
    }

    public final void f() {
        if (LivenessEnum.SHOW_RETAIN_DIALOG.equals(this.f407353g) == false) goto L6;
        return;
    L6:
        if (this.f407349c != null) goto L8;
        return;
    L8:
        CertLog.d("FaceDetectFlow", "start do verify");
        this.f407348b.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_LIVENESS_END, EventConstant.Key.FACE_DETECT_TIMESTAMP);
        this.f407356j.append("live_detection,");
        this.f407355i.set(true);
        if (this.f407349c.f407579d == false) goto L13;
        this.f407352f.post(new com.ss.android.bytedcert.face.d(this));
        this.f407347a.finish();
        return;
    L13:
        if (TextUtils.isEmpty(this.f407348b.getFaceLiveManager().f520422a) == false) goto L16;
        CertLog.e("FaceDetectFlow", "sdkData from jni failed");
        e(new BDResponse(ErrorConstant.Client.ERROR_FACE_DATA_ENCRYPT), false);
        this.f407347a.finish();
        return;
    L16:
        isa.b r100 = this.f407347a;
        r100.showLoading(r100.getActivity().getString(R.string.byted_face_compare_recognized));
        osa.a r101 = this.f407348b.getActionInfo();
        g r102 = new g(this);
        this.f407348b.getMonitorManager().a("人脸比对");
        if (this.f407348b.getCertInfo().f526576j == false) goto L26;
        if (r101 != null) goto L20;
    L24:
        CertLog.d("FaceDetectFlow", "without face_compare & callback");
        e(new BDResponse(new CertResponse(true, g())), true);
        this.f407347a.finish();
        return;
    L20:
        if (r101.f526565b == false) goto L22;
    L23:
        CertLog.d("FaceDetectFlow", "do face_compare & query");
        this.f407348b.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_COMPARE_START, EventConstant.Key.FACE_DETECT_TIMESTAMP);
        EventLogUtils.lastModule = "live_detection";
        EventLogUtils.module = "face_identify";
        this.f407356j.append("face_identify,");
        HashMap r103 = new HashMap();
        r103.put(BytedCertConstant.CertKey.VERIFY_CHANNEL, "byte");
        long r104 = System.currentTimeMillis();
        psa.a r105 = this.f407348b.getRequestUtils();
        h r110 = new h(this, r104, r102);
        String r106 = UrlConstant.getFaceCompareResultPath();
        String r107 = this.f407348b.getFaceLiveManager().f520422a;
        String r108 = this.f407349c.f407582g;
        String r109 = LiveInfo.e(r107);
        Map<String, String> r111 = this.f407348b.appendCommonRequestParams(r103);
        r105.getClass();
        new psa.j(r105, r111, r109, r106, r110).start();
        return;
    L22:
        if (r101.f526564a == false) goto L24;
    L26:
        if (this.f407348b.getCertInfo().f526569c != null) goto L28;
    L36:
        if (r101 != null) goto L38;
    L40:
        CertLog.d("FaceDetectFlow", "without face_compare & callback");
        e(new BDResponse(new CertResponse(true, g())), true);
        this.f407347a.finish();
        return;
    L38:
        if (r101.f526564a == false) goto L40;
        CertLog.d("FaceDetectFlow", "do face_compare");
        this.f407348b.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_COMPARE_START, EventConstant.Key.FACE_DETECT_TIMESTAMP);
        psa.a r112 = this.f407348b.getRequestUtils();
        j r113 = new j(this, r102);
        String r114 = UrlConstant.getFaceCompareVerificationPath();
        String r115 = this.f407348b.getFaceLiveManager().f520422a;
        String r116 = this.f407349c.f407582g;
        String r117 = LiveInfo.e(r115);
        Map<String, String> r118 = this.f407348b.appendCommonRequestParams(null);
        r112.getClass();
        new psa.j(r112, r118, r117, r114, r113).start();
        return;
    L28:
        if (TextUtils.isDigitsOnly(this.f407348b.getCertInfo().f526569c) == false) goto L36;
        if (CastIntegerProtector.parseInt(this.f407348b.getCertInfo().f526569c) != 1) goto L36;
        if (r101 != null) goto L33;
    L35:
        CertLog.d("FaceDetectFlow", "without face_compare & callback");
        e(new BDResponse(new CertResponse(true, g())), true);
        this.f407347a.finish();
        return;
    L33:
        if (r101.f526565b == false) goto L35;
        CertLog.d("FaceDetectFlow", "do face_compare");
        this.f407348b.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_COMPARE_START, EventConstant.Key.FACE_DETECT_TIMESTAMP);
        psa.a r119 = this.f407348b.getRequestUtils();
        i r120 = new i(this, r102);
        String r121 = UrlConstant.getFaceCompareAuthenticationPath();
        String r122 = this.f407348b.getFaceLiveManager().f520422a;
        String r123 = this.f407349c.f407582g;
        String r124 = LiveInfo.e(r122);
        Map<String, String> r125 = this.f407348b.appendCommonRequestParams(null);
        r119.getClass();
        new psa.j(r119, r125, r124, r121, r120).start();
    }

    public final JSONObject g() {
        String r100 = LiveInfo.e(this.f407348b.getFaceLiveManager().f520422a);
        JSONObject r101 = new JSONObject();
        r101.put("sdk_data", r100);     // Catch: JSONException -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void h() {
        LiveInfo r100 = this.f407349c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f407579d == false) goto L9;
        String r101 = BytedCertManager.getInstance().getModulePath(OperationName.OPERATION_OFFLINE_AVAILABLE);
        String[] r102 = f407346v;
        this.f407365s = rsa.d.h(r101, r102[0]);
        this.f407366t = rsa.d.h(BytedCertManager.getInstance().getModulePath(OperationName.OPERATION_OFFLINE_AVAILABLE), r102[1]);
        this.f407367u = rsa.d.h(BytedCertManager.getInstance().getModulePath(OperationName.OPERATION_OFFLINE_AVAILABLE), r102[2]);
        CertLog.d("FaceDetectFlow", "init offline verify");
        return;
    }

    public final void j() {
        this.f407353g = LivenessEnum.NONE;
        this.f407355i.set(false);
        this.f407352f.removeCallbacksAndMessages(null);
        o();
        rsa.c.c(this);
        com.ss.android.bytedcert.face.a r100 = this.f407360n;
        r100.getClass();
        JSONArray r101 = r100.f407341c.optJSONArray("steps");     // Catch: JSONException -> L9
        if (r101 != null) goto L6;
        r101 = new JSONArray();     // Catch: JSONException -> L9
    L6:
        r101.put(com.ss.android.bytedcert.face.a.b("page", "exit", null));     // Catch: JSONException -> L9
        r100.f407341c.put("steps", r101);     // Catch: JSONException -> L9
        r100.f407341c.put("last_event_timestamp", System.currentTimeMillis());     // Catch: JSONException -> L9
        r100.f407341c.put("finish_type", "normal");     // Catch: JSONException -> L9
    L7:
        r100.f407339a.onEvent("face_detection_page_finish", r100.f407341c);
        CertLog.d("FaceDetectFlow", "on event: face_detection_page_finish, params: " + r100.f407341c);
        r100.f407340b.edit().remove("face_flow_steps").apply();
        r100.f407341c.remove("steps");
        CameraStateDetector r102 = this.f407362p;
        r102.f407321b.removeCallbacks(r102.f407324e);
    }

    public final void l() {
        if (this.f407350d == null) goto L22;
        LiveInfo.LivenessInfoConfig r100 = this.f407349c.f407590o;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.enable == true) goto L9;
        return;
    L9:
        if (r100.detectType != LiveInfo.LivenessInfoConfig.DetectType.WHITE_BALANCE) goto L25;
        LiveInfo.LivenessInfoConfig.WbConfig r101 = (LiveInfo.LivenessInfoConfig.WbConfig) r100;
        int r102 = r101.color;
        if (r102 != 1) goto L13;
        bsa.e.f20353a = false;
        CameraFactory$WhiteBalanceType r103 = CameraFactory$WhiteBalanceType.GREEN;
    L20:
        this.f407350d.g(r103);
        return;
    L13:
        if (r102 == 2) goto L16;
        bsa.e.f20353a = false;
        r103 = CameraFactory$WhiteBalanceType.RED;
        goto L20
    L16:
        if (r101.autoBlue == false) goto L18;
        bsa.e.f20353a = true;
        r103 = CameraFactory$WhiteBalanceType.AUTO_INCANDESCENT;
        goto L20
    L18:
        bsa.e.f20353a = false;
        r103 = CameraFactory$WhiteBalanceType.BLUE;
        goto L20
    L25:
        return;
    }

    public final void o() {
        Accelerometer r100 = this.f407351e;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        bsa.a r101 = this.f407350d;
        if (r101 == null) goto L10;
        r101.a();
        bsa.a r102 = this.f407350d;
        lsa.a r103 = r102.f20342t;
        if (r103 == null) goto L10;
        r103.f();
        r102.f20342t = null;
    L10:
        this.f407348b.setLiveSDKRunning(false);
        this.f407348b.setGLPause(true);
        FaceVerify r104 = this.f407363q;
        if (r104 == null) goto L13;
        r104.native_FV_ReleaseHandle();
    L13:
        StillLiveness r105 = this.f407364r;
        if (r105 == null) goto L16;
        r105.native_SL_ReleaseHandle();
    L16:
        EventLogUtils.lastModule = EventLogUtils.module;
        EventLogUtils.module = "";
        this.f407358l = false;
        this.f407359m = false;
    }

    public final void q() {
        if (this.f407349c != null) goto L6;
        return;
    L6:
        if (this.f407350d != null) goto L8;
        return;
    L8:
        this.f407348b.setGLPause(true);
        int r100 = this.f407350d.d(this.f407349c);
        if (r100 == 0) goto L12;
        CertLog.e("FaceDetectFlow", "init params failed:" + r100);
        BDResponse r101 = new BDResponse(ErrorConstant.Client.ERROR_ALGORITHM_PARAMS_FAIL);
        r101.detailErrorCode = r100;
        e(r101, false);
        this.f407347a.finish();
        return;
    L12:
        int r102 = this.f407350d.b(this.f407349c.f407578c.getFlags(), this.f407349c.f407578c.getValues());
        if (r102 == 0) goto L16;
        CertLog.d("FaceDetectFlow", "init config failed:" + r102);
        BDResponse r103 = new BDResponse(ErrorConstant.Client.ERROR_ALGORITHM_PARAMS_FAIL);
        r103.detailErrorCode = r102;
        e(r103, false);
        this.f407347a.finish();
        return;
    L16:
        lsa.a r104 = this.f407350d.f20342t;
        if (r104 == null) goto L19;
        int r105 = r104.g();
    L20:
        if (r105 == 0) goto L23;
        CertLog.d("FaceDetectFlow", "reset failed:" + r105);
        e(new BDResponse(ErrorConstant.Client.ERROR_SET_TASK_FAIL), false);
        this.f407347a.finish();
        return;
    L23:
        this.f407348b.setLiveSDKRunning(true);
        this.f407348b.setGLPause(false);
        return;
    L19:
        r105 = -1;
        goto L20
    }

    static {
        f407346v = new String[]{"tt_face_v", "tt_faceverify_v", "tt_stillliveness_v"};
    }

    public final void d(Pair<Integer, String> r100) {
        if (this.f407348b.getCertInfo().f526576j == false) goto L15;
        HashMap r101 = new HashMap();
        r101.put(BytedCertConstant.CertKey.VERIFY_CHANNEL, "byte");
        osa.a r102 = this.f407348b.getActionInfo();
        if (r102 == null) goto L12;
        if (r102.f526565b == false) goto L9;
    L10:
        CertLog.d("FaceDetectFlow", "return with query");
        psa.a r103 = this.f407348b.getRequestUtils();
        d r104 = new d(this, r100);
        String r105 = this.f407348b.getFlowId();
        Map<String, String> r106 = this.f407348b.appendCommonRequestParams(r101);
        r103.getClass();
        r103.c(new psa.c(r105, r104), "POST", UrlConstant.getQueryPath(), r106);
        return;
    L9:
        if (r102.f526564a == true) goto L10;
    L12:
        if (r100 != null) goto L14;
        r100 = ErrorConstant.Client.ERROR_FACE_LIVE_RETURN;
    L14:
        BDResponse r107 = new BDResponse(r100);
        CertLog.d("FaceDetectFlow", "return without query:" + r107);
        e(r107, false);
        this.f407347a.finish();
        return;
    L15:
        BDResponse r108 = new BDResponse(r100);
        CertLog.d("FaceDetectFlow", "return without query:" + r108);
        e(r108, false);
        this.f407347a.finish();
    }

    @Override // rsa.c.b
    public void onEvent(rsa.c.a r100) {
        if (TextUtils.isEmpty(r100.f539152a) == false) goto L5;
        return;
    L5:
        String r101 = r100.f539152a;
        r101.getClass();
        switch(r101.hashCode()) {
            case -1499968707: goto L25;
            case -603764626: goto L21;
            case -265445474: goto L17;
            case 316297563: goto L13;
            case 546232216: goto L9;
            default: goto L28;
        };
    L28:
        byte r102 = -1;
    L29:
        if (r102 != 0) goto L31;
        Object r103 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.ENABLE_FACE_DETECTION_STEPS);
        if (r103 == null) goto L69;
        if ((r103 instanceof Boolean) == true) goto L67;
        return;
    L67:
        if (((Boolean) r103).booleanValue() == true) goto L69;
        return;
    L69:
        if ((r100.f539153b instanceof JSONObject) == false) goto L81;
        this.f407347a.getActivity().runOnUiThread(new e(this, r100));
        return;
    L81:
        return;
    L31:
        if (r102 == 1) goto L56;
        if (r102 == 2) goto L53;
        if (r102 == 3) goto L53;
        if (r102 != 4) goto L82;
        CertLog.d("FaceDetectFlow", "onCameraStateChange:" + r100.f539153b);
        CameraStateDetector r104 = this.f407362p;
        Object r105 = r100.f539153b;
        if (r104.f407323d == true) goto L40;
        return;
    L40:
        if ((r105 instanceof CameraStateDetector.CameraState) == true) goto L42;
        return;
    L42:
        if (Objects.equals(r105, CameraStateDetector.CameraState.OPENED) == true) goto L44;
    L46:
        r104.f407320a = (CameraStateDetector.CameraState) r105;
        if (Objects.equals(r104.f407320a, CameraStateDetector.CameraState.OPENING) == false) goto L73;
        Handler r106 = r104.f407321b;
        CameraStateDetector.a r107 = r104.f407324e;
        Object r108 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_DETECT_FIRST_FRAME_INTERVAL);
        if ((r108 instanceof Number) == false) goto L51;
        long r109 = ((Number) r108).longValue();
    L52:
        r106.postDelayed(r107, r109);
        return;
    L51:
        r109 = 3000;
        goto L52
    L73:
        return;
    L44:
        if (Objects.equals(r104.f407320a, CameraStateDetector.CameraState.FIRST_FRAME) == false) goto L46;
        return;
    L82:
        return;
    L53:
        Object r110 = r100.f539153b;
        if ((r110 instanceof JSONObject) == false) goto L75;
        this.f407348b.onEvent(r100.f539152a, (JSONObject) r110);
        return;
    L75:
        return;
    L56:
        CertLog.d("FaceDetectFlow", "onCameraError:" + r100.f539153b);
        CameraStateDetector r111 = this.f407362p;
        Object r112 = r100.f539153b;
        if (r111.f407323d == true) goto L60;
        return;
    L60:
        if ((r112 instanceof JSONObject) == false) goto L77;
        r111.f407322c.onEvent("face_detection_camera_frame_error", (JSONObject) r112);
        return;
    L77:
        return;
    L9:
        if (r101.equals("on_camera_state_change") == false) goto L28;
        r102 = 4;
        goto L29
    L13:
        if (r101.equals(EventConstant.Event.BYTED_CERT_CAMERA_INIT_ERROR) == false) goto L28;
        r102 = 3;
        goto L29
    L17:
        if (r101.equals(EventConstant.Event.FACE_DETECTION_OPEN_CAMERA) == false) goto L28;
        r102 = 2;
        goto L29
    L21:
        if (r101.equals("camera_error") == false) goto L28;
        r102 = 1;
        goto L29
    L25:
        if (r101.equals("flow_step") == false) goto L28;
        r102 = 0;
        goto L29
    }

    public final void s(ICertDialogDepend.AlertDialogParams r100) {
        ICertDialogDepend r101 = this.f407348b.getCertDialogDepend();
        if (r101 != null) goto L5;
    L7:
        CommonDialog r102 = new CommonDialog(this.f407347a.getActivity(), false).setConfirmTypeFace(Typeface.defaultFromStyle(1)).setTitle(r100.title).setMessage(r100.message).setConfirmText(r100.positiveLabel).setCancelText(r100.negativeLabel).setListener(new a(r100));
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        return;
    L5:
        if (r101.showAlertDialog(r100) == false) goto L7;
    }

    public final void t(Bundle r110) {
        if (this.f407358l == false) goto L6;
        return;
    L6:
        if (this.f407349c != null) goto L9;
        return;
    L9:
        if (this.f407350d != null) goto L11;
        return;
    L11:
        this.f407348b.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_SMASH_PRE_LOAD, EventConstant.Key.FACE_DETECT_TIMESTAMP);
        this.f407348b.onInitModuleStart(FaceLiveInitDurationHelper.Module.LOAD_SMASH);
        bsa.a r100 = this.f407350d;
        isa.a r101 = (isa.a) this.f407347a;
        FaceDetectFlow r102 = this.f407348b;
        r100.getClass();
        String r103 = r102.getLiveType();
        r103.getClass();
        int r104 = -1;
        switch(r103.hashCode()) {
            case 109765032: goto L23;
            case 112202875: goto L19;
            case 851993275: goto L15;
            default: goto L13;
        };
    L13:
        byte r105 = -1;
    L26:
        switch(r105) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L28;
            default: goto L27;
        };
    L27:
        r100.f20342t = new w(r101);
        String r106 = "动作活体";
    L31:
        r102.getMonitorManager().a(r106);
        r100.f20346x = r100.f20342t.e(r100.f20328f, r110);
        this.f407348b.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_SMASH_LOADED, EventConstant.Key.FACE_DETECT_TIMESTAMP);
        int r111 = this.f407350d.f20346x;
        if (r111 == 0) goto L35;
        BDResponse r107 = new BDResponse(ErrorConstant.Client.ERROR_ALGORITHM_INIT_FAIL);
        r107.detailErrorCode = r111;
        e(r107, false);
        CertLog.e("FaceDetectFlow", "init failed:" + r111 + ";message:" + r107.errorMsg);
        this.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.LOAD_SMASH, false);
        this.f407347a.finish();
        return;
    L35:
        this.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.LOAD_SMASH, true);
        if (this.f407357k == false) goto L38;
        return;
    L38:
        this.f407348b.onInitModuleStart(FaceLiveInitDurationHelper.Module.SMASH_SET_UP);
        CertLog.d("FaceDetectFlow", "SetParam");
        int r112 = this.f407350d.d(this.f407349c);
        if (r112 == 0) goto L42;
        BDResponse r108 = new BDResponse(ErrorConstant.Client.ERROR_ALGORITHM_PARAMS_FAIL);
        r108.detailErrorCode = r112;
        e(r108, false);
        CertLog.e("FaceDetectFlow", "init params failed:" + r112 + ";message:" + r108.errorMsg);
        this.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.SMASH_SET_UP, false);
        this.f407347a.finish();
        return;
    L42:
        this.f407348b.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_SMASH_PRE_SETUP, EventConstant.Key.FACE_DETECT_TIMESTAMP);
        CertLog.d("FaceDetectFlow", "SetConfig");
        int r113 = this.f407350d.b(this.f407349c.f407578c.getFlags(), this.f407349c.f407578c.getValues());
        if (r113 == 0) goto L46;
        BDResponse r109 = new BDResponse(ErrorConstant.Client.ERROR_ALGORITHM_PARAMS_FAIL);
        r109.detailErrorCode = r113;
        e(r109, false);
        CertLog.e("FaceDetectFlow", "init config failed:" + r113 + ";message:" + r109.errorMsg);
        this.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.SMASH_SET_UP, false);
        this.f407347a.finish();
        return;
    L46:
        this.f407348b.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_SMASH_DID_SETUP, EventConstant.Key.FACE_DETECT_TIMESTAMP);
        lsa.a r114 = this.f407350d.f20342t;
        if (r114 == null) goto L49;
        r104 = r114.g();
    L49:
        if (r104 == 0) goto L52;
        BDResponse r115 = new BDResponse(ErrorConstant.Client.ERROR_SET_TASK_FAIL);
        r115.detailErrorCode = r104;
        e(r115, false);
        CertLog.e("FaceDetectFlow", "reset failed:" + r104 + ";message:" + r115.errorMsg);
        this.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.SMASH_SET_UP, false);
        this.f407347a.finish();
        return;
    L52:
        this.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.SMASH_SET_UP, true);
        String r116 = "0";
        long r117 = System.currentTimeMillis() - this.f407348b.getFaceStartTime();
        JSONObject r118 = new JSONObject();     // Catch: Exception -> L68
        if (this.f407348b.isBytedCertFlow() == true) goto L56;
        r118.put(EventConstant.Key.DURING_QUERY_INIT, this.f407348b.getFaceInitTime());     // Catch: Exception -> L68
    L56:
        r118.put("result", "1");     // Catch: Exception -> L68
        r118.put("error_code", "0");     // Catch: Exception -> L68
        r118.put("error_msg", "success");     // Catch: Exception -> L68
        r118.put(EventConstant.Key.DURING_QUERY_LIVE, this.f407348b.getFaceLiveTime());     // Catch: Exception -> L68
        r118.put(EventConstant.Key.DURING_START_ACTIVITY, r117);     // Catch: Exception -> L68
        if (this.f407347a.getActivity().getIntent() == null) goto L63;
        if (this.f407347a.getActivity().getIntent().getBooleanExtra(EventConstant.Key.ALREADY_HAS_PERMISSION, false) == false) goto L61;
        r116 = "1";
    L61:
        r118.put(EventConstant.Key.ALREADY_HAS_PERMISSION, r116);     // Catch: Exception -> L68
    L63:
        if (this.f407348b.isBytedCertFlow() == false) goto L65;
        String r119 = EventConstant.Event.CERT_START_FACE_LIVE_INTERNAL;
    L66:
        this.f407348b.onEvent(r119, r118);     // Catch: Exception -> L68
    L70:
        this.f407348b.onEvent(EventConstant.Event.FACE_DETECTION_ENTER, null);
        this.f407348b.setTimestamp(BytedCertConstant.KeyTimestamp.FACE_PAGE_NOTIFY, EventConstant.Key.FACE_DETECT_TIMESTAMP);
        EventLogUtils.module = "live_detection";
        this.f407358l = true;
        if (BytedCertSdkManager.getInstance().isScreenRecordDetect() == false) goto L76;
        new f(this).run();
        return;
    L76:
        return;
    L65:
        r119 = EventConstant.Event.CERT_START_FACE_LIVE;
    L68:
        e = move-exception;
        e.printStackTrace();
        goto L70
    L28:
        r100.f20342t = new w(r101);
        r106 = "带炫彩的动作活体";
        goto L31
    L29:
        r100.f20342t = new ssa.b();
        r106 = "视频活体";
        goto L31
    L30:
        r100.f20342t = new w(r101);
        r106 = "静默活体";
        goto L31
    L15:
        if (r103.equals(BytedCertConstant.LiveType.LIVE_TYPE_MOTION_WITH_REFLECTION) == false) goto L13;
        r105 = 2;
        goto L26
    L19:
        if (r103.equals("video") == false) goto L13;
        r105 = 1;
        goto L26
    L23:
        if (r103.equals(BytedCertConstant.LiveType.LIVE_TYPE_STILL) == false) goto L13;
        r105 = 0;
        goto L26
    }

    public final boolean u(Activity r100) {
        this.f407348b.onInitModuleStart(FaceLiveInitDurationHelper.Module.CHECK_CAMERA_FEATURE);
        if (r100.getPackageManager().hasSystemFeature("android.hardware.camera") == true) goto L6;
        e(new BDResponse(ErrorConstant.Client.ERROR_CAMERA_UN_SUPPORT), false);
        this.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.CHECK_CAMERA_FEATURE, false);
        CertLog.e("FaceDetectFlow", "onCreate: camera not support");
        return true;
    L6:
        this.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.CHECK_CAMERA_FEATURE, true);
        return false;
    }

    public c(isa.b r100, FaceDetectFlow r101) {
        Handler r102 = new Handler(Looper.getMainLooper());
        this.f407352f = r102;
        this.f407353g = LivenessEnum.NONE;
        this.f407354h = new Object();
        this.f407355i = new AtomicBoolean(false);
        this.f407356j = new StringBuilder();
        this.f407359m = false;
        this.f407361o = 0;
        this.f407363q = null;
        this.f407364r = null;
        this.f407347a = r100;
        this.f407348b = r101;
        this.f407349c = r101.getLiveInfo();
        rsa.c.b(this);
        this.f407360n = new com.ss.android.bytedcert.face.a(r100.getActivity(), r101);
        this.f407362p = new CameraStateDetector(r102, r101);
    }

    public static void a(c r100, String r101) {
        Object r102 = r100.f407354h;
        monitor-enter(r102);
        r100.f407353g = LivenessEnum.NONE;     // Catch: Throwable -> L6 Exception -> L8
        r100.f407354h.notifyAll();     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L6
        if ("cancel".equals(r101) == true) goto L14;
        return;
    L14:
        if (LivenessEnum.FACE_COMPARE.equals(r100.f407353g) == false) goto L16;
        return;
    L16:
        if (LivenessEnum.LIVENESS_DETECT.equals(r100.f407353g) == true) goto L31;
        JSONObject r103 = new JSONObject();
        r103.put(EventConstant.Key.BACK_POSITION, "detection");     // Catch: Exception -> L23
    L19:
        r100.f407348b.onEvent(EventConstant.Event.RETURN_PREVIOUS_PAGE, r103);
        r100.d(ErrorConstant.Client.ERROR_FACE_LIVE_RETURN);
        return;
    L31:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static void c(c r100, LivenessEnum r101) {
        Object r102 = r100.f407354h;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (LivenessEnum.SHOW_RETAIN_DIALOG.equals(r100.f407353g) == true) goto L15;
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L15:
        r100.f407354h.wait();     // Catch: Exception -> L8 Throwable -> L12
        r100.f407353g = r101;     // Catch: Exception -> L8 Throwable -> L12
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        goto L10
    }

    public final void e(BDResponse r100, boolean r101) {
        this.f407347a.s();
        this.f407348b.onFaceLiveFinish(r100, r101, r100.success, this.f407356j.toString());
    }

    public final void i(boolean r100, Pair<Integer, String> r101) {
        if (r100 == false) goto L5;
    L42:
        JSONObject r102 = new JSONObject();
        r102.put(EventConstant.Key.BACK_POSITION, "detection");     // Catch: Exception -> L55
    L44:
        this.f407348b.onEvent(EventConstant.Event.RETURN_PREVIOUS_PAGE, r102);
        CertLog.d("FaceDetectFlow", "onBackPressed,finish and return");
        if (r101 != null) goto L47;
        r101 = ErrorConstant.Client.ERROR_FACE_LIVE_RETURN;
    L47:
        d(r101);
        bsa.a r103 = this.f407350d;
        if (r103 == null) goto L64;
        lsa.a r104 = r103.f20342t;
        if (r104 == null) goto L65;
        r104.b("on_back_press", null);
        return;
    L65:
        return;
    L64:
        return;
    L5:
        if (this.f407348b.isOpenLiveOpt() == false) goto L7;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L42;
        CertLog.d("FaceDetectFlow", "onBackPressed,show retain dialog");
        if (this.f407355i.get() == false) goto L19;
        return;
    L19:
        if (TextUtils.isEmpty(this.f407348b.getCertInfo().f526590x) == true) goto L22;
        String r106 = this.f407348b.getCertInfo().f526590x;
    L26:
        if (TextUtils.isEmpty(this.f407348b.getCertInfo().f526591y) == true) goto L28;
        String r107 = this.f407348b.getCertInfo().f526591y;
    L30:
        if (TextUtils.isEmpty(this.f407348b.getCertInfo().A) == true) goto L32;
        String r108 = this.f407348b.getCertInfo().A;
    L34:
        if (TextUtils.isEmpty(this.f407348b.getCertInfo().f526592z) == true) goto L36;
        String r109 = this.f407348b.getCertInfo().f526592z;
    L37:
        this.f407348b.setLiveSDKRunning(false);
        this.f407347a.D0();
        ICertDialogDepend.AlertDialogParams r110 = new ICertDialogDepend.AlertDialogParams();
        r110.type = ICertDialogDepend.DialogType.FACE_RETAIN;
        r110.context = this.f407347a.getActivity();
        r110.title = r107;
        r110.message = r106;
        r110.positiveLabel = r109;
        r110.negativeLabel = r108;
        k r111 = new k(this, r109, r108, r106);
        r110.positiveListener = r111;
        r110.negativeListener = r111;
        s(r110);
        JSONObject r112 = new JSONObject();
        r112.put("action_type", EventConstant.Value.RETAIN_SHOW);     // Catch: Exception -> L53
    L39:
        this.f407348b.onEvent(EventConstant.Event.FACE_DETECTION_FAIL_POPUP, r112);
        JSONObject r113 = new JSONObject();
        r113.put(EventConstant.Key.RETAIN_PROMPT, r106);     // Catch: Exception -> L54
    L41:
        this.f407348b.onEvent(EventConstant.Event.FACE_RETAIN_POPUP, r113);
        this.f407353g = LivenessEnum.SHOW_RETAIN_DIALOG;
        this.f407357k = true;
        return;
    L36:
        r109 = this.f407347a.getActivity().getString(R.string.byted_dialog_continue_certification);
        goto L37
    L32:
        r108 = this.f407347a.getActivity().getString(R.string.byted_dialog_decertification);
        goto L34
    L28:
        r107 = this.f407347a.getActivity().getString(R.string.byted_dialog_exit_remind);
        goto L30
    L22:
        if (this.f407348b.isOpenLiveOpt() == false) goto L24;
        r106 = this.f407347a.getActivity().getString(R.string.byted_dialog_exit_message);
        goto L26
    L24:
        r106 = this.f407347a.getActivity().getString(R.string.byted_dialog_retain);
        goto L26
    L7:
        if (TextUtils.isEmpty(this.f407348b.getCertInfo().f526590x) == false) goto L14;
        LiveInfo r114 = this.f407349c;
        if (r114 != null) goto L11;
    L13:
        r105 = false;
        goto L15
    L11:
        if (r114.f407591p == false) goto L13;
        goto L13
    }

    public final void k(String r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.put("action_type", r100);     // Catch: Exception -> L6
        r102.put("error_code", String.valueOf(r101));     // Catch: Exception -> L6
        r102.put("fail_reason", this.f407350d.f20342t.d());     // Catch: Exception -> L6
    L4:
        this.f407348b.onEvent(EventConstant.Event.FACE_DETECTION_FAIL_POPUP, r102);
    }

    public final void m(boolean r100, Pair<Integer, String> r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == false) goto L6;
        String r103 = "1";
    L15:
        r102.put("result", r103);     // Catch: Exception -> L11
        if (r101 == null) goto L13;
        r102.put("error_msg", r101.second);     // Catch: Exception -> L11
        r102.put("error_code", String.valueOf(r101.first));     // Catch: Exception -> L11
    L13:
        this.f407348b.onEvent(EventConstant.Event.CERT_OFFLINE_FACE_VERIFY, r102);
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L6:
        r103 = "0";
        goto L15
    }

    public final void n(boolean r100, Pair<Integer, String> r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == false) goto L6;
        String r103 = "1";
    L15:
        r102.put("result", r103);     // Catch: Exception -> L11
        if (r101 == null) goto L13;
        r102.put("error_msg", r101.second);     // Catch: Exception -> L11
        r102.put("error_code", String.valueOf(r101.first));     // Catch: Exception -> L11
    L13:
        this.f407348b.onEvent(EventConstant.Event.CERT_DO_STILL_LIVENESS, r102);
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L6:
        r103 = "0";
        goto L15
    }

    public final void r(GLSurfaceView r110, FaceDetectFullActivity.f r111) {
        if (this.f407359m == false) goto L5;
        return;
    L5:
        if (this.f407358l == false) goto L8;
        return;
    L8:
        if (this.f407351e != null) goto L10;
        this.f407351e = new Accelerometer(this.f407347a.getActivity().getApplicationContext());
    L10:
        this.f407351e.a();
        BytedCertManager.getInstance().postEventMessage(this.f407348b.getCertInfo().f526573g, EventConstant.MSSecEvent.CAMERA_CREATE);
        if (r110 != null) goto L15;
        e(new BDResponse(ErrorConstant.Client.ERROR_ALGORITHM_INIT_FAIL), false);
        CertLog.e("FaceDetectFlow", "init failed:surface view is null");
        this.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.LOAD_SMASH, false);
        this.f407347a.finish();
        return;
    L15:
        if (this.f407350d != null) goto L23;
        Activity r100 = this.f407347a.getActivity();
        FaceDetectFlow r101 = this.f407348b;
        boolean r102 = this.f407347a instanceof FaceDetectDialogActivity;
        Object r103 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_DISPLAY_FACTOR);
        if ((r103 instanceof Boolean) == true) goto L19;
    L21:
        bsa.a r104 = new csa.a(r100, r101, r111, r110, false, r102);
    L22:
        this.f407350d = r104;
        goto L23
    L19:
        if (((Boolean) r103).booleanValue() == false) goto L21;
        r104 = new bsa.b(r100, r101, r111, r110, false, r102);
    L23:
        this.f407348b.setCameraStartType(1);
        this.f407348b.setGLPause(false);
        if (this.f407357k == true) goto L26;
        this.f407348b.setLiveSDKRunning(true);
    L26:
        this.f407348b.onInitModuleStart("face_camera_setup");
        bsa.a r112 = this.f407350d;
        r112.getClass();
        STGLRenderer r105 = new STGLRenderer();
        r112.f20336n = r105;
        r105.f407270a = false;
        r112.f20329g.onResume();
        this.f407350d.i();
        this.f407350d.c(new com.ss.android.bytedcert.face.e(this));
        this.f407350d.e(new com.ss.android.bytedcert.face.f(this));
        this.f407348b.onInitModuleFinish("face_camera_setup", true, true);
        this.f407359m = true;
    }

    public final void p(String r100, String r101, int r102) {
        bsa.a r103 = this.f407350d;
        if (r103 == null) goto L6;
        r103.g(CameraFactory$WhiteBalanceType.NONE);
    L6:
        if (this.f407347a.getActivity().isFinishing() == false) goto L8;
        return;
    L8:
        LiveInfo r104 = this.f407349c;
        if (r104 != null) goto L12;
        return;
    L12:
        if (r104.f407579d == false) goto L18;
        int r105 = r104.f407580e - 1;
        r104.f407580e = r105;
        if (r105 < 0) goto L16;
        this.f407347a.getActivity().runOnUiThread(new b(this, r100, r101, r102));
        return;
    L16:
        e(new BDResponse(ErrorConstant.Client.ERROR_FACE_LIVE_MAX_TIME), false);
        this.f407347a.finish();
        return;
    L18:
        this.f407347a.showLoading(null);
        CertLog.d("FaceDetectFlow", "request live_detect");
        C4711c r106 = new C4711c(this, r100, r101, r102);
        psa.a r107 = this.f407348b.getRequestUtils();
        boolean r108 = this.f407348b.getCertInfo().f526576j;
        FaceDetectFlow r109 = this.f407348b;
        Map<String, String> r110 = r109.appendCommonRequestParams(r109.createSubmitLiveParams());
        r107.getClass();
        r107.c(r106, "GET", UrlConstant.getLiveDetectPath(r108, TextUtils.equals("video", r110.get(BytedCertConstant.CertKey.LIVE_TYPE))), r110);
    }

    public static void b(c r100, String r101, String r102, int r103) {
        r100.f407347a.D0();
        ICertDialogDepend.AlertDialogParams r104 = new ICertDialogDepend.AlertDialogParams();     // Catch: Exception -> L5
        r104.type = ICertDialogDepend.DialogType.FACE_RETRY;     // Catch: Exception -> L5
        r104.context = r100.f407347a.getActivity();     // Catch: Exception -> L5
        r104.title = r101;     // Catch: Exception -> L5
        r104.message = r102;     // Catch: Exception -> L5
        r104.positiveLabel = r100.f407347a.getActivity().getString(R.string.byted_face_live_try_more);     // Catch: Exception -> L5
        r104.positiveListener = new l(r100, r103);     // Catch: Exception -> L5
        r104.negativeLabel = r100.f407347a.getActivity().getString(R.string.byted_face_live_out);     // Catch: Exception -> L5
        r104.negativeListener = new com.ss.android.bytedcert.face.b(r100, r103, r102, r101);     // Catch: Exception -> L5
        r100.k(EventConstant.Value.ALERT_SHOW, r103);     // Catch: Exception -> L5
        r100.f407357k = true;     // Catch: Exception -> L5
        r100.s(r104);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
