package com.obric.assistant.activation.presentation.runtime.session.dispatch;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningChildCoordinator;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<T> f385553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f385554b;

    /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.session.dispatch.a$a, reason: collision with other inner class name */
    public static final class C4591a {
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f385555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f385556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<T> f385557c;

        public b() {
            this(null, false, null, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f385555a, r101.f385555a) == true) goto L12;
            return false;
        L12:
            if (this.f385556b == r101.f385556b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f385557c, r101.f385557c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f385555a.hashCode() * 31;
            if (this.f385556b == false) goto L5;
            int r101 = 1231;
        L7:
            return ((r100 + r101) * 31) + this.f385557c.hashCode();
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Result(ready=" + this.f385555a + ", buffered=" + this.f385556b + ", dropped=" + this.f385557c + ')';
        }

        public b(List r100, boolean r101, List r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r100 = CollectionsKt.emptyList();
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = false;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = CollectionsKt.emptyList();
        L11:
            Intrinsics.checkNotNullParameter(r100, "ready");
            Intrinsics.checkNotNullParameter(r102, "dropped");
            this.f385555a = r100;
            this.f385556b = r101;
            this.f385557c = r102;
        }
    }

    static {
    }

    public final b<T> g() {
        boolean r100 = this.f385554b;
        int r101 = this.f385553a.size();
        if (this.f385554b == false) goto L5;
        b<T> r102 = f(null);
    L6:
        FLogger.f375446a.i("AiKeySessionEventGate", "gate_release_pending_down: waitingBefore=" + r100 + " waitingAfter=" + this.f385554b + " cachedBefore=" + r101 + " released=" + r102.f385555a.size());
        return r102;
    L5:
        r102 = new b(null, false, null, 7);
        goto L6
    }

    public a() {
        this.f385553a = new ArrayDeque();
        FLogger.f375446a.i("AiKeySessionEventGate", "gate_initialized: capacity=32");
    }

    public final List<T> b() {
        List r100 = CollectionsKt.createListBuilder();
    L4:
        if ((!this.f385553a.isEmpty()) == false) goto L7;
        r100.add(this.f385553a.removeFirst());
        goto L4
    L7:
        return CollectionsKt.build(r100);
    }

    public static b e(InteractionSessionEventDispatcher.a r100) {
        return new b(CollectionsKt.listOf(r100), false, null, 6);
    }

    public final b c(InteractionSessionEventDispatcher.a r100) {
        boolean r101 = this.f385554b;
        int r102 = this.f385553a.size();
        if (this.f385554b == false) goto L5;
        b r103 = a(r100, CollectionsKt.emptyList());
    L6:
        FLogger.f375446a.i("AiKeySessionEventGate", "gate_on_following_event: waitingBefore=" + r101 + " waitingAfter=" + this.f385554b + " cachedBefore=" + r102 + " cachedAfter=" + this.f385553a.size() + " buffered=" + r103.f385556b + " released=" + r103.f385555a.size() + " dropped=" + r103.f385557c.size());
        return r103;
    L5:
        r103 = e(r100);
        goto L6
    }

    public final b<T> f(T r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("AiKeySessionEventGate", "release terminalEvent=" + r100);
        List r102 = CollectionsKt.toMutableList(b());
        if (r100 == null) goto L5;
        r102.add(r100);
    L5:
        this.f385554b = false;
        StringBuilder r103 = new StringBuilder("gate_events_released: released=");
        r103.append(r102.size());
        r103.append(" hasTerminal=");
        if (r100 == null) goto L8;
        boolean r104 = true;
    L9:
        r103.append(r104);
        r101.i("AiKeySessionEventGate", r103.toString());
        return new b(r102, false, null, 6);
    L8:
        r104 = false;
        goto L9
    }

    public final b a(InteractionSessionEventDispatcher.a r100, List r101) {
        List r102 = CollectionsKt.toMutableList(r101);
        if (this.f385553a.size() < 32) goto L5;
        r102.add(this.f385553a.removeFirst());
        FLogger.f375446a.w("AiKeySessionEventGate", "gate_capacity_overflow: capacity=32 cached=" + this.f385553a.size() + " droppedOldest=1");
    L5:
        this.f385553a.addLast(r100);
        FLogger.f375446a.i("AiKeySessionEventGate", "gate_event_buffered: cached=" + this.f385553a.size() + " dropped=" + r102.size());
        return new b(null, true, r102, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b d(int r100, InteractionSessionEventDispatcher.a.c r110) {
        boolean r101 = this.f385554b;
        int r102 = this.f385553a.size();
        if (r100 != 20) goto L15;
        ObricListeningChildCoordinator.f385289a.getClass();
        cba.b r103 = ObricListeningChildCoordinator.f385295g;
        if (r103 != null) goto L7;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L15;
        boolean r105 = true;
    L17:
        switch(r100) {
            case 20: goto L27;
            case 21: goto L24;
            case 22: goto L20;
            default: goto L18;
        };
    L18:
        b<T> r106 = e(r110);
    L30:
        FLogger.f375446a.i("AiKeySessionEventGate", "gate_on_show: invocationType=" + r100 + " shouldGate=" + r105 + " waitingBefore=" + r101 + " waitingAfter=" + this.f385554b + " cachedBefore=" + r102 + " cachedAfter=" + this.f385553a.size() + " buffered=" + r106.f385556b + " released=" + r106.f385555a.size() + " dropped=" + r106.f385557c.size());
        return r106;
    L27:
        if (r105 == false) goto L29;
        List<T> r107 = b();
        this.f385554b = true;
        FLogger.f375446a.i("AiKeySessionEventGate", "gate_down_started: replaced=" + r107.size() + " capacity=32");
        r106 = a(r110, r107);
        goto L30
    L29:
        r106 = e(r110);
        goto L30
    L20:
        if (this.f385554b == false) goto L22;
        List<T> r111 = b();
        this.f385554b = false;
        FLogger.f375446a.i("AiKeySessionEventGate", "gate_round_cancelled: dropped=" + r111.size());
        r106 = new b(null, false, r111, 3);
        goto L30
    L22:
        r106 = e(r110);
        goto L30
    L24:
        if (this.f385554b == false) goto L26;
        r106 = f(r110);
        goto L30
    L26:
        r106 = e(r110);
        goto L30
    L7:
        if (r103.f23107d != ObricAiKeyGestureState.FIRST_DOWN) goto L9;
        boolean r108 = true;
    L10:
        if (r108 != true) goto L12;
        r104 = true;
        goto L13
    L9:
        r108 = false;
    L15:
        r105 = false;
        goto L17
    }
}
