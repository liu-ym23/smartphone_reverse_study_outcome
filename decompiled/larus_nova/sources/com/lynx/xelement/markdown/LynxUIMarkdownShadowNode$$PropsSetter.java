package com.lynx.xelement.markdown;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUIMarkdownShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public LynxUIMarkdownShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        LynxUIMarkdownShadowNode r103 = (LynxUIMarkdownShadowNode) r100;
        r101.getClass();
        switch(r101.hashCode()) {
            case -2003776663: goto L102;
            case -1993305778: goto L98;
            case -1787558626: goto L94;
            case -1493293085: goto L90;
            case -1416592663: goto L86;
            case -1157887457: goto L82;
            case -1145258555: goto L78;
            case -1116605419: goto L74;
            case -1043245271: goto L70;
            case -775988986: goto L66;
            case -691933460: goto L62;
            case -412316625: goto L58;
            case -350684741: goto L54;
            case -215582707: goto L50;
            case 263767276: goto L46;
            case 264504047: goto L42;
            case 387245343: goto L38;
            case 951530617: goto L34;
            case 1108442963: goto L30;
            case 1137695781: goto L26;
            case 1214647014: goto L22;
            case 1257322832: goto L18;
            case 1587844870: goto L14;
            case 1629007544: goto L10;
            case 1916500116: goto L6;
            default: goto L105;
        };
    L105:
        byte r104 = -1;
    L107:
        switch(r104) {
            case 0: goto L158;
            case 1: goto L156;
            case 2: goto L154;
            case 3: goto L152;
            case 4: goto L150;
            case 5: goto L148;
            case 6: goto L146;
            case 7: goto L144;
            case 8: goto L142;
            case 9: goto L140;
            case 10: goto L138;
            case 11: goto L136;
            case 12: goto L134;
            case 13: goto L132;
            case 14: goto L130;
            case 15: goto L128;
            case 16: goto L126;
            case 17: goto L124;
            case 18: goto L122;
            case 19: goto L120;
            case 20: goto L118;
            case 21: goto L116;
            case 22: goto L114;
            case 23: goto L112;
            case 24: goto L110;
            default: goto L108;
        };
    L108:
        super.a(r100, r101, r102);
        return;
    L110:
        r103.setEnableRegionView(r102.b(r101, false));
        return;
    L112:
        r103.setTextMaxLine(r102.f(r101, 0));
        return;
    L114:
        r103.setTypewriterHeightTransitionDuration(r102.e(r101, 0.0f));
        return;
    L116:
        r103.setTextMarkAttachments(r102.a(r101));
        return;
    L118:
        r103.setImageSyncLoad(r102.b(r101, false));
        return;
    L120:
        r103.setSelectionBackgroundColor(r102.f(r101, 0));
        return;
    L122:
        r103.setStyleSheet(r102.g(r101));
        return;
    L124:
        r103.setContent(r102.h(r101));
        return;
    L126:
        r103.setExposureTags(r102.a(r101));
        return;
    L128:
        r103.setContentID(r102.h(r101));
        return;
    L130:
        r103.setEnableTextSelection(r102.b(r101, false));
        return;
    L132:
        r103.setContentComplete(r102.b(r101, false));
        return;
    L134:
        r103.setImageDownSampling(r102.b(r101, false));
        return;
    L136:
        r103.setMarkdownEffect(r102.g(r101));
        return;
    L138:
        r103.setAllowBreakAroundPunctuation(r102.b(r101, false));
        return;
    L140:
        r103.setAnimationVelocity(r102.e(r101, 0.0f));
        return;
    L142:
        r103.setAnimationFrameRate(r102.e(r101, 0.0f));
        return;
    L144:
        r103.setTypewriterAutoHeight(r102.b(r101, false));
        return;
    L146:
        r103.setSelectionHandleSize(r102.f(r101, 0));
        return;
    L148:
        r103.setSelectionHandleColor(r102.f(r101, 0));
        return;
    L150:
        r103.setMarkdownContentRange(r102.a(r101));
        return;
    L152:
        r103.setAnimationType(r102.h(r101));
        return;
    L154:
        r103.setInitialAnimationStep(r102.f(r101, 0));
        return;
    L156:
        r103.setMarkdownMaxHeight(r102.e(r101, 0.0f));
        return;
    L158:
        r103.setTypewriterHeightTransitionPrefetch(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("enable-region-view") == false) goto L105;
        r104 = 24;
        goto L107
    L10:
        if (r101.equals("text-maxline") == false) goto L105;
        r104 = 23;
        goto L107
    L14:
        if (r101.equals("typewriter-height-transition-duration") == false) goto L105;
        r104 = 22;
        goto L107
    L18:
        if (r101.equals("text-mark-attachments") == false) goto L105;
        r104 = 21;
        goto L107
    L22:
        if (r101.equals("image-sync-load") == false) goto L105;
        r104 = 20;
        goto L107
    L26:
        if (r101.equals("selection-background-color") == false) goto L105;
        r104 = 19;
        goto L107
    L30:
        if (r101.equals("markdown-style") == false) goto L105;
        r104 = 18;
        goto L107
    L34:
        if (r101.equals("content") == false) goto L105;
        r104 = 17;
        goto L107
    L38:
        if (r101.equals("exposure-tags") == false) goto L105;
        r104 = 16;
        goto L107
    L42:
        if (r101.equals("content-id") == false) goto L105;
        r104 = 15;
        goto L107
    L46:
        if (r101.equals("text-selection") == false) goto L105;
        r104 = 14;
        goto L107
    L50:
        if (r101.equals("content-complete") == false) goto L105;
        r104 = HTTP.CR;
        goto L107
    L54:
        if (r101.equals("image-downsampling") == false) goto L105;
        r104 = 12;
        goto L107
    L58:
        if (r101.equals("markdown-effect") == false) goto L105;
        r104 = 11;
        goto L107
    L62:
        if (r101.equals("allow-break-around-punctuation") == false) goto L105;
        r104 = 10;
        goto L107
    L66:
        if (r101.equals("animation-velocity") == false) goto L105;
        r104 = 9;
        goto L107
    L70:
        if (r101.equals("animation-frame-rate") == false) goto L105;
        r104 = 8;
        goto L107
    L74:
        if (r101.equals("typewriter-dynamic-height") == false) goto L105;
        r104 = 7;
        goto L107
    L78:
        if (r101.equals("selection-handle-size") == false) goto L105;
        r104 = 6;
        goto L107
    L82:
        if (r101.equals("selection-handle-color") == false) goto L105;
        r104 = 5;
        goto L107
    L86:
        if (r101.equals("content-range") == false) goto L105;
        r104 = 4;
        goto L107
    L90:
        if (r101.equals("animation-type") == false) goto L105;
        r104 = 3;
        goto L107
    L94:
        if (r101.equals("initial-animation-step") == false) goto L105;
        r104 = 2;
        goto L107
    L98:
        if (r101.equals("markdown-max-height") == false) goto L105;
        r104 = 1;
        goto L107
    L102:
        if (r101.equals("typewriter-height-transition-prefetch") == false) goto L105;
        r104 = 0;
        goto L107
    }
}
