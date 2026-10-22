package com.bytedance.android.livesdk.liveinit.other;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ce1.e;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.utils.ScreenShotUtils;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.detail.LiveRoomDurationRetrieveLogger;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.ne;
import com.bytedance.android.livesdk.config.x9;
import com.bytedance.android.livesdk.debugtools.AntiDeteriorationBroadcastReceiver;
import com.bytedance.android.livesdk.floatview.IFloatWindowManager;
import com.bytedance.android.livesdk.floatview.VideoFloatWindowManager;
import com.bytedance.android.livesdk.floatview.q;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.InitThread;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.f0;
import com.bytedance.android.livesdk.performance.LivePerformanceManager;
import com.bytedance.android.livesdk.r1;
import com.bytedance.android.livesdk.service.f;
import com.bytedance.android.livesdk.utils.a5;
import com.bytedance.android.livesdk.utils.d7;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.tools.superkv.i;
import com.bytedance.android.tools.superkv.j;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.inflater.PriorityAsyncLayoutInflater;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0017J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/other/LiveOtherLazyInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initHookForAlphaVideoSurfaceView", "", "initNewVideoInnerFloatManager", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "lazyInitThread", "Lcom/bytedance/android/livesdk/init/InitThread;", "postDelayTime", "", "reportAnchorApplicationExitInfo", "reportDeviceTotalMemory", "reportWatchingTag", "hostApp", "Lcom/bytedance/android/livehostapi/foundation/IHostApp;", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOtherLazyInitUnit extends AbsLiveInitUnit {
    public static final LiveOtherLazyInitUnit INSTANCE = null;

    public static final class a implements j {
        public a() {
        }

        public static void a(int r2, String r3) {
            if (r2 != 1) goto L5;
            b0.o().getClass();
            g.i("SuperKV", r3);
            return;
        L5:
            if (r2 != 2) goto L7;
            b0.o().getClass();
            g.n("SuperKV", r3);
            return;
        L7:
            if (r2 == 3) goto L9;
            b0.o().getClass();
            g.c("SuperKV", r3);
            return;
        L9:
            b0.o().getClass();
            g.c("SuperKV", r3);
        }

        public final void onLog(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "message");
            a(r2, r3);
        }

        public final void onLog(int r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r3, "throwable");
            a(3, r2);
            b0 r4 = b0.o();
            StackTraceElement[] r5 = r3.getStackTrace();
            r4.getClass();
            g.m(6, r5);
        }
    }

    public static final class b implements Runnable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveOtherLazyInitUnit r0 = LiveOtherLazyInitUnit.INSTANCE;     // Catch: Throwable -> L8
            LiveOtherLazyInitUnit.access$reportDeviceTotalMemory(r0);     // Catch: Throwable -> L8
            LiveOtherLazyInitUnit.access$reportAnchorApplicationExitInfo(r0);     // Catch: Throwable -> L8
            f r1 = TTLiveSDKContext.getHostService();     // Catch: Throwable -> L8
            if (r1 == null) goto L11;
            IHostContext r2 = r1.b();     // Catch: Throwable -> L8
            if (r2 == null) goto L15;
            int r3 = ft1.a.a;     // Catch: Throwable -> L8
            r2.context();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class c implements ScreenShotUtils.a {
        public c() {
        }

        public final ILivePlayerClient currentClient() {
            ILivePlayerClient r0 = LivePlatformPlayerManager.f();
            Intrinsics.checkNotNull(r0);
            return r0;
        }
    }

    public static final class d implements IHostAppMonitorListener {
        public final /* synthetic */ IHostApp a;

        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public d(IHostApp r1) {
            this.a = r1;
        }

        public final void onActivityResumed(Activity r5) {
            Intrinsics.checkNotNullParameter(r5, "activity");
            List r0 = this.a.getAllLiveActivity();     // Catch: Throwable -> L31
            boolean r1 = true;
            if (r0 != null) goto L6;
        L5:
            boolean r2 = false;
        L12:
            x50.a.b(r2);     // Catch: Throwable -> L31
            if (r2 == true) goto L15;
        L28:
            r1 = false;
        L29:
            x50.a.d(r1);     // Catch: Throwable -> L31
            return;
        L15:
            if ((r5 instanceof FragmentActivity) == true) goto L17;
        L16:
            boolean r6 = false;
        L26:
            if (r6 == false) goto L28;
        L17:
            FragmentManager r7 = ((FragmentActivity) r5).getSupportFragmentManager();     // Catch: Throwable -> L31
            if (r7 == null) goto L16;
            Iterator r8 = r7.getFragments().iterator();     // Catch: Throwable -> L31
        L22:
            if (r8.hasNext() == false) goto L16;
            if ((((Fragment) r8.next()) instanceof ILiveRoomPageFragment) == false) goto L22;
            r6 = true;
            goto L26
        L6:
            Iterator r3 = r0.iterator();     // Catch: Throwable -> L31
        L8:
            if (r3.hasNext() == false) goto L5;
            if (((Class) r3.next()).isInstance(r5) == false) goto L8;
            r2 = true;
        }

        public final void appEnterBackground(boolean r2, boolean r3) {
            if (r2 == true) goto L4;
            return;
        L4:
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L11;
            if (r3 == false) goto L7;
            return;
        L7:
            if (d7.a == true) goto L13;
            d7.a = true;
            return;
        L13:
            return;
        }
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        INSTANCE = new LiveOtherLazyInitUnit();
    }

    private final void initHookForAlphaVideoSurfaceView() {
        int r0 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L12
        if (r0 == 30) goto L9;
        if (r0 == 31) goto L9;
        if (r0 == 32) goto L9;
        return;
    L9:
        if (tb1.c.a == false) goto L18;
        Method r1 = INVOKESTATIC_com_bytedance_android_livesdk_liveinit_other_LiveOtherLazyInitUnit_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.livesdk.SurfaceViewHacker").getDeclaredMethod("initHook", new Class[0]);     // Catch: Throwable -> L12
        r1.setAccessible(true);     // Catch: Throwable -> L12
        r1.invoke(null, new Object[0]);     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
    }

    private final void reportDeviceTotalMemory() {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (((Boolean) x9.a.getValue()).booleanValue() == false) goto L13;
        Object r0 = TTLiveSDKContext.getHostService().b().context().getSystemService("activity");     // Catch: Throwable -> L9
        if (r0 == null) goto L8;
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L9
        ((ActivityManager) r0).getMemoryInfo(r1);     // Catch: Throwable -> L9
        String r2 = String.valueOf(r1.totalMem / 1.0737418E9f);     // Catch: Throwable -> L9
        HashMap r3 = new HashMap();     // Catch: Throwable -> L9
        r3.put("total_memory_GB", r2);     // Catch: Throwable -> L9
        Npth.addTags(r3);     // Catch: Throwable -> L9
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L9
    }

    public void initialize() {
        if (((Boolean) r1.a.getValue()).booleanValue() == true) goto L5;
        k.l(IPerformanceManager.class, new LivePerformanceManager());
    L5:
        TTLiveSDKContext.getHostService().a.webView().setCachePrefix(TTLiveWebOfflineConfig.getOfflinePatterns());
        LiveInitSettingKeys.get_LIVE_SETTINGS_MONITOR();
        if (LiveInitSettingKeys.get_LIVE_LOGSDK_CONFIG().a() == false) goto L10;
        LiveInitSettingKeys.get_LIVE_LOGSDK_CONFIG().getClass();
        v.a();
        int r0 = ww2.a.a;
        sw2.a.a();
        List r1 = LiveInitSettingKeys.get_LIVE_LOG_SDK_SPM_BLACK_LIST();
        if (r1 == null) goto L10;
        sw2.a.a.addAll(r1);
    L10:
        ConcurrentHashMap r2 = qc.a.a;
        v.a();
        boolean r3 = true;
        boolean r4 = false;
        LocalTestManager.a(new Class[]{wy.a.class});
        i.a r5 = i.a;
        int r6 = com.bytedance.android.tools.superkv.g.q;
        int r7 = com.bytedance.android.tools.superkv.g.r;
        String r8 = TTLiveSDKContext.getHostService().b().context().getFilesDir().getPath() + File.separator + "live_kv";
        LocalTestManager.a(new Class[]{wy.a.class});
        a r9 = new a();
        if (i.b == false) goto L13;
        com.bytedance.android.tools.superkv.b.e(new IllegalStateException("SuperKV must not be initialized twice!"));
    L13:
        com.bytedance.android.tools.superkv.b.b = r9;
        if (r6 > 128) goto L16;
        com.bytedance.android.tools.superkv.b.e(new IllegalArgumentException("Initial file size must > 128"));
    L16:
        PolarisFileWrapper r10 = new PolarisFileWrapper(r8);
        if (r10.exists() == true) goto L19;
        r10.mkdir();
    L19:
        i.a r11 = i.a;
        r11.b = r8;
        r11.c = 64;
        com.bytedance.android.tools.superkv.b.a = false;
        com.bytedance.android.tools.superkv.g.q = r6;
        com.bytedance.android.tools.superkv.g.r = r7;
        i.b = true;
        Npth.registerSdk(1729, String.valueOf(com.bytedance.android.livesdk.paas.c.b()));     // Catch: Throwable -> L22
        x50.a.c();     // Catch: Throwable -> L22
        x50.a.d(false);     // Catch: Throwable -> L22
        x50.a.b(false);     // Catch: Throwable -> L22
        reportWatchingTag(TTLiveSDKContext.getHostService().e());     // Catch: Throwable -> L22
        i0.c().postDelayed(b.a, 10000);     // Catch: Throwable -> L22
        PriorityAsyncLayoutInflater.setIgnoreInflateAfterContextDestroy(((Boolean) ne.a.getValue()).booleanValue());     // Catch: Throwable -> L22
    L23:
        f0 r12 = new f0();
        ce1.d r13 = e.a;
        Intrinsics.checkNotNullParameter(r12, "loggerDepend");
        e.a = r12;
        TraceMonitor.g(new com.bytedance.android.livesdk.monitor.trace.a());
        c r14 = new c();
        ScreenShotUtils.a r15 = ScreenShotUtils.a;
        Intrinsics.checkNotNullParameter(r14, "provider");
        ScreenShotUtils.a = r14;
        if (v.a() == false) goto L31;
        IntentFilter r16 = new IntentFilter();
        int r17 = AntiDeteriorationBroadcastReceiver.b;
        r16.addAction("android.intent.action.ANTI_DETERIORATION");
        Context r18 = TTLiveSDKContext.getHostService().b().context();
        if (r18 == null) goto L31;
        if (Build.VERSION.SDK_INT < 34) goto L30;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_liveinit_other_LiveOtherLazyInitUnit_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r18, new AntiDeteriorationBroadcastReceiver(), r16, 2);
        goto L31
    L30:
        INVOKEVIRTUAL_com_bytedance_android_livesdk_liveinit_other_LiveOtherLazyInitUnit_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r18, new AntiDeteriorationBroadcastReceiver(), r16, 4);
    L31:
        IMiddleHostService r19 = TTMiddlewareLiveSDK.sHostService;
        if ((r19 instanceof IHostService) == true) goto L34;
        r19 = null;
    L34:
        IHostService r20 = (IHostService) r19;
        if (r20 != null) goto L37;
    L41:
        ALogger.e("TTLiveSDKContext", "PrivacyFacade init failed; host context is null");
    L42:
        initHookForAlphaVideoSurfaceView();
        initNewVideoInnerFloatManager();
        LiveRoomDurationRetrieveLogger.f();
        int r21 = com.bytedance.android.livesdk.liveinit.a.a;
        f r22 = TTLiveSDKContext.getHostService();
        if (r22 == null) goto L52;
        String r23 = r22.b().getChannel();
        if (LocalTestManager.b(new Class[]{wy.a.class}) == false) goto L48;
    L51:
        r4 = r3;
        goto L52
    L48:
        if (Intrinsics.areEqual("test", r23) == true) goto L51;
        r3 = false;
    L52:
        if (r4 == true) goto L54;
        return;
    L54:
        monitor-enter(a5.class);
    L61:
        th = move-exception;
        throw th;
    L56:
        if (a5.a != null) goto L58;
        a5.a = new a5();     // Catch: Throwable -> L61
    L58:
        a5 r24 = a5.a;     // Catch: Throwable -> L61
        monitor-exit(a5.class);
        r24.getClass();
        a5.a();
        return;
    L37:
        if (r20.appContext() == null) goto L41;
        if (r20.appContext().context() == null) goto L41;
        q60.a.a(r20.appContext().context(), LiveInitSettingKeys.get_LIVE_AUDIO_AND_VIDEO_PRIVACY_CONFIG());
        goto L42
    }

    public InitThread lazyInitThread() {
        return getInitThreadWithConfig(LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitThreadConfig().getInitOtherLazy());
    }

    public long postDelayTime() {
        return LiveInitAssistant.INSTANCE.getInitConfigInner().getUnitPostDelayConfig().getCommonDelayTime();
    }

    private final void initNewVideoInnerFloatManager() {
        ILiveService r0 = TTLiveSDKContext.getLiveService();
        if (r0 == null) goto L5;
        r0.getVideoFloatManager();
    L5:
        q r1 = VideoFloatWindowManager.f;
        k.l(IFloatWindowManager.class, VideoFloatWindowManager.b.a());
    }

    private LiveOtherLazyInitUnit() {
    }

    private final void reportAnchorApplicationExitInfo() {
        Boolean r0 = NewBroadcastMonitor.a;
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveOtherLazyInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.ENTER_ROOM;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livesdk_liveinit_other_LiveOtherLazyInitUnit_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static final /* synthetic */ void access$reportAnchorApplicationExitInfo(LiveOtherLazyInitUnit r0) {
        r0.reportAnchorApplicationExitInfo();
    }

    public static final /* synthetic */ void access$reportDeviceTotalMemory(LiveOtherLazyInitUnit r0) {
        r0.reportDeviceTotalMemory();
    }

    private final void reportWatchingTag(IHostApp r2) {
        r2.registerLiveLifeCycleListener(new d(r2));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_android_livesdk_liveinit_other_LiveOtherLazyInitUnit_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10, int r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, r11);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, r11, null, null, 3, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10, r11);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10, r11);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, r11);
    L35:
        return r8.registerReceiver(r9, r10, r11);
    }
}
