package com.bytedance.lark.lynxlib.behavior;

import com.bytedance.ies.xelement.text.inlinetext.LynxInlineTextShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: classes19.dex */
public final class j extends com.lynx.tasm.behavior.a {
    @Override // com.lynx.tasm.behavior.a
    public final ShadowNode createShadowNode() {
        return new LynxInlineTextShadowNode();
    }

    public j() {
        super("x-inline-text");
    }
}
