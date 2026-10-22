package he3;

import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lhe3/o0;", "", "", "tabType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "d", "", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "images", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lhe3/e2;", "videos", "e", "Lhe3/h;", "commentInfo", "Lhe3/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lhe3/h;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o0 {

    @SerializedName("comment_info")
    private final h commentInfo;

    @SerializedName("images")
    private final List<ImageURL> images;

    @SerializedName("tab_type")
    private final String tabType;

    @SerializedName("title")
    private final String title;

    @SerializedName("videos")
    private final List<e2> videos;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == false) goto L16;
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videos, r101.videos) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.commentInfo, r101.commentInfo) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.tabType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<ImageURL> r107 = this.images;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<e2> r110 = this.videos;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        h r113 = this.commentInfo;
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
        return "DeepFeedTabItem(tabType=" + this.tabType + ", title=" + this.title + ", images=" + this.images + ", videos=" + this.videos + ", commentInfo=" + this.commentInfo + ")";
    }

    public o0() {
        this.tabType = null;
        this.title = null;
        this.images = null;
        this.videos = null;
        this.commentInfo = null;
    }

    public final h a() {
        return this.commentInfo;
    }

    public final List<ImageURL> b() {
        return this.images;
    }

    public final String c() {
        return this.tabType;
    }

    public final String d() {
        return this.title;
    }

    public final List<e2> e() {
        return this.videos;
    }
}
