package gf2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lgf2/b;", "", "", "type", "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "", "statusCode", "Ljava/lang/Integer;", "getStatusCode", "()Ljava/lang/Integer;", "minCursor", "getMinCursor", "maxCursor", "b", "", "hasMore", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "Lgf2/a;", "videoList", "Ljava/util/List;", "c", "()Ljava/util/List;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("max_cursor")
    private final Long maxCursor;

    @SerializedName("min_cursor")
    private final Long minCursor;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("type")
    private final Long type;

    @SerializedName("video_list")
    private final List<a> videoList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.minCursor, r101.minCursor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxCursor, r101.maxCursor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.videoList, r101.videoList) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.statusCode;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.minCursor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.maxCursor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.hasMore;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<a> r116 = this.videoList;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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
        return "LinkVideoListResponse(type=" + this.type + ", statusCode=" + this.statusCode + ", minCursor=" + this.minCursor + ", maxCursor=" + this.maxCursor + ", hasMore=" + this.hasMore + ", videoList=" + this.videoList + ")";
    }

    public b() {
        this.type = null;
        this.statusCode = null;
        this.minCursor = null;
        this.maxCursor = null;
        this.hasMore = null;
        this.videoList = null;
    }

    public final Boolean a() {
        return this.hasMore;
    }

    public final Long b() {
        return this.maxCursor;
    }

    public final List<a> c() {
        return this.videoList;
    }

    public final Long getType() {
        return this.type;
    }
}
