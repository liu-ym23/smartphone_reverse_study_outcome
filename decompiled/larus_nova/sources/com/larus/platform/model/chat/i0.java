package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/platform/model/chat/NexPulseApiConfig;", "", "enableOfficeNewConversationInstantCache", "", "backgroundClearWcbMsg", "backgroundClearMsgLimit", "", "backgroundClearMinMessageCnt", "backgroundClearMinWcbLimit", "backgroundClearExpireSeconds", "", "<init>", "(ZZIIIJ)V", "getEnableOfficeNewConversationInstantCache", "()Z", "getBackgroundClearWcbMsg", "getBackgroundClearMsgLimit", "()I", "getBackgroundClearMinMessageCnt", "getBackgroundClearMinWcbLimit", "getBackgroundClearExpireSeconds", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i0 {

    @SerializedName("background_clear_expire_seconds")
    private final long backgroundClearExpireSeconds;

    @SerializedName("background_clear_min_message_cnt")
    private final int backgroundClearMinMessageCnt;

    @SerializedName("background_clear_min_wcb_limit")
    private final int backgroundClearMinWcbLimit;

    @SerializedName("background_clear_msg_limit")
    private final int backgroundClearMsgLimit;

    @SerializedName("background_clear_wcb_msg")
    private final boolean backgroundClearWcbMsg;

    @SerializedName("enable_office_new_conversation_instant_cache")
    private final boolean enableOfficeNewConversationInstantCache;

    public i0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (this.enableOfficeNewConversationInstantCache == r101.enableOfficeNewConversationInstantCache) goto L12;
        return false;
    L12:
        if (this.backgroundClearWcbMsg == r101.backgroundClearWcbMsg) goto L15;
        return false;
    L15:
        if (this.backgroundClearMsgLimit == r101.backgroundClearMsgLimit) goto L18;
        return false;
    L18:
        if (this.backgroundClearMinMessageCnt == r101.backgroundClearMinMessageCnt) goto L21;
        return false;
    L21:
        if (this.backgroundClearMinWcbLimit == r101.backgroundClearMinWcbLimit) goto L24;
        return false;
    L24:
        if (this.backgroundClearExpireSeconds == r101.backgroundClearExpireSeconds) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableOfficeNewConversationInstantCache == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.backgroundClearWcbMsg == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((((((r102 + r100) * 31) + this.backgroundClearMsgLimit) * 31) + this.backgroundClearMinMessageCnt) * 31) + this.backgroundClearMinWcbLimit) * 31;
        long r104 = this.backgroundClearExpireSeconds;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "NexPulseApiConfig(enableOfficeNewConversationInstantCache=" + this.enableOfficeNewConversationInstantCache + ", backgroundClearWcbMsg=" + this.backgroundClearWcbMsg + ", backgroundClearMsgLimit=" + this.backgroundClearMsgLimit + ", backgroundClearMinMessageCnt=" + this.backgroundClearMinMessageCnt + ", backgroundClearMinWcbLimit=" + this.backgroundClearMinWcbLimit + ", backgroundClearExpireSeconds=" + this.backgroundClearExpireSeconds + ')';
    }

    public final long a() {
        return this.backgroundClearExpireSeconds;
    }

    public final int b() {
        return this.backgroundClearMinMessageCnt;
    }

    public final int c() {
        return this.backgroundClearMinWcbLimit;
    }

    public final int d() {
        return this.backgroundClearMsgLimit;
    }

    public final boolean e() {
        return this.backgroundClearWcbMsg;
    }

    public i0(int r100) {
        this.enableOfficeNewConversationInstantCache = true;
        this.backgroundClearWcbMsg = false;
        this.backgroundClearMsgLimit = 20;
        this.backgroundClearMinMessageCnt = 10;
        this.backgroundClearMinWcbLimit = 5;
        this.backgroundClearExpireSeconds = 7200;
    }
}
