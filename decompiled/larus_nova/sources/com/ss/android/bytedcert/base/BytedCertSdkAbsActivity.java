package com.ss.android.bytedcert.base;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.Lifecycle;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.face.ui.FaceDetectDialogActivity;
import com.ss.android.bytedcert.flow.base.AbsCertFlow;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.ablity.ICertLoadingDialog;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import com.ss.android.cert.manager.permission.PermissionHelper;
import com.ss.android.cert.manager.permission.PermissionRequest;
import com.ss.android.cert.manager.utils.LocaleHelper;
import java.util.HashMap;
import java.util.Map;
import rsa.i;
import v19.f;

/* JADX INFO: loaded from: classes34.dex */
public abstract class BytedCertSdkAbsActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f407260c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f407261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICertLoadingDialog f407262b;

    public static class a implements PermissionHelper.PermissionRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermissionHelper.PermissionRequestCallback f407263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f407264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f407265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f407266d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f407267e;

        @Override // com.ss.android.cert.manager.permission.PermissionHelper.PermissionRequestCallback
        public final void onRequest(boolean r100, boolean r101, HashMap<String, PermissionEntity> r102, String r103) {
            PermissionHelper.PermissionRequestCallback r104 = this.f407263a;
            if (r104 == null) goto L5;
            r104.onRequest(r100, r101, r102, r103);
        L5:
            if (r101 == false) goto L11;
            BytedCertSdkAbsActivity.f407260c = this.f407264b;
            Intent r105 = this.f407265c.b(this.f407266d, r100);
            Context r106 = this.f407266d;
            if ((r106 instanceof Activity) == false) goto L9;
            ((Activity) r106).startActivityForResult(r105, this.f407267e);
            return;
        L9:
            r105.setFlags(268435456);
            this.f407266d.startActivity(r105);
            return;
        }

        public a(PermissionHelper.PermissionRequestCallback r100, String r101, c r102, Context r103, int r104) {
            this.f407263a = r100;
            this.f407264b = r101;
            this.f407265c = r102;
            this.f407266d = r103;
            this.f407267e = r104;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BytedCertSdkAbsActivity f407268a;

        @Override // java.lang.Runnable
        public final void run() {
            rsa.b.b(this.f407268a.f407262b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(BytedCertSdkAbsActivity r100) {
            this.f407268a = r100;
        }
    }

    public interface c {
        HashMap<String, PermissionEntity> a(Context r100);

        Intent b(Context r100, boolean r101);
    }

    public abstract void A1(ICertFlow r100, ThemeConfig r101);

    public boolean C1() {
        return !(this instanceof FaceDetectDialogActivity);
    }

    public boolean D1() {
        return false;
    }

    public void hideLoading() {
        Handler r100 = this.f407261a;
        b r101 = new b(this);
        if (r100 == null) goto L13;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        r101.run();     // Catch: Exception -> L9
    L10:
        return;
    L7:
        r100.post(r101);     // Catch: Exception -> L9
    L14:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        hideLoading();
        this.f407261a.removeCallbacksAndMessages(null);
    }

    public BytedCertSdkAbsActivity() {
        this.f407261a = new Handler(Looper.getMainLooper());
        this.f407262b = null;
    }

    public final boolean B1() {
        if (isDestroyed() == false) goto L5;
    L8:
        return true;
    L5:
        if (isFinishing() == true) goto L8;
        return false;
    }

    /* JADX INFO: Removed unreachable split cross block B:56:0x0117 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (D1() == false) goto L6;
        overridePendingTransition(0, 0);
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L47;
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
    L53:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L53
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L53
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L53
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L53
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L53
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L53
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L53;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L53
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public ICertDialogDepend z1() {
        return BytedCertSdkManager.getInstance().getCertDialogDepend();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        if (TextUtils.isEmpty(f407260c) == true) goto L6;
        r100 = LocaleHelper.setLocale(r100, f407260c);
    L6:
        super.attachBaseContext(r100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        if (r110 == null) goto L13;
        finish();
        return;
    L13:
        Intent r111 = getIntent();
        if (r111 != null) goto L17;
        finish();
        return;
    L17:
        if (D1() == false) goto L19;
        overridePendingTransition(0, 0);
    L19:
        String r112 = r111.getStringExtra(BytedCertConstant.IntentKey.FLOW_ID);
        ICertFlow r113 = BytedCertManager.getInstance().getFlow(r112);
        if (r113 != null) goto L22;
        ThemeConfig r100 = BytedCertManager.getInstance().getThemeConfig();
    L23:
        int r101 = r100.faceLiveScreenBgColor();
        Window r102 = getWindow();
        int r103 = Build.VERSION.SDK_INT;
        r102.clearFlags(67108864);
        r102.addFlags(Integer.MIN_VALUE);
        r102.setStatusBarColor(r101);
        if (ColorUtils.calculateLuminance(r101) >= 0.5d) goto L28;
        if (r103 < 26) goto L30;
        i.a(r102).setSystemUiVisibility(16);
    L30:
        int r104 = r100.faceLiveNavBarColor();
        Window r105 = getWindow();
        r105.addFlags(Integer.MIN_VALUE);
        r105.setNavigationBarColor(r104);
        int r106 = i.a(getWindow()).getSystemUiVisibility();
        if (ColorUtils.calculateLuminance(r104) >= 0.5d) goto L34;
        if (r103 < 26) goto L36;
        r106 = r106 & (-17);
    L36:
        i.a(r105).setSystemUiVisibility(r106);
        if (C1() == false) goto L39;
        Window r107 = getWindow();
        r107.clearFlags(67108864);
        r107.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        r107.addFlags(Integer.MIN_VALUE);
        i.a(r107).setSystemUiVisibility(ISmModel.VERSION_0700);
        r107.setStatusBarColor(0);
        r107.setNavigationBarColor(0);
    L39:
        A1(r113, r100);
        return;
    L34:
        if (r103 < 26) goto L36;
        r106 = r106 | 16;
        goto L36
    L28:
        if (r103 < 23) goto L30;
        i.a(r102).setSystemUiVisibility(8192);
        goto L30
    L22:
        r100 = r113.getThemeConfig();
        goto L23
    }

    public static void y1(Context r100, int r110, String r111, c r112, PermissionHelper.OnPermissionEventListener r113, PermissionHelper.PermissionRequestCallback r114) {
        if (r100 != null) goto L6;
        if (r114 == null) goto L10;
        r114.onRequest(false, false, null, "none");
        return;
    L10:
        return;
    L6:
        if (r112 != null) goto L8;
        return;
    L8:
        PermissionHelper.checkRequestPermissions(r100, AbsCertFlow.getPermissionLocalStrings(r100, r111), r113, new PermissionRequest().setEntities(r112.a(r100)).setCallback(new a(r114, r111, r112, r100, r110)));
    }
}
