package com.obric.sva.sdk.ohr;

import android.content.Context;
import aoa.a;
import aoa.b;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.e;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sna.i;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0005J \u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/obric/sva/sdk/ohr/OhrHandStateBridge;", "", "<init>", "()V", "TAG", "", "lock", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "registered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "latestOhrHand", "Ljava/util/concurrent/atomic/AtomicInteger;", "listener", "com/obric/sva/sdk/ohr/OhrHandStateBridge$listener$1", "Lcom/obric/sva/sdk/ohr/OhrHandStateBridge$listener$1;", "switchStateAsync", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enabled", "", "reason", "ensureRegisteredAsync", "syncSwitchState", "tryRegister", "release", "currentOhrHand", "", "refreshCurrentValue", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OhrHandStateBridge {
    public static final OhrHandStateBridge INSTANCE = null;
    private static final String TAG = "OhrHandStateBridge";
    private static final ExecutorService executor = null;
    private static final AtomicInteger latestOhrHand = null;
    private static final OhrHandStateBridge$listener$1 listener = null;
    private static final Object lock = null;
    private static final AtomicBoolean registered = null;

    private OhrHandStateBridge() {
    }

    public static /* synthetic */ void a(Context r100, boolean r101, String r102) {
        switchStateAsync$lambda$2(r100, r101, r102);
    }

    public static /* synthetic */ Thread b(Runnable r100) {
        return executor$lambda$1(r100);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.sva.sdk.ohr.OhrHandStateBridge$listener$1] */
    static {
        INSTANCE = new OhrHandStateBridge();
        lock = new Object();
        executor = PThreadExecutorsUtils.newSingleThreadExecutor(new a());
        registered = new AtomicBoolean(false);
        latestOhrHand = new AtomicInteger(0);
        listener = new OhrHandStateBridge$listener$1();
    }

    public final int currentOhrHand() {
        if (registered.get() == true) goto L5;
    L7:
        return 0;
    L5:
        if (i.a() == false) goto L7;
        return latestOhrHand.get();
    }

    public static final /* synthetic */ AtomicInteger access$getLatestOhrHand$p() {
        return latestOhrHand;
    }

    private static final Thread executor$lambda$1(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "sva-ohr-hand-state");
        r101.setDaemon(true);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void refreshCurrentValue(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        MemoryResponse r102 = e.f397109a.b("ohr_hand");     // Catch: Throwable -> L13
        if (r102.a() == false) goto L10;
        AtomicInteger r103 = latestOhrHand;     // Catch: Throwable -> L13
        Integer r104 = (Integer) r102.f397053c;     // Catch: Throwable -> L13
        if (r104 == null) goto L8;
        int r105 = r104.intValue();     // Catch: Throwable -> L13
    L9:
        r103.set(r105);     // Catch: Throwable -> L13
        LogUtils.i(TAG, "refresh current value reason=" + r100 + " value=" + r103.get(), new Object[0]);     // Catch: Throwable -> L13
    L11:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L21;
        LogUtils.w(TAG, "refresh current value exception reason=" + r100 + " msg=" + r107.getMessage(), new Object[0]);
        return;
    L21:
        return;
    L8:
        r105 = 0;
        goto L9
    L10:
        LogUtils.w(TAG, "refresh current value failed reason=" + r100 + " code=" + r102.f397051a + " msg=" + r102.f397052b, new Object[0]);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private final void release(String r110) {
        Object r100 = lock;
        monitor-enter(r100);
        AtomicBoolean r101 = registered;     // Catch: Throwable -> L23
        if (r101.compareAndSet(true, false) == true) goto L27;
        latestOhrHand.set(0);     // Catch: Throwable -> L23
        monitor-exit(r100);
        return;
    L27:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        e r103 = e.f397109a;     // Catch: Throwable -> L16
        MemoryResponse r104 = r103.j(listener);     // Catch: Throwable -> L16
        if (r104.a() == true) goto L14;
        r101.set(true);     // Catch: Throwable -> L16
        LogUtils.w(TAG, "unregister failed reason=" + r110 + " code=" + r104.f397051a + " msg=" + r104.f397052b, new Object[0]);     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L14:
        r103.g();     // Catch: Throwable -> L16
        latestOhrHand.set(0);     // Catch: Throwable -> L16
        LogUtils.i(TAG, "release success reason=" + r110, new Object[0]);     // Catch: Throwable -> L16
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);     // Catch: Throwable -> L23
        if (r106 == null) goto L21;
        registered.set(true);     // Catch: Throwable -> L23
        LogUtils.w(TAG, "release exception reason=" + r110 + " msg=" + r106.getMessage(), new Object[0]);     // Catch: Throwable -> L23
    L21:
        monitor-exit(r100);
        return;
    L16:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L23
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private final void tryRegister(Context r110, String r111) {
        Object r100 = lock;
        monitor-enter(r100);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (i.a() == true) goto L9;
        LogUtils.i(TAG, "register skipped: truth capture disabled reason=" + r111, new Object[0]);     // Catch: Throwable -> L27
        monitor-exit(r100);
        return;
    L9:
        AtomicBoolean r101 = registered;     // Catch: Throwable -> L27
        if (r101.get() == false) goto L13;
        monitor-exit(r100);
        return;
    L13:
        AtomicInteger r102 = latestOhrHand;     // Catch: Throwable -> L27
        r102.set(0);     // Catch: Throwable -> L27
        OhrHandStateBridge r103 = INSTANCE;     // Catch: Throwable -> L27
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L20
        Context r112 = r110.getApplicationContext();     // Catch: Throwable -> L20
        e r105 = e.f397109a;     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L20
        e.d(r105, r112, new OhrHandStateBridge$tryRegister$1$1$1(), 0, 4);     // Catch: Throwable -> L20
        MemoryResponse r113 = r105.f(listener);     // Catch: Throwable -> L20
        if (r113.a() == false) goto L17;
        r101.set(true);     // Catch: Throwable -> L20
        r103.refreshCurrentValue("register_success");     // Catch: Throwable -> L20
        LogUtils.i(TAG, "register success reason=" + r111 + " latest=" + r102.get(), new Object[0]);     // Catch: Throwable -> L20
    L18:
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);     // Catch: Throwable -> L27
        if (r115 == null) goto L25;
        LogUtils.w(TAG, "register exception reason=" + r111 + " msg=" + r115.getMessage(), new Object[0]);     // Catch: Throwable -> L27
    L25:
        monitor-exit(r100);
        return;
    L17:
        LogUtils.w(TAG, "register failed reason=" + r111 + " code=" + r113.f397051a + " msg=" + r113.f397052b, new Object[0]);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L27
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
        goto L22
    }

    public final void ensureRegisteredAsync(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "reason");
        switchStateAsync(r100, true, r101);
    }

    private static final void switchStateAsync$lambda$2(Context r100, boolean r101, String r102) {
        OhrHandStateBridge r103 = INSTANCE;
        Intrinsics.checkNotNull(r100);
        r103.syncSwitchState(r100, r101, r102);
    }

    private final void syncSwitchState(Context r100, boolean r101, String r102) {
        if (r101 == false) goto L4;
        tryRegister(r100, r102);
        return;
    L4:
        release(r102);
    }

    public final void switchStateAsync(Context r100, final boolean r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "reason");
        final Context r103 = r100.getApplicationContext();
        if (r101 == true) goto L5;
        latestOhrHand.set(0);
    L5:
        executor.execute(new b(r103, r101, r102));
    }
}
