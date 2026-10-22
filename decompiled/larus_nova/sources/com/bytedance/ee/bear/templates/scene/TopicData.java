package com.bytedance.ee.bear.templates.scene;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/templates/scene/TopicData;", "Lcom/bytedance/ee/util/io/NonProguard;", "templates", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "Lkotlin/collections/ArrayList;", "hasMore", "", "<init>", "(Ljava/util/ArrayList;Z)V", "getTemplates", "()Ljava/util/ArrayList;", "setTemplates", "(Ljava/util/ArrayList;)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopicData implements NonProguard {
    private boolean hasMore;
    private ArrayList<TemplateV4> templates;

    /* JADX WARN: Multi-variable type inference failed */
    public TopicData() {
        ArrayList r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TopicData copy$default(TopicData r100, ArrayList r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.templates;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hasMore;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<TemplateV4> component1() {
        return this.templates;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final TopicData copy(ArrayList<TemplateV4> r100, boolean r101) {
        return new TopicData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TopicData) == true) goto L8;
        return false;
    L8:
        TopicData r101 = (TopicData) r100;
        if (Intrinsics.areEqual(this.templates, r101.templates) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r101.hasMore) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ArrayList<TemplateV4> r100 = this.templates;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.hasMore == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TopicData(templates=" + this.templates + ", hasMore=" + this.hasMore + ')';
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final ArrayList<TemplateV4> getTemplates() {
        return this.templates;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setTemplates(ArrayList<TemplateV4> r100) {
        this.templates = r100;
    }

    public TopicData(ArrayList<TemplateV4> r100, boolean r101) {
        this.templates = r100;
        this.hasMore = r101;
    }

    public /* synthetic */ TopicData(ArrayList r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
