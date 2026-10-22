package com.bytedance.android.shopping.store.aggregate;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.store.common.activity.ECStoreBaseActivity;
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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/ShopAggregatePageActivity;", "Lcom/bytedance/android/ec/store/common/activity/ECStoreBaseActivity;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregatePageActivity extends ECStoreBaseActivity {
    public ImmersionBar l;

    public ShopAggregatePageActivity() {
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772248);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ShopAggregatePageActivity.class.getName()));
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
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ShopAggregatePageActivity.class.getName()));
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        overridePendingTransition(2130772245, 2130772253);
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onCreate(r6);
        setContentView(2131560932);
        Intent r7 = getIntent();
        Fragment r2 = null;
        if (r7 == null) goto L13;
        Serializable r8 = r7.getSerializableExtra("store_param");
    L15:
        if ((r8 instanceof ShopAggregateParam) == true) goto L17;
        r8 = null;
    L17:
        ShopAggregateParam r9 = (ShopAggregateParam) r8;
        if (r9 == null) goto L38;
        Fragment r3 = getSupportFragmentManager().findFragmentByTag("shop_aggregate_fragment");     // Catch: Exception -> L31
        if ((r3 instanceof ShopAggregatePageFragment) == false) goto L24;
        r2 = r3;
    L24:
        if (((ShopAggregatePageFragment) r2) != null) goto L39;
        ShopAggregatePageFragment.h.getClass();     // Catch: Exception -> L31
        Intrinsics.checkNotNullParameter(r9, "storeParam");     // Catch: Exception -> L31
        ShopAggregatePageFragment r4 = new ShopAggregatePageFragment();     // Catch: Exception -> L31
        Bundle r5 = new Bundle();     // Catch: Exception -> L31
        r5.putSerializable("store_param", r9);     // Catch: Exception -> L31
        Unit r10 = Unit.INSTANCE;     // Catch: Exception -> L31
        r4.setArguments(r5);     // Catch: Exception -> L31
        FragmentTransaction r11 = getSupportFragmentManager().beginTransaction();     // Catch: Exception -> L31
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "shop_aggregate_fragment", 2131371065) == true) goto L29;
        r11 = r11.add(2131371065, r4, "shop_aggregate_fragment");     // Catch: Exception -> L31
    L29:
        r11.commitAllowingStateLoss();     // Catch: Exception -> L31
        return;
    L39:
        return;
    L31:
        e = move-exception;
        e.printStackTrace();
        return;
    L38:
        return;
    L13:
        r8 = null;
        goto L15
    }
}
