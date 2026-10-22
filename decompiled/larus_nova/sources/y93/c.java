package y93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Ly93/c;", "", "", "loadMoreStart", "Ljava/lang/Long;", "getLoadMoreStart", "()Ljava/lang/Long;", "loadMoreEnd", "getLoadMoreEnd", "", "loadMoreVisible", "Ljava/lang/Integer;", "getLoadMoreVisible", "()Ljava/lang/Integer;", "loadMoreVisibleTime", "getLoadMoreVisibleTime", "status", "getStatus", "errCode", "getErrCode", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("error_code")
    private final Integer errCode;

    @SerializedName("t_load_more_end")
    private final Long loadMoreEnd;

    @SerializedName("t_load_more_start")
    private final Long loadMoreStart;

    @SerializedName("load_more_visible")
    private final Integer loadMoreVisible;

    @SerializedName("t_load_more_visible")
    private final Long loadMoreVisibleTime;

    @SerializedName("status")
    private final Integer status;

    public c() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.loadMoreStart, r101.loadMoreStart) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.loadMoreEnd, r101.loadMoreEnd) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.loadMoreVisible, r101.loadMoreVisible) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.loadMoreVisibleTime, r101.loadMoreVisibleTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.errCode, r101.errCode) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.loadMoreStart;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.loadMoreEnd;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.loadMoreVisible;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.loadMoreVisibleTime;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.status;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.errCode;
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
        return "LoadMoreAnalyseBean(loadMoreStart=" + this.loadMoreStart + ", loadMoreEnd=" + this.loadMoreEnd + ", loadMoreVisible=" + this.loadMoreVisible + ", loadMoreVisibleTime=" + this.loadMoreVisibleTime + ", status=" + this.status + ", errCode=" + this.errCode + ")";
    }

    public c(Long r100, Long r101, Integer r102, Long r103, Integer r104, Integer r105) {
        this.loadMoreStart = r100;
        this.loadMoreEnd = r101;
        this.loadMoreVisible = r102;
        this.loadMoreVisibleTime = r103;
        this.status = r104;
        this.errCode = r105;
    }
}
