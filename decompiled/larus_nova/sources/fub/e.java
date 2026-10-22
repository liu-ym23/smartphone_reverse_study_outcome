package fub;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f478928c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f478926a, r101.f478926a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478927b, r101.f478927b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f478928c, r101.f478928c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f478926a.hashCode() * 31;
        String r101 = this.f478927b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f478928c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "RecordingUploadResult(uploadedFileToken=" + this.f478926a + ", fileUrl=" + this.f478927b + ", extra=" + this.f478928c + ')';
    }

    public e(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "uploadedFileToken");
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.f478926a = r100;
        this.f478927b = r101;
        this.f478928c = r102;
    }
}
