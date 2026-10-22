package sj3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lsj3/m;", "", "", "height", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "width", "c", "", "uri", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "urlList", "Ljava/util/List;", "getUrlList", "()Ljava/util/List;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("height")
    private final Integer height;

    @SerializedName("uri")
    private final String uri;

    @SerializedName("url_list")
    private final List<String> urlList;

    @SerializedName("width")
    private final Integer width;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L14;
        m r4 = (m) r3;
        if (Intrinsics.areEqual(this.height, r4.height) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.width, r4.width) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlList, r4.urlList) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.height;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.width;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.uri;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.urlList;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "TagIconInfoDTO(height=" + this.height + ", width=" + this.width + ", uri=" + this.uri + ", urlList=" + this.urlList + ")";
    }

    public m() {
        this.height = null;
        this.width = null;
        this.uri = null;
        this.urlList = null;
    }

    public final Integer a() {
        return this.height;
    }

    public final String b() {
        return this.uri;
    }

    public final Integer c() {
        return this.width;
    }
}
