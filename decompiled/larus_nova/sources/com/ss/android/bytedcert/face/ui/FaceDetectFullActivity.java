package com.ss.android.bytedcert.face.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.bytedcert.base.BytedCertSdkAbsActivity;
import com.ss.android.bytedcert.camera.common.CameraFactory$WhiteBalanceType;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.flow.face.FaceDetectFlow;
import com.ss.android.bytedcert.flow.face.FaceLiveInitDurationHelper;
import com.ss.android.bytedcert.model.LiveInfo;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.view.AudioProgressTextView;
import com.ss.android.bytedcert.view.CircleInsideBgView;
import com.ss.android.bytedcert.view.CircleMotionView;
import com.ss.android.bytedcert.view.CountDownButton;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import jsa.h;
import kotlin.jvm.internal.Intrinsics;
import rsa.i;
import vsa.j;
import vsa.k;
import vsa.l;
import vsa.m;
import vsa.n;

/* JADX INFO: loaded from: classes34.dex */
public class FaceDetectFullActivity extends BytedCertSdkAbsActivity implements isa.a {
    public static final /* synthetic */ int H = 0;
    public float A;
    public float B;
    public final f C;
    public final Handler D;
    public long E;
    public Animator F;
    public String G;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f407466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownButton f407467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CircleMotionView f407468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CircleInsideBgView f407469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RelativeLayout f407470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RelativeLayout f407471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f407472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f407473k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f407474l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f407475m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f407476n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AudioProgressTextView f407477o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ScrollView f407478p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public StringBuilder f407479q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f407480r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f407481s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageView f407482t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public GLSurfaceView f407483u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CountDownTimer f407484v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ThemeConfig f407485w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.ss.android.bytedcert.face.c f407486x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public FaceDetectFlow f407487y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f407488z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FaceDetectFullActivity f407489a;

