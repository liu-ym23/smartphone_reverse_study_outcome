package com.bytedance.ee.bear.lynx.impl.xelement;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes18.dex */
public class CCMXELottieView$$PropsSetter extends LynxUI$$PropsSetter {
    public CCMXELottieView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        CCMXELottieView r103 = (CCMXELottieView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1526942142: goto L14;
            case 3327652: goto L10;
            case 1439562083: goto L6;
            default: goto L17;
        };
    L17:
        switch(r104) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.setProperty(r100, r101, r102);
        return;
    L20:
        r103.setAutoplay(r102.b(r101, false));
        return;
    L22:
        r103.setLoop(r102.b(r101, false));
        return;
    L24:
        r103.setLocalSrc(r102.h(r101));
        return;
    L6:
        if (r101.equals("autoplay") == false) goto L17;
        r104 = 2;
        goto L17
    L10:
        if (r101.equals("loop") == false) goto L17;
        r104 = 1;
        goto L17
    L14:
        if (r101.equals("src-local") == false) goto L17;
        r104 = 0;
        goto L17
    }
}
