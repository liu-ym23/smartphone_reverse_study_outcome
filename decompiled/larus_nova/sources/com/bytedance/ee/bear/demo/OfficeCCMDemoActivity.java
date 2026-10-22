package com.bytedance.ee.bear.demo;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/demo/OfficeCCMDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "docsSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "getDocsSdk", "()Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "setDocsSdk", "(Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;)V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "createRootView", "Landroid/view/View;", "showPrefetchDialog", "Companion", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCCMDemoActivity extends Hilt_OfficeCCMDemoActivity implements d0c.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f217515e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Inject
    public ik5.a f217516d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeCCMDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(OfficeCCMDemoActivity.class.getName()));
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

    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeCCMDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeCCMDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.a(LarkContext.getApplication());
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

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public OfficeCCMDemoActivity() {
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        A1(r100);
        super.onCreate(r100);
        LinearLayout r101 = new LinearLayout(this);
        r101.setOrientation(1);
        TextView r102 = new TextView(this);
        r102.setText("CCM 测试页面");
        r102.setPadding(50, 50, 50, 50);
        r102.setTextSize(18.0f);
        r101.addView(r102);
        Button r103 = new Button(this);
        r103.setText("打开 Office Space");
        r103.setOnClickListener(new o0(this));
        r101.addView(r103);
        Button r104 = new Button(this);
        r104.setText("打开豆包新 UI 组件");
        r104.setOnClickListener(new r0(this));
        r101.addView(r104);
        Button r105 = new Button(this);
        r105.setText("打开文档");
        r105.setOnClickListener(new s0(this));
        r101.addView(r105);
        Button r106 = new Button(this);
        r106.setText("打开Drive-普通PDF");
        r106.setOnClickListener(new t0(this));
        r101.addView(r106);
        Button r107 = new Button(this);
        r107.setText("打开Drive-文件加密PDF（123456.pdf）");
        r107.setOnClickListener(new u0(this));
        r101.addView(r107);
        Button r108 = new Button(this);
        r108.setText("打开Drive-链接加密PDF（718T2@41）");
        r108.setOnClickListener(new v0(this));
        r101.addView(r108);
        Button r109 = new Button(this);
        r109.setText("打开Drive-Word文件");
        r109.setOnClickListener(new w0(this));
        r101.addView(r109);
        Button r110 = new Button(this);
        r110.setText("打开Drive-Excel文件");
        r110.setOnClickListener(new x0(this));
        r101.addView(r110);
        Button r111 = new Button(this);
        r111.setText("打开Drive-Excel文件（大小超限）");
        r111.setOnClickListener(new e0(this));
        r101.addView(r111);
        Button r112 = new Button(this);
        r112.setText("打开Drive-PPT文件");
        r112.setOnClickListener(new f0(this));
        r101.addView(r112);
        Button r113 = new Button(this);
        r113.setText("打开Drive-TXT文件");
        r113.setOnClickListener(new g0(this));
        r101.addView(r113);
        Button r114 = new Button(this);
        r114.setText("打开Drive-MarkDown文件");
        r114.setOnClickListener(new h0(this));
        r101.addView(r114);
        Button r115 = new Button(this);
        r115.setText("打开Drive-音频文件（m4a）");
        r115.setOnClickListener(new i0(this));
        r101.addView(r115);
        Button r116 = new Button(this);
        r116.setText("打开Drive-json文件");
        r116.setOnClickListener(new j0(this));
        r101.addView(r116);
        Button r117 = new Button(this);
        r117.setText("打开Drive-xml文件");
        r117.setOnClickListener(new k0(this));
        r101.addView(r117);
        Button r118 = new Button(this);
        r118.setText("打开Drive-html文件");
        r118.setOnClickListener(new l0(this));
        r101.addView(r118);
        Button r119 = new Button(this);
        r119.setText("打开Drive-js文件");
        r119.setOnClickListener(new m0(this));
        r101.addView(r119);
        Button r120 = new Button(this);
        r120.setText("打开Drive-log文件");
        r120.setOnClickListener(new n0(this));
        r101.addView(r120);
        Button r121 = new Button(this);
        r121.setText("打开Drive-无权限（可申请）");
        r121.setOnClickListener(new p0(this));
        r101.addView(r121);
        Button r122 = new Button(this);
        r122.setText("预拉取数据");
        r122.setOnClickListener(new q0(this));
        r101.addView(r122);
        ScrollView r123 = new ScrollView(this);
        r123.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r123.addView(r101, new ViewGroup.LayoutParams(-1, -1));
        setContentView(r123);
    }
}
