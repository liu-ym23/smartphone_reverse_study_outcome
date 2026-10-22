package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f508467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f508468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f508469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f508470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f508471k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f508461a, r101.f508461a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508462b, r101.f508462b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508463c, r101.f508463c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508464d, r101.f508464d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508465e, r101.f508465e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508466f, r101.f508466f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f508467g, r101.f508467g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f508468h, r101.f508468h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f508469i, r101.f508469i) == true) goto L36;
        return false;
    L36:
        if (this.f508470j == r101.f508470j) goto L39;
        return false;
    L39:
        if (this.f508471k == r101.f508471k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508461a.hashCode() * 31;
        String r101 = this.f508462b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f508463c.hashCode()) * 31;
        String r105 = this.f508464d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f508465e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f508466f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f508467g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f508468h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f508469i;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return ((((r119 + r102) * 31) + this.f508470j) * 31) + this.f508471k;
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
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
        return "ReportCreateTemplateClickParam(module=" + this.f508461a + ", subModule=" + this.f508462b + ", click=" + this.f508463c + ", parentToken=" + this.f508464d + ", objToken=" + this.f508465e + ", templateId=" + this.f508466f + ", templateToken=" + this.f508467g + ", templateName=" + this.f508468h + ", templateType=" + this.f508469i + ", objType=" + this.f508470j + ", type=" + this.f508471k + ')';
    }

    public final int getType() {
        return this.f508471k;
    }

    public j(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter("templates", "click");
        this.f508461a = r100;
        this.f508462b = r101;
        this.f508463c = "templates";
        this.f508464d = r102;
        this.f508465e = r103;
        this.f508466f = r104;
        this.f508467g = r105;
        this.f508468h = r106;
        this.f508469i = r110;
        this.f508470j = r111;
        this.f508471k = r112;
    }
}
