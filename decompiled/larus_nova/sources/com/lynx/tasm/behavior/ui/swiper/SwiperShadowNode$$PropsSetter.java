package com.lynx.tasm.behavior.ui.swiper;

import androidx.camera.video.AudioStats;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class SwiperShadowNode$$PropsSetter extends CustomLayoutShadowNode$$PropsSetter {
    public SwiperShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r100, String r101, x0 r102) {
        SwiperShadowNode r103 = (SwiperShadowNode) r100;
        r101.getClass();
        switch(r101.hashCode()) {
            case -1984141450: goto L30;
            case -686438324: goto L26;
            case -111166008: goto L22;
            case 3357091: goto L18;
            case 24002884: goto L14;
            case 201065357: goto L10;
            case 1665556140: goto L6;
            default: goto L33;
        };
    L33:
        byte r104 = -1;
    L35:
        switch(r104) {
            case 0: goto L50;
            case 1: goto L48;
            case 2: goto L46;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L38;
            default: goto L36;
        };
    L36:
        super.a(r100, r101, r102);
        return;
    L38:
        r103.setPageMargin(r102.d(r101));
        return;
    L40:
        r103.setMaxYScale(r102.c(r101, AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    L42:
        r103.setPreviousMargin(r102.d(r101));
        return;
    L44:
        r103.setMode(r102.h(r101));
        return;
    L46:
        r103.setNextMargin(r102.d(r101));
        return;
    L48:
        r103.setMaxXScale(r102.c(r101, AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    L50:
        r103.setVertical(r102.b(r101, false));
        return;
    L6:
        if (r101.equals("page-margin") == false) goto L33;
        r104 = 6;
        goto L35
    L10:
        if (r101.equals("max-y-scale") == false) goto L33;
        r104 = 5;
        goto L35
    L14:
        if (r101.equals("previous-margin") == false) goto L33;
        r104 = 4;
        goto L35
    L18:
        if (r101.equals("mode") == false) goto L33;
        r104 = 3;
        goto L35
    L22:
        if (r101.equals("next-margin") == false) goto L33;
        r104 = 2;
        goto L35
    L26:
        if (r101.equals("max-x-scale") == false) goto L33;
        r104 = 1;
        goto L35
    L30:
        if (r101.equals("vertical") == false) goto L33;
        r104 = 0;
        goto L35
    }
}
