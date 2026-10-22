package com.ss.android.lark.widget.richtext.utils;

import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/richtext/RichTextElement$RichTextProperty;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.widget.richtext.utils.ExtensionRichTextKt$copy$2", f = "ExtensionRichText.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ExtensionRichTextKt$copy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RichTextElement.RichTextProperty>, Object> {
    final /* synthetic */ RichTextElement.RichTextProperty $this_copy;
    int label;

    public ExtensionRichTextKt$copy$2(RichTextElement.RichTextProperty r100, Continuation<? super ExtensionRichTextKt$copy$2> r101) {
        this.$this_copy = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ExtensionRichTextKt$copy$2(this.$this_copy, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super RichTextElement.RichTextProperty> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super RichTextElement.RichTextProperty> r101) {
        return ((ExtensionRichTextKt$copy$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return a.a(this.$this_copy);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
