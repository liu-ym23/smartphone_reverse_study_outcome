package com.bytedance.lark.lynxlib.widget.empty;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes19.dex */
public class LynxEmptyStateView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxEmptyStateView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        LynxEmptyStateView r103 = (LynxEmptyStateView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -2143207164: goto L74;
            case -1488979661: goto L70;
            case -1216561690: goto L66;
            case -1160394216: goto L62;
            case -728523665: goto L58;
            case -465387874: goto L54;
            case -129165806: goto L50;
            case -64548767: goto L46;
            case 3079825: goto L42;
            case 110371416: goto L38;
            case 214055131: goto L34;
            case 449325929: goto L30;
            case 556428391: goto L26;
            case 682367301: goto L22;
            case 1216883197: goto L18;
            case 1293192686: goto L14;
            case 1673617171: goto L10;
            case 1837524118: goto L6;
            default: goto L77;
        };
    L77:
        switch(r104) {
            case 0: goto L114;
            case 1: goto L112;
            case 2: goto L110;
            case 3: goto L108;
            case 4: goto L106;
            case 5: goto L104;
            case 6: goto L102;
            case 7: goto L100;
            case 8: goto L98;
            case 9: goto L96;
            case 10: goto L94;
            case 11: goto L92;
            case 12: goto L90;
            case 13: goto L88;
            case 14: goto L86;
            case 15: goto L84;
            case 16: goto L82;
            case 17: goto L80;
            default: goto L78;
        };
    L78:
        super.setProperty(r100, r101, r102);
        return;
    L80:
        r103.setImageResId(r102.h(r101));
        return;
    L82:
        r103.setSecondaryActionStyle(r102.h(r101));
        return;
    L84:
        r103.setHyperlink(r102.h(r101));
        return;
    L86:
        r103.setImageSizeMode(r102.h(r101));
        return;
    L88:
        r103.setPrimaryActionStyle(r102.h(r101));
        return;
    L90:
        r103.setLinkActionEnabled(r102.b(r101, false));
        return;
    L92:
        r103.setLinkAction(r102.h(r101));
        return;
    L94:
        r103.setTitleBottomMargin(r102.f(r101, 0));
        return;
    L96:
        r103.setTitle(r102.h(r101));
        return;
    L98:
        r103.setDesc(r102.h(r101));
        return;
    L100:
        r103.setSecondaryActionEnabled(r102.b(r101, false));
        return;
    L102:
        r103.setPrimaryActionTopMargin(r102.f(r101, 0));
        return;
    L104:
        r103.setImageBottomMargin(r102.f(r101, 0));
        return;
    L106:
        r103.setPrimaryActionEnabled(r102.b(r101, false));
        return;
    L108:
        r103.setPrimaryText(r102.h(r101));
        return;
    L110:
        r103.setSecondaryText(r102.h(r101));
        return;
    L112:
        r103.setImageSize(r102.e(r101, 0.0f));
        return;
    L114:
        r103.setSecondaryActionTopMargin(r102.f(r101, 0));
        return;
    L6:
        if (r101.equals("img-res-id-str") == false) goto L77;
        r104 = 17;
        goto L77
    L10:
        if (r101.equals("secondary-action-style") == false) goto L77;
        r104 = 16;
        goto L77
    L14:
        if (r101.equals("desc-inline-hyperlink") == false) goto L77;
        r104 = 15;
        goto L77
    L18:
        if (r101.equals("image-size-mode") == false) goto L77;
        r104 = 14;
        goto L77
    L22:
        if (r101.equals("primary-action-style") == false) goto L77;
        r104 = HTTP.CR;
        goto L77
    L26:
        if (r101.equals("link-action-enable") == false) goto L77;
        r104 = 12;
        goto L77
    L30:
        if (r101.equals("link-action") == false) goto L77;
        r104 = 11;
        goto L77
    L34:
        if (r101.equals("title-bottom-margin") == false) goto L77;
        r104 = 10;
        goto L77
    L38:
        if (r101.equals("title") == false) goto L77;
        r104 = 9;
        goto L77
    L42:
        if (r101.equals(SocialConstants.PARAM_APP_DESC) == false) goto L77;
        r104 = 8;
        goto L77
    L46:
        if (r101.equals("secondary-action-enable") == false) goto L77;
        r104 = 7;
        goto L77
    L50:
        if (r101.equals("primary-action-top-margin") == false) goto L77;
        r104 = 6;
        goto L77
    L54:
        if (r101.equals("image-bottom-margin") == false) goto L77;
        r104 = 5;
        goto L77
    L58:
        if (r101.equals("primary-action-enable") == false) goto L77;
        r104 = 4;
        goto L77
    L62:
        if (r101.equals("primary-text") == false) goto L77;
        r104 = 3;
        goto L77
    L66:
        if (r101.equals("secondary-text") == false) goto L77;
        r104 = 2;
        goto L77
    L70:
        if (r101.equals("image-size") == false) goto L77;
        r104 = 1;
        goto L77
    L74:
        if (r101.equals("secondary-action-top-margin") == false) goto L77;
        r104 = 0;
        goto L77
    }
}
