package jv6;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ljv6/e;", "", "", RemoteMessageConst.MessageBody.MSG_CONTENT, "Ljava/lang/String;", "getMsgContent", "()Ljava/lang/String;", "setMsgContent", "(Ljava/lang/String;)V", "", "msgType", "Ljava/lang/Integer;", "getMsgType", "()Ljava/lang/Integer;", "setMsgType", "(Ljava/lang/Integer;)V", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("msg_content")
    private String msgContent;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    private Integer msgType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.msgContent, r101.msgContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msgType, r101.msgType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.msgContent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.msgType;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "IMInfo(msgContent=" + this.msgContent + ", msgType=" + this.msgType + ')';
    }
}
