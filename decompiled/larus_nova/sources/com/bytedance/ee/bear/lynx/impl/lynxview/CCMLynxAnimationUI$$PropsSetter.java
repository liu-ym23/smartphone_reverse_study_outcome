package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes18.dex */
public class CCMLynxAnimationUI$$PropsSetter extends LynxUI$$PropsSetter {
    public CCMLynxAnimationUI$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        CCMLynxAnimationUI r103 = (CCMLynxAnimationUI) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case 3327652: goto L18;
            case 3443508: goto L14;
            case 97692013: goto L10;
            case 1591119016: goto L6;
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
        r103.setLottieType(r102.f(r101, 0));
        return;
    L26:
        r103.setFrame(r102.f(r101, 0));
        return;
    L28:
        r103.setPlaying(r102.b(r101, false));
        return;
    L30:
        r103.setLoop(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("lottie-type") == false) goto L21;
        r104 = 3;
        goto L21
    L10:
        if (r101.equals("frame") == false) goto L21;
        r104 = 2;
        goto L21
    L14:
        if (r101.equals("play") == false) goto L21;
        r104 = 1;
        goto L21
    L18:
        if (r101.equals("loop") == false) goto L21;
        r104 = 0;
        goto L21
    }
}
