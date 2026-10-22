package com.ss.android.lark.picker.doubao.view.pickercommon;

import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterTagState;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher$flushPending$result$1$1", f = "DoubaoChatterTagEnricher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoChatterTagEnricher$flushPending$result$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends DoubaoLocalChatterTagState>>, Object> {
    final /* synthetic */ List<String> $ids;
    final /* synthetic */ DoubaoChatterTagEnricher $this_runCatching;
    int label;

    public DoubaoChatterTagEnricher$flushPending$result$1$1(DoubaoChatterTagEnricher r100, List<String> r101, Continuation<? super DoubaoChatterTagEnricher$flushPending$result$1$1> r102) {
        this.$this_runCatching = r100;
        this.$ids = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoubaoChatterTagEnricher$flushPending$result$1$1(this.$this_runCatching, this.$ids, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Map<String, ? extends DoubaoLocalChatterTagState>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Map<String, DoubaoLocalChatterTagState>> r101) {
        return ((DoubaoChatterTagEnricher$flushPending$result$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return DoubaoChatterTagEnricher.access$getProvider$p(this.$this_runCatching).getTagStatesByChatterIds(this.$ids);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
