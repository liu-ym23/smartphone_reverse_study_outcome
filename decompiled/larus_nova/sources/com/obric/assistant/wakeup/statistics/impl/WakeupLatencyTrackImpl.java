package com.obric.assistant.wakeup.statistics.impl;

import android.os.SystemClock;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.common.applog.EventVerify;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0002J8\u0010#\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0002J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/impl/WakeupLatencyTrackImpl;", "Lcom/obric/assistant/spi/wakeup/IWakeupLatencyTrackService;", "<init>", "()V", "scene", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", InteractConst.WAKEUP_SESSION_TYPE, "tIpc", "Ljava/util/concurrent/atomic/AtomicLong;", "tMain", "tLaunch", "activateToRecordTrace", "Lcom/obric/assistant/wakeup/statistics/impl/WakeupLatencyTrackImpl$ActivateToRecordTrace;", "markActivationStart", "", "activationStartUptimeMillis", "", "launchMethod", "mainProcessReady", "", "markIpcStart", InteractConst.WAKEUP_SESSION_NAME, "ipcStartTime", "markMainProcessReceived", "timestamp", "markAssistantLaunchStart", "markRecordStart", "reportActivateToRecord", "recordStartUptimeMillis", "resetInternal", "duration", "start", "end", "report", "ipcToMain", "mainToLaunch", "launchToRecord", "total", "reportWakeupStart", "reportAttemptDropped", "prevScene", "prevSession", "stage", "Companion", "ActivateToRecordTrace", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupLatencyTrackImpl implements IWakeupLatencyTrackService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<String> f394478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<String> f394479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f394480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f394481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f394482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<a> f394483f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f394484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f394485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f394486c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f394484a == r101.f394484a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f394485b, r101.f394485b) == true) goto L15;
            return false;
        L15:
            if (this.f394486c == r101.f394486c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f394484a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f394485b.hashCode()) * 31;
            if (this.f394486c == false) goto L5;
            int r102 = 1231;
        L7:
            return r101 + r102;
        L5:
            r102 = 1237;
            goto L7
        }

        public final String toString() {
            return "ActivateToRecordTrace(activationStartUptimeMillis=" + this.f394484a + ", launchMethod=" + this.f394485b + ", mainProcessReady=" + this.f394486c + ')';
        }

        public a(long r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "launchMethod");
            this.f394484a = r100;
            this.f394485b = r101;
            this.f394486c = r102;
        }
    }

    public static final class b {
    }

    static {
    }

    public static long f(long r100, long r101) {
        if (r100 > 0) goto L5;
    L9:
        return -1;
    L5:
        if (r101 <= 0) goto L9;
        long r102 = r101 - r100;
        if (r102 < 0) goto L9;
        return r102;
    }

    public WakeupLatencyTrackImpl() {
        this.f394478a = new AtomicReference("");
        this.f394479b = new AtomicReference("");
        this.f394480c = new AtomicLong(0);
        this.f394481d = new AtomicLong(0);
        this.f394482e = new AtomicLong(0);
        this.f394483f = new AtomicReference(null);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void b(long r100) {
        if (this.f394480c.get() > 0) goto L5;
        return;
    L5:
        this.f394481d.compareAndSet(0, r100);
    }

    /* JADX WARN: Failed to calculate best type for var: r7v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v0 ??, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r7v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v0 ??, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v0 java.util.concurrent.atomic.AtomicLong, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void c(long r210) {
        long r100 = SystemClock.uptimeMillis();
        a r110 = this.f394483f.getAndSet(null);
        if (r110 == null) goto L13;
        long r101 = f(r110.f394484a, r100);
        long r111 = -1;
        if (r101 != (-1)) goto L9;
        FLogger.f375446a.w("WakeupLatencyTrackImpl", "skip activate_to_record: start=" + r110.f394484a + ", end=" + r100);
        goto L13
    L9:
        long r102 = iba.a.a(AppHost.f326268a.getApplication());
        if (r102 <= 0) goto L12;
        r111 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r102, 0);
    L12:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new WakeupLatencyTrackImpl$reportActivateToRecord$1(r101, r110, r111, null), 3, null);
    L13:
        long r103 = this.f394480c.getAndSet(r11);
        if (r103 > r11) goto L16;
        return;
    L16:
        long r104 = this.f394481d.getAndSet(r11);
        long r105 = this.f394482e.getAndSet(0);
        long r112 = f(r103, r104);
        long r106 = f(r104, r105);
        long r107 = f(r105, r210);
        long r108 = f(r103, r210);
        FLogger.f375446a.i("WakeupLatencyTrackImpl", "markRecordStart t3=" + r210 + "; durations ipc->main=" + r112 + " main->launch=" + r106 + " launch->record=" + r107 + " total=" + r108 + ' ');
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new WakeupLatencyTrackImpl$report$1(this.f394478a.getAndSet(""), this.f394479b.getAndSet(""), r112, r106, r107, r108, null), 3, null);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void e(long r100) {
        if (this.f394480c.get() > 0) goto L5;
        return;
    L5:
        this.f394482e.compareAndSet(0, r100);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void a(long r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "launchMethod");
        if (r100 > 0) goto L5;
        return;
    L5:
        this.f394483f.set(new a(r100, r101, r102));
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void d(String r210, String r211, long r212) {
        Intrinsics.checkNotNullParameter(r210, "scene");
        Intrinsics.checkNotNullParameter(r211, InteractConst.WAKEUP_SESSION_NAME);
        if (r212 > 0) goto L7;
        FLogger.f375446a.w("WakeupLatencyTrackImpl", "markIpcStart got invalid ipcStartTime=" + r212 + ", skip sample");
        this.f394480c.set(0);
        this.f394481d.set(0);
        this.f394482e.set(0);
        this.f394478a.set("");
        this.f394479b.set("");
        return;
    L7:
        if (this.f394480c.get() <= 0) goto L12;
        if (Intrinsics.areEqual(this.f394478a.get(), r210) == false) goto L12;
        return;
    L12:
        if (this.f394480c.get() <= 0) goto L21;
        String r100 = this.f394478a.get();
        String r101 = this.f394479b.get();
        if (this.f394482e.get() <= 0) goto L17;
        String r110 = "record_pending";
    L20:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new WakeupLatencyTrackImpl$reportAttemptDropped$1(r100, r101, r110, null), 3, null);
        goto L21
    L17:
        if (this.f394481d.get() <= 0) goto L19;
        r110 = EventVerify.TYPE_LAUNCH;
        goto L20
    L19:
        r110 = PullConfiguration.PROCESS_NAME_MAIN;
    L21:
        this.f394478a.set(r210);
        this.f394479b.set(r211);
        this.f394480c.set(r212);
        this.f394481d.set(0);
        this.f394482e.set(0);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new WakeupLatencyTrackImpl$reportWakeupStart$1(r210, r211, null), 3, null);
    }
}
