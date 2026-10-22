package hda;

import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemoryDataReviewModuleKey f484775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Vote f484776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f484777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f484779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f484780g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r101 = (w0) r100;
        if (Intrinsics.areEqual(this.f484774a, r101.f484774a) == true) goto L12;
        return false;
    L12:
        if (this.f484775b == r101.f484775b) goto L15;
        return false;
    L15:
        if (this.f484776c == r101.f484776c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f484777d, r101.f484777d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f484778e, r101.f484778e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f484779f, r101.f484779f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f484780g, r101.f484780g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f484774a.hashCode() * 31) + this.f484775b.hashCode()) * 31) + this.f484776c.hashCode()) * 31) + this.f484777d.hashCode()) * 31) + this.f484778e.hashCode()) * 31) + this.f484779f.hashCode()) * 31;
        String r101 = this.f484780g;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MemoryReviewSubmitFeedbackDto(recordId=" + this.f484774a + ", module=" + this.f484775b + ", vote=" + this.f484776c + ", reasons=" + this.f484777d + ", comment=" + this.f484778e + ", businessPayloadJson=" + this.f484779f + ", traceJson=" + this.f484780g + ')';
    }

    public w0(String r100, MemoryDataReviewModuleKey r101, Vote r102, Set<String> r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "vote");
        Intrinsics.checkNotNullParameter(r103, "reasons");
        Intrinsics.checkNotNullParameter(r104, "comment");
        Intrinsics.checkNotNullParameter(r105, "businessPayloadJson");
        this.f484774a = r100;
        this.f484775b = r101;
        this.f484776c = r102;
        this.f484777d = r103;
        this.f484778e = r104;
        this.f484779f = r105;
        this.f484780g = r106;
    }
}
