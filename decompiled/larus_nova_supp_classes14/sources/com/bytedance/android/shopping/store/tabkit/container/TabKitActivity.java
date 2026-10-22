package com.bytedance.android.shopping.store.tabkit.container;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.tabkit.TabKitAbilityConfig;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.utils.n;
import com.bytedance.android.shopping.store.utils.o;
import com.bytedance.ies.uikit.base.SSActivity;
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
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/container/TabKitActivity;", "Landroidx/fragment/app/FragmentActivity;", "Luk3/a;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitActivity extends FragmentActivity implements uk3.a {
    public static final /* synthetic */ int e = 0;
    public TabKitFragment a;
    public TabKitRouterParams b;
    public final boolean c;
    public final Lazy d;

    public static final class a {
        public static void a(Context r4, Class r5, Bundle r6) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "tabKitFragmentClazz");
            long r0 = r6.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
            Map<Long, TabkitFirstFramePref> r2 = ok3.a.e;
            TabkitFirstFramePref r1 = ok3.a.C0149a.a(r0);
            if (r1 == null) goto L5;
            TabkitFramePref.recordTime$default(r1, "t_route_activity_start", null, 2, null);
        L5:
            Intent r3 = new Intent(r4, TabKitActivity.class);
            r3.putExtra("tabkit_fragment_clazz", r5);
            r3.putExtra("biz_arguments", r6);
            Unit r7 = Unit.INSTANCE;
            r4.startActivity(r3);
        }
    }

    static {
    }

    @Override // uk3.a
    public final float b() {
        return ((Number) this.d.getValue()).floatValue();
    }

    /* JADX INFO: Removed unreachable split cross block B:74:0x0145 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        int r2 = ik3.a.a;
        TabKitRouterParams r3 = this.b;
        if (r3 == null) goto L5;
        String r4 = r3.getPageExitAnim();
    L7:
        if (r4 != null) goto L10;
    L15:
        int r5 = -1;
        int r6 = -1;
    L16:
        if (r5 == (-1)) goto L22;
        if (r6 == (-1)) goto L22;
        if ((this instanceof SSActivity) == false) goto L21;
        ((SSActivity) this).A1(r5, r6);
    L24:
        if ((this instanceof ChatWindowActivity) == true) goto L65;
        FLogger r7 = FLogger.a;
        r7.i("ActivityLancet", "finish ".concat(TabKitActivity.class.getName()));
        long r8 = SystemClock.uptimeMillis();
        Map r9 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r9);
        Long r10 = (Long) r9.get(this);     // Catch: Throwable -> L66
        if (r10 != null) goto L31;
    L34:
        r9.put(this, Long.valueOf(r8));     // Catch: Throwable -> L66
        monitor-exit(r9);     // Catch: Throwable -> L66
    L63:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L71:
        return;
    L37:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L40;
        r7.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L63
        goto L71
    L40:
        if (isFinishing() == true) goto L43;
        r7.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L63
        goto L71
    L43:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L46;
        r7.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L63
        goto L71
    L46:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L49;
        r7.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L63
        goto L71
    L49:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L52;
        r7.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L63
        goto L71
    L52:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L54;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L63
        goto L71
    L54:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L63
        if (r1 == null) goto L71;
        r1.addFlags(268435456);     // Catch: Throwable -> L63
        r1.addFlags(2097152);     // Catch: Throwable -> L63
        r7.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L63
        startActivity(r1);     // Catch: Throwable -> L60
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L63
        goto L71
    L31:
        if ((r8 - r10.longValue()) >= 800) goto L34;
        monitor-exit(r9);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        throw th;
    L65:
        return;
    L21:
        overridePendingTransition(r5, r6);
    L22:
        com.bytedance.ies.uikit.base.a.a(this);
        goto L24
    L10:
        if (r4.hashCode() != 3135100) goto L15;
        if (r4.equals("fade") == false) goto L15;
        r5 = 2130772235;
        r6 = 2130772237;
        goto L16
    L5:
        r4 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        dm.a.a("TabKitActivity").i("TabKitActivity onDestroy");
        super.onDestroy();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        ShoppingAsyncInflater.e.getClass();     // Catch: Throwable -> L5
        Activity r1 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this);     // Catch: Throwable -> L5
        ShoppingAsyncInflater.d.remove(r1);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void onStart() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        super.onStart();     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L12;
        ECExceptionMonitor.f(r2, "TabKitActivity::onStart error");
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public TabKitActivity() {
        this.c = true;
        this.d = LazyKt.lazy(new TabKitActivity$sizeInDp$2(this));
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

    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle y1() {
        Intent r0 = getIntent();
        if (r0 == null) goto L8;
        Bundle r1 = r0.getBundleExtra("biz_arguments");
        Context r2 = BadParcelableCrashOptimizer.getContext();
        if (r1 == null) goto L10;
        if (r2 == null) goto L11;
        r1.setClassLoader(r2.getClassLoader());
        return r1;
    L11:
        return r1;
    L10:
        return r1;
    L8:
        return null;
    }

    @Override // uk3.a
    public final boolean g() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void attachBaseContext(Context r3) {
        super/*androidx.core.app.ComponentActivity*/.attachBaseContext(r3);
        if (Intrinsics.areEqual(ECAppInfoService.e.getAppId(), "482431") == true) goto L20;
        if (r3 == null) goto L25;
        Bundle r0 = y1();
        if (r0 == null) goto L9;
        Boolean r1 = Boolean.valueOf(r0.getBoolean("is_store"));
    L11:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L13;
        return;
    L13:
        if (ECShopABSettings.d() != 1) goto L22;
        Resources r4 = r3.getResources();
        if (r4 == null) goto L23;
        Configuration r5 = r4.getConfiguration();
        if (r5 == null) goto L24;
        r5.fontScale = o.a;
        applyOverrideConfiguration(r5);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r1 = null;
        goto L11
    L25:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L131
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L131
    L8:
        dm.a.a("TabKitActivity").i("TabKitActivity create");
        boolean r2 = false;
        if (hk3.e.a() <= 1) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        d.a(this);
    L14:
        Bundle r3 = y1();
        Boolean r4 = null;
        if (r3 == null) goto L17;
        Object r5 = r3.get(TabKitRouterParams.KEY_ROUTER_PARAMS);
    L19:
        if ((r5 instanceof TabKitRouterParams) == true) goto L21;
        r5 = null;
    L21:
        this.b = (TabKitRouterParams) r5;
        Bundle r6 = y1();
        if (r6 == null) goto L24;
        long r7 = r6.getLong(TabkitFirstFramePref.KEY_TABKIT_MONITOR);
        Map<Long, TabkitFirstFramePref> r8 = ok3.a.e;
        TabkitFirstFramePref r9 = ok3.a.C0149a.a(r7);
    L26:
        if (r9 == null) goto L28;
        TabkitFramePref.recordTime$default(r9, "t_on_create_activity", null, 2, null);
    L28:
        Bundle r11 = y1();
        if (r11 != null) goto L31;
    L45:
        super.onCreate(r10);
        if (hk3.e.a() <= 1) goto L48;
        boolean r12 = true;
    L49:
        if (r12 == true) goto L51;
        d.a(this);
    L51:
        int r13 = ik3.a.a;
        TabKitRouterParams r14 = this.b;
        if (r14 == null) goto L54;
        String r15 = r14.getPageEnterAnim();
    L56:
        if (r15 != null) goto L59;
    L64:
        int r16 = -1;
        int r17 = -1;
    L65:
        if (r16 == (-1)) goto L71;
        if (r17 == (-1)) goto L71;
        if ((this instanceof SSActivity) == false) goto L70;
        ((SSActivity) this).A1(r16, r17);
    L72:
        setContentView(2131560975);
        Fragment r18 = getSupportFragmentManager().findFragmentByTag("tabkit_fragment");
        if ((r18 instanceof TabKitFragment) == true) goto L75;
        r18 = null;
    L75:
        TabKitFragment r19 = (TabKitFragment) r18;
        this.a = r19;
        if (r19 != null) goto L96;
        Serializable r20 = getIntent().getSerializableExtra("tabkit_fragment_clazz");
        if ((r20 instanceof Class) == true) goto L80;
        r20 = null;
    L80:
        Class r21 = (Class) r20;
        if (r21 == null) goto L85;
        Constructor r22 = r21.getDeclaredConstructor(new Class[0]);
        if (r22 == null) goto L85;
        TabKitFragment r23 = (TabKitFragment) r22.newInstance(new Object[0]);
    L86:
        this.a = r23;
        if (r23 == null) goto L89;
        Bundle r24 = new Bundle();
        r24.putAll(y1());
        Unit r25 = Unit.INSTANCE;
        r23.setArguments(r24);
    L89:
        TabKitFragment r26 = this.a;
        if (r26 == null) goto L96;
        FragmentTransaction r27 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r27, r26, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "tabkit_fragment", 2131388065) == true) goto L95;
        r27.add(2131388065, r26, "tabkit_fragment");
    L95:
        r27.commitNowAllowingStateLoss();
    L85:
        r23 = null;
    L96:
        TabKitFragment r28 = this.a;
        if (r28 == null) goto L99;
        r28.e = getWindow();
    L99:
        l0.d(getWindow());
        if (r10 == null) goto L102;
        r4 = Boolean.valueOf(r10.getBoolean("is_configuration_changing"));
    L102:
        dm.a.b r0 = dm.a.a("TabKitActivity");
        StringBuilder r29 = new StringBuilder("reportActivityCreated hasSavedState=");
        if (r10 == null) goto L105;
        boolean r30 = true;
    L106:
        r29.append(r30);
        r29.append(", isConfigurationChanging=");
        r29.append(r4);
        r0.i(r29.toString());
        com.bytedance.android.ec.sdk.helper.g r31 = com.bytedance.android.ec.sdk.helper.g.a;
        JSONObject r32 = new JSONObject();
        r32.putOpt("EVENT_ORIGIN_FEATURE", "TEMAI");
        TabKitRouterParams r33 = this.b;
        String r34 = "";
        if (r33 == null) goto L110;
        String r35 = r33.getBizTag();
        if (r35 == null) goto L110;
    L111:
        r32.putOpt("biz_tag", r35);
        TabKitRouterParams r36 = this.b;
        if (r36 == null) goto L117;
        String r37 = r36.getAnchorUrl();
        if (r37 == null) goto L117;
        String r38 = n.b(r37);
        if (r38 == null) goto L117;
    L118:
        r32.putOpt("anchor_url", r38);
        TabKitRouterParams r39 = this.b;
        if (r39 == null) goto L126;
        String r40 = r39.getApiUrl();
        if (r40 == null) goto L126;
        String r41 = n.b(r40);
        if (r41 == null) goto L126;
        r34 = r41;
    L126:
        r32.putOpt("api_url", r34);
        if (r10 == null) goto L129;
        r2 = true;
    L129:
        r32.putOpt("is_recreate", Boolean.valueOf(r2));
        r32.putOpt("is_configuration_changing", Boolean.valueOf(Intrinsics.areEqual(r4, Boolean.TRUE)));
        Unit r110 = Unit.INSTANCE;
        r31.logV3("ec_tabkit_activity_create", r32);
        return;
    L117:
        r38 = "";
    L110:
        r35 = "";
        goto L111
    L105:
        r30 = false;
        goto L106
    L70:
        overridePendingTransition(r16, r17);
    L71:
        com.bytedance.ies.uikit.base.a.b(this, 0);
        goto L72
    L59:
        if (r15.hashCode() != 3135100) goto L64;
        if (r15.equals("fade") == false) goto L64;
        r16 = 2130772235;
        r17 = 2130772237;
        goto L65
    L54:
        r15 = null;
        goto L56
    L48:
        r12 = false;
        goto L49
    L31:
        if (r11.getString("pre_create_anniex_uid") == null) goto L45;
        TabKitRouterParams r42 = this.b;
        if (r42 == null) goto L45;
        TabKitAbilityConfig r43 = new TabKitAbilityConfig(r42);
        if (r43.b("enable_anniex_async_create") == false) goto L45;
        if (r43.b("disable_anniex_container") == true) goto L45;
        if (r9 == null) goto L42;
        TabkitFramePref.recordTime$default(r9, "t_start_pre_create_annie", null, 2, null);
    L42:
        int r44 = ECSdk.a;
        IECHostService r45 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r45 == null) goto L45;
        r45.getECAnnieXHostService();
        goto L45
    L24:
        r9 = null;
        goto L26
    L17:
        r5 = null;
        goto L19
    L11:
        r1 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(r3);
        r3.putBoolean("is_configuration_changing", isChangingConfigurations());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L12;
        boolean r4 = ECServiceManager.a;
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getHandleBackToOtherAppIfNeed(this) == false) goto L7;
        return true;
    L7:
        TabKitFragment r5 = this.a;
        if (r5 == null) goto L10;
        r5.S90();
    L10:
        return true;
    L12:
        return super/*android.app.Activity*/.onKeyDown(r2, r3);
    }
}
