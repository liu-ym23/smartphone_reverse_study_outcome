package com.bytedance.ee.bear.templates.data;

import ao5.a;
import com.bytedance.ee.bear.contract.Result;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public static /* synthetic */ TemplateGroupTab copy$default(TemplateGroupTab r10, int r11, ArrayList r12, boolean r13, boolean r14, String r15, Throwable r16, String r17, int r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.source;
    L7:
        if ((r20 & 2) == 0) goto L9;
        ArrayList r3 = r10.categoryTabList;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = r10.hasMore;
    L15:
        if ((r20 & 8) == 0) goto L17;
        boolean r5 = r10.hasData;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.shareIndex;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Throwable r7 = r10.err;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.buffer;
    L31:
        if ((r20 & 128) == 0) goto L33;
        int r9 = r10.size;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r1 = r10.onlyBlankDocument;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
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

    public final TemplateGroupTab copy(int r12, ArrayList<CategoryTab> r13, boolean r14, boolean r15, String r16, Throwable r17, String r18, int r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r13, "categoryTabList");
        Intrinsics.checkNotNullParameter(r16, "shareIndex");
        Intrinsics.checkNotNullParameter(r18, "buffer");
        return new TemplateGroupTab(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TemplateGroupTab) == true) goto L8;
        return false;
    L8:
        TemplateGroupTab r6 = (TemplateGroupTab) r5;
        if (this.source == r6.source) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.categoryTabList, r6.categoryTabList) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r6.hasMore) goto L18;
        return false;
    L18:
        if (this.hasData == r6.hasData) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.shareIndex, r6.shareIndex) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.err, r6.err) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.buffer, r6.buffer) == true) goto L30;
        return false;
    L30:
        if (this.size == r6.size) goto L33;
        return false;
    L33:
        if (this.onlyBlankDocument == r6.onlyBlankDocument) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.source * 31) + this.categoryTabList.hashCode()) * 31;
        int r2 = 1231;
        if (this.hasMore == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.hasData == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.shareIndex.hashCode()) * 31;
        Throwable r6 = this.err;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (((((r5 + r7) * 31) + this.buffer.hashCode()) * 31) + this.size) * 31;
        if (this.onlyBlankDocument == true) goto L19;
        r2 = 1237;
    L19:
        return r8 + r2;
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
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

    public TemplateGroupTab(int r2, ArrayList<CategoryTab> r3, boolean r4, boolean r5, String r6, Throwable r7, String r8, int r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r3, "categoryTabList");
        Intrinsics.checkNotNullParameter(r6, "shareIndex");
        Intrinsics.checkNotNullParameter(r8, "buffer");
        this.source = r2;
        this.categoryTabList = r3;
        this.hasMore = r4;
        this.hasData = r5;
        this.shareIndex = r6;
        this.err = r7;
        this.buffer = r8;
        this.size = r9;
        this.onlyBlankDocument = r10;
    }

    public /* synthetic */ TemplateGroupTab(int r10, ArrayList r11, boolean r12, boolean r13, String r14, Throwable r15, String r16, int r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 2) == 0) goto L5;
        ArrayList r1 = new ArrayList();
    L6:
        boolean r3 = false;
        if ((r19 & 4) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r19 & 8) == 0) goto L13;
        boolean r4 = true;
    L15:
        if ((r19 & 16) == 0) goto L17;
        String r5 = "0";
    L19:
        if ((r19 & 32) == 0) goto L21;
        Throwable r6 = null;
    L23:
        if ((r19 & 64) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r19 & 128) == 0) goto L29;
        int r8 = 0;
    L31:
        if ((r19 & 256) != 0) goto L34;
        r3 = r18;
    L34:
        this(r10, r1, r2, r4, r5, r6, r7, r8, r3);
        return;
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L6
    }
}
