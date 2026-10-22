package uu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;", "", "firstPageSize", "", "secondPageSize", "pageSize", "<init>", "(III)V", "getFirstPageSize", "()I", "getSecondPageSize", "getPageSize", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("first_page_size")
    private final int firstPageSize;

    @SerializedName("page_size")
    private final int pageSize;

    @SerializedName("second_page_size")
    private final int secondPageSize;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.firstPageSize == r101.firstPageSize) goto L12;
        return false;
    L12:
        if (this.secondPageSize == r101.secondPageSize) goto L15;
        return false;
    L15:
        if (this.pageSize == r101.pageSize) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.firstPageSize * 31) + this.secondPageSize) * 31) + this.pageSize;
    }

    public final String toString() {
        return "ConversationGroupPagingExperimentConfig(firstPageSize=" + this.firstPageSize + ", secondPageSize=" + this.secondPageSize + ", pageSize=" + this.pageSize + ')';
    }

    public final int a() {
        return this.firstPageSize;
    }

    public final int b() {
        return this.pageSize;
    }

    public final int c() {
        return this.secondPageSize;
    }

    public /* synthetic */ c(int r100) {
        this(5, 10, 20);
    }

    public c(int r100, int r101, int r102) {
        this.firstPageSize = r100;
        this.secondPageSize = r101;
        this.pageSize = r102;
    }
}
