package com.bytedance.ee.bear.profile;

import android.R;
import android.animation.ValueAnimator;
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
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0018J\b\u0010\u001f\u001a\u00020\u0018H\u0003J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0007H\u0002J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0018H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\b\u0010/\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/profile/HalfProfileActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "maxHeight", "", "isNightMode", "", "isLandscape", "binding", "Lcom/bytedance/ee/bear/lark/databinding/ActivityHalfProfileBinding;", "dragView", "Lcom/bytedance/ee/bear/profile/HalfProfileDragView;", "profilePageController", "Lcom/ss/android/lark/profile_api/IProfilePageController;", "isProfileReachTop", "onTouchEventIntercept", "Landroid/view/View$OnTouchListener;", "gestureDetector", "Landroid/view/GestureDetector;", "isDispatchingActivityBackPressed", "profileFragmentInitialPadding", "", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "compatOrientation", "initDragView", "notifyFullScreenStatus", "enter", "autoSlide", "updateProfileFragmentStatusBarPadding", "enterFullScreen", "slideToTargetHeight", "targetHeight", "", "duration", "", "finish", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onBackPressed", "getMidHeight", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@AndroidEntryPoint
public final class HalfProfileActivity extends Hilt_HalfProfileActivity {
    public static final /* synthetic */ int q = 0;
    public int f;
    public boolean g;
    public boolean h;
    public ActivityHalfProfileBinding i;
    public j j;
    public r1c.a k;
    public boolean l;
    public com.bytedance.ee.bear.profile.e m;
    public GestureDetector n;
    public boolean o;
    public int[] p;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ HalfProfileActivity a;

