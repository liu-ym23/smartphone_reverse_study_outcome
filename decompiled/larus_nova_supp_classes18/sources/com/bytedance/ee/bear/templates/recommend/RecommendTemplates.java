package com.bytedance.ee.bear.templates.recommend;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.n;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001:\u0001\u001dB1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/templates/recommend/RecommendTemplates;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "Lkotlin/collections/ArrayList;", "source", "", "templates", "err", "", "<init>", "(ILjava/util/ArrayList;Ljava/lang/Throwable;)V", "getSource", "()I", "getTemplates", "()Ljava/util/ArrayList;", "getErr", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendTemplates extends Result<ArrayList<TemplateV4>> {
    public static final a Companion = null;
    private final Throwable err;
    private final int source;
    private final ArrayList<TemplateV4> templates;

    public static final class a {
        public a() {
        }

        public static RecommendTemplates a(int r5, String r6) {
            if (r6 != null) goto L4;
        L7:
            boolean r0 = true;
        L8:
            if (r0 == true) goto L10;
            Locale r1 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
            boolean r2 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
            JSONObject r7 = new JSONObject(r6).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L21
            if (r7 == null) goto L15;
            JSONArray r3 = r7.optJSONArray("templates");     // Catch: Throwable -> L21
        L16:
            if (r7 == null) goto L18;
            JSONObject r8 = r7.optJSONObject("users");     // Catch: Throwable -> L21
        L19:
            int r4 = n.a;     // Catch: Throwable -> L21
            Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L21
            return new RecommendTemplates(r5, n.b(r3, r8, r1, r2), null);
        L18:
            r8 = null;
            goto L19
        L15:
            r3 = null;
        L21:
            th = move-exception;
            tt5.a.d("RecommendTemplates", "parse()...error:" + th);
            return new RecommendTemplates(r5, new ArrayList(), th);
        L10:
            return new RecommendTemplates(r5, new ArrayList(), new Throwable("json is null"));
        L4:
            if (StringsKt.isBlank(r6) == true) goto L7;
            r0 = false;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendTemplates copy$default(RecommendTemplates r0, int r1, ArrayList r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.source;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.templates;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.err;
    L12:
        return r0.copy(r1, r2, r3);
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

    public final RecommendTemplates copy(int r2, ArrayList<TemplateV4> r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "templates");
        return new RecommendTemplates(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RecommendTemplates) == true) goto L8;
        return false;
    L8:
        RecommendTemplates r6 = (RecommendTemplates) r5;
        if (this.source == r6.source) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templates, r6.templates) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.err, r6.err) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.source * 31) + this.templates.hashCode()) * 31;
        Throwable r1 = this.err;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
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

    public RecommendTemplates(int r2, ArrayList<TemplateV4> r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "templates");
        this.source = r2;
        this.templates = r3;
        this.err = r4;
    }
}
