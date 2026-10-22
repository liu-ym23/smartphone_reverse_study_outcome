package com.lynx.tasm.behavior.ui;

import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class LynxUI$$PropsSetter extends LynxBaseUI$$PropsSetter {
    public LynxUI$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r110) {
        LynxUI r102 = (LynxUI) r100;
        r101.getClass();
        byte r103 = -1;
        switch(r101.hashCode()) {
            case -1970593579: goto L130;
            case -1796753876: goto L126;
            case -1757493843: goto L122;
            case -1649314686: goto L118;
            case -1613231517: goto L114;
            case -1297725862: goto L110;
            case -1274492040: goto L106;
            case -1267206133: goto L102;
            case -1091287993: goto L98;
            case -1087342188: goto L94;
            case -1013209314: goto L90;
            case -412530555: goto L86;
            case -397950676: goto L82;
            case -316342365: goto L78;
            case -127928127: goto L74;
            case -49240502: goto L70;
            case 37625839: goto L66;
            case 315007413: goto L62;
            case 374052076: goto L58;
            case 633600340: goto L54;
            case 714841829: goto L50;
            case 805728555: goto L46;
            case 839919573: goto L42;
            case 949630603: goto L38;
            case 985926797: goto L34;
            case 1052666732: goto L30;
            case 1229849887: goto L26;
            case 1372923181: goto L22;
            case 1485345550: goto L18;
            case 1941332754: goto L14;
            case 1998370329: goto L10;
            case 2022810070: goto L6;
            default: goto L134;
        };
    L6:
        if (r101.equals("layout-animation-create-timing-function") == false) goto L134;
        r103 = 31;
        goto L134
    L10:
        if (r101.equals("layout-animation-create-duration") == false) goto L134;
        r103 = 30;
        goto L134
    L14:
        if (r101.equals(RemoteMessageConst.Notification.VISIBILITY) == false) goto L134;
        r103 = 29;
        goto L134
    L18:
        if (r101.equals("enter-transition-name") == false) goto L134;
        r103 = 28;
        goto L134
    L22:
        if (r101.equals("layout-animation-update-property") == false) goto L134;
        r103 = 27;
        goto L134
    L26:
        if (r101.equals("offset-path") == false) goto L134;
        r103 = 26;
        goto L134
    L30:
        if (r101.equals("transform") == false) goto L134;
        r103 = 25;
        goto L134
    L34:
        if (r101.equals("layout-animation-delete-delay") == false) goto L134;
        r103 = 24;
        goto L134
    L38:
        if (r101.equals("layout-animation-delete-property") == false) goto L134;
        r103 = 23;
        goto L134
    L42:
        if (r101.equals("offset-rotate") == false) goto L134;
        r103 = 22;
        goto L134
    L46:
        if (r101.equals("layout-animation-update-delay") == false) goto L134;
        r103 = 21;
        goto L134
    L50:
        if (r101.equals("enable-reuse-animation-state") == false) goto L134;
        r103 = 20;
        goto L134
    L54:
        if (r101.equals("exit-transition-name") == false) goto L134;
        r103 = 19;
        goto L134
    L58:
        if (r101.equals("layout-animation-update-duration") == false) goto L134;
        r103 = 18;
        goto L134
    L62:
        if (r101.equals("accessibility-label") == false) goto L134;
        r103 = 17;
        goto L134
    L66:
        if (r101.equals("offset-distance") == false) goto L134;
        r103 = 16;
        goto L134
    L70:
        if (r101.equals("layout-animation-delete-duration") == false) goto L134;
        r103 = 15;
        goto L134
    L74:
        if (r101.equals("accessibility-elements-hidden") == false) goto L134;
        r103 = 14;
        goto L134
    L78:
        if (r101.equals("layout-animation-update-timing-function") == false) goto L134;
        r103 = HTTP.CR;
        goto L134
    L82:
        if (r101.equals("hardware-layer") == false) goto L134;
        r103 = 12;
        goto L134
    L86:
        if (r101.equals("layout-animation-delete-timing-function") == false) goto L134;
        r103 = 11;
        goto L134
    L90:
        if (r101.equals("layout-animation-create-delay") == false) goto L134;
        r103 = 10;
        goto L134
    L94:
        if (r101.equals("shared-element") == false) goto L134;
        r103 = 9;
        goto L134
    L98:
        if (r101.equals("overlap") == false) goto L134;
        r103 = 8;
        goto L134
    L102:
        if (r101.equals(GXTemplateKey.STYLE_OPACITY) == false) goto L134;
        r103 = 7;
        goto L134
    L106:
        if (r101.equals("filter") == false) goto L134;
        r103 = 6;
        goto L134
    L110:
        if (r101.equals("layout-animation-create-property") == false) goto L134;
        r103 = 5;
        goto L134
    L114:
        if (r101.equals("resume-transition-name") == false) goto L134;
        r103 = 4;
        goto L134
    L118:
        if (r101.equals("clip-path") == false) goto L134;
        r103 = 3;
        goto L134
    L122:
        if (r101.equals("transform-order") == false) goto L134;
        r103 = 2;
        goto L134
    L126:
        if (r101.equals("pause-transition-name") == false) goto L134;
        r103 = 1;
        goto L134
    L130:
        if (r101.equals("lynx-test-tag") == false) goto L134;
        r103 = 0;
    L134:
        switch(r103) {
            case 0: goto L199;
            case 1: goto L197;
            case 2: goto L195;
            case 3: goto L193;
            case 4: goto L191;
            case 5: goto L189;
            case 6: goto L187;
            case 7: goto L185;
            case 8: goto L183;
            case 9: goto L181;
            case 10: goto L179;
            case 11: goto L177;
            case 12: goto L175;
            case 13: goto L173;
            case 14: goto L171;
            case 15: goto L169;
            case 16: goto L167;
            case 17: goto L165;
            case 18: goto L163;
            case 19: goto L161;
            case 20: goto L159;
            case 21: goto L157;
            case 22: goto L155;
            case 23: goto L153;
            case 24: goto L151;
            case 25: goto L149;
            case 26: goto L147;
            case 27: goto L145;
            case 28: goto L143;
            case 29: goto L141;
            case 30: goto L139;
            case 31: goto L137;
            default: goto L135;
        };
    L135:
        super.setProperty(r100, r101, r110);
        return;
    L137:
        r102.setLayoutAnimationCreateTimingFunc(r110.a(r101));
        return;
    L139:
        r102.setLayoutAnimationCreateDuration(r110.c(r101, AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    L141:
        r102.setVisibility(r110.f(r101, 1));
        return;
    L143:
        r102.setEnterTransitionName(r110.a(r101));
        return;
    L145:
        r102.setLayoutAnimationUpdateProperty(r110.f(r101, 0));
        return;
    L147:
        r102.setOffsetPath(r110.a(r101));
        return;
    L149:
        r102.setTransform(r110.a(r101));
        return;
    L151:
        r102.setLayoutAnimationDeleteDelay(r110.c(r101, AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    L153:
        r102.setLayoutAnimationDeleteProperty(r110.f(r101, 0));
        return;
    L155:
        r102.setOffsetRotate(r110.e(r101, 0.0f));
        return;
    L157:
        r102.setLayoutAnimationUpdateDelay(r110.c(r101, AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    L159:
        r102.setEnableReuseAnimationState(r110.b(r101, true));
        return;
    L161:
        r102.setExitTransitionName(r110.a(r101));
        return;
    L163:
        r102.setLayoutAnimationUpdateDuration(r110.c(r101, AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    L165:
        r102.setAccessibilityLabel(r110.d(r101));
        return;
    L167:
        r102.setOffsetDistance(r110.e(r101, 0.0f));
        return;
    L169:
        r102.setLayoutAnimationDeleteDuration(r110.c(r101, AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    L171:
        r102.setAccessibilityElementsHidden(r110.b(r101, false));
        return;
    L173:
        r102.setLayoutAnimationUpdateTimingFunc(r110.a(r101));
        return;
    L175:
        r102.setRenderToHardwareTexture(r110.b(r101, false));
        return;
    L177:
        r102.setLayoutAnimationDeleteTimingFunc(r110.a(r101));
        return;
    L179:
        r102.setLayoutAnimationCreateDelay(r110.c(r101, AudioStats.AUDIO_AMPLITUDE_NONE));
        return;
    L181:
        r102.setShareElement(r110.h(r101));
        return;
    L183:
        r102.setOverlap(r110.d(r101));
        return;
    L185:
        r102.setAlpha(r110.e(r101, 1.0f));
        return;
    L187:
        r102.setFilter(r110.a(r101));
        return;
    L189:
        r102.setLayoutAnimationCreateProperty(r110.f(r101, 0));
        return;
    L191:
        r102.setResumeTransitionName(r110.a(r101));
        return;
    L193:
        r102.setClipPath(r110.a(r101));
        return;
    L195:
        r102.setTransformOrder(r110.d(r101));
        return;
    L197:
        r102.setPauseTransitionName(r110.a(r101));
        return;
    L199:
        r102.setTestID(r110.h(r101));
    }
}
