package com.bytedance.android.shopping.store.search.activity;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.arch.viewmodel.c;
import com.bytedance.android.ec.store.common.activity.ECStoreBaseActivity;
import com.bytedance.android.shopping.store.search.fragment.ECShopSearchFragment;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchViewModel;
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
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/search/activity/ECShopSearchActivity;", "Lcom/bytedance/android/ec/store/common/activity/ECStoreBaseActivity;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSearchActivity extends ECStoreBaseActivity implements QViewModelOwner {
    public static final /* synthetic */ int o = 0;
    public final c l;
    public ImmersionBar m;
    public ECShopSearchFragment n;

    public static final class a {
    }

    static {
    }

    public ECShopSearchActivity() {
        super(0);
        Function0<ViewModelProvider.Factory> r0 = new ECShopSearchActivity$viewModel$2(this);
        final Function0<FragmentActivity> r1 = new ECShopSearchActivity$$special$$inlined$viewModels$1(this);
        this.l = com.bytedance.android.ec.core.arch.viewmodel.a.a(this, Reflection.getOrCreateKotlinClass(ShopSearchViewModel.class), new ECShopSearchActivity$$special$$inlined$viewModels$2(r1), r0);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ECShopSearchActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
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

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void onBackPressed() {
        ECShopSearchFragment r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) r0.S90().getHistoryEditing().a(), Boolean.TRUE) == false) goto L7;
        r0.S90().getHistoryEditing().g(Boolean.FALSE);
        return;
    L7:
        r0.S90().setToNewPage(false);
        r0.requireActivity().finish();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECShopSearchActivity.class.getName()));
    L5:
        super.onDestroy();
        ImmersionBar r0 = this.m;
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
        this.m = r0;
        if (r0 == null) goto L8;
        ImmersionBar r1 = r0.statusBarDarkFont(true);
        if (r1 == null) goto L9;
        r1.init();
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L23
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L23
    L8:
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onCreate(r5);
        ShopSearchViewModel r6 = (ShopSearchViewModel) this.l.getValue();
        Serializable r0 = getIntent().getSerializableExtra("search_param");
        if (r0 == null) goto L22;
        r6.setSearchParam((ECShopSearchParam) r0);
        setContentView(2131560932);
        Fragment r7 = getSupportFragmentManager().findFragmentByTag("shop_search_fragment");
        if ((r7 instanceof ECShopSearchFragment) == true) goto L13;
        r7 = null;
    L13:
        ECShopSearchFragment r8 = (ECShopSearchFragment) r7;
        this.n = r8;
        if (r8 != null) goto L26;
        ECShopSearchParam r9 = ((ShopSearchViewModel) this.l.getValue()).getSearchParam();
        int r2 = ECShopSearchFragment.i;
        Intrinsics.checkNotNullParameter(r9, "searchParam");
        ECShopSearchFragment r3 = new ECShopSearchFragment();
        Bundle r4 = new Bundle();
        r4.putSerializable("search_param", r9);
        Unit r10 = Unit.INSTANCE;
        r3.setArguments(r4);
        this.n = r3;
        FragmentTransaction r11 = getSupportFragmentManager().beginTransaction();
        ECShopSearchFragment r1 = this.n;
        Intrinsics.checkNotNull(r1);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "shop_search_fragment", 2131371065) == true) goto L19;
        r11 = r11.add(2131371065, r1, "shop_search_fragment");
    L19:
        r11.commitAllowingStateLoss();
        return;
    L26:
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.search.router.ECShopSearchParam");
    }
}
