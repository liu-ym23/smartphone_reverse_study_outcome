package com.larus.bmhome.chat.markdown.code;

import com.larus.bmhome.chat.markdown.code.render.CodeRenderApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/markdown/code/render/CodeRenderResponse;", "Lcom/larus/bmhome/chat/markdown/code/render/CodeRenderApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.MarkdownCodePreviewer$requestCodeRenderImage$1$response$1", f = "MarkdownCodePreviewer.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class MarkdownCodePreviewer$requestCodeRenderImage$1$response$1 extends SuspendLambda implements Function2<CodeRenderApi, Continuation<? super BizResponse<ih8.b>>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ Integer $height;
    final /* synthetic */ String $language;
    final /* synthetic */ String $theme;
    final /* synthetic */ Integer $width;
    private /* synthetic */ Object L$0;
    int label;

    public MarkdownCodePreviewer$requestCodeRenderImage$1$response$1(String r100, String r101, String r102, Integer r103, Integer r104, Continuation<? super MarkdownCodePreviewer$requestCodeRenderImage$1$response$1> r105) {
        this.$code = r100;
        this.$language = r101;
        this.$theme = r102;
        this.$width = r103;
        this.$height = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        MarkdownCodePreviewer$requestCodeRenderImage$1$response$1 r101 = new MarkdownCodePreviewer$requestCodeRenderImage$1$response$1(this.$code, this.$language, this.$theme, this.$width, this.$height, r110);
        r101.L$0 = r100;
        return r101;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CodeRenderApi r100, Continuation<? super BizResponse<ih8.b>> r101) {
        return ((MarkdownCodePreviewer$requestCodeRenderImage$1$response$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CodeRenderApi r100, Continuation<? super BizResponse<ih8.b>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L11:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        CodeRenderApi r111 = (CodeRenderApi) this.L$0;
        ih8.a r102 = new ih8.a(this.$code, this.$language, this.$theme, this.$width, this.$height);
        this.label = 1;
        r110 = r111.codeRenderImage(r102, this);
        if (r110 != r100) goto L11;
        return r100;
    }
}
