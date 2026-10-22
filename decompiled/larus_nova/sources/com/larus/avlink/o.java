package com.larus.avlink;

import android.os.SystemClock;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.avlink.plugins.n3;
import com.larus.avlink.plugins.n4;
import com.larus.avlink.plugins.o4;
import com.larus.im.service.audio.AudioSessionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes24.dex */
public abstract class o extends LLMCallController<n4> {
    public static final /* synthetic */ int E = 0;
    public Function1<? super byte[], Unit> A;
    public boolean B;
    public final com.larus.avlink.rtc.e C;
    public final Lazy D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f293481v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f293482w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final buc.a f293483x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final buc.a f293484y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final buc.a f293485z;

    public static final class a {
    }

    public final class b extends LLMCallController<n4>.a implements n4 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f293486b;

        @Override // com.larus.avlink.plugins.n4
        public final boolean A() {
            return this.f293486b.C.f294473a;
        }

        @Override // com.larus.avlink.plugins.n4
        public final boolean E() {
            if (this.f293486b.f289030f.f288759s != AudioSessionType.MMT) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.larus.avlink.plugins.n4
        public final boolean e() {
            return this.f293486b.f293484y.c();
        }

        @Override // com.larus.avlink.plugins.n4
        public final void mute() {
            this.f293486b.G(new RealtimeCallParam());
        }

        @Override // com.larus.avlink.plugins.n4
        public final int q() {
            return this.f293486b.f293481v;
        }

        @Override // com.larus.avlink.plugins.n4
        public final void unmute() {
            this.f293486b.U(new RealtimeCallParam());
        }

        @Override // com.larus.avlink.plugins.n4
        public final boolean x() {
            if (this.f293486b.f289030f.f288759s != AudioSessionType.RTC) goto L5;
            return true;
        L5:
            return false;
        }

        public b(o r100) {
            this.f293486b = r100;
            super(r100);
        }

        @Override // com.larus.avlink.plugins.n4
        public final void f(int r100) {
            this.f293486b.g0(r100);
        }

        @Override // com.larus.avlink.plugins.n4
        public final void m(int r100) {
            this.f293486b.d0(r100);
        }

        @Override // com.larus.avlink.plugins.n4
        public final void o(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Function1<? super byte[], Unit> r101 = this.f293486b.A;
            if (r101 == null) goto L6;
            r101.invoke(r100);
            return;
        }

        @Override // com.larus.avlink.plugins.n4
        public final void p(String r100, String r101) {
            Intrinsics.checkNotNullParameter("env_observe", "caller");
            this.f293486b.h0("env_observe", r100, r101);
        }

        @Override // com.larus.avlink.plugins.n4
        public final void d(boolean r100, int r101, int r102) {
            this.f293486b.f0(r100, r101, r102);
        }
    }

    static {
    }

    public abstract void Y();

    public void Z() {
    }

    public abstract void c0(RealtimeCallParam r100, int r101, String r102, String r103);

    public abstract void e0(m r100);

    public abstract void i0(Map r100);

    @Override // com.larus.audio.call.arch.LLMCallController
    public final com.larus.audio.call.arch.c K() {
        return new b(this);
    }

    public final n3 X() {
        return (n3) LLMCallController.w(this, Reflection.getOrCreateKotlinClass(n3.class));
    }

    @Override // com.larus.audio.call.arch.LLMCallController
    public String A() {
        return this.f293482w;
    }

    public CompletableDeferred V(int r100) {
        g0(r100);
        return I();
    }

