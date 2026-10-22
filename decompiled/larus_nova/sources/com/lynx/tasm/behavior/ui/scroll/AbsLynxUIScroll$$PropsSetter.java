package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class AbsLynxUIScroll$$PropsSetter extends UISimpleView$$PropsSetter {
    public AbsLynxUIScroll$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        AbsLynxUIScroll r103 = (AbsLynxUIScroll) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -2039913758: goto L54;
            case -2032847360: goto L50;
            case -1571036001: goto L46;
            case -445000626: goto L42;
            case -402166408: goto L38;
            case -402166407: goto L34;
            case -169901481: goto L30;
            case 65137827: goto L26;
            case 65138261: goto L22;
            case 257565167: goto L18;
            case 660290816: goto L14;
            case 1751260029: goto L10;
            case 2019037959: goto L6;
            default: goto L57;
        };
    L57:
        switch(r104) {
            case 0: goto L84;
            case 1: goto L82;
            case 2: goto L80;
            case 3: goto L78;
            case 4: goto L76;
            case 5: goto L74;
            case 6: goto L72;
            case 7: goto L70;
            case 8: goto L68;
            case 9: goto L66;
            case 10: goto L64;
            case 11: goto L62;
            case 12: goto L60;
            default: goto L58;
        };
    L58:
        super.setProperty(r100, r101, r102);
        return;
    L60:
        r103.setScrollLeft(r102.f(r101, 0));
        return;
    L62:
        r103.setScrollBarEnable(r102.b(r101, false));
        return;
    L64:
        r103.setUpperThreshole(r102.f(r101, 0));
        return;
    L66:
        r103.setForbidFlingFocusChange(r102.b(r101, false));
        return;
    L68:
        r103.setScrollTop(r102.f(r101, 0));
        return;
    L70:
        r103.setScrollTap(r102.b(r101, false));
        return;
    L72:
        r103.setEnableScroll(r102.b(r101, true));
        return;
    L74:
        r103.setScrollY(r102.d(r101));
        return;
    L76:
        r103.setScrollX(r102.d(r101));
        return;
    L78:
        r103.setEnableNewNested(r102.b(r101, false));
        return;
    L80:
        r103.setLowerThreshole(r102.f(r101, 0));
        return;
    L82:
        r103.scrollToIndex(r102.f(r101, 0));
        return;
    L84:
        r103.setBlockDescendantFocusability(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("scroll-left") == false) goto L57;
        r104 = 12;
        goto L57
    L10:
        if (r101.equals("scroll-bar-enable") == false) goto L57;
        r104 = 11;
        goto L57
    L14:
        if (r101.equals("upper-threshold") == false) goto L57;
        r104 = 10;
        goto L57
    L18:
        if (r101.equals("forbid-fling-focus-change") == false) goto L57;
        r104 = 9;
        goto L57
    L22:
        if (r101.equals("scroll-top") == false) goto L57;
        r104 = 8;
        goto L57
    L26:
        if (r101.equals("scroll-tap") == false) goto L57;
        r104 = 7;
        goto L57
    L30:
        if (r101.equals("enable-scroll") == false) goto L57;
        r104 = 6;
        goto L57
    L34:
        if (r101.equals("scroll-y") == false) goto L57;
        r104 = 5;
        goto L57
    L38:
        if (r101.equals("scroll-x") == false) goto L57;
        r104 = 4;
        goto L57
    L42:
        if (r101.equals("enable-new-nested") == false) goto L57;
        r104 = 3;
        goto L57
    L46:
        if (r101.equals("lower-threshold") == false) goto L57;
        r104 = 2;
        goto L57
    L50:
        if (r101.equals("scroll-to-index") == false) goto L57;
        r104 = 1;
        goto L57
    L54:
        if (r101.equals("block-descendant-focusability") == false) goto L57;
        r104 = 0;
        goto L57
    }
}
