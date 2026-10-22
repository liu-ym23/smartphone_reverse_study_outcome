package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import com.obric.assistant.omnidetailpage.localmedia.LocalMediaShareHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.blockview.LocalMediaViewHolder$saveMedia$1$saved$1", f = "TaskLocalMediaPreviewView.kt", i = {}, l = {670}, m = "invokeSuspend", n = {}, s = {})
public final class LocalMediaViewHolder$saveMedia$1$saved$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ifa.c $item;
    int label;
    final /* synthetic */ j this$0;

    public LocalMediaViewHolder$saveMedia$1$saved$1(j r100, ifa.c r101, Continuation<? super LocalMediaViewHolder$saveMedia$1$saved$1> r102) {
        this.this$0 = r100;
        this.$item = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LocalMediaViewHolder$saveMedia$1$saved$1(this.this$0, this.$item, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((LocalMediaViewHolder$saveMedia$1$saved$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        LocalMediaShareHelper r103 = LocalMediaShareHelper.f390800a;
        Context r104 = this.this$0.f390633a;
        ifa.c r105 = this.$item;
        this.label = 1;
        r100 = r103.b(r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
