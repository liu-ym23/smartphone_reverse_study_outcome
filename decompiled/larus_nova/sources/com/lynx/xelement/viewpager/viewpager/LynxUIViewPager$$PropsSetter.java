package com.lynx.xelement.viewpager.viewpager;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUIViewPager$$PropsSetter extends BaseLynxViewPager$$PropsSetter {
    public LynxUIViewPager$$PropsSetter() {
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager$$PropsSetter, com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxUIViewPager r103 = (LynxUIViewPager) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -2087292118: goto L30;
            case -1926922070: goto L26;
            case -1705023195: goto L22;
            case -1504749759: goto L18;
            case -169901481: goto L14;
            case 504748326: goto L10;
            case 2126196810: goto L6;
            default: goto L33;
        };
    L33:
        switch(r104) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            default: goto L34;
        };
    L34:
        super.setProperty(r100, r101, r102);
        return;
    L36:
        r103.setDistinguishSwipeTap(r102.b(r101, true));
        return;
    L38:
        r103.setSinglePageTouch(r102.b(r101, false));
        return;
    L40:
        r103.setEnableScroll(r102.b(r101, false));
        return;
    L42:
        r103.setAndroidAlwaysOverscroll(r102.b(r101, false));
        return;
    L44:
        r103.setPageChangeAnimation(r102.b(r101, false));
        return;
    L46:
        r103.setInitialSelect(r102.f(r101, 0));
        return;
    L48:
        r103.setForceCanScroll(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("android-distinguish-swipe-tap") == false) goto L33;
        r104 = 6;
        goto L33
    L10:
        if (r101.equals("single-page-touch") == false) goto L33;
        r104 = 5;
        goto L33
    L14:
        if (r101.equals("enable-scroll") == false) goto L33;
        r104 = 4;
        goto L33
    L18:
        if (r101.equals("android-always-overscroll") == false) goto L33;
        r104 = 3;
        goto L33
    L22:
        if (r101.equals("page-change-animation") == false) goto L33;
        r104 = 2;
        goto L33
    L26:
        if (r101.equals("initial-select-index") == false) goto L33;
        r104 = 1;
        goto L33
    L30:
        if (r101.equals("android-force-can-scroll") == false) goto L33;
        r104 = 0;
        goto L33
    }
}
