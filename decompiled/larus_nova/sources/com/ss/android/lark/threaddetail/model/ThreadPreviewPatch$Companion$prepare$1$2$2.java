package com.ss.android.lark.threaddetail.model;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ThreadPreviewPatch$Companion$prepare$1$2$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ RichTextElement.AnchorProperty $anchor;
    final /* synthetic */ RichTextElement $element;
    final /* synthetic */ String $elementId;
    final /* synthetic */ Map<String, PreviewHangPoint> $hangPoints;
    final /* synthetic */ PreviewHangPoint $point;
    final /* synthetic */ UrlCardPreviewEntity $previous;
    final /* synthetic */ RichText $richText;

    public ThreadPreviewPatch$Companion$prepare$1$2$2(Map<String, PreviewHangPoint> r100, String r101, PreviewHangPoint r102, UrlCardPreviewEntity r103, RichTextElement.AnchorProperty r104, RichText r105, RichTextElement r106) {
        this.$hangPoints = r100;
        this.$elementId = r101;
        this.$point = r102;
        this.$previous = r103;
        this.$anchor = r104;
        this.$richText = r105;
        this.$element = r106;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        PreviewHangPoint r100 = this.$hangPoints.get(this.$elementId);
        PreviewHangPoint r101 = this.$point;
        if (r100 == r101) goto L5;
    L23:
        boolean r102 = false;
    L25:
        return Boolean.valueOf(r102);
    L5:
        if (r101.getUrlCardPreviewEntity() != this.$previous) goto L23;
        if (this.$anchor == null) goto L22;
        RichText r103 = this.$richText;
        RichTextElement.RichTextProperty r104 = null;
        if (r103 == null) goto L15;
        RichText.RichTextElements r105 = r103.getElements();
        if (r105 == null) goto L15;
        Map<String, RichTextElement> r106 = r105.getDictionary();
        if (r106 == null) goto L15;
        RichTextElement r107 = r106.get(this.$elementId);
    L16:
        RichTextElement r108 = this.$element;
        if (r107 != r108) goto L23;
        if (r108 == null) goto L21;
        r104 = r108.getProperty();
    L21:
        if (r104 != this.$anchor) goto L23;
    L15:
        r107 = null;
    L22:
        r102 = true;
        goto L25
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
