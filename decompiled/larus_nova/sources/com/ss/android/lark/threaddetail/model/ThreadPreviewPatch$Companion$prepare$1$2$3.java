package com.ss.android.lark.threaddetail.model;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ThreadPreviewPatch$Companion$prepare$1$2$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RichTextElement $element;
    final /* synthetic */ PreviewHangPoint $point;
    final /* synthetic */ RichTextElement.AnchorProperty $preparedAnchor;
    final /* synthetic */ PreviewHangPoint $preparedPoint;

    public ThreadPreviewPatch$Companion$prepare$1$2$3(PreviewHangPoint r100, PreviewHangPoint r101, RichTextElement.AnchorProperty r102, RichTextElement r103) {
        this.$point = r100;
        this.$preparedPoint = r101;
        this.$preparedAnchor = r102;
        this.$element = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$point.setUrlCardPreviewEntity(this.$preparedPoint.getUrlCardPreviewEntity());
        RichTextElement.AnchorProperty r100 = this.$preparedAnchor;
        if (r100 == null) goto L8;
        RichTextElement r101 = this.$element;
        if (r101 == null) goto L9;
        r101.setProperty(r100);
        return;
    L9:
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
