package com.bytedance.ee.bear.lynx.impl.lynxview;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CCMLynxAnimationUI$$PropsSetter extends LynxUI$.PropsSetter {
    public CCMLynxAnimationUI$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        CCMLynxAnimationUI r0 = (CCMLynxAnimationUI) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case 3327652: goto L18;
            case 3443508: goto L14;
            case 97692013: goto L10;
            case 1591119016: goto L6;
            default: goto L21;
        };
    L21:
        switch(r3) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        super.setProperty(r5, r6, r7);
        return;
    L24:
        r0.setLottieType(r7.f(r6, 0));
        return;
    L26:
        r0.setFrame(r7.f(r6, 0));
        return;
    L28:
        r0.setPlaying(r7.b(r6, false));
        return;
    L30:
        r0.setLoop(r7.b(r6, false));
        return;
    L6:
        if (r6.equals("lottie-type") == false) goto L21;
        r3 = 3;
        goto L21
    L10:
        if (r6.equals("frame") == false) goto L21;
        r3 = 2;
        goto L21
    L14:
        if (r6.equals("play") == false) goto L21;
        r3 = 1;
        goto L21
    L18:
        if (r6.equals("loop") == false) goto L21;
        r3 = 0;
        goto L21
    }
}
