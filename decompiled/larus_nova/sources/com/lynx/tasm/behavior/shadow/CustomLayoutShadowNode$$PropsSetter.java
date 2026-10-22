package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class CustomLayoutShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public CustomLayoutShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r100, String r101, x0 r102) {
        CustomLayoutShadowNode r103 = (CustomLayoutShadowNode) r100;
        r101.getClass();
        if (r101.equals("custom-layout") == true) goto L6;
        super.a(r100, r101, r102);
        return;
    L6:
        r103.setCustomLayout(r102.b(r101, false));
    }
}
