package tv6;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Ltv6/d;", "", "", "nextPage", "I", "getNextPage", "()I", "setNextPage", "(I)V", "", "", "videoInfo", "Ljava/util/List;", "getVideoInfo", "()Ljava/util/List;", "setVideoInfo", "(Ljava/util/List;)V", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "totalCount", "getTotalCount", "setTotalCount", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("has_more")
    private Boolean hasMore;

    @SerializedName("next_page")
    private int nextPage;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    private int totalCount;

    @SerializedName("aweme_struct")
    private List<String> videoInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.nextPage == r101.nextPage) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.videoInfo, r101.videoInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L18;
        return false;
    L18:
        if (this.totalCount == r101.totalCount) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.nextPage * 31;
        List<String> r101 = this.videoInfo;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.hasMore;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.totalCount;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoPageStruct(nextPage=" + this.nextPage + ", videoInfo=" + this.videoInfo + ", hasMore=" + this.hasMore + ", totalCount=" + this.totalCount + ')';
    }

    public d() {
        this.nextPage = 0;
        this.videoInfo = null;
        this.hasMore = null;
        this.totalCount = 0;
    }
}
