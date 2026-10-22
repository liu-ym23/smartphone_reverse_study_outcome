package com.ss.android.lark.chat.video;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
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
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chat/video/VideoPreviewActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/chat/video/OnFragmentInteractListener;", "<init>", "()V", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "setupShareElementCallback", "listener", "Lcom/ss/android/lark/chat/video/SharedElementListener;", "isDoAnimationWithDefault", "", "onBackPressed", "onFragmentInflated", "onClosed", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPreviewActivity extends BaseFragmentActivity implements g {
    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final boolean isDoAnimationWithDefault() {
        return false;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(VideoPreviewActivity.class.getName()));
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

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VideoPreviewActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        StatusBarUtil.showStatusBar(this);
        Iterator<Fragment> r100 = getSupportFragmentManager().getFragments().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        ActivityResultCaller r101 = (Fragment) r100.next();
        if ((r101 instanceof a) == false) goto L4;
        if (((a) r101).onBackPressed() == false) goto L4;
        return;
    L10:
        super.onBackPressed();
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

    public VideoPreviewActivity() {
    }

    @Override // com.ss.android.lark.chat.video.g
    public final void j() {
        startPostponedEnterTransition();
    }

    @Override // com.ss.android.lark.chat.video.g
    public final void onClosed() {
        StatusBarUtil.showStatusBar(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        disableBlackStatusBarBeforeOnCreate();
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.activity_video_preview);
        StatusBarUtil.setTranslucentForImageView(this, 255, new View[]{findViewById(com.larus.nova.R.id.fragment_container)});
        postponeEnterTransition();
        String r101 = getIntent().getStringExtra("preview_origin_url");
        Image r102 = (Image) getIntent().getSerializableExtra("preview_cover");
        getIntent().getStringExtra("preview_i_frame_url");
        String r103 = getIntent().getStringExtra("preview_vid");
        FragmentTransaction r104 = getSupportFragmentManager().beginTransaction();
        if (TextUtils.isEmpty(r103) == true) goto L18;
        YoutubeVideoPreviewFragment r105 = new YoutubeVideoPreviewFragment();
        Bundle r106 = new Bundle();
        r106.putSerializable("param_vid", r103);
        r106.putSerializable("param_cover_image", r102);
        r105.setArguments(r106);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r104, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, com.larus.nova.R.id.fragment_container) == true) goto L16;
        r104.add(com.larus.nova.R.id.fragment_container, r105);
    L16:
        r104.commitNowAllowingStateLoss();
        getWindow().getSharedElementEnterTransition().addListener(new q(r105, this));
        return;
    L18:
        if (TextUtils.isEmpty(r101) == true) goto L24;
        int r107 = InnerVideoPreviewFragment.f416753o;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "videoOriginUrl");
        InnerVideoPreviewFragment r108 = new InnerVideoPreviewFragment();
        Bundle r109 = new Bundle();
        r109.putString("video_origin_url", r101);
        r109.putSerializable("video_cover", r102);
        r109.putSerializable("video_site", null);
        r108.setArguments(r109);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r104, r108, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, com.larus.nova.R.id.fragment_container) == true) goto L23;
        r104.add(com.larus.nova.R.id.fragment_container, r108);
    L23:
        r104.commitNowAllowingStateLoss();
        getWindow().getSharedElementEnterTransition().addListener(new q(r108, this));
        return;
    L24:
        finish();
    }
}
