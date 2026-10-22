package com.bytedance.ies.xelement.viewpager.childitem;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxTabbarItem$$PropsSetter extends UIGroup$$PropsSetter {
    public LynxTabbarItem$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxTabbarItem r103 = (LynxTabbarItem) r100;
        r101.getClass();
        if (r101.equals("select") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.setSelect(r102.b(r101, false));
    }
}
