package vs7;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.WorkState;
import com.dtf.face.api.IDTFragment;
import com.dtf.face.api.IDTUICallBack;
import com.dtf.face.camera.CameraSurfaceView;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.Coll;
import com.dtf.face.config.DeviceSetting;
import com.dtf.face.config.Upload;
import com.dtf.face.log.MemoryService;
import com.dtf.face.log.RecordConst;
import com.dtf.face.log.RecordService;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.dtf.face.utils.ClientConfigUtil;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import com.dtf.toyger.base.face.ToygerFaceService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import faceverify.l;
import faceverify.m;
import faceverify.o;
import faceverify.q;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import ws7.p;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements i {
    public WorkState A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CameraSurfaceView f557066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f557067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f557068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f557069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f557070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IDTFragment f557071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Activity f557072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f557073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f557074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public qs7.a f557075j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f557076k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f557077l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ws7.b f557078m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public vs7.g f557079n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f557080o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f557081p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f557082q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, Object> f557083r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f557084s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f557085t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f557086u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f557087v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f557088w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f557089x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, Long> f557090y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Handler f557091z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f557092a;

        public final void a() {
            String r100 = this.f557092a.f557086u;
            m.f476172c = r100;
            if (m.f476170a != null) goto L6;
            m.a();
        L6:
            if (m.f476171b.containsKey(r100) == true) goto L31;
            Context r101 = hs7.a.h().getContext();     // Catch: Throwable -> L28
            String[] r102 = r101.getAssets().list(FaceShowElderlyFragment.AUDIO_ASSTES_PATH);     // Catch: Throwable -> L28
            if (r102 != null) goto L10;
        L12:
            PolarisFileWrapper r103 = new PolarisFileWrapper(r101.getCacheDir(), FaceShowElderlyFragment.DOWNLOAD_AUDIO_PATH);     // Catch: Throwable -> L28
            if (new PolarisFileWrapper(r103.getAbsolutePath() + File.separator + r100 + FaceShowElderlyFragment.AUDIO_FORM).exists() == true) goto L15;
        L17:
            HashMap<String, String> r104 = new HashMap();     // Catch: Throwable -> L28
            AndroidClientConfig r105 = hs7.a.h().c();     // Catch: Throwable -> L28
            if (r105 == null) goto L22;
            HashMap<String, String> r106 = r105.suitable;     // Catch: Throwable -> L28
            if (r106 == null) goto L22;
            r104 = r106;
        L22:
            String r107 = r104.get(r100);     // Catch: Throwable -> L28
            if (r104.size() > 0) goto L25;
            return;
        L25:
            if (TextUtils.isEmpty(r107) == true) goto L38;
            ts7.c.c(new o(r100, r107));     // Catch: Throwable -> L28
            return;
        L38:
            return;
        L15:
            if (m.a(r100) == false) goto L17;
            m.a(r103.getAbsolutePath(), r100, true);     // Catch: Throwable -> L28
            return;
        L10:
            if (r102.length <= 0) goto L12;
            m.a(FaceShowElderlyFragment.AUDIO_ASSTES_PATH, r100, false);     // Catch: Throwable -> L28
            return;
        L28:
            th = move-exception;
            RecordService.getInstance().recordException(th);
            return;
        L31:
            if (m.f476174e.contains(m.f476171b.get(r100)) == false) goto L40;
            m.a(m.f476171b.get(r100).intValue());
            return;
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

        public a(f r100) {
            this.f557092a = r100;
        }
    }

    public class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f557093a;

        public class a implements Animation.AnimationListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f557094a;

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation r100) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation r100) {
            }

            public a(b r100) {
                this.f557094a = r100;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation r100) {
                ImageView r101 = this.f557094a.f557093a.f557067b;
                if (r101 == null) goto L5;
                r101.setVisibility(8);
            L5:
                this.f557094a.f557093a.f557076k = 0;
            }
        }

        public b(f r100) {
            this.f557093a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r110) {
            int r100 = r110.what;
            if (r100 != 917) goto L5;
            this.f557093a.f557071f.onPhotinusInterrupt();
            View r101 = this.f557093a.f557069d;
            if (r101 == null) goto L232;
            r101.setBackgroundColor(0);
        L232:
            return true;
        L5:
            if (r100 != 923) goto L7;
            IDTFragment r102 = this.f557093a.f557071f;
            if (r102 == null) goto L232;
            r102.onCameraPreviewBegin(1);
            AlphaAnimation r103 = new AlphaAnimation(1.0f, 0.0f);
            r103.setDuration(200);
            r103.setAnimationListener(new a(this));
            ImageView r104 = this.f557093a.f557067b;
            if (r104 == null) goto L232;
            r104.startAnimation(r103);
            goto L232
        L7:
            if (r100 == 924) goto L221;
            is7.e r105 = null;
            switch(r100) {
                case 901: goto L194;
                case 902: goto L185;
                case 903: goto L132;
                case 904: goto L12;
                default: goto L10;
            };
        L10:
            switch(r100) {
                case 910: goto L220;
                case 911: goto L212;
                case 912: goto L208;
                case 913: goto L201;
                case 914: goto L197;
                default: goto L232;
            };
        L197:
            hs7.b r106 = hs7.b.D;
            int r107 = r110.arg1;
            ToygerFaceService r108 = r106.f487019b;
            if (r108 != null) goto L234;
        L200:
            this.f557093a.f557080o = r110.arg1;
            goto L232
        L234:
            r108.updateNativeState(106, String.valueOf(r107));     // Catch: Exception -> L233
            goto L200
        L201:
            this.f557093a.e(true);
            ws7.b r109 = this.f557093a.f557078m;
            if (r109 == null) goto L204;
            r109.f561061e.removeMessages(0);
            r109.f561061e.removeCallbacks(null);
        L204:
            this.f557093a.j(true, true);
            if (hs7.b.D.f487041x == false) goto L207;
            this.f557093a.f557071f.onPhotinusEnd();
        L207:
            this.f557093a.f557071f.onVerifyBegin();
            goto L232
        L208:
            f r111 = this.f557093a;
            int r112 = r110.arg1;
            View r113 = r111.f557069d;
            if (r113 == null) goto L211;
            r113.setBackgroundColor(r112);
        L211:
            r111.f557071f.onPhotinusColorUpdate(r112);
            goto L232
        L212:
            f r114 = this.f557093a;
            if (r114.f557069d != null) goto L219;
            FrameLayout r115 = r114.f557071f.getPhotinusContainer();
            r114.f557070e = r115;
            if (r115 == null) goto L219;
            r115.setVisibility(0);
            View r116 = new View(r114.f557072g, null);
            r114.f557069d = r116;
            r114.f557070e.addView(r116, new FrameLayout.LayoutParams(-1, -1));
        L219:
            r114.f557071f.onPhotinusBegin();
            goto L232
        L220:
            this.f557093a.g();
            goto L232
        L12:
            f r117 = this.f557093a;
            int r118 = r110.arg1;
            int r119 = r110.arg2;
            Bundle r120 = r110.peekData();
            if (r117.f557081p == r119) goto L15;
            r117.c(true);
        L15:
            r117.f557081p = r119;
            if (r118 == 14) goto L46;
            if (r118 != 15) goto L19;
            String r121 = "rightYaw";
            int r122 = R.string.dtf_right_yaw_guide;
        L47:
            String r123 = p.g(r117.f557072g, r121, r122);
            switch(r118) {
                case 20: goto L50;
                case 21: goto L50;
                case 22: goto L50;
                case 23: goto L50;
                default: goto L49;
            };
        L49:
            String r124 = "";
            int r125 = -1;
        L52:
            if (r125 != (-1)) goto L71;
            if (r119 == 0) goto L67;
            if (r119 == 1) goto L65;
            if (r119 == 2) goto L64;
            if (r119 == 3) goto L63;
            if (r119 == 6) goto L62;
            if (r119 == 7) goto L61;
            if (r119 != 8) goto L71;
        L61:
            r117.f557082q = true;
            goto L71
        L62:
            r117.f557082q = true;
        L70:
            r124 = "photinusCommTips";
            r125 = R.string.dtf_face_photinus_comm_tips_text;
            goto L71
        L63:
            r117.f557082q = true;
            r125 = R.string.dtf_static_message_right_yaw_liveness;
            r124 = "rightYawLiveness";
            goto L71
        L64:
            r117.f557082q = true;
            r125 = R.string.dtf_static_message_left_yaw_liveness;
            r124 = "leftYawLiveness";
            goto L71
        L65:
            r117.f557082q = true;
        L69:
            r124 = "faceTitleBlink";
            r125 = R.string.dtf_face_comm_tips_text;
            goto L71
        L67:
            if (r117.f557082q == false) goto L70;
            if (r118 != 0) goto L69;
        L71:
            r117.f557071f.onFaceTipsUpdateFace(p.g(r117.f557072g, r124, r125), r123, r120);
            if (r118 == 0) goto L92;
            if (r118 == 11) goto L91;
            if (r118 == 12) goto L92;
            if (r118 != 14) goto L77;
            r119 = 2;
        L94:
            if (r117.f557080o == r119) goto L102;
            r117.f557080o = r119;
            r117.f557091z.removeMessages(914);
            Message r126 = Message.obtain(r117.f557091z);
            r126.what = 914;
            int r127 = r117.f557080o;
            r126.arg1 = r127;
            Handler r128 = r117.f557091z;
            if (r127 != 0) goto L99;
            long r129 = 0;
        L100:
            r128.sendMessageDelayed(r126, r129);
            goto L102
        L99:
            r129 = 100;
        L102:
            if (r117.f557084s == false) goto L232;
            if (r117.f557085t == r118) goto L232;
            if (r118 == 1) goto L130;
            if (r118 == 2) goto L129;
            if (r118 == 3) goto L128;
            if (r118 == 5) goto L127;
            if (r118 == 6) goto L127;
            if (r118 != 8) goto L112;
            r117.f557086u = "dtf_light";
        L131:
            m.b();
            r117.f557091z.removeCallbacks(r117.f557087v);
            r117.f557091z.postDelayed(r117.f557087v, 16);
            r117.f557085t = r118;
            goto L232
        L112:
            if (r118 != 19) goto L114;
            r117.f557086u = "dtf_too_more_face";
            goto L131
        L114:
            if (r118 != 11) goto L116;
            r117.f557086u = "dtf_blink";
            goto L131
        L116:
            if (r118 == 12) goto L123;
            if (r118 != 14) goto L119;
            r117.f557086u = "dtf_left_yaw";
            goto L131
        L119:
            if (r118 != 15) goto L232;
            r117.f557086u = "dtf_right_yaw";
            goto L131
        L123:
            r117.f557086u = "dtf_stay";
        L127:
            r117.f557086u = "dtf_angle";
            goto L131
        L128:
            r117.f557086u = "dtf_away";
            goto L131
        L129:
            r117.f557086u = "dtf_closer";
            goto L131
        L130:
            r117.f557086u = "dtf_integrity";
            goto L131
        L77:
            if (r118 != 15) goto L79;
            r119 = 3;
            goto L94
        L79:
            if (r118 != 17) goto L81;
            r119 = 5;
            goto L94
        L81:
            if (r118 == 18) goto L87;
            switch(r118) {
                case 25: goto L84;
                case 26: goto L84;
                case 27: goto L84;
                case 28: goto L84;
                case 29: goto L84;
                case 30: goto L94;
                default: goto L83;
            };
        L83:
            r119 = 0;
            goto L94
        L84:
            if (r119 != 8) goto L86;
            r119 = 8;
            goto L94
        L86:
            r119 = 7;
            goto L94
        L87:
            r119 = 6;
            goto L94
        L91:
            r119 = 1;
        L92:
            r119 = r117.f557080o;
            goto L94
        L50:
            r125 = R.string.dtf_static_message_quality_tips;
            r124 = "qualityTitle";
            goto L52
        L19:
            if (r118 == 100) goto L44;
            switch(r118) {
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L30;
                case 4: goto L29;
                case 5: goto L35;
                case 6: goto L35;
                case 7: goto L28;
                case 8: goto L27;
                case 9: goto L26;
                case 10: goto L25;
                case 11: goto L24;
                case 12: goto L37;
                default: goto L21;
            };
        L21:
            switch(r118) {
                case 18: goto L37;
                case 19: goto L36;
                case 20: goto L35;
                case 21: goto L34;
                case 22: goto L33;
                case 23: goto L34;
                default: goto L22;
            };
        L22:
            switch(r118) {
                case 25: goto L43;
                case 26: goto L42;
                case 27: goto L41;
                case 28: goto L40;
                case 29: goto L39;
                case 30: goto L38;
                default: goto L23;
            };
        L23:
            r121 = "";
            r122 = -1;
            goto L47
        L38:
            r121 = "faceNotInPosition";
            r122 = R.string.dtf_face_not_in_position;
            goto L47
        L39:
            r121 = "nearFarCollect";
            r122 = R.string.dtf_nearfar_collect;
            goto L47
        L40:
            r121 = "calibrateTooClose";
            r122 = R.string.dtf_calibrate_too_close;
            goto L47
        L41:
            r121 = "calibrateTooFar";
            r122 = R.string.dtf_calibrate_too_far;
            goto L47
        L42:
            r121 = "targetTooClose";
            r122 = R.string.dtf_target_too_close;
            goto L47
        L43:
            r121 = "targetTooFar";
            r122 = R.string.dtf_target_too_far;
            goto L47
        L33:
            r121 = "hasHat";
            r122 = R.string.dtf_has_hat;
            goto L47
        L34:
            r121 = "faceOcclusion";
            r122 = R.string.dtf_has_occlusion;
            goto L47
        L36:
            r121 = "faceTooMore";
            r122 = R.string.dtf_face_too_more;
            goto L47
        L24:
            r121 = IPerformanceManager.MODULE_BLINK;
            r122 = R.string.dtf_blink_openness;
            goto L47
        L25:
            r121 = "eyesOnScreen";
            r122 = R.string.dtf_bad_eye_openness;
            goto L47
        L26:
            r121 = "faceBadQuality";
            r122 = R.string.dtf_bad_quality;
            goto L47
        L27:
            r121 = "faceBrightless";
            r122 = R.string.dtf_bad_brightness;
            goto L47
        L28:
            r121 = "faceIsMoving";
            r122 = R.string.dtf_is_moving;
            goto L47
        L29:
            r121 = "faceNotIn";
            r122 = R.string.dtf_face_not_in_center;
            goto L47
        L30:
            r121 = "faceTooClose";
            r122 = R.string.dtf_distance_too_close;
            goto L47
        L31:
            r121 = "faceTooFar";
            r122 = R.string.dtf_distance_too_far;
            goto L47
        L32:
            r121 = "faceNotFound";
            r122 = R.string.dtf_no_face;
        L35:
            r121 = "badPitch";
            r122 = R.string.dtf_bad_pitch;
        L37:
            r121 = "stackTime";
            r122 = R.string.dtf_stack_time;
            goto L47
        L44:
            r121 = "doPhotinus";
            r122 = R.string.dtf_topText_do_photinus;
            goto L47
        L46:
            r121 = "leftYaw";
            r122 = R.string.dtf_left_yaw_guide;
            goto L47
        L132:
            f r130 = this.f557093a;
            String r131 = (String) r110.obj;
            r130.getClass();
            if (r131.contains("~_~") == false) goto L135;
            String[] r132 = r131.split("~_~");
            boolean r133 = false;
            String r134 = r132[0];
            String r135 = r132[1];
            r131 = r134;
        L137:
            if (TextUtils.isEmpty(r131) == false) goto L139;
            r131 = "Z1000";
        L139:
            r130.e(r133);
            r130.f557071f.onVerifyEnd();
            boolean r136 = r131.equals("3003");
            if (hs7.a.h().f487000l == false) goto L184;
            if (r136 == true) goto L184;
            h r137 = new h(r130, r131);
            if ("Z1025".equals(r131) == false) goto L145;
        L180:
            r130.k(p.g(r130.f557072g, "dialogNetworkFailedTitle", R.string.dtf_message_box_title_network), p.g(r130.f557072g, "dialogNetworkFailedMsg", R.string.dtf_message_box_message_network), p.g(r130.f557072g, "dialogNetworkFailedConfirm", R.string.dtf_message_box_btn_ok_tip), null, r131, r137);
        L181:
            boolean r138 = true;
        L182:
            if (r138 == true) goto L232;
            r130.i(r131, "");
            goto L232
        L145:
            if ("Z1028".equals(r131) == true) goto L180;
            if ("Z1026".equals(r131) == true) goto L180;
            if ("Z1027".equals(r131) == true) goto L180;
            if ("Z1011".equals(r131) == true) goto L180;
            if ("Z1012".equals(r131) == true) goto L180;
            if ("Z1001".equals(r131) == false) goto L158;
        L179:
            r130.k(p.g(r130.f557072g, "dialogSDKErrTitle", R.string.dtf_message_box_title_sys_error), p.g(r130.f557072g, "dialogSDKErrMsg", R.string.dtf_message_box_message_sys_error), p.g(r130.f557072g, "dialogSDKErrConfirm", R.string.dtf_message_box_btn_ok_tip), null, r131, r137);
            goto L181
        L158:
            if ("Z1013".equals(r131) == true) goto L179;
            if ("Z1023".equals(r131) == true) goto L179;
            if ("Z1020".equals(r131) == false) goto L165;
        L178:
            r130.k(p.g(r130.f557072g, "dialogCamOpenFailedTitle", R.string.dtf_message_box_title_camera_open_fail), p.g(r130.f557072g, "dialogCamOpenFailedMsg", R.string.dtf_message_box_message_reopen), p.g(r130.f557072g, "dialogCamOpenFailedConfirm", R.string.dtf_message_box_btn_ok_tip), null, r131, r137);
            goto L181
        L165:
            if ("Z1021".equals(r131) == true) goto L178;
            if ("Z1004".equals(r131) == false) goto L170;
        L177:
            r130.k(p.g(r130.f557072g, "dialogArchSysFailedTitle", R.string.dtf_message_box_title_not_support), p.g(r130.f557072g, "dialogArchSysFailedMsg", R.string.dtf_message_box_message_not_support), p.g(r130.f557072g, "dialogArchSysFailedConfirm", R.string.dtf_message_box_btn_ok_tip), null, r131, r137);
            goto L181
        L170:
            if ("Z1003".equals(r131) == true) goto L177;
            if ("Z1018".equals(r131) == true) goto L177;
            if ("Z1002".equals(r131) == true) goto L177;
            r138 = false;
        L184:
            r130.i(r131, r135);
            goto L232
        L135:
            r133 = false;
            r135 = "";
            goto L137
        L185:
            f r139 = this.f557093a;
            r139.getClass();
            hs7.a.h().O = "faceLiveness";
            RecordService.getInstance().recordEvent(2, "faceScan", new String[]{"status", "face completed", "scanCost", String.valueOf(System.currentTimeMillis() - r139.f557073h)});
            CameraSurfaceView r140 = r139.f557066a;
            if (r140 == null) goto L188;
            r105 = r140.getCameraInterface();
        L188:
            if (r105 == null) goto L190;
            r105.stopPreview();
        L190:
            r139.f557071f.onCameraPreviewEnd();
            ws7.b r141 = r139.f557078m;
            if (r141 == null) goto L193;
            r141.a();
        L193:
            RecordService.getInstance().recordEvent(2, "uploadFaceImage", new String[]{"status", "start upload face image"});
            r139.f557091z.post(new vs7.a(r139));
            ts7.c.d(new vs7.b(r139));
            goto L232
        L194:
            f r142 = this.f557093a;
            double r143 = r110.arg1;
            double r144 = r110.arg2;
            if (r142.f557066a == null) goto L232;
            r142.f557071f.onCameraSizeChanged(r143, r144);
            r142.f557066a.setBackgroundColor(0);
            goto L232
        L221:
            this.f557093a.f557071f.onPhotinusEnd();
            View r145 = this.f557093a.f557069d;
            if (r145 == null) goto L232;
            r145.setBackgroundColor(0);
            goto L232
        }
    }

    public class c implements IDTUICallBack.MessageBoxCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f557095a;

        @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
        public final void onOK() {
        }

        @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
        public final void onCancel() {
            RecordService.getInstance().recordEvent(2, "userBack", new String[]{"type", "pressCloseButton"});
            this.f557095a.h("Z1046", null);
        }

        public c(f r100) {
            this.f557095a = r100;
        }
    }

    public class d implements IDTFragment.IDTCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f557096a;

        public d(f r100) {
            this.f557096a = r100;
        }

        @Override // com.dtf.face.api.IDTFragment.IDTCallBack
        public final void onElderAudioSwitch(boolean r100) {
            this.f557096a.f557084s = r100;
        }

        @Override // com.dtf.face.api.IDTFragment.IDTCallBack
        public final void onFaceRegionChange(Map<String, Object> r110) {
            JSONObject r100 = new JSONObject();     // Catch: Throwable -> L47
            JSONObject r101 = new JSONObject();     // Catch: Throwable -> L47
            if (r110.containsKey("faceRegion") == false) goto L31;
            r101.put2("faceRegion", JSON.parseArray((String) r110.get("faceRegion")));     // Catch: Throwable -> L47
            int r102 = this.f557096a.f557081p;     // Catch: Throwable -> L47
            if (r102 != 0) goto L9;
            String r103 = ToygerFaceAlgorithmConfig.NO_LIVENESS;
        L28:
            r100.put2(r103, r101);     // Catch: Throwable -> L47
            goto L31
        L9:
            if (r102 != 1) goto L11;
            r103 = ToygerFaceAlgorithmConfig.ZFACE_BLINK_LIVENESS;
            goto L28
        L11:
            if (r102 != 2) goto L13;
            r103 = ToygerFaceAlgorithmConfig.ZFACE_LEFT_LIVENESS;
            goto L28
        L13:
            if (r102 != 3) goto L16;
            r103 = ToygerFaceAlgorithmConfig.ZFACE_RIGHT_LIVENESS;
            goto L28
        L16:
            if (r102 != 5) goto L19;
            r103 = ToygerFaceAlgorithmConfig.ZFACE_LIPMOVEMENT_LIVENESS;
            goto L28
        L19:
            if (r102 != 6) goto L22;
            r103 = ToygerFaceAlgorithmConfig.ZFACE_PHOTINUS_LIVENESS;
            goto L28
        L22:
            if (r102 != 7) goto L25;
            r103 = ToygerFaceAlgorithmConfig.ZFACE_NEARFAR_LIVENESS;
            goto L28
        L25:
            if (r102 != 8) goto L27;
            r103 = ToygerFaceAlgorithmConfig.ZFACE_EQUIPMENT_LIVENESS;
            goto L28
        L27:
            r103 = "";
        L31:
            if (r110.containsKey("eleRegion") == false) goto L39;
            JSONObject r111 = JSON.parseObject((String) r110.get("eleRegion"));     // Catch: Throwable -> L47
            if (r111 == null) goto L38;
            ((HashMap) this.f557096a.f557083r).put(q.KEY_FACE_AREA, r111);     // Catch: Throwable -> L47
            hs7.b r112 = hs7.b.D;     // Catch: Throwable -> L47
            Map<String, Object> r104 = this.f557096a.f557083r;     // Catch: Throwable -> L47
            r112.getClass();     // Catch: Throwable -> L47
            if (r104 == null) goto L37;
            RecordService.getInstance().recordEvent(2, "toygerConfigUpdate", new String[]{"msg", JSON.toJSONString(r104)});     // Catch: Throwable -> L47
            ((HashMap) r112.f487030m).putAll(r104);     // Catch: Throwable -> L47
            r112.f487028k = false;     // Catch: Throwable -> L47
        L37:
            r100.put2(ToygerFaceAlgorithmConfig.ZFACE_EQUIPMENT_LIVENESS, r101);     // Catch: Throwable -> L47
            goto L39
        L38:
            return;
        L39:
            hs7.b r113 = hs7.b.D;     // Catch: Throwable -> L47
            String r105 = r100.toJSONString();     // Catch: Throwable -> L47
            ToygerFaceService r114 = r113.f487019b;     // Catch: Throwable -> L47
            if (r114 != null) goto L51;
        L43:
            RecordService r115 = RecordService.getInstance();     // Catch: Throwable -> L47
            r115.recordEvent(2, "updateFaceCaptureRegion", new String[]{"msg", r100.toJSONString()});     // Catch: Throwable -> L47
            return;
        L51:
            r114.updateNativeState(102, r105);     // Catch: Exception -> L50 Throwable -> L47
        L47:
            th = move-exception;
            RecordService.getInstance().recordEvent(3, "updateFaceCaptureRegionError", new String[]{"errMsg", RecordService.getStackTraceString(th)});
        }
    }

    public class e implements IDTUICallBack.MessageBoxCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDTUICallBack.MessageBoxCallBack f557097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f557098b;

        @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
        public final void onCancel() {
            this.f557098b.f(false);
            IDTUICallBack.MessageBoxCallBack r100 = this.f557097a;
            if (r100 == null) goto L6;
            r100.onCancel();
            return;
        }

        @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
        public final void onOK() {
            this.f557098b.f(false);
            IDTUICallBack.MessageBoxCallBack r100 = this.f557097a;
            if (r100 == null) goto L6;
            r100.onOK();
            return;
        }

        public e(f r100, IDTUICallBack.MessageBoxCallBack r101) {
            this.f557098b = r100;
            this.f557097a = r101;
        }
    }

    /* JADX INFO: renamed from: vs7.f$f, reason: collision with other inner class name */
    public class C8039f implements IDTUICallBack.MessageBoxCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f557099a;

        @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
        public final void onCancel() {
        }

        @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
        public final void onOK() {
            RecordService.getInstance().recordEvent(2, "faceScan", new String[]{"status", "time out, not success"});
            this.f557099a.h("Z1006", null);
        }

        public C8039f(f r100) {
            this.f557099a = r100;
        }
    }

    public class g implements ws7.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f557100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f557101b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f557102a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f557103b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f557103b.a(this.f557102a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(g r100, int r101) {
                this.f557103b = r100;
                this.f557102a = r101;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f557104a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f557104a.b();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(g r100) {
                this.f557104a = r100;
            }
        }

        public class c implements IDTUICallBack.MessageBoxCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f557105a;

            @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
            public final void onOK() {
                f r100 = this.f557105a.f557101b;
                if (r100.f557076k != 1) goto L14;
                CameraSurfaceView r101 = r100.f557066a;
                if (r101 == null) goto L14;
                is7.e r102 = r101.getCameraInterface();
                if (r102 == null) goto L14;
                if (r102.getCamera() == null) goto L14;
                r102.getCamera().startPreview();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                RecordService.getInstance().recordEvent(4, "cameraException", new String[]{"errMsg", RecordService.getStackTraceString(th)});
            L14:
                r100.f557076k = 0;
                SgomInfoManager.updateToken();
                RecordService.getInstance().recordEvent(2, "faceScan", new String[]{"status", "time out, user retry:" + r100.f557077l});
                r100.f557077l = r100.f557077l + 1;
                hs7.d.f487062i.b();
                hs7.b r103 = hs7.b.D;
                int r104 = r100.f557077l;
                ToygerFaceService r105 = r103.f487019b;
                if (r105 != null) goto L20;
            L17:
                r100.f557071f.onRetry(r100.f557077l);
                r100.f557091z.sendEmptyMessage(910);
                r100.f557081p = -1;
                ((HashMap) r100.f557090y).clear();
                return;
            L20:
                r103.f487021d = r104;     // Catch: Exception -> L19
                r105.updateNativeState(107, String.valueOf(r104));     // Catch: Exception -> L19
                goto L17
            }

            @Override // com.dtf.face.api.IDTUICallBack.MessageBoxCallBack
            public final void onCancel() {
                RecordService.getInstance().recordEvent(2, "faceScan", new String[]{"status", "time out, user back"});
                this.f557105a.f557101b.h("Z1005", null);
            }

            public c(g r100) {
                this.f557105a = r100;
            }
        }

        public final void b() {
            if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
            this.f557101b.f557091z.post(new b(this));
            return;
        L6:
            hs7.b r100 = hs7.b.D;
            ToygerFaceService r101 = r100.f487019b;
            if (r101 == null) goto L9;
            r101.updateNativeState(108, "");
        L9:
            this.f557101b.c(false);
            RecordService.getInstance().recordEvent(2, "faceScanFailed", new String[]{RecordConst.LOG_ERR_TYPE, "timeOut", "msg", hs7.d.f487062i.c()});
            if (this.f557101b.d() == false) goto L16;
            hs7.b.f(r100.f487033p);
            String r102 = p.g(this.f557101b.f557072g, "dialogTimeOutTitle", R.string.dtf_message_box_title_retry_face_scan);
            f r103 = this.f557101b;
            if (r103.f557076k == 0) goto L14;
            r102 = p.g(r103.f557072g, "dialogInterruptTitle", R.string.dtf_message_box_title_operation_fail);
        L14:
            MemoryService.getInstance().trigger("Z1005");
            f r104 = this.f557101b;
            r104.k(r102, p.g(r104.f557072g, "dialogTimeOutMsg", R.string.dtf_message_box_message_retry_face_scan), p.g(this.f557101b.f557072g, "dialogTimeOutConfirm", R.string.dtf_message_box_btn_retry_ok), null, "Z1005", new c(this));
            return;
        }

        public final void a(int r100) {
            if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
            this.f557101b.f557091z.post(new a(this, r100));
            return;
        L6:
            this.f557101b.f557071f.onTimeChanged(r100, this.f557100a);
        }

        public g(f r100, int r101) {
            this.f557101b = r100;
            this.f557100a = r101;
        }
    }

    @Override // vs7.i
    public final void onActivityResult() {
    }

    @Override // vs7.i
    public final void onStart() {
    }

    @Override // vs7.i
    public final void onStop() {
        this.f557076k = 2;
        this.f557071f.hideMessageBox();
        j(true, false);
    }

    public final boolean d() {
        hs7.b r100 = hs7.b.D;
        WorkState r101 = r100.f487025h;
        if (WorkState.FACE_COMPLETED != r101) goto L5;
        return false;
    L5:
        AndroidClientConfig r102 = hs7.a.h().c();
        if (r102 != null) goto L8;
    L10:
        int r103 = 4;
    L12:
        if (this.f557077l < r103) goto L15;
        hs7.b.f(r100.f487033p);
        MemoryService.getInstance().trigger("Z1006");
        k(p.g(this.f557072g, "dialogTooManyRetriesTitle", R.string.dtf_message_box_title_retry_face_scan_time_out), p.g(this.f557072g, "dialogTooManyRetriesMsg", R.string.dtf_message_box_message_retry_face_scan_time_out), p.g(this.f557072g, "dialogTooManyRetriesConfirm", R.string.dtf_message_box_message_btn_retry_ok_time_out), null, "Z1006", new C8039f(this));
        return false;
    L15:
        return true;
    L8:
        if (r102.getColl() == null) goto L10;
        r103 = r102.getColl().retry;
        goto L12
    }

    public final void g() {
        this.f557089x = 0;
        AndroidClientConfig r100 = hs7.a.h().c();
        if (r100 != null) goto L5;
    L9:
        int r101 = 20;
    L10:
        this.f557078m = new ws7.b(r101, new g(this, r101));
        return;
    L5:
        if (r100.getColl() == null) goto L9;
        r101 = r100.getColl().time;
        if (r101 <= 0) goto L9;
        goto L9
    }

    @Override // vs7.i
    public final void onDestroy() {
        ws7.b r100 = this.f557078m;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        hs7.b r101 = hs7.b.D;
        ToygerFaceService r102 = r101.f487019b;
        if (r102 != null) goto L46;
    L8:
        hs7.b.f(r101.f487033p);
        hs7.b.f(r101.f487034q);
        monitor-enter(r101);
        Handler r103 = r101.f487023f;     // Catch: Throwable -> L42
        if (r103 == null) goto L13;
        r103.removeCallbacks(null);     // Catch: Throwable -> L42
        r103.removeMessages(0);     // Catch: Throwable -> L42
        r101.f487023f = null;     // Catch: Throwable -> L42
    L13:
        monitor-exit(r101);
        r101.f487018a = null;
        r101.f487019b = null;
        r101.B = false;
        r101.f487038u = true;
        faceverify.d r104 = r101.f487022e;
        Bitmap r105 = r104.f476093b;
        if (r105 != null) goto L17;
    L19:
        r104.f476093b = null;
        r104.f476100i = "";
        r104.f476101j = null;
        r104.f476102k = null;
        r104.f476096e = null;
        r104.f476099h = null;
        r104.f476105n = null;
        r104.f476104m = null;
        r104.f476094c = null;
        r104.f476098g = null;
        l r106 = r101.A;
        if (r106 == null) goto L52;
        r106.c();
        r101.A = null;
    L52:
        ps7.d r107 = r101.f487042y;     // Catch: Throwable -> L26
        if (r107 == null) goto L28;
        r107.c();     // Catch: Throwable -> L26
    L28:
        r101.f487022e = new faceverify.d();
        faceverify.h r108 = r101.f487020c;
        if (r108 != null) goto L31;
    L40:
        r101.f487032o = null;
        ts7.c.d(new faceverify.a(r101));
        os7.a.f526516l.b();
        String r109 = Long.toString(System.currentTimeMillis() - this.f557074i);
        RecordService.getInstance().recordEvent(2, "destroyToygerActivity", new String[]{"timeCost", r109});
        this.f557091z.removeCallbacks(null);
        this.f557091z.removeMessages(0);
        return;
    L31:
        if (r108.f476134m == true) goto L36;
        monitor-enter(r108);
        r108.f476134m = true;     // Catch: Throwable -> L37
        monitor-exit(r108);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L36:
        r101.f487020c = null;
    L26:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L28
    L17:
        if (r105.isRecycled() == true) goto L19;
        r104.f476093b.recycle();
        r104.f476093b = null;
    L42:
        th = move-exception;
        throw th;
    L46:
        r102.release();     // Catch: Exception -> L45
        goto L8
    }

    @Override // vs7.i
    public final void onResume() {
        if (this.f557076k != 2) goto L6;
        RecordService.getInstance().recordEvent(2, "userBack", new String[]{"type", "pressBackClose", "msg", hs7.d.f487062i.c()});
        h("Z1008", null);
        return;
    }

    public f() {
        this.f557073h = System.currentTimeMillis();
        this.f557074i = System.currentTimeMillis();
        this.f557076k = 0;
        this.f557077l = 0;
        this.f557080o = -1;
        this.f557081p = -1;
        this.f557082q = false;
        this.f557083r = new HashMap();
        this.f557084s = false;
        this.f557085t = -1;
        this.f557087v = new a(this);
        this.f557088w = 0;
        this.f557089x = 0;
        this.f557090y = new HashMap();
        this.f557091z = new Handler(new b(this));
        this.A = null;
    }

    @Override // vs7.i
    public final void onBackPressed() {
        this.f557089x = System.currentTimeMillis();
        if (this.f557071f.onBackPressed() == false) goto L6;
        return;
    L6:
        if (this.f557071f.hasShowMessageBox() == false) goto L9;
        return;
    L9:
        if (this.f557079n != null) goto L11;
        this.f557079n = new vs7.g(this);
    L11:
        this.f557079n.onClose();
    }

    @Override // vs7.i
    public final void onPause() {
        this.f557089x = System.currentTimeMillis();
        WorkState r100 = hs7.b.D.f487025h;
        if (this.f557076k != 2) goto L5;
        return;
    L5:
        if (WorkState.RET != r100) goto L7;
        return;
    L7:
        if (WorkState.FACE_COMPLETED != r100) goto L9;
        return;
    L9:
        if (WorkState.PHOTINUS == r100) goto L41;
        boolean r101 = !ClientConfigUtil.e("HIDE_INTERRUPT_DIALOG");
        if (r101 == false) goto L27;
        CameraSurfaceView r102 = this.f557066a;
        if (r102 == null) goto L23;
        is7.e r103 = r102.getCameraInterface();
        if (r103 == null) goto L23;
        if (r103.getCamera() == null) goto L23;
        r103.stopCamera();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "cameraException", new String[]{"errMsg", RecordService.getStackTraceString(th)});
    L23:
        ws7.b r104 = this.f557078m;
        if (r104 == null) goto L27;
        r104.a();
    L27:
        if (d() == false) goto L32;
        RecordService.getInstance().recordEvent(3, MessageIndication.STATUS_INTERRUPT, new String[]{"msg", MessageIndication.STATUS_INTERRUPT});
        if (r101 == false) goto L31;
        k(p.g(this.f557072g, "dialogInterruptTitle", R.string.dtf_message_box_title_operation_fail), "", null, p.g(this.f557072g, "dialogInterruptCancel", R.string.dtf_message_box_btn_retry_exit), "Z1046", new c(this));
        goto L32
    L31:
        RecordService.getInstance().recordEvent(3, MessageIndication.STATUS_INTERRUPT, new String[]{"msg", "hideInterruptDialog"});
    L32:
        if (r101 == false) goto L40;
        this.f557076k = 1;
        return;
    L40:
        return;
    }

    public final void c(boolean r110) {
        String r100 = faceverify.f.a(this.f557081p);
        if ("null".equals(r100) == true) goto L5;
        long r101 = System.currentTimeMillis() - this.f557088w;
        RecordService r102 = RecordService.getInstance();
        String[] r103 = new String[6];
        r103[0] = "name";
        r103[1] = r100;
        r103[2] = ChameleonOpenTracker.ParamKey.COST;
        r103[3] = String.valueOf(r101);
        r103[4] = "type";
        if (r110 == false) goto L10;
        String r111 = "success";
    L11:
        r103[5] = r111;
        r102.recordEvent(2, "actionEnd", r103);
        ((HashMap) this.f557090y).put(r100, Long.valueOf(r101));
    L12:
        this.f557088w = System.currentTimeMillis();
        return;
    L10:
        r111 = "fail";
        goto L11
    L5:
        if ((-1) == this.f557081p) goto L12;
        RecordService.getInstance().recordEvent(3, "costActionCodeErr", new String[]{"currentActionCode", String.valueOf(this.f557081p)});
        goto L12
    }

    public final void e(boolean r110) {
        HashMap r100 = new HashMap();
        Map<String, Long> r101 = this.f557090y;
        monitor-enter(r101);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (((HashMap) this.f557090y).containsKey("total") == false) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L37
        return;
    L9:
        if (0 != this.f557089x) goto L11;
        this.f557089x = System.currentTimeMillis();     // Catch: Throwable -> L37
    L11:
        long r102 = this.f557089x - this.f557074i;     // Catch: Throwable -> L37
        ((HashMap) this.f557090y).put("total", Long.valueOf(r102));     // Catch: Throwable -> L37
        String r103 = faceverify.f.a(this.f557081p);     // Catch: Throwable -> L37
        if (this.f557081p != 0) goto L18;
        if (this.f557082q == false) goto L18;
    L28:
        String r111 = JSON.toJSONString(this.f557090y);     // Catch: Throwable -> L37
        r100.put("verifyCost", r111);     // Catch: Throwable -> L37
        RecordService r104 = RecordService.getInstance();     // Catch: Throwable -> L37
        r104.recordEvent(2, "actionCost", new String[]{ChameleonOpenTracker.ParamKey.COST, r111});     // Catch: Throwable -> L37
        monitor-exit(r101);     // Catch: Throwable -> L37
        if (hs7.c.a().f487061g != null) goto L35;
        hs7.c.a().f487061g = new HashMap();
    L35:
        hs7.c.a().f487061g.putAll(r100);
        return;
    L18:
        if (((HashMap) this.f557090y).containsKey(r103) == true) goto L20;
        ((HashMap) this.f557090y).put(r103, Long.valueOf(r102));     // Catch: Throwable -> L37
    L20:
        RecordService r105 = RecordService.getInstance();     // Catch: Throwable -> L37
        String[] r112 = new String[6];     // Catch: Throwable -> L37
        r112[0] = "name";     // Catch: Throwable -> L37
        r112[1] = r103;     // Catch: Throwable -> L37
        r112[2] = ChameleonOpenTracker.ParamKey.COST;     // Catch: Throwable -> L37
        r112[3] = String.valueOf(r102);     // Catch: Throwable -> L37
        r112[4] = "type";     // Catch: Throwable -> L37
        if (r110 == false) goto L25;
        String r113 = "success";
    L27:
        r112[5] = r113;     // Catch: Throwable -> L37
        r105.recordEvent(2, "actionEnd", r112);     // Catch: Throwable -> L37
        goto L28
    L25:
        r113 = "fail";
        goto L27
    }

    public final void f(boolean r100) {
        if (r100 == true) goto L5;
    L10:
        if (r100 == false) goto L15;
        ws7.b r101 = this.f557078m;
        if (r101 == null) goto L14;
        r101.f561061e.removeMessages(0);
        r101.f561061e.removeCallbacks(null);
    L14:
        hs7.b r102 = hs7.b.D;
        WorkState r103 = WorkState.PAUSE;
        WorkState r104 = r102.f487025h;
        r102.f487025h = r103;
        this.A = r104;
        return;
    L15:
        ws7.b r105 = this.f557078m;
        if (r105 == null) goto L18;
        r105.handleMessage(r105.f561061e.obtainMessage());
    L18:
        hs7.b r106 = hs7.b.D;
        WorkState r107 = this.A;
        WorkState r108 = r106.f487025h;
        r106.f487025h = r107;
        return;
    L5:
        if (hs7.b.D.f487025h != WorkState.PAUSE) goto L10;
        ws7.b r109 = this.f557078m;
        if (r109 == null) goto L20;
        r109.f561061e.removeMessages(0);
        r109.f561061e.removeCallbacks(null);
        return;
    }

    @Override // vs7.i
    public final void a(IDTFragment r100, Activity r110) {
        this.f557071f = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f557072g = r110;
        vs7.g r111 = new vs7.g(this);
        this.f557079n = r111;
        r100.setCloseCallBack(r111);
        this.f557071f.setDTCallBack(new d(this));
        this.f557071f.onUILoadSuccess();
        if (this.f557076k == 2) goto L125;
        RecordService.getInstance().recordEvent(2, "faceScan", new String[]{"status", "start preview"});
        SgomInfoManager.updateSgomInfo(-11706411, null);
        hs7.b r101 = hs7.b.D;
        if (r101 != null) goto L11;
        return;
    L11:
        if (this.f557066a != null) goto L17;
        FrameLayout r102 = this.f557071f.getCameraContainer();
        this.f557068c = r102;
        if (r102 == null) goto L17;
        r102.setVisibility(0);
        this.f557066a = new CameraSurfaceView(this.f557072g, null);
        ImageView r103 = new ImageView(this.f557072g, null);
        this.f557067b = r103;
        r103.setBackgroundColor(-1);
        this.f557067b.setVisibility(0);
        this.f557067b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f557068c.addView(this.f557066a, new FrameLayout.LayoutParams(-1, -1));
        this.f557068c.addView(this.f557067b, new FrameLayout.LayoutParams(-1, -1));
    L17:
        int r104 = this.f557076k;
        boolean r105 = true;
        if (r104 == 2) goto L22;
        if (r104 == (-1)) goto L22;
        boolean r106 = false;
    L23:
        j(r106, false);
        CameraSurfaceView r107 = this.f557066a;
        if (r107 == null) goto L29;
        r107.setVisibility(0);
        is7.a.f495624a = 640;
        CameraSurfaceView r108 = this.f557066a;
        Activity r109 = this.f557072g;
        r108.getClass();
        r108.f273636d = new DeviceSetting();
        is7.e r112 = CameraSurfaceView.getCameraImpl();
        CameraSurfaceView.f273632e = r112;
        if (r112 == null) goto L28;
        r112.initCamera(r109, true, true, r108.f273636d);
    L28:
        this.f557066a.setCameraCallback(r101);
    L29:
        this.f557071f.onCameraPreviewBegin(0);
        CameraSurfaceView r113 = this.f557066a;
        if (r113 == null) goto L119;
        Context r114 = this.f557072g;
        Handler r115 = this.f557091z;
        is7.e r116 = r113.getCameraInterface();
        if (r114 == null) goto L34;
        r114 = r114.getApplicationContext();
    L34:
        faceverify.d r117 = r101.f487022e;
        r117.f476093b = null;
        r117.f476100i = "";
        r101.f487025h = WorkState.INIT;
        r101.f487027j = new AtomicBoolean(false);
        r101.f487029l = false;
        r101.f487041x = true;
        r101.f487021d = 0;
        hs7.b.f(r101.f487033p);
        hs7.b.f(r101.f487034q);
        r101.f487023f = r115;
        r101.f487018a = r116;
        r101.f487038u = false;
        ToygerFaceService r118 = new ToygerFaceService();
        r101.f487019b = r118;
        if (r118.init(r114, false, r101) == false) goto L53;
        AndroidClientConfig r119 = hs7.a.h().c();
        if (r119 == null) goto L46;
        Upload r120 = r119.getUpload();
        if (r120 == null) goto L43;
        r101.f487041x = r120.photinusVideo;
        hs7.a r121 = hs7.a.h();
        r121.f486996h = r120.chameleonFrameEnable;
    L43:
        if (hs7.a.h().l() == false) goto L46;
        r101.f487028k = true;
    L46:
        if (r101.f487041x == false) goto L49;
        r101.f487042y = new ps7.d(r114);
    L49:
        if (hs7.a.h().f486996h == false) goto L51;
        r101.A = new l();
    L51:
        if (r119 != null) goto L54;
        RecordService.getInstance().recordEvent(4, "ClientConfigError", new String[]{"status", "ClientCfg null"});
        goto L53
    L54:
        hs7.a r122 = hs7.a.h();
        if (r122.D == false) goto L57;
    L60:
        boolean r123 = true;
    L61:
        monitor-enter(r101);
        r101.f487031n = r123;     // Catch: Throwable -> L116
        if (r123 == false) goto L73;
        CopyOnWriteArrayList<is7.b> r124 = r101.f487033p;     // Catch: Throwable -> L116
        if (r124 != null) goto L67;
        r101.f487033p = new CopyOnWriteArrayList();     // Catch: Throwable -> L116
    L68:
        CopyOnWriteArrayList<is7.b> r125 = r101.f487034q;     // Catch: Throwable -> L116
        if (r125 != null) goto L71;
        r101.f487034q = new CopyOnWriteArrayList();     // Catch: Throwable -> L116
    L72:
        r101.f487036s = 0;     // Catch: Throwable -> L116
        r101.f487037t = false;     // Catch: Throwable -> L116
        hs7.b.f(r101.f487034q);     // Catch: Throwable -> L116
        goto L73
    L71:
        hs7.b.f(r125);     // Catch: Throwable -> L116
        goto L72
    L67:
        hs7.b.f(r124);     // Catch: Throwable -> L116
    L73:
        monitor-exit(r101);
        AndroidClientConfig r126 = hs7.a.h().c();
        if (r126 == null) goto L81;
        Coll r127 = r126.getColl();
        if (r127 == null) goto L81;
        int r128 = r127.getCaptureFrameLimit();
        if (r128 <= 0) goto L81;
        int r129 = Math.max(r128, 10);
    L82:
        r101.f487035r = r129;
        File r130 = ws7.o.d(hs7.a.h().getContext(), null, true);
        if (r130 == null) goto L87;
        byte[] r131 = ws7.i.h(r130.getAbsolutePath());
        if (r131 == null) goto L87;
        ((HashMap) r101.f487030m).put(q.ASSET_FACE_HIGH, r131);
    L87:
        File r132 = ws7.o.d(hs7.a.h().getContext(), "fd4ddd72c85fd5fe2913be520df32ed0", false);
        if (r132 == null) goto L92;
        byte[] r133 = ws7.i.h(r132.getAbsolutePath());
        if (r133 == null) goto L92;
        ((HashMap) r101.f487030m).put(q.ASSET_FACE, r133);
    L92:
        File r134 = ws7.o.d(hs7.a.h().getContext(), "e047462a83518c799c4082850d19c250", false);
        if (r134 == null) goto L97;
        byte[] r135 = ws7.i.h(r134.getAbsolutePath());
        if (r135 == null) goto L97;
        ((HashMap) r101.f487030m).put(q.ASSET_QUALITY, r135);
    L97:
        ((HashMap) r101.f487030m).put("porting", "JRCloud");
        Map<String, Object> r136 = r101.f487030m;
        HashMap r137 = (HashMap) r136;
        r137.put(q.KEY_PUBLIC_KEY, ws7.i.g(hs7.a.h().getContext()));
        Map<String, Object> r138 = r101.f487030m;
        HashMap r139 = (HashMap) r138;
        r139.put(q.KEY_META_SERIALIZER, Integer.toString(1));
        Map<String, Object> r140 = r101.f487030m;
        HashMap r141 = (HashMap) r140;
        r141.put(q.KEY_PHOTINUS_CONFIG, Boolean.valueOf(r101.f487041x));
        Map<String, Object> r142 = r101.f487030m;
        hs7.a r143 = hs7.a.h();
        if (r143.D == false) goto L100;
    L103:
        boolean r144 = true;
    L104:
        HashMap r145 = (HashMap) r142;
        r145.put(q.KEY_ENABLE_VIDEO_CAPTURE_CONFIG, Boolean.valueOf(r144));
        Map<String, Object> r146 = r101.f487030m;
        HashMap r147 = (HashMap) r146;
        r147.put(q.KEY_LOCAL_MATCHING_COMMAND, r119.getVerifyMode());
        Map<String, Object> r148 = r101.f487030m;
        if (r119.getAlgorithm() == null) goto L107;
        Object r149 = r119.getAlgorithm();
    L108:
        ((HashMap) r148).put(q.KEY_ALGORITHM_CONFIG, r149);
        Map<String, Object> r150 = r101.f487030m;
        if (r119.getUpload() == null) goto L111;
        Object r151 = r119.getUpload();
    L112:
        ((HashMap) r150).put("upload", r151);
        r101.f487025h = WorkState.FACE_CAPTURING;
    L113:
        if (r105 == false) goto L119;
        RecordService.getInstance().recordEvent(2, "faceScan", new String[]{"status", "faceScan init Success"});
        this.f557077l = 0;
        this.f557073h = System.currentTimeMillis();
        g();
        return;
    L111:
        r151 = "";
        goto L112
    L107:
        r149 = "";
        goto L108
    L100:
        if (r143.E == true) goto L103;
        r144 = false;
    L81:
        r129 = 30;
    L116:
        th = move-exception;
        throw th;
    L57:
        if (r122.E == true) goto L60;
        r123 = false;
    L53:
        r105 = false;
    L119:
        RecordService.getInstance().recordEvent(2, "faceScan", new String[]{"status", "init toyger presenter fail"});
        h("Z1001", null);
        return;
    L22:
        r106 = true;
        goto L23
    }

    @Override // vs7.i
    public final void b(IDTFragment r100, Activity r101) {
        this.f557071f = r100;
        this.f557072g = r101;
        this.f557076k = -1;
        String r102 = hs7.a.h().f486989a;
        this.f557075j = new qs7.a();
    }

    public final void h(String r100, String r101) {
        Message r102 = Message.obtain();
        r102.what = 903;
        if (r101 == null) goto L5;
        r100 = r100 + "~_~" + r101;
    L5:
        r102.obj = r100;
        this.f557091z.sendMessage(r102);
    }

    public final void i(String r100, String r101) {
        if (hs7.c.a().f487060f != null) goto L9;
        hs7.c r102 = hs7.c.a();
        hs7.d r103 = hs7.d.f487062i;
        Bitmap r104 = r103.a(r103.f487063a, r103.f487064b, r103.f487065c, r103.f487066d);
        if (r104 == null) goto L7;
        byte[] r105 = ws7.i.c(r104);
    L8:
        r102.f487060f = r105;
        goto L9
    L7:
        r105 = null;
    L9:
        hs7.d r106 = hs7.d.f487062i;
        r106.f487063a = null;
        Bitmap r107 = r106.f487067e;     // Catch: Throwable -> L18
        if (r107 != null) goto L13;
    L15:
        r106.f487067e = null;     // Catch: Throwable -> L18
        goto L16
    L13:
        if (r107.isRecycled() == true) goto L15;
        r106.f487067e.recycle();     // Catch: Throwable -> L18
    L16:
        RecordService.getInstance().recordEvent(2, "ToygerActivityClose", new String[]{"errCode", r100});
        hs7.b.D.getClass();
        hs7.b.e(r100, r101);
        this.f557072g.finish();
    }

    public final void j(boolean r100, boolean r101) {
        ImageView r102 = this.f557067b;
        if (r102 == null) goto L24;
        if (r100 == true) goto L7;
        r102.setVisibility(8);
        return;
    L7:
        if (r102.getVisibility() != 0) goto L9;
        return;
    L9:
        this.f557067b.setVisibility(0);
        hs7.d r103 = hs7.d.f487062i;
        Bitmap r104 = r103.a(r103.f487063a, r103.f487064b, r103.f487065c, r103.f487066d);
        if (r101 == false) goto L19;
        Bitmap r105 = null;
        if (r104 != null) goto L22;
    L17:
        if (r105 == null) goto L26;
        this.f557067b.setImageBitmap(r105);
        return;
    L26:
        return;
    L22:
        Bitmap r106 = Bitmap.createBitmap((int) (r104.getWidth() / 6.0f), (int) (r104.getHeight() / 6.0f), Bitmap.Config.ARGB_4444);     // Catch: OutOfMemoryError -> L16
        Canvas r107 = new Canvas(r106);     // Catch: OutOfMemoryError -> L16
        r107.scale(0.16666667f, 0.16666667f);     // Catch: OutOfMemoryError -> L16
        Paint r108 = new Paint();     // Catch: OutOfMemoryError -> L16
        r108.setFlags(2);     // Catch: OutOfMemoryError -> L16
        r107.drawBitmap(r104, 0.0f, 0.0f, r108);     // Catch: OutOfMemoryError -> L16
        r105 = faceverify.f.a(r106, 1, true);     // Catch: OutOfMemoryError -> L16
        goto L17
    L19:
        if (r104 == null) goto L28;
        this.f557067b.setImageBitmap(Bitmap.createBitmap(r104));
        return;
    L28:
        return;
    }

    public final boolean k(String r110, String r111, String r112, String r113, String r114, IDTUICallBack.MessageBoxCallBack r115) {
        if (this.f557084s == false) goto L6;
        m.b();
    L6:
        if (this.f557071f.hasShowMessageBox() == false) goto L9;
        return false;
    L9:
        if (this.f557071f.onMessageBoxShow(r110, r111, r112, r113, r114, new e(this, r115)) == false) goto L12;
        f(true);
        return true;
    L12:
        return false;
    }
}
