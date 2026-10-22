package com.lynx.xelement.input;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUITextArea$$PropsSetter extends LynxUIBaseInput$$PropsSetter {
    public LynxUITextArea$$PropsSetter() {
    }

    @Override // com.lynx.xelement.input.LynxUIBaseInput$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxUITextArea r103 = (LynxUITextArea) r100;
        r101.getClass();
        if (r101.equals("maxlines") == false) goto L5;
        r103.setMaxLines(r102.f(r101, Integer.MAX_VALUE));
        return;
    L5:
        if (r101.equals("enable-scroll-bar") == true) goto L8;
        super.setProperty(r100, r101, r102);
        return;
    L8:
        r103.setEnableScrollBar(r102.b(r101, false));
    }
}
