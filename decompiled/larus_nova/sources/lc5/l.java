package lc5;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f508478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f508479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508481f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f508476a, r101.f508476a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508477b, r101.f508477b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508478c, r101.f508478c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508479d, r101.f508479d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508480e, r101.f508480e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508481f, r101.f508481f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f508476a.hashCode() * 31) + this.f508477b.hashCode()) * 31;
        String r101 = this.f508478c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f508479d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f508480e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f508481f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "ReportHeaderFilterClickParam(click=" + this.f508476a + ", module=" + this.f508477b + ", subModule=" + this.f508478c + ", path=" + this.f508479d + ", docValue=" + this.f508480e + ", operateValue=" + this.f508481f + ')';
    }

    public l(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "click");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        this.f508476a = r100;
        this.f508477b = r101;
        this.f508478c = r102;
        this.f508479d = r103;
        this.f508480e = r104;
        this.f508481f = r105;
    }
}
