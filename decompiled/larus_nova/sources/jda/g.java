package jda;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.ss.android.cert.manager.constants.EventConstant;
import hda.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class g extends com.obric.assistant.cocreationreview.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleKey f498771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f498772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f498773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f498774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f498775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e1 f498776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f498777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f498778i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f498770a, r101.f498770a) == true) goto L12;
        return false;
    L12:
        if (this.f498771b == r101.f498771b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f498772c, r101.f498772c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f498773d, r101.f498773d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f498774e, r101.f498774e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f498775f, r101.f498775f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f498776g, r101.f498776g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f498777h, r101.f498777h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f498778i, r101.f498778i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((this.f498770a.hashCode() * 31) + this.f498771b.hashCode()) * 31) + this.f498772c.hashCode()) * 31) + this.f498773d.hashCode()) * 31) + this.f498774e.hashCode()) * 31) + this.f498775f.hashCode()) * 31) + this.f498776g.hashCode()) * 31) + this.f498777h.hashCode()) * 31;
        String r101 = this.f498778i;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CollectionMemoryUsageRecord(id=" + this.f498770a + ", module=" + this.f498771b + ", savedAt=" + this.f498772c + ", collectionDomain=" + this.f498773d + ", collectionTitle=" + this.f498774e + ", collectionSummary=" + this.f498775f + ", uiModel=" + this.f498776g + ", payload=" + this.f498777h + ", traceJson=" + this.f498778i + ')';
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final String a() {
        return this.f498770a;
    }

    @Override // com.obric.assistant.cocreationreview.a
    public final ModuleKey b() {
        return this.f498771b;
    }

    public g(String r100, ModuleKey r101, String r102, String r103, String r104, e1 r105, String r106, String r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "savedAt");
        Intrinsics.checkNotNullParameter("收藏记忆", "collectionDomain");
        Intrinsics.checkNotNullParameter(r103, "collectionTitle");
        Intrinsics.checkNotNullParameter(r104, "collectionSummary");
        Intrinsics.checkNotNullParameter(r105, "uiModel");
        Intrinsics.checkNotNullParameter(r106, WsConstants.KEY_PAYLOAD);
        this.f498770a = r100;
        this.f498771b = r101;
        this.f498772c = r102;
        this.f498773d = "收藏记忆";
        this.f498774e = r103;
        this.f498775f = r104;
        this.f498776g = r105;
        this.f498777h = r106;
        this.f498778i = r110;
    }
}
