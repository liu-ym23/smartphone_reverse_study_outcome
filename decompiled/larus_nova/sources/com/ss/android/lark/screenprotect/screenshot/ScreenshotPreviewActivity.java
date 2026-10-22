package com.ss.android.lark.screenprotect.screenshot;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.screen.protect.databinding.ActivityScreenshotPreviewBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/screenprotect/screenshot/ScreenshotPreviewActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "animator", "Landroid/animation/AnimatorSet;", "lKEventId", "", "binding", "Lcom/ss/android/lark/security/screen/protect/databinding/ActivityScreenshotPreviewBinding;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "startAnimation", "onStop", "dismissWithAnim", "onBackPressed", VideoEventOneOutSync.END_TYPE_FINISH, LiveCommonConstants.REASON_ON_DEDTROY, "isDoAnimationWithDefault", "", "enableGlobalWatermark", "Companion", "screen-protect_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenshotPreviewActivity extends BaseFragmentActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f439799d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f439800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f439801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActivityScreenshotPreviewBinding f439802c;

    public static final class a {
        public a() {
        }

        public final void startActivity(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ScsLogger.d("SHARE_SS_ScreenshotPreviewActivity", "startActivity");
            Intent r102 = new Intent(r100, ScreenshotPreviewActivity.class);
            r102.putExtra("DATA_LK_EVENT_ID", r101);
            if ((r100 instanceof Activity) == true) goto L5;
            r102.addFlags(268435456);
        L5:
            r100.startActivity(r102);
        }
    }

    static {
        f439799d = new a();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.ss.android.lark.base.watermark.IWatermarkable
    public final boolean enableGlobalWatermark() {
        return false;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final boolean isDoAnimationWithDefault() {
        return false;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        AnimatorSet r100 = this.f439800a;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        ScsLogger.d("SHARE_SS_ScreenshotPreviewActivity", "onBackPressed()");
        super.onBackPressed();
        return;
    L11:
        return;
    L5:
        if (r100.isRunning() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ScreenshotPreviewActivity.class.getName()));
    L5:
        ScsLogger.d("SHARE_SS_ScreenshotPreviewActivity", LiveCommonConstants.REASON_ON_DEDTROY);
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        AnimatorSet r100 = this.f439800a;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isRunning() != true) goto L7;
    L8:
        if (r101 == false) goto L12;
        AnimatorSet r102 = this.f439800a;
        if (r102 == null) goto L12;
        r102.cancel();
    L12:
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L19;
        z1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r101 = false;
        goto L8
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x010f */
    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ScreenshotPreviewActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
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
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
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

    public ScreenshotPreviewActivity() {
    }

    public static View z1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        overridePendingTransition(0, 0);
        disableColorNavigationBarBeforeOnCreate();
        super.onCreate(r110);
        ScsLogger.d("SHARE_SS_ScreenshotPreviewActivity", WidgetCostModule.TYPE_ON_CREATE);
        getWindow().setStatusBarColor(0);
        getWindow().setWindowAnimations(0);
        ActivityScreenshotPreviewBinding r100 = null;
        View r111 = getLayoutInflater().inflate(com.larus.nova.R.layout.activity_screenshot_preview, null, false);
        int r101 = com.larus.nova.R.id.coverView;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.coverView);
        if (r102 == null) goto L52;
        r101 = com.larus.nova.R.id.imageView;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.imageView);
        if (r103 == null) goto L52;
        r101 = com.larus.nova.R.id.previewContainer;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.previewContainer);
        if (r104 == null) goto L52;
        ConstraintLayout r112 = (ConstraintLayout) r111;
        this.f439802c = new ActivityScreenshotPreviewBinding(r112, r102, r103, r104);
        setContentView(r112);
        int r113 = getIntent().getIntExtra("DATA_LK_EVENT_ID", 0);
        this.f439801b = r113;
        ShareScreenshotUtil r105 = ShareScreenshotUtil.f439806a;
        ShareScreenshotUtil.b r114 = (ShareScreenshotUtil.b) ((LinkedHashMap) ShareScreenshotUtil.f439807b).get(Integer.valueOf(r113));
        if (r114 == null) goto L21;
        SoftReference<Bitmap> r115 = r114.f439811b;
        if (r115 == null) goto L21;
        Bitmap r116 = r115.get();
    L22:
        if (r116 != null) goto L24;
        ShareScreenshotUtil.g(this.f439801b);
        finish();
        return;
    L24:
        ActivityScreenshotPreviewBinding r106 = this.f439802c;
        if (r106 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L27:
        r106.f440491c.setImageBitmap(r116);
        Bitmap r117 = Bitmap.createBitmap(r116.getWidth(), r116.getHeight(), Bitmap.Config.RGB_565);
        Canvas r107 = new Canvas(r117);
        r107.drawColor(-1);
        r107.setBitmap(null);
        ActivityScreenshotPreviewBinding r108 = this.f439802c;
        if (r108 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L30:
        r108.f440490b.setImageBitmap(r117);
        this.f439800a = new AnimatorSet();
        ActivityScreenshotPreviewBinding r118 = this.f439802c;
        if (r118 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L33:
        ObjectAnimator r119 = ObjectAnimator.ofFloat(r118.f440490b, "alpha", new float[]{1.0f, 0.0f});
        r119.setDuration(300);
        r119.setStartDelay(300);
        ActivityScreenshotPreviewBinding r109 = this.f439802c;
        if (r109 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L36:
        ObjectAnimator r120 = ObjectAnimator.ofFloat(r109.f440492d, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.6f});
        r120.setDuration(600);
        r120.setInterpolator(new DecelerateInterpolator());
        ActivityScreenshotPreviewBinding r121 = this.f439802c;
        if (r121 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L39:
        ObjectAnimator r122 = ObjectAnimator.ofFloat(r121.f440492d, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.6f});
        r122.setDuration(600);
        r122.setInterpolator(new DecelerateInterpolator());
        r122.addUpdateListener(new i(this));
        AnimatorSet r123 = this.f439800a;
        if (r123 == null) goto L42;
        r123.playTogether(new Animator[]{r119, r120, r122});
    L42:
        AnimatorSet r124 = this.f439800a;
        if (r124 == null) goto L45;
        r124.addListener(new c(this));
    L45:
        ActivityScreenshotPreviewBinding r125 = this.f439802c;
        if (r125 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L49:
        r100.f440492d.postDelayed(new h(this), 100);
        return;
    L48:
        r100 = r125;
    L21:
        r116 = null;
    L52:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r101)));
    }
}
