package com.larus.im.internal.audio.session.v1.sami;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.internal.delegate.w;
import com.larus.im.internal.network.link.impl.sami.n;
import com.larus.im.service.audio.MediaSession;
import com.larus.im.service.audio.l;
import com.larus.im.service.audio.x0;
import com.larus.im.service.audio.y;
import com.larus.im.service.audio.z;
import he9.d;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import pd9.e;
import ue9.f;
import ue9.g;
import ue9.i;
import ve9.h;

/* JADX INFO: loaded from: classes29.dex */
public abstract class SAMIMediaSession extends e {
    public static final /* synthetic */ int D = 0;
    public final Lazy A;
    public final b B;
    public final MutableSharedFlow<l> C;

    public static final class a {
    }

    public static final class b extends ue9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SAMIMediaSession f347401a;

        public b(SAMIMediaSession r100) {
            this.f347401a = r100;
        }

        @Override // ue9.a
        public final void a(f r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            Intrinsics.checkNotNullParameter(r100, "frame");
            if ((r100.getType() instanceof g.a) == false) goto L13;
            byte[] r101 = r100.f549869c;
            if (r101 == null) goto L7;
            String r102 = new String(r101, Charsets.UTF_8);
        L8:
            SAMIMediaSession r103 = this.f347401a;
            byte[] r104 = r100.f549867a;
            if (r102 != null) goto L11;
            r102 = "";
        L11:
            r103.P(new l(r104, r102, r100.getType(), false));
            return;
        L7:
            r102 = null;
            goto L8
        }
    }

    public static final class c<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SAMIMediaSession f347402a;

        public c(SAMIMediaSession r100) {
            this.f347402a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r110, Continuation r111) {
            l r112 = (l) r110;
            if ((r112.getType() instanceof g.a) == false) goto L5;
            SAMIMediaSession r113 = this.f347402a;
            r113.getClass();
            Intrinsics.checkNotNullParameter(r112, "frame");
            r113.f350662s.b(r112);
        L5:
            i r114 = this.f347402a.H();
            byte[] r100 = r112.f350772a;
            g r101 = r112.getType();
            String r115 = r112.f350773b;
            if (r115 == null) goto L8;
            byte[] r116 = r115.getBytes(Charsets.UTF_8);
        L9:
            r114.f(new f(r100, r101, r116, null, false, null, 56));
            return Unit.INSTANCE;
        L8:
            r116 = null;
            goto L9
        }
    }

    static {
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final Object M(Continuation<? super Unit> r100) {
        return X(this, r100);
    }

    @Override // id9.d
    public final y a() {
        return null;
    }

    @Override // id9.e
    public final z e() {
        return null;
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final d J() {
        return (d) this.A.getValue();
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final void Q() {
        if (h.a(this.f350646c, "launch_stream_task_on_start", false) == true) goto L6;
        SAMIMediaSession$launchStreamTask$1 r100 = new SAMIMediaSession$launchStreamTask$1(this, null);
        Intrinsics.checkNotNullParameter(r100, "block");
        Job r101 = BuildersKt.launch$default(MediaSession.f350643y, null, null, r100, 3, null);
        this.f350647d.offer(r101);
        return;
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final void S() {
        CoroutineExtKt.a(new SAMIMediaSession$requestCallEnd$1(this, null));
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final void T() {
        CoroutineExtKt.a(new SAMIMediaSession$requestCallStart$1(this, null));
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.e
    public final void start() {
        super.start();
        if (h.a(this.f350646c, "launch_stream_task_on_start", false) == false) goto L6;
        SAMIMediaSession$launchStreamTask$1 r100 = new SAMIMediaSession$launchStreamTask$1(this, null);
        Intrinsics.checkNotNullParameter(r100, "block");
        Job r101 = BuildersKt.launch$default(MediaSession.f350643y, null, null, r100, 3, null);
        this.f350647d.offer(r101);
        return;
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final ue9.a I() {
        return this.B;
    }

    public SAMIMediaSession(x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
        this.A = LazyKt.lazy(new com.larus.im.internal.audio.session.v1.sami.b());
        this.B = new b(this);
        int r101 = ((Number) w.f348278n.getValue()).intValue();
        this.C = SharedFlowKt.MutableSharedFlow(((Number) w.f348277m.getValue()).intValue(), r101, BufferOverflow.SUSPEND);
    }

    @Override // com.larus.im.service.audio.MediaSession
    public final i G(ve9.g r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        int r101 = com.larus.im.internal.network.link.impl.sami.a.f349438a;
        Intrinsics.checkNotNullParameter(r100, "config");
        return new n(r100);
    }

    @Override // com.larus.im.service.audio.MediaSession, id9.d
    public final void u(l r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Intrinsics.checkNotNullParameter(r100, "frame");
        L();
        this.C.tryEmit(r100);
    }

    public static /* synthetic */ Object X(SAMIMediaSession r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof SAMIMediaSession$launchPushStreamTask$1) == false) goto L7;
        SAMIMediaSession$launchPushStreamTask$1 r102 = (SAMIMediaSession$launchPushStreamTask$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L12;
        ResultKt.throwOnFailure(r104);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        MutableSharedFlow<l> r107 = r100.C;
        c r108 = new c(r100);
        r102.label = 1;
        if (r107.collect(r108, r102) != r105) goto L18;
        return r105;
    L7:
        r102 = new SAMIMediaSession$launchPushStreamTask$1(r100, r101);
        goto L8
    }
}
