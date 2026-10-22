package com.bytedance.android.shopping.store.shopfeed;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.store.common.activity.ECStoreBaseActivity;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.shopfeed.fragment.ECShopFlowFragment;
import com.bytedance.android.shopping.store.shopfeed.fragment.ECShopInnerFlowFragment;
import com.bytedance.android.shopping.store.shopfeed.fragment.ECShopMomentFlowFragment;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/ECShopFeedActivity;", "Lcom/bytedance/android/ec/store/common/activity/ECStoreBaseActivity;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopFeedActivity extends ECStoreBaseActivity {
    public static final /* synthetic */ int m = 0;
    public ImmersionBar l;

    public static final class a {
    }

    static {
    }

    public ECShopFeedActivity() {
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772248);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ECShopFeedActivity.class.getName()));
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
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECShopFeedActivity.class.getName()));
    L5:
        super.onDestroy();
        ImmersionBar r0 = this.l;
        if (r0 == null) goto L9;
        r0.destroy();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        z1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.y1();
        ImmersionBar r0 = ImmersionBar.with(this);
        this.l = r0;
        if (r0 == null) goto L8;
        ImmersionBar r1 = r0.statusBarDarkFont(true);
        if (r1 == null) goto L9;
        r1.init();
        return;
    L9:
        return;
    }

    public static View z1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        overridePendingTransition(2130772245, 2130772253);
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onCreate(r6);
        setContentView(2131560851);
        int r7 = com.bytedance.android.shopping.store.shopfeed.fragment.a.a;
        Intent r8 = getIntent();
        Intrinsics.checkNotNullParameter(r8, "intent");
        Bundle r0 = new Bundle();
        r0.putSerializable("shop_feed_param", r8.getSerializableExtra("shop_feed_param"));
        r0.putLong("router_start_time", r8.getLongExtra("router_start_time", 0));
        r0.putString("source_btm_token", r8.getStringExtra("source_btm_token"));
        r0.putString("shop_inner_flow_btm", r8.getStringExtra("shop_inner_flow_btm"));
        Serializable r9 = r8.getSerializableExtra("shop_feed_param");
        if ((r9 instanceof ShopFeedParam) == true) goto L13;
        r9 = null;
    L13:
        ShopFeedParam r10 = (ShopFeedParam) r9;
        if (r10 == null) goto L18;
        Integer r11 = r10.getTabType();
        if (r11 == null) goto L18;
        int r12 = r11.intValue();
    L20:
        if (r12 != TabEnum.SHOP_FLOW_PAGE.getType()) goto L23;
        Fragment r13 = new ECShopFlowFragment();
        r13.setArguments(r0);
    L29:
        FragmentTransaction r1 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131370871) == true) goto L33;
        r1.add(2131370871, r13);
    L33:
        r1.commitNowAllowingStateLoss();
        l0.d(getWindow());
        View r14 = z1(getWindow());
        r14.setSystemUiVisibility((r14.getSystemUiVisibility() | 2) | 512);
        return;
    L23:
        if (r12 != TabEnum.SHOP_MOMENT_FLOW_PAGE.getType()) goto L26;
        r13 = new ECShopMomentFlowFragment();
        r13.setArguments(r0);
        goto L29
    L26:
        if (r12 != TabEnum.SHOP_INNER_FLOW_PAGE.getType()) goto L28;
        r13 = new ECShopInnerFlowFragment();
        r13.setArguments(r0);
        goto L29
    L28:
        r13 = new ECShopInnerFlowFragment();
        r13.setArguments(r0);
    L18:
        r12 = TabEnum.SHOP_INNER_FLOW_PAGE.getType();
        goto L20
    }
}
