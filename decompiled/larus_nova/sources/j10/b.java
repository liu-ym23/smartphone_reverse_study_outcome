package j10;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lj10/b;", "", "", "feedbackId", "J", "getFeedbackId", "()J", "", "errCode", "I", "getErrCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("err_code")
    private final int errCode;

    @SerializedName("feedback_id")
    private final long feedbackId;

    @SerializedName("message")
    private final String message;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.feedbackId == r101.feedbackId) goto L8;
        return false;
    L8:
        if (this.errCode == r101.errCode) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.feedbackId;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.errCode) * 31;
        String r102 = this.message;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "InteractGamePostFeedbackResponse(feedbackId=" + this.feedbackId + ", errCode=" + this.errCode + ", message=" + this.message + ")";
    }
}
