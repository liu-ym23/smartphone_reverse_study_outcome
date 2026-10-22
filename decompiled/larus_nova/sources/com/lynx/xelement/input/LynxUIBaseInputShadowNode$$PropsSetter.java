package com.lynx.xelement.input;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUIBaseInputShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public LynxUIBaseInputShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r100, String r101, x0 r102) {
        LynxUIBaseInputShadowNode r103 = (LynxUIBaseInputShadowNode) r100;
        r101.getClass();
        if (r101.equals(GXTemplateKey.GAIAX_LAYER_LINE_SPACING) == true) goto L6;
        super.a(r100, r101, r102);
        return;
    L6:
        r103.setLineSpacingStr(r102.d(r101));
    }
}
