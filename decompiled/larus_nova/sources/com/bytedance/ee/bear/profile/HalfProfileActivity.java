package com.bytedance.ee.bear.profile;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lark.databinding.ActivityHalfProfileBinding;
import com.bytedance.ee.bear.lark.dependency.c0;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0018J\b\u0010\u001f\u001a\u00020\u0018H\u0003J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0007H\u0002J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0018H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\b\u0010/\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/profile/HalfProfileActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "maxHeight", "", "isNightMode", "", "isLandscape", "binding", "Lcom/bytedance/ee/bear/lark/databinding/ActivityHalfProfileBinding;", "dragView", "Lcom/bytedance/ee/bear/profile/HalfProfileDragView;", "profilePageController", "Lcom/ss/android/lark/profile_api/IProfilePageController;", "isProfileReachTop", "onTouchEventIntercept", "Landroid/view/View$OnTouchListener;", "gestureDetector", "Landroid/view/GestureDetector;", "isDispatchingActivityBackPressed", "profileFragmentInitialPadding", "", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "compatOrientation", "initDragView", "notifyFullScreenStatus", "enter", "autoSlide", "updateProfileFragmentStatusBarPadding", "enterFullScreen", "slideToTargetHeight", "targetHeight", "", "duration", "", VideoEventOneOutSync.END_TYPE_FINISH, "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onBackPressed", "getMidHeight", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
public final class HalfProfileActivity extends Hilt_HalfProfileActivity {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f236243q = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f236244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f236245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f236246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ActivityHalfProfileBinding f236247i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j f236248j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public r1c.a f236249k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f236250l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.ee.bear.profile.e f236251m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public GestureDetector f236252n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f236253o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f236254p;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HalfProfileActivity f236255a;

