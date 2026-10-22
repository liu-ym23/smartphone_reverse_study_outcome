package com.bytedance.awemeopen.apps.framework.framework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.utils.d;
import com.bytedance.awemeopen.apps.framework.utils.j;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;
import w04.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseActivity;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "VM", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/content/Intent;", "intent", "", "requestCode", "Landroid/os/Bundle;", "options", "", "startActivityForResult", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosBaseActivity<VM extends AosViewModel> extends AppCompatActivity {
    public abstract void A1();

    public abstract void B1();

    public abstract void C1();

    public abstract void D1();

    public abstract void F1(Bundle r100);

    public abstract Class<VM> G1();

    public abstract void initView();

    public abstract int z1();

    public AosBaseActivity() {
        new LinkedHashMap();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (j.a() == false) goto L6;
        overridePendingTransition(R.anim.aos_slide_in_no, AosExtConfig.f193138b.U0().getExitAnim());
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L56:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
    L51:
        goto L56
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L51;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int r100 = d.f197686a;
        if (d.a.b(this) == true) goto L6;
        super.onBackPressed();
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        C1();
        D1();
    }

    public boolean y1() {
        return !n0.c(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        super.onCreate(r100);
        setContentView(z1());
        ViewModelProviderFactory r101 = ViewModelProviderFactory.f196951a;
        r101.getClass();
        Intrinsics.checkNotNullParameter((AosViewModel) new ViewModelProvider(this, r101).get(G1()), "<set-?>");
        F1(r100);
        initView();
        B1();
        A1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void setContentView(int r100) {
        super.setContentView(r100);
        int r101 = a.f557782a;
        boolean r102 = y1();
        Window r103 = getWindow();
        r103.clearFlags(67108864);
        View r104 = a.a(r103);
        if (r102 == false) goto L5;
        int r105 = 8192;
    L6:
        r104.setSystemUiVisibility(r105 | 1280);
        r103.addFlags(Integer.MIN_VALUE);
        r103.setStatusBarColor(getResources().getColor(android.R.color.transparent));
        return;
    L5:
        r105 = 0;
        goto L6
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r100, int r101, Bundle r102) {
        super.startActivityForResult(r100, r101, r102);
        if (j.a() == false) goto L6;
        overridePendingTransition(AosExtConfig.f193138b.U0().getEnterAnim(), R.anim.aos_slide_in_no);
        return;
    }
}
