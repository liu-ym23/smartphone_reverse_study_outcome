package com.ss.android.lark.cameraview;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.camera_export.CameraConstants;
import com.ss.android.lark.camera_export.CameraFG;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.camera_export.ILarkCameraDependency;
import com.ss.android.lark.cameraexport.CameraLaunchMonitor;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.forsetiutils.ForsetiEmbeddedUtils;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001a\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0014J\"\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0010H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006$"}, d2 = {"Lcom/ss/android/lark/cameraview/VECameraActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "cameraParam", "Lcom/ss/android/lark/camera_export/CameraParam;", "getCameraParam", "()Lcom/ss/android/lark/camera_export/CameraParam;", "cameraParam$delegate", "Lkotlin/Lazy;", "cameraDependency", "Lcom/ss/android/lark/camera_export/ILarkCameraDependency;", "kotlin.jvm.PlatformType", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "initNavigationBarView", "setupFragment", "useNewVeCamera", "", LiveCommonConstants.REASON_ON_DEDTROY, "onResume", "mOnTakePhotoVideoListener", "com/ss/android/lark/cameraview/VECameraActivity$mOnTakePhotoVideoListener$1", "Lcom/ss/android/lark/cameraview/VECameraActivity$mOnTakePhotoVideoListener$1;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "Companion", "cameraview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VECameraActivity extends BaseFragmentActivity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f410850e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f410851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ILarkCameraDependency f410852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Fragment f410853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f410854d;

    public static final class a {
    }

    public static final class b implements x0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VECameraActivity f410855a;

        @Override // com.ss.android.lark.cameraview.x0
        public final void d() {
        }

        @Override // com.ss.android.lark.cameraview.x0
        public final void onCloseClick() {
            this.f410855a.finish();
        }

        public b(VECameraActivity r100) {
            this.f410855a = r100;
        }

        @Override // com.ss.android.lark.cameraview.x0
        public final boolean a(String r100) {
            if (r100 != null) goto L5;
        L21:
            Log.e("VECameraActivity", "path is not exits: " + r100);
            this.f410855a.finish();
            return false;
        L5:
            if (FileUtils.r(r100) == false) goto L21;
            Bundle r101 = this.f410855a.getIntent().getExtras();
            if (r101 != null) goto L10;
        L20:
            return false;
        L10:
            if (r101.containsKey(CameraConstants.KEY_CAMERA_INPUT_PARAM) == false) goto L20;
            CameraParam r102 = (CameraParam) r101.getSerializable(CameraConstants.KEY_CAMERA_INPUT_PARAM);
            if (r102 != null) goto L14;
        L16:
            boolean r103 = false;
        L17:
            if (r103 == false) goto L20;
            this.f410855a.f410852b.saveCameraResultToGallery(r100);
            return true;
        L14:
            if (r102.isSaveGallery() != true) goto L16;
            r103 = true;
            goto L17
        }

        @Override // com.ss.android.lark.cameraview.x0
        public final void b(String r100) {
            VECameraActivity r101 = this.f410855a;
            r101.f410852b.onTakeMedia(r101, r100, CameraParam.TYPE_VE_CAMERA);
        }

        @Override // com.ss.android.lark.cameraview.x0
        public final void c(String r100) {
            if (r100 == null) goto L5;
            VECameraActivity r101 = this.f410855a;
            r101.f410852b.openPhotoEditor(r101, r100, 3);
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VECameraActivity.class.getName()));
    L5:
        super.onDestroy();
        this.f410852b.onDestroy(this);
    }

    public VECameraActivity() {
        this.f410851a = LazyKt.lazy(new VECameraActivity$cameraParam$2(this));
        this.f410852b = (ILarkCameraDependency) ApiUtils.getApi(ILarkCameraDependency.class);
        this.f410854d = new b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(VECameraActivity.class.getName()));
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

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        z1();
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

    public final void z1() {
        WindowInsetsUtils.f(this);
        WindowInsetsUtils.e(this);
        com.ss.android.lark.insets.h r100 = WindowInsetsUtils.c(this);
        r100.i(UIUtils.getColor(this, com.larus.nova.R.color.static_black));
        r100.f(false);
        r100.o(true);
        r100.c(false);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        finish();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        getWindow().addFlags(128);
        super.onCreate(r100);
        if (CameraFG.getEnableVECameraPortrait() == false) goto L13;
    L16:
        setRequestedOrientation(1);
    L17:
        setContentView(com.larus.nova.R.layout.activity_camera_view_layout);
        if (((CameraParam) this.f410851a.getValue()).isNewVeCamera() == false) goto L20;
        CameraParam r101 = (CameraParam) this.f410851a.getValue();
        Fragment r102 = new CameraViewFragmentV2();
        Bundle r103 = new Bundle();
        r103.putSerializable(CameraConstants.KEY_CAMERA_INPUT_PARAM, r101);
        r102.setArguments(r103);
    L21:
        this.f410853c = r102;
        FragmentTransaction r104 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r104, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, com.larus.nova.R.id.camera_view_fragment) == true) goto L25;
        r104 = r104.replace(com.larus.nova.R.id.camera_view_fragment, r102);
    L25:
        r104.commitAllowingStateLoss();
        if ((r102 instanceof CameraViewFragment) == false) goto L29;
        b r105 = this.f410854d;
        ((CameraViewFragment) r102).f410794f = r105;
    L31:
        this.f410852b.onCreate(this);
        CameraLaunchMonitor.onOpenCameraStart();
        z1();
        return;
    L29:
        if ((r102 instanceof CameraViewFragmentV2) == false) goto L31;
        b r106 = this.f410854d;
        ((CameraViewFragmentV2) r102).f410802f = r106;
        goto L31
    L20:
        CameraParam r107 = (CameraParam) this.f410851a.getValue();
        r102 = new CameraViewFragment();
        Bundle r108 = new Bundle();
        r108.putSerializable(CameraConstants.KEY_CAMERA_INPUT_PARAM, r107);
        r102.setArguments(r108);
        goto L21
    L13:
        if (ForsetiConfig.a(this) == false) goto L16;
        if (ForsetiEmbeddedUtils.f() == false) goto L17;
        goto L16
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Fragment r103 = this.f410853c;
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
    L6:
        if (r100 != 3) goto L12;
        if (r102 == null) goto L13;
        Bundle r104 = r102.getExtras();
        if (r104 == null) goto L14;
        this.f410852b.onEditPhotoResult(this, r104, CameraParam.TYPE_VE_CAMERA);
        return;
    L14:
        return;
    L13:
        return;
    }
}
