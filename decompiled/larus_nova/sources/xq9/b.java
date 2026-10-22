package xq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/markdown/MarkdownTableRenderConfig;", "", "enableTableHeader", "", "enableTableDetailPageRotate", "enableTableDetailPageDefaultPortrait", "<init>", "(ZZZ)V", "getEnableTableHeader", "()Z", "getEnableTableDetailPageRotate", "getEnableTableDetailPageDefaultPortrait", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("enable_table_detail_page_default_portrait")
    private final boolean enableTableDetailPageDefaultPortrait;

    @SerializedName("enable_table_detail_page_rotate")
    private final boolean enableTableDetailPageRotate;

    @SerializedName("enable_table_header")
    private final boolean enableTableHeader;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.enableTableHeader == r101.enableTableHeader) goto L12;
        return false;
    L12:
        if (this.enableTableDetailPageRotate == r101.enableTableDetailPageRotate) goto L15;
        return false;
    L15:
        if (this.enableTableDetailPageDefaultPortrait == r101.enableTableDetailPageDefaultPortrait) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableTableHeader == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableTableDetailPageRotate == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableTableDetailPageDefaultPortrait == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MarkdownTableRenderConfig(enableTableHeader=" + this.enableTableHeader + ", enableTableDetailPageRotate=" + this.enableTableDetailPageRotate + ", enableTableDetailPageDefaultPortrait=" + this.enableTableDetailPageDefaultPortrait + ')';
    }

    public final boolean a() {
        return this.enableTableDetailPageDefaultPortrait;
    }

    public final boolean b() {
        return this.enableTableDetailPageRotate;
    }

    public final boolean c() {
        return this.enableTableHeader;
    }

    public b(int r100) {
        this.enableTableHeader = true;
        this.enableTableDetailPageRotate = true;
        this.enableTableDetailPageDefaultPortrait = true;
    }
}
