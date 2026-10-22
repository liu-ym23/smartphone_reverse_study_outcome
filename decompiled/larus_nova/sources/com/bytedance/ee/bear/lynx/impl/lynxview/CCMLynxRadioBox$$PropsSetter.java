package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes18.dex */
public class CCMLynxRadioBox$$PropsSetter extends LynxUI$$PropsSetter {
    public CCMLynxRadioBox$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        CCMLynxRadioBox r103 = (CCMLynxRadioBox) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1964681502: goto L26;
            case -1735887358: goto L22;
            case -1350454882: goto L18;
            case -342264874: goto L14;
            case 3575610: goto L10;
            case 1001453060: goto L6;
            default: goto L29;
        };
    L29:
        switch(r104) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            default: goto L30;
        };
    L30:
        super.setProperty(r100, r101, r102);
        return;
    L32:
        r103.setChecked(r102.b(r101, false));
        return;
    L34:
        r103.setType(r102.h(r101));
        return;
    L36:
        r103.setLargeSize(r102.b(r101, false));
        return;
    L38:
        r103.setEnable(r102.b(r101, false));
        return;
    L40:
        r103.setUnCheckBackgroundColor(r102.h(r101));
        return;
    L42:
        r103.setClickable(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("is-checked") == false) goto L29;
        r104 = 5;
        goto L29
    L10:
        if (r101.equals("type") == false) goto L29;
        r104 = 4;
        goto L29
    L14:
        if (r101.equals("is-large-size") == false) goto L29;
        r104 = 3;
        goto L29
    L18:
        if (r101.equals("is-enabled") == false) goto L29;
        r104 = 2;
        goto L29
    L22:
        if (r101.equals("uncheck-background-color") == false) goto L29;
        r104 = 1;
        goto L29
    L26:
        if (r101.equals("clickable") == false) goto L29;
        r104 = 0;
        goto L29
    }
}
