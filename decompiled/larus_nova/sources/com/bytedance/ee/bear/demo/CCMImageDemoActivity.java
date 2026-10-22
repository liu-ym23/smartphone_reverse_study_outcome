package com.bytedance.ee.bear.demo;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.facade.common.BaseCommonActivity;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.BaseSwitches;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J.\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J.\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001aH\u0002J \u0010$\u001a\u0004\u0018\u00010%2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH\u0002J\u0016\u0010(\u001a\u00020\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120*H\u0002J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020.H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/demo/CCMImageDemoActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseCommonActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "docsSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "getDocsSdk", "()Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "setDocsSdk", "(Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;)V", "logView", "Landroid/widget/TextView;", "photoContainer", "Landroid/widget/FrameLayout;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "showLocalImage", KtvSubElement.CONTAINER, "showOfficeAsset", "assetCandidates", "", "", "outputFileName", "previewExt", "bindAssetButton", "buttonId", "", "createPreviewModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewFileModel;", "localPath", "name", "cacheAsset", "Ljava/io/File;", "dp", BaseSwitches.V, "onClickClear", "block", "Lkotlin/Function0;", "append", "text", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "office-ccm-demo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMImageDemoActivity extends BaseCommonActivity implements d0c.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f217501e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f217502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f217503d;

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CCMImageDemoActivity.class.getName()));
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

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CCMImageDemoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.a(LarkContext.getApplication());
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

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public CCMImageDemoActivity() {
    }

    public final void B1(String r100) {
        TextView r101 = this.f217502c;
        LinearLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("logView");
        r101 = null;
    L5:
        r101.append(r100);
        TextView r103 = this.f217502c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("logView");
        r103 = null;
    L8:
        ViewParent r104 = r103.getParent();
        if ((r104 instanceof LinearLayout) == false) goto L11;
        r102 = (LinearLayout) r104;
    L11:
        if (r102 == null) goto L14;
        r102.setVisibility(0);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        A1(r100);
        super.onCreate(r100);
        htb.a.a();
        new ce5.a(this);
        setContentView(com.larus.nova.R.layout.activity_ccm_image_demo);
        this.f217502c = (TextView) findViewById(com.larus.nova.R.id.ccm_image_demo_log);
        this.f217503d = (FrameLayout) findViewById(com.larus.nova.R.id.ccm_image_demo_photo_container);
        ((Button) findViewById(com.larus.nova.R.id.ccm_image_demo_btn_show_local_image)).setOnClickListener(new AnonymousClass1(this));
        C1(com.larus.nova.R.id.ccm_image_demo_btn_show_asset_office, CollectionsKt.listOf("Unsplash-1.jpg"), "Unsplash-1.jpg", "jpg");
        C1(com.larus.nova.R.id.ccm_image_demo_btn_show_asset_gif, CollectionsKt.listOf(new String[]{"gif_test.gif", "gif_test"}), "gif_test.gif", "gif");
        C1(com.larus.nova.R.id.ccm_image_demo_btn_show_asset_heif, CollectionsKt.listOf(new String[]{"heif_test.heic", "heif_test.heif", "heif_test"}), "heif_test.heic", "heic");
        C1(com.larus.nova.R.id.ccm_image_demo_btn_show_asset_png, CollectionsKt.listOf(new String[]{"png_test.png", "png_test"}), "png_test.png", LoadParams.ImageFormat.PNG);
        C1(com.larus.nova.R.id.ccm_image_demo_btn_show_asset_big_jpg, CollectionsKt.listOf(new String[]{"big_jpg.jpg", "big_jpg"}), "big_jpg.jpg", "jpg");
        C1(com.larus.nova.R.id.ccm_image_demo_btn_show_asset_long_png, CollectionsKt.listOf(new String[]{"long_png.png", "long_png"}), "long_png.png", LoadParams.ImageFormat.PNG);
        C1(com.larus.nova.R.id.ccm_image_demo_btn_show_asset_high_hz_gif, CollectionsKt.listOf(new String[]{"high_hz_gif.gif", "high_hz_gif"}), "high_hz_gif.gif", "gif");
        C1(com.larus.nova.R.id.ccm_image_demo_btn_show_asset_big_gif, CollectionsKt.listOf(new String[]{"big_gif.gif", "big_gif"}), "big_gif.gif", "gif");
        C1(com.larus.nova.R.id.ccm_image_demo_btn_show_asset_big_heic, CollectionsKt.listOf(new String[]{"big_heic.heic", "big_heic"}), "big_heic.heic", "heic");
    }

    public final PolarisFileWrapper D1(List r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(getCacheDir(), r101);
        if (r102.exists() == false) goto L5;
        return r102;
    L5:
        Iterator r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L31;
        String r104 = (String) r103.next();
        InputStream r105 = getAssets().open(r104);     // Catch: Exception -> L30
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Throwable -> L25
        byte[] r107 = new byte[8192];     // Catch: Throwable -> L20
        int r108 = r105.read(r107);     // Catch: Throwable -> L20
    L14:
        if (r108 == (-1)) goto L16;
        r106.write(r107, 0, r108);     // Catch: Throwable -> L20
        r108 = r105.read(r107);     // Catch: Throwable -> L20
        goto L14
    L16:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L20
        goto L7
    L17:
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r105, null);     // Catch: Exception -> L30
        return r102;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L31:
        return null;
    }

    public final void C1(int r100, final List<String> r101, final String r102, final String r103) {
        ((Button) findViewById(r100)).setOnClickListener(new CCMImageDemoActivity$bindAssetButton$1(this, r101, r102, r103));
    }
}
