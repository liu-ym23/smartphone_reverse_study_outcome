package com.larus.audio.call.plugins;

import android.os.SystemClock;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.audio.call.arch.c;
import com.larus.im.service.audio.DataType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class e<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements r0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<com.larus.im.service.audio.s> f289447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f289448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f289449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b78.b f289450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f289451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f289452k;

    public static final class a implements com.larus.im.service.audio.x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f289453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DataType f289454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e<C> f289455c;

        @Override // com.larus.im.service.audio.x
        public final String getName() {
            return this.f289453a;
        }

        @Override // com.larus.im.service.audio.x
        public DataType getType() {
            return this.f289454b;
        }

        public a(e<C> r100) {
            this.f289455c = r100;
            this.f289453a = r100.f289448g;
            this.f289454b = DataType.PLAYER;
        }

        @Override // com.larus.im.service.audio.x
        public final void a(com.larus.im.service.audio.l r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            e<C> r101 = this.f289455c;
            r101.getClass();
            String r102 = com.larus.audio.call.util.m.b(r100.b(), "src_channel");
            if (Intrinsics.areEqual(r101.getContext().params().f288751k.f288826o, "dora_si") == false) goto L5;
            boolean r103 = Intrinsics.areEqual(r102, "1");
        L6:
            if (r103 == false) goto L8;
            com.larus.audio.call.util.e.f289645a.i(this.f289455c.f289448g, "[CALL] onReceiveFrame，frame silent: " + r100.f350775d + " extra: " + r100.f350773b);
            this.f289455c.j3(r100);
            return;
        L8:
            com.larus.audio.call.util.e.f289645a.i(this.f289455c.f289448g, "zchhhhh, audio scrChannel is 0");
            return;
        L5:
            r103 = true;
            goto L6
        }
    }

    @Override // com.larus.audio.call.arch.a
    public com.larus.im.service.audio.x Q2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void X2() {
        cancel("Interrupt");
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        this.f289450i.b(true, WidgetCostModule.TYPE_ON_START);
        super.e3();
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        cancel("onStop");
        super.g3();
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return this.f289452k;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f289448g;
    }

    public void R1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        com.larus.audio.call.arch.b.a(getContext()).R1(r100);
    }

    @Override // com.larus.audio.call.plugins.r0
    public final void cancel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        this.f289450i.b(false, r100);
    }

    public void j3(Object r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        if (this.f289450i.a() == true) goto L6;
        return;
    L6:
        if ((r110 instanceof com.larus.audio.call.play.h.c) == false) goto L9;
        com.larus.audio.call.arch.b.a(getContext()).p0((com.larus.audio.call.play.h) r110);
        return;
    L9:
        if ((r110 instanceof com.larus.audio.call.play.h.b) == false) goto L12;
        com.larus.audio.call.arch.b.a(getContext()).p0((com.larus.audio.call.play.h) r110);
        return;
    L12:
        if ((r110 instanceof com.larus.im.service.audio.l) == false) goto L22;
        long r100 = SystemClock.elapsedRealtime();
        com.larus.im.service.audio.l r111 = (com.larus.im.service.audio.l) r110;
        com.larus.im.service.audio.l r101 = this.f289447f.invoke().a(r111);
        long r102 = SystemClock.elapsedRealtime();
        if (r111.f350775d == true) goto L16;
        com.larus.audio.call.arch.b.a(getContext()).p0(new com.larus.audio.call.play.h.a(r101.f350772a, r101.d(), r101.c(), r101.b()));
    L16:
        long r103 = SystemClock.elapsedRealtime() - r100;
        long r104 = r102 - r100;
        if (r104 <= 12) goto L23;
        com.larus.audio.call.util.e.f289645a.e(this.f289448g, "[handleData] process " + r104 + "ms, all " + r103 + "ms.");
        return;
    L23:
        return;
    }

    public e(com.larus.audio.call.arch.c r100, com.larus.audio.call.arch.n r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "postProcessor");
        super(r100);
        this.f289447f = r101;
        this.f289448g = "CommonAudioFrameReceiver";
        this.f289449h = LazyKt.lazy(new d());
        this.f289450i = new b78.b("CommonAudioFrameReceiver");
        this.f289451j = true;
        this.f289452k = new f(this);
    }
}
