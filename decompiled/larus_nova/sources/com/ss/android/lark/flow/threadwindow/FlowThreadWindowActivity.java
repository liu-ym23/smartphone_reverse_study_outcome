package com.ss.android.lark.flow.threadwindow;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.chatwindow.IllegalUserSessionException;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.codeblock.theme.CodeBlockV2ThemeManager;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0014J\"\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000bH\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "chatId", "", "activityHookManager", "Lcom/ss/android/lark/chat/core/extension/ActivityHookManager;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "setupFragment", "replaceFragment", "args", "setFlowSystemBars", LiveCommonConstants.REASON_ON_DEDTROY, "onActivityResult", "requestCode", "", "resultCode", "data", "isSlideEnable", "", "shouldNotifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "setupActivityHookOnBackPressed", "getChatId", "bundle", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowThreadWindowActivity extends Hilt_FlowThreadWindowActivity implements d0c.c, zsb.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f424097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.chat.core.extension.a f424098c;

    public static final class a {
    }

    static {
    }

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

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity
    public final boolean isSlideEnable() {
        return false;
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
    @Override // com.ss.android.lark.flow.threadwindow.Hilt_FlowThreadWindowActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(FlowThreadWindowActivity.class.getName()));
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

    @Override // com.ss.android.lark.flow.threadwindow.Hilt_FlowThreadWindowActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowThreadWindowActivity.class.getName()));
    L5:
        super.onDestroy();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        ((itb.c) LarkContext.spiByDwarf(itb.c.class)).V(this);     // Catch: Throwable -> L8
        com.larksuite.framework.utils.t.c(this);     // Catch: Throwable -> L8
        com.larksuite.framework.utils.t.b(this);     // Catch: Throwable -> L8
        com.ss.android.lark.chat.utils.j.f416683a.clear();     // Catch: Throwable -> L8
        CodeBlockV2ThemeManager.a();     // Catch: Throwable -> L8
        TableUtils.f412435a = null;     // Catch: Throwable -> L8
        ColumnsUtils.f412434a = null;     // Catch: Throwable -> L8
        TextLayoutBuilder.b();     // Catch: Throwable -> L8
        this.f424098c.d();     // Catch: Throwable -> L8
        z6b.a.f570633a = false;     // Catch: Throwable -> L8
        ChatCoreModule.a().getChatDependency().r();     // Catch: Throwable -> L8
        com.ss.android.lark.chat.utils.u.a.f416743a.a();     // Catch: Throwable -> L8
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L16;
        Log.w("FlowThreadWindowActivity", "FlowThreadWindowActivity cleanup failed", r102);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public FlowThreadWindowActivity() {
        this.f424098c = new com.ss.android.lark.chat.core.extension.a(this);
    }

    @Override // d0c.c
    public final UserSession e9() {
        Intent r100 = getIntent();
        if (r100 != null) goto L5;
    L14:
        StringBuilder r101 = new StringBuilder("invalid intent, intent:");
        if (r100 != null) goto L17;
        boolean r102 = true;
    L18:
        r101.append(r102);
        Log.e("FlowThreadWindowActivity", new IllegalUserSessionException(r101.toString()), true);
        finish();
        return PassportcConvention.a(getApplication());
    L17:
        r102 = false;
        goto L18
    L5:
        if (r100.getExtras() == null) goto L14;
        if (r100.hasExtra("iji.convention.user_id") == true) goto L10;
    L11:
        Log.e("FlowThreadWindowActivity", new IllegalUserSessionException("provideUserSession invalid extra, id:" + r100.hasExtra("iji.convention.user_id") + ", key:" + r100.hasExtra("iji.convention.session_key")), true);
        PassportcConvention.e(r100, getApplication());
    L13:
        return PassportcConvention.c(this);
    L10:
        if (r100.hasExtra("iji.convention.session_key") == true) goto L13;
        goto L11
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

    @Override // zsb.d
    public final boolean Cy(Notice r100) {
        String r101 = this.f424097b;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return t0.c(r100, r101);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        this.PARENT_TAG = "FlowThreadWindowActivity";
        super.onCreate(r100);
        zfb.a.a(this);
        ImSdk r101 = ImSdk.f425890a;
        boolean r102 = ImSdk.f425892c;
        boolean r103 = OfficeSDKManager.isAvailable();
        if (r103 == false) goto L26;
        if (r102 == false) goto L26;
        final OnBackPressedDispatcher r104 = getOnBackPressedDispatcher();
        r104.addCallback(this, new FlowThreadWindowActivity$setupActivityHookOnBackPressed$1(this, r104));
        FlowThreadWindowContainerFragment r105 = new FlowThreadWindowContainerFragment();
        r105.setArguments(getIntent().getExtras());
        Bundle r106 = getIntent().getExtras();
        if (r106 == null) goto L18;
        String r107 = r106.getString("chatID");
        if (r107 == null) goto L18;
    L21:
        this.f424097b = r107;
        FragmentTransaction r108 = getSupportFragmentManager().beginTransaction();
        String r109 = FlowThreadWindowContainerFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r108, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r109, R.id.content) == true) goto L25;
        r108.add(R.id.content, r105, r109);
    L25:
        r108.commitAllowingStateLoss();
        WindowInsetsUtils.f(this);
        WindowInsetsUtils.d(this);
        WindowInsetsUtils.e(this);
        WindowInsetsUtils.c(this).b(UIUtils.getColor(this, com.larus.nova.R.color.flow_ud_bg_base_1));
        return;
    L18:
        if (r106 == null) goto L20;
        r107 = r106.getString("chatID");
        goto L21
    L20:
        r107 = null;
    L26:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r103 + ", im sdk ready: " + r102 + ", finish. " + FlowThreadWindowActivity.class.getName());
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        if (r100 == null) goto L28;
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L29;
        String r102 = r101.getString("chatID");
        if (r102 != null) goto L10;
        r102 = r101.getString("chatID");
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
        return;
    L18:
        setIntent(r100);
        this.f424097b = r102;
        Fragment r104 = getSupportFragmentManager().findFragmentById(R.id.content);
        if ((r104 instanceof FlowThreadWindowContainerFragment) == false) goto L21;
        ((FlowThreadWindowContainerFragment) r104).A0(r100);
    L26:
        this.f424098c.e(r100);
        return;
    L21:
        FlowThreadWindowContainerFragment r105 = new FlowThreadWindowContainerFragment();
        r105.setArguments(r101);
        FragmentTransaction r106 = getSupportFragmentManager().beginTransaction();
        String r107 = FlowThreadWindowContainerFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r106, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r107, R.id.content) == true) goto L25;
        r106.replace(R.id.content, r105, r107);
    L25:
        r106.commitAllowingStateLoss();
        goto L26
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L29:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Fragment r103 = getSupportFragmentManager().findFragmentById(R.id.content);
        if (r103 == null) goto L5;
        r103.onActivityResult(r100, r101, r102);
    L5:
        this.f424098c.a(r100, r101, r102);
    }
}
