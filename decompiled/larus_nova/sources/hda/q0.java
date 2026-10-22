package hda;

import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewFeedbackState;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemoryDataReviewModuleKey f484741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f484742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f484743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MemoryReviewFeedbackState f484745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f484746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f484747h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.f484740a, r101.f484740a) == true) goto L12;
        return false;
    L12:
        if (this.f484741b == r101.f484741b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f484742c, r101.f484742c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f484743d, r101.f484743d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f484744e, r101.f484744e) == true) goto L24;
        return false;
    L24:
        if (this.f484745f == r101.f484745f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f484746g, r101.f484746g) == true) goto L30;
        return false;
    L30:
        if (this.f484747h == r101.f484747h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f484740a.hashCode() * 31) + this.f484741b.hashCode()) * 31;
        String r101 = this.f484742c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f484743d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f484744e.hashCode()) * 31) + this.f484745f.hashCode()) * 31;
        String r108 = this.f484746g;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        long r109 = this.f484747h;
        return ((r107 + r102) * 31) + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewRecordDto(recordId=" + this.f484740a + ", module=" + this.f484741b + ", title=" + this.f484742c + ", summary=" + this.f484743d + ", cardPayloadJson=" + this.f484744e + ", feedbackState=" + this.f484745f + ", traceJson=" + this.f484746g + ", updateTimeMillis=" + this.f484747h + ')';
    }

    public q0(String r100, MemoryDataReviewModuleKey r101, String r102, String r103, String r104, MemoryReviewFeedbackState r105, String r106, long r107) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r104, "cardPayloadJson");
        Intrinsics.checkNotNullParameter(r105, "feedbackState");
        this.f484740a = r100;
        this.f484741b = r101;
        this.f484742c = r102;
        this.f484743d = r103;
        this.f484744e = r104;
        this.f484745f = r105;
        this.f484746g = r106;
        this.f484747h = r107;
    }
}
