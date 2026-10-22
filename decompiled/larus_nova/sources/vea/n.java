package vea;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f554527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f554528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f554529d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f554526a == r101.f554526a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554527b, r101.f554527b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f554528c, r101.f554528c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f554529d, r101.f554529d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f554526a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f554527b.hashCode()) * 31;
        Integer r102 = this.f554528c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f554529d;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricRestoreImageResult(success=" + this.f554526a + ", failUris=" + this.f554527b + ", errorCode=" + this.f554528c + ", errorMsg=" + this.f554529d + ')';
    }

    public /* synthetic */ n(boolean r100, Integer r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        List r104 = CollectionsKt.emptyList();
    L7:
        if ((r103 & 4) == 0) goto L10;
        r101 = null;
    L10:
        if ((r103 & 8) == 0) goto L12;
        r102 = null;
    L12:
        this(r100, r104, r101, r102);
        return;
    L5:
        r104 = null;
        goto L7
    }

    public n(boolean r100, List<String> r101, Integer r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "failUris");
        this.f554526a = r100;
        this.f554527b = r101;
        this.f554528c = r102;
        this.f554529d = r103;
    }
}
