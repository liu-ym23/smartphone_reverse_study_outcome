package com.bytedance.ies.xelement.viewpager.foldview;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class BaseLynxFoldView$$PropsSetter extends UISimpleView$$PropsSetter {
    public BaseLynxFoldView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        BaseLynxFoldView r103 = (BaseLynxFoldView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1662739435: goto L18;
            case -1221994365: goto L14;
            case -169901481: goto L10;
            case 1819831630: goto L6;
            default: goto L21;
        };
    L21:
        switch(r104) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        super.setProperty(r100, r101, r102);
        return;
    L24:
        r103.setGranularity(r102.e(r101, 0.01f));
        return;
    L26:
        r103.setEnableScroll(r102.b(r101, true));
        return;
    L28:
        r103.setScrollEnable(r102.b(r101, true));
        return;
    L30:
        r103.setCompatContainerPopup(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("granularity") == false) goto L21;
        r104 = 3;
        goto L21
    L10:
        if (r101.equals("enable-scroll") == false) goto L21;
        r104 = 2;
        goto L21
    L14:
        if (r101.equals(GXTemplateKey.GAIAX_LAYER_SCROLL_ENABLE) == false) goto L21;
        r104 = 1;
        goto L21
    L18:
        if (r101.equals("compat-container-popup") == false) goto L21;
        r104 = 0;
        goto L21
    }
}
