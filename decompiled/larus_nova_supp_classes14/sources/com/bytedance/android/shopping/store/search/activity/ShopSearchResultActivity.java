package com.bytedance.android.shopping.store.search.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.store.common.activity.ECStoreBaseActivity;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.search.fragment.ShopSearchResultFragment;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
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
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/search/activity/ShopSearchResultActivity;", "Lcom/bytedance/android/ec/store/common/activity/ECStoreBaseActivity;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchResultActivity extends ECStoreBaseActivity {
    public static final /* synthetic */ int m = 0;
    public ImmersionBar l;

    public static final class a {
        public a() {
        }

        public static void a(Context r3, ECShopSearchParam r4, Integer r5, String r6, int r7) {
            int r0 = ShopSearchResultActivity.m;
            if ((r7 & 4) == 0) goto L6;
            r5 = null;
        L6:
            if ((r7 & 8) == 0) goto L9;
            r6 = null;
        L9:
            if ((r7 & 16) == 0) goto L11;
            boolean r8 = true;
        L12:
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "searchParam");
            r4.setFromSearchActivity(r8);
            r4.setSourceBtmToken(r6);
            Intent r9 = new Intent(r3, ShopSearchResultActivity.class);
            r9.putExtra("search_param", r4);
            boolean r10 = r3 instanceof Activity;
            if (r10 == false) goto L15;
            Lazy r2 = ECStoreFoldPhoneHelper.a;
            ECStoreFoldPhoneHelper.h((Activity) r3);
        L15:
            r4.setSplitMode(false);
            if (r5 == null) goto L28;
            if (r10 == true) goto L19;
            Context r11 = null;
        L20:
            Activity r12 = (Activity) r11;
            if (r12 == null) goto L23;
            r12.startActivityForResult(r9, r5.intValue());
        L23:
            if (r10 == true) goto L25;
            r3 = null;
        L25:
            Activity r13 = (Activity) r3;
            if (r13 == null) goto L30;
            r13.overridePendingTransition(0, 0);
            return;
        L30:
            return;
        L19:
            r11 = r3;
            goto L20
        L28:
            r3.startActivity(r9);
            return;
        L11:
            r8 = false;
            goto L12
        }
    }

    static {
        new a();
    }

    public ShopSearchResultActivity() {
        super(0);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ShopSearchResultActivity.class.getName()));
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ShopSearchResultActivity.class.getName()));
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
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onCreate(r6);
        Intent r7 = getIntent();
        Fragment r1 = null;
        if (r7 == null) goto L13;
        Serializable r8 = r7.getSerializableExtra("search_param");
    L14:
        if (r8 == null) goto L29;
        ECShopSearchParam r9 = (ECShopSearchParam) r8;
        com.bytedance.ies.uikit.base.a.b(this, 1);
        setContentView(2131560920);
        Fragment r2 = getSupportFragmentManager().findFragmentByTag("shop_search_result_fragment");
        if ((r2 instanceof ShopSearchResultFragment) == false) goto L20;
        r1 = r2;
    L20:
        if (((ShopSearchResultFragment) r1) != null) goto L26;
        int r3 = ShopSearchResultFragment.g;
        Intrinsics.checkNotNullParameter(r9, "searchParam");
        ShopSearchResultFragment r4 = new ShopSearchResultFragment();
        Bundle r5 = new Bundle();
        r5.putSerializable("search_param", r9);
        Unit r10 = Unit.INSTANCE;
        r4.setArguments(r5);
        FragmentTransaction r11 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "shop_search_result_fragment", 2131386276) == true) goto L25;
        r11.add(2131386276, r4, "shop_search_result_fragment");
    L25:
        r11.commitNowAllowingStateLoss();
    L26:
        l0.d(getWindow());
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.search.router.ECShopSearchParam");
    L13:
        r8 = null;
        goto L14
    }
}
