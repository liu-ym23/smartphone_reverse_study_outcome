package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.utils.ShadowNodeSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class ShadowNode$$PropsSetter implements ShadowNodeSetter<ShadowNode> {
    public ShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r100, String r101, x0 r102) {
        r101.getClass();
        byte r103 = -1;
        switch(r101.hashCode()) {
            case -1559879186: goto L26;
            case -992853731: goto L22;
            case -804847959: goto L18;
            case 856740501: goto L14;
            case 1443214456: goto L10;
            case 2100930194: goto L6;
            default: goto L29;
        };
    L29:
        switch(r103) {
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            default: goto L30;
        };
    L30:
        return;
    L31:
        r100.setEventThrough(r102.d(r101));
        return;
    L33:
        r100.setDataset(r102.g(r101));
        return;
    L35:
        r100.setEventThroughPropagation(r102.d(r101));
        return;
    L37:
        r100.setPointerEvents(r102.f(r101, 0));
        return;
    L39:
        r100.setIgnoreFocus(r102.d(r101));
        return;
    L41:
        r100.setVerticalAlign(r102.a(r101));
        return;
    L6:
        if (r101.equals("event-through") == false) goto L29;
        r103 = 5;
        goto L29
    L10:
        if (r101.equals("dataset") == false) goto L29;
        r103 = 4;
        goto L29
    L14:
        if (r101.equals("enable-touch-pseudo-propagation") == false) goto L29;
        r103 = 3;
        goto L29
    L18:
        if (r101.equals("pointer-events") == false) goto L29;
        r103 = 2;
        goto L29
    L22:
        if (r101.equals("ignore-focus") == false) goto L29;
        r103 = 1;
        goto L29
    L26:
        if (r101.equals("vertical-align") == false) goto L29;
        r103 = 0;
        goto L29
    }
}
