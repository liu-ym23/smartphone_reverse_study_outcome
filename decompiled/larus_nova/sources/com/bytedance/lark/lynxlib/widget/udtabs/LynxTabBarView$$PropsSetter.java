package com.bytedance.lark.lynxlib.widget.udtabs;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxTabBarView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxTabBarView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxTabBarView r103 = (LynxTabBarView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -953347877: goto L18;
            case -887638045: goto L14;
            case 1027794903: goto L10;
            case 1939577734: goto L6;
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
        r103.setIndicatorFullWidth(r102.b(r101, false));
        return;
    L26:
        r103.setDisableAttachEvent(r102.b(r101, false));
        return;
    L28:
        r103.setTabLayoutGravity(r102.h(r101));
        return;
    L30:
        r103.setTabMode(r102.h(r101));
        return;
    L6:
        if (r101.equals("indicator-full-width") == false) goto L21;
        r104 = 3;
        goto L21
    L10:
        if (r101.equals("disable-attach-event") == false) goto L21;
        r104 = 2;
        goto L21
    L14:
        if (r101.equals("tab-layout-gravity") == false) goto L21;
        r104 = 1;
        goto L21
    L18:
        if (r101.equals("tab-mode") == false) goto L21;
        r104 = 0;
        goto L21
    }
}
