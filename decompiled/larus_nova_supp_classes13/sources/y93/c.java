package y93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L18;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.loadMoreStart, r4.loadMoreStart) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.loadMoreEnd, r4.loadMoreEnd) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.loadMoreVisible, r4.loadMoreVisible) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.loadMoreVisibleTime, r4.loadMoreVisibleTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.errCode, r4.errCode) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.loadMoreStart;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.loadMoreEnd;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.loadMoreVisible;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.loadMoreVisibleTime;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.status;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.errCode;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
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
        return "LoadMoreAnalyseBean(loadMoreStart=" + this.loadMoreStart + ", loadMoreEnd=" + this.loadMoreEnd + ", loadMoreVisible=" + this.loadMoreVisible + ", loadMoreVisibleTime=" + this.loadMoreVisibleTime + ", status=" + this.status + ", errCode=" + this.errCode + ")";
    }

    public c(Long r1, Long r2, Integer r3, Long r4, Integer r5, Integer r6) {
        this.loadMoreStart = r1;
        this.loadMoreEnd = r2;
        this.loadMoreVisible = r3;
        this.loadMoreVisibleTime = r4;
        this.status = r5;
        this.errCode = r6;
    }
}
