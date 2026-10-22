package com.bytedance.ies.xelement.text.inlinetext;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxInlineTextShadowNode$$PropsSetter extends InlineTextShadowNode$$PropsSetter {
    public LynxInlineTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        LynxInlineTextShadowNode r103 = (LynxInlineTextShadowNode) r100;
        r101.getClass();
        if (r101.equals("no-trim") == true) goto L6;
        super.a(r100, r101, r102);
        return;
    L6:
        r103.setNoTrim(r102.b(r101, true));
    }
}
