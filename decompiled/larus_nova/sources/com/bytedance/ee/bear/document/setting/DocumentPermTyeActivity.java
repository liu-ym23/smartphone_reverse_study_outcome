package com.bytedance.ee.bear.document.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010&\u001a\u00020#2\b\b\u0001\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020#H\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/DocumentPermTyeActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "anyTxFromXml", "Landroid/widget/TextView;", "getAnyTxFromXml", "()Landroid/widget/TextView;", "setAnyTxFromXml", "(Landroid/widget/TextView;)V", "onlyLayoutFromXml", "Landroid/widget/LinearLayout;", "getOnlyLayoutFromXml", "()Landroid/widget/LinearLayout;", "setOnlyLayoutFromXml", "(Landroid/widget/LinearLayout;)V", "anyLayoutFromXml", "getAnyLayoutFromXml", "setAnyLayoutFromXml", "onlyCkFromXml", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getOnlyCkFromXml", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "setOnlyCkFromXml", "(Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;)V", "anyCkFromXml", "getAnyCkFromXml", "setAnyCkFromXml", "viewModel", "Lcom/bytedance/ee/bear/document/setting/DocumentSettingViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/document/setting/DocumentSettingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setStatusBarAndNavigationBarColor", "bgColor", "", "bindObserver", "bindView", "updatePermType", "permType", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentPermTyeActivity extends BaseActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f221725i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f221726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f221727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f221728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDCheckBox f221729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDCheckBox f221730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f221731h;

    public static final class a {
    }

    static {
    }

    public final UDCheckBox D1() {
        KeyEvent.Callback r100 = this.f221730g;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.any_ck);
        this.f221730g = (UDCheckBox) r100;
    L6:
        return (UDCheckBox) r100;
    }

    public final UDCheckBox F1() {
        KeyEvent.Callback r100 = this.f221729f;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.only_ck);
        this.f221729f = (UDCheckBox) r100;
    L6:
        return (UDCheckBox) r100;
    }

    public final DocumentSettingViewModel G1() {
        return (DocumentSettingViewModel) this.f221731h.getValue();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(DocumentPermTyeActivity.class.getName()));
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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
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
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DocumentPermTyeActivity.class.getName()));
    L5:
        super.onDestroy();
        G1().onDestroyed();
    }

    public DocumentPermTyeActivity() {
        this.f221731h = LazyKt.lazy(new DocumentPermTyeActivity$viewModel$2(this));
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
        r101.k(R.color.bg_base);
        int r102 = UIUtils.getColor(r101.f545177a, R.color.bg_base);
        WindowInsetsUtils.c(r101.f545177a).i(r102);
    L5:
        setContentView(R.layout.doc_access_permtype_layout);
        int r103 = getIntent().getIntExtra("permission_type", 1);
        KeyEvent.Callback r104 = this.f221726c;
        if (r104 != null) goto L8;
        r104 = findViewById(R.id.any_tx);
        this.f221726c = (TextView) r104;
    L8:
        ((TextView) r104).setText(G1().getAnyText(this));
        KeyEvent.Callback r105 = this.f221727d;
        if (r105 != null) goto L11;
        r105 = findViewById(R.id.only_layout);
        this.f221727d = (LinearLayout) r105;
    L11:
        ((LinearLayout) r105).setOnClickListener(new b(this));
        KeyEvent.Callback r106 = this.f221728e;
        if (r106 != null) goto L14;
        r106 = findViewById(R.id.any_layout);
        this.f221728e = (LinearLayout) r106;
    L14:
        ((LinearLayout) r106).setOnClickListener(new c(this));
        F1().setClickable(false);
        D1().setClickable(false);
        G1().getPermissionType().observe(this, new com.bytedance.ee.bear.document.setting.a(this));
        G1().getPermissionType().setValue(Integer.valueOf(r103));
    }

    public static final void C1(DocumentPermTyeActivity r100, int r101) {
        r100.getClass();
        tt5.a.h("DocumentPermTyeActivity", "update it " + r101);
        if (r101 != 1) goto L5;
        r100.F1().setChecked(true);
        r100.D1().setChecked(false);
        return;
    L5:
        if (r101 != 2) goto L11;
        r100.F1().setChecked(false);
        r100.D1().setChecked(true);
        return;
    }
}
