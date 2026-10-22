package com.ss.android.lark.chat.cot.detail.blueprint.block;

import com.ss.android.lark.movable.MarkdownMovableView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CotMovableRenderDelegate$2 extends AdaptedFunctionReference implements Function2<String, Float, Unit> {
    public CotMovableRenderDelegate$2(Object r100) {
        super(2, r100, MarkdownMovableView.class, "renderMarkdown", "renderMarkdown(Ljava/lang/String;FLcom/bytedance/lark/lark_markdown_render_android/MovableRenderUrlPreviewInlines;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Float r101) {
        invoke(r100, r101.floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String r100, float r101) {
        MarkdownMovableView.k((MarkdownMovableView) this.receiver, r100, r101);
    }
}
