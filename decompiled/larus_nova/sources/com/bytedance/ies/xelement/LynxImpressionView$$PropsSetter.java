package com.bytedance.ies.xelement;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxImpressionView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxImpressionView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxImpressionView r103 = (LynxImpressionView) r100;
        r101.getClass();
        if (r101.equals("impression-percent") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.impressionPercent(r102.f(r101, 0));
    }
}
