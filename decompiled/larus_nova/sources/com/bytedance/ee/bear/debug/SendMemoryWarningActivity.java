package com.bytedance.ee.bear.debug;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.debug.databinding.ActivitySendMemoryWarningBinding;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import jx4.x;
import jx4.y;
import jx4.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/debug/SendMemoryWarningActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "mBitableApi", "Lcom/bytedance/ee/bear/share/IBitableApi;", "binding", "Lcom/bytedance/ee/bear/debug/databinding/ActivitySendMemoryWarningBinding;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMemoryWarningActivity extends BaseActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.share.b f217358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActivitySendMemoryWarningBinding f217359d;

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(SendMemoryWarningActivity.class.getName()));
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
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(SendMemoryWarningActivity.class.getName()));
    L5:
        super.onDestroy();
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

    public SendMemoryWarningActivity() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        ActivitySendMemoryWarningBinding r101 = null;
        View r102 = getLayoutInflater().inflate(com.larus.nova.R.layout.activity_send_memory_warning, null, false);
        int r103 = com.larus.nova.R.id.container;
        if (((LinearLayout) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.container)) == null) goto L29;
        ConstraintLayout r104 = (ConstraintLayout) r102;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.sendNormalButton);
        if (r105 == null) goto L27;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.sendSeriousButton);
        if (r106 == null) goto L26;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.sendWarningButton);
        if (r107 != null) goto L11;
        r103 = com.larus.nova.R.id.sendWarningButton;
        goto L29
    L11:
        if (((TextView) ViewBindings.findChildViewById(r102, com.larus.nova.R.id.title)) == null) goto L24;
        this.f217359d = new ActivitySendMemoryWarningBinding(r104, r105, r106, r107);
        setContentView(r104);
        this.f217358c = (com.bytedance.ee.bear.share.b) org.koin.java.a.c(com.bytedance.ee.bear.share.b.class, null, null, 6);
        ActivitySendMemoryWarningBinding r108 = this.f217359d;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L15:
        r108.f217369b.setOnClickListener(new x(this));
        ActivitySendMemoryWarningBinding r109 = this.f217359d;
        if (r109 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L18:
        r109.f217371d.setOnClickListener(new y(this));
        ActivitySendMemoryWarningBinding r110 = this.f217359d;
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r101.f217370c.setOnClickListener(new z(this));
        return;
    L21:
        r101 = r110;
        goto L22
    L24:
        r103 = com.larus.nova.R.id.title;
        goto L29
    L26:
        r103 = com.larus.nova.R.id.sendSeriousButton;
        goto L29
    L27:
        r103 = com.larus.nova.R.id.sendNormalButton;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
