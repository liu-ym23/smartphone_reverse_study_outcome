package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class FrescoInlineImageShadowNode$$PropsSetter extends AbsInlineImageShadowNode$$PropsSetter {
    public FrescoInlineImageShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r100, String r101, x0 r102) {
        FrescoInlineImageShadowNode r103 = (FrescoInlineImageShadowNode) r100;
        r101.getClass();
        if (r101.equals("skip-redirection") == false) goto L5;
        r103.setSkipRedirection(r102.b(r101, false));
        return;
    L5:
        if (r101.equals("loop-count") == true) goto L8;
        super.a(r100, r101, r102);
        return;
    L8:
        r103.setLoopCount(r102.f(r101, 0));
    }
}
