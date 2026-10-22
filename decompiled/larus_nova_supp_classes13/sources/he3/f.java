package he3;

import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lhe3/f;", "", "", "commentId", "Ljava/lang/String;", "getCommentId", "()Ljava/lang/String;", "text", "a", "userName", "d", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "userAvatar", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "b", "()Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "userIcon", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("comment_id")
    private final String commentId;

    @SerializedName("text")
    private final String text;

    @SerializedName("user_avatar")
    private final ImageURL userAvatar;

    @SerializedName("user_icon")
    private final ImageURL userIcon;

    @SerializedName("user_name")
    private final String userName;

    public f() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L16;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.commentId, r4.commentId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.userName, r4.userName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userAvatar, r4.userAvatar) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.userIcon, r4.userIcon) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.commentId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.text;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.userName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ImageURL r10 = this.userAvatar;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ImageURL r13 = this.userIcon;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedCommentContent(commentId=" + this.commentId + ", text=" + this.text + ", userName=" + this.userName + ", userAvatar=" + this.userAvatar + ", userIcon=" + this.userIcon + ")";
    }

    public final String a() {
        return this.text;
    }

    public final ImageURL b() {
        return this.userAvatar;
    }

    public final ImageURL c() {
        return this.userIcon;
    }

    public final String d() {
        return this.userName;
    }

    public f(String r1, String r2, String r3, ImageURL r4, ImageURL r5) {
        this.commentId = r1;
        this.text = r2;
        this.userName = r3;
        this.userAvatar = r4;
        this.userIcon = r5;
    }
}