        @Override // java.lang.Runnable
        public final void run() {
            ImageView r100 = this.f407489a.f407481s;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setVisibility(8);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(FaceDetectFullActivity r100) {
            this.f407489a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f407490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FaceDetectFullActivity f407491b;

        @Override // java.lang.Runnable
        public final void run() {
            FaceDetectFullActivity r100 = this.f407491b;     // Catch: Throwable -> L7
            int r101 = FaceDetectFullActivity.H;     // Catch: Throwable -> L7
            if (r100.B1() == true) goto L10;
            long r102 = System.currentTimeMillis();     // Catch: Throwable -> L7
            FaceDetectFullActivity r103 = this.f407491b;     // Catch: Throwable -> L7
            r103.f407477o.setProgress((r102 - r103.E) / this.f407490a);     // Catch: Throwable -> L7
            this.f407491b.D.postDelayed(this, 30);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }

        public b(FaceDetectFullActivity r100, long r101) {
            this.f407491b = r100;
            this.f407490a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ isa.c f407492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FaceDetectFullActivity f407493b;

        public class a extends CountDownTimer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f407494a;

            @Override // android.os.CountDownTimer
            public final void onFinish() {
                FaceDetectFullActivity r100 = this.f407494a.f407493b;
                int r101 = FaceDetectFullActivity.H;
                CountDownTimer r102 = r100.f407484v;
                if (r102 == null) goto L6;
                r102.cancel();
                r100.f407484v = null;
                return;
            }

            @Override // android.os.CountDownTimer
            public final void onTick(long r100) {
                int r101 = ((int) r100) / 1000;
                if (r101 > 0) goto L5;
            L7:
                c r102 = this.f407494a;
                r102.f407493b.f407477o.setText(r102.f407492a.f495700a);
                return;
            L5:
                if (TextUtils.isEmpty(this.f407494a.f407492a.f495700a) == true) goto L7;
                this.f407494a.f407493b.f407477o.setText(String.format(this.f407494a.f407492a.f495700a + " (%d秒)", new Object[]{Integer.valueOf(r101)}));
            }

            public a(c r100, long r101) {
                this.f407494a = r100;
                super(r101, 999);
            }
        }

        public class b implements n.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f407495a;

            public final boolean b() {
                FaceDetectFullActivity r100 = this.f407495a.f407493b;
                return !TextUtils.equals(r100.G, r100.f407477o.getText());
            }

            public final boolean c() {
                c r100 = this.f407495a;
                if (TextUtils.equals(r100.f407493b.G, r100.f407492a.f495700a) == false) goto L6;
                c r101 = this.f407495a;
                r101.f407493b.f407477o.setText(r101.f407492a.f495700a);
                return false;
            L6:
                return true;
            }

            public b(c r100) {
                this.f407495a = r100;
            }

            public final void a(Animator r100) {
                this.f407495a.f407493b.F = r100;
            }
        }

        public final void a() {
            FaceDetectFullActivity r100 = this.f407493b;
            int r101 = FaceDetectFullActivity.H;
            if (r100.B1() == false) goto L6;
            return;
        L6:
            if (this.f407493b.f407487y.isOpenLiveOpt() == false) goto L15;
            FaceDetectFullActivity r102 = this.f407493b;
            CountDownTimer r103 = r102.f407484v;
            if (r103 == null) goto L10;
            r103.cancel();
            r102.f407484v = null;
        L10:
            isa.c r104 = this.f407492a;
            if (r104.f495705f <= 0) goto L13;
            this.f407493b.f407484v = new a(this, ((long) (this.f407492a.f495705f + 1)) * 1000);
            this.f407493b.f407484v.start();
        L80:
            this.f407493b.M1(this.f407492a.f495700a);
            return;
        L13:
            this.f407493b.f407477o.setText(r104.f495700a);
            goto L80
        L15:
            if (this.f407493b.f407487y.getCertInfo().H == false) goto L44;
            isa.c r105 = this.f407492a;
            int r106 = r105.f495703d;
            if (r106 != 103) goto L19;
        L24:
            boolean r107 = true;
        L25:
            int r108 = r105.f495701b;
            if (r108 != 0) goto L30;
            if (r107 == false) goto L29;
            this.f407493b.f407482t.setVisibility(0);
            goto L44
        L29:
            this.f407493b.f407482t.setVisibility(8);
            goto L44
        L30:
            if (r108 != 2) goto L34;
            if (r107 == false) goto L33;
            this.f407493b.f407482t.setVisibility(0);
            CountDownButton r109 = this.f407493b.f407467e;
            int r110 = ColorProtector.parseColor("#ff0050");
            r109.f407766y = true;
            r109.f407767z = r110;
            goto L44
        L33:
            this.f407493b.f407482t.setVisibility(8);
            CountDownButton r111 = this.f407493b.f407467e;
            r111.f407766y = false;
            r111.f407767z = 0;
            goto L44
        L34:
            if (r108 != 3) goto L44;
            if (r106 != 0) goto L44;
            if (this.f407493b.f407487y.getCertInfo().H == false) goto L44;
            this.f407493b.D.removeCallbacksAndMessages(null);
            this.f407493b.f407477o.setProgress(0.0f);
            CountDownButton r112 = this.f407493b.f407467e;
            r112.f407758q = (int) r112.f407757p;
            r112.postInvalidate();
            r112.f407755n.removeCallbacksAndMessages(null);
            r112.f407759r = System.currentTimeMillis();
            r112.f407755n.postDelayed(r112.f407756o, 10);
            CountDownButton r113 = this.f407493b.f407467e;
            int r114 = ColorProtector.parseColor("#1CDD66");
            r113.f407766y = true;
            r113.f407767z = r114;
            this.f407493b.f407482t.setVisibility(0);
            n.a(this.f407493b.f407482t, null);
            ViewGroup.LayoutParams r115 = this.f407493b.f407482t.getLayoutParams();
            int r116 = (int) i.b(this.f407493b, 80.0f);
            if (r115 != null) goto L41;
            r115 = new RelativeLayout.LayoutParams(r116, r116);
        L42:
            this.f407493b.f407482t.setLayoutParams(r115);
            FaceDetectFullActivity r117 = this.f407493b;
            r117.f407482t.setImageDrawable(r117.getResources().getDrawable(R.mipmap.byted_face_success));
            goto L44
        L41:
            r115.width = r116;
            r115.height = r116;
            goto L42
        L19:
            if (r106 == 106) goto L24;
            if (r106 == 111) goto L24;
            r107 = false;
        L44:
            if (this.f407493b.f407487y.getCertInfo().G == false) goto L79;
            isa.c r118 = this.f407492a;
            if (r118.f495701b != 2) goto L76;
            b r119 = new b(this);
            FaceDetectFullActivity r120 = this.f407493b;
            String r121 = r118.f495700a;
            r120.G = r121;
            if (r118.f495704e == true) goto L73;
            int r122 = r118.f495702c;
            if (r122 == 0) goto L69;
            if (r122 == 1) goto L69;
            if (r122 == 2) goto L65;
            if (r122 != 3) goto L55;
        L61:
            AudioProgressTextView r123 = r120.f407477o;
            boolean r124 = TextUtils.isEmpty(r123.getText());
            j r125 = new j(r119, r123);
            if (r124 == false) goto L64;
            r119.c();
            n.a(r123, r125);
            goto L80
        L64:
            n.b(r123, new k(r119, r123, r125));
            goto L80
        L55:
            if (r122 == 4) goto L65;
            if (r122 == 5) goto L61;
            r120.f407477o.setText(r121);
            Animator r126 = this.f407493b.F;
            if (r126 == null) goto L80;
            r126.cancel();
        L65:
            AudioProgressTextView r127 = r120.f407477o;
            boolean r128 = TextUtils.isEmpty(r127.getText());
            l r129 = new l(r119, r127);
            if (r128 == false) goto L68;
            r119.c();
            n.a(r127, r129);
            goto L80
        L68:
            n.b(r127, new m(r119, r127, r129));
        L69:
            AudioProgressTextView r130 = r120.f407477o;
            boolean r131 = TextUtils.isEmpty(r130.getText());
            vsa.f r132 = new vsa.f(r119, r130);
            if (r131 == false) goto L72;
            r119.c();
            n.a(r130, r132);
            goto L80
        L72:
            n.b(r130, new vsa.i(r119, r130, r132));
            goto L80
        L73:
            r120.f407477o.setText(r121);
            Animator r133 = this.f407493b.F;
            if (r133 == null) goto L80;
            r133.cancel();
            goto L80
        L76:
            this.f407493b.f407477o.setText(r118.f495700a);
            Animator r134 = this.f407493b.F;
            if (r134 == null) goto L80;
            r134.cancel();
            goto L80
        L79:
            this.f407493b.f407477o.setText(this.f407492a.f495700a);
            goto L80
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

        public c(FaceDetectFullActivity r100, isa.c r101) {
            this.f407493b = r100;
            this.f407492a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FaceDetectFullActivity f407496a;

        @Override // java.lang.Runnable
        public final void run() {
            FaceDetectFullActivity r100 = this.f407496a;     // Catch: Throwable -> L9
            int r101 = FaceDetectFullActivity.H;     // Catch: Throwable -> L9
            if (r100.B1() == true) goto L12;
            FaceDetectFullActivity r102 = this.f407496a;     // Catch: Throwable -> L9
            r102.f407476n.setText(r102.f407479q.toString());     // Catch: Throwable -> L9
            ScrollView r103 = this.f407496a.f407478p;     // Catch: Throwable -> L9
            if (r103 == null) goto L16;
            r103.fullScroll(130);     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public d(FaceDetectFullActivity r100) {
            this.f407496a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f407497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f407498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f407499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FaceDetectFullActivity f407500d;

        public final void a() {
            FaceDetectFullActivity r100 = this.f407500d;
            int r101 = FaceDetectFullActivity.H;
            if (r100.B1() == false) goto L5;
            return;
        L5:
            int r102 = this.f407497a;
            if (r102 > 0) goto L8;
        L10:
            this.f407500d.f407475m.setText(this.f407499c);
            return;
        L8:
            if (r102 > this.f407498b) goto L10;
            FaceDetectFullActivity r103 = this.f407500d;
            i.h(r103.f407475m, r103.getResources().getString(R.string.byted_detect_remain_actions, new Object[]{Integer.valueOf(this.f407497a)}), String.valueOf(this.f407497a), null);
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

        public e(FaceDetectFullActivity r100, int r101, int r102, String r103) {
            this.f407500d = r100;
            this.f407497a = r101;
            this.f407498b = r102;
            this.f407499c = r103;
        }
    }

    public class f implements bsa.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FaceDetectFullActivity f407501a;

        @Override // bsa.f
        public final void a() {
            this.f407501a.runOnUiThread(new com.ss.android.bytedcert.face.ui.a(this));
        }

        public f(FaceDetectFullActivity r100) {
            this.f407501a = r100;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f407502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f407503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f407504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FaceDetectFullActivity f407505d;

        public final void a() {
            Bitmap r100 = Bitmap.createBitmap(this.f407502a, this.f407503b, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L5
            r100.copyPixelsFromBuffer(ByteBuffer.wrap(this.f407504c));     // Catch: Exception -> L5
            ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L5
            r100.compress(Bitmap.CompressFormat.JPEG, 80, r101);     // Catch: Exception -> L5
            Bitmap r102 = rsa.a.a(this.f407505d.getApplicationContext(), r100);     // Catch: Exception -> L5
            r100.recycle();     // Catch: Exception -> L5
            this.f407505d.f407481s.setImageBitmap(r102);
            this.f407505d.f407481s.setVisibility(0);
            this.f407505d.M1("info detecting");
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

        public g(FaceDetectFullActivity r100, int r101, int r102, byte[] r103) {
            this.f407505d = r100;
            this.f407502a = r101;
            this.f407503b = r102;
            this.f407504c = r103;
        }
    }

    @Override // isa.a, isa.b
    public Activity getActivity() {
        return this;
    }

    @Override // isa.b
    public final void s() {
    }

    @Override // isa.b
    public final void D0() {
        CountDownButton r100 = this.f407467e;
        if (r100 == null) goto L5;
        r100.f407755n.removeCallbacksAndMessages(null);
    L5:
        CountDownTimer r101 = this.f407484v;
        if (r101 == null) goto L9;
        r101.cancel();
        this.f407484v = null;
        return;
    }

    public final void L1() {
        CircleMotionView r100 = this.f407468f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f407733n.get() == true) goto L12;
        CircleMotionView r101 = this.f407468f;
        ValueAnimator r102 = r101.f407732m;
        if (r102 == null) goto L9;
        r102.cancel();
    L9:
        CertLog.d("Animation#", "start animation");
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 2.0f, 0.001f});
        r101.f407732m = r103;
        r103.setDuration(6000);
        r101.f407732m.setInterpolator(new CircleMotionView.a());
        r101.f407732m.setRepeatMode(2);
        r101.f407732m.setRepeatCount(-1);
        r101.f407732m.addUpdateListener(new usa.a(r101));
        r101.f407732m.start();
        r101.f407733n.set(true);
        return;
    }

    @Override // isa.a
    public final void Q0() {
        com.ss.android.bytedcert.face.c r100 = this.f407486x;
        if (r100 == null) goto L5;
        r100.f();
    L5:
        runOnUiThread(new jsa.f(this));
    }

    @Override // isa.a
    public final void T0() {
        bsa.a r100 = this.f407486x.f407350d;
        if (r100 == null) goto L6;
        r100.g(CameraFactory$WhiteBalanceType.NONE);
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        com.ss.android.bytedcert.face.c r100 = this.f407486x;
        if (r100 == null) goto L6;
        r100.i(false, null);
        return;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        D0();
        com.ss.android.bytedcert.face.c r100 = this.f407486x;
        if (r100 == null) goto L8;
        r100.j();
    L8:
        this.D.removeCallbacksAndMessages(null);
    }

    @Override // isa.b
    public final void r0() {
        CountDownButton r100 = this.f407467e;
        if (r100 == null) goto L6;
        r100.f407758q = (int) r100.f407757p;
        r100.postInvalidate();
        r100.f407755n.removeCallbacksAndMessages(null);
        r100.f407759r = System.currentTimeMillis();
        r100.f407755n.postDelayed(r100.f407756o, 10);
        return;
    }

    public FaceDetectFullActivity() {
        this.C = new f(this);
        this.D = new Handler(Looper.getMainLooper());
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity
    public final boolean D1() {
        if (getIntent() != null) goto L5;
        return false;
    L5:
        if (getIntent().getBooleanExtra("without_animation", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int F1() {
        int r100 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r100 > 0) goto L7;
        return 0;
    L7:
        return getResources().getDimensionPixelSize(r100);
    }

    public final float H1() {
        float r100 = i.d(this);
        float r101 = getIntent().getFloatExtra("radius", 0.0f);
        this.A = r101;
        if (r101 > 0.0f) goto L5;
    L9:
        this.A = r100;
        return 1.0f;
    L5:
        if (r101 >= (i.f(this) / 2.0f)) goto L9;
        return this.A / r100;
    }

    public int I1() {
        return i.e(this);
    }

    @Override // isa.b
    public final void V0() {
        if (B1() == false) goto L6;
        return;
    L6:
        if (this.f407481s == null) goto L9;
        runOnUiThread(new a(this));
        return;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // isa.a
    public final void m() {
        if (B1() == false) goto L5;
        return;
    L5:
        showLoading("识别中，请勿移动");
        this.f407486x.l();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        D0();
        com.ss.android.bytedcert.face.c r100 = this.f407486x;
        if (r100 == null) goto L6;
        r100.o();
        return;
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
        L1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (isFinishing() == false) goto L5;
        return;
    L5:
        com.ss.android.bytedcert.face.c r100 = this.f407486x;
        if (r100 == null) goto L8;
        r100.r(this.f407483u, this.C);
        this.f407486x.t(getIntent().getExtras());
    L8:
        LiveInfo r101 = this.f407487y.getLiveInfo();
        if (r101 == null) goto L13;
        CountDownButton r102 = this.f407467e;
        if (r102 == null) goto L13;
        float r103 = r101.f407577b;
        r102.f407757p = r103;
        r102.f407758q = r103;
        r102.postInvalidate();
        CountDownButton r104 = this.f407467e;
        r104.f407758q = r103;
        r104.postInvalidate();
    L13:
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("page", "resume", null)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        L1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        D0();
        CircleMotionView r100 = this.f407468f;
        if (r100 != null) goto L5;
    L7:
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("page", "back", null)));
        return;
    L5:
        if (r100.f407732m == null) goto L7;
        CertLog.d("Animation#", "stop animation");
        r100.f407732m.cancel();
        r100.f407732m = null;
        r100.f407733n.set(false);
        goto L7
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, isa.b
    public final void hideLoading() {
        super.hideLoading();
    }

    @Override // isa.b
    public final void C0(int r100) {
        CountDownButton r101 = this.f407467e;
        if (r101 == null) goto L5;
        float r102 = r100;
        r101.f407757p = r102;
        r101.f407758q = r102;
        r101.postInvalidate();
        CountDownButton r103 = this.f407467e;
        r103.f407758q = r102;
        r103.postInvalidate();
    L5:
        com.ss.android.bytedcert.face.c r104 = this.f407486x;
        if (r104 == null) goto L8;
        r104.q();
    L8:
        V0();
    }

    public final void K1(float r110) {
        if (this.f407477o != null) goto L6;
        this.f407477o = (AudioProgressTextView) findViewById(R.id.tv_task_board);
    L6:
        if (this.f407474l != null) goto L8;
        this.f407474l = (TextView) findViewById(R.id.tv_tip_in_cycle);
    L8:
        float r100 = this.f407485w.faceLiveTextSize();
        float r101 = i.e(this);
        float r102 = i.f(this);
        this.f407474l.setTranslationY(((-((int) (this.A + i.b(this, 50.0f)))) + r110) + i.b(this, 60.0f));
        this.f407477o.setVisibility(0);
        if (r100 <= 0.0f) goto L12;
        this.f407477o.setTextSize(2, r100);
    L12:
        if (this.f407487y.getCertInfo().F == false) goto L14;
        AudioProgressTextView r103 = this.f407477o;
        int r104 = ColorProtector.parseColor("#467BFB");
        int r105 = this.f407485w.faceLiveTextColor();
        r103.f407709c.setColor(r104);
        r103.f407708b.setColor(r105);
        r103.invalidate();
    L15:
        float r106 = r101 / r102;
        if (r106 >= 1.6f) goto L18;
        this.f407477o.setTranslationY((-((int) (this.A + i.b(this, 30.0f)))) + r110);
    L20:
        if (this.f407487y.isOpenLiveOpt() == true) goto L22;
        return;
    L22:
        if (this.f407475m != null) goto L24;
        this.f407475m = (TextView) findViewById(R.id.tv_task_bottom);
    L24:
        if (r100 <= 0.0f) goto L26;
        this.f407475m.setTextSize(2, r100);
    L26:
        if (r106 >= 1.6f) goto L28;
        this.f407475m.setTranslationY(((int) (this.A + i.b(this, 30.0f))) + r110);
    L29:
        this.f407475m.setVisibility(0);
        this.f407475m.setTextColor(this.f407485w.faceLiveTextColor());
        return;
    L28:
        this.f407475m.setTranslationY(((int) (this.A + i.b(this, 52.0f))) + r110);
        goto L29
    L18:
        this.f407477o.setTranslationY((-((int) (this.A + i.b(this, 52.0f)))) + r110);
        goto L20
    L14:
        this.f407477o.setTextColor(this.f407485w.faceLiveTextColor());
        goto L15
    }

    public final void M1(String r100) {
        if (BytedCertSdkManager.getInstance().isLocalTest() == false) goto L13;
        TextView r101 = this.f407476n;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.getVisibility() == 0) goto L9;
        return;
    L9:
        if (this.f407479q != null) goto L11;
        this.f407479q = new StringBuilder("new mvp ui\n");
    L11:
        StringBuilder r102 = this.f407479q;
        r102.append(r100);
        r102.append("\n");
        runOnUiThread(new d(this));
        return;
    }

    @Override // isa.a
    public final void Y0(int r110) {
        if (B1() == false) goto L5;
        return;
    L5:
        if (this.f407480r == null) goto L59;
        String r100 = this.f407487y.getCertInfo().D;
        if (r110 != this.f407485w.faceLiveScreenBgColor()) goto L13;
        if (TextUtils.isEmpty(r100) == true) goto L13;
        int r111 = this.f407485w.faceLiveTextColor();
        this.f407480r.setVisibility(0);
        ((SimpleDraweeView) this.f407480r).setController(Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r100)).build()).setAutoPlayAnimations(true).setOldController(((SimpleDraweeView) this.f407480r).getController()).build());
        Boolean r101 = Boolean.valueOf(this.f407485w.isWebDarkMode());
        int r102 = 0;
    L16:
        AudioProgressTextView r103 = this.f407477o;
        if (r103 == null) goto L19;
        r103.setTextColor(r111);
    L19:
        Window r112 = getWindow();
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 29) goto L22;
        r112.setNavigationBarContrastEnforced(false);
    L22:
        r112.addFlags(Integer.MIN_VALUE);
        r112.setStatusBarColor(r102);
        r112.setNavigationBarColor(r102);
        int r105 = i.a(r112).getSystemUiVisibility() | 1024;
        if (ColorUtils.calculateLuminance(r102) >= 0.5d) goto L25;
        if (r101 != null) goto L25;
    L28:
        if (r104 < 23) goto L30;
        r105 = r105 & (-8193);
    L30:
        if (r104 < 26) goto L36;
        r105 = r105 & (-17);
    L36:
        i.a(r112).setSystemUiVisibility(r105 | 512);
        if (r104 < 28) goto L39;
        WindowManager.LayoutParams r106 = r112.getAttributes();
        r106.layoutInDisplayCutoutMode = 1;
        r112.setAttributes(r106);
    L39:
        CountDownButton r113 = this.f407467e;
        if (r113 == null) goto L42;
        r113.setBgColor(r102);
    L42:
        CircleMotionView r114 = this.f407468f;
        if (r114 == null) goto L46;
        r114.setBgColor(r102);
    L46:
        if (this.f407470h == null) goto L53;
        int r115 = F1();
        if (r115 <= 0) goto L52;
        ViewGroup.LayoutParams r107 = this.f407470h.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L52;
        ((ViewGroup.MarginLayoutParams) r107).setMargins(0, r115, 0, 0);
    L52:
        this.f407470h.setBackgroundColor(r102);
    L53:
        RelativeLayout r116 = this.f407471i;
        if (r116 == null) goto L56;
        r116.setBackgroundColor(r102);
    L56:
        M1("change background color:" + r102);
        return;
    L25:
        if (r101 != null) goto L27;
    L32:
        if (r104 < 23) goto L34;
        r105 = r105 | 8192;
    L34:
        if (r104 < 26) goto L36;
        r105 = r105 | 16;
        goto L36
    L27:
        if (r101.booleanValue() == false) goto L32;
    L13:
        if (r110 != this.f407485w.faceLiveScreenBgColor()) goto L15;
        int r108 = this.f407485w.faceLiveTextColor();
        this.f407480r.setVisibility(8);
        r101 = Boolean.valueOf(this.f407485w.isWebDarkMode());
        r102 = r110;
        r111 = r108;
        goto L16
    L15:
        this.f407480r.setVisibility(8);
        r101 = null;
        r102 = r110;
        r111 = -1;
        goto L16
    }

    @Override // isa.a
    public final void a0(isa.c r100) {
        if (B1() == false) goto L6;
        return;
    L6:
        if (this.f407477o == null) goto L9;
        runOnUiThread(new c(this, r100));
        return;
    }

    @Override // isa.a
    public final void e1(long r100) {
        this.D.removeCallbacksAndMessages(null);
        AudioProgressTextView r101 = this.f407477o;
        if (r101 == null) goto L6;
        r101.setProgress(0.0f);
        this.E = System.currentTimeMillis();
        runOnUiThread(new b(this, r100));
        return;
    }

    @Override // isa.a
    public final void f0(int r100) {
        if (B1() == false) goto L5;
        return;
    L5:
        CountDownButton r101 = this.f407467e;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.f407760s == r100) goto L13;
        r101.f407760s = r100;
        r101.f407758q = r100;
        r101.postInvalidate();
        r101.f407759r = System.currentTimeMillis();
        r101.f407755n.postDelayed(r101.f407756o, 10);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r100 == null) goto L8;
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L17
    L9:
        if (r102 != null) goto L12;
    L14:
        if (r101 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r102.intValue() == r101) goto L19;
    L8:
        r102 = null;
    L19:
        float r103 = H1();
        if (r103 == this.B) goto L28;
        this.B = r103;
        float r104 = this.f407488z;
        if (getResources().getConfiguration().orientation != 2) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L27;
        r104 = 0.0f;
    L27:
        i.i(this.f407483u, this.B, r104, true);
        i.i(this.f407481s, this.B, r104, true);
        i.i(this.f407482t, this.B, r104, true);
        i.i(this.f407469g, this.B, r104, true);
        i.i(this.f407468f, this.B, r104, true);
        i.i(this.f407467e, this.B, r104, true);
        goto L28
    L24:
        r105 = false;
    L28:
        M1("onConfigurationChanged");
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    @Override // isa.b
    public final void showLoading(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        String r101 = getString(R.string.byted_loading_text);
        Handler r102 = this.f407261a;
        asa.a r103 = new asa.a(this, r101);
        if (r102 != null) goto L7;
        return;
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        r103.run();     // Catch: Exception -> L18
    L19:
        return;
    L9:
        r102.post(r103);     // Catch: Exception -> L18
        goto L19
    L11:
        Handler r104 = this.f407261a;
        asa.a r105 = new asa.a(this, r100);
        if (r104 != null) goto L14;
        return;
    L14:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L16;
        r105.run();     // Catch: Exception -> L18
        goto L19
    L16:
        r104.post(r105);     // Catch: Exception -> L18
    }

    @Override // isa.a
    public final void v(String r100) {
        if (B1() == false) goto L5;
        return;
    L5:
        if (this.f407474l != null) goto L7;
        return;
    L7:
        if (this.f407469g != null) goto L10;
        return;
    L10:
        if (this.f407472j == true) goto L15;
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return;
    L15:
        if (this.f407472j == true) goto L17;
    L19:
        runOnUiThread(new jsa.e(this, r100));
        return;
    L17:
        if (TextUtils.equals(this.f407473k, r100) == false) goto L19;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity
    public void A1(ICertFlow r100, ThemeConfig r110) {
        if ((r100 instanceof FaceDetectFlow) == true) goto L6;
        CertLog.e("FaceDetectFlow", "onCreate: flow is not a FaceDetectFlow:" + r100);
        finish();
        return;
    L6:
        FaceDetectFlow r101 = (FaceDetectFlow) r100;
        this.f407487y = r101;
        this.f407485w = r110;
        int r111 = Build.VERSION.SDK_INT;
        if (r111 == 26) goto L9;
        setRequestedOrientation(1);
    L9:
        setContentView(R.layout.byted_activity_main_sdk);
        com.ss.android.bytedcert.face.c r102 = new com.ss.android.bytedcert.face.c(this, this.f407487y);
        this.f407486x = r102;
        if (r102.u(this) == false) goto L13;
        this.f407486x.i(true, null);
        return;
    L13:
        LiveInfo r103 = r101.getLiveInfo();
        if (r103 != null) goto L18;
        CertLog.e("FaceDetectFlow", "onCreate: live info is null");
        this.f407486x.i(true, null);
        return;
    L18:
        if (r103.D == false) goto L22;
        Window r104 = getWindow();
        if (r104 == null) goto L22;
        r104.setFlags(8192, 8192);
    L22:
        com.ss.android.bytedcert.face.c r105 = this.f407486x;
        LiveInfo r106 = r105.f407349c;
        if (r106 != null) goto L25;
    L32:
        boolean r107 = false;
    L33:
        if (r107 == false) goto L36;
        this.f407486x.i(true, null);
        return;
    L36:
        this.f407487y.onInitModuleStart(FaceLiveInitDurationHelper.Module.INIT_UI);
        this.B = H1();
        this.f407488z = getIntent().getFloatExtra("translation_y", 0.0f);
        float r108 = (I1() / 2.0f) - this.A;
        if (this.f407488z >= (-(r108 - i.b(this, 130.0f)))) goto L39;
    L40:
        this.f407488z = 0.0f;
    L41:
        float r109 = this.f407488z;
        if (getResources().getConfiguration().orientation != 2) goto L44;
        boolean r112 = true;
    L45:
        if (r112 == false) goto L47;
        r109 = 0.0f;
    L47:
        String r113 = this.f407487y.getCertInfo().C;
        if (TextUtils.isEmpty(r113) == true) goto L50;
        SimpleDraweeView r114 = (SimpleDraweeView) findViewById(R.id.face_title_icon);
        r114.setVisibility(0);
        r114.setController(Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r113)).build()).setAutoPlayAnimations(true).setOldController(r114.getController()).setControllerListener(new jsa.i(this, r114)).build());
    L50:
        ImageView r115 = (ImageView) findViewById(R.id.face_return_back);
        if (this.f407485w.isFaceLiveBack() == false) goto L57;
        Drawable r116 = this.f407485w.faceLiveBackImage();
        if (r116 != null) goto L55;
        r116 = getResources().getDrawable(R.mipmap.byted_back_new);
    L55:
        r115.setImageDrawable(r116);
        r115.setOnClickListener(new jsa.j(this));
    L57:
        if (this.f407487y.getCertInfo().f526582p == false) goto L62;
        findViewById(R.id.layout_protocol_logo).setVisibility(0);
        if (this.f407485w.isWebDarkMode() == false) goto L62;
        ((TextView) findViewById(R.id.ima_protocol_label)).setTextColor(ColorProtector.parseColor("#80FFFFFF"));
    L62:
        if (this.f407487y.isOpenLiveOpt() == false) goto L67;
        CircleMotionView r117 = (CircleMotionView) findViewById(R.id.liveness_opt_circle_motion_view);
        this.f407468f = r117;
        r117.setVisibility(0);
        i.i(this.f407468f, this.B, r109, false);
        if (this.f407485w.faceLiveProgressWidth() <= 0.0f) goto L66;
        this.f407468f.setProgressLineWidth(this.f407485w.faceLiveProgressWidth());
    L86:
        K1(r109);
        LiveInfo r118 = this.f407487y.getLiveInfo();
        if (r118 != null) goto L89;
    L93:
        GLSurfaceView r119 = (GLSurfaceView) findViewById(R.id.id_gl_sv);
        this.f407483u = r119;
        r119.setZOrderOnTop(false);
        this.f407483u.setZOrderMediaOverlay(false);
        i.i(this.f407483u, this.B, r109, false);
        this.f407471i = (RelativeLayout) findViewById(R.id.face_bg);
        this.f407480r = (ImageView) findViewById(R.id.iv_face_bg);
        this.f407481s = (ImageView) findViewById(R.id.iv_wb_mask);
        this.f407482t = (ImageView) findViewById(R.id.iv_lost_face_mask);
        float r120 = i.d(this);
        ViewGroup.LayoutParams r121 = this.f407482t.getLayoutParams();
        int r122 = (int) ((r120 * 2.0f) - i.b(this, 50.0f));
        if (r121 != null) goto L96;
        r121 = new RelativeLayout.LayoutParams(r122, r122);
    L97:
        this.f407482t.setLayoutParams(r121);
        i.i(this.f407482t, this.B, r109, false);
        i.i(this.f407481s, this.B, r109, false);
        this.f407470h = (RelativeLayout) findViewById(R.id.bar);
        CircleInsideBgView r123 = (CircleInsideBgView) findViewById(R.id.circle_inside_bg_view);
        this.f407469g = r123;
        i.i(r123, this.B, r109, false);
        this.f407466d = (FrameLayout) findViewById(R.id.id_preview_layout);
        Y0(this.f407485w.faceLiveScreenBgColor());
        if (BytedCertSdkManager.getInstance().isLocalTest() == true) goto L100;
    L103:
        this.f407487y.onInitModuleEnd(FaceLiveInitDurationHelper.Module.INIT_UI, true);
        this.f407486x.h();
        this.f407486x.r(this.f407483u, this.C);
        if (BytedCertSdkManager.getInstance().isLocalTest() == false) goto L123;
        WindowManager r124 = (WindowManager) getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r125 = new DisplayMetrics();
        r124.getDefaultDisplay().getMetrics(r125);
        int r126 = r125.widthPixels;
        int r127 = r125.heightPixels;
        int r128 = Math.min(r126, r127);
        int r129 = Math.max(r126, r127);
        M1("\n圆框半径比例：" + (this.A / r128));
        M1("相对屏幕中心的竖直偏移：" + (r109 / ((float) r129)));
        WindowManager r130 = (WindowManager) getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r131 = new DisplayMetrics();
        r130.getDefaultDisplay().getMetrics(r131);
        int r132 = r131.densityDpi;
        if (r132 < 640) goto L109;
        String r133 = "xxxhdpi";
    L121:
        M1("dpi：".concat(r133));
        M1("\n");
        return;
    L109:
        if (r132 < 480) goto L112;
        r133 = "xxhdpi";
        goto L121
    L112:
        if (r132 < 240) goto L115;
        r133 = "hdpi";
        goto L121
    L115:
        if (r132 < 160) goto L118;
        r133 = "mdpi";
        goto L121
    L118:
        if (r132 < 120) goto L120;
        r133 = "ldpi";
        goto L121
    L120:
        r133 = "unknown";
        goto L121
    L123:
        return;
    L100:
        if (this.f407479q != null) goto L102;
        this.f407479q = new StringBuilder("new mvp ui\n");
    L102:
        this.f407476n = (TextView) findViewById(R.id.tv_debug_info);
        this.f407478p = (ScrollView) findViewById(R.id.sv_debug_info_layout);
        this.f407476n.setVisibility(0);
        this.f407476n.setText(this.f407479q.toString());
        Button r134 = (Button) findViewById(R.id.btn_debug);
        r134.setVisibility(0);
        r134.setOnClickListener(new h());
        goto L103
    L96:
        r121.width = r122;
        r121.height = r122;
        goto L97
    L89:
        if (r118.f407586k == false) goto L91;
    L92:
        ImageView r135 = (ImageView) findViewById(R.id.face_voice_switch);
        r135.setVisibility(0);
        G1(r135, r118.f407587l);
        r135.setOnClickListener(new jsa.l(this, r118, r135));
        goto L93
    L91:
        if (this.f407487y.getCertInfo().F == false) goto L93;
    L66:
        this.f407468f.setProgressLineWidth(i.b(this, 2.0f));
        goto L86
    L67:
        CountDownButton r136 = (CountDownButton) findViewById(R.id.countdown2);
        this.f407467e = r136;
        r136.setVisibility(0);
        i.i(this.f407467e, this.B, r109, false);
        this.f407467e.setOnSizeChangedListener(new jsa.k(this, r109));
        if (this.f407485w.faceLiveProgressWidth() <= 0.0f) goto L70;
        this.f407467e.setProgressLineWidth(this.f407485w.faceLiveProgressWidth());
    L72:
        if (this.f407485w.faceLiveProgressGap() <= 0.0f) goto L75;
        this.f407467e.setProgressGap(this.f407485w.faceLiveProgressGap());
    L75:
        if (this.f407467e.getProgressColor() != (-1)) goto L78;
        this.f407467e.setProgressColor(this.f407485w.faceLiveProgressColor());
    L78:
        if (this.f407467e.getProgressBgColor() != (-1)) goto L80;
        this.f407467e.setProgressBgColor(this.f407485w.faceLiveProgressBgColor());
    L80:
        LiveInfo r137 = this.f407487y.getLiveInfo();
        if (r137 == null) goto L84;
        int r138 = r137.f407577b;
        CountDownButton r139 = this.f407467e;
        float r140 = r138;
        r139.f407757p = r140;
        r139.f407758q = r140;
        r139.postInvalidate();
        CountDownButton r141 = this.f407467e;
        r141.f407758q = r140;
        r141.postInvalidate();
    L84:
        if (this.f407487y.getCertInfo().H == false) goto L86;
        this.f407467e.setProgressGap(i.b(this, 5.0f));
        this.f407467e.setProgressLineWidth(i.b(this, 5.0f));
        this.f407467e.setAngleHole(0);
        this.f407467e.setDash(true);
        this.f407467e.setProgressBgColor(FakePickerAvatarCreator.LTGRAY);
        CountDownButton r142 = this.f407467e;
        int[] r143 = {ColorProtector.parseColor("#00ddff"), ColorProtector.parseColor("#2f7cf6"), ColorProtector.parseColor("#00ddff")};
        r142.f407765x = true;
        r142.f407752k = r143;
        goto L86
    L70:
        this.f407467e.setProgressLineWidth(i.b(this, 4.0f));
        goto L72
    L44:
        r112 = false;
        goto L45
    L39:
        if (this.f407488z <= r108) goto L41;
    L25:
        if (TextUtils.equals(BytedCertConstant.LiveType.LIVE_TYPE_MOTION_WITH_REFLECTION, r106.f407582g) == false) goto L32;
        if (r111 < 24) goto L32;
        r105.f407348b.onInitModuleStart(FaceLiveInitDurationHelper.Module.CHECK_MULTI_WINDOW);
        if (isInMultiWindowMode() == false) goto L31;
        CertLog.e("FaceDetectFlow", "onCreate: is in multi window mode");
        r105.e(new BDResponse(ErrorConstant.Client.ERROR_MULTI_WINDOW), false);
        r105.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.CHECK_MULTI_WINDOW, false);
        r107 = true;
        goto L33
    L31:
        r105.f407348b.onInitModuleEnd(FaceLiveInitDurationHelper.Module.CHECK_MULTI_WINDOW, true);
        goto L32
    }

    public final void G1(ImageView r100, boolean r101) {
        if (r101 == false) goto L8;
        if (this.f407485w.isWebDarkMode() == false) goto L6;
        r100.setImageResource(R.mipmap.byted_cert_voice_on_dark);
        return;
    L6:
        r100.setImageResource(R.mipmap.byted_cert_voice_on);
        return;
    L8:
        if (this.f407485w.isWebDarkMode() == false) goto L10;
        r100.setImageResource(R.mipmap.byted_cert_voice_off_dark);
        return;
    L10:
        r100.setImageResource(R.mipmap.byted_cert_voice_off);
    }

    @Override // isa.a
    public final void T(String r100, int r101, int r102) {
        if (B1() == false) goto L6;
        return;
    L6:
        if (this.f407475m != null) goto L8;
        return;
    L8:
        if (this.f407487y.isOpenLiveOpt() == false) goto L12;
        runOnUiThread(new e(this, r101, r102, r100));
        return;
    }

    @Override // isa.a
    public final void b1(byte[] r100, int r101, int r102) {
        if (B1() == false) goto L5;
        return;
    L5:
        ImageView r103 = this.f407481s;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.getVisibility() == 0) goto L13;
        byte[] r104 = new byte[r100.length];
        System.arraycopy(r100, 0, r104, 0, r100.length);
        runOnUiThread(new g(this, r101, r102, r104));
        return;
    }

    @Override // isa.a
    public final void s0(String r100, String r101, int r102) {
        com.ss.android.bytedcert.face.c r103 = this.f407486x;
        if (r103 == null) goto L6;
        r103.p(r100, r101, r102);
        return;
    }
}
