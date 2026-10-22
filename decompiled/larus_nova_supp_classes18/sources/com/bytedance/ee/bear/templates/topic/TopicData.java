package com.bytedance.ee.bear.templates.topic;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/templates/topic/TopicData;", "Lcom/bytedance/ee/util/io/NonProguard;", "banner", "Lcom/bytedance/ee/bear/templates/topic/TopicBannerData;", "templates", "", "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "<init>", "(Lcom/bytedance/ee/bear/templates/topic/TopicBannerData;Ljava/util/List;)V", "getBanner", "()Lcom/bytedance/ee/bear/templates/topic/TopicBannerData;", "setBanner", "(Lcom/bytedance/ee/bear/templates/topic/TopicBannerData;)V", "getTemplates", "()Ljava/util/List;", "setTemplates", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopicData implements NonProguard {
    private f banner;
    private List<TemplateV4> templates;

    /* JADX WARN: Multi-variable type inference failed */
    public TopicData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TopicData copy$default(TopicData r0, f r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.banner;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.templates;
    L9:
        return r0.copy(r1, r2);
    }

    public final f component1() {
        return this.banner;
    }

    public final List<TemplateV4> component2() {
        return this.templates;
    }

    public final TopicData copy(f r2, List<TemplateV4> r3) {
        return new TopicData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TopicData) == true) goto L8;
        return false;
    L8:
        TopicData r6 = (TopicData) r5;
        if (Intrinsics.areEqual(this.banner, r6.banner) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templates, r6.templates) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        f r0 = this.banner;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<TemplateV4> r4 = this.templates;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TopicData(banner=" + this.banner + ", templates=" + this.templates + ')';
    }

    public final f getBanner() {
        return this.banner;
    }

    public final List<TemplateV4> getTemplates() {
        return this.templates;
    }

    public final void setBanner(f r1) {
        this.banner = r1;
    }

    public final void setTemplates(List<TemplateV4> r1) {
        this.templates = r1;
    }

    public TopicData(f r1, List<TemplateV4> r2) {
        this.banner = r1;
        this.templates = r2;
    }

    public /* synthetic */ TopicData(f r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
