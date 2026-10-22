package com.bytedance.applet.debug.view;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersion;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersionPage;
import com.bytedance.applet.databinding.LarusAppletDebugVersionManagerActivityBinding;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0012H\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002J\u001a\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0-*\u00020%H\u0002J\u0012\u0010.\u001a\b\u0012\u0004\u0012\u0002000/*\u00020%H\u0002J\u000e\u00101\u001a\u0004\u0018\u00010\f*\u000200H\u0002J\b\u00102\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/applet/debug/view/AppletDebugVersionManagerActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/bytedance/applet/databinding/LarusAppletDebugVersionManagerActivityBinding;", "adapter", "Lcom/bytedance/applet/debug/view/AppletDebugVersionAdapter;", "loadAppListJob", "Lkotlinx/coroutines/Job;", "submitJob", "nextAppCursor", "", "hasMoreApps", "", "loadingMoreApps", "userScrollingAppList", "appListScrollDistance", "", "originDebugMode", "Lcom/bytedance/ai/debug/IAISDKDebugService$DebugMode;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "initViews", "loadFirstPage", "loadMoreApps", "loadMoreVersions", "appKey", "cursor", "submitChangedConfigs", "bindFirstPage", "result", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoList;", "appendAppPage", "updateConfirmButtonState", "updateEmptyView", "loadMoreScrollDistance", "showLoadingState", "hideLoadingState", "toSelectedVersionMap", "", "toDisplayApps", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfo;", "defaultVersionTag", "getXToken", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebugVersionManagerActivity extends FlowCommonAppCompatActivity {
    public static final int q = 0;
    public LarusAppletDebugVersionManagerActivityBinding g;
    public AppletDebugVersionAdapter h;
    public Job i;
    public Job j;
    public String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public IAISDKDebugService.DebugMode p;

    public static final class a {
    }

    public final boolean H1() {
        return true;
    }

    static {
        q = IAISDKDebugService.DebugMode.SCAN_PREVIEW.getValue();
    }

    public final void Q1() {
        com.bytedance.ai.utils.g.a.i("AppletDebugVersionManager", "loadFirstPage");
        this.i = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletDebugVersionManagerActivity$loadFirstPage$1(this, null), 3, null);
    }

    public final void S1() {
        AppletDebugVersionAdapter r0 = this.h;
        LarusAppletDebugVersionManagerActivityBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        boolean r2 = !r0.z2().isEmpty();
        LarusAppletDebugVersionManagerActivityBinding r3 = this.g;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.e.setEnabled(r2);
        LarusAppletDebugVersionManagerActivityBinding r4 = this.g;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        TextView r5 = r1.e;
        if (r2 == false) goto L15;
        float r6 = 1.0f;
    L16:
        r5.setAlpha(r6);
        return;
    L15:
        r6 = 0.6f;
        goto L16
    L11:
        r1 = r4;
        goto L12
    }

    public final void T1() {
        LarusAppletDebugVersionManagerActivityBinding r0 = this.g;
        AppletDebugVersionAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        TextView r2 = r0.f;
        AppletDebugVersionAdapter r3 = this.h;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L10:
        if (r1.getItemCount() != 0) goto L12;
        int r4 = 0;
    L13:
        r2.setVisibility(r4);
        return;
    L12:
        r4 = 8;
        goto L13
    L8:
        r1 = r3;
        goto L10
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(AppletDebugVersionManagerActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletDebugVersionManagerActivity.class.getName()));
    L5:
        IAISDKDebugService.DebugMode r0 = this.p;
        if (r0 == null) goto L8;
        IAISDKDebugService.a.C(r0);
    L8:
        Job r1 = this.i;
        if (r1 == null) goto L11;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L11:
        Job r2 = this.j;
        if (r2 == null) goto L14;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L14:
        super.onDestroy();
    }

    public AppletDebugVersionManagerActivity() {
        this.k = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public static final String N1(AppletDebugVersionManagerActivity r0) {
        r0.getClass();
        Function0 r1 = com.larus.platform.service.q.a.f().a;
        if (r1 == null) goto L5;
        String r2 = (String) r1.invoke();
    L6:
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public static final void O1(AppletDebugVersionManagerActivity r2) {
        LarusAppletDebugVersionManagerActivityBinding r0 = r2.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.h.setVisibility(8);
        r2.S1();
    }

    public static final void P1(AppletDebugVersionManagerActivity r4) {
        LarusAppletDebugVersionManagerActivityBinding r0 = r4.g;
        LarusAppletDebugVersionManagerActivityBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.h.setVisibility(0);
        LarusAppletDebugVersionManagerActivityBinding r5 = r4.g;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r1.e.setEnabled(false);
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public static Map R1(OpenPlatformPreviewAppInfoList r7) {
        List r8 = r7.getScanSelectedApps();
        if (r8 != null) goto L5;
        r8 = CollectionsKt.emptyList();
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L42;
        OpenPlatformPreviewAppInfo r1 = (OpenPlatformPreviewAppInfo) r9.next();
        String r2 = r1.getAppKey();
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        String r4 = null;
        if (StringsKt.isBlank(r2) == true) goto L39;
        OpenPlatformPreviewVersion[] r3 = new OpenPlatformPreviewVersion[2];
        List r5 = r1.getTestVersions();
        if (r5 == null) goto L17;
        OpenPlatformPreviewVersion r6 = (OpenPlatformPreviewVersion) CollectionsKt.firstOrNull(r5);
    L18:
        r3[0] = r6;
        List r10 = r1.getAuditVersions();
        if (r10 == null) goto L21;
        OpenPlatformPreviewVersion r11 = (OpenPlatformPreviewVersion) CollectionsKt.firstOrNull(r10);
    L22:
        r3[1] = r11;
        List r12 = CollectionsKt.listOfNotNull(r3);
        OpenPlatformPreviewVersionPage r13 = r1.getFormalVersions();
        if (r13 == null) goto L25;
        List r14 = r13.getItems();
    L26:
        if (r14 != null) goto L28;
        r14 = CollectionsKt.emptyList();
    L28:
        Iterator r15 = CollectionsKt.plus(r12, r14).iterator();
    L30:
        if (r15.hasNext() == false) goto L34;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((OpenPlatformPreviewVersion) r16).isDefault(), Boolean.TRUE) == false) goto L30;
    L35:
        OpenPlatformPreviewVersion r17 = (OpenPlatformPreviewVersion) r16;
        if (r17 == null) goto L38;
        r4 = r17.getVersionTag();
    L38:
        r4 = TuplesKt.to(r2, r4);
        goto L39
    L34:
        r16 = null;
        goto L35
    L25:
        r14 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r6 = null;
    L39:
        if (r4 == null) goto L7;
        r0.add(r4);
        goto L7
    L42:
        return MapsKt.toMap(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r18) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r18);
        IAISDKDebugService.Companion r1 = IAISDKDebugService.a;
        this.p = r1.getDebugMode();
        r1.C(IAISDKDebugService.DebugMode.SCAN_PREVIEW);
        LarusAppletDebugVersionManagerActivityBinding r3 = null;
        ConstraintLayout r2 = getLayoutInflater().inflate(2131561809, null, false);
        int r4 = 2131363106;
        RecyclerView r7 = ViewBindings.findChildViewById(r2, 2131363106);
        if (r7 == null) goto L60;
        r4 = 2131363772;
        ImageButton r8 = (ImageButton) ViewBindings.findChildViewById(r2, 2131363772);
        if (r8 == null) goto L60;
        r4 = 2131364406;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131364406);
        if (r9 == null) goto L60;
        r4 = 2131367655;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r2, 2131367655);
        if (r10 == null) goto L60;
        r4 = 2131371607;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r2, 2131371607);
        if (r11 == null) goto L60;
        r4 = 2131378150;
        ProgressBar r12 = (ProgressBar) ViewBindings.findChildViewById(r2, 2131378150);
        if (r12 == null) goto L60;
        r4 = 2131379050;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131379050);
        if (r13 == null) goto L60;
        r4 = 2131380620;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131380620);
        if (r14 == null) goto L60;
        r4 = 2131384138;
        ImageButton r15 = (ImageButton) ViewBindings.findChildViewById(r2, 2131384138);
        if (r15 == null) goto L60;
        ConstraintLayout r5 = r2;
        if (((TextView) ViewBindings.findChildViewById(r2, 2131388915)) == null) goto L58;
        this.g = new LarusAppletDebugVersionManagerActivityBinding(r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r5);
        setContentView(r5);
        B1(getResources().getColor(2131100404));
        LarusAppletDebugVersionManagerActivityBinding r6 = this.g;
        if (r6 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L34:
        r6.k.setBackgroundColor(ContextCompat.getColor(this, 2131100404));
        this.h = new AppletDebugVersionAdapter(new AppletDebugVersionManagerActivity$initViews$1(this), new AppletDebugVersionManagerActivity$initViews$2(this));
        LarusAppletDebugVersionManagerActivityBinding r16 = this.g;
        if (r16 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L37:
        r16.b.setLayoutManager(new LinearLayoutManager(this));
        LarusAppletDebugVersionManagerActivityBinding r17 = this.g;
        if (r17 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L40:
        RecyclerView r19 = r17.b;
        AppletDebugVersionAdapter r20 = this.h;
        if (r20 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r20 = null;
    L43:
        r19.setAdapter(r20);
        LarusAppletDebugVersionManagerActivityBinding r21 = this.g;
        if (r21 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L46:
        r21.b.addOnScrollListener(new AppletDebugVersionManagerActivity$initViews$3(this));
        LarusAppletDebugVersionManagerActivityBinding r22 = this.g;
        if (r22 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L49:
        e1.d(r22.c, new o(this));
        LarusAppletDebugVersionManagerActivityBinding r23 = this.g;
        if (r23 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L52:
        e1.d(r23.j, new p(this));
        LarusAppletDebugVersionManagerActivityBinding r24 = this.g;
        if (r24 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L56:
        e1.d(r3.e, new q(this));
        S1();
        Q1();
        return;
    L55:
        r3 = r24;
        goto L56
    L58:
        r4 = 2131388915;
    L60:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r4)));
    }
}
