package com.lynx.tasm.behavior.shadow.text;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class TextShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    public TextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r100, String r101, x0 r102) {
        TextShadowNode r103 = (TextShadowNode) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1801128308: goto L34;
            case -1215680224: goto L30;
            case -356469693: goto L26;
            case 679001436: goto L22;
            case 1381862785: goto L18;
            case 1713623170: goto L14;
            case 2010704238: goto L10;
            case 2050754629: goto L6;
            default: goto L37;
        };
    L37:
        switch(r104) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L50;
            case 3: goto L48;
            case 4: goto L46;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L40;
            default: goto L38;
        };
    L38:
        super.a(r100, r101, r102);
        return;
    L40:
        r103.setAutoFontSizeLineRanges(r102.a(r101));
        return;
    L42:
        r103.setAutoFontSizePresetSizes(r102.a(r101));
        return;
    L44:
        r103.setVerticalTextAlign(r102.h(r101));
        return;
    L46:
        r103.setHyphen(r102.f(r101, 0));
        return;
    L48:
        r103.setEnableFullJustify(r102.b(r101, false));
        return;
    L50:
        r103.setAutoFontSize(r102.a(r101));
        return;
    L52:
        r103.setLineHeight(r102.e(r101, 1.0E21f));
        return;
    L54:
        r103.setEnableTailColorConvert(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("-x-auto-font-size-line-ranges") == false) goto L37;
        r104 = 7;
        goto L37
    L10:
        if (r101.equals("-x-auto-font-size-preset-sizes") == false) goto L37;
        r104 = 6;
        goto L37
    L14:
        if (r101.equals("text-single-line-vertical-align") == false) goto L37;
        r104 = 5;
        goto L37
    L18:
        if (r101.equals("hyphens") == false) goto L37;
        r104 = 4;
        goto L37
    L22:
        if (r101.equals("enable-full-justify") == false) goto L37;
        r104 = 3;
        goto L37
    L26:
        if (r101.equals("-x-auto-font-size") == false) goto L37;
        r104 = 2;
        goto L37
    L30:
        if (r101.equals(GXTemplateKey.STYLE_FONT_LINE_HEIGHT) == false) goto L37;
        r104 = 1;
        goto L37
    L34:
        if (r101.equals("tail-color-convert") == false) goto L37;
        r104 = 0;
        goto L37
    }
}
