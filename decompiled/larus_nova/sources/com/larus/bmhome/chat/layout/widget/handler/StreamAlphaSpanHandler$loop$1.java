package com.larus.bmhome.chat.layout.widget.handler;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.handler.StreamAlphaSpanHandler$loop$1", f = "StreamAlphaSpanHandler.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class StreamAlphaSpanHandler$loop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public StreamAlphaSpanHandler$loop$1(Continuation<? super StreamAlphaSpanHandler$loop$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new StreamAlphaSpanHandler$loop$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((StreamAlphaSpanHandler$loop$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:12:0x0027). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
        StreamAlphaSpanHandler$loop$1 r111 = this;
    L12:
        int r102 = RangesKt.coerceAtLeast((int) ((255.0d / p.f305055e) * 33), 1);
        Map<String, p.a> r103 = p.f305052b;
        if (r103.isEmpty() == false) goto L16;
        p.f305054d = false;
        return Unit.INSTANCE;
    L16:
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = ((LinkedHashMap) r103).entrySet().iterator();
    L18:
        if (r105.hasNext() == false) goto L22;
        Map.Entry r106 = (Map.Entry) r105.next();
        if (((p.a) r106.getValue()).f305058c.isEmpty() == false) goto L18;
        r104.put(r106.getKey(), r106.getValue());
        goto L18
    L22:
        Iterator r107 = r104.entrySet().iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        p.f305052b.remove(((Map.Entry) r107.next()).getKey());
        goto L24
    L26:
        Iterator r108 = ((LinkedHashMap) p.f305052b).entrySet().iterator();
    L28:
        if (r108.hasNext() == false) goto L9;
        Map.Entry r109 = (Map.Entry) r108.next();
        String r112 = (String) r109.getKey();
        Iterator<Map.Entry<Integer, Integer>> r113 = ((p.a) r109.getValue()).f305058c.entrySet().iterator();
    L31:
        if (r113.hasNext() == false) goto L35;
        Map.Entry<Integer, Integer> r114 = r113.next();
        r114.setValue(Boxing.boxInt(r114.getValue().intValue() + r102));
        if (r114.getValue().intValue() < 255) goto L31;
        r113.remove();
        goto L31
    L35:
        p.a(r112);
    L9:
        r111.label = 1;
        if (DelayKt.delay(33, r111) != r100) goto L12;
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        r111 = this;
        goto L9
    }
}
