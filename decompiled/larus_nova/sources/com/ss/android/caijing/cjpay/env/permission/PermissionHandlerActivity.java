package com.ss.android.caijing.cjpay.env.permission;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.router.CJRouteOutMonitorUtils;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.api.permissions.PermissionsService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f06.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import v19.f;

/* JADX INFO: loaded from: classes34.dex */
public class PermissionHandlerActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f407969b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cta.a f407970a;

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermissionHandlerActivity f407971a;

        public a(PermissionHandlerActivity r100) {
            this.f407971a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            cta.a r102 = this.f407971a.f407970a;
            if (r102 == null) goto L5;
            r102.a();
        L5:
            this.f407971a.A1();
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermissionHandlerActivity f407972a;

        public b(PermissionHandlerActivity r100) {
            this.f407972a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            PermissionHandlerActivity r102 = this.f407972a;
            String r103 = PermissionHandlerActivity.f407969b;
            r102.getClass();
            Intent r104 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: Exception -> L5
            r104.setData(Uri.fromParts("package", r102.getPackageName(), null));     // Catch: Exception -> L5
            CJRouteOutMonitorUtils.INSTANCE.injectRouteOutCertIdToIntent("41489154", r104);     // Catch: Exception -> L5
            r102.startActivityForResult(r104, 2);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("PermissionHandlerActivity#openAppSetting", e);
            CJLogger.b("PermissionHandler", "open app setting failed");
            cta.a r105 = r102.f407970a;
            if (r105 == null) goto L9;
            r105.a();
        L9:
            r102.A1();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final void A1() {
    L41:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionHandlerActivity#showNeverAskRationaleDialog", th);
        CJLogger.c("PermissionHandlerActivity", "requestNext", th);
        return;
    L3:
        if (isFinishing() == false) goto L5;
        return;
    L5:
        cta.b r100 = cta.b.C5585b.f465375a;     // Catch: Throwable -> L41
        Context r101 = getApplicationContext();     // Catch: Throwable -> L41
        monitor-enter(r100);     // Catch: Throwable -> L41
        cta.a r102 = null;
    L44:
        List<cta.a> r103 = r100.f465373a;     // Catch: Throwable -> L38
        int r104 = 0;
        if (r103 == null) goto L14;
        if (((ArrayList) r103).size() <= 0) goto L14;
        cta.a r105 = (cta.a) ListProtector.get(r100.f465373a, 0);     // Catch: Throwable -> L38
        ListProtector.remove(r100.f465373a, 0);     // Catch: Throwable -> L38
        r102 = cta.b.a(r101, r105);     // Catch: Throwable -> L38
        if (r102 == null) goto L44;
    L14:
        if (r102 != null) goto L16;
        r100.f465374b = false;     // Catch: Throwable -> L38
    L16:
        monitor-exit(r100);     // Catch: Throwable -> L41
        this.f407970a = r102;     // Catch: Throwable -> L41
        if (r102 == null) goto L37;
        String[] r106 = r102.f465369b;     // Catch: Throwable -> L41
        if (r106 != null) goto L22;
        return;
    L22:
        if (r106.length <= 0) goto L55;
        B1(r106);     // Catch: Exception -> L25 Throwable -> L41
    L58:
        return;
    L25:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionHandlerActivity#requestNext", e);     // Catch: Throwable -> L41
        CJBasicCommonUtils.logCatch("CJCatch", "PermissionHandlerActivity#requestNext", e);     // Catch: Throwable -> L41
        String[] r107 = this.f407970a.f465370c;     // Catch: Throwable -> L41
        if (r107 != null) goto L29;
    L35:
        String r108 = "";
    L36:
        C1(this, r108);     // Catch: Throwable -> L41
        return;
    L29:
        if (r107.length == 0) goto L35;
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L41
        int r110 = r107.length;     // Catch: Throwable -> L41
    L32:
        if (r104 >= r110) goto L34;
        r109.append(r107[r104]);     // Catch: Throwable -> L41
        r104 = r104 + 1;     // Catch: Throwable -> L41
        goto L32
    L34:
        r108 = r109.toString();     // Catch: Throwable -> L41
        goto L36
    L55:
        return;
    L37:
        finish();     // Catch: Throwable -> L41
        return;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
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
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public PermissionHandlerActivity() {
    }

    public static View y1(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void B1(String[] r100) {
        ve4.a.f554342a.getClass();
        PermissionsService r101 = (PermissionsService) ve4.a.a(PermissionsService.class);
        if (r101 == null) goto L6;
        r101.permissionsRequest("upload_id_card", new cta.c(this, r100));
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        CJLogger.d("PermissionHandlerActivity", WidgetCostModule.TYPE_ON_CREATE);
        if (getIntent() != null) goto L13;
    L34:
        cta.b.C5585b.f465375a.getClass();
        new WeakReference(this);
        A1();
        return;
    L13:
        if (getIntent().hasExtra("is_immersive") == false) goto L34;
        if (getIntent().getBooleanExtra("is_immersive", false) == false) goto L34;
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L32
        getWindow().setSoftInputMode(3);     // Catch: Throwable -> L32
        if (r101 < 29) goto L21;
        getWindow().setNavigationBarContrastEnforced(false);     // Catch: Throwable -> L32
    L21:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L28;
        getWindow().addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L32
        getWindow().setStatusBarColor(Color.parseColor("#00000000"));     // Catch: Throwable -> L32
        getWindow().setNavigationBarColor(Color.parseColor("#00000000"));     // Catch: Throwable -> L32
        if (r101 < 23) goto L25;
        int r102 = 9216;
    L26:
        View r103 = y1(getWindow());     // Catch: Throwable -> L32
        r103.setSystemUiVisibility(r102 | 512);     // Catch: Throwable -> L32
        goto L28
    L25:
        r102 = 1024;
    L28:
        if (r101 < 28) goto L30;
        WindowManager.LayoutParams r104 = getWindow().getAttributes();     // Catch: Throwable -> L32
        r104.layoutInDisplayCutoutMode = 1;     // Catch: Throwable -> L32
        getWindow().setAttributes(r104);     // Catch: Throwable -> L32
    L30:
        CJPayThemeManager.getInstance().adjustStatusBarMode(this, null, false);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionHandlerActivity#setFullScreen", th);
        CJBasicCommonUtils.logCatch("CJCatch", "PermissionHandlerActivity#setFullScreen", th);
        goto L34
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        A1();
    }

    public final void C1(Context r100, String r101) {
        if (isFinishing() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        StringBuilder r102 = new StringBuilder(r101.substring(0, r101.length() - 1));
        r102.append("。\n操作路径：设置->应用->");
        String r103 = f407969b;
        if (r103 == null) goto L28;
    L14:
        r102.append(r103);
        r102.append("->权限");
        AlertDialog r104 = new AlertDialog.Builder(r100).setTitle("我们需要一些权限").setMessage(r102).setPositiveButton("去设置", new b(this)).setNegativeButton("取消", new a(this)).setCancelable(false).create();
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r104);
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L18:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        return;
    L28:
        PackageManager r105 = getApplicationContext().getPackageManager();     // Catch: Exception -> L12
        r103 = r105.getApplicationLabel(r105.getApplicationInfo(getPackageName(), 128)).toString();     // Catch: Exception -> L12
        f407969b = r103;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionHandlerActivity#getAppLabel", e);
        CJLogger.b("PermissionHandler", "get app label failed");
        r103 = "应用名称";
        goto L14
    L20:
        cta.a r106 = this.f407970a;
        if (r106 == null) goto L23;
        r106.a();
    L23:
        A1();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 != 2) goto L9;
        cta.b r103 = cta.b.C5585b.f465375a;
        Context r104 = getApplicationContext();
        cta.a r105 = this.f407970a;
        r103.getClass();
        cta.a r106 = cta.b.a(r104, r105);
        this.f407970a = r106;
        if (r106 == null) goto L7;
        r106.a();
    L7:
        A1();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {Integer.valueOf(r210), r211, r212};
        f06.b r112 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(102611);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r113 = r104;
        int r114 = r103;
        f06.a[] r213 = r102;
        d r106 = r105.preInvoke(102611, "androidx/appcompat/app/AppCompatActivity", "onRequestPermissionsResult", this, r111, "void", r112);     // Catch: Exception -> L36
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L36
    L17:
        if (r106.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r210, r211, r212);
    L20:
        if (r210 == 0) goto L22;
        return;
    L22:
        if (this.f407970a != null) goto L25;
        A1();
        return;
    L25:
        int r115 = 0;
    L27:
        if (r115 >= r211.length) goto L33;
        cta.a r107 = this.f407970a;
        String r108 = r211[r115];
        int r109 = r212[r115];
        Map<String, Integer> r116 = r107.f465371d;
        if (r116 == null) goto L31;
        ((HashMap) r116).put(r108, Integer.valueOf(r109));
    L31:
        r115 = r115 + 1;
        goto L27
    L33:
        if (z1(r211, this.f407970a.f465370c, r212) == true) goto L46;
        this.f407970a.a();
        A1();
        return;
    L46:
        return;
    L14:
        r104 = r113 + 1;
        r103 = r114;
        r102 = r213;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }

    public final boolean z1(String[] r100, String[] r101, int[] r102) {
        int r103 = 0;
        if (isFinishing() == false) goto L5;
        return false;
    L5:
        StringBuilder r104 = new StringBuilder();
        boolean r105 = false;
    L7:
        if (r103 >= r100.length) goto L17;
        if (r102[r103] != (-1)) goto L17;
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, r100[r103]) == true) goto L16;
        if (r101[r103].isEmpty() == true) goto L15;
        r104.append(r101[r103]);
    L15:
        r105 = true;
    L16:
        r103 = r103 + 1;
    L17:
        if (r105 == false) goto L19;
        C1(this, r104.toString());
    L19:
        return r105;
    }
}
