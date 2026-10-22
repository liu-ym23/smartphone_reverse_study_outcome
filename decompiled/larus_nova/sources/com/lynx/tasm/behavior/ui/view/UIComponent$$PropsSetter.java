package com.lynx.tasm.behavior.ui.view;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class UIComponent$$PropsSetter extends UIView$$PropsSetter {
    public UIComponent$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        UIComponent r103 = (UIComponent) r100;
        r101.getClass();
        if (r101.equals("z-index") == false) goto L5;
        r103.setZIndex(r102.f(r101, 0));
        return;
    L5:
        if (r101.equals("item-key") == true) goto L8;
        super.setProperty(r100, r101, r102);
        return;
    L8:
        r103.setItemKey(r102.h(r101));
    }
}
