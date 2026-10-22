package he3;

import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lhe3/f;", "", "", "commentId", "Ljava/lang/String;", "getCommentId", "()Ljava/lang/String;", "text", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "userName", "d", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "userAvatar", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "b", "()Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "userIcon", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("comment_id")
    private final String commentId;

    @SerializedName("text")
    private final String text;

    @SerializedName("user_avatar")
    private final ImageURL userAvatar;

    @SerializedName("user_icon")
    private final ImageURL userIcon;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    public f() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.commentId, r101.commentId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userAvatar, r101.userAvatar) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.userIcon, r101.userIcon) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.commentId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.userName;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ImageURL r110 = this.userAvatar;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ImageURL r113 = this.userIcon;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
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

    public f(String r100, String r101, String r102, ImageURL r103, ImageURL r104) {
        this.commentId = r100;
        this.text = r101;
        this.userName = r102;
        this.userAvatar = r103;
        this.userIcon = r104;
    }
}
