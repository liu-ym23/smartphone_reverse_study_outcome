package com.obric.assistant.interaction.impl.window;

import android.app.Dialog;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.product.platform.api.view.ObricWindowGestureListener;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\fH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/HomeSwipeUpGestureController;", "", "onGestureTriggered", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "generation", "", "registeredToken", "Landroid/os/IBinder;", "registeredListener", "Lcom/obric/aiagent/product/platform/api/view/ObricWindowGestureListener;", "enabled", "", "start", "dialog", "Landroid/app/Dialog;", "stop", "stopInternal", "isFeatureSupported", "registerToFramework", "token", "listener", "unregisterFromFramework", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeSwipeUpGestureController {
    public static final Companion Companion = null;
    private static final String FEATURE_KEY = "obric.window.special.gesture";
    private static final String TAG = "HomeSwipeUpGestureCtl";
    private volatile boolean enabled;
    private int generation;
    private final Function0<Unit> onGestureTriggered;
    private ObricWindowGestureListener registeredListener;
    private IBinder registeredToken;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/HomeSwipeUpGestureController$Companion;", "", "<init>", "()V", "TAG", "", "FEATURE_KEY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(HomeSwipeUpGestureController r100, int r101, View r102) {
        start$lambda$0(r100, r101, r102);
    }

    private final boolean isFeatureSupported() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        iaa.b.f488963a.getClass();     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(iaa.b.b(FEATURE_KEY)));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return ((Boolean) r101).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void stopInternal() {
        IBinder r100 = this.registeredToken;
        ObricWindowGestureListener r101 = this.registeredListener;
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        unregisterFromFramework(r100, r101);
    L6:
        this.registeredToken = null;
        this.registeredListener = null;
        this.enabled = false;
    }

    public final void stop() {
        this.generation++;
        stopInternal();
    }

    public HomeSwipeUpGestureController(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onGestureTriggered");
        this.onGestureTriggered = r100;
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_HomeSwipeUpGestureController_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ Function0 access$getOnGestureTriggered$p(HomeSwipeUpGestureController r100) {
        return r100.onGestureTriggered;
    }

    public final void start(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Window r101 = r100.getWindow();
        if (r101 == null) goto L5;
        final View r102 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_HomeSwipeUpGestureController_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101);
    L7:
        if (r102 != null) goto L11;
        FLogger.f375446a.w(TAG, "start: decorView is null");
        this.enabled = false;
        return;
    L11:
        if (isFeatureSupported() == true) goto L14;
        this.enabled = false;
        return;
    L14:
        final int r103 = this.generation + 1;
        this.generation = r103;
        r102.post(new r(this, r103, r102));
        return;
    L5:
        r102 = null;
        goto L7
    }

    private final boolean registerToFramework(IBinder r100, ObricWindowGestureListener r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(t9a.b.b().windowManager().a(r100, r101)));     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L9;
        FLogger.f375446a.e(TAG, "registerToFramework exception", r104);
    L9:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = r105;
    L13:
        return ((Boolean) r103).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void unregisterFromFramework(IBinder r100, ObricWindowGestureListener r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        t9a.b.b().windowManager().b(r100, r101);     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L12;
        FLogger.f375446a.w(TAG, "unregisterFromFramework failed", r104);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private static final void start$lambda$0(final HomeSwipeUpGestureController r100, int r101, View r102) {
        if (r100.generation == r101) goto L5;
        return;
    L5:
        IBinder r103 = r102.getWindowToken();
        if (r103 != null) goto L10;
        FLogger.f375446a.w(TAG, "start: windowToken is null");
        r100.enabled = false;
        return;
    L10:
        if (Intrinsics.areEqual(r103, r100.registeredToken) == true) goto L12;
    L14:
        r100.stopInternal();
        ObricWindowGestureListener r104 = new HomeSwipeUpGestureController$start$1$listener$1(r100);
        boolean r105 = r100.registerToFramework(r103, r104);
        r100.enabled = r105;
        if (r105 == false) goto L17;
        r100.registeredToken = r103;
        r100.registeredListener = r104;
        FLogger.f375446a.i(TAG, "start: register success");
        return;
    L17:
        FLogger.f375446a.w(TAG, "start: register failed, fallback to broadcast");
        return;
    L12:
        if (r100.enabled == false) goto L14;
    }
}
