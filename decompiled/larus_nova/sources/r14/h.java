package r14;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lr14/h;", "", "", "recommendType", "J", "getRecommendType", "()J", "setRecommendType", "(J)V", "", "relationTextKey", "Ljava/lang/String;", "getRelationTextKey", "()Ljava/lang/String;", "setRelationTextKey", "(Ljava/lang/String;)V", "recType", "getRecType", "setRecType", "friendTypeStr", "getFriendTypeStr", "setFriendTypeStr", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class h {

    @SerializedName("friend_type_str")
    private String friendTypeStr;

    @SerializedName("rec_type")
    private String recType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_TYPE)
    private long recommendType;

    @SerializedName("relation_text_key")
    private String relationTextKey;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.recommendType == r101.recommendType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.relationTextKey, r101.relationTextKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.recType, r101.recType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.friendTypeStr, r101.friendTypeStr) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.recommendType;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.relationTextKey;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.recType;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.friendTypeStr;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        return r108 + r103;
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "AwemeRelationRecommendModel(recommendType=" + this.recommendType + ", relationTextKey=" + this.relationTextKey + ", recType=" + this.recType + ", friendTypeStr=" + this.friendTypeStr + ')';
    }
}
