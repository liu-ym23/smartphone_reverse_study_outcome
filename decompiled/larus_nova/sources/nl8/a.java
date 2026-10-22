package nl8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f519548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f519549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f519550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f519551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f519552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f519553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f519554i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f519546a, r101.f519546a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519547b, r101.f519547b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f519548c, r101.f519548c) == true) goto L18;
        return false;
    L18:
        if (this.f519549d == r101.f519549d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f519550e, r101.f519550e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f519551f, r101.f519551f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f519552g, r101.f519552g) == true) goto L30;
        return false;
    L30:
        if (this.f519553h == r101.f519553h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f519554i, r101.f519554i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f519546a.hashCode() * 31) + this.f519547b.hashCode()) * 31) + this.f519548c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f519549d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f519550e.hashCode()) * 31) + this.f519551f.hashCode()) * 31;
        Function0<Boolean> r104 = this.f519552g;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        if (this.f519553h == true) goto L14;
        r101 = 1237;
    L14:
        int r108 = (r107 + r101) * 31;
        Boolean r109 = this.f519554i;
        if (r109 == null) goto L19;
        r105 = r109.hashCode();
    L19:
        return r108 + r105;
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "GuiToolVMData(dataIdentifier=" + this.f519546a + ", title=" + this.f519547b + ", url=" + this.f519548c + ", canFold=" + this.f519549d + ", leftDarkIcon=" + this.f519550e + ", leftLightIcon=" + this.f519551f + ", interceptClickCard=" + this.f519552g + ", disableFoldExpandClick=" + this.f519553h + ", initialFoldState=" + this.f519554i + ')';
    }

    public a(String r100, String r101, String r102, boolean r103, String r104, String r105, ml8.c r106, boolean r107, Boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "dataIdentifier");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r104, "leftDarkIcon");
        Intrinsics.checkNotNullParameter(r105, "leftLightIcon");
        this.f519546a = r100;
        this.f519547b = r101;
        this.f519548c = r102;
        this.f519549d = r103;
        this.f519550e = r104;
        this.f519551f = r105;
        this.f519552g = r106;
        this.f519553h = r107;
        this.f519554i = r110;
    }
}
