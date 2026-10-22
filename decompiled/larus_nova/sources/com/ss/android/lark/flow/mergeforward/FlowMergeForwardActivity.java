package com.ss.android.lark.flow.mergeforward;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
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
import com.ss.android.lark.audio.f;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chatwindow.IllegalUserSessionException;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.Lazy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0019H\u0002J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110*R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/ss/android/lark/flow/mergeforward/FlowMergeForwardActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mFragmentLazy", "Ldagger/Lazy;", "Lcom/ss/android/lark/flow/mergeforward/FlowMergeForwardContainerFragment;", "getMFragmentLazy", "()Ldagger/Lazy;", "setMFragmentLazy", "(Ldagger/Lazy;)V", "mFragment", "getMFragment", "()Lcom/ss/android/lark/flow/mergeforward/FlowMergeForwardContainerFragment;", "msgIdPath", "", "", "messageContent", "Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;", "translatedMessageContent", "TAG", "getTAG", "()Ljava/lang/String;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onWindowFocusChanged", "hasFocus", "", "initMsgIdPath", "getMsgIdPathList", "", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowMergeForwardActivity extends Hilt_FlowMergeForwardActivity implements d0c.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public Lazy<FlowMergeForwardContainerFragment> f423716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f423717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MergeForwardContent f423718d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.ss.android.lark.flow.mergeforward.Hilt_FlowMergeForwardActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(FlowMergeForwardActivity.class.getName()));
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

    @Override // com.ss.android.lark.flow.mergeforward.Hilt_FlowMergeForwardActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowMergeForwardActivity.class.getName()));
    L5:
        super.onDestroy();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        ((itb.c) LarkContext.spiByDwarf(itb.c.class)).V(this);     // Catch: Throwable -> L11
        Map<String, f> r101 = f.f408976e;     // Catch: Throwable -> L11
        f r102 = f.b.a(this);     // Catch: Throwable -> L11
        r102.d();     // Catch: Throwable -> L11
        ((ConcurrentHashMap) r102.f408978b).clear();     // Catch: Throwable -> L11
        ((ConcurrentHashMap) f.f408976e).remove(r102.f408977a);     // Catch: Throwable -> L11
        TextLayoutBuilder.b();     // Catch: Throwable -> L11
        int r103 = com.ss.android.lark.mergeforward.b.f431885d - 1;     // Catch: Throwable -> L11
        com.ss.android.lark.mergeforward.b.f431885d = r103;     // Catch: Throwable -> L11
        if (r103 != 0) goto L9;
        com.ss.android.lark.mergeforward.b.f431883b = null;     // Catch: Throwable -> L11
        com.ss.android.lark.mergeforward.b.f431884c = null;     // Catch: Throwable -> L11
    L9:
        ChatCoreModule.a().getChatDependency().r();     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final FlowMergeForwardContainerFragment z1() {
        Lazy<FlowMergeForwardContainerFragment> r100 = this.f423716b;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFragmentLazy");
        r100 = null;
    L7:
        return r100.get();
    }

    public FlowMergeForwardActivity() {
        this.f423717c = new ArrayList();
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
        Log.e(this.PARENT_TAG, new IllegalUserSessionException(r101.toString()), true);
        finish();
        return PassportcConvention.a(getApplication());
    L17:
        r102 = false;
        goto L18
    L5:
        if (r100.getExtras() == null) goto L14;
        if (r100.hasExtra("iji.convention.user_id") == true) goto L10;
    L11:
        Log.e(this.PARENT_TAG, new IllegalUserSessionException("provideUserSession invalid extra, id:" + r100.hasExtra("iji.convention.user_id") + ", key:" + r100.hasExtra("iji.convention.session_key")), true);
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

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        this.PARENT_TAG = "FlowMergeForwardActivity";
        fsb.f.c("FlowMergeForwardActivity").j();
        fsb.f.b().i(WidgetCostModule.TYPE_ON_CREATE);
        getTheme().setTo(getApplicationContext().getTheme());
        getTheme().applyStyle(com.larus.nova.R.style.FlowIM, true);
        super.onCreate(r100);
        zfb.a.a(this);
        ImSdk r101 = ImSdk.f425890a;
        boolean r102 = ImSdk.f425892c;
        boolean r103 = OfficeSDKManager.isAvailable();
        if (r103 == false) goto L33;
        if (r102 == false) goto L33;
        z1().setArguments(getIntent().getExtras());
        FragmentTransaction r104 = getSupportFragmentManager().beginTransaction();
        FlowMergeForwardContainerFragment r105 = z1();
        MergeForwardContent r106 = null;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r104, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content) == true) goto L18;
        r104.add(R.id.content, r105, null);
    L18:
        r104.commitAllowingStateLoss();
        WindowInsetsUtils.f(this);
        WindowInsetsUtils.d(this);
        WindowInsetsUtils.e(this);
        WindowInsetsUtils.c(this).b(UIUtils.getColor(this, com.larus.nova.R.color.flow_ud_bg_base_1));
        com.ss.android.lark.mergeforward.b.a r107 = com.ss.android.lark.mergeforward.b.f431882a;
        if (r107 == null) goto L21;
        r106 = r107.f431886a;
    L21:
        this.f423718d = r106;
        Bundle r108 = getIntent().getExtras();
        if (r108 == null) goto L26;
        ArrayList<String> r109 = r108.getStringArrayList("key_msg_id_path_list");
        if (r109 == null) goto L26;
    L27:
        this.f423717c = r109;
        MergeForwardContent r110 = this.f423718d;
        if (r110 == null) goto L32;
        String r111 = r110.getMessageId();
        if (r111 == null) goto L32;
        this.f423717c.add(r111);
    L32:
        fsb.f.b().h(WidgetCostModule.TYPE_ON_CREATE);
        return;
    L26:
        r109 = new ArrayList();
    L33:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r103 + ", im sdk ready: " + r102 + ", finish. " + FlowMergeForwardActivity.class.getName());
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        fsb.f.b().g();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        FlowMergeForwardContainerFragment r103 = z1();
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
        return;
    }
}
