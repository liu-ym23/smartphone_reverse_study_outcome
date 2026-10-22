package com.larus.home.obric;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.ChatActivity;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.n4;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.setting.api.SettingService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import dc9.d;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sga.e;
import t1a.b;
import v19.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0014J\b\u0010\u0012\u001a\u00020\fH\u0014J\b\u0010\u0013\u001a\u00020\fH\u0014J\b\u0010\u0014\u001a\u00020\fH\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/larus/home/obric/ObricChatActivity;", "Lcom/larus/bmhome/chat/ChatActivity;", "Lcom/larus/bmhome/chat/IWindowChatActivity;", "<init>", "()V", "orionChatExtension", "Lcom/obric/assistant/spi/chat/callback/IObricChatExtensionUtilsCallback;", "getOrionChatExtension", "()Lcom/obric/assistant/spi/chat/callback/IObricChatExtensionUtilsCallback;", "orionChatExtension$delegate", "Lkotlin/Lazy;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "getVContext", "Lcom/larus/ui/arch/context/external/VContext;", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, VideoEventOneOutSync.END_TYPE_FINISH, "getBackgroundResource", "", "disableToSetBackgroundColor", "color", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatActivity extends ChatActivity implements n4 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f346390l = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f346391k;

    /* JADX INFO: loaded from: classes29.dex */
    public static final class a {
    }

    static {
    }

    public final jga.a R1() {
        return (jga.a) this.f346391k.getValue();
    }

    @Override // com.larus.bmhome.chat.ChatActivity, com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricChatActivity.class.getName()));
    L5:
        FLogger.f375446a.i("ObricChatActivity", LiveCommonConstants.REASON_ON_DEDTROY);
        jga.a r100 = R1();
        if (r100 == null) goto L8;
        r100.b(this);
    L8:
        super.onDestroy();
    }

    @Override // com.larus.bmhome.chat.ChatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        FLogger.f375446a.i("ObricChatActivity", "onPause");
        super.onPause();
        jga.a r100 = R1();
        if (r100 == null) goto L6;
        r100.a(this);
        return;
    }

    @Override // com.larus.bmhome.chat.ChatActivity, com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        FLogger.f375446a.i("ObricChatActivity", "onResume");
        super.onResume();
        SettingService.f367887a.k();
        jga.a r100 = R1();
        if (r100 == null) goto L6;
        r100.g(this);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        FLogger.f375446a.i("ObricChatActivity", WidgetCostModule.TYPE_ON_START);
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        FLogger.f375446a.i("ObricChatActivity", "onStop");
        super.onStop();
        jga.a r100 = R1();
        if (r100 == null) goto L6;
        r100.d(this);
    L6:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L12;
        Q1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    public ObricChatActivity() {
        this.f346391k = LazyKt.lazy(new pc9.a(this));
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final int C1() {
        jga.a r100 = R1();
        if (r100 == null) goto L9;
        Integer r101 = r100.e(getIntent());
        if (r101 == null) goto L9;
        return r101.intValue();
    L9:
        return super.C1();
    }

    @Override // com.larus.bmhome.chat.ChatActivity, com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        if (i3.f365750a.h() == true) goto L9;
        super.finish();
        jga.a r100 = R1();
        if (r100 == null) goto L9;
        r100.h(this);
    L9:
        if ((this instanceof ChatWindowActivity) == true) goto L62;
        FLogger r101 = FLogger.f375446a;
        r101.i("ActivityLancet", "finish ".concat(ObricChatActivity.class.getName()));
        long r102 = SystemClock.uptimeMillis();
        Map<Activity, Long> r103 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r103);
        Long r104 = r103.get(this);     // Catch: Throwable -> L51
        if (r104 != null) goto L16;
    L19:
        r103.put(this, Long.valueOf(r102));     // Catch: Throwable -> L51
        monitor-exit(r103);     // Catch: Throwable -> L51
    L48:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L59:
        return;
    L22:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L25;
        r101.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L48
    L54:
        goto L59
    L25:
        if (isFinishing() == true) goto L28;
        r101.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L48
        goto L54
    L28:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L31;
        r101.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L48
        goto L54
    L31:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L34;
        r101.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L48
        goto L54
    L34:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L37;
        r101.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L48
        goto L54
    L37:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L39;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L48
        goto L54
    L39:
        Intent r105 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L48
        if (r105 == null) goto L54;
        r105.addFlags(268435456);     // Catch: Throwable -> L48
        r105.addFlags(2097152);     // Catch: Throwable -> L48
        r101.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L48
        startActivity(r105);     // Catch: Throwable -> L45
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L48
        goto L54
    L16:
        if ((r102 - r104.longValue()) >= 800) goto L19;
        monitor-exit(r103);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.ChatActivity, com.larus.bmhome.chat.d4
    public final b getVContext() {
        if (isDestroyed() == false) goto L5;
        return null;
    L5:
        List<Fragment> r100 = getSupportFragmentManager().getFragments();
        ListIterator<Fragment> r101 = r100.listIterator(r100.size());
    L7:
        if (r101.hasPrevious() == false) goto L14;
        Fragment r102 = r101.previous();
        if (r102.getId() != com.larus.nova.R.id.fragment_container) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L7;
    L16:
        if ((r102 instanceof ChatFragment) == false) goto L18;
        ChatFragment r104 = (ChatFragment) r102;
    L19:
        if (r104 != null) goto L22;
        return null;
    L22:
        if (r104.isAdded() == true) goto L24;
    L33:
        return null;
    L24:
        if (r104.getActivity() != this) goto L33;
        return r104.WF();
    L28:
        e = move-exception;
        if (r104.getActivity() == this) goto L32;
        return null;
    L32:
        throw e;
    L18:
        r104 = null;
        goto L19
    L11:
        r103 = false;
        goto L12
    L14:
        r102 = null;
        goto L16
    }

    public static View Q1(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final void B1(int r100) {
        jga.a r101 = R1();
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L19;
        jga.a r104 = R1();
        if (r104 != null) goto L12;
    L14:
        r102 = false;
    L15:
        if (r102 == true) goto L20;
        super.B1(r100);
        return;
    L20:
        return;
    L12:
        if (r104.k(this) != true) goto L14;
    L19:
        return;
    L5:
        if (r101.i(this) != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (d.a() == true) goto L16;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L14
        if (r102 != null) goto L9;
    L11:
        if (r101 != 3) goto L16;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:ObricChatActivity portrait");     // Catch: Throwable -> L14
        goto L16
    L9:
        if (r102.intValue() != r101) goto L11;
    L16:
        jga.a r103 = R1();
        if (r103 == null) goto L22;
        r103.j(this, r100);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L16
    }

    @Override // com.larus.bmhome.chat.ChatActivity, com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        FLogger r101 = FLogger.f375446a;
        r101.i("ObricChatActivity", WidgetCostModule.TYPE_ON_CREATE);
        boolean r102 = false;
        boolean r103 = getIntent().getBooleanExtra("wakeup_assistant", false);
        r101.d("ObricChatActivity", "handleWakeup: " + r103 + ", " + getIntent());
        ObricInteractDelegate.f392884b.notifyWakeupEvent(r103);
        jga.a r104 = R1();
        if (r104 == null) goto L15;
        if (r100 == null) goto L14;
        r102 = true;
    L14:
        r104.c(this, r102);
    L16:
        super.onCreate(r100);
        L1();
        jga.a r105 = R1();
        if (r105 == null) goto L19;
        r105.f(this, O1().getArguments(), r100);
    L19:
        e.a(Q1(getWindow()));
        return;
    L15:
        setShowWhenLocked(false);
        goto L16
    }
}
