package com.lynx.tasm.behavior.shadow.text;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class InlineTextShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    public InlineTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r100, String r110, x0 r111) {
        InlineTextShadowNode r101 = (InlineTextShadowNode) r100;
        r110.getClass();
        byte r102 = -1;
        switch(r110.hashCode()) {
            case -1820411228: goto L46;
            case -1559879186: goto L42;
            case -1032412580: goto L38;
            case -20727064: goto L34;
            case 605322756: goto L30;
            case 609634231: goto L26;
            case 610793468: goto L22;
            case 881039699: goto L18;
            case 1266923840: goto L14;
            case 1466337535: goto L10;
            case 2005447450: goto L6;
            default: goto L49;
        };
    L49:
        switch(r102) {
            case 0: goto L72;
            case 1: goto L70;
            case 2: goto L68;
            case 3: goto L66;
            case 4: goto L64;
            case 5: goto L62;
            case 6: goto L60;
            case 7: goto L58;
            case 8: goto L56;
            case 9: goto L54;
            case 10: goto L52;
            default: goto L50;
        };
    L50:
        super.a(r100, r110, r111);
        return;
    L52:
        r101.setBackgroundRepeat(r111.a(r110));
        return;
    L54:
        r101.setBorderRadius(1, r111.a(r110));
        return;
    L56:
        r101.setBackgroundSize(r111.a(r110));
        return;
    L58:
        r101.setBorderRadius(0, r111.a(r110));
        return;
    L60:
        r101.setBackgroundImage(r111.a(r110));
        return;
    L62:
        r101.setBorderRadius(4, r111.a(r110));
        return;
    L64:
        r101.setBackgroundColor(r111.f(r110, 0));
        return;
    L66:
        r101.setBackgroundPosition(r111.a(r110));
        return;
    L68:
        r101.setBorderRadius(2, r111.a(r110));
        return;
    L70:
        r101.setVerticalAlign(r111.a(r110));
        return;
    L72:
        r101.setBorderRadius(3, r111.a(r110));
        return;
    L6:
        if (r110.equals("background-repeat") == false) goto L49;
        r102 = 10;
        goto L49
    L10:
        if (r110.equals(GXTemplateKey.STYLE_BORDER_TOP_LEFT_RADIUS) == false) goto L49;
        r102 = 9;
        goto L49
    L14:
        if (r110.equals("background-size") == false) goto L49;
        r102 = 8;
        goto L49
    L18:
        if (r110.equals(GXTemplateKey.STYLE_BORDER_RADIUS) == false) goto L49;
        r102 = 7;
        goto L49
    L22:
        if (r110.equals(GXTemplateKey.STYLE_BACKGROUND_IMAGE) == false) goto L49;
        r102 = 6;
        goto L49
    L26:
        if (r110.equals(GXTemplateKey.STYLE_BORDER_BOTTOM_LEFT_RADIUS) == false) goto L49;
        r102 = 5;
        goto L49
    L30:
        if (r110.equals(GXTemplateKey.STYLE_BACKGROUND_COLOR) == false) goto L49;
        r102 = 4;
        goto L49
    L34:
        if (r110.equals("background-position") == false) goto L49;
        r102 = 3;
        goto L49
    L38:
        if (r110.equals(GXTemplateKey.STYLE_BORDER_TOP_RIGHT_RADIUS) == false) goto L49;
        r102 = 2;
        goto L49
    L42:
        if (r110.equals("vertical-align") == false) goto L49;
        r102 = 1;
        goto L49
    L46:
        if (r110.equals(GXTemplateKey.STYLE_BORDER_BOTTOM_RIGHT_RADIUS) == false) goto L49;
        r102 = 0;
        goto L49
    }
}
