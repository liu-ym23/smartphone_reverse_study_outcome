package com.bytedance.ee.bear.templates.preview.announce;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001:\u0001\u0019B)\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateResults;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "Lkotlin/collections/ArrayList;", "templates", "err", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/Throwable;)V", "getTemplates", "()Ljava/util/ArrayList;", "getErr", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnounceTemplateResults extends Result<ArrayList<AnnounceTemplate>> {
    public static final a Companion = null;
    private final Throwable err;
    private final ArrayList<AnnounceTemplate> templates;

    public static final class a {
        public a() {
        }

        public static ArrayList a(JSONArray r19, boolean r20) {
            if (r19 == null) goto L5;
            ArrayList r1 = new ArrayList();
            int r2 = r19.length();
            int r3 = 0;
        L7:
            if (r3 >= r2) goto L20;
            JSONObject r4 = r19.optJSONObject(r3);
            if (r4 != null) goto L11;
            ThumbnailExtra r11 = new ThumbnailExtra(null, null, 0, 7, null);
        L15:
            ThumbnailExtra r17 = r11;
        L16:
            AnnounceTemplate r5 = new AnnounceTemplate(r4.optString(ResourceData.KEY_ID), r4.optString("name"), r4.optString(ResourceData.KEY_OBJ_TOKEN), r4.optInt("obj_type"), r17, r20);
            if (sbb.e.g.b != r5.getObjType()) goto L19;
            r1.add(r5);
        L19:
            r3 = r3 + 1;
            goto L7
        L11:
            JSONObject r6 = r4.optJSONObject("thumbnail_extra");
            if (r6 != null) goto L14;
            r17 = new ThumbnailExtra(null, null, 0, 7, null);
            goto L16
        L14:
            r11 = new ThumbnailExtra(r6.optString("decrypt_key"), r6.optString("thumbnail"), r6.optInt(ResourceData.KEY_TYPE));
            goto L15
        L20:
            return r1;
        L5:
            return new ArrayList();
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnounceTemplateResults copy$default(AnnounceTemplateResults r0, ArrayList r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.templates;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.err;
    L9:
        return r0.copy(r1, r2);
    }

    public final ArrayList<AnnounceTemplate> component1() {
        return this.templates;
    }

    public final Throwable component2() {
        return this.err;
    }

    public final AnnounceTemplateResults copy(ArrayList<AnnounceTemplate> r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "templates");
        return new AnnounceTemplateResults(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AnnounceTemplateResults) == true) goto L8;
        return false;
    L8:
        AnnounceTemplateResults r6 = (AnnounceTemplateResults) r5;
        if (Intrinsics.areEqual(this.templates, r6.templates) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.err, r6.err) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.templates.hashCode() * 31;
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
        return "AnnounceTemplateResults(templates=" + this.templates + ", err=" + this.err + ')';
    }

    public final Throwable getErr() {
        return this.err;
    }

    public final ArrayList<AnnounceTemplate> getTemplates() {
        return this.templates;
    }

    public AnnounceTemplateResults(ArrayList<AnnounceTemplate> r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "templates");
        this.templates = r2;
        this.err = r3;
    }
}
