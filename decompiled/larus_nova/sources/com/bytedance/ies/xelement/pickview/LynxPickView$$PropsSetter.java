package com.bytedance.ies.xelement.pickview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxPickView$$PropsSetter extends UIView$$PropsSetter {
    public LynxPickView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxPickView r103 = (LynxPickView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -208291852: goto L14;
            case 1256871824: goto L10;
            case 2065426547: goto L6;
            default: goto L17;
        };
    L17:
        switch(r104) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.setProperty(r100, r101, r102);
        return;
    L20:
        r103.setIndicatorStyle(r102.h(r101));
        return;
    L22:
        r103.setMaskStyle(r102.h(r101));
        return;
    L24:
        r103.setVisibleCount(r102.h(r101));
        return;
    L6:
        if (r101.equals("indicator-style") == false) goto L17;
        r104 = 2;
        goto L17
    L10:
        if (r101.equals("mask-style") == false) goto L17;
        r104 = 1;
        goto L17
    L14:
        if (r101.equals("visible-count") == false) goto L17;
        r104 = 0;
        goto L17
    }
}
