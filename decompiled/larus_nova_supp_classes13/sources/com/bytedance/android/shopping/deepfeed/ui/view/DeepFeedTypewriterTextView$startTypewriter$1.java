package com.bytedance.android.shopping.deepfeed.ui.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedTypewriterTextView$startTypewriter$1", f = "DeepFeedTypewriterTextView.kt", i = {0}, l = {61}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
final class DeepFeedTypewriterTextView$startTypewriter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $boldEnd;
    final /* synthetic */ int $boldStart;
    final /* synthetic */ long $charDelay;
    final /* synthetic */ String $cursor;
    final /* synthetic */ String $fullText;
    final /* synthetic */ Function0 $onFinish;
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ DeepFeedTypewriterTextView this$0;

    public DeepFeedTypewriterTextView$startTypewriter$1(DeepFeedTypewriterTextView r1, String r2, int r3, int r4, String r5, long r6, Function0 r8, Continuation r9) {
        this.this$0 = r1;
        this.$fullText = r2;
        this.$boldStart = r3;
        this.$boldEnd = r4;
        this.$cursor = r5;
        this.$charDelay = r6;
        this.$onFinish = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        Intrinsics.checkNotNullParameter(r12, "completion");
        return new DeepFeedTypewriterTextView$startTypewriter$1(this.this$0, this.$fullText, this.$boldStart, this.$boldEnd, this.$cursor, this.$charDelay, this.$onFinish, r12);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [android.widget.TextView, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedTypewriterTextView] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.widget.TextView, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedTypewriterTextView] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0050 -> B:16:0x0053). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r12);
        DeepFeedTypewriterTextView$startTypewriter$1 r13 = this;
    L16:
        if (r3 == r2) goto L21;
        r3 = r3 + 1;
    L11:
        ?? r10 = r13.this$0;
        String r4 = r13.$fullText;
        if (r4 == null) goto L19;
        r10.setText(DeepFeedTypewriterTextView.x(r10, r4.substring(0, r3), r13.$boldStart, r13.$boldEnd, r13.$cursor, true));
        long r5 = r13.$charDelay;
        r13.I$0 = r3;
        r13.I$1 = r2;
        r13.label = 1;
        if (DelayKt.delay(r5, r13) != r0) goto L16;
        return r0;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L21:
        ?? r6 = r13.this$0;
        r6.setText(DeepFeedTypewriterTextView.x(r6, r13.$fullText, r13.$boldStart, r13.$boldEnd, r13.$cursor, false));
        Function0 r14 = r13.$onFinish;
        if (r14 == null) goto L25;
        Unit r15 = (Unit) r14.invoke();
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        int r16 = this.$fullText.length();
        if (1 > r16) goto L20;
        r3 = 1;
        r2 = r16;
        r13 = this;
        goto L11
    L20:
        r13 = this;
        goto L21
    }
}
