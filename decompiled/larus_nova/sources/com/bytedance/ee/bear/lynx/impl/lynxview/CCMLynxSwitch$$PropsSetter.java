package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes18.dex */
public class CCMLynxSwitch$$PropsSetter extends LynxUI$$PropsSetter {
    public CCMLynxSwitch$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        CCMLynxSwitch r103 = (CCMLynxSwitch) r100;
        r101.getClass();
        if (r101.equals("is-enabled") == false) goto L5;
        r103.setEnable(r102.b(r101, false));
        return;
    L5:
        if (r101.equals("is-on") == true) goto L8;
        super.setProperty(r100, r101, r102);
        return;
    L8:
        r103.setChecked(r102.b(r101, false));
    }
}
