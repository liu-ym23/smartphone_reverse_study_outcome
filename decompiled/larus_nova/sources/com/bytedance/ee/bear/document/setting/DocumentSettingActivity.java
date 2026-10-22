package com.bytedance.ee.bear.document.setting;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.framework.utils.UIUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020#2\b\b\u0001\u0010'\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0014J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/document/setting/DocumentSettingActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "leaderLayoutFromXml", "Landroid/widget/RelativeLayout;", "getLeaderLayoutFromXml", "()Landroid/widget/RelativeLayout;", "setLeaderLayoutFromXml", "(Landroid/widget/RelativeLayout;)V", "udSwitchFromXml", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "getUdSwitchFromXml", "()Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "setUdSwitchFromXml", "(Lcom/larksuite/component/universe_design/udswitch/UDSwitch;)V", "accessLayoutFromXml", "getAccessLayoutFromXml", "setAccessLayoutFromXml", "rightTxFromXml", "Landroid/widget/TextView;", "getRightTxFromXml", "()Landroid/widget/TextView;", "setRightTxFromXml", "(Landroid/widget/TextView;)V", "viewModel", "Lcom/bytedance/ee/bear/document/setting/DocumentSettingViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/document/setting/DocumentSettingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "permType", "", "Ljava/lang/Integer;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setStatusBarAndNavigationBarColor", "bgColor", "bindView", "init", "onResume", "bindObserver", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentSettingActivity extends BaseActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f221732i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RelativeLayout f221733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDSwitch f221734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RelativeLayout f221735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f221736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f221737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f221738h;

    public static final class a {
    }

    static {
    }

    public final DocumentSettingViewModel C1() {
        return (DocumentSettingViewModel) this.f221737g.getValue();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(DocumentSettingActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DocumentSettingActivity.class.getName()));
    L5:
        super.onDestroy();
        C1().onDestroyed();
    }

    public DocumentSettingActivity() {
        this.f221737g = LazyKt.lazy(new DocumentSettingActivity$viewModel$2(this));
        this.f221738h = 1;
    }

    public final void init() {
        C1().init();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        C1().refreshPermType();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        ta5.g r101 = (ta5.g) vb(ta5.g.class);
        if (r101 == null) goto L5;
        r101.k(com.larus.nova.R.color.bg_base);
        int r102 = UIUtils.getColor(r101.f545177a, com.larus.nova.R.color.bg_base);
        WindowInsetsUtils.c(r101.f545177a).i(r102);
    L5:
        setContentView(com.larus.nova.R.layout.ccm_doc_setting_layout);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r103 = jg5.e.a.f499003a.e();
        KeyEvent.Callback r104 = this.f221733c;
        if (r104 != null) goto L8;
        r104 = findViewById(com.larus.nova.R.id.leader_layout);
        this.f221733c = (RelativeLayout) r104;
    L8:
        RelativeLayout r105 = (RelativeLayout) r104;
        if (r103 == false) goto L11;
        int r106 = 0;
    L12:
        r105.setVisibility(r106);
        KeyEvent.Callback r107 = this.f221734d;
        if (r107 != null) goto L15;
        r107 = findViewById(com.larus.nova.R.id.ud_switch);
        this.f221734d = (UDSwitch) r107;
    L15:
        ((UDSwitch) r107).setOnCheckedChangeListener(new g(this));
        KeyEvent.Callback r108 = this.f221735e;
        if (r108 != null) goto L18;
        r108 = findViewById(com.larus.nova.R.id.access_layout);
        this.f221735e = (RelativeLayout) r108;
    L18:
        ((RelativeLayout) r108).setOnClickListener(new h(this));
        C1().getAutoAuthLeader().observe(this, new d(this));
        C1().getPermissionType().observe(this, new e(this));
        C1().getHasLeader().observe(this, new f(this));
        init();
        return;
    L11:
        r106 = 8;
        goto L12
    }
}
