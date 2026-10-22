package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.ec.core.event.EventActionImpl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class Monitor extends EventActionImpl implements d, h {
    public a c;
    public c d;
    public final ConcurrentHashMap<String, String> e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/pre_purchase/arch/launch/Monitor$State;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAILURE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State FAILURE = null;
        public static final State SUCCESS = null;
        public static final /* synthetic */ State[] a = null;
        private final String value;

        static {
            State r1 = new State("SUCCESS", 0, "success");
            SUCCESS = r1;
            State r2 = new State("FAILURE", 1, "failure");
            FAILURE = r2;
            a = new State[]{r1, r2};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public State(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public final ChainName a;
        public final long b;
        public final CopyOnWriteArrayList<c> c;
        public Throwable d;
        public Long e;
        public State f;

        public a() {
            throw null;
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L18;
            a r7 = (a) r6;
            if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            ChainName r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            long r3 = this.b;
            int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            CopyOnWriteArrayList<c> r5 = this.c;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            Throwable r8 = this.d;
            if (r8 == null) goto L13;
            int r9 = r8.hashCode();
        L14:
            int r10 = (r7 + r9) * 31;
            Long r11 = this.e;
            if (r11 == null) goto L17;
            int r12 = r11.hashCode();
        L18:
            int r13 = (r10 + r12) * 31;
            State r14 = this.f;
            if (r14 == null) goto L22;
            r1 = r14.hashCode();
        L22:
            return r13 + r1;
        L17:
            r12 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L14
        L9:
            r6 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ChainStats(chainName=" + this.a + ", startTime=" + this.b + ", stageStats=" + this.c + ", error=" + this.d + ", endTime=" + this.e + ", state=" + this.f + ")";
        }

        public a(ChainName r6) {
            long r0 = System.currentTimeMillis();
            CopyOnWriteArrayList<c> r2 = new CopyOnWriteArrayList();
            State r3 = State.FAILURE;
            Intrinsics.checkNotNullParameter(r6, "chainName");
            Intrinsics.checkNotNullParameter(r2, "stageStats");
            Intrinsics.checkNotNullParameter(r3, "state");
            this.a = r6;
            this.b = r0;
            this.c = r2;
            this.d = null;
            this.e = null;
            this.f = r3;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final StageName a;
        public final long b;
        public Long c;
        public State d;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof c) == false) goto L14;
            c r7 = (c) r6;
            if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            StageName r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            long r3 = this.b;
            int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            Long r5 = this.c;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            State r8 = this.d;
            if (r8 == null) goto L14;
            r1 = r8.hashCode();
        L14:
            return r7 + r1;
        L9:
            r6 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "StageStats(stageName=" + this.a + ", startTime=" + this.b + ", endTime=" + this.c + ", state=" + this.d + ")";
        }

        public c(StageName r3, long r4) {
            State r0 = State.FAILURE;
            Intrinsics.checkNotNullParameter(r3, "stageName");
            Intrinsics.checkNotNullParameter(r0, "state");
            this.a = r3;
            this.b = r4;
            this.c = null;
            this.d = r0;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.d
    public final void c() {
        a r0 = this.c;
        if (r0 == null) goto L5;
        r0.e = Long.valueOf(System.currentTimeMillis());
        State r1 = State.SUCCESS;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.f = r1;
    L5:
        o();
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void d() {
        c r0 = this.d;
        if (r0 == null) goto L5;
        r0.c = Long.valueOf(System.currentTimeMillis());
    L5:
        c r1 = this.d;
        if (r1 == null) goto L8;
        State r2 = State.SUCCESS;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.d = r2;
    L8:
        a r3 = this.c;
        if (r3 == null) goto L14;
        CopyOnWriteArrayList<c> r4 = r3.c;
        if (r4 == null) goto L15;
        r4.add(this.d);
        return;
    L15:
        return;
    }

    public final void o() {
        LinkedHashMap r0 = new LinkedHashMap();
        a r1 = this.c;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = String.valueOf(r1.b);
    L6:
        r0.put("T_chain_start", r3);
        a r4 = this.c;
        if (r4 == null) goto L11;
        Long r5 = r4.e;
        if (r5 == null) goto L11;
        String r6 = String.valueOf(r5.longValue());
    L12:
        r0.put("T_chain_end", r6);
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r8 = this.e.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        Map.Entry<String, String> r9 = r8.next();
        r7.put(r9.getKey(), r9.getValue());
        goto L14
    L16:
        a r10 = this.c;
        if (r10 == null) goto L21;
        ChainName r11 = r10.a;
        if (r11 == null) goto L21;
        String r12 = r11.getValue();
    L22:
        r7.put("name", r12);
        a r13 = this.c;
        if (r13 == null) goto L27;
        State r14 = r13.f;
        if (r14 == null) goto L27;
        r2 = r14.getValue();
    L27:
        r7.put("state", r2);
        a r15 = this.c;
        if (r15 == null) goto L34;
        Throwable r16 = r15.d;
        if (r16 == null) goto L34;
        String r17 = r16.getMessage();
        if (r17 == null) goto L34;
        r7.put("error_msg", r17);
    L34:
        LinkedHashMap r18 = new LinkedHashMap();
        a r19 = this.c;
        if (r19 == null) goto L42;
        CopyOnWriteArrayList<c> r20 = r19.c;
        if (r20 == null) goto L42;
        Iterator<T> r21 = r20.iterator();
    L40:
        if (r21.hasNext() == false) goto L42;
        c r22 = (c) r21.next();
        r0.put("T_" + r22.a.getValue() + "_start", String.valueOf(r22.b));
        r0.put("T_" + r22.a.getValue() + "_end", String.valueOf(r22.c));
        r18.put(r22.a.getValue() + "_state", r22.d.getValue());
    L42:
        r7.put("timing", com.bytedance.android.shopping.extensions.k.x(r0));
        r7.put("stage_state", com.bytedance.android.shopping.extensions.k.x(r18));
        doEventAction("ec_launcher_trace", r7, new Pair[0]);
        return;
    L21:
        r12 = null;
    L11:
        r6 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public Monitor(String r3) {
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        ConcurrentHashMap<String, String> r0 = new ConcurrentHashMap();
        r0.put("session_id", r3);
        Unit r4 = Unit.INSTANCE;
        this.e = r0;
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void h(Throwable r3) {
        c r4 = this.d;
        if (r4 == null) goto L5;
        r4.c = Long.valueOf(System.currentTimeMillis());
    L5:
        c r5 = this.d;
        if (r5 == null) goto L8;
        State r0 = State.FAILURE;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r5.d = r0;
    L8:
        a r6 = this.c;
        if (r6 == null) goto L14;
        CopyOnWriteArrayList<c> r7 = r6.c;
        if (r7 == null) goto L15;
        r7.add(this.d);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.d
    public final void i(Throwable r4) {
        a r0 = this.c;
        if (r0 == null) goto L5;
        r0.e = Long.valueOf(System.currentTimeMillis());
        State r1 = State.FAILURE;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.f = r1;
        r0.d = r4;
    L5:
        o();
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.d
    public final void k(ChainName r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.c = new a(r2);
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void e(StageName r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        this.d = new c(r4, System.currentTimeMillis());
        if (r5 == null) goto L10;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        Map.Entry<String, String> r7 = r6.next();
        String r0 = r7.getKey();
        String r8 = r7.getValue();
        if (this.e.containsKey(r0) == true) goto L6;
        this.e.put(r0, String.valueOf(r8));
        goto L6
    L16:
        return;
    }
}
