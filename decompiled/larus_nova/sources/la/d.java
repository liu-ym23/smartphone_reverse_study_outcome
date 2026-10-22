package la;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f508158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f508159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f508160d;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f508157a, r101.f508157a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508158b, r101.f508158b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508159c, r101.f508159c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508160d, r101.f508160d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f508157a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Bitmap r104 = this.f508158b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f508159c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f508160d;
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
        return "SearchData(searchText=" + this.f508157a + ", searchBitmap=" + this.f508158b + ", containerEnterFrom=" + this.f508159c + ", containerEnterMethod=" + this.f508160d + ')';
    }

    public d(int r100) {
        this.f508157a = null;
        this.f508158b = null;
        this.f508159c = null;
        this.f508160d = null;
    }
}
