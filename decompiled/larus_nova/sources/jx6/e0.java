package jx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011¨\u0006\u0017"}, d2 = {"Ljx6/e0;", "", "Ljx6/g0;", "userInfo", "Ljx6/g0;", "e", "()Ljx6/g0;", "", "Ljx6/f;", "scoreTags", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Ljx6/n;", "thumbnails", "d", "itemId", "b", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("content")
    private final String content;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("score_tags")
    private final List<f> scoreTags;

    @SerializedName("thumbnails")
    private final List<n> thumbnails;

    @SerializedName("user_info")
    private final g0 userInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.userInfo, r101.userInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scoreTags, r101.scoreTags) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.thumbnails, r101.thumbnails) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        g0 r100 = this.userInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<f> r104 = this.scoreTags;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<n> r110 = this.thumbnails;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.itemId;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "UgcItemData(userInfo=" + this.userInfo + ", scoreTags=" + this.scoreTags + ", content=" + this.content + ", thumbnails=" + this.thumbnails + ", itemId=" + this.itemId + ')';
    }

    public e0() {
        this.userInfo = null;
        this.scoreTags = null;
        this.content = null;
        this.thumbnails = null;
        this.itemId = null;
    }

    public final String a() {
        return this.content;
    }

    public final String b() {
        return this.itemId;
    }

    public final List<f> c() {
        return this.scoreTags;
    }

    public final List<n> d() {
        return this.thumbnails;
    }

    public final g0 e() {
        return this.userInfo;
    }
}
