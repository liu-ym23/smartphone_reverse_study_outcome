package com.lynx.xelement.blur;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUIBlurView$$PropsSetter extends UIView$$PropsSetter {
    public LynxUIBlurView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxUIBlurView r103 = (LynxUIBlurView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -866653701: goto L18;
            case -91134698: goto L14;
            case 681292984: goto L10;
            case 1574384313: goto L6;
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
        r103.setExperimentalUpdateBlurRadius(r102.b(r101, false));
        return;
    L26:
        r103.setBlurRadius(r102.h(r101));
        return;
    L28:
        r103.setCaptureTarget(r102.h(r101));
        return;
    L30:
        r103.setEnableAutoBlur(r102.b(r101, true));
        return;
    L6:
        if (r101.equals("experimental-update-blur-radius") == false) goto L21;
        r104 = 3;
        goto L21
    L10:
        if (r101.equals("blur-radius") == false) goto L21;
        r104 = 2;
        goto L21
    L14:
        if (r101.equals("android-capture-target") == false) goto L21;
        r104 = 1;
        goto L21
    L18:
        if (r101.equals("enable-auto-blur") == false) goto L21;
        r104 = 0;
        goto L21
    }
}
