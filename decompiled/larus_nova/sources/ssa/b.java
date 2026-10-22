package ssa;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.camera.core.RetryPolicy;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.bytedcert.callback.VerifyCallBack;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.cvlibrary.FaceLiveness;
import com.ss.android.bytedcert.dialog.FaceLiveDialog;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.flow.face.FaceDetectFlow;
import com.ss.android.bytedcert.manager.AutoTestManager;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.model.LiveInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends lsa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FaceLiveness f543431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f543432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f543433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FaceLiveDialog f543434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VerifyCallBack f543435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f543436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f543437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f543438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f543439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f543440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ksa.e f543441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f543442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f543443m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f543444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Runnable f543445o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public i f543446p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f543447q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f543448r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f543449s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FaceDetectFlow f543450t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f543451u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f543452v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String[] f543453w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<Integer> f543454x;

    public class a implements ksa.a.InterfaceC6605a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543455a;

        /* JADX INFO: renamed from: ssa.b$a$a, reason: collision with other inner class name */
        public class RunnableC7645a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f543456a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f543456a.f543455a.n();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC7645a(a r100) {
                this.f543456a = r100;
            }
        }

        /* JADX INFO: renamed from: ssa.b$a$b, reason: collision with other inner class name */
        public class RunnableC7646b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f543457a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f543457a.f543455a.f543437g = false;     // Catch: Throwable -> L4
                this.f543457a.f543455a.f543438h = 3;     // Catch: Throwable -> L4
                this.f543457a.f543455a.o(true);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC7646b(a r100) {
                this.f543457a = r100;
            }
        }

        @Override // ksa.a.InterfaceC6605a
        public final void onPrepared() {
            this.f543455a.f543436f.postDelayed(new RunnableC7645a(this), 1000);
            b r100 = this.f543455a;
            RunnableC7646b r101 = new RunnableC7646b(this);
            r100.f543445o = r101;
            r100.f543436f.postDelayed(r101, RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
            this.f543455a.f543438h = 2;
        }

        @Override // ksa.a.InterfaceC6605a
        public final void onStopped() {
            b r100 = this.f543455a;
            if (r100.f543439i == false) goto L8;
            nsa.a r101 = r100.f543450t.getFaceLiveManager();
            String r102 = r100.f543442l;
            r101.f520424c = r102;
            if (((Boolean) rsa.d.l(r102).first).booleanValue() == false) goto L7;
            r100.f543435e.doUploadVideo(r100.f543442l, 3);
        L9:
            this.f543455a.f543438h = 0;
            return;
        L7:
            r100.f543436f.postDelayed(new ssa.d(r100), 1000);
            goto L9
        L8:
            rsa.d.g(r100.f543442l);
            goto L9
        }

        public a(b r100) {
            this.f543455a = r100;
        }
    }

    /* JADX INFO: renamed from: ssa.b$b, reason: collision with other inner class name */
    public class RunnableC7647b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f543458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f543459b;

        @Override // java.lang.Runnable
        public final void run() {
            ksa.e r100 = this.f543459b.f543441k;     // Catch: Throwable -> L4
            byte[] r101 = this.f543458a;     // Catch: Throwable -> L4
            r100.b(r101, r101.length, System.nanoTime() / 1000);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC7647b(b r100, byte[] r101) {
            this.f543459b = r100;
            this.f543458a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543460a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f543460a.f543437g = true;     // Catch: Throwable -> L4
            this.f543460a.o(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(b r100) {
            this.f543460a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543461a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f543461a.f543437g = false;     // Catch: Throwable -> L4
            String r100 = this.f543461a.c(2);     // Catch: Throwable -> L4
            String r101 = this.f543461a.l();     // Catch: Throwable -> L4
            b r102 = this.f543461a;     // Catch: Throwable -> L4
            r102.f543434d.showDialog((Activity) r102.f543433c, r100, r101, 2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(b r100) {
            this.f543461a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543462a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f543462a.f543437g = false;     // Catch: Throwable -> L4
            String r100 = this.f543462a.c(2);     // Catch: Throwable -> L4
            String r101 = this.f543462a.l();     // Catch: Throwable -> L4
            b r102 = this.f543462a;     // Catch: Throwable -> L4
            r102.f543434d.showDialog((Activity) r102.f543433c, r100, r101, 2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(b r100) {
            this.f543462a = r100;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543463a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f543463a;     // Catch: Throwable -> L6
            TextView r101 = r100.f543451u;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.setText(r100.f543452v);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public f(b r100) {
            this.f543463a = r100;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f543464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f543465b;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f543465b;     // Catch: Throwable -> L4
            r100.f543439i = this.f543464a;     // Catch: Throwable -> L4
            r100.f543441k.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(b r100, boolean r101) {
            this.f543465b = r100;
            this.f543464a = r101;
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543466a;

        public final void a() {
            b r100 = this.f543466a;
            String r101 = r100.f543447q.substring(0, r100.f543448r + 1);
            b r102 = this.f543466a;
            int r103 = r102.f543447q.length();
            r102.getClass();
            StringBuilder r104 = new StringBuilder();
            int r105 = 0;
        L3:
            if (r105 >= r103) goto L12;
            if (r105 >= r101.length()) goto L7;
            r104.append(r101.charAt(r105));
        L9:
            if (r105 == (r103 - 1)) goto L11;
            r104.append(" ");
        L11:
            r105 = r105 + 1;
            goto L3
        L7:
            r104.append("·");
            goto L9
        L12:
            this.f543466a.f543436f.setText(r104.toString());
            this.f543466a.f543436f.setVisibility(0);
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

        public h(b r100) {
            this.f543466a = r100;
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f543467a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f543467a;     // Catch: Throwable -> L4
            r100.f543448r++;     // Catch: Throwable -> L4
            r100.n();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public i(b r100) {
            this.f543467a = r100;
        }
    }

    @Override // lsa.a
    public final String d() {
        return null;
    }

    @Override // lsa.a
    public final int f() {
        if (this.f543432b != 0) goto L6;
        return -1;
    L6:
        this.f543436f.removeCallbacks(this.f543445o);
        int r100 = this.f543431a.native_FL_ReleaseHandle(this.f543432b, false, "");
        this.f543432b = 0;
        return r100;
    }

    @Override // lsa.a
    public final int g() {
        if (this.f543432b != 0) goto L6;
        return -1;
    L6:
        this.f543437g = true;
        this.f543443m = System.currentTimeMillis() + 500;
        this.f543444n = 0;
        this.f543448r = 0;
        this.f543440j = 0;
        this.f543439i = false;
        return this.f543431a.native_FL_ResetHandle(this.f543432b, false, "");
    }

    public final String l() {
        return this.f543433c.getString(R.string.byted_detect_over_time_msg);
    }

    public final void n() {
        if (this.f543438h == 2) goto L6;
        return;
    L6:
        if (this.f543448r <= (this.f543447q.length() - 1)) goto L9;
        CertLog.e("VideoLivenessTask", "show last number, stop detect");
        this.f543437g = false;
        return;
    L9:
        this.f543436f.post(new h(this));
        i r100 = new i(this);
        this.f543446p = r100;
        this.f543436f.postDelayed(r100, 1000);
    }

    public b() {
        this.f543431a = null;
        this.f543432b = 0;
        this.f543437g = false;
        this.f543438h = 0;
        this.f543440j = 0;
        this.f543443m = 0;
        this.f543444n = 0;
        this.f543447q = AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_IN__NETWORK_WIFI__SCREEN_ON;
        this.f543448r = 0;
        this.f543449s = null;
        new String[]{IPerformanceManager.MODULE_BLINK, "open_mouth", "nod", "shake_head"};
        new String[]{"检测尚未完成", "检测成功", "超时未检测到第一张有效人脸", "单个动作超时", "人脸丢失超过最大允许次数", "人脸REID超时", "做错动作，可能是视频攻击", "静默活体检测失败", "过程中人脸不一致"};
        this.f543452v = "";
        this.f543454x = new ArrayList();
    }

    @Override // lsa.a
    public final String c(int r100) {
        if (r100 == 2) goto L11;
        if (r100 == 3) goto L9;
        return this.f543433c.getString(R.string.byted_detect_video_fail_title);
    L9:
        return this.f543433c.getString(R.string.byted_detect_upload_fail_title);
    L11:
        return this.f543433c.getString(R.string.byted_detect_over_time_title);
    }

    @Override // lsa.a
    public final int k(LiveInfo r110) {
        if (TextUtils.isEmpty(r110.f407583h) == true) goto L5;
        this.f543447q = r110.f407583h;
    L5:
        int r100 = r110.f407577b;
        CertLog.d("debug1 face liveness", "SetParam");
        if (this.f543432b != 0) goto L9;
        return -1;
    L9:
        int r111 = this.f543431a.native_FL_SetParamFromBytes(this.f543432b, 1, 1, r100, 0, 0, 0);
        if (r111 == 0) goto L12;
        return r111;
    L12:
        return 0;
    }

    public final void m(boolean r100) {
        Boolean r101 = this.f543449s;
        if (r101 != null) goto L5;
    L7:
        this.f543449s = Boolean.valueOf(r100);
        JSONObject r102 = new JSONObject();
        if (r100 == false) goto L11;
        String r103 = "success";
    L29:
        r102.put(EventConstant.Key.VIDEO_PROMPT_RESULT, r103);     // Catch: Exception -> L28
        List<Integer> r104 = this.f543454x;     // Catch: Exception -> L28
        if (r104 != null) goto L15;
    L24:
        String r105 = "";
    L25:
        r102.put(EventConstant.Key.VIDEO_PROMPT_INFO, r105);     // Catch: Exception -> L28
        goto L26
    L15:
        if (((ArrayList) r104).isEmpty() == true) goto L24;
        int r106 = ((ArrayList) this.f543454x).size();     // Catch: Exception -> L28
        JSONArray r107 = new JSONArray();     // Catch: Exception -> L28
        int r108 = 0;
    L18:
        if (r108 >= r106) goto L23;
        Integer r109 = (Integer) ListProtector.get(this.f543454x, r108);     // Catch: Exception -> L28
        if (r109 == null) goto L22;
        r107.put(r109);     // Catch: Exception -> L28
    L22:
        r108 = r108 + 1;     // Catch: Exception -> L28
        goto L18
    L23:
        r105 = r107.toString();     // Catch: Exception -> L28
    L26:
        this.f543450t.onEvent(EventConstant.Event.FACE_DETECTION_VIDEO_QUALITY, r102);
        return;
    L11:
        r103 = "fail";
        goto L29
    L5:
        if (r100 != r101.booleanValue()) goto L7;
    }

    public final void o(boolean r100) {
        CertLog.e("VideoLivenessTask", "stopRecord upload =" + r100);
        this.f543436f.removeCallbacks(this.f543446p);
        this.f543448r = 0;
        this.f543436f.post(new ssa.c(this));
        this.f543436f.postDelayed(new g(this, r100), 500);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lsa.a
    public final int e(Context r110, Bundle r111) {
        this.f543433c = r110;
        this.f543434d = (FaceLiveDialog) r110;
        this.f543435e = (VerifyCallBack) r110;
        String r112 = r111.getString(BytedCertConstant.IntentKey.FLOW_ID);
        if (TextUtils.isEmpty(r112) == false) goto L6;
        CertLog.e("VideoLivenessTask", "args error");
        return 1;
    L6:
        ICertFlow r113 = BytedCertManager.getInstance().getFlow(r112);
        if ((r113 instanceof FaceDetectFlow) == true) goto L10;
        CertLog.e("VideoLivenessTask", "flow error");
        return 1;
    L10:
        this.f543450t = (FaceDetectFlow) r113;
        this.f543453w = this.f543433c.getResources().getStringArray(R.array.byted_liveness_prompt_info);
        FaceLiveness r114 = new FaceLiveness();
        this.f543431a = r114;
        this.f543432b = r114.native_FL_CreateHandler();
        if (this.f543432b != 0) goto L14;
        CertLog.d("VideoLivenessTask", "Create handle err: " + this.f543432b);
        return 1;
    L14:
        String r115 = "res/action_liveness/" + FaceLiveness.native_FL_GetModelName();
        rsa.d.c(r110, r115);
        String r116 = rsa.d.j(r110, r115);
        int r100 = this.f543431a.native_FL_SetModule(this.f543432b, r116);
        if (r100 == 0) goto L22;
        CertLog.e("VideoLivenessTask", " err SetModle in FaceLiveness, code: " + r100);
        if (r100 != (-5)) goto L21;
        PolarisFileWrapper r117 = new PolarisFileWrapper(r116);
        if (r117.exists() == false) goto L21;
        r117.delete();
    L21:
        return r100;
    L22:
        Activity r118 = (Activity) r110;
        this.f543451u = (TextView) r118.findViewById(R.id.tv_task_board);
        float r101 = this.f543450t.getThemeConfig().faceLiveTextSize();
        if (r101 <= 0.0f) goto L25;
        this.f543451u.setTextSize(2, r101);
    L25:
        float r102 = rsa.i.d(r110);
        if ((UIUtils.getScreenHeight(r110) / UIUtils.getScreenWidth(r110)) >= 1.6f) goto L28;
        this.f543451u.setTranslationY(-((int) (UIUtils.dip2Px(r110, 50.0f) + r102)));
    L29:
        this.f543451u.setVisibility(0);
        ThemeConfig r103 = this.f543450t.getThemeConfig();
        this.f543451u.setTextColor(r103.faceLiveTextColor());
        this.f543436f = (TextView) r118.findViewById(R.id.tv_tip_under_cicle);
        this.f543436f.setTranslationY((int) (r102 + UIUtils.dip2Px(r110, 50.0f)));
        this.f543436f.setVisibility(0);
        this.f543436f.setTextColor(r103.faceLiveTextColor());
        this.f543437g = true;
        this.f543441k = new ksa.e();
        this.f543443m = System.currentTimeMillis() + 500;
        this.f543444n = 0;
        this.f543448r = 0;
        this.f543440j = 0;
        this.f543439i = false;
        this.f543441k.f505977d = new a(this);
        return 0;
    L28:
        this.f543451u.setTranslationY(-((int) (UIUtils.dip2Px(r110, 82.0f) + r102)));
        goto L29
    }

    @Override // lsa.a
    public final int i(int[] r100, float[] r101) {
        CertLog.d("debug1 face liveness", "SetParam");
        if (this.f543432b != 0) goto L7;
        return -1;
    L7:
        if (r100 != null) goto L9;
    L22:
        return 0;
    L9:
        if (r100.length == 0) goto L22;
        if (r101 == null) goto L22;
        if (r101.length == 0) goto L22;
        int r102 = 0;
    L17:
        if (r102 >= r100.length) goto L22;
        int r103 = this.f543431a.native_FL_SetConfigFloat(this.f543432b, r100[r102], r101[r102]);
        if (r103 != 0) goto L20;
        r102 = r102 + 1;
        goto L17
    L20:
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v3 */
    @Override // lsa.a
    public final int a(byte[] r210, int r211, byte[] r212, int r213, int r214) {
        if (this.f543438h != 2) goto L7;
        ThreadPlus.submitRunnable(new RunnableC7647b(this, r210));
    L7:
        if (this.f543437g == true) goto L9;
        return -1;
    L9:
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f543443m) >= 500) goto L12;
        return -1;
    L12:
        this.f543443m = r100;
        if (this.f543444n != 0) goto L15;
        this.f543444n = r100;
    L15:
        int r101 = r213 * 4;
        if (this.f543432b != 0) goto L18;
        return -1;
    L18:
        int[] r110 = new int[2];
        if (AutoTestManager.getInstance().isAutoTest() == false) goto L38;
        AutoTestManager.outputLog("start videoLiveness");
        AutoTestManager.getInstance().initHook();     // Catch: Exception -> L23
    L26:
        if (AutoTestManager.getInstance().getAutoTestFace() != null) goto L28;
        return -1;
    L28:
        AutoTestManager r102 = AutoTestManager.getInstance();
        byte[] r103 = r102.getAutoTestFace();
        if (r103 != null) goto L31;
    L36:
        return -1;
    L31:
        if (r103.length <= 0) goto L36;
        if (this.f543450t.isLiveSdkPaused() == false) goto L35;
        return 0;
    L35:
        int r104 = this.f543431a.native_FL_doFaceQuality(this.f543432b, r103, 0, r102.getImageW(), r102.getImageH(), r102.getImageW() * 4, r211, r110);
        ?? r111 = 0;
    L42:
        if (r104 == 0) goto L45;
        CertLog.e("VideoLivenessTask", "faceLiveness.native_FL_doFaceQuality :" + r104);
        return r104;
    L45:
        int r105 = r110[r111];
        int r106 = r110[1];
        this.f543452v = "";
        int r107 = r106 - 101;
        CertLog.e("VideoLivenessTask", "faceLiveness.native_FL_doFaceQuality prompt:" + r106);
        if (r107 < 0) goto L75;
        String[] r108 = this.f543453w;
        if (r107 >= r108.length) goto L75;
        this.f543452v = r108[r107];
        if (((ArrayList) this.f543454x).isEmpty() == true) goto L53;
        List<Integer> r109 = this.f543454x;
        if (((Integer) ListProtector.get(r109, ((ArrayList) r109).size() - 1)).intValue() != r107) goto L53;
    L55:
        if (r107 != 6) goto L57;
        m(true);
        if (this.f543438h != 0) goto L72;
        this.f543438h = 1;
        String r112 = rsa.b.a();
        this.f543442l = rsa.d.j(this.f543433c, r112 + "_src.mp4");
        StringBuilder r113 = new StringBuilder("start record ");
        r113.append(this.f543442l);
        CertLog.d("VideoLivenessTask", r113.toString());
        this.f543441k.a(r213, r214, this.f543442l, 15, true);
        this.f543441k.c();
    L72:
        this.f543452v = this.f543433c.getString(R.string.byted_detect_read_number);
    L73:
        ((Activity) this.f543433c).runOnUiThread(new f(this));
        return r105;
    L57:
        if (this.f543438h != 2) goto L64;
        this.f543436f.removeCallbacks(this.f543445o);
        this.f543438h = 3;
        this.f543436f.post(new c(this));
        this.f543440j++;
        CertLog.e("VideoLivenessTask", "video record interruptTime " + this.f543440j);
        long r114 = System.currentTimeMillis() - this.f543444n;
        CertLog.e("VideoLivenessTask", "video total costTime " + r114);
        if (this.f543440j <= 5) goto L61;
    L62:
        this.f543436f.post(new d(this));
    L68:
        m(r111);
        goto L73
    L61:
        if (r114 <= 30000) goto L68;
    L64:
        if (this.f543438h != 0) goto L68;
        long r115 = System.currentTimeMillis() - this.f543444n;
        CertLog.e("VideoLivenessTask", "video total costTime " + r115);
        if (r115 <= 30000) goto L68;
        this.f543436f.post(new e(this));
    L53:
        ((ArrayList) this.f543454x).add(Integer.valueOf(r107));
    L75:
        return -1;
    L23:
        e = move-exception;
        AutoTestManager.outputLog("init hook fail");
        e.printStackTrace();
        goto L26
    L38:
        if (this.f543450t.isLiveSdkPaused() == false) goto L40;
        return 0;
    L40:
        r111 = 0;
        r104 = this.f543431a.native_FL_doFaceQuality(this.f543432b, r210, 0, r213, r214, r101, r211, r110);
        goto L42
    }
}
