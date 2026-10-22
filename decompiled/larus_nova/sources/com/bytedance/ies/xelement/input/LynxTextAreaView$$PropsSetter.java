package com.bytedance.ies.xelement.input;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes19.dex */
public class LynxTextAreaView$$PropsSetter extends LynxBaseInputView$$PropsSetter {
    public LynxTextAreaView$$PropsSetter() {
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxTextAreaView r103 = (LynxTextAreaView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1550570986: goto L18;
            case -428786256: goto L14;
            case 419784731: goto L10;
            case 2043213058: goto L6;
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
        r103.setMinHeight(r102.h(r101));
        return;
    L26:
        r103.setMaxLines(r102.f(r101, Integer.MAX_VALUE));
        return;
    L28:
        r103.setMaxHeight(r102.h(r101));
        return;
    L30:
        r103.setRichType(r102.h(r101));
        return;
    L6:
        if (r101.equals(GXTemplateKey.FLEXBOX_MIN_HEIGHT) == false) goto L21;
        r104 = 3;
        goto L21
    L10:
        if (r101.equals("maxlines") == false) goto L21;
        r104 = 2;
        goto L21
    L14:
        if (r101.equals(GXTemplateKey.FLEXBOX_MAX_HEIGHT) == false) goto L21;
        r104 = 1;
        goto L21
    L18:
        if (r101.equals("richtype") == false) goto L21;
        r104 = 0;
        goto L21
    }
}
