package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lhe3/j1;", "", "Lhe3/f1;", "button", "Lhe3/f1;", "a", "()Lhe3/f1;", "", "commentCount", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setCommentCount", "(Ljava/lang/Long;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j1 {

    @SerializedName("button")
    private final f1 button;

    @SerializedName("comment_count")
    private Long commentCount;

    public j1() {
    }

    public final f1 a() {
        return this.button;
    }

    public final Long b() {
        return this.commentCount;
    }
}
