package com.larus.dora.impl.core.request.v2;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.dora.impl.frameassembler.DoraAggregateFrameAssembler;
import com.larus.dora.impl.frameassembler.DoraIncompleteReason;
import com.larus.dora.impl.frameassembler.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import vj4.d;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraRequestXV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraRequestXV2 f332240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f332241b = null;

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f332242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DoraAggregateFrameAssembler f332243b;

        public a(int r100, DoraAggregateFrameAssembler r101) {
            this.f332242a = r100;
            this.f332243b = r101;
        }

        @Override // vj4.d
        public final void a(long r110, int r111, int r112, int r113, int r114, byte[] r210, long r211, byte[] r212) {
            Intrinsics.checkNotNullParameter(r210, "data");
            Intrinsics.checkNotNullParameter(r212, "extra");
            if (r110 != this.f332242a) goto L6;
            this.f332243b.a(r110, r111, r112, r113, r114, r210, r211, r212);
            return;
        }
    }

    public static final class b implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraAggregateFrameAssembler f332244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<d> f332245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f332246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ vj4.c f332247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f332248e;

        public b(DoraAggregateFrameAssembler r100, Ref.ObjectRef<d> r101, int r102, vj4.c r103, long r104) {
            this.f332244a = r100;
            this.f332245b = r101;
            this.f332246c = r102;
            this.f332247d = r103;
            this.f332248e = r104;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            DoraRequestXV2.b(this.f332246c, this.f332247d, this.f332248e, true, "invokeOnCancellation");
            this.f332244a.shutdown();
            vj4.b.a.f555417a.c(this.f332245b.element);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements com.larus.dora.impl.frameassembler.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f332249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<d> f332250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i<com.larus.dora.impl.core.request.v2.a> f332251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f332252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ vj4.c f332253e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f332254f;

        @Override // com.larus.dora.impl.frameassembler.b
        public final void a(h r100, byte[] r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
            DoraRequestXV2.b(this.f332252d, this.f332253e, this.f332254f, false, LynxVideoManagerLite.EVENT_ON_PLAY_COMPLETED);
            if (this.f332249a.compareAndSet(false, true) == false) goto L6;
            vj4.b.a.f555417a.c(this.f332250b.element);
            i<com.larus.dora.impl.core.request.v2.a> r102 = this.f332251c;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(new com.larus.dora.impl.core.request.v2.a.b(r101)));
            return;
        }

        @Override // com.larus.dora.impl.frameassembler.b
        public final void b(h r100, DoraIncompleteReason r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "reason");
            DoraRequestXV2.b(this.f332252d, this.f332253e, this.f332254f, true, "onIncomplete, reason: " + r101);
            if (this.f332249a.compareAndSet(false, true) == false) goto L6;
            vj4.b.a.f555417a.c(this.f332250b.element);
            i<com.larus.dora.impl.core.request.v2.a> r102 = this.f332251c;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(new com.larus.dora.impl.core.request.v2.a.C4213a(new RuntimeException("onIncomplete, reason: " + r101))));
            return;
        }

        @Override // com.larus.dora.impl.frameassembler.b
        public final void c(h r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "error");
            DoraRequestXV2.b(this.f332252d, this.f332253e, this.f332254f, true, "onError, error: " + r101);
            if (this.f332249a.compareAndSet(false, true) == false) goto L6;
            vj4.b.a.f555417a.c(this.f332250b.element);
            i<com.larus.dora.impl.core.request.v2.a> r102 = this.f332251c;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(new com.larus.dora.impl.core.request.v2.a.C4213a(r101)));
            return;
        }

        public c(AtomicBoolean r100, Ref.ObjectRef r101, j r102, int r103, vj4.c r104, long r105) {
            this.f332249a = r100;
            this.f332250b = r101;
            this.f332251c = r102;
            this.f332252d = r103;
            this.f332253e = r104;
            this.f332254f = r105;
        }
    }

    public DoraRequestXV2() {
    }

    static {
        f332240a = new DoraRequestXV2();
        f332241b = new AtomicInteger(0);
    }

    public final Object a(vj4.c r110, long r111, Continuation<? super com.larus.dora.impl.core.request.v2.a> r112) {
        if ((r112 instanceof DoraRequestXV2$requestV2$1) == false) goto L7;
        DoraRequestXV2$requestV2$1 r100 = (DoraRequestXV2$requestV2$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        com.larus.dora.impl.core.request.v2.a r114 = (com.larus.dora.impl.core.request.v2.a) r113;
        if (r114 == null) goto L20;
        return r114;
    L20:
        return new com.larus.dora.impl.core.request.v2.a.C4213a(new RuntimeException("requestV2 timeout"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        DoraRequestXV2$requestV2$$inlined$suspendCoroutineWithTimeoutOrNull$1 r115 = new DoraRequestXV2$requestV2$$inlined$suspendCoroutineWithTimeoutOrNull$1(null, f332241b.incrementAndGet(), r110, new AtomicBoolean(false), SystemClock.elapsedRealtime());
        r100.label = 1;
        r113 = TimeoutKt.c(r111, r115, r100);
        if (r113 != r102) goto L17;
        return r102;
    L7:
        r100 = new DoraRequestXV2$requestV2$1(this, r112);
        goto L8
    }

    public static final void b(int r100, vj4.c r101, long r102, boolean r103, String r104) {
        if (r103 == false) goto L5;
        g49.d.e("DoraRequestXV2", "id: " + r100 + ", " + r101 + ", " + r104 + ", cost: " + (SystemClock.elapsedRealtime() - r102));
        return;
    L5:
        g49.d.d("DoraRequestXV2", "id: " + r100 + ", " + r101 + ", " + r104 + ", cost: " + (SystemClock.elapsedRealtime() - r102));
    }
}
