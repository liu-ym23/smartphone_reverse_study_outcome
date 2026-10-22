package com.bytedance.ee.bear.demo;

import android.R;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/demo/OfficeCCMDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "docsSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "getDocsSdk", "()Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "setDocsSdk", "(Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "createRootView", "Landroid/view/View;", "showPrefetchDialog", "Companion", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCCMDemoActivity extends Hilt_OfficeCCMDemoActivity implements d0c.c {
    public static final /* synthetic */ int e = 0;

    @Inject
    public ik5.a d;

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

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeCCMDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(OfficeCCMDemoActivity.class.getName()));
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

    @Override // com.bytedance.ee.bear.demo.Hilt_OfficeCCMDemoActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OfficeCCMDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public final UserSession e9() {
        return PassportcConvention.a(LarkContext.getApplication());
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
    public final /* bridge */ /* synthetic */ Object m125provideComponent() {
        return provideComponent();
    }

    public OfficeCCMDemoActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        A1(r4);
        super.onCreate(r4);
        LinearLayout r5 = new LinearLayout(this);
        r5.setOrientation(1);
        TextView r0 = new TextView(this);
        r0.setText("CCM 测试页面");
        r0.setPadding(50, 50, 50, 50);
        r0.setTextSize(18.0f);
        r5.addView(r0);
        Button r1 = new Button(this);
        r1.setText("打开 Office Space");
        r1.setOnClickListener(new o0(this));
        r5.addView(r1);
        Button r2 = new Button(this);
        r2.setText("打开豆包新 UI 组件");
        r2.setOnClickListener(new r0(this));
        r5.addView(r2);
        Button r3 = new Button(this);
        r3.setText("打开文档");
        r3.setOnClickListener(new s0(this));
        r5.addView(r3);
        Button r6 = new Button(this);
        r6.setText("打开Drive-普通PDF");
        r6.setOnClickListener(new t0(this));
        r5.addView(r6);
        Button r7 = new Button(this);
        r7.setText("打开Drive-文件加密PDF（123456.pdf）");
        r7.setOnClickListener(new u0(this));
        r5.addView(r7);
        Button r8 = new Button(this);
        r8.setText("打开Drive-链接加密PDF（718T2@41）");
        r8.setOnClickListener(new v0(this));
        r5.addView(r8);
        Button r9 = new Button(this);
        r9.setText("打开Drive-Word文件");
        r9.setOnClickListener(new w0(this));
        r5.addView(r9);
        Button r10 = new Button(this);
        r10.setText("打开Drive-Excel文件");
        r10.setOnClickListener(new x0(this));
        r5.addView(r10);
        Button r11 = new Button(this);
        r11.setText("打开Drive-Excel文件（大小超限）");
        r11.setOnClickListener(new e0(this));
        r5.addView(r11);
        Button r12 = new Button(this);
        r12.setText("打开Drive-PPT文件");
        r12.setOnClickListener(new f0(this));
        r5.addView(r12);
        Button r13 = new Button(this);
        r13.setText("打开Drive-TXT文件");
        r13.setOnClickListener(new g0(this));
        r5.addView(r13);
        Button r14 = new Button(this);
        r14.setText("打开Drive-MarkDown文件");
        r14.setOnClickListener(new h0(this));
        r5.addView(r14);
        Button r16 = new Button(this);
        r16.setText("打开Drive-音频文件（m4a）");
        r16.setOnClickListener(new i0(this));
        r5.addView(r16);
        Button r17 = new Button(this);
        r17.setText("打开Drive-json文件");
        r17.setOnClickListener(new j0(this));
        r5.addView(r17);
        Button r18 = new Button(this);
        r18.setText("打开Drive-xml文件");
        r18.setOnClickListener(new k0(this));
        r5.addView(r18);
        Button r19 = new Button(this);
        r19.setText("打开Drive-html文件");
        r19.setOnClickListener(new l0(this));
        r5.addView(r19);
        Button r20 = new Button(this);
        r20.setText("打开Drive-js文件");
        r20.setOnClickListener(new m0(this));
        r5.addView(r20);
        Button r21 = new Button(this);
        r21.setText("打开Drive-log文件");
        r21.setOnClickListener(new n0(this));
        r5.addView(r21);
        Button r22 = new Button(this);
        r22.setText("打开Drive-无权限（可申请）");
        r22.setOnClickListener(new p0(this));
        r5.addView(r22);
        Button r23 = new Button(this);
        r23.setText("预拉取数据");
        r23.setOnClickListener(new q0(this));
        r5.addView(r23);
        ScrollView r24 = new ScrollView(this);
        r24.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r24.addView(r5, new ViewGroup.LayoutParams(-1, -1));
        setContentView(r24);
    }
}
