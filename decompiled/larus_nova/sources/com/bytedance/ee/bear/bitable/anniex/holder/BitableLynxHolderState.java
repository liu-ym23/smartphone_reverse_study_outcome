package com.bytedance.ee.bear.bitable.anniex.holder;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableLynxHolderState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f206718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public State f206719b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/anniex/holder/BitableLynxHolderState$State;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "FAILED", "DESTROYED", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State ACTIVE = null;
        public static final State DESTROYED = null;
        public static final State FAILED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f206720a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f206721b = null;

        public static EnumEntries<State> getEntries() {
            return f206721b;
        }

        static {
            State r100 = new State("ACTIVE", 0);
            ACTIVE = r100;
            State r101 = new State("FAILED", 1);
            FAILED = r101;
            State r102 = new State("DESTROYED", 2);
            DESTROYED = r102;
            State[] r103 = {r100, r101, r102};
            f206720a = r103;
            f206721b = EnumEntriesKt.enumEntries(r103);
        }

        public static State[] values() {
            return (State[]) f206720a.clone();
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean a() {
        Object r100 = this.f206718a;
        monitor-enter(r100);
        if (this.f206719b != State.ACTIVE) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);
        return r101;
    L7:
        r101 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean c() {
        Object r100 = this.f206718a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f206719b == State.ACTIVE) goto L7;
        boolean r101 = false;
    L9:
        monitor-exit(r100);
        return r101;
    L7:
        this.f206719b = State.FAILED;     // Catch: Throwable -> L11
        r101 = true;
        goto L9
    }

    public BitableLynxHolderState() {
        this.f206718a = new Object();
        this.f206719b = State.ACTIVE;
    }

    public final boolean b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "detach");
        Object r101 = this.f206718a;
        monitor-enter(r101);
        State r102 = this.f206719b;     // Catch: Throwable -> L11
        State r103 = State.DESTROYED;     // Catch: Throwable -> L11
        if (r102 != r103) goto L7;
        boolean r104 = false;
    L9:
        monitor-exit(r101);
        return r104;
    L7:
        this.f206719b = r103;     // Catch: Throwable -> L11
        r100.invoke();     // Catch: Throwable -> L11
        r104 = true;
    L11:
        th = move-exception;
        throw th;
    }
}
