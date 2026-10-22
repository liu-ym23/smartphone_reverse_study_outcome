package com.ss.android.lark.widget.photo.preview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.palette.widget.ConstraintLayoutPalette;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.perf.ResourcePerfMonitor;
import com.ss.android.lark.security.compliance.api.params.FlagState;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.lark.widget.photo.preview.utils.PhotoPagerFgUtils;
import com.ss.android.lark.widget.photo.preview.video.online.f0;
import com.ss.android.lark.widget.photo.preview.video.online.j0;
import com.ss.android.lark.widget.photo.preview.video.pip.PipModeProcessor;
import com.ss.android.lark.widget.photopicker.animation.BaseData;
import com.ss.android.lark.widget.photopicker.coordinator.PhotoPreviewCoordinator;
import com.ss.android.lark.widget.photopicker.coordinator.PreviewEvent;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.gallery.callback.OnImageSelectListener;
import com.ss.android.lark.widget.previewanimation.PreviewAnimation;
import com.ss.android.lark.widget.previewanimation.player.image.ImageScaleTransformPlayer;
import com.ss.android.lark.widget.previewanimation.toolkit.DragScaleView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001SB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001c\u001a\u00020\u000fH\u0014J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u000fH\u0016J\b\u0010$\u001a\u00020\u001eH\u0014J\b\u0010%\u001a\u00020\u001eH\u0014J\u0018\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0014H\u0002J\b\u00100\u001a\u00020\u001eH\u0002J\b\u00101\u001a\u00020\u001eH\u0002J\b\u00102\u001a\u00020\u001eH\u0002J\b\u00103\u001a\u00020\u001eH\u0002J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0014J\u0010\u00107\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0016J\"\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020\u000f2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001e09H\u0002J\b\u0010>\u001a\u00020\u001eH\u0002J\b\u0010?\u001a\u00020\u001eH\u0002J\u0016\u0010@\u001a\u00020\u000f2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001e09H\u0002J\b\u0010A\u001a\u00020\u001eH\u0016J \u0010B\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020EH\u0016J \u0010F\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020EH\u0016J \u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020EH\u0016J\"\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\r2\b\u0010O\u001a\u0004\u0018\u000106H\u0014J\b\u0010P\u001a\u00020\u001eH\u0016J\b\u0010Q\u001a\u00020\u001eH\u0014J\b\u0010R\u001a\u00020\u001eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e09X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/PhotoPagerActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/ss/android/lark/widget/photopicker/gallery/callback/DragListener;", "<init>", "()V", "pagerFragment", "Lcom/ss/android/lark/widget/photo/preview/PhotoPagerFragment;", "mInitData", "Lcom/ss/android/lark/widget/photo/preview/PhotoPagerInitData;", "mInitialPhotoItem", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "mInitialPhotoCount", "", "mIsLandscape", "", "enterRecord", "Lcom/ss/android/lark/widget/previewanimation/AnimationRecord;", "Lcom/ss/android/lark/widget/previewanimation/player/image/ImageScaleTransformPlayer;", "pagerWrapper", "Landroid/view/ViewGroup;", "animationContainer", "activityCreateTimestamp", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "isDoAnimationWithDefault", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "initNavigationBarView", "onWindowFocusChanged", "hasFocus", "onResume", "onPause", "onPictureInPictureModeChanged", "isInPictureInPictureMode", "newConfig", "Landroid/content/res/Configuration;", "parseArguments", "setIsSecureActivityIfNeed", "enable", "initView", "handleEnterAnimation", KtvSubElement.CONTAINER, "scheduleEnterAnimation", "initPagerBgColor", "preparePagerFragment", "initFragmentInner", "onNewIntent", "intent", "Landroid/content/Intent;", "onConfigurationChanged", "onResultAction", "Lkotlin/Function0;", "scheduleTransformExitAnimation", "Lkotlinx/coroutines/Job;", "useCompatMode", "actionOnAnimEnd", "restoreStatusBarForExit", "hideWaterMark", "updateAnimationDrawableIfPageChange", "onBackPressed", com.alipay.sdk.m.x.d.f25928r, "currentIndex", "dragStateInfo", "Lcom/ss/android/lark/widget/previewanimation/toolkit/DragScaleView$DragStateInfo;", "onDragStart", "onDragRestore", "dragScaleView", "Lcom/ss/android/lark/widget/previewanimation/toolkit/DragScaleView;", "CurrentIndex", "DragStateInfo", "onActivityResult", "requestCode", "resultCode", "data", VideoEventOneOutSync.END_TYPE_FINISH, "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoPagerActivity extends BaseFragmentActivity implements CoroutineScope, idc.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f446498j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PhotoPagerFragment f446499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PhotoPagerInitData f446500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PhotoItem f446501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.widget.previewanimation.a<ImageScaleTransformPlayer> f446502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f446503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f446504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f446505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineContext f446506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f446507i;

    public static final class a {
    }

    public static final class b implements PhotoPagerFragment.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoPagerActivity f446508a;

        public b(PhotoPagerActivity r100) {
            this.f446508a = r100;
        }

        @Override // com.ss.android.lark.widget.photo.preview.PhotoPagerFragment.b
        public final void a(ConstraintLayoutPalette r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            PhotoPagerActivity r101 = this.f446508a;
            int r102 = PhotoPagerActivity.f446498j;
            PhotoPagerFragment r103 = r101.f446499a;
            if (r103 == null) goto L5;
            r103.f446531j = r101;
        L5:
            r101.B1();
        }
    }

    static {
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final boolean isDoAnimationWithDefault() {
        return false;
    }

    public final boolean C1() {
        Bundle r100 = this.mBundle;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L18;
        PhotoPagerInitData.b r102 = PhotoPagerInitData.Companion;
        Bundle r103 = this.mBundle;
        r102.getClass();
        PhotoPagerInitData r104 = PhotoPagerInitData.b.a(r103);
        this.f446500b = r104;
        r104.getPhotoItem().size();
        this.f446501c = (PhotoItem) CollectionsKt.getOrNull(r104.getPhotoItem(), r104.getCurrentItem());
        PhotoPagerInitData r105 = this.f446500b;
        if (r105 != null) goto L10;
    L12:
        boolean r106 = !r101;
        Window r107 = getWindow();
        if (r106 == false) goto L15;
        Log.i("PhotoPagerActivity", "secret chat screen security is off");
        com.ss.android.lark.widget.photopicker.f.a().getSecurityComplianceDependency();
        Log.i("PhotoPagerActivity", "admin screen security is off");
        r107.clearFlags(8192);
    L17:
        return !CollectionUtils.isEmpty(r104.getPhotoItem());
    L15:
        getIntent().putExtra("SCS_FLAG_STATE", FlagState.Ban.getValue());
        Log.i("PhotoPagerActivity", "secret chat screen security is on, banned screenshot");
        r107.setFlags(8192, 8192);
        goto L17
    L10:
        if (r105.isSecure() != true) goto L12;
        r101 = true;
        goto L12
    }

    public final void D1() {
        PhotoPagerInitData r100 = this.f446500b;
        PhotoPagerFragment r101 = com.ss.android.lark.widget.photopicker.utils.m.b(this, null, getIntent().getExtras(), r100);
        this.f446499a = r101;
        if (r101.f446537p != true) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r101.f446531j = this;
        B1();
    L8:
        PhotoPagerFragment r103 = this.f446499a;
        if (r103 == null) goto L11;
        b r104 = new b(this);
        Intrinsics.checkNotNullParameter(r104, "listener");
        r103.f446534m = r104;
    L11:
        PhotoPagerFragment r105 = this.f446499a;
        if (r105 == null) goto L16;
        r105.f446533l = true;
        DragScaleView r106 = r105.f446530i;
        if (r106 == null) goto L16;
        Intrinsics.checkNotNull(r106);
        r106.setEnableDrag(true);
    L16:
        this.f446503e = (ViewGroup) findViewById(R.id.frame_layout);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        Log.i("PhotoPagerActivity", "onBackPressed, createTime: " + this.f446505g);
        Function0<Unit> r100 = this.f446507i;
        BuildersKt.launch$default(this, null, null, new PhotoPagerActivity$scheduleTransformExitAnimation$2(this, r100, F1(r100), null), 3, null);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PhotoPagerActivity.class.getName()));
    L5:
        Log.i("PhotoPagerActivity", "onDestroy, createTime: " + this.f446505g);
        ResourcePerfMonitor.IMAGE_PREVIEW.onEnd();
        PhotoPagerFragment r100 = this.f446499a;
        if (r100 == null) goto L10;
        PhotoItem r101 = r100.T90();
        if (r101 == null) goto L10;
        String r102 = r101.getImageKey();
    L11:
        PhotoPagerFragment r103 = this.f446499a;
        if (r103 == null) goto L18;
        PhotoPagerInitData r104 = r103.f446542u;
        if (r104 == null) goto L18;
        OnImageSelectListener r105 = r104.getImageSelectListener();
        if (r105 == null) goto L18;
        r105.exitListener(r102);
    L18:
        super.onDestroy();
        return;
    L10:
        r102 = null;
        goto L11
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        Log.i("PhotoPagerActivity", "onStop, createTime: " + this.f446505g);
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        z1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public PhotoPagerActivity() {
        this.f446505g = -1;
        this.f446506h = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain());
        this.f446507i = new PhotoPagerActivity$onResultAction$1(this);
    }

    public final void B1() {
        Bundle r100 = getIntent().getExtras();
        if (r100 == null) goto L12;
        String r101 = (String) com.ss.android.lark.widget.photopicker.animation.c.b(this, "APPLICATION_ID");
        int r102 = BaseData.AnimationType.TRANSLATE_ANIMATION.getValue();
        if (r100.getInt(r101 + ".animationtype", r102) != r102) goto L7;
        boolean r103 = true;
    L8:
        PhotoPagerFragment r104 = this.f446499a;
        if (r104 == null) goto L13;
        r104.W90(r103);
        return;
    L13:
        return;
    L7:
        r103 = false;
        goto L8
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0125 */
    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        Log.i("PhotoPagerActivity", "finish, createTime: " + this.f446505g);
        this.f446507i.invoke();
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(PhotoPagerActivity.class.getName()));
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

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (((Boolean) PhotoPagerFgUtils.f447141f.getValue()).booleanValue() == false) goto L6;
        setRequestedOrientation(3);
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (((Boolean) PhotoPagerFgUtils.f447141f.getValue()).booleanValue() == false) goto L6;
        setRequestedOrientation(2);
        return;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f446506h;
    }

    public static View z1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void A1(ViewGroup r100) {
        PreviewAnimation r101 = (PreviewAnimation) this.mBundle.getParcelable("PreviewAnimation:key:name");
        ViewGroup r102 = null;
        if (r101 != null) goto L10;
        ViewGroup r103 = this.f446503e;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("pagerWrapper");
    L8:
        r102.setVisibility(0);
        return;
    L7:
        r102 = r103;
        goto L8
    L10:
        BuildersKt.launch$default(this, null, null, new PhotoPagerActivity$handleEnterAnimation$1(r101, r100, this, null), 3, null);
    }

    public final boolean F1(Function0<Unit> r100) {
        PhotoPagerFragment r101 = this.f446499a;
        if (r101 == null) goto L5;
        PhotoItem r102 = r101.T90();
    L7:
        if (r102 != null) goto L10;
        r100.invoke();
        finish();
        return false;
    L10:
        PhotoPreviewCoordinator.Companion.getClass();
        Drawable r103 = PhotoPreviewCoordinator.a.b(this).getCurrentPhotoDrawable();
        if (r103 == null) goto L20;
        if (Intrinsics.areEqual(r102, this.f446501c) == true) goto L20;
        com.ss.android.lark.widget.previewanimation.a<ImageScaleTransformPlayer> r104 = this.f446502d;
        if (r104 == null) goto L20;
        ImageScaleTransformPlayer r105 = (ImageScaleTransformPlayer) r104.a();
        if (r105 == null) goto L20;
        Intrinsics.checkNotNullParameter(r103, "drawable");
        r105.f448009a = r103;
        r103.setBounds(0, 0, r103.getIntrinsicWidth(), r103.getIntrinsicHeight());
        r105.e();
    L20:
        return !Intrinsics.areEqual(r102, this.f446501c);
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r100 == null) goto L8;
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L17
    L9:
        if (r102 != null) goto L12;
    L14:
        if (r101 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:PhotoPagerActivity portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r102.intValue() == r101) goto L19;
    L8:
        r102 = null;
    L19:
        int r103 = r100.orientation;
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        int r101 = com.ss.android.lark.widget.photo.preview.utils.a.f447152a;
        com.ss.android.lark.widget.photo.preview.video.pip.b r102 = (com.ss.android.lark.widget.photo.preview.video.pip.b) com.ss.android.lark.widget.photo.preview.utils.a.c(com.ss.android.lark.widget.photo.preview.video.pip.b.class);
        if (r102 == null) goto L13;
        r102.H4(this);
    L13:
        ResourcePerfMonitor.IMAGE_PREVIEW.onStart();
        fsb.f.c("PhotoPagerActivity").j();
        fsb.f.b().i("setContentView");
        super.onCreate(r100);
        setContentView(R.layout.__picker_activity_photo_pager);
        fsb.f.b().h("setContentView");
        if (C1() == true) goto L16;
        finish();
        fsb.f.b().d();
    L16:
        this.f446504f = (ViewGroup) findViewById(R.id.preview_animation_container);
        D1();
        ViewGroup r103 = this.f446503e;
        ViewGroup r104 = null;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("pagerWrapper");
        r103 = null;
    L19:
        r103.setVisibility(4);
        ViewGroup r105 = this.f446504f;
        if (r105 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("animationContainer");
    L23:
        r104.post(new com.ss.android.lark.widget.photo.preview.a(this, r104));
        if (CarUtils.a() == false) goto L26;
        getWindow().clearFlags(1024);
        WindowInsetsUtils.f(this);
        com.ss.android.lark.insets.h r106 = WindowInsetsUtils.c(this);
        r106.f(true);
        r106.o(true);
        r106.c(true);
        r106.k(true);
        r106.b(-16777216);
        return;
    L26:
        WindowInsetsUtils.f(this);
        WindowInsetsUtils.e(this);
        WindowInsetsUtils.d(this);
        return;
    L22:
        r104 = r105;
        goto L23
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        super.onNewIntent(r100);
        Log.i("PhotoPagerActivity", "onNewIntent");
        setIntent(r100);
        this.mBundle = r100.getExtras();
        C1();
        D1();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        fsb.f.b().g();
    }

    @Override // idc.a
    public final void iY(DragScaleView r100, DragScaleView.c r101) {
        Intrinsics.checkNotNullParameter(r100, "dragScaleView");
        Intrinsics.checkNotNullParameter(r101, "DragStateInfo");
        PhotoPreviewCoordinator.Companion.getClass();
        PhotoPreviewCoordinator.dispatch$default(PhotoPreviewCoordinator.a.b(this), PreviewEvent.PAGER_ON_DRAG_SCALE_END, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.ss.android.lark.widget.photo.preview.video.online.j0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onPictureInPictureModeChanged(boolean r100, Configuration r101) {
        Intrinsics.checkNotNullParameter(r101, "newConfig");
        super.onPictureInPictureModeChanged(r100, r101);
        if (r100 == false) goto L12;
        com.ss.android.lark.widget.photo.preview.video.pip.a r102 = PipModeProcessor.f447398f;
        if (r102 == null) goto L35;
        final f0.e r103 = (f0.e) r102;
        Log.d("OnlineVideoGalleryView", "onEnterPipMode");
        vcc.a r104 = r103.f447352b.f447327h;
        if (r104 == null) goto L9;
        r104.u(true);
    L9:
        com.ss.android.lark.widget.photo.preview.video.pip.b r105 = r103.f447351a;
        if (r105 == null) goto L36;
        r105.ne(r103.f447352b.f447323d, true);
        r103.f447351a.K7(new j0(r103));
        return;
    L36:
        return;
    L35:
        return;
    L12:
        com.ss.android.lark.widget.photo.preview.video.pip.a r106 = PipModeProcessor.f447398f;
        if (r106 == null) goto L38;
        f0.e r107 = (f0.e) r106;
        Log.d("OnlineVideoGalleryView", "onExitPipMode");
        vcc.a r108 = r107.f447352b.f447327h;
        if (r108 == null) goto L17;
        r108.u(false);
    L17:
        FragmentActivity r109 = r107.f447352b.f447323d;
        if (r109 == null) goto L30;
        int r110 = f0.a.f447346a[r109.getLifecycle().getCurrentState().ordinal()];
        if (r110 != 1) goto L22;
        r107.f447352b.f447323d.finish();
    L31:
        com.ss.android.lark.widget.photo.preview.video.pip.b r111 = r107.f447351a;
        if (r111 == null) goto L39;
        r111.zc();
        return;
    L39:
        return;
    L22:
        if (r110 == 2) goto L24;
        Log.i("OnlineVideoGalleryView", "onExitPipMode activity state is not start.");
        goto L31
    L24:
        com.ss.android.lark.widget.photo.preview.video.pip.b r112 = r107.f447351a;
        if (r112 == null) goto L31;
        FragmentActivity r113 = r107.f447352b.f447323d;
        if (r113 == null) goto L31;
        r112.ne(r113, false);
        goto L31
    L30:
        Log.i("OnlineVideoGalleryView", "onExitPipMode activity is null.");
        goto L31
    }

    @Override // idc.a
    public final void tj(ViewGroup r100, DragScaleView.c r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "dragStateInfo");
        com.ss.android.lark.widget.previewanimation.a<ImageScaleTransformPlayer> r102 = this.f446502d;
        if (r102 == null) goto L7;
        ImageScaleTransformPlayer r103 = (ImageScaleTransformPlayer) r102.a();
        if (r103 == null) goto L7;
        r103.f448015g = udc.b.a(r101.f448037a, r103.f448015g);
        Rect r104 = r101.f448040d;
        Intrinsics.checkNotNullParameter(r104, "newBounds");
        r103.f448018j.set(r104);
    L7:
        boolean r105 = F1(this.f446507i);
        BuildersKt.launch$default(this, null, null, new PhotoPagerActivity$scheduleTransformExitAnimation$2(this, this.f446507i, r105, null), 3, null);
    }

    @Override // idc.a
    public final void wE(ViewGroup r100, DragScaleView.c r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "dragStateInfo");
        PhotoPreviewCoordinator.Companion.getClass();
        PhotoPreviewCoordinator.dispatch$default(PhotoPreviewCoordinator.a.b(this), PreviewEvent.PAGER_ON_DRAG_SCALE_BEGIN, null, 2, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        PhotoPagerFragment r103 = this.f446499a;
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
        return;
    }
}
