package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/chat/GoMaxReadPositionConfig;", "", "anchorToMaxReadMsg", "", "anchorToPushAndCvsRedDotMsgTop", "backDownToMaxReadFirst", "<init>", "(ZZZ)V", "getAnchorToMaxReadMsg", "()Z", "getAnchorToPushAndCvsRedDotMsgTop", "getBackDownToMaxReadFirst", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class v {

    @SerializedName("anchor_to_max_read_msg")
    private final boolean anchorToMaxReadMsg;

    @SerializedName("anchor_to_push_and_cvs_red_dot_msg_top")
    private final boolean anchorToPushAndCvsRedDotMsgTop;

    @SerializedName("back_down_to_max_read_first")
    private final boolean backDownToMaxReadFirst;

    public v() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.anchorToMaxReadMsg == r101.anchorToMaxReadMsg) goto L12;
        return false;
    L12:
        if (this.anchorToPushAndCvsRedDotMsgTop == r101.anchorToPushAndCvsRedDotMsgTop) goto L15;
        return false;
    L15:
        if (this.backDownToMaxReadFirst == r101.backDownToMaxReadFirst) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.anchorToMaxReadMsg == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.anchorToPushAndCvsRedDotMsgTop == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.backDownToMaxReadFirst == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "GoMaxReadPositionConfig(anchorToMaxReadMsg=" + this.anchorToMaxReadMsg + ", anchorToPushAndCvsRedDotMsgTop=" + this.anchorToPushAndCvsRedDotMsgTop + ", backDownToMaxReadFirst=" + this.backDownToMaxReadFirst + ')';
    }

    public final boolean a() {
        return this.anchorToMaxReadMsg;
    }

    public final boolean b() {
        return this.anchorToPushAndCvsRedDotMsgTop;
    }

    public final boolean c() {
        return this.backDownToMaxReadFirst;
    }

    public v(int r100) {
        this.anchorToMaxReadMsg = false;
        this.anchorToPushAndCvsRedDotMsgTop = false;
        this.backDownToMaxReadFirst = false;
    }
}
