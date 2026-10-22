package com.bytedance.ies.xelement.input;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class AutoHeightInputShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public AutoHeightInputShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        AutoHeightInputShadowNode r103 = (AutoHeightInputShadowNode) r100;
        r101.getClass();
        if (r101.equals(GXTemplateKey.STYLE_FONT_SIZE) == true) goto L6;
        super.a(r100, r101, r102);
        return;
    L6:
        r103.setFontTextSize(r102.d(r101));
    }
}
