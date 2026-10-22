package com.bytedance.ies.xelement;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxSeekerManager$$PropsSetter extends LynxUI$$PropsSetter {
    public LynxSeekerManager$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxSeekerManager r103 = (LynxSeekerManager) r100;
        r101.getClass();
        if (r101.equals("duration") == false) goto L5;
        r103.setDuration(r102.f(r101, 0));
        return;
    L5:
        if (r101.equals("currentDuration") == true) goto L8;
        super.setProperty(r100, r101, r102);
        return;
    L8:
        r103.setProgress(r102.f(r101, 0));
    }
}
