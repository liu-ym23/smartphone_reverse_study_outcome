package com.lynx.tasm.behavior.ui.image;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class AbsUIImage$$PropsSetter extends LynxUI$$PropsSetter {
    public AbsUIImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        AbsUIImage r103 = (AbsUIImage) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1937917490: goto L62;
            case -1249491252: goto L58;
            case -934531685: goto L54;
            case -629825370: goto L50;
            case -320982203: goto L46;
            case -256430480: goto L42;
            case 114148: goto L38;
            case 3357091: goto L34;
            case 207594941: goto L30;
            case 516005201: goto L26;
            case 598246771: goto L22;
            case 681292984: goto L18;
            case 1198809474: goto L14;
            case 1515751784: goto L10;
            case 1615092063: goto L6;
            default: goto L65;
        };
    L65:
        switch(r104) {
            case 0: goto L96;
            case 1: goto L94;
            case 2: goto L92;
            case 3: goto L90;
            case 4: goto L88;
            case 5: goto L86;
            case 6: goto L84;
            case 7: goto L82;
            case 8: goto L80;
            case 9: goto L78;
            case 10: goto L76;
            case 11: goto L74;
            case 12: goto L72;
            case 13: goto L70;
            case 14: goto L68;
            default: goto L66;
        };
    L66:
        super.setProperty(r100, r101, r102);
        return;
    L68:
        r103.setAutoSize(r102.b(r101, false));
        return;
    L70:
        r103.setCapInsets(r102.h(r101));
        return;
    L72:
        r103.setDisableDefaultPlaceholder(r102.b(r101, false));
        return;
    L74:
        r103.setBlurRadius(r102.h(r101));
        return;
    L76:
        r103.setPlaceholder(r102.h(r101));
        return;
    L78:
        r103.setCapInsetsBackUp(r102.h(r101));
        return;
    L80:
        r103.setPreFetchHeight(r102.h(r101));
        return;
    L82:
        r103.setObjectFit(r102.h(r101));
        return;
    L84:
        r103.setSource(r102.h(r101));
        return;
    L86:
        r103.setPreFetchWidth(r102.h(r101));
        return;
    L88:
        r103.setDisableDefaultResize(r102.b(r101, false));
        return;
    L90:
        r103.setLoopCount(r102.f(r101, 0));
        return;
    L92:
        r103.setRepeat(r102.b(r101, false));
        return;
    L94:
        r103.setCoverStart(r102.b(r101, false));
        return;
    L96:
        r103.setCapInsetsScale(r102.h(r101));
        return;
    L6:
        if (r101.equals("auto-size") == false) goto L65;
        r104 = 14;
        goto L65
    L10:
        if (r101.equals("capInsets") == false) goto L65;
        r104 = HTTP.CR;
        goto L65
    L14:
        if (r101.equals("disable-default-placeholder") == false) goto L65;
        r104 = 12;
        goto L65
    L18:
        if (r101.equals("blur-radius") == false) goto L65;
        r104 = 11;
        goto L65
    L22:
        if (r101.equals(GXTemplateKey.GAIAX_PLACEHOLDER) == false) goto L65;
        r104 = 10;
        goto L65
    L26:
        if (r101.equals("cap-insets") == false) goto L65;
        r104 = 9;
        goto L65
    L30:
        if (r101.equals("prefetch-height") == false) goto L65;
        r104 = 8;
        goto L65
    L34:
        if (r101.equals("mode") == false) goto L65;
        r104 = 7;
        goto L65
    L38:
        if (r101.equals("src") == false) goto L65;
        r104 = 6;
        goto L65
    L42:
        if (r101.equals("prefetch-width") == false) goto L65;
        r104 = 5;
        goto L65
    L46:
        if (r101.equals("disable-default-resize") == false) goto L65;
        r104 = 4;
        goto L65
    L50:
        if (r101.equals("loop-count") == false) goto L65;
        r104 = 3;
        goto L65
    L54:
        if (r101.equals(SalesInfoStruct.REPEAT) == false) goto L65;
        r104 = 2;
        goto L65
    L58:
        if (r101.equals("cover-start") == false) goto L65;
        r104 = 1;
        goto L65
    L62:
        if (r101.equals("cap-insets-scale") == false) goto L65;
        r104 = 0;
        goto L65
    }
}
