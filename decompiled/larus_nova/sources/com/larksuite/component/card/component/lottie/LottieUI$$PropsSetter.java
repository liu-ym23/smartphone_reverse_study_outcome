package com.larksuite.component.card.component.lottie;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes24.dex */
public class LottieUI$$PropsSetter extends LynxUI$$PropsSetter {
    public LottieUI$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LottieUI r103 = (LottieUI) r100;
        r101.getClass();
        if (r101.equals("src") == true) goto L6;
        super.setProperty(r100, r101, r102);
        return;
    L6:
        r103.setSrc(r102.h(r101));
    }
}
