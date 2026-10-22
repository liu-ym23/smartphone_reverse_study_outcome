package jv6;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Ljv6/p;", "", "", "", "userImg", "Ljava/util/List;", "getUserImg", "()Ljava/util/List;", "userName", "Ljava/lang/String;", "getUserName", "()Ljava/lang/String;", "", "userId", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "secUserId", "getSecUserId", "", "hasDraw", "Ljava/lang/Boolean;", "getHasDraw", "()Ljava/lang/Boolean;", "lifeShareId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("has_draw")
    private final Boolean hasDraw;

    @SerializedName("life_share_id")
    private final String lifeShareId;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("user_id")
    private final Long userId;

    @SerializedName("user_img")
    private final List<String> userImg;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.userImg, r101.userImg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.secUserId, r101.secUserId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hasDraw, r101.hasDraw) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lifeShareId, r101.lifeShareId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.userImg;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.userName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.userId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.secUserId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.hasDraw;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.lifeShareId;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareUserInfo(userImg=" + this.userImg + ", userName=" + this.userName + ", userId=" + this.userId + ", secUserId=" + this.secUserId + ", hasDraw=" + this.hasDraw + ", lifeShareId=" + this.lifeShareId + ')';
    }

    public p() {
        this.userImg = null;
        this.userName = null;
        this.userId = null;
        this.secUserId = null;
        this.hasDraw = null;
        this.lifeShareId = null;
    }

    public final String a() {
        return this.lifeShareId;
    }

    public final Long b() {
        return this.userId;
    }
}
