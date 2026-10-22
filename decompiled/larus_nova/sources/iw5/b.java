package iw5;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f496221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f496222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f496223c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f496221a, r101.f496221a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f496222b, r101.f496222b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f496223c, r101.f496223c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f496221a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f496222b.hashCode()) * 31;
        String r104 = this.f496223c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAsrResponseExtraInfo(audioDataTosUri=" + this.f496221a + ", audioEventResponses=" + this.f496222b + ", logId=" + this.f496223c + ')';
    }

    public b() {
        this(null, CollectionsKt.emptyList(), null);
    }

    public b(String r100, List<a> r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "audioEventResponses");
        this.f496221a = r100;
        this.f496222b = r101;
        this.f496223c = r102;
    }
}
