package ps9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f530470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f530471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f530472d;

    /* JADX INFO: renamed from: ps9.a$a, reason: collision with other inner class name */
    public static final class C7236a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f530469a, r101.f530469a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530470b, r101.f530470b) == true) goto L15;
        return false;
    L15:
        if (this.f530471c == r101.f530471c) goto L18;
        return false;
    L18:
        if (this.f530472d == r101.f530472d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f530469a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f530470b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.f530471c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f530472d == true) goto L19;
        r106 = 1237;
    L19:
        return r108 + r106;
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReceiveTextRequest(action=" + this.f530469a + ", mimeType=" + this.f530470b + ", hasText=" + this.f530471c + ", hasShareUris=" + this.f530472d + ')';
    }

    public a(String r100, String r101, boolean r102, boolean r103) {
        this.f530469a = r100;
        this.f530470b = r101;
        this.f530471c = r102;
        this.f530472d = r103;
    }
}
