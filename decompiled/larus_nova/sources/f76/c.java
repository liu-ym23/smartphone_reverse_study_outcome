package f76;

import android.net.Uri;
import com.bytedance.ies.xelement.api.XResourceFrom;
import com.bytedance.ies.xelement.api.XResourceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f475769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final XResourceType f475771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final XResourceFrom f475772d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f475769a, r101.f475769a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475770b, r101.f475770b) == true) goto L15;
        return false;
    L15:
        if (this.f475771c == r101.f475771c) goto L18;
        return false;
    L18:
        if (this.f475772d == r101.f475772d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f475769a.hashCode() * 31;
        String r101 = this.f475770b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        XResourceType r105 = this.f475771c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        XResourceFrom r108 = this.f475772d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "XResourceLoadInfo(inputUri=" + this.f475769a + ", resourcePath=" + this.f475770b + ", resourceType=" + this.f475771c + ", resourceFrom=" + this.f475772d + ')';
    }

    public c(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "inputUri");
        this.f475769a = r100;
        this.f475770b = r101;
        this.f475771c = null;
        this.f475772d = null;
    }
}
