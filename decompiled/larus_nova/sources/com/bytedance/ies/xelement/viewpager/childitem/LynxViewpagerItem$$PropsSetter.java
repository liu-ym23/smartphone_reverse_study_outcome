package com.bytedance.ies.xelement.viewpager.childitem;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxViewpagerItem$$PropsSetter extends UIGroup$$PropsSetter {
    public LynxViewpagerItem$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxViewpagerItem r103 = (LynxViewpagerItem) r100;
        r101.getClass();
        if (r101.equals("tag") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.setTag(r102.h(r101));
    }
}
