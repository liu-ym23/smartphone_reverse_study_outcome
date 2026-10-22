package tc5;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f545403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f545404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f545405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f545406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f545407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f545408h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f545401a, r101.f545401a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f545402b, r101.f545402b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f545403c, r101.f545403c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f545404d, r101.f545404d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f545405e, r101.f545405e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f545406f, r101.f545406f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f545407g, r101.f545407g) == true) goto L30;
        return false;
    L30:
        if (this.f545408h == r101.f545408h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f545401a.hashCode() * 31;
        String r101 = this.f545402b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f545403c.hashCode()) * 31;
        String r105 = this.f545404d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f545405e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f545406f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f545407g;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return ((r113 + r102) * 31) + this.f545408h;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReportCreateNewClickParam(module=" + this.f545401a + ", subModule=" + this.f545402b + ", click=" + this.f545403c + ", target=" + this.f545404d + ", templateId=" + this.f545405e + ", parentToken=" + this.f545406f + ", objToken=" + this.f545407g + ", type=" + this.f545408h + ')';
    }

    public final int getType() {
        return this.f545408h;
    }

    public a(String r100, String r101, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        if (r110 != e.f541296g.f541317b) goto L6;
    L17:
        String r102 = "docs";
    L18:
        this(r100, r101, r102, "ccm_template_systemcenter_view", r111, r110);
        return;
    L6:
        if (r110 != e.f541297h.f541317b) goto L9;
        r102 = "sheets";
        goto L18
    L9:
        if (r110 != e.f541300k.f541317b) goto L12;
        r102 = "mindnotes";
        goto L18
    L12:
        if (r110 != e.f541298i.f541317b) goto L15;
        r102 = DocumentType.BITABLE_NAME;
        goto L18
    L15:
        if (r110 != e.f541304o.f541317b) goto L17;
        r102 = DocumentType.DOCX_NAME;
        goto L18
    }

    public a(String r100, String r101, String r102, String r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "click");
        this.f545401a = r100;
        this.f545402b = r101;
        this.f545403c = r102;
        this.f545404d = r103;
        this.f545405e = "";
        this.f545406f = r104;
        this.f545407g = "";
        this.f545408h = r105;
    }
}
