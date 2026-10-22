package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamPushTargetConfig {
    public String pushCDNURL;
    public MixedStreamPushTargetType pushTargetType;
    public String pushWTNStreamID;

    public String getMixedStreamPushTargetTypePushCDNURL() {
        String r100 = this.pushCDNURL;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public int getMixedStreamPushTargetTypePushTargetType() {
        return this.pushTargetType.value();
    }

    public String getMixedStreamPushTargetTypePushWTNStreamID() {
        String r100 = this.pushWTNStreamID;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public MixedStreamPushTargetConfig() {
        this.pushTargetType = MixedStreamPushTargetType.PUSH_TO_CDN;
        this.pushCDNURL = "";
        this.pushWTNStreamID = "";
    }

    public MixedStreamPushTargetConfig(MixedStreamPushTargetType r100, String r101, String r102) {
        MixedStreamPushTargetType r103 = MixedStreamPushTargetType.PUSH_TO_CDN;
        this.pushTargetType = r100;
        this.pushCDNURL = r101;
        this.pushWTNStreamID = r102;
    }
}
