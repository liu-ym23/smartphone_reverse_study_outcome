package com.bytedance.ee.bear.lynx.impl.xelement;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CCMXELottieView$$PropsSetter extends LynxUI$.PropsSetter {
    public CCMXELottieView$$PropsSetter() {
    }

    public final void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        CCMXELottieView r0 = (CCMXELottieView) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1526942142: goto L14;
            case 3327652: goto L10;
            case 1439562083: goto L6;
            default: goto L17;
        };
    L17:
        switch(r3) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.setProperty(r5, r6, r7);
        return;
    L20:
        r0.setAutoplay(r7.b(r6, false));
        return;
    L22:
        r0.setLoop(r7.b(r6, false));
        return;
    L24:
        r0.setLocalSrc(r7.h(r6));
        return;
    L6:
        if (r6.equals("autoplay") == false) goto L17;
        r3 = 2;
        goto L17
    L10:
        if (r6.equals("loop") == false) goto L17;
        r3 = 1;
        goto L17
    L14:
        if (r6.equals("src-local") == false) goto L17;
        r3 = 0;
        goto L17
    }
}
