package com.bytedance.ee.bear.bitable.anniex.view;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes15.dex */
public class BitableLynxIconView$$PropsSetter extends LynxUI$$PropsSetter {
    public BitableLynxIconView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        BitableLynxIconView r103 = (BitableLynxIconView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -2071077606: goto L66;
            case -1744641491: goto L62;
            case -1185092131: goto L58;
            case -1180109083: goto L54;
            case -738250553: goto L50;
            case -738139618: goto L46;
            case -543582613: goto L42;
            case 3355: goto L38;
            case 102340: goto L34;
            case 116079: goto L30;
            case 108403163: goto L26;
            case 109780401: goto L22;
            case 111106384: goto L18;
            case 130575052: goto L14;
            case 448556207: goto L10;
            case 811723230: goto L6;
            default: goto L69;
        };
    L69:
        Integer r105 = null;
        Integer r106 = null;
        Integer r107 = null;
        Integer r108 = null;
        Boolean r109 = null;
        Integer r110 = null;
        Integer r111 = null;
        switch(r104) {
            case 0: goto L128;
            case 1: goto L122;
            case 2: goto L116;
            case 3: goto L110;
            case 4: goto L107;
            case 5: goto L105;
            case 6: goto L100;
            case 7: goto L97;
            case 8: goto L92;
            case 9: goto L89;
            case 10: goto L87;
            case 11: goto L82;
            case 12: goto L79;
            case 13: goto L77;
            case 14: goto L75;
            case 15: goto L73;
            default: goto L71;
        };
    L71:
        super.setProperty(r100, r101, r102);
        return;
    L73:
        r103.setClickAction(r102.h(r101));
        return;
    L75:
        r103.setIconTintColor(r102.h(r101));
        return;
    L77:
        r103.setVisibleType(r102.h(r101));
        return;
    L79:
        r103.setUdKey(r102.h(r101));
        return;
    L87:
        r103.setResId(r102.h(r101));
        return;
    L89:
        r103.setUrl(r102.h(r101));
        return;
    L97:
        r103.setId(r102.h(r101));
        return;
    L105:
        r103.setIconMeta(r102.h(r101));
        return;
    L107:
        r103.setIconInfo(r102.h(r101));
        return;
    L82:
        if (r102.k(r101) == true) goto L85;
        r106 = Integer.valueOf(r102.f(r101, 0));
    L85:
        r103.setStyle(r106);
        return;
    L92:
        if (r102.k(r101) == true) goto L95;
        r107 = Integer.valueOf(r102.f(r101, 0));
    L95:
        r103.setGif(r107);
        return;
    L100:
        if (r102.k(r101) == true) goto L103;
        r108 = Integer.valueOf(r102.f(r101, 0));
    L103:
        r103.setIconRadius(r108);
        return;
    L110:
        if (r102.k(r101) == true) goto L113;
        r109 = Boolean.valueOf(r102.b(r101, false));
    L113:
        r103.setIsSync(r109);
        return;
    L116:
        if (r102.k(r101) == true) goto L119;
        r110 = Integer.valueOf(r102.f(r101, 0));
    L119:
        r103.setImgRes(r110);
        return;
    L122:
        if (r102.k(r101) == true) goto L125;
        r111 = Integer.valueOf(r102.f(r101, 0));
    L125:
        r103.setPlaceholderRes(r111);
        return;
    L128:
        if (r102.k(r101) == true) goto L131;
        r105 = Integer.valueOf(r102.f(r101, 0));
    L131:
        r103.setEnumIcon(r105);
        return;
    L6:
        if (r101.equals("clickAction") == false) goto L69;
        r104 = 15;
        goto L69
    L10:
        if (r101.equals("iconTintColor") == false) goto L69;
        r104 = 14;
        goto L69
    L14:
        if (r101.equals("visibleType") == false) goto L69;
        r104 = HTTP.CR;
        goto L69
    L18:
        if (r101.equals("udKey") == false) goto L69;
        r104 = 12;
        goto L69
    L22:
        if (r101.equals("style") == false) goto L69;
        r104 = 11;
        goto L69
    L26:
        if (r101.equals("resId") == false) goto L69;
        r104 = 10;
        goto L69
    L30:
        if (r101.equals("url") == false) goto L69;
        r104 = 9;
        goto L69
    L34:
        if (r101.equals("gif") == false) goto L69;
        r104 = 8;
        goto L69
    L38:
        if (r101.equals("id") == false) goto L69;
        r104 = 7;
        goto L69
    L42:
        if (r101.equals("iconRadius") == false) goto L69;
        r104 = 6;
        goto L69
    L46:
        if (r101.equals("iconMeta") == false) goto L69;
        r104 = 5;
        goto L69
    L50:
        if (r101.equals("iconInfo") == false) goto L69;
        r104 = 4;
        goto L69
    L54:
        if (r101.equals("isSync") == false) goto L69;
        r104 = 3;
        goto L69
    L58:
        if (r101.equals("imgRes") == false) goto L69;
        r104 = 2;
        goto L69
    L62:
        if (r101.equals("placeholderRes") == false) goto L69;
        r104 = 1;
        goto L69
    L66:
        if (r101.equals("enumIcon") == false) goto L69;
        r104 = 0;
        goto L69
    }
}
