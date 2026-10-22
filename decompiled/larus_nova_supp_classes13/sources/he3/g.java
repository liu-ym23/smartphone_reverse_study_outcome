package he3;

import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lhe3/g;", "", "", "commentId", "Ljava/lang/String;", "getCommentId", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "image", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "a", "()Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("comment_id")
    private final String commentId;

    @SerializedName("image")
    private final ImageURL image;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L10;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.commentId, r4.commentId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.commentId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ImageURL r4 = this.image;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedCommentImage(commentId=" + this.commentId + ", image=" + this.image + ")";
    }

    public g() {
        this.commentId = null;
        this.image = null;
    }

    public final ImageURL a() {
        return this.image;
    }
}
