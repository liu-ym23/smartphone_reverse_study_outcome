package com.bytedance.android.shopping.feed.activity;

import android.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.utils.g0;
import com.bytedance.android.shopping.feed.view.d;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OSUtils;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/feed/activity/ProductFeedActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "Lcom/bytedance/android/shopping/feed/view/d;", "<init>", "()V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedActivity extends AbsActivity implements d {
    public static final /* synthetic */ int l = 0;
    public ImmersionBar j;
    public View k;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772248);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ProductFeedActivity.class.getName()));
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ProductFeedActivity.class.getName()));
    L5:
        super.onDestroy();
        ImmersionBar r0 = this.j;
        if (r0 == null) goto L9;
        r0.destroy();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        super.y1();
        if (OSUtils.isEMUI3_0() == false) goto L5;
        return;
    L5:
        if (OSUtils.isEMUI3_1() == true) goto L22;
        int r0 = g0.a;
        Window r1 = getWindow();
        if (r1 != null) goto L10;
    L13:
        ImmersionBar r2 = ImmersionBar.with(this);
        this.j = r2;
        if (r2 == null) goto L20;
        ImmersionBar r3 = r2.statusBarDarkFont(true);
        if (r3 == null) goto L21;
        r3.init();
        return;
    L21:
        return;
    L20:
        return;
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L13;
        WindowManager.LayoutParams r4 = r1.getAttributes();
        r4.layoutInDisplayCutoutMode = 1;
        r1.setAttributes(r4);
        goto L13
    }

    public ProductFeedActivity() {
    }

    @Override // com.bytedance.android.shopping.feed.view.d
    public final void close(boolean r1) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r9);
        setContentView(2131560640);
        overridePendingTransition(2130772245, 2130772253);
        this.k = findViewById(2131370808);
        Serializable r0 = getIntent().getSerializableExtra("param_key");
        if ((r0 instanceof AnchorV3Param) == true) goto L13;
        r0 = null;
    L13:
        Serializable r1 = (AnchorV3Param) r0;
        if (r1 == null) goto L33;
        Serializable r2 = getIntent().getSerializableExtra("page_style");
        if ((r2 instanceof InnerFlowPageStyleDTO) == true) goto L18;
        r2 = null;
    L18:
        Serializable r3 = (InnerFlowPageStyleDTO) r2;
        if (r3 == null) goto L34;
        int r5 = ProductFeedContentFragment.I;
        Intrinsics.checkNotNullParameter(r1, "param");
        Intrinsics.checkNotNullParameter(r3, "innerFlowPageStyle");
        Intrinsics.checkNotNullParameter(this, "parentView");
        ProductFeedContentFragment r6 = new ProductFeedContentFragment();
        Bundle r7 = new Bundle();
        r7.putSerializable("param_key", r1);
        r7.putSerializable("page_style", r3);
        Unit r4 = Unit.INSTANCE;
        r6.setArguments(r7);
        Intrinsics.checkNotNullParameter(this, "parentView");
        r6.u = this;
        FragmentManager r8 = getSupportFragmentManager();
        if (r8 == null) goto L35;
        FragmentTransaction r10 = r8.beginTransaction();
        if (r10 != null) goto L25;
        return;
    L25:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131370808) == true) goto L28;
        r10 = r10.replace(2131370808, r6);
    L28:
        if (r10 == null) goto L37;
        r10.commitAllowingStateLoss();
        return;
    L37:
        return;
    L35:
        return;
    L34:
        return;
    }
}
