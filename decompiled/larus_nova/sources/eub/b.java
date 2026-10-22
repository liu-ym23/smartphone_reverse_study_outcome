package eub;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmMinutesFileUploadErrorCode f474116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f474118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f474119d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f474116a == r101.f474116a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474117b, r101.f474117b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474118c, r101.f474118c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474119d, r101.f474119d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f474116a.hashCode() * 31) + this.f474117b.hashCode()) * 31;
        Integer r101 = this.f474118c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        e r105 = this.f474119d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMinutesFileUploadError(code=" + this.f474116a + ", message=" + this.f474117b + ", rawCode=" + this.f474118c + ", quotaInfo=" + this.f474119d + ')';
    }

    public b(MmMinutesFileUploadErrorCode r100, String r101, Integer r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f474116a = r100;
        this.f474117b = r101;
        this.f474118c = r102;
        this.f474119d = r103;
    }

    public /* synthetic */ b(MmMinutesFileUploadErrorCode r100, String r101, Integer r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102, null);
    }
}
