package com.bytedance.livesdk.init;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.IBaseHostService;
import com.bytedance.android.livesdk.init.ILiveInitExecutor;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jc1.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u0001H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020'H\u0016J+\u0010(\u001a\u00020\u001d2#\u0010)\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/bytedance/livesdk/init/LiveInitExecutorProxy;", "Lcom/bytedance/android/livesdk/init/ILiveInitExecutor;", "()V", "LOG_TAG", "", "getLOG_TAG", "()Ljava/lang/String;", "LiveInitExecutor", "getLiveInitExecutor", "()Lcom/bytedance/android/livesdk/init/ILiveInitExecutor;", "LiveInitExecutorName", "hostService", "Lcom/bytedance/android/livehostapi/IBaseHostService;", "getHostService", "()Lcom/bytedance/android/livehostapi/IBaseHostService;", "setHostService", "(Lcom/bytedance/android/livehostapi/IBaseHostService;)V", "initAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "str", "", "isFromNewInit", "()Z", "setFromNewInit", "(Z)V", "buildLiveInitExecutor", "doCompleteInit", "", "doInitActionFromBack", "from", "doInitSpecificUnits", "liveUnitKeyList", "", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "doPreInit", "ensureLazy", "getInitStatus", "", "setLiveInitAction", "action", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInitExecutorProxy implements ILiveInitExecutor {
    public static final LiveInitExecutorProxy INSTANCE = null;
    private static final String LOG_TAG = null;
    private static final String LiveInitExecutorName = null;
    private static IBaseHostService hostService;
    private static Function1<? super String, Boolean> initAction;
    private static boolean isFromNewInit;

    public static final class a implements ILiveInitExecutor {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
        public final void doCompleteInit() {
            ALogger.i(LiveInitExecutorProxy.INSTANCE.getLOG_TAG(), "LiveInitExecutorProxy   retLiveInitExecutor  err  doCompleteInit    thread =  " + ThreadMethodProxy.currentThread().getName());
        }

        @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
        public final void doPreInit() {
            ALogger.i(LiveInitExecutorProxy.INSTANCE.getLOG_TAG(), "LiveInitExecutorProxy   retLiveInitExecutor  err  doPreInit    thread =  " + ThreadMethodProxy.currentThread().getName());
        }

        @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
        public final int getInitStatus() {
            ALogger.i(LiveInitExecutorProxy.INSTANCE.getLOG_TAG(), "LiveInitExecutorProxy   retLiveInitExecutor  err  getInitStatus    thread =  " + ThreadMethodProxy.currentThread().getName());
            return 0;
        }

        @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
        public final void doInitSpecificUnits(List<? extends LiveInitUnitKey> r100) {
            Intrinsics.checkNotNullParameter(r100, "liveUnitKeyList");
            ALogger.i(LiveInitExecutorProxy.INSTANCE.getLOG_TAG(), "LiveInitExecutorProxy   retLiveInitExecutor  err  doInitSpecificUnits    thread =  " + ThreadMethodProxy.currentThread().getName());
        }

        @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
        public final void ensureLazy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "from");
            ALogger.i(LiveInitExecutorProxy.INSTANCE.getLOG_TAG(), "LiveInitExecutorProxy   retLiveInitExecutor  err  ensureLazy    thread =  " + ThreadMethodProxy.currentThread().getName());
        }
    }

    private LiveInitExecutorProxy() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private final ILiveInitExecutor buildLiveInitExecutor() {
        ILiveInitExecutor r100 = null;
        int r101 = e.f498076a;     // Catch: Exception -> L8
        Constructor r102 = INVOKESTATIC_com_bytedance_livesdk_init_LiveInitExecutorProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(LiveInitExecutorName).getDeclaredConstructor(new Class[0]);     // Catch: Exception -> L8
        r102.setAccessible(true);     // Catch: Exception -> L8
        Object r103 = r102.newInstance(new Object[0]);     // Catch: Exception -> L8
        if ((r103 instanceof ILiveInitExecutor) == true) goto L6;
        r103 = null;
    L6:
        r100 = (ILiveInitExecutor) r103;     // Catch: Exception -> L8
    L10:
        if (r100 == null) goto L12;
        return r100;
    L12:
        return new a();
    L8:
        e = move-exception;
        ALogger.i(LOG_TAG, "LiveInitExecutorProxy   retLiveInitExecutor  err  " + e + "  thread =  " + ThreadMethodProxy.currentThread().getName());
        goto L10
    }

    static {
        INSTANCE = new LiveInitExecutorProxy();
        LOG_TAG = "LiveInitExecutor_";
        LiveInitExecutorName = "com.bytedance.android.livesdk.liveinit.LiveInitExecutor";
    }

    private final ILiveInitExecutor getLiveInitExecutor() {
        return buildLiveInitExecutor();
    }

    @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
    public void doCompleteInit() {
        getLiveInitExecutor().doCompleteInit();
    }

    @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
    public void doPreInit() {
        getLiveInitExecutor().doPreInit();
    }

    @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
    public int getInitStatus() {
        return getLiveInitExecutor().getInitStatus();
    }

    public final IBaseHostService getHostService() {
        return hostService;
    }

    public final String getLOG_TAG() {
        return LOG_TAG;
    }

    public final boolean isFromNewInit() {
        return isFromNewInit;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_livesdk_init_LiveInitExecutorProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public final void doInitActionFromBack(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Function1<? super String, Boolean> r101 = initAction;
        if (r101 == null) goto L6;
        Boolean r102 = r101.invoke(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
    public void doInitSpecificUnits(List<? extends LiveInitUnitKey> r100) {
        Intrinsics.checkNotNullParameter(r100, "liveUnitKeyList");
        if (isFromNewInit == true) goto L5;
        return;
    L5:
        getLiveInitExecutor().doInitSpecificUnits(r100);
    }

    @Override // com.bytedance.android.livesdk.init.ILiveInitExecutor
    public void ensureLazy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        if (isFromNewInit == true) goto L5;
        return;
    L5:
        getLiveInitExecutor().ensureLazy(r100);
    }

    public final void setFromNewInit(boolean r100) {
        isFromNewInit = r100;
    }

    public final void setHostService(IBaseHostService r100) {
        hostService = r100;
    }

    public final void setLiveInitAction(Function1<? super String, Boolean> r100) {
        initAction = r100;
    }
}