        public b(HalfProfileActivity r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j r0 = this.a.j;     // Catch: Throwable -> L10
            if (r0 == null) goto L5;
            r0.o();     // Catch: Throwable -> L10
        L5:
            HalfProfileActivity r1 = this.a;     // Catch: Throwable -> L10
            j r2 = r1.j;     // Catch: Throwable -> L10
            if (r2 == null) goto L8;
            r2.l(r1.f * 0.87f);     // Catch: Throwable -> L10
        L8:
            this.a.C1();     // Catch: Throwable -> L10
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
        public final /* synthetic */ HalfProfileActivity a;

        public c(HalfProfileActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            GeneratedComponentManagerHolder r5 = this.a;
            Intent r0 = new Intent();
            r0.putExtra("is_confirm", true);
            Unit r1 = Unit.INSTANCE;
            r5.setResult(-1, r0);
            this.a.finish();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ HalfProfileActivity a;

        public d(HalfProfileActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.finish();
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ HalfProfileActivity a;

        public e(HalfProfileActivity r1) {
            this.a = r1;
        }

        public final void a() {
            ActivityHalfProfileBinding r0 = this.a.i;
            ActivityHalfProfileBinding r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r0 = null;
        L5:
            VerticalScrollInterceptLayout r2 = r0.e;
            if (r2 == null) goto L8;
            r2.setVisibility(0);
        L8:
            ActivityHalfProfileBinding r3 = this.a.i;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L12:
            r1.i.setVisibility(0);
            j r4 = this.a.j;
            if (r4 == null) goto L15;
            r4.o();
        L15:
            HalfProfileActivity r5 = this.a;
            if (r5.h == false) goto L19;
            r5.C1();
            return;
        L19:
            return;
        L11:
            r1 = r3;
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

    public final void onBackPressed() {
        this.o = true;
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onBackPressed();     // Catch: Throwable -> L6
        this.o = false;
        return;
    L6:
        th = move-exception;
        this.o = false;
        throw th;
    }

    public final void C1() {
        ActivityHalfProfileBinding r0 = this.i;
        ActivityHalfProfileBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        VerticalScrollInterceptLayout r1 = r0.e;
        if (r1 == null) goto L8;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
    L10:
        if (this.h == true) goto L12;
        if (r3 == null) goto L16;
        r3.width = -1;
    L16:
        ActivityHalfProfileBinding r4 = this.i;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L20:
        VerticalScrollInterceptLayout r5 = r2.e;
        if (r5 == null) goto L24;
        r5.setLayoutParams(r3);
        return;
    L24:
        return;
    L19:
        r2 = r4;
        goto L20
    L12:
        if ((r3 instanceof LinearLayout.LayoutParams) == false) goto L16;
        ((LinearLayout.LayoutParams) r3).width = (int) (cu5.c.d() * 0.7f);
        goto L16
    L8:
        r3 = null;
        goto L10
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.profile.Hilt_HalfProfileActivity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(HalfProfileActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.profile.Hilt_HalfProfileActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(HalfProfileActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public HalfProfileActivity() {
        this.f = com.bytedance.ee.util.ui.n.t();
        this.g = h18.f.a(eu5.b.a);
        this.l = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r22) {
        this.g = h18.f.b(getResources().getConfiguration());
        this.h = cu5.c.e(this);
        ActivityHalfProfileBinding r8 = null;
        View r0 = getLayoutInflater().inflate(2131558486, null, false);
        int r1 = 2131367794;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r0, 2131367794);
        if (r12 == null) goto L109;
        r1 = 2131375587;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r0, 2131375587);
        if (r13 == null) goto L109;
        r1 = 2131375595;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131375595);
        if (r14 == null) goto L109;
        r1 = 2131375607;
        if (ViewBindings.findChildViewById(r0, 2131375607) == null) goto L109;
        r1 = 2131383203;
        VerticalScrollInterceptLayout r15 = (VerticalScrollInterceptLayout) ViewBindings.findChildViewById(r0, 2131383203);
        if (r15 == null) goto L109;
        FrameLayout r16 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131383214);
        if (r16 == null) goto L107;
        r1 = 2131383255;
        FrameLayout r17 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131383255);
        if (r17 == null) goto L109;
        FrameLayout r2 = (FrameLayout) r0;
        View r19 = ViewBindings.findChildViewById(r0, 2131386031);
        if (r19 == null) goto L106;
        View r20 = ViewBindings.findChildViewById(r0, 2131389146);
        if (r20 == null) goto L105;
        this.i = new ActivityHalfProfileBinding(r2, r12, r13, r14, r15, r16, r17, r2, r19, r20);
        setContentView(r2);
        getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, 2131100562)));
        getWindow().setExitTransition(null);
        StatusBarUtil.setTransparent(this);
        ActivityHalfProfileBinding r3 = this.i;
        if (r3 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L23:
        TextView r4 = r3.c;
        if (r4 == null) goto L26;
        r4.setOnClickListener(new c(this));
    L26:
        String r5 = getIntent().getStringExtra("content");
        if (r5 == null) goto L34;
        ActivityHalfProfileBinding r6 = this.i;
        if (r6 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L31:
        TextView r7 = r6.b;
        if (r7 == null) goto L34;
        r7.setText(r5);
    L34:
        String r9 = getIntent().getStringExtra("confirmText");
        if (r9 == null) goto L42;
        ActivityHalfProfileBinding r10 = this.i;
        if (r10 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L39:
        TextView r11 = r10.c;
        if (r11 == null) goto L42;
        r11.setText(r9);
    L42:
        ActivityHalfProfileBinding r18 = this.i;
        if (r18 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L45:
        r18.h.setOnClickListener(new d(this));
        ActivityHalfProfileBinding r21 = this.i;
        if (r21 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L48:
        VerticalScrollInterceptLayout r23 = r21.e;
        if (r23 == null) goto L51;
        r23.addOnLayoutChangeListener(new com.bytedance.ee.bear.profile.a(this));
    L51:
        ActivityHalfProfileBinding r24 = this.i;
        if (r24 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L54:
        VerticalScrollInterceptLayout r25 = r24.e;
        if (r25 == null) goto L57;
        r25.setDelegate(new com.bytedance.ee.bear.profile.b(this));
    L57:
        ActivityHalfProfileBinding r26 = this.i;
        if (r26 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L60:
        VerticalScrollInterceptLayout r27 = r26.e;
        int r28 = this.f;
        float r29 = 0.87f * r28;
        float r30 = r28;
        View[] r31 = new View[1];
        ActivityHalfProfileBinding r32 = this.i;
        if (r32 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L63:
        r31[0] = r32.i;
        j r33 = new j(this, r27, r29, r30, CollectionsKt.arrayListOf(r31));
        this.j = r33;
        ((com.bytedance.ee.bear.facade.common.widget.d) r33).b = 0.5f;
        ((com.bytedance.ee.bear.facade.common.widget.d) r33).a = 0.5f;
        ActivityHalfProfileBinding r34 = this.i;
        if (r34 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L66:
        r33.i(r34.e);
        ((com.bytedance.ee.bear.facade.common.widget.d) r33).l = true;
        r33.l(1.0f);
        ((com.bytedance.ee.bear.facade.common.widget.d) r33).h = new com.bytedance.ee.bear.profile.c(r33, this);
        this.n = new GestureDetector(this, new com.bytedance.ee.bear.profile.d(this));
        com.bytedance.ee.bear.profile.e r35 = new com.bytedance.ee.bear.profile.e(this);
        this.m = r35;
        j r36 = this.j;
        if (r36 == null) goto L69;
        ((com.bytedance.ee.bear.facade.common.widget.d) r36).o = r35;
    L69:
        String r37 = getIntent().getStringExtra("userId");
        String r38 = "";
        if (r37 != null) goto L72;
        r37 = "";
    L72:
        String r39 = getIntent().getStringExtra("title");
        if (r39 == null) goto L110;
        r38 = r39;
    L110:
        Pair r40 = ((c0) org.koin.android.ext.android.a.a(this).a.d().c(Reflection.getOrCreateKotlinClass(c0.class), null, null)).j4(PassportcConvention.c(this), r37, r38);     // Catch: Exception -> L89
        final Fragment r41 = (Fragment) r40.getFirst();
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(new HalfProfileActivity$initDragView$6(r41, this), false);
        r1c.a r42 = (r1c.a) r40.getSecond();
        this.k = r42;
        if (r42 == null) goto L80;
        r42.b(new f(this));
    L80:
        r1c.a r43 = this.k;
        if (r43 == null) goto L83;
        r43.a(new g(this));
    L83:
        if (r41 == null) goto L91;
        FragmentTransaction r44 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r44, r41, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "UserProfileFragmentV3", 2131383214) == true) goto L88;
        r44.add(2131383214, r41, "UserProfileFragmentV3");
    L88:
        r44.commitAllowingStateLoss();
    L91:
        ActivityHalfProfileBinding r45 = this.i;
        if (r45 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r45 = null;
    L94:
        VerticalScrollInterceptLayout r46 = r45.e;
        if (r46 == null) goto L97;
        r46.setVisibility(4);
    L97:
        ActivityHalfProfileBinding r47 = this.i;
        if (r47 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L101:
        FrameLayout r48 = r8.h;
        if (r48 == null) goto L112;
        r48.post(new e(this));
        return;
    L112:
        return;
    L100:
        r8 = r47;
    L89:
        e = move-exception;
        tt5.a.f("HalfProfileActivity", e, false);
        goto L91
    L105:
        r1 = 2131389146;
        goto L109
    L106:
        r1 = 2131386031;
        goto L109
    L107:
        r1 = 2131383214;
    L109:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (r2.getAction() != 0) goto L8;
        GestureDetector r0 = this.n;
        if (r0 == null) goto L8;
        r0.onTouchEvent(r2);
    L8:
        return super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.dispatchTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r6) {
        Intrinsics.checkNotNullParameter(r6, "newConfig");
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onConfigurationChanged(r6);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (dc9.d.a() == true) goto L17;
        int r1 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r2 = Integer.valueOf(r6.orientation);     // Catch: Throwable -> L14
        if (r2 != null) goto L9;
    L11:
        if (r1 != 3) goto L17;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:HalfProfileActivity portrait");     // Catch: Throwable -> L14
        goto L17
    L9:
        if (r2.intValue() != r1) goto L11;
    L17:
        if (this.g == h18.f.b(r6)) goto L20;
        finish();
    L20:
        if (this.h == cu5.c.e(this)) goto L25;
        this.h = cu5.c.e(this);
        com.bytedance.ee.util.ui.j.c(new b(this));
        return;
    L25:
        return;
    L14:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L17
    }

    public final void D1(boolean r12, boolean r13) {
        ActivityHalfProfileBinding r0 = this.i;
        ActivityHalfProfileBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        LinearLayout r1 = r0.d;
        int r3 = 8;
        if (r1 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L23;
        ActivityHalfProfileBinding r5 = this.i;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L15:
        View r6 = r5.j;
        if (r6 != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == false) goto L23;
        boolean r8 = true;
    L25:
        if (en4.a.l() == false) goto L39;
        ActivityHalfProfileBinding r9 = this.i;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L30:
        FrameLayout r10 = r9.f;
        if (r10 == null) goto L39;
        int[] r11 = this.p;
        if (r11 != null) goto L36;
        r11 = new int[]{r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r10.getPaddingBottom()};
        this.p = r11;
    L36:
        if (r12 == false) goto L38;
        WindowInsetsUtils.g(r10, true, false);
        goto L39
    L38:
        WindowInsetsUtils.g(r10, false, false);
        r10.setPadding(r11[0], r11[1], r11[2], r11[3]);
    L39:
        if (r12 != r8) goto L41;
        return;
    L41:
        if (r12 == false) goto L45;
        j r14 = this.j;
        if (r14 == null) goto L48;
        ((com.bytedance.ee.bear.facade.common.widget.d) r14).o = null;
    L48:
        ActivityHalfProfileBinding r15 = this.i;
        if (r15 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L51:
        LinearLayout r16 = r15.d;
        if (r16 != null) goto L54;
    L58:
        r1c.a r17 = this.k;
        if (r17 == null) goto L61;
        r17.c(r12);
    L61:
        ActivityHalfProfileBinding r18 = this.i;
        if (r18 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L65:
        View r19 = r2.j;
        if (r19 != null) goto L68;
    L71:
        if (r12 == true) goto L84;
        if (r13 == false) goto L85;
        float r110 = this.f * 0.87f;
        j r111 = this.j;
        if (r111 == null) goto L76;
        r111.j(r110, 200);
    L76:
        j r112 = this.j;
        if (r112 == null) goto L79;
        ((com.bytedance.ee.bear.facade.common.widget.d) r112).k = false;
    L79:
        if (r112 == null) goto L86;
        h r113 = new h(this);
        Intrinsics.checkNotNullParameter(r113, "listener");
        ValueAnimator r114 = ((com.bytedance.ee.bear.facade.common.widget.d) r112).f;
        if (r114 == null) goto L87;
        r114.addListener(r113);
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
        if ((!r12) == false) goto L70;
        r3 = 0;
    L70:
        r19.setVisibility(r3);
        goto L71
    L64:
        r2 = r18;
        goto L65
    L54:
        if ((!r12) == false) goto L56;
        int r20 = 0;
    L57:
        r16.setVisibility(r20);
        goto L58
    L56:
        r20 = 8;
        goto L57
    L45:
        j r21 = this.j;
        if (r21 == null) goto L48;
        ((com.bytedance.ee.bear.facade.common.widget.d) r21).o = this.m;
        goto L48
    L18:
        if (r6.getVisibility() != 8) goto L20;
        r7 = true;
    L23:
        r8 = false;
        goto L25
    L8:
        if (r1.getVisibility() != 8) goto L10;
        r4 = true;
        goto L11
    }
}
