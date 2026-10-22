package com.bytedance.lynx.media;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.x0;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;

/* JADX INFO: loaded from: classes21.dex */
public class AbsMediaEngineView$$PropsSetter extends UISimpleView$$PropsSetter {
    public AbsMediaEngineView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        AbsMediaEngineView r103 = (AbsMediaEngineView) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1869688179: goto L110;
            case -1818677004: goto L106;
            case -1768477940: goto L102;
            case -1600030548: goto L98;
            case -1489589134: goto L94;
            case -1326197564: goto L90;
            case -810883302: goto L86;
            case -642624357: goto L82;
            case -455669834: goto L78;
            case -83209062: goto L74;
            case -51537065: goto L70;
            case -17124500: goto L66;
            case 114586: goto L62;
            case 116753: goto L58;
            case 3327652: goto L54;
            case 3493088: goto L50;
            case 104264043: goto L46;
            case 109641799: goto L42;
            case 110541305: goto L38;
            case 269397981: goto L34;
            case 510966438: goto L30;
            case 560180969: goto L26;
            case 795307910: goto L22;
            case 1065675907: goto L18;
            case 1261144289: goto L14;
            case 1877609302: goto L10;
            case 2096002969: goto L6;
            default: goto L114;
        };
    L6:
        if (r101.equals("pause-on-hide") == false) goto L114;
        r104 = 26;
        goto L114
    L10:
        if (r101.equals("play-url") == false) goto L114;
        r104 = 25;
        goto L114
    L14:
        if (r101.equals("player-option") == false) goto L114;
        r104 = 24;
        goto L114
    L18:
        if (r101.equals("object-fit") == false) goto L114;
        r104 = 23;
        goto L114
    L22:
        if (r101.equals("headers") == false) goto L114;
        r104 = 22;
        goto L114
    L26:
        if (r101.equals("auto-prepare") == false) goto L114;
        r104 = 21;
        goto L114
    L30:
        if (r101.equals("player-type") == false) goto L114;
        r104 = 20;
        goto L114
    L34:
        if (r101.equals("inittime") == false) goto L114;
        r104 = 19;
        goto L114
    L38:
        if (r101.equals("token") == false) goto L114;
        r104 = 18;
        goto L114
    L42:
        if (r101.equals("speed") == false) goto L114;
        r104 = 17;
        goto L114
    L46:
        if (r101.equals("muted") == false) goto L114;
        r104 = 16;
        goto L114
    L50:
        if (r101.equals("rate") == false) goto L114;
        r104 = 15;
        goto L114
    L54:
        if (r101.equals("loop") == false) goto L114;
        r104 = 14;
        goto L114
    L58:
        if (r101.equals("vid") == false) goto L114;
        r104 = HTTP.CR;
        goto L114
    L62:
        if (r101.equals("tag") == false) goto L114;
        r104 = 12;
        goto L114
    L66:
        if (r101.equals("cache-size") == false) goto L114;
        r104 = 11;
        goto L114
    L70:
        if (r101.equals("video-model") == false) goto L114;
        r104 = 10;
        goto L114
    L74:
        if (r101.equals("extended-params") == false) goto L114;
        r104 = 9;
        goto L114
    L78:
        if (r101.equals("initial-time") == false) goto L114;
        r104 = 8;
        goto L114
    L82:
        if (r101.equals("preload-key") == false) goto L114;
        r104 = 7;
        goto L114
    L86:
        if (r101.equals(ITTVideoEngineEventSource.KEY_VOLUME) == false) goto L114;
        r104 = 6;
        goto L114
    L90:
        if (r101.equals("domain") == false) goto L114;
        r104 = 5;
        goto L114
    L94:
        if (r101.equals("objectfit") == false) goto L114;
        r104 = 4;
        goto L114
    L98:
        if (r101.equals("resolution") == false) goto L114;
        r104 = 3;
        goto L114
    L102:
        if (r101.equals("experimental-force-prepare-play-after-surface-available") == false) goto L114;
        r104 = 2;
        goto L114
    L106:
        if (r101.equals("skip-prepare-check") == false) goto L114;
        r104 = 1;
        goto L114
    L110:
        if (r101.equals("sub-tag") == false) goto L114;
        r104 = 0;
    L114:
        switch(r104) {
            case 0: goto L169;
            case 1: goto L167;
            case 2: goto L165;
            case 3: goto L163;
            case 4: goto L161;
            case 5: goto L159;
            case 6: goto L157;
            case 7: goto L155;
            case 8: goto L153;
            case 9: goto L151;
            case 10: goto L149;
            case 11: goto L147;
            case 12: goto L145;
            case 13: goto L143;
            case 14: goto L141;
            case 15: goto L139;
            case 16: goto L137;
            case 17: goto L135;
            case 18: goto L133;
            case 19: goto L131;
            case 20: goto L129;
            case 21: goto L127;
            case 22: goto L125;
            case 23: goto L123;
            case 24: goto L121;
            case 25: goto L119;
            case 26: goto L117;
            default: goto L115;
        };
    L115:
        super.setProperty(r100, r101, r102);
        return;
    L117:
        r103.setPauseOnHide(r102.b(r101, false));
        return;
    L119:
        r103.setPlayUrl(r102.h(r101));
        return;
    L121:
        r103.setPlayerOption(r102.g(r101));
        return;
    L123:
        r103.setObjectFit(r102.h(r101));
        return;
    L125:
        r103.setHeaders(r102.g(r101));
        return;
    L127:
        r103.setAutoPrepare(r102.b(r101, false));
        return;
    L129:
        r103.setPlayerType(r102.h(r101));
        return;
    L131:
        r103.setDeprecatedInitTime(r102.f(r101, 0));
        return;
    L133:
        r103.setToken(r102.h(r101));
        return;
    L135:
        r103.setSpeed(r102.e(r101, 0.0f));
        return;
    L137:
        r103.setMuted(r102.b(r101, false));
        return;
    L139:
        r103.setRate(r102.f(r101, 0));
        return;
    L141:
        r103.setLoop(r102.b(r101, false));
        return;
    L143:
        r103.setVid(r102.h(r101));
        return;
    L145:
        r103.setVideoTag(r102.h(r101));
        return;
    L147:
        r103.setCacheSize(r102.f(r101, 0));
        return;
    L149:
        r103.setVideoModel(r102.h(r101));
        return;
    L151:
        r103.setExtendedParams(r102.g(r101));
        return;
    L153:
        r103.setInitTime(r102.f(r101, 0));
        return;
    L155:
        r103.setPreloadKey(r102.h(r101));
        return;
    L157:
        r103.setVolume(r102.e(r101, 0.0f));
        return;
    L159:
        r103.setDomain(r102.h(r101));
        return;
    L161:
        r103.setDeprecatedObjectFit(r102.h(r101));
        return;
    L163:
        r103.setResolution(r102.h(r101));
        return;
    L165:
        r103.setForcePreparePlayAfterSurfaceAvailable(r102.h(r101));
        return;
    L167:
        r103.setSkipPrepareCheck(r102.b(r101, false));
        return;
    L169:
        r103.setVideoSubTag(r102.h(r101));
    }
}
