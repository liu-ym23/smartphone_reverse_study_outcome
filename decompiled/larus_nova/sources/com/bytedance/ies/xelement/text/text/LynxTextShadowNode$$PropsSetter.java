package com.bytedance.ies.xelement.text.text;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxTextShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public LynxTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        LynxTextShadowNode r103 = (LynxTextShadowNode) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1550570986: goto L14;
            case 125841635: goto L10;
            case 1629007544: goto L6;
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
        super.a(r100, r101, r102);
        return;
    L20:
        r103.setTextMaxLine(r102.h(r101));
        return;
    L22:
        r103.setEllipsizeMode(r102.h(r101));
        return;
    L24:
        r103.setRichType(r102.h(r101));
        return;
    L6:
        if (r101.equals("text-maxline") == false) goto L17;
        r104 = 2;
        goto L17
    L10:
        if (r101.equals("ellipsize-mode") == false) goto L17;
        r104 = 1;
        goto L17
    L14:
        if (r101.equals("richtype") == false) goto L17;
        r104 = 0;
        goto L17
    }
}
