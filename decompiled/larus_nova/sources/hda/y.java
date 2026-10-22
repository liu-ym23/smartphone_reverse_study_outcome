package hda;

import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewFeedbackState;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemoryReviewFeedbackState f484793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Vote f484794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f484795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f484796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f484798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f484799g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f484793a == r101.f484793a) goto L12;
        return false;
    L12:
        if (this.f484794b == r101.f484794b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f484795c, r101.f484795c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f484796d, r101.f484796d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f484797e, r101.f484797e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f484798f, r101.f484798f) == true) goto L27;
        return false;
    L27:
        if (this.f484799g == r101.f484799g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f484793a.hashCode() * 31;
        Vote r101 = this.f484794b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f484795c.hashCode()) * 31) + this.f484796d.hashCode()) * 31;
        String r105 = this.f484797e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f484798f;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        long r109 = this.f484799g;
        return ((r107 + r102) * 31) + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryReviewFeedbackInfoDto(state=" + this.f484793a + ", vote=" + this.f484794b + ", reasons=" + this.f484795c + ", comment=" + this.f484796d + ", displayedCardJson=" + this.f484797e + ", traceJson=" + this.f484798f + ", updateTimeMillis=" + this.f484799g + ')';
    }

    public y(MemoryReviewFeedbackState r100, Vote r101, Set<String> r102, String r103, String r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r102, "reasons");
        Intrinsics.checkNotNullParameter(r103, "comment");
        this.f484793a = r100;
        this.f484794b = r101;
        this.f484795c = r102;
        this.f484796d = r103;
        this.f484797e = r104;
        this.f484798f = r105;
        this.f484799g = r106;
    }
}
