package com.ss.android.bytedcert.face.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Outline;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class FaceDetectPercentActivity extends FaceDetectFullActivity {
    public static final /* synthetic */ int I = 0;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FaceDetectPercentActivity f407506a;

        public a(FaceDetectPercentActivity r100) {
            this.f407506a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), i.b(this.f407506a, 20.0f));
        }
    }

    @Override // com.ss.android.bytedcert.face.ui.FaceDetectFullActivity
    public final int F1() {
        return 0;
    }

    @Override // com.ss.android.bytedcert.face.ui.FaceDetectFullActivity, com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    @Override // com.ss.android.bytedcert.face.ui.FaceDetectFullActivity
    public final int I1() {
        Intent r100 = getIntent();
        if (r100 != null) goto L7;
        return i.e(this);
    L7:
        return r100.getIntExtra("face_view_height", i.e(this));
    }

    @Override // com.ss.android.bytedcert.face.ui.FaceDetectFullActivity, com.ss.android.bytedcert.base.BytedCertSdkAbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if (D1() == true) goto L7;
        overridePendingTransition(0, R.anim.byted_slide_bottom_out);
    L7:
        if ((this instanceof ChatWindowActivity) == true) goto L60;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L49
        if (r103 != null) goto L14;
    L17:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L49
        monitor-exit(r102);     // Catch: Throwable -> L49
    L46:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L57:
        return;
    L20:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L46
    L52:
        goto L57
    L23:
        if (isFinishing() == true) goto L26;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L46
        goto L52
    L26:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L29;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L46
        goto L52
    L29:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L32;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L46
        goto L52
    L32:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L35;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L46
        goto L52
    L35:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L37;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L46
        goto L52
    L37:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L46
        if (r104 == null) goto L52;
        r104.addFlags(268435456);     // Catch: Throwable -> L46
        r104.addFlags(2097152);     // Catch: Throwable -> L46
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L46
        startActivity(r104);     // Catch: Throwable -> L43
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L46
        goto L52
    L14:
        if ((r101 - r103.longValue()) >= 800) goto L17;
        monitor-exit(r102);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.bytedcert.face.ui.FaceDetectFullActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (D1() == false) goto L5;
        return;
    L5:
        overridePendingTransition(R.anim.byted_slide_bottom_in, 0);
    }

    @Override // com.ss.android.bytedcert.face.ui.FaceDetectFullActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public FaceDetectPercentActivity() {
    }

    public static View N1(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.ss.android.bytedcert.face.ui.FaceDetectFullActivity, com.ss.android.bytedcert.base.BytedCertSdkAbsActivity
    public final void A1(ICertFlow r100, ThemeConfig r101) {
        super.A1(r100, r101);
        setFinishOnTouchOutside(false);
        GLSurfaceView r102 = this.f407483u;
        if (r102 == null) goto L9;
        int r103 = (int) ((-r102.getTranslationY()) - ((I1() - (this.f407483u.getScaleY() * I1())) / 2.0f));
        if (r103 <= 0) goto L9;
        ViewParent r104 = this.f407483u.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r104).setPadding(0, ((int) i.b(this, 12.0f)) + r103, 0, r103 + ((int) i.b(this, 12.0f)));
    L9:
        Window r105 = getWindow();
        if (r105 == null) goto L16;
        r105.setGravity(80);
        WindowManager.LayoutParams r106 = r105.getAttributes();
        r106.width = -1;
        r106.height = I1();
        r105.setAttributes(r106);
        r105.setBackgroundDrawable(getResources().getDrawable(R.drawable.byted_bg_white_r20dp_top));
        if (Build.VERSION.SDK_INT < 22) goto L14;
        r105.setClipToOutline(true);
    L14:
        N1(r105).setOutlineProvider(new a(this));
        N1(r105).setClipToOutline(true);
        return;
    }
}
