package pea;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f528738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f528739e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f528735a, r101.f528735a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528736b, r101.f528736b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528737c, r101.f528737c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528738d, r101.f528738d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528739e, r101.f528739e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f528735a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f528736b.hashCode()) * 31;
        String r104 = this.f528737c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f528738d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f528739e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BigIsLandTextInfo(frontTitle=" + this.f528735a + ", title=" + this.f528736b + ", content=" + this.f528737c + ", narrowFont=" + this.f528738d + ", showHighlightColor=" + this.f528739e + ')';
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        String r101 = this.f528735a;
        if (r101 == null) goto L5;
        r100.put("frontTitle", r101);
    L5:
        r100.put("title", this.f528736b);
        String r102 = this.f528737c;
        if (r102 == null) goto L8;
        r100.put("content", r102);
    L8:
        Boolean r103 = this.f528738d;
        if (r103 == null) goto L11;
        r103.booleanValue();
        r100.put("narrowFont", this.f528738d);
    L11:
        Boolean r104 = this.f528739e;
        if (r104 == null) goto L14;
        r104.booleanValue();
        r100.put("showHighlightColor", this.f528739e);
    L14:
        return r100;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f528735a = null;
        this.f528736b = r100;
        this.f528737c = null;
        this.f528738d = null;
        this.f528739e = null;
    }
}
