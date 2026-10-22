package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f508588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f508591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f508592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f508593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f508594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f508595k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f508585a, r101.f508585a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508586b, r101.f508586b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508587c, r101.f508587c) == true) goto L18;
        return false;
    L18:
        if (this.f508588d == r101.f508588d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508589e, r101.f508589e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508590f, r101.f508590f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f508591g, r101.f508591g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f508592h, r101.f508592h) == true) goto L33;
        return false;
    L33:
        if (this.f508593i == r101.f508593i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f508594j, r101.f508594j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f508595k, r101.f508595k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508585a.hashCode() * 31;
        String r101 = this.f508586b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f508587c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f508588d) * 31;
        String r108 = this.f508589e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f508590f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f508591g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f508592h;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        int r118 = (r116 + r102) * 31;
        if (this.f508593i == false) goto L29;
        int r119 = 1231;
    L31:
        return ((((r118 + r119) * 31) + this.f508594j.hashCode()) * 31) + this.f508595k.hashCode();
    L29:
        r119 = 1237;
        goto L31
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
        return "ReportSpaceDeleteOrRemoveView(module=" + this.f508585a + ", subModule=" + this.f508586b + ", objToken=" + this.f508587c + ", type=" + this.f508588d + ", subFileType=" + this.f508589e + ", containerObjToken=" + this.f508590f + ", containerType=" + this.f508591g + ", shortcutToken=" + this.f508592h + ", isSharedFolder=" + this.f508593i + ", deleteContentType=" + this.f508594j + ", deleteType=" + this.f508595k + ')';
    }

    public final int getType() {
        return this.f508588d;
    }

    public w(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter("own", "deleteContentType");
        Intrinsics.checkNotNullParameter("delete", "deleteType");
        this.f508585a = r100;
        this.f508586b = "recent";
        this.f508587c = r101;
        this.f508588d = r102;
        this.f508589e = r103;
        this.f508590f = "";
        this.f508591g = "";
        this.f508592h = "";
        this.f508593i = false;
        this.f508594j = "own";
        this.f508595k = "delete";
    }
}
