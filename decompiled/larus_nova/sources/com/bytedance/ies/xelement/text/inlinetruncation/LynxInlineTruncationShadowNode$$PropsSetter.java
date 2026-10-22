package com.bytedance.ies.xelement.text.inlinetruncation;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxInlineTruncationShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public LynxInlineTruncationShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        LynxInlineTruncationShadowNode r103 = (LynxInlineTruncationShadowNode) r100;
        r101.getClass();
        if (r101.equals("stick") == true) goto L6;
        super.a(r100, r101, r102);
        return;
    L6:
        r103.setStick(r102.b(r101, false));
    }
}
