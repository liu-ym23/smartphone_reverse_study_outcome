package com.bytedance.ee.bear.templates.horizontal;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001B9\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplates;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "Lkotlin/collections/ArrayList;", "source", "", "templates", "err", "", "hasMore", "", "<init>", "(ILjava/util/ArrayList;Ljava/lang/Throwable;Z)V", "getSource", "()I", "setSource", "(I)V", "getTemplates", "()Ljava/util/ArrayList;", "getErr", "()Ljava/lang/Throwable;", "getHasMore", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalTemplates extends Result<ArrayList<TemplateV4>> {
    private final Throwable err;
    private final boolean hasMore;
    private int source;
    private final ArrayList<TemplateV4> templates;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalTemplates copy$default(HorizontalTemplates r100, int r101, ArrayList r102, Throwable r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.source;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.templates;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.err;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.hasMore;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.source;
    }

    public final ArrayList<TemplateV4> component2() {
        return this.templates;
    }

    public final Throwable component3() {
        return this.err;
    }

    public final boolean component4() {
        return this.hasMore;
    }

    public final HorizontalTemplates copy(int r100, ArrayList<TemplateV4> r101, Throwable r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "templates");
        return new HorizontalTemplates(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HorizontalTemplates) == true) goto L8;
        return false;
    L8:
        HorizontalTemplates r101 = (HorizontalTemplates) r100;
        if (this.source == r101.source) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templates, r101.templates) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.err, r101.err) == true) goto L18;
        return false;
    L18:
        if (this.hasMore == r101.hasMore) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.source * 31) + this.templates.hashCode()) * 31;
        Throwable r101 = this.err;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.hasMore == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "HorizontalTemplates(source=" + this.source + ", templates=" + this.templates + ", err=" + this.err + ", hasMore=" + this.hasMore + ')';
    }

    public final Throwable getErr() {
        return this.err;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final int getSource() {
        return this.source;
    }

    public final ArrayList<TemplateV4> getTemplates() {
        return this.templates;
    }

    public final void setSource(int r100) {
        this.source = r100;
    }

    public HorizontalTemplates(int r100, ArrayList<TemplateV4> r101, Throwable r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "templates");
        this.source = r100;
        this.templates = r101;
        this.err = r102;
        this.hasMore = r103;
    }
}
