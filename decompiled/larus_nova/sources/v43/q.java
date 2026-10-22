package v43;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f553079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f553080d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L14;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f553077a, r101.f553077a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f553078b, r101.f553078b) == true) goto L10;
        return false;
    L10:
        if (this.f553079c == r101.f553079c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553080d, r101.f553080d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        String r100 = this.f553077a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f553078b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f553079c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f553080d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SkuSecondaryPageEventInfo(eventName=" + this.f553077a + ", opportunity=" + this.f553078b + ", needHold=" + this.f553079c + ", renderNodeKey=" + this.f553080d + ")";
    }

    public q(String r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "opportunity");
        Intrinsics.checkNotNullParameter(r103, "renderNodeKey");
        this.f553077a = r100;
        this.f553078b = r101;
        this.f553079c = r102;
        this.f553080d = r103;
    }
}
