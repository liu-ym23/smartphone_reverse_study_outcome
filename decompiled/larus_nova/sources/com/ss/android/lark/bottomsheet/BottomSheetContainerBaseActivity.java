package com.ss.android.lark.bottomsheet;

import android.R;
import android.app.Activity;
import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.yoga.android.YogaViewLayoutFactory;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.appcontext.applifecycle.ILifeCycleEventObserve$Event;
import com.ss.android.lark.appcontext.applifecycle.x;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00011B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u0014\u001a\u00020\nH\u0004J\b\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0012\u0010 \u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\nH\u0016J\"\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0012\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010*H\u0014J\u001a\u00100\u001a\u00020\n2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u00062"}, d2 = {"Lcom/ss/android/lark/bottomsheet/BottomSheetContainerBaseActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/asyncInflater/IAsyncInflaterOwner;", "Lcom/ss/android/lark/appcontext/applifecycle/ILifeCycleEventObserve;", "Lcom/ss/android/lark/appcontext/applifecycle/ILifeCycleEventObserve$ILifeCycleEventObserver;", "Lcom/ss/android/lark/chat/chatwindow/ISetChatWindowResult;", "<init>", "()V", "mLifeCycleEventObserver", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "asyncInflater", "Lcom/ss/android/lark/asyncInflater/PreLoadInflater;", "kotlin.jvm.PlatformType", "getAsyncInflater", "()Lcom/ss/android/lark/asyncInflater/PreLoadInflater;", "asyncInflater$delegate", "Lkotlin/Lazy;", "installFragment", "loadFragment", "getFragment", "Landroidx/fragment/app/Fragment;", "getInflater", "Lcom/ss/android/lark/asyncInflater/IAsyncInflater;", "getSystemService", "", "name", "", "registerObserver", "observer", "unRegisterObserver", "onEventChanged", "eventName", "Lcom/ss/android/lark/appcontext/applifecycle/ILifeCycleEventObserve$Event;", "onBackPressed", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onProvideAssistContent", "outContent", "Landroid/app/assist/AssistContent;", "onNewIntent", "intent", "setChatWindowResult", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BottomSheetContainerBaseActivity extends BaseFragmentActivity implements dwa.d, x, i2b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f410672a;

    public static final class a {
    }

    static {
    }

    @Override // dwa.d
    public final dwa.c Ey() {
        return (dwa.j) this.f410672a.getValue();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public BottomSheetContainerBaseActivity() {
        this.f410672a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BottomSheetContainerBaseActivity$asyncInflater$2(this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
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

    public final Fragment getFragment() {
        return getSupportFragmentManager().findFragmentByTag("installed_fragment");
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        ActivityResultCaller r100 = getFragment();
        if ((r100 instanceof com.ss.android.lark.bottomsheet.fragment.d) == false) goto L5;
        com.ss.android.lark.bottomsheet.fragment.d r101 = (com.ss.android.lark.bottomsheet.fragment.d) r100;
    L6:
        boolean r102 = false;
        if (r101 != null) goto L9;
    L11:
        if (r102 == false) goto L13;
        return;
    L13:
        super.onBackPressed();
        return;
    L9:
        if (r101.l1() != true) goto L11;
        r102 = true;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // i2b.a
    public final void MS(Intent r100) {
        setResult(-1, r100);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (Intrinsics.areEqual("layout_inflater", r100) == false) goto L10;
        LayoutInflater r101 = (LayoutInflater) getSystemService("real_layout_inflater");
        if (r101 != null) goto L8;
        r101 = LayoutInflater.from(this);
    L8:
        return new dwa.f(this, r101);
    L10:
        if (Intrinsics.areEqual("real_layout_inflater", r100) == false) goto L14;
        return super.getSystemService("layout_inflater");
    L14:
        return super.getSystemService(r100);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        disableBlackStatusBarBeforeOnCreate();
        disableColorNavigationBarBeforeOnCreate();
        LayoutInflater.from(this).setFactory(YogaViewLayoutFactory.getInstance());
        super.onCreate(r100);
        v4b.a.a(this);
        setSlideEnable(false);
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.x
    public void onEventChanged(ILifeCycleEventObserve$Event r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Log.i(this.PARENT_TAG, "onEventChanged:" + r100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        ActivityResultCaller r101 = getFragment();
        if ((r101 instanceof com.ss.android.lark.bottomsheet.fragment.d) == false) goto L5;
        com.ss.android.lark.bottomsheet.fragment.d r102 = (com.ss.android.lark.bottomsheet.fragment.d) r101;
    L6:
        if (r102 == null) goto L9;
        r102.A0(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.app.Activity
    public final void onProvideAssistContent(AssistContent r100) {
        super.onProvideAssistContent(r100);
        ActivityResultCaller r101 = getFragment();
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof com.ss.android.lark.bottomsheet.fragment.d) == true) goto L8;
        return;
    L8:
        ((com.ss.android.lark.bottomsheet.fragment.d) r101).aP(r100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Fragment r103 = getFragment();
        if (r103 != null) goto L5;
        return;
    L5:
        r103.onActivityResult(r100, r101, r102);
    }
}
