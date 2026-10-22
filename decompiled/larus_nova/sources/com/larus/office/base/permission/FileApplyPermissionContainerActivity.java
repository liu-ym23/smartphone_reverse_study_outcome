package com.larus.office.base.permission;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/larus/office/base/permission/FileApplyPermissionContainerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "ensureOfficeSdkReady", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileApplyPermissionContainerActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f360607a = 0;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(FileApplyPermissionContainerActivity.class.getName()));
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FileApplyPermissionContainerActivity.class.getName()));
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

    public FileApplyPermissionContainerActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        v19.f.a(getTheme());
        super.onCreate(r100);
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onCreate: token=");
        int r103 = com.larus.office.base.utils.f.f361173a;
        Intent r104 = getIntent();
        Bundle r105 = null;
        if (r104 == null) goto L13;
        String r106 = r104.getStringExtra("office_permission_doc_token");
    L14:
        r102.append(com.larus.office.base.utils.f.b(r106));
        r102.append(", docType=");
        Intent r107 = getIntent();
        if (r107 == null) goto L17;
        Long r108 = Long.valueOf(r107.getLongExtra("office_permission_doc_type", 0));
    L18:
        r102.append(r108);
        r102.append(", needPwd=");
        Intent r109 = getIntent();
        boolean r110 = false;
        if (r109 == null) goto L21;
        Boolean r111 = Boolean.valueOf(r109.getBooleanExtra("office_permission_need_input_password", false));
    L22:
        r102.append(r111);
        r102.append(", canApply=");
        Intent r112 = getIntent();
        if (r112 == null) goto L25;
        Boolean r113 = Boolean.valueOf(r112.getBooleanExtra("office_permission_can_apply_permission", true));
    L26:
        r102.append(r113);
        r101.i("FileApplyPermContainer", r102.toString());
        r101.i("FileApplyPermContainer", "ensureOfficeSdkReady: start");     // Catch: Exception -> L32
        IOfficeSdkServiceV2 r114 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L32
        if (r114 == null) goto L30;
        IOfficeSdkServiceV2.a.b(r114, false, null, 7);     // Catch: Exception -> L32
    L30:
        r101.i("FileApplyPermContainer", "ensureOfficeSdkReady: done");     // Catch: Exception -> L32
    L35:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L37;
        r110 = true;
    L37:
        v19.h.f552477a = r110;
        com.larus.utils.u.e(this, true, r110);
        com.larus.utils.u.d(this);
        setContentView(com.larus.nova.R.layout.larus_activity_file_apply_permission_container);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(com.larus.nova.R.id.file_apply_permission_container), new i());
        if (r100 != null) goto L53;
        FragmentTransaction r115 = getSupportFragmentManager().beginTransaction();
        FileApplyPermissionContainerFragment r116 = new FileApplyPermissionContainerFragment();
        Intent r117 = getIntent();
        if (r117 == null) goto L43;
        r105 = r117.getExtras();
    L43:
        r116.setArguments(r105);
        Unit r118 = Unit.INSTANCE;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r115, r116, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "file_apply_permission_container_fragment", com.larus.nova.R.id.file_apply_permission_container) == true) goto L47;
        r115 = r115.replace(com.larus.nova.R.id.file_apply_permission_container, r116, "file_apply_permission_container_fragment");
    L47:
        r115.commitAllowingStateLoss();
        return;
    L53:
        return;
    L32:
        e = move-exception;
        FLogger.f375446a.e("FileApplyPermContainer", "ensureOfficeSdkReady failed: " + e.getMessage());
        goto L35
    L25:
        r113 = null;
        goto L26
    L21:
        r111 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    }
}
