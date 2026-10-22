package com.bytedance.ee.bear.bitable.anniex.view;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes15.dex */
public class BitableLynxAnimationView$$PropsSetter extends LynxUI$$PropsSetter {
    public BitableLynxAnimationView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        BitableLynxAnimationView r103 = (BitableLynxAnimationView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1526942142: goto L18;
            case 3271912: goto L14;
            case 3327652: goto L10;
            case 1439562083: goto L6;
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
        r103.setAutoplay(r102.b(r101, false));
        return;
    L26:
        r103.setLoop(r102.b(r101, false));
        return;
    L28:
        r103.setJson(r102.h(r101));
        return;
    L30:
        r103.setLocalSrc(r102.h(r101));
        return;
    L6:
        if (r101.equals("autoplay") == false) goto L21;
        r104 = 3;
        goto L21
    L10:
        if (r101.equals("loop") == false) goto L21;
        r104 = 2;
        goto L21
    L14:
        if (r101.equals("json") == false) goto L21;
        r104 = 1;
        goto L21
    L18:
        if (r101.equals("src-local") == false) goto L21;
        r104 = 0;
        goto L21
    }
}
