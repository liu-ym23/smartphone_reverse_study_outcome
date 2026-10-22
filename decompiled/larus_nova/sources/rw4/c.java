package rw4;

import com.bytedance.ee.bear.contract.export.DocumentExportType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f539681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DocumentExportType f539682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f539683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f539684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f539685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final sbb.e f539686f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f539681a == r101.f539681a) goto L12;
        return false;
    L12:
        if (this.f539682b == r101.f539682b) goto L15;
        return false;
    L15:
        if (this.f539683c == r101.f539683c) goto L18;
        return false;
    L18:
        if (this.f539684d == r101.f539684d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f539685e, r101.f539685e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f539686f, r101.f539686f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.f539681a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f539682b.hashCode()) * 31;
        long r102 = this.f539683c;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f539684d) * 31;
        String r104 = this.f539685e;
        if (r104 != null) goto L9;
        int r105 = 0;
    L11:
        return ((r103 + r105) * 31) + this.f539686f.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DocumentExportResult(success=" + this.f539681a + ", exportType=" + this.f539682b + ", duration=" + this.f539683c + ", errorCode=" + this.f539684d + ", errorMsg=" + this.f539685e + ", resourceType=" + this.f539686f + ')';
    }

    public c(boolean r100, DocumentExportType r101, long r102, int r103, String r104, sbb.e r105) {
        Intrinsics.checkNotNullParameter(r101, "exportType");
        Intrinsics.checkNotNullParameter(r105, "resourceType");
        this.f539681a = r100;
        this.f539682b = r101;
        this.f539683c = r102;
        this.f539684d = r103;
        this.f539685e = r104;
        this.f539686f = r105;
    }
}
