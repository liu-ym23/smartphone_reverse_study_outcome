package com.bytedance.ies.xelement.input;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxInputView$$PropsSetter extends LynxBaseInputView$$PropsSetter {
    public LynxInputView$$PropsSetter() {
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxInputView r103 = (LynxInputView) r100;
        r101.getClass();
        if (r101.equals("password") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.setIsPassword(r102.b(r101, false));
    }
}
