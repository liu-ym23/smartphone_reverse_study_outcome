package com.bytedance.ee.bear.templates.preview.announce;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001:\u0001\u0019B)\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateResults;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplate;", "Lkotlin/collections/ArrayList;", "templates", "err", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/Throwable;)V", "getTemplates", "()Ljava/util/ArrayList;", "getErr", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnounceTemplateResults extends Result<ArrayList<AnnounceTemplate>> {
    public static final a Companion = null;
    private final Throwable err;
    private final ArrayList<AnnounceTemplate> templates;

    public static final class a {
        public a() {
        }

        public static ArrayList a(JSONArray r110, boolean r210) {
            if (r110 == null) goto L5;
            ArrayList r100 = new ArrayList();
            int r101 = r110.length();
            int r102 = 0;
        L7:
            if (r102 >= r101) goto L20;
            JSONObject r103 = r110.optJSONObject(r102);
            if (r103 != null) goto L11;
            ThumbnailExtra r111 = new ThumbnailExtra(null, null, 0, 7, null);
        L15:
            ThumbnailExtra r112 = r111;
        L16:
            AnnounceTemplate r104 = new AnnounceTemplate(r103.optString("id"), r103.optString("name"), r103.optString("obj_token"), r103.optInt("obj_type"), r112, r210);
            if (sbb.e.f541296g.f541317b != r104.getObjType()) goto L19;
            r100.add(r104);
        L19:
            r102 = r102 + 1;
            goto L7
        L11:
            JSONObject r105 = r103.optJSONObject("thumbnail_extra");
            if (r105 != null) goto L14;
            r112 = new ThumbnailExtra(null, null, 0, 7, null);
            goto L16
        L14:
            r111 = new ThumbnailExtra(r105.optString("decrypt_key"), r105.optString(DocCallbackImpl.KEY_THUMBNAIL), r105.optInt("type"));
            goto L15
        L20:
            return r100;
        L5:
            return new ArrayList();
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnounceTemplateResults copy$default(AnnounceTemplateResults r100, ArrayList r101, Throwable r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.templates;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.err;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<AnnounceTemplate> component1() {
        return this.templates;
    }

    public final Throwable component2() {
        return this.err;
    }

    public final AnnounceTemplateResults copy(ArrayList<AnnounceTemplate> r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "templates");
        return new AnnounceTemplateResults(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AnnounceTemplateResults) == true) goto L8;
        return false;
    L8:
        AnnounceTemplateResults r101 = (AnnounceTemplateResults) r100;
        if (Intrinsics.areEqual(this.templates, r101.templates) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.err, r101.err) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.templates.hashCode() * 31;
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
        return "AnnounceTemplateResults(templates=" + this.templates + ", err=" + this.err + ')';
    }

    public final Throwable getErr() {
        return this.err;
    }

    public final ArrayList<AnnounceTemplate> getTemplates() {
        return this.templates;
    }

    public AnnounceTemplateResults(ArrayList<AnnounceTemplate> r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "templates");
        this.templates = r100;
        this.err = r101;
    }
}
