package com.larus.audio.call.mgr;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import s68.n;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f289218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<UpStateReducer> f289219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<DownStateReducer> f289220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C3963b<AVKitDuplexState.UpState> f289221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C3963b<AVKitDuplexState.DownState> f289222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StateFlowImpl f289223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateFlowImpl f289224g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.audio.call.mgr.b$b, reason: collision with other inner class name */
    public static final class C3963b<S> implements n<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<S, StateTriggerEvent> f289225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<StateTriggerEvent, h<S>> f289226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f289227c;

        public final Map<StateTriggerEvent, h<S>> b() {
            return MapsKt.toMap(this.f289226b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C3963b(Function1<? super S, ? extends StateTriggerEvent> r100) {
            Intrinsics.checkNotNullParameter(r100, "extractTriggerBy");
            this.f289225a = r100;
            this.f289226b = new LinkedHashMap();
        }

        @Override // s68.n
        public final void a(S r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            StateTriggerEvent r101 = this.f289225a.invoke(r100);
            if (r101 == null) goto L7;
            Map<StateTriggerEvent, h<S>> r102 = this.f289226b;
            int r103 = h.f289261c;
            r102.put(r101, h.a.a(r100));
            this.f289227c = true;
            return;
        L7:
            throw new IllegalArgumentException(("pending state must carry non-null triggerBy as its pending key, got: " + r100).toString());
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f289228a = null;

        static {
            int[] r100 = new int[ReducerPosition.values().length];
            r100[ReducerPosition.APPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ReducerPosition.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f289228a = r100;
        }
    }

    static {
    }

    public b() {
        this.f289218a = new ReentrantLock();
        this.f289219b = new ArrayList();
        this.f289220c = new ArrayList();
        this.f289221d = new C3963b(new s68.d());
        this.f289222e = new C3963b(new s68.e());
        StateFlowImpl r100 = j1.a(new AVKitDuplexState(new AVKitCoreStates$Invalid(), new AVKitCoreStates$Invalid()));
        this.f289223f = r100;
        this.f289224g = r100;
    }

    public static String b(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return " (by " + r100 + ')';
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a(StateTriggerEvent r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        ReentrantLock r110 = this.f289218a;
        r110.lock();
        AVKitDuplexState r100 = (AVKitDuplexState) this.f289223f.getValue();     // Catch: Throwable -> L20
        AVKitDuplexState.UpState r111 = r100.getUpState();     // Catch: Throwable -> L20
        AVKitDuplexState.DownState r112 = r100.getDownState();     // Catch: Throwable -> L20
        Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r113 = this.f289221d.b();     // Catch: Throwable -> L20
        Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r114 = this.f289222e.b();     // Catch: Throwable -> L20
        C3963b<AVKitDuplexState.UpState> r101 = this.f289221d;     // Catch: Throwable -> L20
        r101.getClass();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r210, "event");     // Catch: Throwable -> L20
        h r102 = (h) ((LinkedHashMap) r101.f289226b).get(r210);     // Catch: Throwable -> L20
        String r115 = "reducer=";
        StateTriggerEvent r116 = null;
        boolean r103 = false;
        boolean r104 = true;
        if (r102 == null) goto L7;
        C3963b<AVKitDuplexState.UpState> r105 = this.f289221d;     // Catch: Throwable -> L20
        ((LinkedHashMap) r105.f289226b).clear();     // Catch: Throwable -> L20
        r105.f289227c = true;     // Catch: Throwable -> L20
        r102.f289263b.invoke(this.f289221d);     // Catch: Throwable -> L20
        this.f289221d.f289227c = false;     // Catch: Throwable -> L20
        AVKitDuplexState.UpState r106 = (AVKitDuplexState.UpState) r102.f289262a;     // Catch: Throwable -> L20
        r110 = r110;
        String r117 = "pending-hit";
        boolean r118 = true;
        boolean r119 = true;
    L25:
        if ((r112 instanceof AVKitCoreStates$Paused) == false) goto L27;
        AVKitCoreStates$Paused r107 = (AVKitCoreStates$Paused) r112;     // Catch: Throwable -> L58
    L28:
        if (r107 == null) goto L30;
        AVKitDuplexState.DownState r108 = r107.f289167b;     // Catch: Throwable -> L58
    L31:
        if (r108 != null) goto L33;
    L47:
        boolean r211 = false;
    L48:
        C3963b<AVKitDuplexState.DownState> r109 = this.f289222e;     // Catch: Throwable -> L58
        r109.getClass();     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r210, "event");     // Catch: Throwable -> L58
        h r120 = (h) ((LinkedHashMap) r109.f289226b).get(r210);     // Catch: Throwable -> L58
        if (r120 == null) goto L60;
        C3963b<AVKitDuplexState.DownState> r121 = this.f289222e;     // Catch: Throwable -> L58
        ((LinkedHashMap) r121.f289226b).clear();     // Catch: Throwable -> L58
        r121.f289227c = r118;     // Catch: Throwable -> L58
        r120.f289263b.invoke(this.f289222e);     // Catch: Throwable -> L58
        this.f289222e.f289227c = false;     // Catch: Throwable -> L58
        if (r211 == true) goto L53;
        AVKitDuplexState.DownState r122 = (AVKitDuplexState.DownState) r120.f289262a;     // Catch: Throwable -> L58
    L57:
        r106 = r106;
        String r123 = "pending-hit";
        boolean r124 = true;
    L86:
        if (r106 == r111) goto L88;
        boolean r125 = true;
    L89:
        if (r122 == r112) goto L91;
        boolean r212 = true;
    L93:
        if (r125 == true) goto L101;
        if (r212 == true) goto L101;
        if (r119 == true) goto L100;
        if (r124 == true) goto L100;
        com.larus.audio.call.util.e.f289645a.w("AVKitStateMachine", c(r210, r100));     // Catch: Throwable -> L58
    L102:
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L58
        r110.unlock();
        return;
    L100:
        com.larus.audio.call.util.e.f289645a.i("AVKitStateMachine", d(r210, r113, r114));     // Catch: Throwable -> L58
    L101:
        AVKitDuplexState r127 = new AVKitDuplexState(r106, r122);     // Catch: Throwable -> L58
        this.f289223f.setValue(r127);     // Catch: Throwable -> L58
        com.larus.audio.call.util.e r128 = com.larus.audio.call.util.e.f289645a;     // Catch: Throwable -> L58
        r128.i("AVKitStateMachine", f(r210, r100, r127, r125, r212, r117, r123));     // Catch: Throwable -> L58
        r128.i("AVKitStateMachine", d(r210, r113, r114));     // Catch: Throwable -> L58
        goto L102
    L91:
        r212 = false;
        goto L93
    L88:
        r125 = false;
        goto L89
    L53:
        if (r107 == null) goto L55;
        r116 = r107.getTriggerBy();     // Catch: Throwable -> L58
    L55:
        r122 = new AVKitCoreStates$Paused(r116, (AVKitDuplexState.DownState) r120.f289262a);     // Catch: Throwable -> L58
        goto L57
    L60:
        if (r211 == false) goto L65;
        if (r108 == null) goto L64;
        AVKitDuplexState.DownState r129 = r108;
    L66:
        Iterator r130 = ((ArrayList) this.f289220c).iterator();     // Catch: Throwable -> L58
        Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r213 = r114;
        boolean r131 = false;
    L68:
        if (r130.hasNext() == false) goto L77;
        DownStateReducer r132 = (DownStateReducer) r130.next();     // Catch: Throwable -> L58
        C3963b<AVKitDuplexState.DownState> r133 = this.f289222e;     // Catch: Throwable -> L58
        r133.f289227c = false;     // Catch: Throwable -> L58
        h r134 = r132.b(r129, r210, r133);     // Catch: Throwable -> L58
        if (r134 != null) goto L71;
        C3963b<AVKitDuplexState.DownState> r135 = this.f289222e;     // Catch: Throwable -> L58
        if (r135.f289227c == false) goto L76;
        Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r136 = r135.b();     // Catch: Throwable -> L58
        g(ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, r132, r210, r213, r136);     // Catch: Throwable -> L58
        r213 = r136;
        r131 = true;
    L76:
        r108 = r108;
        r106 = r106;
        r129 = r129;
        r107 = r107;
        r115 = r115;
        goto L68
    L71:
        AVKitDuplexState.DownState r137 = (AVKitDuplexState.DownState) r134.f289262a;     // Catch: Throwable -> L58
        C3963b<AVKitDuplexState.DownState> r138 = this.f289222e;     // Catch: Throwable -> L58
        ((LinkedHashMap) r138.f289226b).clear();     // Catch: Throwable -> L58
        r138.f289227c = true;     // Catch: Throwable -> L58
        r134.f289263b.invoke(this.f289222e);     // Catch: Throwable -> L58
        r123 = r115 + Reflection.getOrCreateKotlinClass(r132.getClass()).getSimpleName();     // Catch: Throwable -> L58
        r122 = r137;
        r124 = true;
    L78:
        if (r211 == false) goto L86;
        if (r122 != r108) goto L82;
        r122 = (AVKitCoreStates$Paused) r112;     // Catch: Throwable -> L58
        goto L86
    L82:
        if (r107 == 0) goto L85;
        r116 = r107.getTriggerBy();     // Catch: Throwable -> L58
    L85:
        r122 = new AVKitCoreStates$Paused(r116, r122);     // Catch: Throwable -> L58
        goto L86
    L77:
        r124 = r131;
        r123 = null;
        r122 = r129;
        goto L78
    L64:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L58
    L65:
        r129 = r112;
        goto L66
    L33:
        if (Intrinsics.areEqual(r210, StateTriggerEvent.Resume.f289213a) == true) goto L47;
        if (Intrinsics.areEqual(r210, StateTriggerEvent.Pause.f289204a) == true) goto L47;
        if (Intrinsics.areEqual(r210, StateTriggerEvent.Connect.f289195a) == true) goto L47;
        if (Intrinsics.areEqual(r210, StateTriggerEvent.Connected.f289196a) == true) goto L47;
        if (Intrinsics.areEqual(r210, StateTriggerEvent.Stop.f289215a) == true) goto L47;
        if (Intrinsics.areEqual(r210, StateTriggerEvent.Reset.f289212a) == true) goto L47;
        if ((r210 instanceof StateTriggerEvent.Error) == true) goto L47;
        r211 = true;
        goto L48
    L30:
        r108 = null;
        goto L31
    L27:
        r107 = null;
        goto L28
    L7:
        Iterator r139 = ((ArrayList) this.f289219b).iterator();     // Catch: Throwable -> L20
        Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r140 = r113;
        boolean r141 = false;
    L9:
        if (r139.hasNext() == false) goto L22;
        UpStateReducer r142 = (UpStateReducer) r139.next();     // Catch: Throwable -> L20
        C3963b<AVKitDuplexState.UpState> r143 = this.f289221d;     // Catch: Throwable -> L20
        r143.f289227c = r103;     // Catch: Throwable -> L20
        h r144 = r142.a(r111, r210, r143);     // Catch: Throwable -> L20
        if (r144 != null) goto L12;
        C3963b<AVKitDuplexState.UpState> r145 = this.f289221d;     // Catch: Throwable -> L20
        if (r145.f289227c == false) goto L19;
        Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r214 = r145.b();     // Catch: Throwable -> L20
        ReentrantLock r215 = r110;
        g("up", r142, r210, r140, r214);     // Catch: Throwable -> L58
        r140 = r214;
        r110 = r215;
        r141 = true;
        r104 = true;
    L58:
        th = th;
    L105:
        r215.unlock();
        throw th;
    L19:
        r103 = false;
        goto L9
    L12:
        AVKitDuplexState.UpState r146 = (AVKitDuplexState.UpState) r144.f289262a;     // Catch: Throwable -> L20
        C3963b<AVKitDuplexState.UpState> r147 = this.f289221d;     // Catch: Throwable -> L20
        ((LinkedHashMap) r147.f289226b).clear();     // Catch: Throwable -> L20
        r147.f289227c = r104;     // Catch: Throwable -> L20
        r144.f289263b.invoke(this.f289221d);     // Catch: Throwable -> L20
        String r148 = "reducer=" + Reflection.getOrCreateKotlinClass(r142.getClass()).getSimpleName();     // Catch: Throwable -> L20
        r118 = true;
    L23:
        r106 = r146;
        r117 = r148;
        r119 = r104;
        goto L25
    L22:
        r118 = true;
        r104 = r141;
        r146 = r111;
        r148 = null;
    L20:
        th = th;
        r215 = r110;
        goto L105
    }

    public final String e(Map<StateTriggerEvent, ? extends h<?>> r110) {
        if (r110.isEmpty() == false) goto L7;
        return SliceInitService.DEFAULT_SWITCH;
    L7:
        return CollectionsKt.joinToString$default(r110.entrySet(), null, "{", com.alipay.sdk.m.u.i.f25855d, 0, null, new s68.a(this), 25, null);
    }

    public static String c(StateTriggerEvent r100, AVKitDuplexState r101) {
        String r102 = Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName();
        if (r101.getUpState() != r101.getDownState()) goto L5;
        String r103 = " (shared)";
    L7:
        return "[sm][noop] event=" + r102 + " | up=" + r101.getUpState().toSimpleString() + " | down=" + r101.getDownState().toSimpleString() + r103;
    L5:
        r103 = "";
        goto L7
    }

    public final void h(final DownStateReducer r100, ReducerPosition r101) {
        Intrinsics.checkNotNullParameter(r100, "reducer");
        Intrinsics.checkNotNullParameter(r101, "position");
        ReentrantLock r102 = this.f289218a;
        r102.lock();
    L24:
        th = move-exception;
        r102.unlock();
        throw th;
    L4:
        if ((r100 instanceof UpStateReducer) == false) goto L13;
        CollectionsKt.removeAll(this.f289219b, new s68.b(r100));     // Catch: Throwable -> L24
        int r103 = c.f289228a[r101.ordinal()];     // Catch: Throwable -> L24
        if (r103 == 1) goto L11;
        if (r103 != 2) goto L10;
        ((ArrayList) this.f289219b).add(0, r100);     // Catch: Throwable -> L24
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L24
    L11:
        ((ArrayList) this.f289219b).add(r100);     // Catch: Throwable -> L24
    L13:
        if ((r100 instanceof DownStateReducer) == false) goto L21;
        CollectionsKt.removeAll(this.f289220c, new s68.c(r100));     // Catch: Throwable -> L24
        int r104 = c.f289228a[r101.ordinal()];     // Catch: Throwable -> L24
        if (r104 == 1) goto L20;
        if (r104 != 2) goto L19;
        ((ArrayList) this.f289220c).add(0, r100);     // Catch: Throwable -> L24
        goto L21
    L19:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L24
    L20:
        ((ArrayList) this.f289220c).add(r100);     // Catch: Throwable -> L24
    L21:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r102.unlock();
    }

    public final String d(StateTriggerEvent r100, Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r101, Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r102) {
        String r103 = Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName();
        Map<StateTriggerEvent, h<AVKitDuplexState.UpState>> r104 = this.f289221d.b();
        Map<StateTriggerEvent, h<AVKitDuplexState.DownState>> r105 = this.f289222e.b();
        boolean r106 = Intrinsics.areEqual(r101, r104);
        String r107 = ContainerUtils.KEY_VALUE_DELIMITER;
        if (r106 == false) goto L5;
        String r108 = ContainerUtils.KEY_VALUE_DELIMITER;
    L7:
        if (Intrinsics.areEqual(r102, r105) == true) goto L11;
        r107 = "->";
    L11:
        return "[sm][pending-diff] event=" + r103 + " | upPending: " + e(r101) + r108 + e(r104) + " | downPending: " + e(r102) + r107 + e(r105);
    L5:
        r108 = "->";
        goto L7
    }

    public final void g(String r100, s68.h r101, StateTriggerEvent r102, Map<StateTriggerEvent, ? extends h<?>> r103, Map<StateTriggerEvent, ? extends h<?>> r104) {
        com.larus.audio.call.util.e.f289645a.i("AVKitStateMachine", "[sm][slot-diff] side=" + r100 + " event=" + Reflection.getOrCreateKotlinClass(r102.getClass()).getSimpleName() + " reducer=" + Reflection.getOrCreateKotlinClass(r101.getClass()).getSimpleName() + " | " + r100 + "Pending: " + e(r103) + " -> " + e(r104));
    }

    public static String f(StateTriggerEvent r100, AVKitDuplexState r101, AVKitDuplexState r102, boolean r103, boolean r110, String r111, String r112) {
        String r104 = Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName();
        if (r101.getUpState() != r101.getDownState()) goto L5;
    L8:
        boolean r105 = true;
    L9:
        String r106 = " (shared)";
        if (r103 == false) goto L17;
        if (r110 == false) goto L17;
        if (r102.getUpState() != r102.getDownState()) goto L17;
        if (Intrinsics.areEqual(r111, r112) == false) goto L17;
        String r107 = "up&down: " + r101.getUpState().toSimpleString() + " -> " + ((AVKitDuplexState.DownState) r102.getUpState()).toSimpleString() + b(r111) + " (shared)";
    L28:
        return "[sm][state-move] event=" + r104 + " | " + r107;
    L17:
        if (r103 == false) goto L19;
        String r108 = "up: " + r101.getUpState().toSimpleString() + " -> " + r102.getUpState().toSimpleString() + b(r111);
    L20:
        if (r110 == false) goto L22;
        String r109 = "down: " + r101.getDownState().toSimpleString() + " -> " + r102.getDownState().toSimpleString() + b(r112);
    L23:
        if (r105 == true) goto L26;
        r106 = "";
    L26:
        r107 = r108 + " | " + r109 + r106;
        goto L28
    L22:
        r109 = "down= " + r101.getDownState().toSimpleString();
        goto L23
    L19:
        r108 = "up= " + r101.getUpState().toSimpleString();
        goto L20
    L5:
        if (r102.getUpState() == r102.getDownState()) goto L8;
        r105 = false;
        goto L9
    }
}
