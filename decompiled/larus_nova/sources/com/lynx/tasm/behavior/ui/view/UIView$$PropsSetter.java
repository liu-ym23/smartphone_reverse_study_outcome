package com.lynx.tasm.behavior.ui.view;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class UIView$$PropsSetter extends UISimpleView$$PropsSetter {
    public UIView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        UIView r103 = (UIView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1389119727: goto L18;
            case -505576881: goto L14;
            case -400775539: goto L10;
            case 327124377: goto L6;
            default: goto L21;
        };
    L21:
        switch(r104) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        super.setProperty(r100, r101, r102);
        return;
    L24:
        r103.setBlurAutoUpdate(r102.b(r101, true));
        return;
    L26:
        r103.setBlurSampling(r102.f(r101, 0));
        return;
    L28:
        r103.copyable(r102.b(r101, false));
        return;
    L30:
        r103.setImpressionId(r102.h(r101));
        return;
    L6:
        if (r101.equals("android-enable-auto-blur") == false) goto L21;
        r104 = 3;
        goto L21
    L10:
        if (r101.equals("blur-sampling") == false) goto L21;
        r104 = 2;
        goto L21
    L14:
        if (r101.equals("copyable") == false) goto L21;
        r104 = 1;
        goto L21
    L18:
        if (r101.equals("impression_id") == false) goto L21;
        r104 = 0;
        goto L21
    }
}
