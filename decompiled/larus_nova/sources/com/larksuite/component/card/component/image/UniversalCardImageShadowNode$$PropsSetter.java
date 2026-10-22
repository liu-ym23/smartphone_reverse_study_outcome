package com.larksuite.component.card.component.image;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes24.dex */
public class UniversalCardImageShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public UniversalCardImageShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        UniversalCardImageShadowNode r103 = (UniversalCardImageShadowNode) r100;
        r101.getClass();
        if (r101.equals(SlcElement.KEY_PROPS) == true) goto L6;
        super.a(r100, r101, r102);
        return;
    L6:
        r103.setContent(r102.g(r101));
    }
}
