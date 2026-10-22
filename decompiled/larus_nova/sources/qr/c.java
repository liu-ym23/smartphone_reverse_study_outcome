package qr;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lqr/c;", "", "", "type", "I", "getType", "()I", "", WsConstants.KEY_PAYLOAD, "Ljava/lang/String;", "getPayload", "()Ljava/lang/String;", RemoteMessageConst.MSGID, "getMsgId", "reqMsgId", "getReqMsgId", "", "msgIndex", "J", "getMsgIndex", "()J", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("msg_id")
    private final String msgId;

    @SerializedName("msg_idx")
    private final long msgIndex;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    private final String payload;

    @SerializedName("resp_for")
    private final String reqMsgId;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    private final int type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.msgId, r101.msgId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reqMsgId, r101.reqMsgId) == true) goto L14;
        return false;
    L14:
        if (this.msgIndex == r101.msgIndex) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.type * 31;
        String r101 = this.payload;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.msgId;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.reqMsgId;
        if (r108 == null) goto L13;
        r102 = r108.hashCode();
    L13:
        long r109 = this.msgIndex;
        return ((r107 + r102) * 31) + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveMsg(type=" + this.type + ", payload=" + this.payload + ", msgId=" + this.msgId + ", reqMsgId=" + this.reqMsgId + ", msgIndex=" + this.msgIndex + ")";
    }

    public c() {
        this.type = 0;
        this.payload = null;
        this.msgId = null;
        this.reqMsgId = null;
        this.msgIndex = 0;
    }

    public final int getType() {
        return this.type;
    }
}
