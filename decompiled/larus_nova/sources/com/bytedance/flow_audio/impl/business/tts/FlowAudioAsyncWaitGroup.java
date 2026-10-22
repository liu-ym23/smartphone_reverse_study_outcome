package com.bytedance.flow_audio.impl.business.tts;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowAudioAsyncWaitGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f244059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Channel<Integer> f244060b;

    public FlowAudioAsyncWaitGroup() {
        this.f244060b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0059 -> B:22:0x005c). Please report as a decompilation issue!!! */
    public final Object a(Continuation<? super Unit> r100) {
        if ((r100 instanceof FlowAudioAsyncWaitGroup$wait$1) == false) goto L7;
        FlowAudioAsyncWaitGroup$wait$1 r101 = (FlowAudioAsyncWaitGroup$wait$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r101.I$1;
        int r107 = r101.I$0;
        ChannelIterator<Integer> r108 = (ChannelIterator) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L23:
        if (((Boolean) r103).booleanValue() == false) goto L29;
        r106 = r106 + r108.next().intValue();
        if (r106 >= r107) goto L27;
    L19:
        r101.L$0 = r108;
        r101.I$0 = r107;
        r101.I$1 = r106;
        r101.label = 1;
        r103 = r108.hasNext(r101);
        if (r103 != r104) goto L23;
        return r104;
    L27:
        return Unit.INSTANCE;
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        int r109 = this.f244059a;
        if (r109 <= 0) goto L17;
        r107 = r109;
        r108 = this.f244060b.iterator();
        r106 = 0;
        goto L19
    L17:
        return Unit.INSTANCE;
    L7:
        r101 = new FlowAudioAsyncWaitGroup$wait$1(this, r100);
        goto L8
    }
}
