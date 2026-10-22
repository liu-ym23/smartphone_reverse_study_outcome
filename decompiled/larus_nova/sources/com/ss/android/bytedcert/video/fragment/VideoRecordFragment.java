package com.ss.android.bytedcert.video.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import bsa.f;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.camera.common.gl.STGLRenderer;
import com.ss.android.bytedcert.dialog.CommonDialog;
import com.ss.android.bytedcert.dialog.controller.video.VideoRecordController;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.utils.Accelerometer;
import com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment;
import com.ss.android.bytedcert.view.VideoRecordButton;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.CertLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoRecordFragment extends AbsBaseFragment implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f407680v = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f407681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Accelerometer f407682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public bsa.a f407683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f407684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GLSurfaceView f407685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f407686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f407687l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f407688m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f407689n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VideoRecordButton f407690o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f407691p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f407692q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f407693r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public VideoRecordController f407694s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final WeakHandler f407695t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e f407696u;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoRecordFragment f407697a;

        public a(VideoRecordFragment r100) {
            this.f407697a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
            r101.put("button", "cancel");     // Catch: Exception -> L5
            this.f407697a.f407694s.onEvent(EventConstant.Event.EVENT_VIDEO_RECORD_PREPARE_CLICK, r101);     // Catch: Exception -> L5
        L3:
            VideoRecordFragment r102 = this.f407697a;
            Pair<Integer, String> r103 = ErrorConstant.Client.ERROR_FACE_LIVE_RETURN;
            int r104 = VideoRecordFragment.f407680v;
            r102.getClass();
            r102.S90(new BDResponse(r103));
        }
    }

    public class b implements VideoRecordButton.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoRecordFragment f407698a;

        @Override // com.ss.android.bytedcert.view.VideoRecordButton.d
        public final void a1() {
            boolean r100 = false;
            if (BytedCertSdkManager.getInstance().isLocalTest() == false) goto L5;
            Toast.makeText(this.f407698a.getActivity(), "开始录制", 0).show();
        L5:
            lsa.a r101 = this.f407698a.f407683h.f20342t;
            if (r101 == null) goto L8;
            r101.g();
        L8:
            VideoRecordFragment r102 = this.f407698a;
            if (r102.getActivity() == null) goto L11;
            ((ssa.a) r102.getActivity()).F0();
        L11:
            TextView r103 = r102.f407686k;
            if (r103 == null) goto L14;
            r100 = TextUtils.equals(r103.getText(), r102.getString(R.string.byted_video_record_default_prompt));
        L14:
            if (r100 == false) goto L28;
            bsa.a r104 = r102.f407683h;
            if (r104 == null) goto L33;
            r102.f407693r = true;
            lsa.a r105 = r104.f20342t;
            if (r105 == null) goto L33;
            if ((r105 instanceof ssa.e) == false) goto L33;
            ((ssa.e) r105).m(r104.f20324b, r104.f20325c);
        L33:
            JSONObject r106 = new JSONObject();     // Catch: Exception -> L24
            r106.put("button", "record_video_start");     // Catch: Exception -> L24
            r102.f407694s.onEvent(EventConstant.Event.EVENT_VIDEO_RECORD_PREPARE_CLICK, r106);     // Catch: Exception -> L24
        L25:
            r102.f407686k.setVisibility(8);
            TextView r107 = r102.f407687l;
            if (r107 == null) goto L35;
            r107.setTextSize(2, 35.0f);
            return;
        L35:
            return;
        L28:
            r102.f407690o.b();
            if (r102.getActivity() == null) goto L31;
            ((ssa.a) r102.getActivity()).r1(r102.getString(R.string.byted_video_record_pre_check_no_face_title), r102.getString(R.string.byted_video_record_pre_check_no_face_tip), null, r102.getString(R.string.byted_know), null, r102.f407689n);
            return;
        L31:
            r102.S90(new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN));
        }

        public b(VideoRecordFragment r100) {
            this.f407698a = r100;
        }

        @Override // com.ss.android.bytedcert.view.VideoRecordButton.d
        public final void a(VideoRecordButton.StopType r100) {
            if (BytedCertSdkManager.getInstance().isLocalTest() == false) goto L5;
            Toast.makeText(this.f407698a.getActivity(), "录制结束", 0).show();
        L5:
            lsa.a r101 = this.f407698a.f407683h.f20342t;
            if (r101 != null) goto L8;
        L10:
            TextView r102 = this.f407698a.f407686k;
            if (r102 == null) goto L13;
            r102.setVisibility(0);
        L13:
            TextView r103 = this.f407698a.f407688m;
            if (r103 == null) goto L16;
            r103.setVisibility(8);
        L16:
            TextView r104 = this.f407698a.f407687l;
            if (r104 == null) goto L30;
            r104.setTextSize(2, 25.0f);
        L30:
            JSONObject r105 = new JSONObject();     // Catch: Exception -> L29
            if (r100 != VideoRecordButton.StopType.CLICK) goto L24;
            r105.put("button", "record_video_end_click");     // Catch: Exception -> L29
        L27:
            this.f407698a.f407694s.onEvent(EventConstant.Event.EVENT_VIDEO_RECORD_PREPARE_CLICK, r105);     // Catch: Exception -> L29
            return;
        L24:
            if (r100 != VideoRecordButton.StopType.RELEASE) goto L26;
            r105.put("button", "record_video_end_release");     // Catch: Exception -> L29
            goto L27
        L26:
            r105.put("button", "record_video_end_timeout");     // Catch: Exception -> L29
        L32:
            return;
        L8:
            if ((r101 instanceof ssa.e) == false) goto L10;
            ((ssa.e) r101).n(true);
            goto L10
        }

        @Override // com.ss.android.bytedcert.view.VideoRecordButton.d
        public final void b(long r100) {
            TextView r101 = this.f407698a.f407688m;
            if (r101 == null) goto L6;
            r101.setVisibility(0);
            this.f407698a.f407688m.setText(String.format("00:%02d / 00:%d", new Object[]{Long.valueOf(r100 / 1000), Integer.valueOf(this.f407698a.f407691p)}));
            return;
        }
    }

    public class c implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoRecordFragment f407699a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f407700a;

            @Override // java.lang.Runnable
            public final void run() {
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L14;
                throw th;
            L14:
                return;
            L3:
                if (this.f407700a.f407699a.getContext() == null) goto L10;
                this.f407700a.f407699a.f407690o.b();     // Catch: Throwable -> L7
                VideoRecordFragment r100 = this.f407700a.f407699a;     // Catch: Throwable -> L7
                r100.W90(r100.getString(R.string.byted_video_record_timeout), ErrorConstant.Client.ERROR_VIDEO_RECORD_NO_FACE);     // Catch: Throwable -> L7
                return;
            }

            public a(c r100) {
                this.f407700a = r100;
            }
        }

        public c(VideoRecordFragment r100) {
            this.f407699a = r100;
        }

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            if (this.f407699a.getActivity() == null) goto L5;
            ((ssa.a) this.f407699a.getActivity()).hideLoading();
        L5:
            if (r100 != null) goto L8;
            VideoRecordFragment r101 = this.f407699a;
            Pair<Integer, String> r102 = ErrorConstant.Client.ERROR_NETWORK_ERROR;
            String r103 = (String) r102.second;
            int r104 = VideoRecordFragment.f407680v;
            r101.W90(r103, r102);
        L20:
            JSONObject r105 = new JSONObject();     // Catch: Exception -> L19
            if (r100 != null) goto L14;
        L16:
            String r106 = "fail";
        L17:
            r105.put("result", r106);     // Catch: Exception -> L19
            this.f407699a.f407694s.onEvent(EventConstant.Event.EVENT_RANDOM_CODE_REQUEST_RESULT, r105);     // Catch: Exception -> L19
            return;
        L14:
            if (r100.success == false) goto L16;
            r106 = "success";
        L22:
            return;
        L8:
            if (r100.success == false) goto L10;
            this.f407699a.f407689n = 0;
            String r107 = r100.jsonData.optString("read_content");
            this.f407699a.f407694s.setReadContext(r107);
            this.f407699a.f407687l.setText(r107);
            int r108 = r100.jsonData.optInt("expired_interval");
            VideoRecordFragment r109 = this.f407699a;
            r109.f407691p = r100.jsonData.optInt("record_timeout", 20);
            VideoRecordFragment r110 = this.f407699a;
            r110.f407690o.setMaxDuration(r110.f407691p * 1000);
            VideoRecordFragment r111 = this.f407699a;
            r111.f407695t.postDelayed(new a(this), ((long) (r108 - r111.f407691p)) * 1000);
            goto L20
        L10:
            VideoRecordFragment r112 = this.f407699a;
            String r113 = r100.errorMsg;
            Pair<Integer, String> r114 = new Pair(Integer.valueOf(r100.errorCode), r100.errorMsg);
            int r115 = VideoRecordFragment.f407680v;
            r112.W90(r113, r114);
            goto L20
        }
    }

    public class d implements CommonDialog.OnDialogClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f407701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoRecordFragment f407702b;

        @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
        public final void onCancel(DialogInterface r100) {
            VideoRecordFragment r101 = this.f407702b;
            Pair r102 = this.f407701a;
            int r103 = VideoRecordFragment.f407680v;
            r101.getClass();
            r101.S90(new BDResponse(r102));
        }

        @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
        public final void onConfirm(DialogInterface r100) {
            this.f407702b.T90();
            this.f407702b.f407694s.setLiveSDKRunning(true);
        }

        public d(VideoRecordFragment r100, Pair r101) {
            this.f407702b = r100;
            this.f407701a = r101;
        }
    }

    public class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoRecordFragment f407703a;

        @Override // bsa.f
        public final void a() {
            FragmentActivity r100 = this.f407703a.getActivity();
            if (r100 != null) goto L5;
            return;
        L5:
            r100.runOnUiThread(new com.ss.android.bytedcert.video.fragment.a(this));
        }

        public e(VideoRecordFragment r100) {
            this.f407703a = r100;
        }
    }

    @Override // com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment
    public final int getContentViewLayoutId() {
        return R.layout.byted_fragment_video_record_new;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    public final void V90() {
        CertLog.e(this.f407681f, "release Camera");
        Accelerometer r100 = this.f407682g;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        bsa.a r101 = this.f407683h;
        if (r101 == null) goto L10;
        r101.a();
        bsa.a r102 = this.f407683h;
        lsa.a r103 = r102.f20342t;
        if (r103 == null) goto L10;
        r103.f();
        r102.f20342t = null;
    L10:
        this.f407694s.setLiveSDKRunning(false);
        this.f407694s.setGLPause(true);
        this.f407692q = false;
    }

    public final void X90() {
        this.f407690o.b();
        this.f407694s.setCameraStartType(1);
        bsa.a r100 = this.f407683h;
        r100.getClass();
        STGLRenderer r101 = new STGLRenderer();
        r100.f20336n = r101;
        r101.f407270a = false;
        r100.f20329g.onResume();
        this.f407683h.i();
        this.f407694s.setGLPause(false);
        this.f407694s.setLiveSDKRunning(true);
        this.f407692q = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        Accelerometer r100 = this.f407682g;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        super.onResume();
        if (this.f407692q == true) goto L13;
        U90();
        X90();
        if (this.f407693r == true) goto L10;
        return;
    L10:
        if (getActivity() == null) goto L15;
        W90(getString(R.string.byted_video_record_check_no_face_title), ErrorConstant.Client.ERROR_VIDEO_RECORD_NO_FACE);
        return;
    L15:
        return;
    }

    public VideoRecordFragment() {
        this.f407681f = "VideoRecordFragment";
        this.f407682g = null;
        this.f407683h = null;
        this.f407695t = new WeakHandler(Looper.getMainLooper(), this);
        this.f407696u = new e(this);
    }

    public final void T90() {
        if (getActivity() == null) goto L5;
        ((ssa.a) getActivity()).showLoading();
    L5:
        psa.a r100 = this.f407694s.getRequestUtils();
        Map<String, String> r101 = this.f407694s.appendCommonRequestParams(null);
        c r102 = new c(this);
        r100.getClass();
        if (r101 == null) goto L8;
        HashMap r103 = new HashMap(r101);
    L9:
        r100.c(r102, "GET", UrlConstant.getVideoShootConfigPath(), r103);
        return;
    L8:
        r103 = new HashMap();
        goto L9
    }

    public final void U90() {
        if (getActivity() != null) goto L6;
        return;
    L6:
        if (this.f407682g != null) goto L8;
        this.f407682g = new Accelerometer(getActivity().getApplication());
    L8:
        Bundle r100 = getActivity().getIntent().getExtras();
        if (this.f407683h != null) goto L17;
        Context r101 = getContext();
        VideoRecordController r102 = this.f407694s;
        GLSurfaceView r103 = this.f407685j;
        e r104 = this.f407696u;
        Object r105 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.CAMERA_DISPLAY_FACTOR);
        if ((r105 instanceof Boolean) == true) goto L13;
    L15:
        bsa.a r106 = new csa.a(r101, r102, r104, r103, true, false);
    L16:
        this.f407683h = r106;
        goto L17
    L13:
        if (((Boolean) r105).booleanValue() == false) goto L15;
        r106 = new bsa.b(r101, r102, r104, r103, true, false);
    L17:
        bsa.a r107 = this.f407683h;
        VideoRecordController r108 = this.f407694s;
        r107.getClass();
        ssa.e r109 = new ssa.e(r108);
        r107.f20342t = r109;
        r107.f20346x = r109.e(r107.f20328f, r100);
        if (this.f407683h.f20346x == 0) goto L21;
        CertLog.e("FaceLiveSDKActivity", "init failed");
        BDResponse r110 = new BDResponse(ErrorConstant.Client.ERROR_ALGORITHM_INIT_FAIL);
        r110.detailErrorCode = this.f407683h.f20346x;
        S90(r110);
        return;
    L21:
        CertLog.d("debug1 FaceLiveSDKActivity", "SetParam");
        int r111 = this.f407683h.d(null);
        if (r111 == 0) goto L25;
        CertLog.d("FaceLiveSDKActivity", "init params failed");
        BDResponse r112 = new BDResponse(ErrorConstant.Client.ERROR_ALGORITHM_PARAMS_FAIL);
        r112.detailErrorCode = r111;
        S90(r112);
        return;
    L25:
        CertLog.d("debug1 FaceLiveSDKActivity", "SetConfig");
        lsa.a r113 = this.f407683h.f20342t;
        if (r113 == null) goto L28;
        int r114 = r113.g();
    L29:
        if (r114 == 0) goto L32;
        CertLog.d("FaceLiveSDKActivity", "reset failed");
        S90(new BDResponse(ErrorConstant.Client.ERROR_SET_TASK_FAIL));
        return;
    L32:
        this.f407682g.a();
        return;
    L28:
        r114 = -1;
        goto L29
    }

    @Override // com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment
    public final void initData() {
        if (getArguments() == null) goto L8;
        String r100 = getArguments().getString(BytedCertConstant.IntentKey.FLOW_ID);
        ICertFlow r101 = BytedCertManager.getInstance().getFlow(r100);
        if ((r101 instanceof BytedCertFlow) == false) goto L8;
        this.f407694s = ((BytedCertFlow) r101).getRecordController();
    L8:
        if (this.f407694s != null) goto L11;
        this.f407705e = true;
        S90(new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN));
        return;
    L11:
        FragmentActivity r102 = getActivity();
        if (r102 != null) goto L14;
    L17:
        this.f407694s.onEvent(EventConstant.Event.EVENT_VIDEO_RECORD_PREPARE_SHOW, null);
        return;
    L14:
        if (r102.getPackageManager().hasSystemFeature("android.hardware.camera") == true) goto L17;
        S90(new BDResponse(ErrorConstant.Client.ERROR_CAMERA_UN_SUPPORT));
        this.f407705e = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.f407692q == false) goto L5;
        V90();
    L5:
        this.f407695t.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        if (this.f407692q == false) goto L5;
        V90();
    L5:
        this.f407690o.b();
    }

    public final void S90(BDResponse r100) {
        if (getActivity() == null) goto L6;
        ((ssa.a) getActivity()).O(r100);
        return;
    }

    @Override // com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment
    public final void initActions(View r100) {
        T90();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        CertLog.e(this.f407681f, "hide " + r100);
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f407692q == false) goto L9;
        V90();
        return;
    }

    public final void W90(String r100, Pair<Integer, String> r110) {
        this.f407695t.removeCallbacksAndMessages(null);
        this.f407694s.setLiveSDKRunning(false);
        if (getActivity() == null) goto L5;
        ((ssa.a) getActivity()).r1(r100, null, getString(R.string.byted_exit_veri), getString(R.string.byted_video_record_check_retry), new d(this, r110), ((Integer) r110.first).intValue());
        return;
    L5:
        S90(new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN));
    }

    @Override // com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment
    public final void initViews(View r100, Bundle r101) {
        this.f407684i = (FrameLayout) r100.findViewById(R.id.id_preview_layout);
        this.f407685j = (GLSurfaceView) r100.findViewById(R.id.id_gl_sv);
        this.f407686k = (TextView) r100.findViewById(R.id.tv_prompt);
        ((ImageView) r100.findViewById(R.id.return_back)).setOnClickListener(new a(this));
        this.f407687l = (TextView) r100.findViewById(R.id.tv_code);
        this.f407688m = (TextView) r100.findViewById(R.id.tv_time_spend);
        VideoRecordButton r102 = (VideoRecordButton) r100.findViewById(R.id.video_record_button);
        this.f407690o = r102;
        r102.setOnRecordListener(new b(this));
        U90();
        X90();
    }
}
