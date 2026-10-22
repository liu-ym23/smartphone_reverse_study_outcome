package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lhe3/i0;", "", "", "currentUserCount", "Ljava/lang/Integer;", "getCurrentUserCount", "()Ljava/lang/Integer;", "totalUserCount", "getTotalUserCount", "likeCount", "getLikeCount", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("current_user_count")
    private final Integer currentUserCount;

    @SerializedName("like_count")
    private final Integer likeCount;

    @SerializedName("total_user_count")
    private final Integer totalUserCount;

    public i0() {
        this.currentUserCount = null;
        this.totalUserCount = null;
        this.likeCount = null;
    }
}
