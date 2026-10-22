package com.ss.android.lark.officesdk.minutes.service.fileupload;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final eub.f f433780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eub.g f433781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f433782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f433783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Boolean> f433784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Long> f433785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Long> f433786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f433787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f433788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f433789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f433790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f433791l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f433780a, r101.f433780a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f433781b, r101.f433781b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f433782c, r101.f433782c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f433783d, r101.f433783d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f433784e, r101.f433784e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f433785f, r101.f433785f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f433786g, r101.f433786g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f433787h, r101.f433787h) == true) goto L33;
        return false;
    L33:
        if (this.f433788i == r101.f433788i) goto L36;
        return false;
    L36:
        if (this.f433789j == r101.f433789j) goto L39;
        return false;
    L39:
        if (this.f433790k == r101.f433790k) goto L42;
        return false;
    L42:
        if (this.f433791l == r101.f433791l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((this.f433780a.hashCode() * 31) + this.f433781b.hashCode()) * 31) + this.f433782c.hashCode()) * 31) + this.f433783d.hashCode()) * 31) + this.f433784e.hashCode()) * 31) + this.f433785f.hashCode()) * 31) + this.f433786g.hashCode()) * 31) + this.f433787h.hashCode()) * 31;
        long r101 = this.f433788i;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f433789j;
        return ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f433790k) * 31) + this.f433791l;
    }

    public final String toString() {
        return "MmMinutesFileUploadStoredTask(param=" + this.f433780a + ", status=" + this.f433781b + ", uploadToken=" + this.f433782c + ", uploadTaskIds=" + this.f433783d + ", uploadTaskDoneMap=" + this.f433784e + ", uploadTaskTransferredBytes=" + this.f433785f + ", uploadTaskTotalBytes=" + this.f433786g + ", uploadFileTokenMap=" + this.f433787h + ", lastTotalTransferredBytes=" + this.f433788i + ", lastCallbackTs=" + this.f433789j + ", lastSpeedKBps=" + this.f433790k + ", pipelineRetryCount=" + this.f433791l + ')';
    }

    public o() {
        this(new eub.f(null, null, null, null, null, null, null, null, null, 511), new eub.g(null, null, 255), "", CollectionsKt.emptyList(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), 0, 0, 0, 0);
    }

    public o(eub.f r100, eub.g r101, String r102, List<String> r103, Map<String, Boolean> r104, Map<String, Long> r105, Map<String, Long> r106, Map<String, String> r107, long r110, long r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "status");
        Intrinsics.checkNotNullParameter(r102, "uploadToken");
        Intrinsics.checkNotNullParameter(r103, "uploadTaskIds");
        Intrinsics.checkNotNullParameter(r104, "uploadTaskDoneMap");
        Intrinsics.checkNotNullParameter(r105, "uploadTaskTransferredBytes");
        Intrinsics.checkNotNullParameter(r106, "uploadTaskTotalBytes");
        Intrinsics.checkNotNullParameter(r107, "uploadFileTokenMap");
        this.f433780a = r100;
        this.f433781b = r101;
        this.f433782c = r102;
        this.f433783d = r103;
        this.f433784e = r104;
        this.f433785f = r105;
        this.f433786g = r106;
        this.f433787h = r107;
        this.f433788i = r110;
        this.f433789j = r111;
        this.f433790k = r112;
        this.f433791l = r113;
    }
}
