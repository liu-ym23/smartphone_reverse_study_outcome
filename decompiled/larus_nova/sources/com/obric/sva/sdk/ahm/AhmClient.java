package com.obric.sva.sdk.ahm;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;
import vendor.bytedance.hardware.ahm.IAHMIDL;
import yna.b;
import yna.c;
import yna.d;
import yna.e;
import yna.f;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020!J\b\u0010#\u001a\u00020\u001cH\u0002J\u0006\u0010$\u001a\u00020!J\b\u0010%\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0015H\u0002J\u001c\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010\u00152\b\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/sva/sdk/ahm/AhmClient;", "", "<init>", "()V", "TAG", "", "HAL_SERVICE_NAME", "RETRY_INITIAL_DELAY_MS", "", "RETRY_MAX_DELAY_MS", "RETRY_MAX_ATTEMPTS", "", "callback", "Lcom/obric/sva/sdk/ahm/AhmCallback;", "handlerThread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "mAhm", "Lvendor/bytedance/hardware/ahm/IAHMIDL;", "ahmBinder", "Landroid/os/IBinder;", "ahmDeathRecipient", "Landroid/os/IBinder$DeathRecipient;", "lock", "retryAttempt", "Ljava/util/concurrent/atomic/AtomicInteger;", "reconnectEnabled", "", "openTask", "Ljava/lang/Runnable;", "reconnectTask", "initAhm", "", "open", "openInternal", "close", "closeInternal", "onAhmBinderDied", "deadBinder", "unlinkDeathRecipientLocked", "binder", "deathRecipient", "scheduleReconnect", "cancelReconnect", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AhmClient {
    private static final String HAL_SERVICE_NAME = "vendor.bytedance.hardware.ahm.IAHMIDL/default";
    public static final AhmClient INSTANCE = null;
    private static final long RETRY_INITIAL_DELAY_MS = 500;
    private static final int RETRY_MAX_ATTEMPTS = 20;
    private static final long RETRY_MAX_DELAY_MS = 20000;
    public static final String TAG = "AhmClient";
    private static volatile IBinder ahmBinder;
    private static IBinder.DeathRecipient ahmDeathRecipient;
    private static final AhmCallback callback = null;
    private static final Handler handler = null;
    private static final HandlerThread handlerThread = null;
    private static final Object lock = null;
    private static volatile IAHMIDL mAhm;
    private static final Runnable openTask = null;
    private static volatile boolean reconnectEnabled;
    private static final Runnable reconnectTask = null;
    private static final AtomicInteger retryAttempt = null;

    private AhmClient() {
    }

    public static /* synthetic */ void a() {
        openTask$lambda$1();
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ void b() {
        reconnectTask$lambda$3();
    }

    public static /* synthetic */ void c(IBinder r100) {
        initAhm$lambda$7$lambda$6(r100);
    }

    public static /* synthetic */ void d(IBinder r100) {
        initAhm$lambda$7$lambda$6$lambda$5(r100);
    }

    public static /* synthetic */ void e() {
        close$lambda$10();
    }

    public final void close() {
        reconnectEnabled = false;
        retryAttempt.set(0);
        Handler r100 = handler;
        r100.removeCallbacks(openTask);
        r100.removeCallbacks(reconnectTask);
        r100.post(new c());
    }

    public final void open() {
        reconnectEnabled = true;
        retryAttempt.set(0);
        Handler r100 = handler;
        Runnable r101 = openTask;
        r100.removeCallbacks(r101);
        r100.removeCallbacks(reconnectTask);
        r100.post(r101);
    }

    static {
        INSTANCE = new AhmClient();
        callback = new AhmCallback();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("sva-ahm-client");
        ThreadMethodProxy.start(r100);
        handlerThread = r100;
        handler = new Handler(r100.getLooper());
        lock = new Object();
        retryAttempt = new AtomicInteger(0);
        openTask = new e();
        reconnectTask = new f();
    }

    private final void cancelReconnect() {
        retryAttempt.set(0);
        handler.removeCallbacks(reconnectTask);
    }

    private static final void close$lambda$10() {
        INSTANCE.closeInternal();
    }

    private final void closeInternal() {
        Object r100 = lock;
        monitor-enter(r100);
        IAHMIDL r101 = mAhm;     // Catch: Throwable -> L15
        INSTANCE.unlinkDeathRecipientLocked(ahmBinder, ahmDeathRecipient);     // Catch: Throwable -> L15
        mAhm = null;     // Catch: Throwable -> L15
        ahmBinder = null;     // Catch: Throwable -> L15
        ahmDeathRecipient = null;     // Catch: Throwable -> L15
        monitor-exit(r100);
        if (r101 != null) goto L20;
        LogUtils.i(TAG, "=====mAhm is null =====", new Object[0]);
        return;
    L20:
        LogUtils.i(TAG, "=====ipc_ahm_close ret: " + r101.ipc_ahm_close() + "=====", new Object[0]);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        LogUtils.e(TAG, "Close Ahm failed: " + e.getMessage(), new Object[0]);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private final void initAhm() {
        LogUtils.i(TAG, "===== initAhm =====", new Object[0]);
        Object r100 = lock;
        monitor-enter(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        Method r102 = INVOKESTATIC_com_obric_sva_sdk_ahm_AhmClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class});     // Catch: Throwable -> L11
        r102.setAccessible(true);     // Catch: Throwable -> L11
        Object r103 = r102.invoke(null, new Object[]{HAL_SERVICE_NAME});     // Catch: Throwable -> L11
        if ((r103 instanceof IBinder) == false) goto L8;
        IBinder r104 = (IBinder) r103;     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == false) goto L16;
        r105 = null;
    L16:
        final IBinder r106 = (IBinder) r105;     // Catch: Throwable -> L41
        LogUtils.i(TAG, "=====binder: " + r106 + "=====", new Object[0]);     // Catch: Throwable -> L41
        if (r106 != null) goto L21;
        INSTANCE.unlinkDeathRecipientLocked(ahmBinder, ahmDeathRecipient);     // Catch: Throwable -> L41
        mAhm = null;     // Catch: Throwable -> L41
        ahmBinder = null;     // Catch: Throwable -> L41
        ahmDeathRecipient = null;     // Catch: Throwable -> L41
        monitor-exit(r100);
        return;
    L21:
        IBinder r107 = ahmBinder;     // Catch: Throwable -> L41
        if (r107 == r106) goto L24;
    L31:
        INSTANCE.unlinkDeathRecipientLocked(r107, ahmDeathRecipient);     // Catch: Throwable -> L41
        IBinder.DeathRecipient r108 = new b(r106);     // Catch: Throwable -> L41
        r106.linkToDeath(r108, 0);     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
        IAHMIDL r109 = IAHMIDL.Stub.asInterface(r106);     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
        ahmBinder = r106;     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
        ahmDeathRecipient = r108;     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
        mAhm = r109;     // Catch: Exception -> L34 RemoteException -> L36 Throwable -> L41
    L38:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r100);
        return;
    L36:
        e = move-exception;
        LogUtils.e(TAG, "linkToDeath failed: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L41
        INSTANCE.unlinkDeathRecipientLocked(r106, r108);     // Catch: Throwable -> L41
        mAhm = null;     // Catch: Throwable -> L41
        ahmBinder = null;     // Catch: Throwable -> L41
        ahmDeathRecipient = null;     // Catch: Throwable -> L41
    L34:
        e = move-exception;
        LogUtils.e(TAG, "initAhm failed: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L41
        INSTANCE.unlinkDeathRecipientLocked(r106, r108);     // Catch: Throwable -> L41
        mAhm = null;     // Catch: Throwable -> L41
        ahmBinder = null;     // Catch: Throwable -> L41
        ahmDeathRecipient = null;     // Catch: Throwable -> L41
        goto L38
    L24:
        if (mAhm == null) goto L31;
        if (ahmDeathRecipient == null) goto L31;
        if (r106.isBinderAlive() == false) goto L31;
        monitor-exit(r100);
        return;
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L41
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    private final boolean openInternal() {
        if (reconnectEnabled == true) goto L5;
        return false;
    L5:
        LogUtils.i(TAG, "===== AHM: open =====", new Object[0]);
        initAhm();
        if (reconnectEnabled == true) goto L21;
        return false;
    L21:
        IAHMIDL r100 = mAhm;     // Catch: Exception -> L18
        if (r100 == null) goto L16;
        AhmCallback r101 = callback;     // Catch: Exception -> L18
        r101.setVendorStability();     // Catch: Exception -> L18
        long r102 = r100.ipc_ahm_open_v2(r101, 1);     // Catch: Exception -> L18
        LogUtils.i(TAG, "=====ipc_ahm_open_v2 ret: " + r102 + "=====", new Object[0]);     // Catch: Exception -> L18
        if (r102 != 0) goto L13;
        INSTANCE.cancelReconnect();     // Catch: Exception -> L18
    L13:
        if (r102 != 0) goto L22;
        return true;
    L22:
        return false;
    L16:
        LogUtils.i(TAG, "=====AHM service is null=====", new Object[0]);     // Catch: Exception -> L18
        return false;
    L18:
        e = move-exception;
        LogUtils.e(TAG, "Open Ahm failed: " + e.getMessage(), new Object[0]);
        return false;
    }

    private static final void openTask$lambda$1() {
        INSTANCE.openInternal();
    }

    private static final void reconnectTask$lambda$3() {
        AhmClient r100 = INSTANCE;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(r100.openInternal()));     // Catch: Throwable -> L5
    L7:
        Boolean r103 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = r103;
    L11:
        if (((Boolean) r102).booleanValue() == true) goto L16;
        INSTANCE.scheduleReconnect();
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void scheduleReconnect() {
        if (reconnectEnabled == true) goto L5;
        return;
    L5:
        Handler r100 = handler;
        Runnable r101 = reconnectTask;
        r100.removeCallbacks(r101);
        AtomicInteger r102 = retryAttempt;
        int r103 = r102.get();
        if (r103 < 20) goto L9;
        LogUtils.e(TAG, "reconnect give up, attempt=" + r103, new Object[0]);
        reconnectEnabled = false;
        closeInternal();
        return;
    L9:
        long r104 = RangesKt.coerceAtMost(500 << RangesKt.coerceAtMost(r103, 5), 20000);
        r102.incrementAndGet();
        r100.postDelayed(r101, r104);
        LogUtils.i(TAG, "reconnect scheduled, attempt=" + r103 + " delayMs=" + r104, new Object[0]);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_sdk_ahm_AhmClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static final void initAhm$lambda$7$lambda$6(final IBinder r100) {
        handler.post(new d(r100));
    }

    private static final void initAhm$lambda$7$lambda$6$lambda$5(IBinder r100) {
        INSTANCE.onAhmBinderDied(r100);
    }

    private final void onAhmBinderDied(IBinder r100) {
        Object r101 = lock;
        monitor-enter(r101);
        boolean r102 = false;
        LogUtils.i(TAG, "=====onAhmBinderDied===== dead=" + r100 + " current=" + ahmBinder, new Object[0]);     // Catch: Throwable -> L13
        if (ahmBinder == r100) goto L7;
        LogUtils.i(TAG, "ignore stale AHM binder death", new Object[0]);     // Catch: Throwable -> L13
    L9:
        monitor-exit(r101);
        if (r102 == false) goto L17;
        scheduleReconnect();
        return;
    L17:
        return;
    L7:
        INSTANCE.unlinkDeathRecipientLocked(r100, ahmDeathRecipient);     // Catch: Throwable -> L13
        mAhm = null;     // Catch: Throwable -> L13
        ahmBinder = null;     // Catch: Throwable -> L13
        ahmDeathRecipient = null;     // Catch: Throwable -> L13
        r102 = true;
    L13:
        th = move-exception;
        throw th;
    }

    private final void unlinkDeathRecipientLocked(IBinder r100, IBinder.DeathRecipient r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Boolean.valueOf(r100.unlinkToDeath(r101, 0)));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L13:
        return;
    }
}
