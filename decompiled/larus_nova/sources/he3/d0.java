package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lhe3/d0;", "", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "title", "getTitle", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "authorId", "getAuthorId", "secAuthorId", "getSecAuthorId", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("title")
    private final String title;

    public d0() {
        this.roomId = null;
        this.title = null;
        this.status = null;
        this.authorId = null;
        this.secAuthorId = null;
    }
}
