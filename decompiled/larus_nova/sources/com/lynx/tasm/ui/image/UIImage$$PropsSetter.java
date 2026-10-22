package com.lynx.tasm.ui.image;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.hybrid.xelement.ecomimage.ECLynxImage;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.image.AbsUIImage$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes32.dex */
public class UIImage$$PropsSetter extends AbsUIImage$$PropsSetter {
    public UIImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r100, String r101, x0 r102) {
        UIImage r103 = (UIImage) r100;
        r101.getClass();
        byte r104 = -1;
        switch(r101.hashCode()) {
            case -1937917490: goto L126;
            case -1900756664: goto L122;
            case -1492006372: goto L118;
            case -1338903714: goto L114;
            case -1320385523: goto L110;
            case -1138223116: goto L106;
            case -1059824547: goto L102;
            case -931992873: goto L98;
            case -602643660: goto L94;
            case 259555579: goto L90;
            case 263914060: goto L86;
            case 305374695: goto L82;
            case 512852970: goto L78;
            case 516005201: goto L74;
            case 660415178: goto L70;
            case 828761943: goto L66;
            case 893413739: goto L62;
            case 902281110: goto L58;
            case 1090746891: goto L54;
            case 1145216977: goto L50;
            case 1245269388: goto L46;
            case 1282944765: goto L42;
            case 1338737543: goto L38;
            case 1439562083: goto L34;
            case 1672916293: goto L30;
            case 1739487650: goto L26;
            case 1856274660: goto L22;
            case 1860054545: goto L18;
            case 1941332754: goto L14;
            case 1998893929: goto L10;
            case 2141225912: goto L6;
            default: goto L129;
        };
    L129:
        switch(r104) {
            case 0: goto L192;
            case 1: goto L190;
            case 2: goto L188;
            case 3: goto L186;
            case 4: goto L184;
            case 5: goto L182;
            case 6: goto L180;
            case 7: goto L178;
            case 8: goto L176;
            case 9: goto L174;
            case 10: goto L172;
            case 11: goto L170;
            case 12: goto L168;
            case 13: goto L166;
            case 14: goto L164;
            case 15: goto L162;
            case 16: goto L160;
            case 17: goto L158;
            case 18: goto L156;
            case 19: goto L154;
            case 20: goto L152;
            case 21: goto L150;
            case 22: goto L148;
            case 23: goto L146;
            case 24: goto L144;
            case 25: goto L142;
            case 26: goto L140;
            case 27: goto L138;
            case 28: goto L136;
            case 29: goto L134;
            case 30: goto L132;
            default: goto L130;
        };
    L130:
        super.setProperty(r100, r101, r102);
        return;
    L132:
        r103.setExtraLoadInfo(r102.b(r101, false));
        return;
    L134:
        r103.setEnableCustomGifDecoder(r102.b(r101, false));
        return;
    L136:
        r103.setVisibility(r102.f(r101, 1));
        return;
    L138:
        r103.setTintColor(r102.h(r101));
        return;
    L140:
        r103.setCustomParams(r102.g(r101));
        return;
    L142:
        r103.setDeferInvalidation(r102.b(r101, false));
        return;
    L144:
        r103.fixFrescoWebPBug(r102.b(r101, false));
        return;
    L146:
        r103.setAutoPlay(r102.b(r101, true));
        return;
    L148:
        r103.setImagePlaceHolderHashConfig(r102.g(r101));
        return;
    L150:
        r103.setCacheKeyPathOnly(r102.b(r101, false));
        return;
    L152:
        r103.setFrescoAttach(r102.h(r101));
        return;
    L154:
        r103.setEnableSmoothAnimation(r102.b(r101, false));
        return;
    L156:
        r103.setFrescoVisible(r102.h(r101));
        return;
    L158:
        r103.setSuspendable(r102.d(r101));
        return;
    L160:
        r103.setImageTransitionStyle(r102.h(r101));
        return;
    L162:
        r103.setImageRequestPriority(r102.h(r101));
        return;
    L164:
        r103.setProgressiveRendering(r102.b(r101, false));
        return;
    L166:
        r103.setCapInsetsBackUp(r102.h(r101));
        return;
    L168:
        r103.setSubSample(r102.h(r101));
        return;
    L170:
        r103.setRegionToDecode(r102.g(r101));
        return;
    L172:
        r103.setImageCacheChoice(r102.h(r101));
        return;
    L174:
        r103.setImageSRScale(r102.e(r101, 0.0f));
        return;
    L176:
        r103.setFrescoNinePatch(r102.b(r101, false));
        return;
    L178:
        r103.setSimpleCacheKey(r102.b(r101, true));
        return;
    L180:
        r103.setEnableReportInfo(r102.b(r101, false));
        return;
    L182:
        r103.setImageConfig(r102.h(r101));
        return;
    L184:
        r103.setAsyncRedirect(r102.b(r101, false));
        return;
    L186:
        r103.setSkipRedirection(r102.b(r101, false));
        return;
    L188:
        r103.setEnableResourceHint(r102.b(r101, false));
        return;
    L190:
        r103.setImageSR(r102.b(r101, false));
        return;
    L192:
        r103.setCapInsetsScale(r102.h(r101));
        return;
    L6:
        if (r101.equals("extra-load-info") == false) goto L129;
        r104 = 30;
        goto L129
    L10:
        if (r101.equals("enable-custom-gif-decoder") == false) goto L129;
        r104 = 29;
        goto L129
    L14:
        if (r101.equals(RemoteMessageConst.Notification.VISIBILITY) == false) goto L129;
        r104 = 28;
        goto L129
    L18:
        if (r101.equals("tint-color") == false) goto L129;
        r104 = 27;
        goto L129
    L22:
        if (r101.equals("additional-custom-info") == false) goto L129;
        r104 = 26;
        goto L129
    L26:
        if (r101.equals(ECLynxImage.DEFER_SRC_INVALIDATION) == false) goto L129;
        r104 = 25;
        goto L129
    L30:
        if (r101.equals("fix-fresco-bug") == false) goto L129;
        r104 = 24;
        goto L129
    L34:
        if (r101.equals("autoplay") == false) goto L129;
        r104 = 23;
        goto L129
    L38:
        if (r101.equals("placeholder-hash-config") == false) goto L129;
        r104 = 22;
        goto L129
    L42:
        if (r101.equals("android-cache-key-path-only") == false) goto L129;
        r104 = 21;
        goto L129
    L46:
        if (r101.equals("fresco-attach") == false) goto L129;
        r104 = 20;
        goto L129
    L50:
        if (r101.equals("android-enable-smooth-animation") == false) goto L129;
        r104 = 19;
        goto L129
    L54:
        if (r101.equals("fresco-visible") == false) goto L129;
        r104 = 18;
        goto L129
    L58:
        if (r101.equals("suspendable") == false) goto L129;
        r104 = 17;
        goto L129
    L62:
        if (r101.equals("image-transition-style") == false) goto L129;
        r104 = 16;
        goto L129
    L66:
        if (r101.equals("fetch-priority") == false) goto L129;
        r104 = 15;
        goto L129
    L70:
        if (r101.equals("progressive-rendering") == false) goto L129;
        r104 = 14;
        goto L129
    L74:
        if (r101.equals("cap-insets") == false) goto L129;
        r104 = HTTP.CR;
        goto L129
    L78:
        if (r101.equals("subsample") == false) goto L129;
        r104 = 12;
        goto L129
    L82:
        if (r101.equals("region-to-decode") == false) goto L129;
        r104 = 11;
        goto L129
    L86:
        if (r101.equals("cache-choice") == false) goto L129;
        r104 = 10;
        goto L129
    L90:
        if (r101.equals("super-resolution-scale") == false) goto L129;
        r104 = 9;
        goto L129
    L94:
        if (r101.equals("fresco-nine-patch") == false) goto L129;
        r104 = 8;
        goto L129
    L98:
        if (r101.equals("android-simple-cache-key") == false) goto L129;
        r104 = 7;
        goto L129
    L102:
        if (r101.equals("enable-report-info") == false) goto L129;
        r104 = 6;
        goto L129
    L106:
        if (r101.equals("image-config") == false) goto L129;
        r104 = 5;
        goto L129
    L110:
        if (r101.equals("async-redirect") == false) goto L129;
        r104 = 4;
        goto L129
    L114:
        if (r101.equals("skip-redirection") == false) goto L129;
        r104 = 3;
        goto L129
    L118:
        if (r101.equals("enable-resource-hint") == false) goto L129;
        r104 = 2;
        goto L129
    L122:
        if (r101.equals("enable-super-resolution") == false) goto L129;
        r104 = 1;
        goto L129
    L126:
        if (r101.equals("cap-insets-scale") == false) goto L129;
        r104 = 0;
        goto L129
    }
}
