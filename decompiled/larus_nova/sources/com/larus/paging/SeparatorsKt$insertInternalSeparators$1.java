package com.larus.paging;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.paging.SeparatorsKt", f = "Separators.kt", i = {0, 0, 0, 0, 0, 0}, l = {81}, m = "insertInternalSeparators", n = {"$this$insertInternalSeparators", "generator", "outputList", "outputIndices", MapController.ITEM_LAYER_TAG, RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
final class SeparatorsKt$insertInternalSeparators$1<R, T extends R> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    public SeparatorsKt$insertInternalSeparators$1(Continuation<? super SeparatorsKt$insertInternalSeparators$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        int r111 = this.label | Integer.MIN_VALUE;
        this.label = r111;
        if ((r111 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r111 - Integer.MIN_VALUE;
        SeparatorsKt$insertInternalSeparators$1<R, T> r112 = this;
    L6:
        Object r100 = r112.result;
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r112.label;
        if (r102 != 0) goto L9;
        ResultKt.throwOnFailure(r100);
        throw null;
    L9:
        if (r102 != 1) goto L24;
        int r103 = r112.I$1;
        int r104 = r112.I$0;
        Object r105 = r112.L$4;
        ArrayList r106 = (ArrayList) r112.L$3;
        ArrayList r107 = (ArrayList) r112.L$2;
        Function3 r108 = (Function3) r112.L$1;
        d1 r109 = (d1) r112.L$0;
        ResultKt.throwOnFailure(r100);
    L11:
        if (r100 == null) goto L13;
        r107.add(r100);
        r106.add(Boxing.boxInt(r104));
    L13:
        r107.add(r105);
        r106.add(Boxing.boxInt(r104));
        r104 = r104 + 1;
        if (r104 >= r103) goto L19;
        r105 = ListProtector.get(r109.f363803b, r104);
        Object r113 = ListProtector.get(r109.f363803b, r104 - 1);
        r112.L$0 = r109;
        r112.L$1 = r108;
        r112.L$2 = r107;
        r112.L$3 = r106;
        r112.L$4 = r105;
        r112.I$0 = r104;
        r112.I$1 = r103;
        r112.label = 1;
        r100 = r108.invoke(r113, r105, r112);
        if (r100 != r101) goto L11;
        return r101;
    L19:
        if (r107.size() != r109.f363803b.size()) goto L22;
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.larus.paging.TransformablePage<R of com.larus.paging.SeparatorsKt.insertInternalSeparators>");
        return r109;
    L22:
        return new d1(r109.f363802a, r107, r109.f363804c, r106);
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r112 = new SeparatorsKt$insertInternalSeparators$1(this);
        goto L6
    }
}