        public b(HalfProfileActivity r100) {
            this.f236255a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j r100 = this.f236255a.f236248j;     // Catch: Throwable -> L10
            if (r100 == null) goto L5;
            r100.o();     // Catch: Throwable -> L10
        L5:
            HalfProfileActivity r101 = this.f236255a;     // Catch: Throwable -> L10
            j r102 = r101.f236248j;     // Catch: Throwable -> L10
            if (r102 == null) goto L8;
            r102.l(r101.f236244f * 0.87f);     // Catch: Throwable -> L10
        L8:
            this.f236255a.C1();     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HalfProfileActivity f236256a;

        public c(HalfProfileActivity r100) {
            this.f236256a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            HalfProfileActivity r101 = this.f236256a;
            Intent r102 = new Intent();
            r102.putExtra("is_confirm", true);
            Unit r103 = Unit.INSTANCE;
            r101.setResult(-1, r102);
            this.f236256a.finish();
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HalfProfileActivity f236257a;

        public d(HalfProfileActivity r100) {
            this.f236257a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f236257a.finish();
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HalfProfileActivity f236258a;

        public e(HalfProfileActivity r100) {
            this.f236258a = r100;
        }

        public final void a() {
            ActivityHalfProfileBinding r100 = this.f236258a.f236247i;
            ActivityHalfProfileBinding r101 = null;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r100 = null;
        L5:
            VerticalScrollInterceptLayout r102 = r100.f227339e;
            if (r102 == null) goto L8;
            r102.setVisibility(0);
        L8:
            ActivityHalfProfileBinding r103 = this.f236258a.f236247i;
            if (r103 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L12:
            r101.f227343i.setVisibility(0);
            j r104 = this.f236258a.f236248j;
            if (r104 == null) goto L15;
            r104.o();
        L15:
            HalfProfileActivity r105 = this.f236258a;
            if (r105.f236246h == false) goto L19;
            r105.C1();
            return;
        L19:
            return;
        L11:
            r101 = r103;
            goto L12
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
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        this.f236253o = true;
        super.onBackPressed();     // Catch: Throwable -> L6
        this.f236253o = false;
        return;
    L6:
        th = move-exception;
        this.f236253o = false;
        throw th;
    }

    public final void C1() {
        ActivityHalfProfileBinding r100 = this.f236247i;
        ActivityHalfProfileBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        VerticalScrollInterceptLayout r102 = r100.f227339e;
        if (r102 == null) goto L8;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
    L10:
        if (this.f236246h == true) goto L12;
        if (r103 == null) goto L16;
        r103.width = -1;
    L16:
        ActivityHalfProfileBinding r104 = this.f236247i;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L20:
        VerticalScrollInterceptLayout r105 = r101.f227339e;
        if (r105 == null) goto L24;
        r105.setLayoutParams(r103);
        return;
    L24:
        return;
    L19:
        r101 = r104;
        goto L20
    L12:
        if ((r103 instanceof LinearLayout.LayoutParams) == false) goto L16;
        ((LinearLayout.LayoutParams) r103).width = (int) (cu5.c.d() * 0.7f);
        goto L16
    L8:
        r103 = null;
        goto L10
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    @Override // com.bytedance.ee.bear.profile.Hilt_HalfProfileActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(HalfProfileActivity.class.getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.profile.Hilt_HalfProfileActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(HalfProfileActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public HalfProfileActivity() {
        this.f236244f = com.bytedance.ee.util.ui.n.t();
        this.f236245g = h18.f.a(eu5.b.f474075a);
        this.f236250l = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r210) {
        this.f236245g = h18.f.b(getResources().getConfiguration());
        this.f236246h = cu5.c.e(this);
        ActivityHalfProfileBinding r100 = null;
        View r101 = getLayoutInflater().inflate(com.larus.nova.R.layout.activity_half_profile, null, false);
        int r102 = com.larus.nova.R.id.content;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r101, com.larus.nova.R.id.content);
        if (r110 == null) goto L109;
        r102 = com.larus.nova.R.id.invite;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r101, com.larus.nova.R.id.invite);
        if (r111 == null) goto L109;
        r102 = com.larus.nova.R.id.invite_banner;
        LinearLayout r112 = (LinearLayout) ViewBindings.findChildViewById(r101, com.larus.nova.R.id.invite_banner);
        if (r112 == null) goto L109;
        r102 = com.larus.nova.R.id.invite_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r101, com.larus.nova.R.id.invite_icon)) == null) goto L109;
        r102 = com.larus.nova.R.id.profile_container;
        VerticalScrollInterceptLayout r113 = (VerticalScrollInterceptLayout) ViewBindings.findChildViewById(r101, com.larus.nova.R.id.profile_container);
        if (r113 == null) goto L109;
        FrameLayout r114 = (FrameLayout) ViewBindings.findChildViewById(r101, com.larus.nova.R.id.profile_fragment);
        if (r114 == null) goto L107;
        r102 = com.larus.nova.R.id.profile_panel;
        FrameLayout r115 = (FrameLayout) ViewBindings.findChildViewById(r101, com.larus.nova.R.id.profile_panel);
        if (r115 == null) goto L109;
        FrameLayout r103 = (FrameLayout) r101;
        View r116 = ViewBindings.findChildViewById(r101, com.larus.nova.R.id.shadow);
        if (r116 == null) goto L106;
        View r211 = ViewBindings.findChildViewById(r101, com.larus.nova.R.id.top_divider);
        if (r211 == null) goto L105;
        this.f236247i = new ActivityHalfProfileBinding(r103, r110, r111, r112, r113, r114, r115, r103, r116, r211);
        setContentView(r103);
        getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, com.larus.nova.R.color.bg_mask)));
        getWindow().setExitTransition(null);
        StatusBarUtil.setTransparent(this);
        ActivityHalfProfileBinding r104 = this.f236247i;
        if (r104 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L23:
        TextView r105 = r104.f227337c;
        if (r105 == null) goto L26;
        r105.setOnClickListener(new c(this));
    L26:
        String r106 = getIntent().getStringExtra("content");
        if (r106 == null) goto L34;
        ActivityHalfProfileBinding r107 = this.f236247i;
        if (r107 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L31:
        TextView r108 = r107.f227336b;
        if (r108 == null) goto L34;
        r108.setText(r106);
    L34:
        String r109 = getIntent().getStringExtra("confirmText");
        if (r109 == null) goto L42;
        ActivityHalfProfileBinding r117 = this.f236247i;
        if (r117 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L39:
        TextView r118 = r117.f227337c;
        if (r118 == null) goto L42;
        r118.setText(r109);
    L42:
        ActivityHalfProfileBinding r119 = this.f236247i;
        if (r119 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L45:
        r119.f227342h.setOnClickListener(new d(this));
        ActivityHalfProfileBinding r120 = this.f236247i;
        if (r120 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r120 = null;
    L48:
        VerticalScrollInterceptLayout r121 = r120.f227339e;
        if (r121 == null) goto L51;
        r121.addOnLayoutChangeListener(new com.bytedance.ee.bear.profile.a(this));
    L51:
        ActivityHalfProfileBinding r122 = this.f236247i;
        if (r122 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r122 = null;
    L54:
        VerticalScrollInterceptLayout r123 = r122.f227339e;
        if (r123 == null) goto L57;
        r123.setDelegate(new com.bytedance.ee.bear.profile.b(this));
    L57:
        ActivityHalfProfileBinding r124 = this.f236247i;
        if (r124 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r124 = null;
    L60:
        VerticalScrollInterceptLayout r125 = r124.f227339e;
        int r126 = this.f236244f;
        float r127 = 0.87f * r126;
        float r128 = r126;
        View[] r129 = new View[1];
        ActivityHalfProfileBinding r130 = this.f236247i;
        if (r130 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r130 = null;
    L63:
        r129[0] = r130.f227343i;
        j r131 = new j(this, r125, r127, r128, CollectionsKt.arrayListOf(r129));
        this.f236248j = r131;
        r131.f226587b = 0.5f;
        r131.f226586a = 0.5f;
        ActivityHalfProfileBinding r132 = this.f236247i;
        if (r132 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r132 = null;
    L66:
        r131.i(r132.f227339e);
        r131.f226597l = true;
        r131.l(1.0f);
        r131.f226593h = new com.bytedance.ee.bear.profile.c(r131, this);
        this.f236252n = new GestureDetector(this, new com.bytedance.ee.bear.profile.d(this));
        com.bytedance.ee.bear.profile.e r133 = new com.bytedance.ee.bear.profile.e(this);
        this.f236251m = r133;
        j r134 = this.f236248j;
        if (r134 == null) goto L69;
        r134.f226600o = r133;
    L69:
        String r135 = getIntent().getStringExtra("userId");
        String r136 = "";
        if (r135 != null) goto L72;
        r135 = "";
    L72:
        String r137 = getIntent().getStringExtra("title");
        if (r137 == null) goto L110;
        r136 = r137;
    L110:
        Pair<Fragment, r1c.a> r138 = ((c0) org.koin.android.ext.android.a.a(this).f526122a.d().c(Reflection.getOrCreateKotlinClass(c0.class), null, null)).j4(PassportcConvention.c(this), r135, r136);     // Catch: Exception -> L89
        final Fragment r139 = r138.getFirst();
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(new HalfProfileActivity$initDragView$6(r139, this), false);
        r1c.a r140 = r138.getSecond();
        this.f236249k = r140;
        if (r140 == null) goto L80;
        r140.b(new f(this));
    L80:
        r1c.a r141 = this.f236249k;
        if (r141 == null) goto L83;
        r141.a(new g(this));
    L83:
        if (r139 == null) goto L91;
        FragmentTransaction r142 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r142, r139, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "UserProfileFragmentV3", com.larus.nova.R.id.profile_fragment) == true) goto L88;
        r142.add(com.larus.nova.R.id.profile_fragment, r139, "UserProfileFragmentV3");
    L88:
        r142.commitAllowingStateLoss();
    L91:
        ActivityHalfProfileBinding r143 = this.f236247i;
        if (r143 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r143 = null;
    L94:
        VerticalScrollInterceptLayout r144 = r143.f227339e;
        if (r144 == null) goto L97;
        r144.setVisibility(4);
    L97:
        ActivityHalfProfileBinding r145 = this.f236247i;
        if (r145 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L101:
        FrameLayout r146 = r100.f227342h;
        if (r146 == null) goto L112;
        r146.post(new e(this));
        return;
    L112:
        return;
    L100:
        r100 = r145;
    L89:
        e = move-exception;
        tt5.a.f("HalfProfileActivity", e, false);
        goto L91
    L105:
        r102 = com.larus.nova.R.id.top_divider;
        goto L109
    L106:
        r102 = com.larus.nova.R.id.shadow;
        goto L109
    L107:
        r102 = com.larus.nova.R.id.profile_fragment;
    L109:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L8;
        GestureDetector r101 = this.f236252n;
        if (r101 == null) goto L8;
        r101.onTouchEvent(r100);
    L8:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (dc9.d.a() == true) goto L17;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L14
        if (r102 != null) goto L9;
    L11:
        if (r101 != 3) goto L17;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:HalfProfileActivity portrait");     // Catch: Throwable -> L14
        goto L17
    L9:
        if (r102.intValue() != r101) goto L11;
    L17:
        if (this.f236245g == h18.f.b(r100)) goto L20;
        finish();
    L20:
        if (this.f236246h == cu5.c.e(this)) goto L25;
        this.f236246h = cu5.c.e(this);
        com.bytedance.ee.util.ui.j.c(new b(this));
        return;
    L25:
        return;
    L14:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L17
    }

    public final void D1(boolean r110, boolean r111) {
        ActivityHalfProfileBinding r100 = this.f236247i;
        ActivityHalfProfileBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        LinearLayout r102 = r100.f227338d;
        int r103 = 8;
        if (r102 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L23;
        ActivityHalfProfileBinding r105 = this.f236247i;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L15:
        View r106 = r105.f227344j;
        if (r106 != null) goto L18;
    L20:
        boolean r107 = false;
    L21:
        if (r107 == false) goto L23;
        boolean r108 = true;
    L25:
        if (en4.a.l() == false) goto L39;
        ActivityHalfProfileBinding r109 = this.f236247i;
        if (r109 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L30:
        FrameLayout r112 = r109.f227340f;
        if (r112 == null) goto L39;
        int[] r113 = this.f236254p;
        if (r113 != null) goto L36;
        r113 = new int[]{r112.getPaddingLeft(), r112.getPaddingTop(), r112.getPaddingRight(), r112.getPaddingBottom()};
        this.f236254p = r113;
    L36:
        if (r110 == false) goto L38;
        WindowInsetsUtils.g(r112, true, false);
        goto L39
    L38:
        WindowInsetsUtils.g(r112, false, false);
        r112.setPadding(r113[0], r113[1], r113[2], r113[3]);
    L39:
        if (r110 != r108) goto L41;
        return;
    L41:
        if (r110 == false) goto L45;
        j r114 = this.f236248j;
        if (r114 == null) goto L48;
        r114.f226600o = null;
    L48:
        ActivityHalfProfileBinding r115 = this.f236247i;
        if (r115 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L51:
        LinearLayout r116 = r115.f227338d;
        if (r116 != null) goto L54;
    L58:
        r1c.a r117 = this.f236249k;
        if (r117 == null) goto L61;
        r117.c(r110);
    L61:
        ActivityHalfProfileBinding r118 = this.f236247i;
        if (r118 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L65:
        View r119 = r101.f227344j;
        if (r119 != null) goto L68;
    L71:
        if (r110 == true) goto L84;
        if (r111 == false) goto L85;
        float r120 = this.f236244f * 0.87f;
        j r121 = this.f236248j;
        if (r121 == null) goto L76;
        r121.j(r120, 200);
    L76:
        j r122 = this.f236248j;
        if (r122 == null) goto L79;
        r122.f226596k = false;
    L79:
        if (r122 == null) goto L86;
        h r123 = new h(this);
        Intrinsics.checkNotNullParameter(r123, "listener");
        ValueAnimator r124 = r122.f226591f;
        if (r124 == null) goto L87;
        r124.addListener(r123);
        return;
    L87:
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L68:
        if ((!r110) == false) goto L70;
        r103 = 0;
    L70:
        r119.setVisibility(r103);
        goto L71
    L64:
        r101 = r118;
        goto L65
    L54:
        if ((!r110) == false) goto L56;
        int r125 = 0;
    L57:
        r116.setVisibility(r125);
        goto L58
    L56:
        r125 = 8;
        goto L57
    L45:
        j r126 = this.f236248j;
        if (r126 == null) goto L48;
        r126.f226600o = this.f236251m;
        goto L48
    L18:
        if (r106.getVisibility() != 8) goto L20;
        r107 = true;
    L23:
        r108 = false;
        goto L25
    L8:
        if (r102.getVisibility() != 8) goto L10;
        r104 = true;
        goto L11
    }
}
