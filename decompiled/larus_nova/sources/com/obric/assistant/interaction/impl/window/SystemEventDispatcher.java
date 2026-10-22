package com.obric.assistant.interaction.impl.window;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0002\u0014\u0017\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u001aJ\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001aH\u0002J\b\u0010$\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006&"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/SystemEventDispatcher;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "listener", "Lcom/obric/assistant/interaction/impl/window/SystemEventListener;", "<init>", "(Landroid/content/Context;Lcom/obric/assistant/interaction/impl/window/SystemEventListener;)V", "appContext", "kotlin.jvm.PlatformType", "displayManager", "Landroid/hardware/display/DisplayManager;", SocialConstants.PARAM_RECEIVER, "Landroid/content/BroadcastReceiver;", "displayListener", "Landroid/hardware/display/DisplayManager$DisplayListener;", "started", "", "screenOffDispatched", "backgroundListener", "com/obric/assistant/interaction/impl/window/SystemEventDispatcher$backgroundListener$1", "Lcom/obric/assistant/interaction/impl/window/SystemEventDispatcher$backgroundListener$1;", "processLifecycleObserver", "com/obric/assistant/interaction/impl/window/SystemEventDispatcher$processLifecycleObserver$1", "Lcom/obric/assistant/interaction/impl/window/SystemEventDispatcher$processLifecycleObserver$1;", "start", "", "display", "Landroid/view/Display;", "stop", "checkAppBackground", "startDisplayListener", "dispatchScreenOff", "source", "", "startBroadcastReceiver", "stopBroadcastReceiver", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemEventDispatcher {
    public static final Companion Companion = null;
    private static final String TAG = "SystemEventDispatcher";
    private final Context appContext;
    private final SystemEventDispatcher$backgroundListener$1 backgroundListener;
    private volatile DisplayManager.DisplayListener displayListener;
    private final DisplayManager displayManager;
    private final SystemEventListener listener;
    private final SystemEventDispatcher$processLifecycleObserver$1 processLifecycleObserver;
    private BroadcastReceiver receiver;
    private volatile boolean screenOffDispatched;
    private volatile boolean started;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/SystemEventDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "isScreenOffState", "", "state", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final boolean isScreenOffState(int r100) {
            if (r100 != 1) goto L5;
            return true;
        L5:
            if (r100 != 3) goto L7;
            return true;
        L7:
            if (r100 == 4) goto L13;
            return false;
        L13:
            return true;
        }

        public static final /* synthetic */ boolean access$isScreenOffState(Companion r100, int r101) {
            return r100.isScreenOffState(r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(SystemEventDispatcher$startDisplayListener$newListener$1 r100, int r101) {
        startDisplayListener$lambda$5(r100, r101);
    }

    private final void startBroadcastReceiver() {
        if (this.receiver == null) goto L5;
        return;
    L5:
        IntentFilter r100 = new IntentFilter();
        r100.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        r100.addAction("android.intent.action.SCREEN_OFF");
        r100.addAction("android.intent.action.SCREEN_ON");
        BroadcastReceiver r101 = new SystemEventDispatcher$startBroadcastReceiver$newReceiver$1(this);
        ContextCompat.registerReceiver(this.appContext, r101, r100, "android.permission.WRITE_SETTINGS", com.larus.utils.t0.f375468a, 4);     // Catch: Exception -> L8
        this.receiver = r101;     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e(TAG, "registerReceiver failed", e);
        this.receiver = null;
    }

    private final void stopBroadcastReceiver() {
        BroadcastReceiver r100 = this.receiver;
        if (r100 != null) goto L16;
        return;
    L16:
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_SystemEventDispatcher_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.appContext, r100);     // Catch: Throwable -> L8 Exception -> L10
    L7:
        this.receiver = null;
        return;
    L10:
        e = move-exception;
        FLogger.f375446a.e(TAG, "unregisterReceiver failed", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.receiver = null;
        throw th;
    }

    public final void checkAppBackground() {
        if (AppHost.f326268a.a().isAppBackground() == false) goto L6;
        FLogger.f375446a.i(TAG, "checkAppBackground: app is in background");
        this.listener.onAppBackground();
        return;
    }

    public final void stop() {
        if (this.started == true) goto L5;
        return;
    L5:
        this.started = false;
        DisplayManager.DisplayListener r100 = this.displayListener;
        this.displayListener = null;
        if (r100 == null) goto L8;
        FLogger.f375446a.i(TAG, "stop display listener");
        this.displayManager.unregisterDisplayListener(r100);
    L8:
        stopBroadcastReceiver();
        AppHost.f326268a.a().c(this.backgroundListener);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        ProcessLifecycleOwner.Companion.get().getLifecycle().removeObserver(this.processLifecycleObserver);     // Catch: Throwable -> L11
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L19;
        FLogger.f375446a.e(TAG, "remove ProcessLifecycleOwner observer failed", r103);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static final /* synthetic */ DisplayManager.DisplayListener access$getDisplayListener$p(SystemEventDispatcher r100) {
        return r100.displayListener;
    }

    public static final /* synthetic */ DisplayManager access$getDisplayManager$p(SystemEventDispatcher r100) {
        return r100.displayManager;
    }

    public static final /* synthetic */ SystemEventListener access$getListener$p(SystemEventDispatcher r100) {
        return r100.listener;
    }

    public static final /* synthetic */ BroadcastReceiver access$getReceiver$p(SystemEventDispatcher r100) {
        return r100.receiver;
    }

    public static final /* synthetic */ boolean access$getStarted$p(SystemEventDispatcher r100) {
        return r100.started;
    }

    private final void dispatchScreenOff(String r100) {
        if (this.screenOffDispatched == false) goto L6;
        FLogger.f375446a.i(TAG, "screen off ignored, already dispatched, source=" + r100);
        return;
    L6:
        this.screenOffDispatched = true;
        FLogger.f375446a.i(TAG, "dispatch screen off, source=" + r100);
        this.listener.onScreenOff();
    }

    private final void startDisplayListener(Display r100) {
        if (r100 != null) goto L6;
        FLogger.f375446a.w(TAG, "start display listener skipped, display is null");
        return;
    L6:
        final int r101 = r100.getDisplayId();
        Ref.IntRef r102 = new Ref.IntRef();
        r102.element = r100.getState();
        FLogger.f375446a.i(TAG, "start display listener, displayId=" + r101 + ", initialState=" + r102.element);
        final SystemEventDispatcher$startDisplayListener$newListener$1 r103 = new SystemEventDispatcher$startDisplayListener$newListener$1(this, r101, r102);
        this.displayListener = r103;
        DisplayManager r104 = this.displayManager;
        Handler r105 = com.larus.utils.t0.f375468a;
        r104.registerDisplayListener(r103, r105);
        r105.post(new y(r103, r101));
    }

    public final void start(Display r100) {
        if (this.started == false) goto L5;
        return;
    L5:
        this.started = true;
        this.screenOffDispatched = false;
        startDisplayListener(r100);
        startBroadcastReceiver();
        AppHost.f326268a.a().j(this.backgroundListener);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(this.processLifecycleObserver);     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L16;
        FLogger.f375446a.e(TAG, "add ProcessLifecycleOwner observer failed", r103);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.obric.assistant.interaction.impl.window.SystemEventDispatcher$backgroundListener$1] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.obric.assistant.interaction.impl.window.SystemEventDispatcher$processLifecycleObserver$1] */
    public SystemEventDispatcher(Context r100, SystemEventListener r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.listener = r101;
        Context r102 = r100.getApplicationContext();
        this.appContext = r102;
        Object r103 = r102.getSystemService("display");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        this.displayManager = (DisplayManager) r103;
        this.backgroundListener = new SystemEventDispatcher$backgroundListener$1(this);
        this.processLifecycleObserver = new SystemEventDispatcher$processLifecycleObserver$1(this);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_SystemEventDispatcher_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static final /* synthetic */ void access$dispatchScreenOff(SystemEventDispatcher r100, String r101) {
        r100.dispatchScreenOff(r101);
    }

    public static final /* synthetic */ void access$setScreenOffDispatched$p(SystemEventDispatcher r100, boolean r101) {
        r100.screenOffDispatched = r101;
    }

    private static final void startDisplayListener$lambda$5(SystemEventDispatcher$startDisplayListener$newListener$1 r100, int r101) {
        r100.onDisplayChanged(r101);
    }

    public static /* synthetic */ void start$default(SystemEventDispatcher r100, Display r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = r100.displayManager.getDisplay(0);
    L5:
        r100.start(r101);
    }
}
