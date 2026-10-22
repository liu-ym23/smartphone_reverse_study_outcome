package com.larus.avlink.env.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.material.tabs.TabLayout;
import com.larus.avlink.impl.databinding.LarusActivityDoraMemoryDataBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObserveMemoryDataActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusActivityDoraMemoryDataBinding;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "setupView", "getBackgroundResource", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraEnvObserveMemoryDataActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f292208h = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusActivityDoraMemoryDataBinding f292209g;

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final int C1() {
        return R.color.larus_base_1_overlay;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraEnvObserveMemoryDataActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(DoraEnvObserveMemoryDataActivity.class.getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
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

    public DoraEnvObserveMemoryDataActivity() {
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        LarusActivityDoraMemoryDataBinding r100 = null;
        View r111 = getLayoutInflater().inflate(R.layout.larus_activity_dora_memory_data, null, false);
        int r101 = R.id.tab_layout;
        TabLayout r102 = (TabLayout) ViewBindings.findChildViewById(r111, R.id.tab_layout);
        if (r102 == null) goto L44;
        r101 = R.id.title;
        NovaTitleBarEx r103 = (NovaTitleBarEx) ViewBindings.findChildViewById(r111, R.id.title);
        if (r103 == null) goto L44;
        r101 = R.id.view_pager;
        ViewPager2 r104 = (ViewPager2) ViewBindings.findChildViewById(r111, R.id.view_pager);
        if (r104 == null) goto L44;
        LinearLayout r112 = (LinearLayout) r111;
        this.f292209g = new LarusActivityDoraMemoryDataBinding(r112, r102, r103, r104);
        setContentView(r112);
        LarusActivityDoraMemoryDataBinding r113 = this.f292209g;
        if (r113 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L19:
        NovaTitleBarEx r105 = r113.f293154c;
        NovaTitleBarEx.Y5(r105, getString(R.string.larus_dora_lab_environmental_data_cn), Integer.valueOf(R.color.larus_neutral_100), null, 4);
        r105.getBinding().f326844j.setTextSize(2, 17.0f);
        r105.getBinding().f326844j.setTypeface(null, 1);
        NovaTitleBarEx.b6(r105, R.drawable.larus_ic_left_back, false, null, null, new n(this), 14);
        LarusActivityDoraMemoryDataBinding r114 = this.f292209g;
        if (r114 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L22:
        r114.f293155d.setAdapter(new DoraEnvObserveMemoryDataActivity$setupView$2(this));
        LarusActivityDoraMemoryDataBinding r115 = this.f292209g;
        if (r115 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L25:
        TabLayout r116 = r115.f293153b;
        LarusActivityDoraMemoryDataBinding r106 = this.f292209g;
        if (r106 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L28:
        TabLayout.Tab r107 = r106.f293153b.newTab();
        int r108 = com.larus.utils.j0.f375426a;
        r116.addTab(r107.setText(com.larus.utils.j0.d(R.string.larus_dora_environmental_data_event_tab_cn)));
        LarusActivityDoraMemoryDataBinding r117 = this.f292209g;
        if (r117 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L31:
        TabLayout r118 = r117.f293153b;
        LarusActivityDoraMemoryDataBinding r109 = this.f292209g;
        if (r109 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L34:
        r118.addTab(r109.f293153b.newTab().setText(com.larus.utils.j0.d(R.string.larus_dora_environmental_data_personal_tab_cn)));
        LarusActivityDoraMemoryDataBinding r119 = this.f292209g;
        if (r119 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L37:
        r119.f293153b.addOnTabSelectedListener(new o(this));
        LarusActivityDoraMemoryDataBinding r120 = this.f292209g;
        if (r120 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L41:
        r100.f293155d.registerOnPageChangeCallback(new DoraEnvObserveMemoryDataActivity$setupView$4(this));
        return;
    L40:
        r100 = r120;
    L44:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r101)));
    }
}
