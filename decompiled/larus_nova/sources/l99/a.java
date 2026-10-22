package l99;

import com.google.gson.annotations.SerializedName;
import com.larus.extension.offline_message.api.model.SendMessageUplinkBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/extension/offline_message/api/model/PutMessageUplinkBody;", "", "putMessageBody", "Lcom/larus/extension/offline_message/api/model/SendMessageUplinkBody;", "userType", "", "<init>", "(Lcom/larus/extension/offline_message/api/model/SendMessageUplinkBody;I)V", "getPutMessageBody", "()Lcom/larus/extension/offline_message/api/model/SendMessageUplinkBody;", "setPutMessageBody", "(Lcom/larus/extension/offline_message/api/model/SendMessageUplinkBody;)V", "getUserType", "()I", "setUserType", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("put_message_body")
    private SendMessageUplinkBody putMessageBody;

    @SerializedName("user_type")
    private int userType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.putMessageBody, r101.putMessageBody) == true) goto L12;
        return false;
    L12:
        if (this.userType == r101.userType) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        SendMessageUplinkBody r100 = this.putMessageBody;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.userType;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "PutMessageUplinkBody(putMessageBody=" + this.putMessageBody + ", userType=" + this.userType + ')';
    }

    public a() {
        this.putMessageBody = null;
        this.userType = 0;
    }
}
