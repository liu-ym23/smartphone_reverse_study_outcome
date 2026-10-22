package com.ss.android.lark.imageqrcode.ui;

import android.R;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.utils.UIUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.BizType;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.imageqrcode.QRCodeContentInfo;
import com.ss.android.lark.imageqrcode.QRCodeShowParam;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u001b\u001a\u00020\u000e*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0002J\f\u0010&\u001a\u00020\u000e*\u00020'H\u0002J\b\u0010(\u001a\u00020\u000eH\u0014J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/imageqrcode/ui/ImageQRCodeSelectActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "requestCode", "", "Ljava/lang/Integer;", "mAnimatorSets", "Ljava/util/HashSet;", "Landroid/animation/AnimatorSet;", "Lkotlin/collections/HashSet;", "mHandler", "Landroid/os/Handler;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "init", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initView", "param", "Lcom/ss/android/lark/imageqrcode/QRCodeShowParam;", "showBubbles", "bgBitmap", "Landroid/graphics/Bitmap;", "addBubbleView", "Landroid/widget/FrameLayout;", "content", "Lcom/ss/android/lark/imageqrcode/QRCodeContentInfo;", "bgPixelRect", "Landroid/graphics/RectF;", "bubbleBitmap", "onSelect", "bubble", "msg", "", "startAnim", "Landroidx/appcompat/widget/AppCompatImageView;", LiveCommonConstants.REASON_ON_DEDTROY, "logMsg", "Companion", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageQRCodeSelectActivity extends BaseFragmentActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static QRCodeShowParam f426641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f426642e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f426643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<AnimatorSet> f426644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f426645c;

    public static final class a {
    }

    static {
        f426642e = UIHelper.dp2px(40.0f);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ImageQRCodeSelectActivity.class.getName()));
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

    public final void init() {
        QRCodeShowParam r100 = f426641d;
        if (r100 != null) goto L10;
        Bundle r101 = getIntent().getExtras();
        if (r101 == null) goto L7;
        Serializable r102 = r101.getSerializable("INPUT_PARAM_KEY_SHOW_PARAM");
    L8:
        r100 = (QRCodeShowParam) r102;
        goto L10
    L7:
        r102 = null;
    L10:
        if (r100 != null) goto L12;
    L55:
        Log.e("ImageQRCodeSelectActivity", "param is invalid, finish activity");
        finish();
        return;
    L12:
        if (r100.isInValid() == true) goto L55;
        ArrayList<QRCodeContentInfo> r103 = r100.getContentList();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L15:
        boolean r106 = true;
        if (r105.hasNext() == false) goto L25;
        Object r107 = r105.next();
        QRCodeContentInfo r108 = (QRCodeContentInfo) r107;
        if (r108.isEmpty() == false) goto L20;
    L22:
        r106 = false;
    L23:
        if (r106 == false) goto L15;
        r104.add(r107);
        goto L15
    L20:
        if (r108.isVisible() == false) goto L22;
    L25:
        ArrayList<QRCodeContentInfo> r109 = (ArrayList) CollectionsKt.toCollection(r104, new ArrayList());
        int r110 = r109.size();
        if (r110 == 0) goto L53;
        if (r110 == 1) goto L52;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r109.iterator();
    L30:
        if (r112.hasNext() == false) goto L35;
        Object r113 = r112.next();
        if (((QRCodeContentInfo) r113).isCenterVisible() == false) goto L30;
        r111.add(r113);
        goto L30
    L35:
        if (r111.size() != 1) goto L37;
        z1((QRCodeContentInfo) CollectionsKt.first(r111), "only one code has visible center");
        return;
    L37:
        this.f426643a = r100.getRequestCode();
        r100.setContentList(r109);
        Log.i("ImageQRCodeSelectActivity", "initView");
        AppCompatTextView r114 = (AppCompatTextView) findViewById(com.larus.nova.R.id.qrcode_cancel_view);
        if (r114 == null) goto L40;
        r114.setOnClickListener(new b(this));
    L40:
        AppCompatImageView r115 = (AppCompatImageView) findViewById(com.larus.nova.R.id.qrcode_bg_image);
        if (r115 != null) goto L43;
        return;
    L43:
        if (r100.getScaleType() != QRCodeShowParam.ScaleType.FIT_CENTER) goto L45;
        ImageView.ScaleType r116 = ImageView.ScaleType.FIT_CENTER;
    L46:
        r115.setScaleType(r116);
        Bitmap r117 = r100.getBitmap();
        if (r117 == null) goto L51;
        r115.setImageBitmap(r117);
        FrameLayout r118 = (FrameLayout) findViewById(com.larus.nova.R.id.qrcode_bubbles_layout);
        if (r118 == null) goto L69;
        r118.getViewTreeObserver().addOnGlobalLayoutListener(new e(r118, r117, r100, this));
        return;
    L69:
        return;
    L51:
        RxScheduledExecutor.execInIO(new c(r100), new d(this, r115, r100));
        return;
    L45:
        r116 = ImageView.ScaleType.CENTER_CROP;
        goto L46
    L52:
        z1((QRCodeContentInfo) CollectionsKt.first(r109), "only one code is valid");
        return;
    L53:
        z1((QRCodeContentInfo) CollectionsKt.first(r100.getContentList()), "all codes are invalid");
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ImageQRCodeSelectActivity.class.getName()));
    L5:
        super.onDestroy();
        Log.i("ImageQRCodeSelectActivity", LiveCommonConstants.REASON_ON_DEDTROY);
        f426641d = null;
        Iterator<AnimatorSet> r100 = this.f426644b.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        r100.next().cancel();
        goto L7
    L9:
        this.f426645c.removeCallbacksAndMessages(null);
    }

    public ImageQRCodeSelectActivity() {
        this.f426644b = new HashSet();
        this.f426645c = new Handler(Looper.getMainLooper());
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
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:ImageQRCodeSelectActivity portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r102.intValue() == r101) goto L19;
    L8:
        r102 = null;
    L19:
        Log.i(this.PARENT_TAG, "onConfigurationChanged");
        init();
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        this.useDefaultAnimation = false;
        super.onCreate(r100);
        UIUtils.setStatusBarTransparent(this);
        setContentView(com.larus.nova.R.layout.image_qrcode_select_layout);
        init();
    }

    public final void z1(QRCodeContentInfo r100, String r101) {
        String r102 = r100.getContent();
        Log.i("ImageQRCodeSelectActivity", "onSelect, content " + mlb.b.d(r102) + ", requestCode:" + this.f426643a + ", msg:" + r101);
        if (this.f426643a == null) goto L5;
        Intent r103 = new Intent();
        r103.putExtra("RESULT_PARAM_CONTENT", r102);
        setResult(1000000, r103);
    L25:
        finish();
        return;
    L5:
        String r104 = null;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.scan_code.close_scan_activity_early") == false) goto L15;
        QRCodeShowParam r105 = f426641d;
        if (r105 == null) goto L10;
        String r106 = r105.getFrom();
    L12:
        if (Intrinsics.areEqual(r106, "scan_code") == false) goto L15;
        Intent r107 = new Intent();
        r107.putExtra("RESULT_PARAM_CONTENT", r102);
        setResult(1000000, r107);
        goto L25
    L10:
        r106 = null;
    L15:
        if (ForsetiFGHelpers.d() == true) goto L17;
    L24:
        ((mlb.a) ApiUtils.getApi(mlb.a.class)).openResultPage(this, r102);
        goto L25
    L17:
        if (ForsetiFGHelpers.b(BizType.IM, "scan_code_page") == false) goto L24;
        QRCodeShowParam r108 = f426641d;
        if (r108 == null) goto L22;
        r104 = r108.getFrom();
    L22:
        if (Intrinsics.areEqual(r104, "scan_code") == false) goto L24;
        Intent r109 = new Intent();
        r109.putExtra("RESULT_PARAM_CONTENT", r102);
        setResult(1000000, r109);
        goto L25
    }
}
