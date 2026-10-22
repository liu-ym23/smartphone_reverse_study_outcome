package com.bytedance.android.window.shop.innerflow;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.ec.opt.asyncInflate.d;
import com.bytedance.android.ec.window.base.common.activity.ECWindowBaseActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/ECWindowInnerFlowActivity;", "Lcom/bytedance/android/ec/window/base/common/activity/ECWindowBaseActivity;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowActivity extends ECWindowBaseActivity implements QViewModelOwner {
    public static final /* synthetic */ int o = 0;
    public ImmersionBar l;
    public final Lazy m;
    public final com.bytedance.commerce.base.viewmodel.a n;

    public static final class a {
    }

    public ECWindowInnerFlowActivity() {
        super(0);
        this.m = LazyKt.lazy(ECWindowInnerFlowActivity$uiManager$2.INSTANCE);
        Function0<ViewModelProvider.Factory> r0 = new ECWindowInnerFlowActivity$viewModel$2(this);
        this.n = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(ECWindowInnerFlowViewModel.class), new ECWindowInnerFlowActivity$$special$$inlined$viewModels$1(this), r0);
    }

    static {
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(ECWindowInnerFlowActivity.class, "a1.b76473");
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ECWindowInnerFlowActivity.class.getName()));
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECWindowInnerFlowActivity.class.getName()));
    L5:
        ((QUIManager) this.m.getValue()).r(dq3.b.class);
        ((ECWindowInnerFlowViewModel) this.n.getValue()).release(this);
        ImmersionBar r0 = this.l;
        if (r0 == null) goto L8;
        r0.destroy();
    L8:
        super.onDestroy();
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
        if (this.l != null) goto L5;
        this.l = ImmersionBar.with(this);
    L5:
        ImmersionBar r0 = this.l;
        if (r0 == null) goto L11;
        ImmersionBar r1 = r0.statusBarDarkFont(true);
        if (r1 == null) goto L12;
        r1.init();
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onCreate(r7);
        if (r7 == null) goto L14;
        Serializable r8 = r7.getSerializable("ec_shop_inner_flow_key_schema_params");
        if (r8 == null) goto L14;
    L19:
        if ((r8 instanceof Map) == true) goto L21;
        r8 = null;
    L21:
        Map r9 = (Map) r8;
        if (r9 == null) goto L33;
        ECWindowInnerFlowViewModel r2 = (ECWindowInnerFlowViewModel) this.n.getValue();
        String r4 = (String) r9.get("sec_uid");
        if (r4 != null) goto L26;
        r4 = "";
    L26:
        String r5 = (String) r9.get("inner_flow_type");
        if (r5 == null) goto L31;
        Integer r6 = StringsKt.toIntOrNull(r5);
        if (r6 == null) goto L31;
        int r10 = r6.intValue();
    L32:
        r2.setInnerFlowParam(new b(r9, r4, r10));
    L34:
        Lazy r3 = BtmSDKWrapper.a;
        if (r9 == null) goto L37;
        String r11 = (String) r9.get("source_btm_token");
    L38:
        BtmSDKWrapper.a(this, "a1.b76473", r11);
        ((QUIManager) this.m.getValue()).l(new dq3.b(com.bytedance.android.ec.opt.asyncInflate.c.a(z1(), 2131560375, null, 6)), this, false);
        ((QUIManager) this.m.getValue()).c(dq3.b.class, null);
        setContentView(((QUIManager) this.m.getValue()).p());
        if (((ECWindowInnerFlowViewModel) this.n.getValue()).getInnerFlowParam().c != 1) goto L41;
        getWindow().addFlags(128);
    L41:
        d r12 = z1().a();
        Iterator<T> r0 = ((ECWindowInnerFlowViewModel) this.n.getValue()).getViewCacheTriples().iterator();
    L43:
        if (r0.hasNext() == false) goto L45;
        Triple r1 = (Triple) r0.next();
        r12.c(((Number) r1.component1()).intValue(), ((Number) r1.component2()).intValue(), (String) r1.component3());
        goto L43
    L45:
        r12.commit();
        return;
    L37:
        r11 = null;
    L31:
        r10 = 1;
        goto L32
    L33:
        r9 = null;
    L14:
        Intent r13 = getIntent();
        if (r13 == null) goto L17;
        r8 = r13.getSerializableExtra("ec_shop_inner_flow_key_schema_params");
        goto L19
    L17:
        r8 = null;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSaveInstanceState(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "outState");
        super/*com.bytedance.ies.uikit.base.AbsActivity*/.onSaveInstanceState(r5);
        Serializable r1 = r5.getSerializable("ec_shop_inner_flow_key_schema_params");
        Serializable r3 = null;
        if ((r1 instanceof Map) == true) goto L6;
        r1 = null;
    L6:
        if (((Map) r1) == null) goto L8;
        return;
    L8:
        Intent r2 = getIntent();
        if (r2 == null) goto L11;
        Serializable r4 = r2.getSerializableExtra("ec_shop_inner_flow_key_schema_params");
    L13:
        if ((r4 instanceof Map) == false) goto L16;
        r3 = r4;
    L16:
        Map r6 = (Map) r3;
        if (r6 == null) goto L20;
        r5.putSerializable("ec_shop_inner_flow_key_schema_params", (Serializable) r6);
        return;
    L20:
        return;
    L11:
        r4 = null;
        goto L13
    }
}
