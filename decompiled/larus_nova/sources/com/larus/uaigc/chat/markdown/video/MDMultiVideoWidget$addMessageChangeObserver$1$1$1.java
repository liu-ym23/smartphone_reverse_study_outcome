package com.larus.uaigc.chat.markdown.video;

import android.text.Spanned;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.MDMultiVideoWidget$addMessageChangeObserver$1$1$1", f = "MDMultiVideoWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MDMultiVideoWidget$addMessageChangeObserver$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $maxWidth;
    final /* synthetic */ usc.e $span;
    final /* synthetic */ Spanned $text;
    final /* synthetic */ TextView $textView;
    int label;
    final /* synthetic */ MDMultiVideoWidget this$0;

    public MDMultiVideoWidget$addMessageChangeObserver$1$1$1(MDMultiVideoWidget r100, TextView r101, Spanned r102, usc.e r103, int r104, Continuation<? super MDMultiVideoWidget$addMessageChangeObserver$1$1$1> r105) {
        this.this$0 = r100;
        this.$textView = r101;
        this.$text = r102;
        this.$span = r103;
        this.$maxWidth = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MDMultiVideoWidget$addMessageChangeObserver$1$1$1(this.this$0, this.$textView, this.$text, this.$span, this.$maxWidth, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MDMultiVideoWidget$addMessageChangeObserver$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        MDMultiVideoWidget r101 = this.this$0;
        TextView r102 = this.$textView;
        Spanned r103 = this.$text;
        usc.e r104 = this.$span;
        int r105 = this.$maxWidth;
        int r106 = MDMultiVideoWidget.f371182w;
        r101.e(r102, r103, r104, r105);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
