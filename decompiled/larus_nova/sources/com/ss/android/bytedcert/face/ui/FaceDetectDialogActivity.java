package com.ss.android.bytedcert.face.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
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
import com.ss.android.bytedcert.view.RoundedRectangleImageView;
import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class FaceDetectDialogActivity extends BytedCertSdkAbsActivity implements isa.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f407433x = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f407434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GLSurfaceView f407435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ss.android.bytedcert.face.c f407436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f407437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FaceDetectFlow f407438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f407439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f407440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f407441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f407442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f407443m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f407444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f407445o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f407446p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f407447q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f407448r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f407449s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RoundedRectangleImageView f407450t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<Animator> f407451u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f407452v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f407453w;

    public class a implements vsa.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C4715a f407454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FaceDetectDialogActivity f407455b;

        /* JADX INFO: renamed from: com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity$a$a, reason: collision with other inner class name */
        public class C4715a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f407456a;

            public C4715a(a r100) {
                this.f407456a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Object r101 = this.f407456a.f407455b.f407452v;
                monitor-enter(r101);
                ((ArrayList) this.f407456a.f407455b.f407451u).add(r100);     // Catch: Throwable -> L7
                monitor-exit(r101);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public a(FaceDetectDialogActivity r100) {
            this.f407455b = r100;
            this.f407454a = new C4715a(this);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ isa.c f407457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FaceDetectDialogActivity f407458b;

        public class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f407459a;

            public a(b r100) {
                this.f407459a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                FaceDetectDialogActivity r101 = this.f407459a.f407458b;
                r101.f407446p.clearColorFilter();
                r101.f407447q.clearColorFilter();
                r101.f407448r.clearColorFilter();
                r101.f407449s.clearColorFilter();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Object r101 = this.f407459a.f407458b.f407452v;
                monitor-enter(r101);
                ((ArrayList) this.f407459a.f407458b.f407451u).add(r100);     // Catch: Throwable -> L7
                monitor-exit(r101);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity$b$b, reason: collision with other inner class name */
        public class C4716b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f407460a;

            public C4716b(b r100) {
                this.f407460a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r100) {
                Object r101 = this.f407460a.f407458b.f407452v;
                monitor-enter(r101);
                ((ArrayList) this.f407460a.f407458b.f407451u).add(r100);     // Catch: Throwable -> L7
                monitor-exit(r101);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public final void a() {
            FaceDetectDialogActivity r100 = this.f407458b;
            int r101 = FaceDetectDialogActivity.f407433x;
            if (r100.B1() == false) goto L5;
            return;
        L5:
            isa.c r102 = this.f407457a;
            int r103 = r102.f495703d;
            if (r103 != 103) goto L8;
        L20:
            this.f407458b.f407434d.setText(R.string.byted_face_dialog_detect_prompt_show_face);
            FaceDetectDialogActivity.G1(this.f407458b, -65536);
            View r104 = this.f407458b.f407445o;
            a r105 = new a(this);
            AnimatorSet r106 = new AnimatorSet();
            ArrayList r107 = new ArrayList();
            ObjectAnimator r108 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, 0.0f});
            r108.setDuration(17);
            r108.setInterpolator(new vsa.a(0.42f, 0.58f));
            r107.add(r108);
            ObjectAnimator r109 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, -11.25f});
            r109.setDuration(166);
            r109.setInterpolator(new vsa.a(0.42f, 0.58f));
            r107.add(r109);
            ObjectAnimator r110 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{-11.25f, 11.25f});
            r110.setDuration(152);
            r110.setInterpolator(new vsa.a(0.42f, 0.58f));
            r107.add(r110);
            ObjectAnimator r111 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{11.25f, -5.0f});
            r111.setDuration(166);
            r111.setInterpolator(new vsa.a(0.42f, 0.58f));
            r107.add(r111);
            ObjectAnimator r112 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{-5.0f, 5.0f});
            r112.setDuration(151);
            r112.setInterpolator(new vsa.a(0.42f, 0.58f));
            r107.add(r112);
            ObjectAnimator r113 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{5.0f, 0.0f});
            r113.setDuration(166);
            r113.setInterpolator(new vsa.a(0.42f, 0.58f));
            r107.add(r113);
            ObjectAnimator r114 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, 0.0f});
            r114.setDuration(17);
            r114.setInterpolator(new LinearInterpolator());
            r107.add(r114);
            r106.playSequentially(r107);
            r106.addListener(new vsa.b(r104, r105));
            r106.start();
            return;
        L8:
            if (r103 == 106) goto L20;
            if (r103 == 111) goto L20;
            if (r102.f495701b != 3) goto L19;
            if (r103 != 0) goto L19;
            FaceDetectDialogActivity r115 = this.f407458b;
            r115.f407437g = true;
            if (r115.f407439i == false) goto L18;
            r115.f407434d.setText(R.string.byted_face_dialog_detect_prompt_detecting);
            return;
        L18:
            r115.f407434d.setText(null);
            FaceDetectDialogActivity.G1(this.f407458b, FakePickerAvatarCreator.GREEN);
            this.f407458b.f407444n.setAlpha(1.0f);
            this.f407458b.f407444n.setScaleX(2.5f);
            this.f407458b.f407444n.setScaleY(2.5f);
            FaceDetectDialogActivity r116 = this.f407458b;
            r116.f407444n.setImageDrawable(r116.getResources().getDrawable(R.mipmap.byted_face_success));
            vsa.c.b(this.f407458b.f407444n, new C4716b(this));
            return;
        L19:
            this.f407458b.f407434d.setText(R.string.byted_face_dialog_detect_prompt_detecting);
            FaceDetectDialogActivity r117 = this.f407458b;
            r117.f407446p.clearColorFilter();
            r117.f407447q.clearColorFilter();
            r117.f407448r.clearColorFilter();
            r117.f407449s.clearColorFilter();
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

        public b(FaceDetectDialogActivity r100, isa.c r101) {
            this.f407458b = r100;
            this.f407457a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f407461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f407462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f407463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FaceDetectDialogActivity f407464d;

        public final void a() {
            Bitmap r100 = Bitmap.createBitmap(this.f407461a, this.f407462b, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L5
            r100.copyPixelsFromBuffer(ByteBuffer.wrap(this.f407463c));     // Catch: Exception -> L5
            int r101 = (r100.getWidth() - 360) / 2;     // Catch: Exception -> L5
            int r102 = (r100.getHeight() - 360) / 2;     // Catch: Exception -> L5
            Bitmap r103 = Bitmap.createBitmap(r100, Math.max(r101, 0), Math.max(r102, 0), 360, 360);     // Catch: Exception -> L5
            r100.recycle();     // Catch: Exception -> L5
            Bitmap r104 = rsa.a.a(this.f407464d.getApplicationContext(), r103);     // Catch: Exception -> L5
            r103.recycle();     // Catch: Exception -> L5
            FaceDetectDialogActivity r105 = this.f407464d;
            r105.f407450t.setCornerRadius(i.b(r105.getApplicationContext(), 10.0f));
            this.f407464d.f407450t.setImageBitmap(r104);
            this.f407464d.f407450t.setVisibility(0);
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

        public c(FaceDetectDialogActivity r100, int r101, int r102, byte[] r103) {
            this.f407464d = r100;
            this.f407461a = r101;
            this.f407462b = r102;
            this.f407463c = r103;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FaceDetectDialogActivity f407465a;

        @Override // java.lang.Runnable
        public final void run() {
            RoundedRectangleImageView r100 = this.f407465a.f407450t;     // Catch: Throwable -> L6
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

        public d(FaceDetectDialogActivity r100) {
            this.f407465a = r100;
        }
    }

    @Override // isa.b
    public final void D0() {
    }

    @Override // isa.a
    public final void T(String r100, int r101, int r102) {
    }

    @Override // isa.a
    public final void Y0(int r100) {
    }

    @Override // isa.a
    public final void e1(long r100) {
    }

    @Override // isa.a
    public final void f0(int r100) {
    }

    @Override // isa.a, isa.b
    public Activity getActivity() {
        return this;
    }

    @Override // isa.b
    public final void r0() {
    }

    @Override // isa.a
    public final void v(String r100) {
    }

    public final void H1() {
        Object r100 = this.f407452v;
        monitor-enter(r100);
        int r101 = ((ArrayList) this.f407451u).size() - 1;     // Catch: Throwable -> L15
    L5:
        if (r101 < 0) goto L12;
        Animator r102 = (Animator) ((ArrayList) this.f407451u).get(r101);     // Catch: Throwable -> L15
        if (r102 == null) goto L11;
        if (r102.isRunning() == false) goto L11;
        r102.cancel();     // Catch: Throwable -> L15
    L11:
        r101 = r101 - 1;     // Catch: Throwable -> L15
        goto L5
    L12:
        ((ArrayList) this.f407451u).clear();     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // isa.a
    public final void Q0() {
        com.ss.android.bytedcert.face.c r100 = this.f407436f;
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // isa.a
    public final void T0() {
        bsa.a r100 = this.f407436f.f407350d;
        if (r100 == null) goto L6;
        r100.g(CameraFactory$WhiteBalanceType.NONE);
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        com.ss.android.bytedcert.face.c r100 = this.f407436f;
        if (r100 == null) goto L6;
        r100.i(true, null);
        return;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        com.ss.android.bytedcert.face.c r100 = this.f407436f;
        if (r100 == null) goto L9;
        r100.j();
        return;
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity
    public final ICertDialogDepend z1() {
        FaceDetectFlow r100 = this.f407438h;
        if (r100 == null) goto L5;
        ICertDialogDepend r101 = r100.getCertDialogDepend();
        if (r101 == null) goto L9;
        return r101;
    L9:
        return super.z1();
    L5:
        return super.z1();
    }

    public FaceDetectDialogActivity() {
        this.f407437g = false;
        this.f407439i = true;
        this.f407451u = new ArrayList();
        this.f407452v = new Object();
        this.f407453w = new a(this);
    }

    @Override // isa.b
    public final void V0() {
        if (B1() == false) goto L5;
        return;
    L5:
        RoundedRectangleImageView r100 = this.f407450t;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.getVisibility() != 0) goto L12;
        runOnUiThread(new d(this));
        return;
    }

    /* JADX INFO: Removed unreachable split cross block B:58:0x0126 */
    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        super.hideLoading();
        H1();
        Intent r100 = getIntent();
        if (r100 == null) goto L8;
        if (r100.getBooleanExtra("without_animation", false) == false) goto L8;
        overridePendingTransition(0, 0);
    L8:
        if ((this instanceof ChatWindowActivity) == true) goto L49;
        FLogger r101 = FLogger.f375446a;
        r101.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r102 = SystemClock.uptimeMillis();
        Map<Activity, Long> r103 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r103);
        Long r104 = r103.get(this);     // Catch: Throwable -> L50
        if (r104 != null) goto L15;
    L18:
        r103.put(this, Long.valueOf(r102));     // Catch: Throwable -> L50
        monitor-exit(r103);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L55:
        return;
    L21:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L24;
        r101.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        goto L55
    L24:
        if (isFinishing() == true) goto L27;
        r101.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        goto L55
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L30;
        r101.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        goto L55
    L30:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L33;
        r101.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        goto L55
    L33:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L36;
        r101.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        goto L55
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        goto L55
    L38:
        Intent r105 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L47
        if (r105 == null) goto L55;
        r105.addFlags(268435456);     // Catch: Throwable -> L47
        r105.addFlags(2097152);     // Catch: Throwable -> L47
        r101.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L47
        startActivity(r105);     // Catch: Throwable -> L44
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        goto L55
    L15:
        if ((r102 - r104.longValue()) >= 800) goto L18;
        monitor-exit(r103);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    }

    @Override // isa.a
    public final void m() {
        if (B1() == false) goto L5;
        return;
    L5:
        this.f407436f.l();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        com.ss.android.bytedcert.face.c r100 = this.f407436f;
        if (r100 == null) goto L6;
        r100.o();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (isFinishing() == false) goto L5;
        return;
    L5:
        com.ss.android.bytedcert.face.c r100 = this.f407436f;
        if (r100 == null) goto L8;
        r100.r(this.f407435e, null);
        this.f407436f.t(getIntent().getExtras());
    L8:
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("page", "resume", null)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("page", "back", null)));
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        F1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @Override // isa.b
    public final void s() {
        findViewById(R.id.activity_main).setVisibility(8);
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, isa.b
    public final void hideLoading() {
        super.hideLoading();
    }

    public static View F1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // isa.b
    public final void C0(int r100) {
        com.ss.android.bytedcert.face.c r101 = this.f407436f;
        if (r101 == null) goto L6;
        r101.q();
        return;
    }

    @Override // isa.a
    public final void a0(isa.c r100) {
        if (B1() == false) goto L5;
        return;
    L5:
        if (this.f407434d == null) goto L10;
        CertLog.d("FaceDetectFlow", "updateTaskPrompt: " + r100.f495700a);
        runOnUiThread(new b(this, r100));
        return;
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

    public static void G1(FaceDetectDialogActivity r100, int r101) {
        r100.f407446p.setColorFilter(r101, PorterDuff.Mode.SRC_IN);
        r100.f407447q.setColorFilter(r101, PorterDuff.Mode.SRC_IN);
        r100.f407448r.setColorFilter(r101, PorterDuff.Mode.SRC_IN);
        r100.f407449s.setColorFilter(r101, PorterDuff.Mode.SRC_IN);
    }

    @Override // com.ss.android.bytedcert.base.BytedCertSdkAbsActivity
    public final void A1(ICertFlow r110, ThemeConfig r111) {
        if ((r110 instanceof FaceDetectFlow) == true) goto L6;
        CertLog.e("FaceDetectFlow", "onCreate: flow is not a FaceDetectFlow:" + r110);
        finish();
        return;
    L6:
        FaceDetectFlow r112 = (FaceDetectFlow) r110;
        this.f407438h = r112;
        int r113 = Build.VERSION.SDK_INT;
        if (r113 == 26) goto L9;
        setRequestedOrientation(1);
    L9:
        setContentView(R.layout.byted_activity_face_detect_dialog_view);
        getWindow().setSoftInputMode(3);
        if (r113 < 29) goto L12;
        getWindow().setNavigationBarContrastEnforced(false);
    L12:
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        if (r113 < 23) goto L15;
        int r100 = 9216;
    L16:
        F1(getWindow()).setSystemUiVisibility(r100 | 512);
        if (r113 < 28) goto L19;
        WindowManager.LayoutParams r114 = getWindow().getAttributes();
        r114.layoutInDisplayCutoutMode = 1;
        r114.width = -1;
        r114.height = -1;
        getWindow().setAttributes(r114);
    L19:
        com.ss.android.bytedcert.face.c r115 = new com.ss.android.bytedcert.face.c(this, r112);
        this.f407436f = r115;
        if (r115.u(this) == false) goto L24;
        onBackPressed();
        return;
    L24:
        if (r112.getLiveInfo() != null) goto L27;
        CertLog.e("FaceDetectFlow", "onCreate: live info is null");
        onBackPressed();
        return;
    L27:
        r112.onInitModuleStart(FaceLiveInitDurationHelper.Module.INIT_UI);
        if (r112.getCertInfo().M <= 0) goto L30;
        int r101 = r112.getCertInfo().M;
    L31:
        GLSurfaceView r102 = (GLSurfaceView) findViewById(R.id.id_gl_sv);
        this.f407435e = r102;
        r102.setBackgroundColor(0);
        this.f407435e.getHolder().setFormat(-3);
        this.f407435e.setEGLContextClientVersion(2);
        this.f407435e.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.f407435e.setScaleX(0.001f);
        this.f407435e.setScaleY(0.001f);
        TextView r103 = (TextView) findViewById(R.id.tv_task_board);
        this.f407434d = r103;
        r103.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.f407434d.getPaint().setStrokeWidth(0.5f);
        this.f407434d.setText(R.string.byted_face_dialog_detect_prompt_detecting);
        this.f407450t = (RoundedRectangleImageView) findViewById(R.id.iv_wb_mask);
        this.f407440j = (ImageView) findViewById(R.id.iv_no_face_left_top);
        this.f407441k = (ImageView) findViewById(R.id.iv_no_face_left_bottom);
        this.f407442l = (ImageView) findViewById(R.id.iv_no_face_right_top);
        this.f407443m = (ImageView) findViewById(R.id.iv_no_face_right_bottom);
        this.f407444n = (ImageView) findViewById(R.id.iv_no_face_face_mask);
        this.f407445o = findViewById(R.id.rl_face_subscript);
        this.f407446p = (ImageView) findViewById(R.id.iv_face_left_top);
        this.f407447q = (ImageView) findViewById(R.id.iv_face_left_bottom);
        this.f407448r = (ImageView) findViewById(R.id.iv_face_right_top);
        this.f407449s = (ImageView) findViewById(R.id.iv_face_right_bottom);
        vsa.c.a(this.f407440j, this.f407453w);
        vsa.c.a(this.f407441k, this.f407453w);
        vsa.c.a(this.f407442l, this.f407453w);
        vsa.c.a(this.f407443m, this.f407453w);
        vsa.c.a(this.f407444n, this.f407453w);
        this.f407436f.f407352f.postDelayed(new jsa.b(this), 2000);
        this.f407436f.f407352f.postDelayed(new jsa.c(this), r101);
        r112.onInitModuleEnd(FaceLiveInitDurationHelper.Module.INIT_UI, true);
        this.f407436f.h();
        this.f407436f.r(this.f407435e, null);
        return;
    L30:
        r101 = 10000;
        goto L31
    L15:
        r100 = 1024;
        goto L16
    }

    @Override // isa.a
    public final void b1(byte[] r100, int r101, int r102) {
        if (B1() == false) goto L5;
        return;
    L5:
        if (this.f407439i == true) goto L14;
        RoundedRectangleImageView r103 = this.f407450t;
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.getVisibility() == 0) goto L16;
        byte[] r104 = new byte[r100.length];
        System.arraycopy(r100, 0, r104, 0, r100.length);
        runOnUiThread(new c(this, r101, r102, r104));
        return;
    L16:
        return;
    }

    @Override // isa.a
    public final void s0(String r100, String r101, int r102) {
        com.ss.android.bytedcert.face.c r103 = this.f407436f;
        if (r103 == null) goto L6;
        r103.i(true, ErrorConstant.Client.ERROR_FACE_LIVE_TIMEOUT);
        return;
    }
}
