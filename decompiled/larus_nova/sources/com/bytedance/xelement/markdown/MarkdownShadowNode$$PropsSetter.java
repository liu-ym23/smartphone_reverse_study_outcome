package com.bytedance.xelement.markdown;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes22.dex */
public class MarkdownShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public MarkdownShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        MarkdownShadowNode r103 = (MarkdownShadowNode) r100;
        r101.getClass();
        switch(r101.hashCode()) {
            case -2003776663: goto L78;
            case -1993305778: goto L74;
            case -1787558626: goto L70;
            case -1493293085: goto L66;
            case -1416592663: goto L62;
            case -1116605419: goto L58;
            case -1043245271: goto L54;
            case -775988986: goto L50;
            case -691933460: goto L46;
            case -350684741: goto L42;
            case -215582707: goto L38;
            case 264504047: goto L34;
            case 387245343: goto L30;
            case 951530617: goto L26;
            case 1108442963: goto L22;
            case 1214647014: goto L18;
            case 1587844870: goto L14;
            case 1629007544: goto L10;
            case 1916500116: goto L6;
            default: goto L81;
        };
    L81:
        byte r104 = -1;
    L83:
        switch(r104) {
            case 0: goto L122;
            case 1: goto L120;
            case 2: goto L118;
            case 3: goto L116;
            case 4: goto L114;
            case 5: goto L112;
            case 6: goto L110;
            case 7: goto L108;
            case 8: goto L106;
            case 9: goto L104;
            case 10: goto L102;
            case 11: goto L100;
            case 12: goto L98;
            case 13: goto L96;
            case 14: goto L94;
            case 15: goto L92;
            case 16: goto L90;
            case 17: goto L88;
            case 18: goto L86;
            default: goto L84;
        };
    L84:
        super.a(r100, r101, r102);
        return;
    L86:
        r103.setVSyncAnimation(r102.b(r101, false));
        return;
    L88:
        r103.setTextMaxLine(r102.f(r101, 0));
        return;
    L90:
        r103.setTypewriterHeightTransitionDuration(r102.e(r101, 0.0f));
        return;
    L92:
        r103.setImageSyncLoad(r102.b(r101, false));
        return;
    L94:
        r103.setStyleSheet(r102.g(r101));
        return;
    L96:
        r103.setContent(r102.h(r101));
        return;
    L98:
        r103.setExposureTags(r102.a(r101));
        return;
    L100:
        r103.setContentID(r102.h(r101));
        return;
    L102:
        r103.setContentComplete(r102.b(r101, false));
        return;
    L104:
        r103.setImageDownSampling(r102.b(r101, false));
        return;
    L106:
        r103.setAllowBreakAroundPunctuation(r102.b(r101, false));
        return;
    L108:
        r103.setAnimationVelocity(r102.e(r101, 0.0f));
        return;
    L110:
        r103.setAnimationFrameRate(r102.e(r101, 0.0f));
        return;
    L112:
        r103.setTypewriterAutoHeight(r102.b(r101, false));
        return;
    L114:
        r103.setMarkdownContentRange(r102.a(r101));
        return;
    L116:
        r103.setAnimationType(r102.h(r101));
        return;
    L118:
        r103.setInitialAnimationStep(r102.f(r101, 0));
        return;
    L120:
        r103.setMarkdownMaxHeight(r102.e(r101, 0.0f));
        return;
    L122:
        r103.setTypewriterHeightTransitionPrefetch(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("enable-region-view") == false) goto L81;
        r104 = 18;
        goto L83
    L10:
        if (r101.equals("text-maxline") == false) goto L81;
        r104 = 17;
        goto L83
    L14:
        if (r101.equals("typewriter-height-transition-duration") == false) goto L81;
        r104 = 16;
        goto L83
    L18:
        if (r101.equals("image-sync-load") == false) goto L81;
        r104 = 15;
        goto L83
    L22:
        if (r101.equals("markdown-style") == false) goto L81;
        r104 = 14;
        goto L83
    L26:
        if (r101.equals("content") == false) goto L81;
        r104 = HTTP.CR;
        goto L83
    L30:
        if (r101.equals("exposure-tags") == false) goto L81;
        r104 = 12;
        goto L83
    L34:
        if (r101.equals("content-id") == false) goto L81;
        r104 = 11;
        goto L83
    L38:
        if (r101.equals("content-complete") == false) goto L81;
        r104 = 10;
        goto L83
    L42:
        if (r101.equals("image-downsampling") == false) goto L81;
        r104 = 9;
        goto L83
    L46:
        if (r101.equals("allow-break-around-punctuation") == false) goto L81;
        r104 = 8;
        goto L83
    L50:
        if (r101.equals("animation-velocity") == false) goto L81;
        r104 = 7;
        goto L83
    L54:
        if (r101.equals("animation-frame-rate") == false) goto L81;
        r104 = 6;
        goto L83
    L58:
        if (r101.equals("typewriter-dynamic-height") == false) goto L81;
        r104 = 5;
        goto L83
    L62:
        if (r101.equals("content-range") == false) goto L81;
        r104 = 4;
        goto L83
    L66:
        if (r101.equals("animation-type") == false) goto L81;
        r104 = 3;
        goto L83
    L70:
        if (r101.equals("initial-animation-step") == false) goto L81;
        r104 = 2;
        goto L83
    L74:
        if (r101.equals("markdown-max-height") == false) goto L81;
        r104 = 1;
        goto L83
    L78:
        if (r101.equals("typewriter-height-transition-prefetch") == false) goto L81;
        r104 = 0;
        goto L83
    }
}
