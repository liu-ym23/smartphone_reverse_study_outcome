package com.bytedance.ee.bear.templates.recommend;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.n;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001:\u0001\u001dB1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/templates/recommend/RecommendTemplates;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "Lkotlin/collections/ArrayList;", "source", "", "templates", "err", "", "<init>", "(ILjava/util/ArrayList;Ljava/lang/Throwable;)V", "getSource", "()I", "getTemplates", "()Ljava/util/ArrayList;", "getErr", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendTemplates extends Result<ArrayList<TemplateV4>> {
    public static final a Companion = null;
    private final Throwable err;
    private final int source;
    private final ArrayList<TemplateV4> templates;

    public static final class a {
        public a() {
        }

        public static RecommendTemplates a(int r100, String r101) {
            if (r101 != null) goto L4;
        L7:
            boolean r102 = true;
        L8:
            if (r102 == true) goto L10;
            Locale r103 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
            boolean r104 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
            JSONObject r105 = new JSONObject(r101).optJSONObject("data");     // Catch: Throwable -> L21
            if (r105 == null) goto L15;
            JSONArray r106 = r105.optJSONArray("templates");     // Catch: Throwable -> L21
        L16:
            if (r105 == null) goto L18;
            JSONObject r107 = r105.optJSONObject("users");     // Catch: Throwable -> L21
        L19:
            int r108 = n.f239126a;     // Catch: Throwable -> L21
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L21
            return new RecommendTemplates(r100, n.b(r106, r107, r103, r104), null);
        L18:
            r107 = null;
            goto L19
        L15:
            r106 = null;
        L21:
            th = move-exception;
            tt5.a.d("RecommendTemplates", "parse()...error:" + th);
            return new RecommendTemplates(r100, new ArrayList(), th);
        L10:
            return new RecommendTemplates(r100, new ArrayList(), new Throwable("json is null"));
        L4:
            if (StringsKt.isBlank(r101) == true) goto L7;
            r102 = false;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendTemplates copy$default(RecommendTemplates r100, int r101, ArrayList r102, Throwable r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.source;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.templates;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.err;
    L12:
        return r100.copy(r101, r102, r103);
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

    public final RecommendTemplates copy(int r100, ArrayList<TemplateV4> r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "templates");
        return new RecommendTemplates(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecommendTemplates) == true) goto L8;
        return false;
    L8:
        RecommendTemplates r101 = (RecommendTemplates) r100;
        if (this.source == r101.source) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templates, r101.templates) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.err, r101.err) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.source * 31) + this.templates.hashCode()) * 31;
        Throwable r101 = this.err;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "RecommendTemplates(source=" + this.source + ", templates=" + this.templates + ", err=" + this.err + ')';
    }

    public final Throwable getErr() {
        return this.err;
    }

    public final int getSource() {
        return this.source;
    }

    public final ArrayList<TemplateV4> getTemplates() {
        return this.templates;
    }

    public RecommendTemplates(int r100, ArrayList<TemplateV4> r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "templates");
        this.source = r100;
        this.templates = r101;
        this.err = r102;
    }
}
