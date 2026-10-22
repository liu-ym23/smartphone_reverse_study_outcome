package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowAsrAudioFrameSender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<rw5.d, Integer> f243738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zw5.a f243739b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowAsrAudioFrameSender(Function1<? super rw5.d, Integer> r100, zw5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "sendFrame");
        Intrinsics.checkNotNullParameter(r101, "logContext");
        this.f243738a = r100;
        this.f243739b = r101;
    }

    public final Object b(rw5.d r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof FlowAsrAudioFrameSender$send$1) == false) goto L7;
        FlowAsrAudioFrameSender$send$1 r102 = (FlowAsrAudioFrameSender$send$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (rw5.d) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        int r107 = ((Number) r104).intValue();
        if (r107 == 0) goto L20;
        IKMPLoggerService r108 = lp7.a.f510233a;
        lp7.a.b(e.f243969a, this.f243739b.a("send frame failed nativeCode=" + r107 + " size=" + r100.f539717b.length));
        throw new FlowAsrAudioFrameSendException(r107, r100.f539717b.length);
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r109 = this.f243738a.invoke(r100).intValue();
        r102.L$0 = r100;
        r102.label = 1;
        r104 = a(r100, r109, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new FlowAsrAudioFrameSender$send$1(this, r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0081 -> B:26:0x0084). Please report as a decompilation issue!!! */
    public final Object a(rw5.d r100, int r110, Continuation<? super Integer> r111) {
        if ((r111 instanceof FlowAsrAudioFrameSender$retryIfNeeded$1) == false) goto L7;
        FlowAsrAudioFrameSender$retryIfNeeded$1 r101 = (FlowAsrAudioFrameSender$retryIfNeeded$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r101.I$0;
        rw5.d r113 = (rw5.d) r101.L$0;
        ResultKt.throwOnFailure(r112);
        FlowAsrAudioFrameSender r106 = this;
    L26:
        int r114 = r106.f243738a.invoke(r113).intValue();
        if (r114 != 0) goto L29;
        IKMPLoggerService r107 = lp7.a.f510233a;
        lp7.a.c(e.f243969a, r106.f243739b.a("send frame retry success retryCount=" + (r105 + 1) + " size=" + r113.f539717b.length));
    L30:
        r110 = r114;
    L32:
        return Boxing.boxInt(r110);
    L29:
        r105 = r105 + 1;
    L22:
        if (r105 >= 3) goto L30;
        r101.L$0 = r113;
        r101.I$0 = r105;
        r101.label = 1;
        if (DelayKt.delay(100, r101) != r103) goto L26;
        return r103;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (r110 == 0) goto L17;
        IKMPLoggerService r108 = lp7.a.f510233a;
        lp7.a.d(e.f243969a, this.f243739b.a("send frame retry begin nativeCode=" + r110 + " size=" + r100.f539717b.length));
        if (r110 != 100013) goto L32;
        r106 = this;
        r114 = r110;
        r113 = r100;
        r105 = 0;
        goto L22
    L17:
        return Boxing.boxInt(0);
    L7:
        r101 = new FlowAsrAudioFrameSender$retryIfNeeded$1(this, r111);
        goto L8
    }
}
