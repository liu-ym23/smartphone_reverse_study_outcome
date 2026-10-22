package hs8;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AuthMode f487078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f487079b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f487078a == r101.f487078a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487079b, r101.f487079b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f487078a.hashCode() * 31) + this.f487079b.hashCode();
    }

    public final String toString() {
        return "UploadCredential(authMode=" + this.f487078a + ", attributes=" + this.f487079b + ')';
    }

    public e(AuthMode r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "authMode");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        this.f487078a = r100;
        this.f487079b = r101;
    }
}
