package com.lynx.tasm.behavior.shadow.text;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class AbsInlineImageShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    public AbsInlineImageShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r110, String r111, x0 r112) {
        AbsInlineImageShadowNode r100 = (AbsInlineImageShadowNode) r110;
        r111.getClass();
        switch(r111.hashCode()) {
            case -1820411228: goto L94;
            case -1559879186: goto L90;
            case -1032412580: goto L86;
            case -585734562: goto L82;
            case -570796884: goto L78;
            case -567450431: goto L74;
            case 114148: goto L70;
            case 3357091: goto L66;
            case 143851658: goto L62;
            case 158789336: goto L58;
            case 162135789: goto L54;
            case 307025104: goto L50;
            case 310371557: goto L46;
            case 419144785: goto L42;
            case 434082463: goto L38;
            case 437428916: goto L34;
            case 605322756: goto L30;
            case 609634231: goto L26;
            case 881039699: goto L22;
            case 956705090: goto L18;
            case 971642768: goto L14;
            case 974989221: goto L10;
            case 1466337535: goto L6;
            default: goto L97;
        };
    L97:
        byte r101 = -1;
    L98:
        Integer r102 = null;
        switch(r101) {
            case 0: goto L162;
            case 1: goto L160;
            case 2: goto L158;
            case 3: goto L153;
            case 4: goto L150;
            case 5: goto L148;
            case 6: goto L146;
            case 7: goto L144;
            case 8: goto L139;
            case 9: goto L136;
            case 10: goto L134;
            case 11: goto L132;
            case 12: goto L130;
            case 13: goto L125;
            case 14: goto L122;
            case 15: goto L120;
            case 16: goto L118;
            case 17: goto L116;
            case 18: goto L114;
            case 19: goto L109;
            case 20: goto L106;
            case 21: goto L104;
            case 22: goto L102;
            default: goto L100;
        };
    L100:
        super.a(r110, r111, r112);
        return;
    L102:
        r100.setBorderRadius(1, r112.a(r111));
        return;
    L104:
        r100.setBorderWidth(4, r112.f(r111, 0));
        return;
    L106:
        r100.setBorderStyle(4, r112.f(r111, -1));
        return;
    L114:
        r100.setBorderRadius(0, r112.a(r111));
        return;
    L116:
        r100.setBorderRadius(4, r112.a(r111));
        return;
    L118:
        r100.setBackgroundColor(r112.f(r111, 0));
        return;
    L120:
        r100.setBorderWidth(2, r112.f(r111, 0));
        return;
    L122:
        r100.setBorderStyle(2, r112.f(r111, -1));
        return;
    L130:
        r100.setBorderWidth(0, r112.f(r111, 0));
        return;
    L132:
        r100.setBorderStyle(0, r112.f(r111, -1));
        return;
    L134:
        r100.setBorderWidth(3, r112.f(r111, 0));
        return;
    L136:
        r100.setBorderStyle(3, r112.f(r111, -1));
        return;
    L144:
        r100.setMode(r112.h(r111));
        return;
    L146:
        r100.setSource(r112.h(r111));
        return;
    L148:
        r100.setBorderWidth(1, r112.f(r111, 0));
        return;
    L150:
        r100.setBorderStyle(1, r112.f(r111, -1));
        return;
    L158:
        r100.setBorderRadius(2, r112.a(r111));
        return;
    L160:
        r100.setVerticalAlign(r112.a(r111));
        return;
    L162:
        r100.setBorderRadius(3, r112.a(r111));
        return;
    L109:
        if (r112.k(r111) == true) goto L112;
        r102 = Integer.valueOf(r112.f(r111, 0));
    L112:
        r100.setBorderColor(3, r102);
        return;
    L125:
        if (r112.k(r111) == true) goto L128;
        r102 = Integer.valueOf(r112.f(r111, 0));
    L128:
        r100.setBorderColor(1, r102);
        return;
    L139:
        if (r112.k(r111) == true) goto L142;
        r102 = Integer.valueOf(r112.f(r111, 0));
    L142:
        r100.setBorderColor(2, r102);
        return;
    L153:
        if (r112.k(r111) == true) goto L156;
        r102 = Integer.valueOf(r112.f(r111, 0));
    L156:
        r100.setBorderColor(0, r102);
        return;
    L6:
        if (r111.equals(GXTemplateKey.STYLE_BORDER_TOP_LEFT_RADIUS) == false) goto L97;
        r101 = 22;
        goto L98
    L10:
        if (r111.equals("border-bottom-width") == false) goto L97;
        r101 = 21;
        goto L98
    L14:
        if (r111.equals("border-bottom-style") == false) goto L97;
        r101 = 20;
        goto L98
    L18:
        if (r111.equals("border-bottom-color") == false) goto L97;
        r101 = 19;
        goto L98
    L22:
        if (r111.equals(GXTemplateKey.STYLE_BORDER_RADIUS) == false) goto L97;
        r101 = 18;
        goto L98
    L26:
        if (r111.equals(GXTemplateKey.STYLE_BORDER_BOTTOM_LEFT_RADIUS) == false) goto L97;
        r101 = 17;
        goto L98
    L30:
        if (r111.equals(GXTemplateKey.STYLE_BACKGROUND_COLOR) == false) goto L97;
        r101 = 16;
        goto L98
    L34:
        if (r111.equals("border-right-width") == false) goto L97;
        r101 = 15;
        goto L98
    L38:
        if (r111.equals("border-right-style") == false) goto L97;
        r101 = 14;
        goto L98
    L42:
        if (r111.equals("border-right-color") == false) goto L97;
        r101 = HTTP.CR;
        goto L98
    L46:
        if (r111.equals(GXTemplateKey.STYLE_BORDER_WIDTH) == false) goto L97;
        r101 = 12;
        goto L98
    L50:
        if (r111.equals("border-style") == false) goto L97;
        r101 = 11;
        goto L98
    L54:
        if (r111.equals("border-top-width") == false) goto L97;
        r101 = 10;
        goto L98
    L58:
        if (r111.equals("border-top-style") == false) goto L97;
        r101 = 9;
        goto L98
    L62:
        if (r111.equals("border-top-color") == false) goto L97;
        r101 = 8;
        goto L98
    L66:
        if (r111.equals("mode") == false) goto L97;
        r101 = 7;
        goto L98
    L70:
        if (r111.equals("src") == false) goto L97;
        r101 = 6;
        goto L98
    L74:
        if (r111.equals("border-left-width") == false) goto L97;
        r101 = 5;
        goto L98
    L78:
        if (r111.equals("border-left-style") == false) goto L97;
        r101 = 4;
        goto L98
    L82:
        if (r111.equals("border-left-color") == false) goto L97;
        r101 = 3;
        goto L98
    L86:
        if (r111.equals(GXTemplateKey.STYLE_BORDER_TOP_RIGHT_RADIUS) == false) goto L97;
        r101 = 2;
        goto L98
    L90:
        if (r111.equals("vertical-align") == false) goto L97;
        r101 = 1;
        goto L98
    L94:
        if (r111.equals(GXTemplateKey.STYLE_BORDER_BOTTOM_RIGHT_RADIUS) == false) goto L97;
        r101 = 0;
        goto L98
    }
}
