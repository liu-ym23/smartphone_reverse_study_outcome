package com.bytedance.android.shopping.orderlist.list.container;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.ies.uikit.base.AbsActivity;
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
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/container/OrderListActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "Lcom/bytedance/android/shopping/orderlist/list/container/b;", "<init>", "()V", "Companion", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListActivity extends AbsActivity implements b {
    public static final /* synthetic */ int l = 0;
    public ImmersionBar j;
    public OrderListFragment k;

    public static final class Companion {
        public static void a(Context r2, OrderListParams r3, final String r4, Uri r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "sessionId");
            Intrinsics.checkNotNullParameter(r5, "uri");
            Lazy r0 = OrderCommonLog.a;
            OrderCommonLog.c("OrderListActivity", new OrderListActivity$Companion$launch$1(r4));
            if (r6 == false) goto L12;
            int r7 = OrderListFragment.P;
            OrderListFragment.Companion.a(r3, r4, r5);
            nj.d r8 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
            if (r8 == null) goto L7;
            CJPayBasicExtensionKt.toActivity(r2);
            r8.k();
            Boolean r9 = Boolean.FALSE;
        L9:
            if (k.i(r9) == false) goto L11;
            OrderCommonLog.a("OrderListActivity", OrderListActivity$Companion$launch$2.INSTANCE);
            return;
        L11:
            OrderListActivity$Companion$launch$3 r10 = OrderListActivity$Companion$launch$3.INSTANCE;
            Intrinsics.checkNotNullParameter("OrderListActivity", "tag");
            Intrinsics.checkNotNullParameter(r10, "msg");
            ((ExecutorService) OrderCommonLog.a.getValue()).execute(new com.bytedance.android.shopping.orderlist.common.utils.j("OrderListActivity", r10));
            return;
        L7:
            r9 = null;
            goto L9
        L12:
            Intent r11 = new Intent(r2, OrderListActivity.class);
            Bundle r1 = new Bundle();
            r1.putSerializable("ORDER_LIST_PARAM", r3);
            r1.putSerializable("PrefetchSessionId", r4);
            r11.putExtra("ORDER_LIST_URI", r5);
            Unit r12 = Unit.INSTANCE;
            r11.putExtras(r1);
            r2.startActivity(r11);
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0114 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListActivity", AnonymousClass1.INSTANCE);
        super.finish();
        overridePendingTransition(0, 2130772248);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r3 = FLogger.a;
        r3.i("ActivityLancet", "finish ".concat(OrderListActivity.class.getName()));
        long r4 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r4));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r3.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r3.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r3.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r3.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r3.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
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
        r3.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r4 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OrderListActivity.class.getName()));
    L5:
        OrderListFragment r0 = this.k;
        if (r0 == null) goto L10;
        OrderListViewModel r1 = r0.Y90();
        if (r1 == null) goto L10;
        OrderListTracker r2 = r1.getTracker();
    L11:
        OrderCommonErrorMonitorKt.c(r2, "onDestroy", new C02871(this));
        super.onDestroy();
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final void y1() {
        OrderCommonFirstScreenMonitorKt.a("setStatusBarColor", new OrderListActivity$setStatusBarColor$1(this));
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

    public OrderListActivity() {
    }

    @Override // com.bytedance.android.shopping.orderlist.list.container.b
    public final void close() {
        finish();
    }

    public static final /* synthetic */ void z1(OrderListActivity r0) {
        super.y1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        overridePendingTransition(2130772267, 2130772253);
        super.onCreate(r6);
        setContentView(2131564136);
        Lazy r0 = UIUtils.a;
        UIUtils.g(getWindow(), "#F5F6F9");
        Fragment r1 = null;
        if (r6 != null) goto L30;
        int r7 = OrderListFragment.P;
        Serializable r8 = getIntent().getSerializableExtra("ORDER_LIST_PARAM");
        if ((r8 instanceof OrderListParams) == true) goto L15;
        r8 = null;
    L15:
        OrderListParams r9 = (OrderListParams) r8;
        Intent r2 = getIntent();
        if (r2 == null) goto L20;
        Bundle r3 = r2.getExtras();
        if (r3 == null) goto L20;
        String r4 = r3.getString("PrefetchSessionId");
    L21:
        Intent r5 = getIntent();
        if (r5 == null) goto L24;
        Uri r10 = (Uri) r5.getParcelableExtra("ORDER_LIST_URI");
    L25:
        OrderListFragment r11 = OrderListFragment.Companion.a(r9, r4, r10);
        this.k = r11;
        FragmentTransaction r12 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r11, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131381617) == true) goto L29;
        r12 = r12.replace(2131381617, r11);
    L29:
        r12.commit();
    L35:
        Lazy r13 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListActivity", AnonymousClass2.INSTANCE);
        return;
    L24:
        r10 = null;
    L20:
        r4 = null;
        goto L21
    L30:
        Fragment r14 = getSupportFragmentManager().findFragmentById(2131381617);
        if ((r14 instanceof OrderListFragment) == false) goto L34;
        r1 = r14;
    L34:
        this.k = (OrderListFragment) r1;
        goto L35
    }
}