    public final void W(Function1 r100) {
        long r101 = SystemClock.elapsedRealtime();
        List r102 = CollectionsKt.toList(((LinkedHashMap) x().f289073b).values());
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if ((r105 instanceof com.larus.avlink.plugins.c) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Iterator r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        r100.invoke((com.larus.avlink.plugins.c) r106.next());
        goto L10
    L12:
        com.larus.audio.call.util.e.f289645a.i(A(), "onVoiceWakeUp total cost: " + (SystemClock.elapsedRealtime() - r101) + "ms");
    }

    public final void d0(final int r100) {
        n1.d(A(), "try stop call");
        Z();
        RealtimeCallParam r101 = this.f289030f;
        RealtimeCallParam.k r102 = r101.f288756p;
        if (r100 != 3) goto L5;
        RealtimeCallParam.DoraEndType r103 = RealtimeCallParam.DoraEndType.EIGHT_TIMEOUT;
    L9:
        r102.C = r103;
        RealtimeCallParam.j r104 = r101.f288754n;
        r104.f288838a = Integer.valueOf(r100);
        V(r100).invokeOnCompletion(new h(this, r100));
        return;
    L5:
        if (r100 == 6) goto L7;
        r103 = RealtimeCallParam.DoraEndType.OTHER;
        goto L9
    L7:
        r103 = RealtimeCallParam.DoraEndType.TOUCHPAD;
        goto L9
    }

    public final void g0(int r100) {
        n1.d(A(), "triggerConversationEnd, reason: " + r100 + ", isInConversation: " + this.f293484y.c());
        if (this.f293484y.a(true, false) == false) goto L25;
        List r101 = CollectionsKt.toList(((LinkedHashMap) x().f289073b).values());
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();
        if ((r104 instanceof o4) == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        Iterator r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        ((o4) r105.next()).Q0(r100);
        goto L12
    L14:
        com.larus.avlink.rtc.e r106 = this.C;
        r106.getClass();
        Intrinsics.checkNotNullParameter("triggerConversationEnd", "caller");
        if (r106.f294473a == false) goto L26;
        r106.f294473a = false;
        return;
    L26:
        return;
    }

    public void b0(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "block");
        if (this.f293483x.a(false, true) == false) goto L9;
        Function0<CoroutineScope> r102 = this.f289028d;
        if (r102 == null) goto L11;
        CoroutineScope r103 = r102.invoke();
        if (r103 == null) goto L12;
        BuildersKt.launch$default(r103, Dispatchers.getIO(), null, new BaseDoraCallLLMController$safeStop$1(r101, this, r100, null), 2, null);
        return;
    L12:
        return;
    L11:
        return;
    L9:
        n1.d(A(), "current stop job running, skip ".concat(r100));
    }

    public void f0(final boolean r100, int r101, final int r102) {
        n1.d(A(), "try stopVUI call: hash: " + hashCode() + ", isSilent: " + r100 + ", scene: " + r101);
        Z();
        this.f289030f.f288754n.f288838a = Integer.valueOf(r102);
        V(r102).invokeOnCompletion(new g(this, r100, r102));
    }

    public final void h0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        n1.d(A(), "triggerConversationStart, caller: " + r100 + ", isInConversation: " + this.f293484y.c());
        if (this.f293484y.a(false, true) == false) goto L17;
        com.larus.avlink.rtc.e r103 = this.C;
        r103.getClass();
        com.larus.avlink.rtc.d.f294472a.getClass();
        Boolean r104 = com.larus.avlink.rtc.d.a(r102);
        if (r104 == null) goto L7;
        r103.f294473a = r104.booleanValue();
    L7:
        List r105 = CollectionsKt.toList(((LinkedHashMap) x().f289073b).values());
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        Object r108 = r107.next();
        if ((r108 instanceof o4) == false) goto L9;
        r106.add(r108);
        goto L9
    L13:
        Iterator r109 = r106.iterator();
    L15:
        if (r109.hasNext() == false) goto L24;
        ((o4) r109.next()).i0(r100, r101, r102);
        goto L15
    L24:
        return;
    }

    public o(b78.c r100, com.larus.voicecall.impl.tracer.q r101, int r102, t r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionCreator");
        Intrinsics.checkNotNullParameter(r101, "traceSpan");
        Intrinsics.checkNotNullParameter(r103, "lifecycleScope");
        super(r100, r101, r103);
        this.f293481v = r102;
        this.f293482w = "DoraCallLLMController";
        this.f293483x = buc.b.a(false);
        this.f293484y = buc.b.a(false);
        this.f293485z = buc.b.a(false);
        this.C = new com.larus.avlink.rtc.e();
        this.D = LazyKt.lazy(new e(this));
    }
}
