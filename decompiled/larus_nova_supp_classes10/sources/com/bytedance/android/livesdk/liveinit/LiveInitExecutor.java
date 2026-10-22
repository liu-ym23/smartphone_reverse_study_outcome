package com.bytedance.android.livesdk.liveinit;

import android.os.Looper;
import android.util.Log;
import bolts.Task;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.c6;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.ILiveInitExecutor;
import com.bytedance.android.livesdk.init.InitThread;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitStatus;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.livesdk.init.LiveInitExecutorProxy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001!\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R+\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001aj\b\u0012\u0004\u0012\u00020\u0002`\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u0019R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u0019R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010\u0019¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/LiveInitExecutor;", "Lcom/bytedance/android/livesdk/init/ILiveInitExecutor;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "unit", "", "waitWhenIniting", "", "processUnit", "delayInit", "isMainThread", "postInit", "initUnit", "beforContextInit", "", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "liveUnitKeyList", "doInitSpecificUnits", "doCompleteInit", "doPreInit", "", "from", "ensureLazy", "", "getInitStatus", "calledEnsureLazy", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "units$delegate", "Lkotlin/Lazy;", "getUnits", "()Ljava/util/ArrayList;", "units", "com/bytedance/android/livesdk/liveinit/LiveInitExecutor$completionLatch$2$a", "completionLatch$delegate", "getCompletionLatch", "()Lcom/bytedance/android/livesdk/liveinit/LiveInitExecutor$completionLatch$2$a;", "completionLatch", "Ljava/util/concurrent/atomic/AtomicInteger;", "completeInitStatus", "Ljava/util/concurrent/atomic/AtomicInteger;", "isPreInitSuccess", "isLazyInitSuccess", "isContextInited", "<init>", "()V", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitExecutor implements ILiveInitExecutor {
    public static final LiveInitExecutor INSTANCE = null;
    private static boolean calledEnsureLazy;
    private static AtomicInteger completeInitStatus;
    private static final Lazy completionLatch$delegate = null;
    private static boolean isContextInited;
    private static volatile boolean isLazyInitSuccess;
    private static volatile boolean isPreInitSuccess;
    private static final Lazy units$delegate = null;

    public static final class a implements Runnable {
        public final /* synthetic */ AbsLiveInitUnit a;
        public final /* synthetic */ boolean b;

        public a(AbsLiveInitUnit r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveInitExecutor.access$postInit(LiveInitExecutor.INSTANCE, this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AbsLiveInitUnit a;

        public b(AbsLiveInitUnit r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveInitExecutor.access$initUnit(LiveInitExecutor.INSTANCE, this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<V> implements Callable {
        public final /* synthetic */ AbsLiveInitUnit a;

        public c(AbsLiveInitUnit r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            LiveInitExecutor.access$initUnit(LiveInitExecutor.INSTANCE, this.a);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    private LiveInitExecutor() {
    }

    private final LiveInitExecutor$completionLatch$2.a getCompletionLatch() {
        return (LiveInitExecutor$completionLatch$2.a) completionLatch$delegate.getValue();
    }

    private final ArrayList<AbsLiveInitUnit> getUnits() {
        return (ArrayList) units$delegate.getValue();
    }

    static {
        final LiveInitExecutor r0 = new LiveInitExecutor();
        INSTANCE = r0;
        units$delegate = LazyKt.lazy(LiveInitExecutor$units$2.INSTANCE);
        completionLatch$delegate = LazyKt.lazy(new LiveInitExecutor$completionLatch$2(r0));
        completeInitStatus = new AtomicInteger(0);
    }

    private final void beforContextInit() {
        if (isContextInited == false) goto L5;
        return;
    L5:
        TTLiveSDK.initContext(LiveInitExecutorProxy.INSTANCE.getHostService());
        IHostService r0 = TTMiddlewareLiveSDK.sHostService;
        if (r0 == null) goto L10;
        TTLiveSDKContext.initHostService(r0);
        int r1 = com.bytedance.android.livesdk.liveinit.a.a;
        com.bytedance.android.livesdk.liveinit.a.b(INetworkService.class, AnonymousClass1.INSTANCE);
        isContextInited = true;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livehostapi.IHostService");
    }

    public void doCompleteInit() {
        if (completeInitStatus.get() != 2) goto L5;
        return;
    L5:
        LiveInitAssistant.INSTANCE.markThread(ThreadMethodProxy.currentThread().getName());
        beforContextInit();
        completeInitStatus.compareAndSet(0, 1);
        ArrayList<AbsLiveInitUnit> r0 = getUnits();
        ArrayList r4 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Object r5 = r1.next();
        if (((AbsLiveInitUnit) r5).initPoint() == LiveInitPoint.COMPLETE_AFTER) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L7;
        r4.add(r5);
        goto L7
    L11:
        r6 = false;
        goto L12
    L14:
        Iterator r2 = r4.iterator();
    L16:
        if (r2.hasNext() == false) goto L18;
        AbsLiveInitUnit r7 = (AbsLiveInitUnit) r2.next();
        INSTANCE.processUnit(r7, false);
        goto L16
    L18:
        getCompletionLatch().await();
        ArrayList<AbsLiveInitUnit> r3 = getUnits();
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r3.iterator();
    L20:
        if (r9.hasNext() == false) goto L27;
        Object r10 = r9.next();
        if (((AbsLiveInitUnit) r10).initPoint() != LiveInitPoint.COMPLETE_AFTER) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L20;
        r8.add(r10);
        goto L20
    L24:
        r11 = false;
        goto L25
    L27:
        Iterator r12 = r8.iterator();
    L29:
        if (r12.hasNext() == false) goto L31;
        AbsLiveInitUnit r13 = (AbsLiveInitUnit) r12.next();
        INSTANCE.processUnit(r13, true);
        goto L29
    L31:
        completeInitStatus.set(2);
        c6.a = true;
    }

    public void doPreInit() {
        if (isPreInitSuccess == false) goto L5;
        return;
    L5:
        beforContextInit();
        ArrayList<AbsLiveInitUnit> r0 = getUnits();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L14;
        Object r4 = r2.next();
        if (((AbsLiveInitUnit) r4).initPoint() == LiveInitPoint.PRE_INIT) goto L12;
        r3 = false;
    L12:
        if (r3 == false) goto L6;
        r1.add(r4);
        goto L6
    L14:
        Iterator r5 = r1.iterator();
    L16:
        if (r5.hasNext() == false) goto L20;
        AbsLiveInitUnit r6 = (AbsLiveInitUnit) r5.next();
        if (r6.getInitStatus() == LiveInitStatus.INITED) goto L16;
        INSTANCE.processUnit(r6, true);
        goto L16
    L20:
        isPreInitSuccess = true;
    }

    public int getInitStatus() {
        return completeInitStatus.get();
    }

    public static final /* synthetic */ ArrayList access$getUnits$p(LiveInitExecutor r0) {
        return r0.getUnits();
    }

    private final void delayInit(AbsLiveInitUnit r7) {
        long r0 = r7.postDelayTime();
        boolean r2 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        if (r0 > 0) goto L5;
        postInit(r7, r2);
        return;
    L5:
        a r3 = new a(r7, r2);
        i0.c().postDelayed(r3, r0);
    }

    private final void initUnit(AbsLiveInitUnit r10) {
        r10.getInitLock().lock();
        if (r10.getInitStatus() == LiveInitStatus.NOT_INIT) goto L6;
        r10.getInitLock().unlock();
        return;
    L6:
        boolean r0 = true;
        r10.setInitStatus(LiveInitStatus.INITING);     // Catch: Throwable -> L30
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L30
        r10.initialize();     // Catch: Throwable -> L30
        long r4 = System.currentTimeMillis() - r2;     // Catch: Throwable -> L30
        LiveInitAssistant.INSTANCE.markDuration(r10.getUnitKey() + "_DURATION", r4);     // Catch: Throwable -> L30
        ALogger.i(LiveInitExecutorProxy.INSTANCE.getLOG_TAG(), r10.getUnitKey().toString() + "  duration=" + r4 + "  thread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L30
        r10.setInitStatus(LiveInitStatus.INITED);
        if (r10.needBlock() == false) goto L12;
        getCompletionLatch().countDown();
    L12:
        if (r10.needBlock() == true) goto L28;
        ArrayList<AbsLiveInitUnit> r3 = getUnits();
        if ((r3 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r5 = r3.iterator();
    L20:
        if (r5.hasNext() == false) goto L17;
        if (((AbsLiveInitUnit) r5.next()).getInitStatus() == LiveInitStatus.INITED) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == false) goto L20;
    L26:
        if (r0 == true) goto L28;
        LiveInitAssistant.INSTANCE.markInitFinished();
        goto L28
    L24:
        r6 = false;
    L17:
        r0 = false;
        goto L26
    L16:
        if (r3.isEmpty() == false) goto L18;
    L28:
        r10.getInitLock().unlock();
        return;
    L30:
        th = move-exception;
        ALogger.i(LiveInitExecutorProxy.INSTANCE.getLOG_TAG(), r10.getUnitKey().toString() + "  initUnit err  " + Log.getStackTraceString(th));     // Catch: Throwable -> L35
        if ((th instanceof Exception) == false) goto L34;
        LiveInitAssistant.INSTANCE.reportError(th, "LiveInitExecutor_ERR", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("unit_key", r10.getUnitKey().toString())}));     // Catch: Throwable -> L35
    L34:
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r10.setInitStatus(LiveInitStatus.INITED);
        if (r10.needBlock() == false) goto L40;
        getCompletionLatch().countDown();
    L40:
        if (r10.needBlock() == true) goto L56;
        ArrayList<AbsLiveInitUnit> r7 = getUnits();
        if ((r7 instanceof Collection) == true) goto L44;
    L46:
        Iterator<T> r8 = r7.iterator();
    L48:
        if (r8.hasNext() == false) goto L45;
        if (((AbsLiveInitUnit) r8.next()).getInitStatus() == LiveInitStatus.INITED) goto L52;
        boolean r9 = true;
    L53:
        if (r9 == false) goto L48;
    L54:
        if (r0 == true) goto L56;
        LiveInitAssistant.INSTANCE.markInitFinished();
        goto L56
    L52:
        r9 = false;
    L45:
        r0 = false;
        goto L54
    L44:
        if (r7.isEmpty() == false) goto L46;
    L56:
        r10.getInitLock().unlock();
        throw th;
    }

    public void doInitSpecificUnits(List<? extends LiveInitUnitKey> r6) {
        Intrinsics.checkNotNullParameter(r6, "liveUnitKeyList");
        beforContextInit();
        Iterator<? extends LiveInitUnitKey> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L21;
        LiveInitUnitKey r0 = r7.next();
        Iterator<T> r1 = getUnits().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        if (((AbsLiveInitUnit) r2).getUnitKey() != r0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L7;
    L15:
        AbsLiveInitUnit r3 = (AbsLiveInitUnit) r2;
        if (r3 == null) goto L4;
        if (r3.getInitStatus() == LiveInitStatus.INITED) goto L4;
        processUnit(r3, true);
        goto L4
    L11:
        r4 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    public void ensureLazy(String r10) {
        Intrinsics.checkNotNullParameter(r10, "from");
        LiveInitExecutorProxy r0 = LiveInitExecutorProxy.INSTANCE;
        String r1 = r0.getLOG_TAG();
        StringBuilder r2 = new StringBuilder("ensureLazy   ");
        r2.append(r10);
        r2.append("  isLazyInitSuccess = ");
        r2.append(isLazyInitSuccess);
        r2.append("  isContextInited ");
        r2.append(isContextInited);
        r2.append("  ");
        if (r0.getHostService() != null) goto L5;
        boolean r4 = true;
    L6:
        r2.append(r4);
        ALogger.i(r1, r2.toString());
        calledEnsureLazy = true;
        if (isContextInited == true) goto L9;
    L14:
        ALogger.i(r0.getLOG_TAG(), "ensureLazy return  err   " + r10 + "   " + TTLiveSDKContext.getHostService() + " }");
        if (v.a() == true) goto L18;
        return;
    L18:
        if (isLazyInitSuccess == false) goto L20;
        return;
    L20:
        ArrayList<AbsLiveInitUnit> r3 = getUnits();
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L22:
        if (r6.hasNext() == false) goto L31;
        Object r7 = r6.next();
        AbsLiveInitUnit r8 = (AbsLiveInitUnit) r7;
        if (r8.initPoint() == LiveInitPoint.ENTER_ROOM) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == false) goto L22;
        r5.add(r7);
        goto L22
    L26:
        if (r8.getInitStatus() == LiveInitStatus.INITED) goto L28;
        r9 = true;
        goto L29
    L31:
        ALogger.i(LiveInitExecutorProxy.INSTANCE.getLOG_TAG(), "ensureLazy   " + r10 + "  size = " + r5.size());
        Iterator r11 = r5.iterator();
    L33:
        if (r11.hasNext() == false) goto L35;
        INSTANCE.processUnit((AbsLiveInitUnit) r11.next(), true);
        goto L33
    L35:
        isLazyInitSuccess = true;
        return;
    L9:
        if (r0.getHostService() == null) goto L14;
        if (TTLiveSDKContext.getHostService() == null) goto L14;
        if (TTLiveSDKContext.getHostService().b() != null) goto L18;
    L5:
        r4 = false;
        goto L6
    }

    public static final /* synthetic */ void access$initUnit(LiveInitExecutor r0, AbsLiveInitUnit r1) {
        r0.initUnit(r1);
    }

    private final void postInit(AbsLiveInitUnit r2, boolean r3) {
        if (r3 == false) goto L6;
        if (r2.lazyInitThread() != InitThread.WITH_CALLER) goto L6;
    L7:
        i0.h(new b(r2));
        return;
    L6:
        if (r2.lazyInitThread() == InitThread.MAIN) goto L7;
        Task.callInBackground(new c(r2));
    }

    private final void processUnit(AbsLiveInitUnit r3, boolean r4) {
        if (r3.getInitStatus() != LiveInitStatus.INITED) goto L6;
        return;
    L6:
        if (r3.getInitStatus() != LiveInitStatus.INITING) goto L10;
        if (r4 == true) goto L10;
        return;
    L10:
        if (r3.needBlock() == true) goto L16;
        if (r4 == true) goto L16;
        if (calledEnsureLazy == true) goto L16;
        delayInit(r3);
        return;
    L16:
        initUnit(r3);
    }

    public static final /* synthetic */ void access$postInit(LiveInitExecutor r0, AbsLiveInitUnit r1, boolean r2) {
        r0.postInit(r1, r2);
    }
}
