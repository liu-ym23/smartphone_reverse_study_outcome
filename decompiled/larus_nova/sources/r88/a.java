package r88;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import ey9.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f536661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f536662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f536663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f536664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f536665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f536666f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f536661a, r101.f536661a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f536662b, r101.f536662b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f536663c, r101.f536663c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f536664d, r101.f536664d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f536665e, r101.f536665e) == true) goto L24;
        return false;
    L24:
        if (this.f536666f == r101.f536666f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f536661a.hashCode() * 31) + this.f536662b.hashCode()) * 31) + this.f536663c.hashCode()) * 31) + this.f536664d.hashCode()) * 31;
        Bitmap r101 = this.f536665e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f536666f == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreGenCacheItem(pathKey=" + this.f536661a + ", displayUri=" + this.f536662b + ", preGenImage=" + this.f536663c + ", algorithmUri=" + this.f536664d + ", cachedBitmap=" + this.f536665e + ", hasRunDetection=" + this.f536666f + ')';
    }

    public a(String r100, Uri r101, k r102) {
        Uri r103 = UriProtector.parse("pre_gen://" + r100);
        Intrinsics.checkNotNullParameter(r100, "pathKey");
        Intrinsics.checkNotNullParameter(r101, "displayUri");
        Intrinsics.checkNotNullParameter(r102, "preGenImage");
        Intrinsics.checkNotNullParameter(r103, "algorithmUri");
        this.f536661a = r100;
        this.f536662b = r101;
        this.f536663c = r102;
        this.f536664d = r103;
        this.f536665e = null;
        this.f536666f = false;
    }
}
