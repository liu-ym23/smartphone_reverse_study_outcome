package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRemoteStreamSwitch;

/* JADX INFO: loaded from: classes40.dex */
public class RemoteStreamSwitch {
    public boolean afterEnable;
    public int afterVideoIndex;
    public boolean beforeEnable;
    public int beforeVideoIndex;
    public boolean isScreen;
    public FallbackOrRecoverReason reason;
    public String uid;

    public RemoteStreamSwitch() {
    }

    public String toString() {
        return "RemoteStreamSwitch{uid='" + this.uid + "', isScreen='" + this.isScreen + "', before_video_index='" + this.beforeVideoIndex + "', after_video_index='" + this.afterVideoIndex + "', before_enable='" + this.beforeEnable + "', after_enable='" + this.afterEnable + "', reason='" + this.reason + "'}";
    }

    public RemoteStreamSwitch(InternalRemoteStreamSwitch r100) {
        this.uid = r100.uid;
        this.beforeVideoIndex = r100.beforeVideoIndex;
        this.afterVideoIndex = r100.afterVideoIndex;
        this.beforeEnable = r100.beforeEnable;
        this.afterEnable = r100.afterEnable;
        this.reason = getFallbackOrRecoverReason(r100.reason);
    }

    private FallbackOrRecoverReason getFallbackOrRecoverReason(int r100) {
        switch(r100) {
            case 0: goto L12;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L13;
        };
    L13:
        return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_UNKNOWN;
    L14:
        return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE;
    L15:
        return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH;
    L16:
        return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE;
    L17:
        return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH;
    L18:
        return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE;
    L19:
        return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH;
    L20:
        return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE;
    L12:
        return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH;
    }
}
