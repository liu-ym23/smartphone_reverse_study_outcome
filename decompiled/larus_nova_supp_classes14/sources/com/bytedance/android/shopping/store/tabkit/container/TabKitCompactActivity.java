package com.bytedance.android.shopping.store.tabkit.container;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.shopping.store.home.ECStoreTabKitFragment;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreDataFutureManager;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.utils.x;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitCompactActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitCompactActivity extends FragmentActivity {
    public static final /* synthetic */ int b = 0;
    public TabKitFragment a;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(TabKitCompactActivity.class.getName()));
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
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

    public TabKitCompactActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r6);
        com.bytedance.ies.uikit.base.a.b(this, 0);
        setContentView(2131560975);
        Bundle r7 = getIntent().getBundleExtra("biz_arguments");
        Context r0 = BadParcelableCrashOptimizer.getContext();
        if (r7 == null) goto L14;
        if (r0 == null) goto L14;
        r7.setClassLoader(r0.getClassLoader());
    L14:
        String r1 = null;
        if (r7 == null) goto L17;
        Object r2 = r7.get("store_param");
    L19:
        if ((r2 instanceof ECStoreParam) == true) goto L21;
        r2 = null;
    L21:
        ECStoreParam r3 = (ECStoreParam) r2;
        if (r3 == null) goto L44;
        Uri r8 = UriProtector.parse(r7.getString("schema"));
        if (r8 == null) goto L45;
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Lazy r4 = ECStoreDataFutureManager.g;
        ECStoreDataFutureManager r5 = ECStoreDataFutureManager.a.a();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        String r9 = r3.getSecShopId();
        ECStoreParam r10 = r5.b;
        if (r10 == null) goto L30;
        r1 = r10.getSecShopId();
    L30:
        Intrinsics.areEqual(r9, r1);
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Map<Long, m> r11 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r12 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(r3.getLifecycleMonitorId()));
        if (r12 == null) goto L33;
        r12.K();
    L33:
        int r13 = x.a;
        x.a("/shop/preload/frame/info/", r3.getSecShopId());
        ECStoreApi.a.getClass();
        ECStoreApi r14 = ECStoreApi.a.b;
        if (r14 == null) goto L39;
        Observable<ECStorePreloadInfoResponse> r15 = r14.getShopPreloadFrameInfo(r3.getSecShopId(), (String) r3.getPassThroughParam("pass_through_api"), com.bytedance.android.ec.hybrid.list.util.k.d(ECShopABSettings.k.b()));
        if (r15 == null) goto L39;
        Observable r16 = r15.map(new ti3.b(r3));
        if (r16 == null) goto L39;
    L40:
        bg4.b.b(r16.map(e.a)).subscribe(new f(this, r3, r8), new g(this, r3, r8));
        l0.d(getWindow());
        return;
    L39:
        r16 = Observable.error(new Throwable("getShopPreloadFrameInfo failed : network service not found"));
        goto L40
    L45:
        return;
    L44:
        return;
    L17:
        r2 = null;
        goto L19
    }

    public final void y1(ECStoreTabKitFragment r5) {
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "tabkit_fragment", 2131388065) == true) goto L6;
        r0.add(2131388065, r5, "tabkit_fragment");
    L6:
        r0.commitNowAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L14;
        if (this.a == null) goto L14;
        boolean r4 = ECServiceManager.a;
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getHandleBackToOtherAppIfNeed(this) == false) goto L9;
        return true;
    L9:
        TabKitFragment r5 = this.a;
        if (r5 == null) goto L12;
        r5.S90();
    L12:
        return true;
    L14:
        return super/*android.app.Activity*/.onKeyDown(r2, r3);
    }
}
