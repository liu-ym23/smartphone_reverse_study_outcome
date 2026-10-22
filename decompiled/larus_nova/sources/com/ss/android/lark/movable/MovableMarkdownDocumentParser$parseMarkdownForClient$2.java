package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.ss.android.lark.movable.attatchment.m;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/movable/ParsedMovableDocument;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.movable.MovableMarkdownDocumentParser$parseMarkdownForClient$2", f = "MovableDocumentParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MovableMarkdownDocumentParser$parseMarkdownForClient$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ Function2<String, Float, m> $imageMeasureSizeResolver;
    final /* synthetic */ String $markdown;
    final /* synthetic */ MovableRenderConfig $movableRenderConfig;
    final /* synthetic */ MovableRenderUrlPreviewInlines $urlPreviewInlines;
    final /* synthetic */ float $widthDp;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MovableMarkdownDocumentParser$parseMarkdownForClient$2(String r100, float r101, MovableRenderConfig r102, MovableRenderUrlPreviewInlines r103, Function2<? super String, ? super Float, m> r104, Continuation<? super MovableMarkdownDocumentParser$parseMarkdownForClient$2> r105) {
        this.$markdown = r100;
        this.$widthDp = r101;
        this.$movableRenderConfig = r102;
        this.$urlPreviewInlines = r103;
        this.$imageMeasureSizeResolver = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MovableMarkdownDocumentParser$parseMarkdownForClient$2(this.$markdown, this.$widthDp, this.$movableRenderConfig, this.$urlPreviewInlines, this.$imageMeasureSizeResolver, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super h> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super h> r101) {
        return ((MovableMarkdownDocumentParser$parseMarkdownForClient$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        int r101 = MovableMarkdownDocumentParser.f432561a;
        return MovableMarkdownDocumentParser.a(this.$markdown, this.$widthDp, this.$movableRenderConfig, this.$urlPreviewInlines, this.$imageMeasureSizeResolver);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
