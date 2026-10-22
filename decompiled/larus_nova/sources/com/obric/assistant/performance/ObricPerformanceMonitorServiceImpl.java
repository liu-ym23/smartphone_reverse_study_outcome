package com.obric.assistant.performance;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.network.util.ScreenStateManager;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricPerformanceMonitorConfig;
import com.obric.assistant.t1;
import com.obric.systemopt.SysPowerKit;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/performance/ObricPerformanceMonitorServiceImpl;", "Lcom/obric/assistant/performance/IObricPerformanceMonitorService;", "<init>", "()V", "dozeReceiver", "Lcom/obric/assistant/performance/ObricPerformanceMonitorServiceImpl$DozeReceiver;", "handleDeepCheckJob", "Lkotlinx/coroutines/Job;", "handleLightCheckJob", "doPerformanceOptJob", "dozeMode", "Lcom/obric/assistant/performance/DozeMode;", "monitorConfig", "Lcom/obric/assistant/ObricPerformanceMonitorConfig;", "init", "", "handleDozeChange", "updateDozeMode", "triggerDeepDozeCheck", "doPerformanceCheck", "triggerLightDozeCheck", "registerDozeReceiver", "DozeReceiver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPerformanceMonitorServiceImpl implements IObricPerformanceMonitorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DozeReceiver f391005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f391006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f391007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f391008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile DozeMode f391009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObricPerformanceMonitorConfig f391010g;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/performance/ObricPerformanceMonitorServiceImpl$DozeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/obric/assistant/performance/ObricPerformanceMonitorServiceImpl;)V", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DozeReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricPerformanceMonitorServiceImpl f391011a;

        public DozeReceiver(ObricPerformanceMonitorServiceImpl r100) {
            this.f391011a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            FLogger.f375446a.i("ObricPerformanceMonitor", "onReceive: intent = " + r101);
            if (r101 == null) goto L5;
            String r102 = r101.getAction();
        L6:
            if (r102 == null) goto L20;
            int r103 = r102.hashCode();
            if (r103 == 498807504) goto L17;
            if (r103 == 870701415) goto L13;
            return;
        L13:
            if (r102.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") == false) goto L24;
            ObricPerformanceMonitorServiceImpl.c(this.f391011a);
            return;
        L24:
            return;
        L17:
            if (r102.equals("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED") == false) goto L22;
            ObricPerformanceMonitorServiceImpl.c(this.f391011a);
            return;
        L22:
            return;
        L20:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f391012a = null;

        static {
            int[] r100 = new int[DozeMode.values().length];
            r100[DozeMode.DOZE_DEEP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DozeMode.DOZE_LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f391012a = r100;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1", f = "ObricPerformanceMonitorServiceImpl.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricPerformanceMonitorServiceImpl this$0;

        /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$a */
        public static final class a implements kna.d {
            public a() {
            }

            @Override // kna.d
            public final void a(JSONObject r100) {
                Intrinsics.checkNotNullParameter("obric_performance_power", "eventName");
                Intrinsics.checkNotNullParameter(r100, "data");
                o.f365780a.reportEvent("obric_performance_power", r100);
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$b */
        public static final class b implements kna.c {

            /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$b$a */
            public static final class a implements f09.a.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Function1<Boolean, Unit> f391013a;

                @Override // f09.a.b
                public final void onAllActivityDestroyed() {
                }

                @Override // f09.a.b
                public final void onAppBackground() {
                    this.f391013a.invoke(Boolean.TRUE);
                }

                @Override // f09.a.b
                public final void onAppForeground() {
                    this.f391013a.invoke(Boolean.FALSE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public a(Function1<? super Boolean, Unit> r100) {
                    this.f391013a = r100;
                }
            }

            public b() {
            }

            @Override // kna.c
            public final boolean a() {
                return AppHost.f326268a.a().isAppBackground();
            }

            @Override // kna.c
            public final String b() {
                Activity r100 = AppHost.f326268a.a().getCurrentActivity();
                if (r100 != null) goto L7;
                return null;
            L7:
                return r100.getClass().getName();
            }

            @Override // kna.c
            public final void c(Function1<? super Boolean, Unit> r100) {
                Intrinsics.checkNotNullParameter(r100, "listener");
                AppHost.f326268a.a().j(new a(r100));
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$c */
        public static final class c implements kna.e {

            /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$c$a */
            public static final class a implements ScreenStateManager.b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Function1<Boolean, Unit> f391014a;

                @Override // com.larus.network.util.ScreenStateManager.b
                public final void onScreenOff() {
                    this.f391014a.invoke(Boolean.FALSE);
                }

                @Override // com.larus.network.util.ScreenStateManager.b
                public final void onScreenOn() {
                    this.f391014a.invoke(Boolean.TRUE);
                }

                @Override // com.larus.network.util.ScreenStateManager.b
                public final void onUserPresent() {
                    this.f391014a.invoke(Boolean.TRUE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public a(Function1<? super Boolean, Unit> r100) {
                    this.f391014a = r100;
                }
            }

            public c() {
            }

            @Override // kna.e
            public final boolean a() {
                PowerManager r100 = (PowerManager) ContextCompat.getSystemService(AppHost.f326268a.getApplication(), PowerManager.class);
                if (r100 != null) goto L7;
                return true;
            L7:
                return r100.isInteractive();
            }

            @Override // kna.e
            public final void b(Function1<? super Boolean, Unit> r100) {
                Intrinsics.checkNotNullParameter(r100, "listener");
                ScreenStateManager r101 = ScreenStateManager.f360254a;
                ScreenStateManager.a(new a(r100));
            }
        }

        public AnonymousClass1(ObricPerformanceMonitorServiceImpl r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L9;
            if (r101 != 1) goto L8;
            ResultKt.throwOnFailure(r110);     // Catch: Exception -> L30
        L28:
            ObricPerformanceMonitorServiceImpl.d(this.this$0);     // Catch: Exception -> L30
        L33:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
            ObricPerformanceMonitorServiceImpl r111 = this.this$0;     // Catch: Exception -> L30
            t1 r102 = t1.f393353a;     // Catch: Exception -> L30
            r111.f391010g = r102.getObricPerformanceMonitorConfig();     // Catch: Exception -> L30
            FLogger.f375446a.i("ObricPerformanceMonitor", "init, monitorConfig = " + this.this$0.f391010g);     // Catch: Exception -> L30
            Lazy r112 = f.f391037a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r113 = this.this$0.f391010g;     // Catch: Exception -> L30
            if (r113 != null) goto L13;
            r113 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L13:
            f.a(r113);     // Catch: Exception -> L30
            Lazy r114 = com.obric.assistant.performance.c.f391032a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r115 = this.this$0.f391010g;     // Catch: Exception -> L30
            if (r115 != null) goto L16;
            r115 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L16:
            com.obric.assistant.performance.c.a(r115);     // Catch: Exception -> L30
            boolean r116 = h.f391043a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r117 = this.this$0.f391010g;     // Catch: Exception -> L30
            if (r117 != null) goto L19;
            r117 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L19:
            h.a(r117);     // Catch: Exception -> L30
            Lazy r118 = ObricSettingsChangeMonitor.f391015a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r119 = this.this$0.f391010g;     // Catch: Exception -> L30
            if (r119 != null) goto L22;
            r119 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L22:
            ObricSettingsChangeMonitor.c(r119);     // Catch: Exception -> L30
            Lazy r120 = l.f391046a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r121 = this.this$0.f391010g;     // Catch: Exception -> L30
            if (r121 != null) goto L25;
            r121 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L25:
            Intrinsics.checkNotNullParameter(r121, "config");     // Catch: Exception -> L30
            SysPowerKit r122 = SysPowerKit.getInstance();     // Catch: Exception -> L30
            AppHost.Companion r103 = AppHost.f326268a;     // Catch: Exception -> L30
            r122.addPowerListener(r103.getApplication(), 1, (SysPowerKit.c) l.f391046a.getValue());     // Catch: Exception -> L30
            b r123 = new b();     // Catch: Exception -> L30
            c r104 = new c();     // Catch: Exception -> L30
            Lazy r105 = fna.g.f478034a;     // Catch: Exception -> L30
            fna.g.c(new kna.f(r103.getApplication().getApplicationContext(), r102.getObricPerformancePowerMonitorSettingsConfig(), new a(), r123, r104));     // Catch: Exception -> L30
            AtomicBoolean r106 = lna.h.f510047a;     // Catch: Exception -> L30
            lna.h.b(r102.getObricPerformanceCPUExceptionDiagnosisSettingsConfig(), r123, r104);     // Catch: Exception -> L30
            this.label = 1;     // Catch: Exception -> L30
            if (DelayKt.delay(1000, this) != r100) goto L28;
            return r100;
        L30:
            e = move-exception;
            FLogger.f375446a.e("ObricPerformanceMonitor", "init, error = " + e);
            goto L33
        }
    }

    public static DozeMode e() {
        Lazy r100 = c.f391032a;
        int r101 = Build.VERSION.SDK_INT;     // Catch: Exception -> L25
        boolean r102 = false;
        if (r101 < 23) goto L14;
        PowerManager r103 = (PowerManager) c.f391033b.getValue();     // Catch: Exception -> L25
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L14;
        DozeMode r105 = DozeMode.DOZE_DEEP;     // Catch: Exception -> L25
    L23:
        c.f391034c = r105;     // Catch: Exception -> L25
        FLogger.f375446a.i("ObricPerformanceMonitor", "updateDozeMode: dozeMode = " + c.f391034c);     // Catch: Exception -> L25
    L28:
        return c.f391034c;
    L8:
        if (r103.isDeviceIdleMode() != true) goto L10;
        r104 = true;
    L14:
        if (r101 < 33) goto L22;
        PowerManager r106 = (PowerManager) c.f391033b.getValue();     // Catch: Exception -> L25
        if (r106 != null) goto L18;
    L20:
        if (r102 == false) goto L22;
        r105 = DozeMode.DOZE_LIGHT;     // Catch: Exception -> L25
        goto L23
    L18:
        if (r106.isDeviceLightIdleMode() != true) goto L20;
        r102 = true;
    L22:
        r105 = DozeMode.DOZE_NONE;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        FLogger.f375446a.e("ObricPerformanceMonitor", "getDozeMode: e = " + e);
        goto L28
    }

    public ObricPerformanceMonitorServiceImpl() {
        this.f391005b = new DozeReceiver(this);
        this.f391009f = DozeMode.DOZE_NONE;
    }

    @Override // com.obric.assistant.performance.IObricPerformanceMonitorService
    public final void init() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final void b(ObricPerformanceMonitorServiceImpl r110) {
        r110.getClass();
        if (c.b() == false) goto L6;
        FLogger.f375446a.i("ObricPerformanceMonitor", "assistant active, skip performance check");
        return;
    L6:
        if (f.f391038b == true) goto L51;
        FLogger.f375446a.i("ObricPerformanceMonitor", "checkJvmMemoryLeak: monitor not enabled");
    L16:
        boolean r100 = false;
    L17:
        Lazy r101 = f.f391037a;
        JvmMemoryinfo r102 = f.f391041e;
        if (f.f391038b == true) goto L47;
        FLogger.f375446a.i("ObricPerformanceMonitor", "checkPssMemoryLeak: monitor not enabled");
    L20:
        boolean r111 = false;
    L34:
        Lazy r103 = f.f391037a;
        PssMemoryinfo r104 = f.f391042f;
        if (r100 == true) goto L37;
        if (r111 == true) goto L37;
        return;
    L37:
        FLogger.f375446a.i("ObricPerformanceMonitor", "memory leak, trigger performance optimization, jvmMemory=" + r102 + ", pssMemory=" + r104);
        Job r105 = r110.f391008e;
        if (r105 != null) goto L40;
    L45:
        r110.f391008e = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricPerformanceMonitorServiceImpl$doPerformanceCheck$2(r110, r100, r111, r102, r104, null), 3, null);
        return;
    L40:
        if (r105.isActive() == true) goto L43;
        r105 = null;
    L43:
        if (r105 == null) goto L45;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
        goto L45
    L47:
        int[] r106 = new int[1];     // Catch: Exception -> L31
        r106[0] = Process.myPid();     // Catch: Exception -> L29
        int r107 = ((ActivityManager) f.f391037a.getValue()).getProcessMemoryInfo(r106)[0].getTotalPss() / 1024;     // Catch: Exception -> L29
        int r108 = f.f391040d;     // Catch: Exception -> L29
        if (r107 <= r108) goto L26;
        boolean r109 = true;
    L27:
        f.f391042f = new PssMemoryinfo(Integer.valueOf(r108), Integer.valueOf(r107));     // Catch: Exception -> L29
        FLogger.f375446a.i("ObricPerformanceMonitor", "checkPssMemoryLeak, pssMemoryLeak=" + r109 + ", totalPss=" + r107 + ", pssLeakThreshold=" + f.f391040d);     // Catch: Exception -> L29
        r111 = r109;
        goto L34
    L26:
        r109 = false;
    L29:
        e = e;
    L33:
        FLogger.f375446a.e("ObricPerformanceMonitor", "checkPssMemoryLeak, e=" + e);
    L31:
        e = e;
        goto L33
    L51:
        long r112 = Runtime.getRuntime().totalMemory();     // Catch: Exception -> L14
        long r113 = r112 - Runtime.getRuntime().freeMemory();     // Catch: Exception -> L14
        long r114 = Runtime.getRuntime().maxMemory();     // Catch: Exception -> L14
        float r115 = r113;
        float r116 = f.f391039c;     // Catch: Exception -> L14
        if (r115 <= (r114 * r116)) goto L11;
        boolean r117 = true;
    L12:
        f.f391041e = new JvmMemoryinfo(Float.valueOf(r116), Long.valueOf(r114), Long.valueOf(r113), Long.valueOf(r112));     // Catch: Exception -> L14
        FLogger.f375446a.i("ObricPerformanceMonitor", "checkJvmMemoryLeak, jvmMemoryLeak=" + r117 + ", jvmUsedMemory=" + r113 + ", jvmTotalMemory=" + r112 + ", jvmMaxMemory=" + r114 + ", jvmLeakThreshold=" + f.f391039c);     // Catch: Exception -> L14
        r100 = r117;
        goto L17
    L11:
        r117 = false;
    L14:
        e = move-exception;
        FLogger.f375446a.e("ObricPerformanceMonitor", "checkJvmMemoryLeak, e=" + e);
        goto L16
    }

    public static final void c(ObricPerformanceMonitorServiceImpl r110) {
        r110.getClass();
        DozeMode r100 = e();
        if (r100 != r110.f391009f) goto L5;
        FLogger.f375446a.i("ObricPerformanceMonitor", "handleDozeChange, dozeMode not changed, dozeMode = " + r110.f391009f);
        return;
    L5:
        r110.f391009f = r100;
        FLogger r101 = FLogger.f375446a;
        r101.i("ObricPerformanceMonitor", "handleDozeChange, dozeMode changed, dozeMode = " + r110.f391009f);
        int r102 = a.f391012a[r110.f391009f.ordinal()];
        if (r102 != 1) goto L8;
        r101.i("ObricPerformanceMonitor", "triggerDeepDozeCheck, dozeMode = " + r110.f391009f);
        Job r103 = r110.f391006c;
        if (r103 != null) goto L45;
    L50:
        r110.f391006c = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricPerformanceMonitorServiceImpl$triggerDeepDozeCheck$2(r110, null), 3, null);
        return;
    L45:
        if (r103.isActive() == true) goto L48;
        r103 = null;
    L48:
        if (r103 == null) goto L50;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
        goto L50
    L8:
        if (r102 == 2) goto L25;
        Job r104 = r110.f391006c;
        if (r104 != null) goto L12;
    L17:
        Job r111 = r110.f391007d;
        if (r111 != null) goto L20;
        return;
    L20:
        if (r111.isActive() == true) goto L23;
        r111 = null;
    L23:
        if (r111 == null) goto L54;
        Job.DefaultImpls.cancel$default(r111, null, 1, null);
        return;
    L54:
        return;
    L12:
        if (r104.isActive() == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L17;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
        goto L17
    L25:
        Job r105 = r110.f391006c;
        if (r105 != null) goto L28;
    L33:
        r101.i("ObricPerformanceMonitor", "triggerLightDozeCheck, dozeMode = " + r110.f391009f);
        Job r106 = r110.f391007d;
        if (r106 != null) goto L36;
    L41:
        r110.f391007d = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricPerformanceMonitorServiceImpl$triggerLightDozeCheck$2(r110, null), 3, null);
        return;
    L36:
        if (r106.isActive() == true) goto L39;
        r106 = null;
    L39:
        if (r106 == null) goto L41;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
        goto L41
    L28:
        if (r105.isActive() == true) goto L31;
        r105 = null;
    L31:
        if (r105 == null) goto L33;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
        goto L33
    }

    public static final void d(ObricPerformanceMonitorServiceImpl r100) {
        r100.getClass();
        IntentFilter r101 = new IntentFilter();     // Catch: Exception -> L11
        int r102 = Build.VERSION.SDK_INT;     // Catch: Exception -> L11
        if (r102 < 23) goto L7;
        r101.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");     // Catch: Exception -> L11
    L7:
        if (r102 < 33) goto L9;
        r101.addAction("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED");     // Catch: Exception -> L11
    L9:
        a(AppHost.f326268a.getApplication(), r100.f391005b, r101);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        FLogger.f375446a.e("ObricPerformanceMonitor", "registerDozeReceiver, e=" + e);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Application r100, DozeReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
