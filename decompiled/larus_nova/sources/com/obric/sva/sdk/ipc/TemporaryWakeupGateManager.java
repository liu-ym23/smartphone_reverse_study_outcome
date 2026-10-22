package com.obric.sva.sdk.ipc;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.EnumMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003&'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000fJ\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J&\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\nJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager;", "", "<init>", "()V", "TAG", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "states", "Ljava/util/EnumMap;", "Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$Gate;", "Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$State;", "ownerToken", "Landroid/os/IBinder;", "ownerGeneration", "", "ownerDeath", "Landroid/os/IBinder$DeathRecipient;", "wakewordBusyCallback", "Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$WakewordBusyFailOpenCallback;", "setWakewordBusyFailOpenCallback", "", "callback", "onOwnerTokenAvailable", "token", "generation", "onOwnerBinderDied", "updateGate", "gate", "enabled", "", "reason", "sweepIfExpired", "sweepGateIfExpired", "failOpenAll", "failOpen", "applyGateToGlobals", "isEnabled", "Gate", "WakewordBusyFailOpenCallback", "State", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemporaryWakeupGateManager {
    public static final TemporaryWakeupGateManager INSTANCE = null;
    private static final String TAG = "TemporaryWakeupGateManager";
    private static final ReentrantLock lock = null;
    private static volatile IBinder.DeathRecipient ownerDeath;
    private static volatile long ownerGeneration;
    private static volatile IBinder ownerToken;
    private static final EnumMap<Gate, State> states = null;
    private static volatile WakewordBusyFailOpenCallback wakewordBusyCallback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$Gate;", "", "ttlMs", "", "<init>", "(Ljava/lang/String;IJ)V", "getTtlMs", "()J", "DORA_SUPPRESS", "ENROLL_IGNORE", "WAKEWORD_SOURCE_BUSY", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Gate extends Enum<Gate> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Gate[] $VALUES = null;
        public static final Gate DORA_SUPPRESS = null;
        public static final Gate ENROLL_IGNORE = null;
        public static final Gate WAKEWORD_SOURCE_BUSY = null;
        private final long ttlMs;

        private static final /* synthetic */ Gate[] $values() {
            return new Gate[]{DORA_SUPPRESS, ENROLL_IGNORE, WAKEWORD_SOURCE_BUSY};
        }

        public static EnumEntries<Gate> getEntries() {
            return $ENTRIES;
        }

        static {
            DORA_SUPPRESS = new Gate("DORA_SUPPRESS", 0, 60000);
            ENROLL_IGNORE = new Gate("ENROLL_IGNORE", 1, 30000);
            WAKEWORD_SOURCE_BUSY = new Gate("WAKEWORD_SOURCE_BUSY", 2, 15000);
            Gate[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Gate[] values() {
            return (Gate[]) $VALUES.clone();
        }

        public final long getTtlMs() {
            return this.ttlMs;
        }

        public static Gate valueOf(String r100) {
            return (Gate) r27.a.a(Gate.class, r100);
        }

        private Gate(String r100, int r101, long r102) {
            super(r100, r101);
            this.ttlMs = r102;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$State;", "", "enabled", "", "setAtElapsedMs", "", "generation", "reason", "", "<init>", "(ZJJLjava/lang/String;)V", "getEnabled", "()Z", "getSetAtElapsedMs", "()J", "getGeneration", "getReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class State {
        private final boolean enabled;
        private final long generation;
        private final String reason;
        private final long setAtElapsedMs;

        public static /* synthetic */ State copy$default(State r100, boolean r101, long r102, long r103, String r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.enabled;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.setAtElapsedMs;
        L8:
            long r104 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.generation;
        L11:
            long r105 = r103;
            if ((r111 & 8) == 0) goto L14;
            r110 = r100.reason;
        L14:
            boolean r106 = r101;
            return r100.copy(r106, r104, r105, r110);
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final long component2() {
            return this.setAtElapsedMs;
        }

        public final long component3() {
            return this.generation;
        }

        public final String component4() {
            return this.reason;
        }

        public final State copy(boolean r100, long r110, long r111, String r112) {
            Intrinsics.checkNotNullParameter(r112, "reason");
            return new State(r100, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof State) == true) goto L8;
            return false;
        L8:
            State r101 = (State) r100;
            if (this.enabled == r101.enabled) goto L12;
            return false;
        L12:
            if (this.setAtElapsedMs == r101.setAtElapsedMs) goto L15;
            return false;
        L15:
            if (this.generation == r101.generation) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            if (this.enabled == false) goto L5;
            int r100 = 1231;
        L6:
            long r101 = this.setAtElapsedMs;
            int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.generation;
            return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.reason.hashCode();
        L5:
            r100 = 1237;
            goto L6
        }

        public String toString() {
            return "State(enabled=" + this.enabled + ", setAtElapsedMs=" + this.setAtElapsedMs + ", generation=" + this.generation + ", reason=" + this.reason + ')';
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final long getGeneration() {
            return this.generation;
        }

        public final String getReason() {
            return this.reason;
        }

        public final long getSetAtElapsedMs() {
            return this.setAtElapsedMs;
        }

        public State(boolean r100, long r101, long r102, String r103) {
            Intrinsics.checkNotNullParameter(r103, "reason");
            this.enabled = r100;
            this.setAtElapsedMs = r101;
            this.generation = r102;
            this.reason = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$WakewordBusyFailOpenCallback;", "", "onWakewordBusyFailOpen", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface WakewordBusyFailOpenCallback {
        void onWakewordBusyFailOpen();
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Gate.values().length];
            r100[Gate.DORA_SUPPRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Gate.ENROLL_IGNORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Gate.WAKEWORD_SOURCE_BUSY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private TemporaryWakeupGateManager() {
    }

    static {
        INSTANCE = new TemporaryWakeupGateManager();
        lock = new ReentrantLock();
        states = new EnumMap(Gate.class);
    }

    public final boolean sweepIfExpired() {
        IBinder r100 = ownerToken;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isBinderAlive() != true) goto L7;
    L8:
        if (r101 == false) goto L10;
        return false;
    L10:
        LogUtils.w(TAG, "sweepIfExpired owner binder not alive, fail-open all gates", new Object[0]);
        return failOpenAll("sweep_binder_dead");
    L7:
        r101 = false;
        goto L8
    }

    private final boolean failOpenAll(String r100) {
        Gate[] r101 = Gate.values();
        int r102 = r101.length;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 >= r102) goto L10;
        Gate r105 = r101[r103];
        if (INSTANCE.failOpen(r105, r100) == false) goto L9;
        if (r105 != Gate.WAKEWORD_SOURCE_BUSY) goto L9;
        r104 = true;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        return r104;
    }

    public final boolean isEnabled(Gate r100) {
        Intrinsics.checkNotNullParameter(r100, "gate");
        ReentrantLock r101 = lock;
        r101.lock();
        State r102 = states.get(r100);     // Catch: Throwable -> L11
        boolean r103 = false;
        if (r102 == null) goto L9;
        if (r102.getEnabled() != true) goto L9;
        r103 = true;
    L9:
        r101.unlock();
        return r103;
    L11:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void setWakewordBusyFailOpenCallback(WakewordBusyFailOpenCallback r100) {
        wakewordBusyCallback = r100;
    }

    public final boolean sweepGateIfExpired(Gate r100) {
        Intrinsics.checkNotNullParameter(r100, "gate");
        IBinder r101 = ownerToken;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isBinderAlive() != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        return false;
    L10:
        ReentrantLock r103 = lock;
        r103.lock();
        State r104 = states.get(r100);     // Catch: Throwable -> L34
        r103.unlock();
        if (r104 != null) goto L15;
    L33:
        return false;
    L15:
        if (r104.getEnabled() == false) goto L33;
        if ((SystemClock.elapsedRealtime() - r104.getSetAtElapsedMs()) > r100.getTtlMs()) goto L20;
        return false;
    L20:
        boolean r105 = failOpen(r100, "ttl_expired");
        if (r105 == true) goto L23;
    L32:
        return r105;
    L23:
        if (r100 != Gate.WAKEWORD_SOURCE_BUSY) goto L32;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L30
        WakewordBusyFailOpenCallback r107 = wakewordBusyCallback;     // Catch: Throwable -> L30
        if (r107 == null) goto L27;
        r107.onWakewordBusyFailOpen();     // Catch: Throwable -> L30
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L30
        goto L32
    L27:
        r108 = null;
    L30:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L34:
        th = move-exception;
        r103.unlock();
        throw th;
    L7:
        r102 = false;
        goto L8
    }

    private final void applyGateToGlobals(Gate r100, boolean r101) {
        int r102 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r102 != 1) goto L5;
        Global.sWakeupSupress = r101;
        return;
    L5:
        if (r102 != 2) goto L7;
        Global.sEnrollIgnore = r101;
        return;
    L7:
        if (r102 != 3) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final boolean failOpen(Gate r110, String r111) {
        ReentrantLock r100 = lock;
        r100.lock();
        EnumMap<Gate, State> r101 = states;     // Catch: Throwable -> L15
        State r102 = r101.get(r110);     // Catch: Throwable -> L15
        if (r102 == null) goto L8;
        boolean r103 = true;
        if (r102.getEnabled() != true) goto L8;
    L9:
        if (r103 == false) goto L11;
        r101.put(r110, new State(false, SystemClock.elapsedRealtime(), r102.getGeneration(), "fail_open_" + r111));     // Catch: Throwable -> L15
        INSTANCE.applyGateToGlobals(r110, false);     // Catch: Throwable -> L15
    L11:
        r100.unlock();
        if (r103 == false) goto L14;
        TrackerTelemetry.INSTANCE.onGateFailOpen(r110.name(), r111);
    L14:
        return r103;
    L8:
        r103 = false;
    L15:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    private final void onOwnerBinderDied(IBinder r100, long r101) {
        ReentrantLock r102 = lock;
        r102.lock();
    L25:
        th = move-exception;
        r102.unlock();
        throw th;
    L4:
        if (ownerToken != r100) goto L9;
        if (ownerGeneration != r101) goto L9;
        boolean r103 = true;
    L10:
        r102.unlock();
        if (r103 == true) goto L14;
        LogUtils.i(TAG, "owner binder died ignored generation=" + r101, new Object[0]);
        return;
    L14:
        LogUtils.w(TAG, "owner binder died generation=" + r101 + ", fail-open all gates", new Object[0]);
        if (failOpenAll("binder_died") == false) goto L32;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L22
        WakewordBusyFailOpenCallback r105 = wakewordBusyCallback;     // Catch: Throwable -> L22
        if (r105 == null) goto L19;
        r105.onWakewordBusyFailOpen();     // Catch: Throwable -> L22
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L22
        return;
    L19:
        r106 = null;
    L22:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L32:
        return;
    L9:
        r103 = false;
        goto L10
    }

    public final void onOwnerTokenAvailable(final IBinder r100, final long r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        ReentrantLock r102 = lock;
        r102.lock();
        IBinder r103 = ownerToken;     // Catch: Throwable -> L27
        if (r103 != r100) goto L7;
        r102.unlock();
        return;
    L7:
        IBinder.DeathRecipient r104 = ownerDeath;     // Catch: Throwable -> L27
        if (r103 == null) goto L15;
        if (r104 == null) goto L15;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L13
        Result.m9449constructorimpl(Boolean.valueOf(r103.unlinkToDeath(r104, 0)));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L27
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
    L15:
        ownerToken = r100;     // Catch: Throwable -> L27
        ownerGeneration = r101;     // Catch: Throwable -> L27
        IBinder.DeathRecipient r107 = new TemporaryWakeupGateManager$onOwnerTokenAvailable$1$recipient$1(r100, r101);     // Catch: Throwable -> L27
        ownerDeath = r107;     // Catch: Throwable -> L27
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L18
        r100.linkToDeath(r107, 0);     // Catch: Throwable -> L18
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L27
        if (r110 == null) goto L24;
        LogUtils.e(TAG, "linkToDeath ownerToken failed: " + r110.getMessage(), new Object[0]);     // Catch: Throwable -> L27
    L24:
        LogUtils.i(TAG, "onOwnerTokenAvailable generation=" + r101, new Object[0]);     // Catch: Throwable -> L27
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r102.unlock();
        return;
    L18:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L27
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    public static final /* synthetic */ void access$onOwnerBinderDied(TemporaryWakeupGateManager r100, IBinder r101, long r102) {
        r100.onOwnerBinderDied(r101, r102);
    }

    public final void updateGate(Gate r110, boolean r111, long r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "gate");
        Intrinsics.checkNotNullParameter(r113, "reason");
        ReentrantLock r100 = lock;
        r100.lock();
    L15:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if (ownerGeneration > 0) goto L6;
    L12:
        states.put(r110, new State(r111, SystemClock.elapsedRealtime(), r112, r113));     // Catch: Throwable -> L15
        INSTANCE.applyGateToGlobals(r110, r111);     // Catch: Throwable -> L15
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r100.unlock();
        TrackerTelemetry.INSTANCE.onGateUpdate(r110.name(), r111, r112);
        return;
    L6:
        if (r112 <= 0) goto L12;
        if (r112 == ownerGeneration) goto L12;
        LogUtils.w(TAG, "updateGate ignored generation mismatch gate=" + r110 + " enabled=" + r111 + " generation=" + r112 + " current=" + ownerGeneration, new Object[0]);     // Catch: Throwable -> L15
        r100.unlock();
    }
}
