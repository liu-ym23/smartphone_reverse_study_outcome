package com.lynx.tasm.behavior.ui;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class LynxFlattenUI$$PropsSetter extends LynxBaseUI$$PropsSetter {
    public LynxFlattenUI$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxFlattenUI r103 = (LynxFlattenUI) r100;
        r101.getClass();
        if (r101.equals(GXTemplateKey.STYLE_OPACITY) == false) goto L5;
        r103.setAlpha(r102.e(r101, 1.0f));
        return;
    L5:
        if (r101.equals("transform") == true) goto L8;
        super.setProperty(r100, r101, r102);
        return;
    L8:
        r103.setTransform(r102.a(r101));
    }
}
