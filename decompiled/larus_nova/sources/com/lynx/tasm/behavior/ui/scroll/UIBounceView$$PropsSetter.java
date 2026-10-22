package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class UIBounceView$$PropsSetter extends UISimpleView$$PropsSetter {
    public UIBounceView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        UIBounceView r103 = (UIBounceView) r100;
        r101.getClass();
        if (r101.equals("direction") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.setDirection(r102.d(r101));
    }
}
