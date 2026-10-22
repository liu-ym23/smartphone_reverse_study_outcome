package com.bytedance.ee.bear.lark.biz.bitable;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.bitable.homepage.BitableHomePageFragment;
import com.bytedance.ee.bear.bitable.homepage.BitableTabFragmentV4;
import com.bytedance.ee.bear.bitable.homepage.i0;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/lark/biz/bitable/BitableHomeActivity;", "Lcom/bytedance/ee/bear/bitable/homepage/BitableHomepageBaseActivity;", "Lcom/bytedance/ee/bear/bitable/homepage/IMoreItem;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "homeViewContainerDelegate", "Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;", "useV4HomePage", "", "traceId", "", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initTitle", "getSpecifyMoreItemList", "", "onBackPressed", "onDestroy", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableHomeActivity extends Hilt_BitableHomeActivity implements d0c.c {
    public BitableTabFragmentV4 i;
    public boolean j;
    public String k;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.lark.biz.bitable.Hilt_BitableHomeActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(BitableHomeActivity.class.getName()));
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
    public final void onBackPressed() {
        BitableTabFragmentV4 r0 = this.i;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L18:
        if (r1 == false) goto L20;
        return;
    L20:
        Intent r2 = getIntent();
        if (r2 == null) goto L23;
        String r3 = r2.getStringExtra("container_env");
    L24:
        String r4 = r3;
        if (r4 == null) goto L27;
        ws4.g.b(this.k, System.currentTimeMillis(), new ws4.b(r4, "", "homepage", "user_back", "cancel", 32));
    L27:
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onBackPressed();
        return;
    L23:
        r3 = null;
        goto L24
    L5:
        if (Intrinsics.areEqual(r0.I, Boolean.TRUE) == false) goto L7;
        r0.W90();
    L14:
        boolean r5 = true;
    L16:
        if (r5 != true) goto L18;
        r1 = true;
        goto L18
    L7:
        BitableHomePageFragment r6 = r0.Q;
        if (r6 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == true) goto L14;
        r5 = false;
        goto L16
    L10:
        if (r6.V90() != true) goto L12;
        r7 = true;
        goto L13
    }

    @Override // com.bytedance.ee.bear.lark.biz.bitable.Hilt_BitableHomeActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(BitableHomeActivity.class.getName()));
    L5:
        super.onDestroy();
        if (this.j == false) goto L9;
        com.bytedance.ee.bear.bitable.statistic.m r0 = ws4.g.a;
        String r1 = this.k;
        Intrinsics.checkNotNullParameter(r1, "traceId");
        com.bytedance.ee.bear.bitable.statistic.l.a(ws4.g.a, r1);
        this.k = "";
        ws4.f.b();
        ws4.d.b();
        return;
    }

    public BitableHomeActivity() {
        this.k = "";
    }

    public final UserSession e9() {
        return PassportcConvention.c(this);
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

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m423provideComponent() {
        return provideComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r16) {
        setContentView(2131558450);
        Intent r17 = getIntent();
        com.bytedance.ee.bear.lark.g r0 = null;
        if (r17 == null) goto L5;
        String r18 = r17.getStringExtra("base_hp_from");
    L6:
        Intent r1 = getIntent();
        if (r1 == null) goto L9;
        String r2 = r1.getStringExtra("container_env");
    L10:
        Intent r3 = getIntent();
        if (r3 == null) goto L13;
        String r4 = r3.getStringExtra("home_page_version");
    L14:
        this.j = TextUtils.equals(r4, "v4");
        if (TextUtils.isEmpty(r2) == false) goto L17;
        this.j = idb.f.a().isEnable("bitable.homepage.v4.enable");
        tt5.a.h("BitableHomeActivity", "container env is null & useV4HomePage:" + this.j);
    L17:
        BaseTitleBar r5 = findViewById(2131374494);
        if (this.j == false) goto L21;
        if (r5 == null) goto L23;
        r5.setVisibility(8);
    L23:
        if (this.j == false) goto L32;
        com.bytedance.ee.bear.bitable.statistic.m r6 = ws4.g.a;
        String r7 = r6.createNormalTrace(null);
        r6.addNormalConsumer(r7, new ws4.a());
        this.k = r7;
        if (r2 == null) goto L27;
        Intrinsics.checkNotNullParameter(r2, "containerEnv");
        Intrinsics.checkNotNullParameter("", "tabLoadFrom");
        Intrinsics.checkNotNullParameter("", "scene");
        Intrinsics.checkNotNullParameter("", "reason");
        String r8 = this.k;
        long r10 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r8, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, BatterySceneData.OPT_START, r10, false, 12);
        r9.addExtra("reason", "");
        r9.addExtra(DocRedirectToDocxPlugin.FROM, r2);
        r9.addExtra("tab_load_from", "");
        r9.addExtra("scene", "");
        r6.addNormalPoint(r8, r9);
    L27:
        BitableTabFragmentV4 r11 = new BitableTabFragmentV4();
        this.i = r11;
        r11.U90(r2, r18, this.k);
        FragmentTransaction r19 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r19, r11, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L31;
        r19 = r19.replace(2131373275, r11);
    L31:
        r19.commitNowAllowingStateLoss();
    L41:
        com.ss.android.lark.insets.h r110 = WindowInsetsUtils.c(this);
        r110.c(false);
        r110.b(0);
        return;
    L32:
        boolean r12 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.workbench.new.enable");
        if (r12 == false) goto L35;
        BitableHomeFragment r13 = new BitableTabFragment();
    L36:
        r13.E = r18;
        r13.F = r12;
        r13.h = new i0(this);
        r13.k = new com.bytedance.ee.bear.lark.i(r13, r0);
        FragmentTransaction r111 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r111, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L40;
        r111 = r111.replace(2131373275, r13);
    L40:
        r111.commitNowAllowingStateLoss();
        goto L41
    L35:
        r13 = new BitableHomeFragment();
        goto L36
    L21:
        r5.a(new com.bytedance.ee.bear.lark.biz.bitable.a(com.bytedance.ee.util.ui.l.a(this, 2131255617, 2131101926), this), true);
        goto L23
    L13:
        r4 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r18 = null;
        goto L6
    }
}
