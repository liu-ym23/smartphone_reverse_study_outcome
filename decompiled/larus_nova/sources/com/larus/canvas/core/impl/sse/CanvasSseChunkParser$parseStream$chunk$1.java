package com.larus.canvas.core.impl.sse;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/canvas/core/impl/sse/CanvasChunkPackage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.sse.CanvasSseChunkParser$parseStream$chunk$1", f = "CanvasSseChunkParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasSseChunkParser$parseStream$chunk$1 extends SuspendLambda implements Function1<Continuation<? super b>, Object> {
    final /* synthetic */ BufferedSource $buffer;
    int label;
    final /* synthetic */ CanvasSseChunkParser this$0;

    public CanvasSseChunkParser$parseStream$chunk$1(CanvasSseChunkParser r100, BufferedSource r101, Continuation<? super CanvasSseChunkParser$parseStream$chunk$1> r102) {
        this.this$0 = r100;
        this.$buffer = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new CanvasSseChunkParser$parseStream$chunk$1(this.this$0, this.$buffer, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super b> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super b> r100) {
        return ((CanvasSseChunkParser$parseStream$chunk$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r110);
        CanvasSseChunkParser r111 = this.this$0;
        BufferedSource r100 = this.$buffer;
        int r101 = CanvasSseChunkParser.f322955b;
        r111.getClass();
    L5:
        String r112 = r100.readUtf8Line();
        if (r112 == null) goto L37;
        String r113 = StringsKt.trim(r112).toString();
        if (r113 == null) goto L37;
        if ((!StringsKt.isBlank(r113)) == false) goto L5;
        StringBuilder r102 = new StringBuilder();
        String r103 = "json";
    L13:
        if (r113 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L35;
        int r105 = StringsKt.indexOf$default(r113, ":", 0, false, 6, null);
        if (r105 < 0) goto L21;
        String r106 = StringsKt.trim(r113.substring(0, r105)).toString();
        String r114 = StringsKt.trim(r113.substring(r105 + 1)).toString();
        if ((!StringsKt.isBlank(r114)) == false) goto L31;
        if (Intrinsics.areEqual(r106, "event") == false) goto L28;
        r103 = r114;
        goto L31
    L28:
        if (Intrinsics.areEqual(r106, "data") == false) goto L31;
        r102.append(r114);
    L31:
        if (Intrinsics.areEqual(r103, "done") == true) goto L35;
        r113 = r100.readUtf8Line();
        goto L13
    L21:
        r113 = r100.readUtf8Line();
    L35:
        return new b(r103, r102.toString());
    L15:
        if ((!StringsKt.isBlank(r113)) != true) goto L17;
        r104 = true;
    L37:
        throw new CanvasSseChunkParser.ReadChunkException("stream ended", null);
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
