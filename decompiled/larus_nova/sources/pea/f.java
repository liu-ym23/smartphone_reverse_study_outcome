package pea;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f528773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f528774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f528775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f528776g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f528770a, r101.f528770a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528771b, r101.f528771b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528772c, r101.f528772c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528773d, r101.f528773d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528774e, r101.f528774e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528775f, r101.f528775f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f528776g, r101.f528776g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f528770a.hashCode() * 31) + this.f528771b.hashCode()) * 31;
        String r101 = this.f528772c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f528773d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f528774e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f528775f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return ((r110 + r102) * 31) + this.f528776g.hashCode();
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
        return "ExpandedIconTextInfo(title=" + this.f528770a + ", content=" + this.f528771b + ", colorTitle=" + this.f528772c + ", colorTitleDark=" + this.f528773d + ", colorContent=" + this.f528774e + ", colorContentDark=" + this.f528775f + ", animIconInfo=" + this.f528776g + ')';
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("title", this.f528770a);
        r100.put("content", this.f528771b);
        String r101 = this.f528772c;
        if (r101 == null) goto L5;
        r100.put("colorTitle", r101);
    L5:
        String r102 = this.f528773d;
        if (r102 == null) goto L8;
        r100.put("colorTitleDark", r102);
    L8:
        String r103 = this.f528774e;
        if (r103 == null) goto L11;
        r100.put("colorContent", r103);
    L11:
        String r104 = this.f528775f;
        if (r104 == null) goto L14;
        r100.put("colorContentDark", r104);
    L14:
        d r105 = this.f528776g;
        r105.getClass();
        JSONObject r106 = new JSONObject();
        r106.put("type", r105.f528749a);
        r106.put("src", r105.f528750b);
        String r107 = r105.f528752d;
        if (r107 == null) goto L17;
        r106.put("srcDark", r107);
    L17:
        r100.put("animIconInfo", r106);
        return r100;
    }

    public f(String r100, String r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "animIconInfo");
        this.f528770a = r100;
        this.f528771b = r101;
        this.f528772c = null;
        this.f528773d = null;
        this.f528774e = null;
        this.f528775f = null;
        this.f528776g = r102;
    }
}
