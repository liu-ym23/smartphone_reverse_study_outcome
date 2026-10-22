package qr;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lqr/d;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "", "userId", "J", "getUserId", "()J", "", "forceLiveContentResp", "Z", "getForceLiveContentResp", "()Z", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("force_live_content_resp")
    private final boolean forceLiveContentResp;

    @SerializedName("text")
    private final String text;

    @SerializedName("user_id")
    private final long userId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (this.userId == r101.userId) goto L10;
        return false;
    L10:
        if (this.forceLiveContentResp == r101.forceLiveContentResp) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.userId;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        boolean r105 = this.forceLiveContentResp;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.extra;
        if (r108 == null) goto L13;
        r101 = r108.hashCode();
    L13:
        return r107 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveMsgChatReq(text=" + this.text + ", userId=" + this.userId + ", forceLiveContentResp=" + this.forceLiveContentResp + ", extra=" + this.extra + ")";
    }

    public d() {
        this.text = null;
        this.userId = 0;
        this.forceLiveContentResp = false;
        this.extra = null;
    }
}
