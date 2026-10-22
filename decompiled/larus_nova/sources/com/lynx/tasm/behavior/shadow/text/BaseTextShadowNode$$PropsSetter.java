package com.lynx.tasm.behavior.shadow.text;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class BaseTextShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public BaseTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r100, String r101, x0 r102) {
        BaseTextShadowNode r103 = (BaseTextShadowNode) r100;
        r101.getClass();
        switch(r101.hashCode()) {
            case -2137322088: goto L130;
            case -2125209152: goto L126;
            case -2006495646: goto L122;
            case -1988401764: goto L118;
            case -1961254866: goto L114;
            case -1942970735: goto L110;
            case -1923578189: goto L106;
            case -1846328470: goto L102;
            case -1613296421: goto L98;
            case -1586082113: goto L94;
            case -1477575976: goto L90;
            case -1328339619: goto L86;
            case -1215680224: goto L82;
            case -1080127274: goto L78;
            case -1004442098: goto L74;
            case -962590849: goto L70;
            case -930515806: goto L66;
            case -231573485: goto L62;
            case -20349561: goto L58;
            case 3556653: goto L54;
            case 94842723: goto L50;
            case 108532386: goto L46;
            case 125536225: goto L42;
            case 375997564: goto L38;
            case 431477072: goto L34;
            case 598800822: goto L30;
            case 746232421: goto L26;
            case 856877710: goto L22;
            case 1050625329: goto L18;
            case 1629007544: goto L14;
            case 1889098060: goto L10;
            case 2104465578: goto L6;
            default: goto L133;
        };
    L133:
        byte r104 = -1;
    L135:
        switch(r104) {
            case 0: goto L200;
            case 1: goto L198;
            case 2: goto L196;
            case 3: goto L194;
            case 4: goto L192;
            case 5: goto L190;
            case 6: goto L188;
            case 7: goto L186;
            case 8: goto L184;
            case 9: goto L182;
            case 10: goto L180;
            case 11: goto L178;
            case 12: goto L176;
            case 13: goto L174;
            case 14: goto L172;
            case 15: goto L170;
            case 16: goto L168;
            case 17: goto L166;
            case 18: goto L164;
            case 19: goto L162;
            case 20: goto L160;
            case 21: goto L158;
            case 22: goto L156;
            case 23: goto L154;
            case 24: goto L152;
            case 25: goto L150;
            case 26: goto L148;
            case 27: goto L146;
            case 28: goto L144;
            case 29: goto L142;
            case 30: goto L140;
            case 31: goto L138;
            default: goto L136;
        };
    L136:
        super.a(r100, r101, r102);
        return;
    L138:
        r103.setTextMaxLength(r102.h(r101));
        return;
    L140:
        r103.setTextIndent(r102.a(r101));
        return;
    L142:
        r103.setTextMaxLine(r102.h(r101));
        return;
    L144:
        r103.setFontFeatureSettings(r102.f(r101, 0));
        return;
    L146:
        r103.setTextVerticalAlign(r102.h(r101));
        return;
    L148:
        r103.setTextAlign(r102.f(r101, 3));
        return;
    L150:
        r103.setFontWeight(r102.f(r101, 0));
        return;
    L152:
        r103.setTextDecoration(r102.a(r101));
        return;
    L154:
        r103.setWordBreakStrategy(r102.f(r101, 0));
        return;
    L156:
        r103.setUseWebLineHeight(r102.b(r101, false));
        return;
    L158:
        r103.setFontFamily(r102.h(r101));
        return;
    L160:
        r103.setColor(r102.d(r101));
        return;
    L162:
        r103.setText(r102.d(r101));
        return;
    L164:
        r103.setEnableEmojiCompat(r102.b(r101, false));
        return;
    L166:
        r103.setEnableFontScaling(r102.h(r101));
        return;
    L168:
        r103.setTextOverflow(r102.f(r101, 0));
        return;
    L170:
        r103.setDirection(r102.f(r101, 0));
        return;
    L172:
        r103.setEnableBitmapGradient(r102.b(r101, false));
        return;
    L174:
        r103.setBaselineShift(r102.h(r101));
        return;
    L176:
        r103.setLineHeight(r102.e(r101, 1.0E21f));
        return;
    L178:
        r103.setTextFakeBold(r102.b(r101, false));
        return;
    L180:
        r103.setFontFeatureSettings(r102.a(r101));
        return;
    L182:
        r103.setFontSize(r102.e(r101, 1.0E21f));
        return;
    L184:
        r103.setFontVariationSettings(r102.a(r101));
        return;
    L186:
        r103.setLineSpacing(r102.e(r101, 0.0f));
        return;
    L188:
        r103.setFontStyle(r102.f(r101, 0));
        return;
    L190:
        r103.setTextStrokeWidth(r102.e(r101, 0.0f));
        return;
    L192:
        r103.setTextStrokeColor(r102.d(r101));
        return;
    L194:
        r103.setLetterSpacing(r102.e(r101, 1.0E21f));
        return;
    L196:
        r103.setWhiteSpace(r102.f(r101, 0));
        return;
    L198:
        r103.setTextShadow(r102.a(r101));
        return;
    L200:
        r103.setIncludeFontPadding(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("text-maxlength") == false) goto L133;
        r104 = 31;
        goto L135
    L10:
        if (r101.equals("text-indent") == false) goto L133;
        r104 = 30;
        goto L135
    L14:
        if (r101.equals("text-maxline") == false) goto L133;
        r104 = 29;
        goto L135
    L18:
        if (r101.equals("font-optical-sizing") == false) goto L133;
        r104 = 28;
        goto L135
    L22:
        if (r101.equals("text-vertical-align") == false) goto L133;
        r104 = 27;
        goto L135
    L26:
        if (r101.equals(GXTemplateKey.STYLE_FONT_TEXT_ALIGN) == false) goto L133;
        r104 = 26;
        goto L135
    L30:
        if (r101.equals(GXTemplateKey.STYLE_FONT_WEIGHT) == false) goto L133;
        r104 = 25;
        goto L135
    L34:
        if (r101.equals(GXTemplateKey.STYLE_FONT_TEXT_DECORATION) == false) goto L133;
        r104 = 24;
        goto L135
    L38:
        if (r101.equals("word-break") == false) goto L133;
        r104 = 23;
        goto L135
    L42:
        if (r101.equals("use-web-line-height") == false) goto L133;
        r104 = 22;
        goto L135
    L46:
        if (r101.equals(GXTemplateKey.STYLE_FONT_FAMILY) == false) goto L133;
        r104 = 21;
        goto L135
    L50:
        if (r101.equals("color") == false) goto L133;
        r104 = 20;
        goto L135
    L54:
        if (r101.equals("text") == false) goto L133;
        r104 = 19;
        goto L135
    L58:
        if (r101.equals("android-emoji-compat") == false) goto L133;
        r104 = 18;
        goto L135
    L62:
        if (r101.equals("enable-font-scaling") == false) goto L133;
        r104 = 17;
        goto L135
    L66:
        if (r101.equals(GXTemplateKey.STYLE_FONT_TEXT_OVERFLOW) == false) goto L133;
        r104 = 16;
        goto L135
    L70:
        if (r101.equals("direction") == false) goto L133;
        r104 = 15;
        goto L135
    L74:
        if (r101.equals("bitmap-gradient") == false) goto L133;
        r104 = 14;
        goto L135
    L78:
        if (r101.equals("custom-baseline-shift") == false) goto L133;
        r104 = HTTP.CR;
        goto L135
    L82:
        if (r101.equals(GXTemplateKey.STYLE_FONT_LINE_HEIGHT) == false) goto L133;
        r104 = 12;
        goto L135
    L86:
        if (r101.equals("text-fake-bold") == false) goto L133;
        r104 = 11;
        goto L135
    L90:
        if (r101.equals("font-feature-settings") == false) goto L133;
        r104 = 10;
        goto L135
    L94:
        if (r101.equals(GXTemplateKey.STYLE_FONT_SIZE) == false) goto L133;
        r104 = 9;
        goto L135
    L98:
        if (r101.equals("font-variation-settings") == false) goto L133;
        r104 = 8;
        goto L135
    L102:
        if (r101.equals(GXTemplateKey.GAIAX_LAYER_LINE_SPACING) == false) goto L133;
        r104 = 7;
        goto L135
    L106:
        if (r101.equals("font-style") == false) goto L133;
        r104 = 6;
        goto L135
    L110:
        if (r101.equals("text-stroke-width") == false) goto L133;
        r104 = 5;
        goto L135
    L114:
        if (r101.equals("text-stroke-color") == false) goto L133;
        r104 = 4;
        goto L135
    L118:
        if (r101.equals("letter-spacing") == false) goto L133;
        r104 = 3;
        goto L135
    L122:
        if (r101.equals("white-space") == false) goto L133;
        r104 = 2;
        goto L135
    L126:
        if (r101.equals("text-shadow") == false) goto L133;
        r104 = 1;
        goto L135
    L130:
        if (r101.equals("include-font-padding") == false) goto L133;
        r104 = 0;
        goto L135
    }
}
