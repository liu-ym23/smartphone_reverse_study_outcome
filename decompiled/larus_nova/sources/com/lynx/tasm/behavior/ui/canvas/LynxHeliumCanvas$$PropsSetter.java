package com.lynx.tasm.behavior.ui.canvas;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class LynxHeliumCanvas$$PropsSetter extends LynxUI$$PropsSetter {
    public LynxHeliumCanvas$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxHeliumCanvas r103 = (LynxHeliumCanvas) r100;
        r101.getClass();
        if (r101.equals("consume-android-events") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.setConsumeAllEvents(r102.b(r101, false));
    }
}
