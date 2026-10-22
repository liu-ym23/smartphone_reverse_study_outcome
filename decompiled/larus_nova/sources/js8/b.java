package js8;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuthMode f500233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f500234b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f500233a == r101.f500233a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500234b, r101.f500234b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f500233a.hashCode() * 31) + this.f500234b.hashCode();
    }

    public final String toString() {
        return "UploadCredential(authMode=" + this.f500233a + ", attributes=" + this.f500234b + ')';
    }

    public b(AuthMode r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "authMode");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        this.f500233a = r100;
        this.f500234b = r101;
    }
}
