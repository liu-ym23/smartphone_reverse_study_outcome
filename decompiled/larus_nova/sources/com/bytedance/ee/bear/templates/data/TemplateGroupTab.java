package com.bytedance.ee.bear.templates.data;

import ao5.a;
import com.bytedance.ee.bear.contract.Result;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001Bq\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u0019\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u0004HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003Ju\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\nHÆ\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0006HÖ\u0001J\t\u00101\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/templates/data/TemplateGroupTab;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/data/Category;", "Lkotlin/collections/ArrayList;", "source", "", "categoryTabList", "Lcom/bytedance/ee/bear/templates/data/CategoryTab;", "hasMore", "", "hasData", "shareIndex", "", "err", "", "buffer", "size", "onlyBlankDocument", "<init>", "(ILjava/util/ArrayList;ZZLjava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;IZ)V", "getSource", "()I", "getCategoryTabList", "()Ljava/util/ArrayList;", "getHasMore", "()Z", "getHasData", "getShareIndex", "()Ljava/lang/String;", "getErr", "()Ljava/lang/Throwable;", "getBuffer", "getSize", "getOnlyBlankDocument", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateGroupTab extends Result<ArrayList<a>> {
    private final String buffer;
    private final ArrayList<CategoryTab> categoryTabList;
    private final Throwable err;
    private final boolean hasData;
    private final boolean hasMore;
    private final boolean onlyBlankDocument;
    private final String shareIndex;
    private final int size;
    private final int source;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TemplateGroupTab copy$default(TemplateGroupTab r110, int r111, ArrayList r112, boolean r113, boolean r114, String r115, Throwable r116, String r117, int r118, boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.source;
    L7:
        if ((r210 & 2) == 0) goto L9;
        ArrayList r101 = r110.categoryTabList;
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r102 = r110.hasMore;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.hasData;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.shareIndex;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Throwable r105 = r110.err;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.buffer;
    L31:
        if ((r210 & 128) == 0) goto L33;
        int r107 = r110.size;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.onlyBlankDocument;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.source;
    }

    public final ArrayList<CategoryTab> component2() {
        return this.categoryTabList;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final boolean component4() {
        return this.hasData;
    }

    public final String component5() {
        return this.shareIndex;
    }

    public final Throwable component6() {
        return this.err;
    }

    public final String component7() {
        return this.buffer;
    }

    public final int component8() {
        return this.size;
    }

    public final boolean component9() {
        return this.onlyBlankDocument;
    }

    public final TemplateGroupTab copy(int r110, ArrayList<CategoryTab> r111, boolean r112, boolean r113, String r114, Throwable r115, String r116, int r117, boolean r210) {
        Intrinsics.checkNotNullParameter(r111, "categoryTabList");
        Intrinsics.checkNotNullParameter(r114, "shareIndex");
        Intrinsics.checkNotNullParameter(r116, "buffer");
        return new TemplateGroupTab(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TemplateGroupTab) == true) goto L8;
        return false;
    L8:
        TemplateGroupTab r101 = (TemplateGroupTab) r100;
        if (this.source == r101.source) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.categoryTabList, r101.categoryTabList) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r101.hasMore) goto L18;
        return false;
    L18:
        if (this.hasData == r101.hasData) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.shareIndex, r101.shareIndex) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.err, r101.err) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.buffer, r101.buffer) == true) goto L30;
        return false;
    L30:
        if (this.size == r101.size) goto L33;
        return false;
    L33:
        if (this.onlyBlankDocument == r101.onlyBlankDocument) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.source * 31) + this.categoryTabList.hashCode()) * 31;
        int r101 = 1231;
        if (this.hasMore == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.hasData == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.shareIndex.hashCode()) * 31;
        Throwable r106 = this.err;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((((r105 + r107) * 31) + this.buffer.hashCode()) * 31) + this.size) * 31;
        if (this.onlyBlankDocument == true) goto L19;
        r101 = 1237;
    L19:
        return r108 + r101;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "TemplateGroupTab(source=" + this.source + ", categoryTabList=" + this.categoryTabList + ", hasMore=" + this.hasMore + ", hasData=" + this.hasData + ", shareIndex=" + this.shareIndex + ", err=" + this.err + ", buffer=" + this.buffer + ", size=" + this.size + ", onlyBlankDocument=" + this.onlyBlankDocument + ')';
    }

    public final String getBuffer() {
        return this.buffer;
    }

    public final ArrayList<CategoryTab> getCategoryTabList() {
        return this.categoryTabList;
    }

    public final Throwable getErr() {
        return this.err;
    }

    public final boolean getHasData() {
        return this.hasData;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getOnlyBlankDocument() {
        return this.onlyBlankDocument;
    }

    public final String getShareIndex() {
        return this.shareIndex;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getSource() {
        return this.source;
    }

    public TemplateGroupTab(int r100, ArrayList<CategoryTab> r101, boolean r102, boolean r103, String r104, Throwable r105, String r106, int r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "categoryTabList");
        Intrinsics.checkNotNullParameter(r104, "shareIndex");
        Intrinsics.checkNotNullParameter(r106, "buffer");
        this.source = r100;
        this.categoryTabList = r101;
        this.hasMore = r102;
        this.hasData = r103;
        this.shareIndex = r104;
        this.err = r105;
        this.buffer = r106;
        this.size = r107;
        this.onlyBlankDocument = r110;
    }

    public /* synthetic */ TemplateGroupTab(int r110, ArrayList r111, boolean r112, boolean r113, String r114, Throwable r115, String r116, int r117, boolean r118, int r119, DefaultConstructorMarker r210) {
        if ((r119 & 2) == 0) goto L5;
        ArrayList r100 = new ArrayList();
    L6:
        boolean r101 = false;
        if ((r119 & 4) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r119 & 8) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r119 & 16) == 0) goto L17;
        String r104 = "0";
    L19:
        if ((r119 & 32) == 0) goto L21;
        Throwable r105 = null;
    L23:
        if ((r119 & 64) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r119 & 128) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r119 & 256) != 0) goto L34;
        r101 = r118;
    L34:
        this(r110, r100, r102, r103, r104, r105, r106, r107, r101);
        return;
    L29:
        r107 = r117;
        goto L31
    L25:
        r106 = r116;
        goto L27
    L21:
        r105 = r115;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L6
    }
}
