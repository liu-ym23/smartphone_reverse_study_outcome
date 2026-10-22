package is8;

import com.larus.bmhome.upload.sdk.api.model.UploadStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UploadStage f495654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f495657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f495658e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f495654a == r101.f495654a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495655b, r101.f495655b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495656c, r101.f495656c) == true) goto L18;
        return false;
    L18:
        if (this.f495657d == r101.f495657d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495658e, r101.f495658e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f495654a.hashCode() * 31) + this.f495655b.hashCode()) * 31) + this.f495656c.hashCode()) * 31;
        if (this.f495657d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Throwable r103 = this.f495658e;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "UploadError(stage=" + this.f495654a + ", code=" + this.f495655b + ", message=" + this.f495656c + ", retryable=" + this.f495657d + ", cause=" + this.f495658e + ')';
    }

    public d(UploadStage r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter("upload_skeleton_failed", "code");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f495654a = r100;
        this.f495655b = "upload_skeleton_failed";
        this.f495656c = r101;
        this.f495657d = true;
        this.f495658e = r102;
    }
}
