package com.bytedance.ies.xelement.text.inlineimage;

import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.ui.text.a;
import com.lynx.tasm.ui.image.FrescoInlineImageShadowNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@LynxShadowNode(tagName = "x-inline-image")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xelement/text/inlineimage/LynxInlineImageShadowNode;", "Lcom/lynx/tasm/ui/image/FrescoInlineImageShadowNode;", "<init>", "()V", "x-element-text_release"}, k = 1, mv = {1, 6, 0})
public final class LynxInlineImageShadowNode extends FrescoInlineImageShadowNode {
    public LynxInlineImageShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void S(a r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
        r100.f570552a = 11;
        r100.f570553b = 0.0f;
    }
}
