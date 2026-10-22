package hs8;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final is8.g f487073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final is8.a f487074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f487075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f487076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f487077e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f487073a, r101.f487073a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487074b, r101.f487074b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f487075c, r101.f487075c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f487076d, r101.f487076d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f487077e, r101.f487077e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f487073a.hashCode() * 31) + this.f487074b.hashCode()) * 31) + this.f487075c.hashCode()) * 31;
        String r101 = this.f487076d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f487077e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PostUploadContext(request=" + this.f487073a + ", route=" + this.f487074b + ", engineResult=" + this.f487075c + ", resourceId=" + this.f487076d + ", attributes=" + this.f487077e + ')';
    }

    public d(is8.g r100, is8.a r101, a r102, String r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r102, "engineResult");
        Intrinsics.checkNotNullParameter(r104, "attributes");
        this.f487073a = r100;
        this.f487074b = r101;
        this.f487075c = r102;
        this.f487076d = r103;
        this.f487077e = r104;
    }
}
