package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f465815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f465816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f465817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f465818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f465819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f465820f;

    public d() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f465815a, r101.f465815a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465816b, r101.f465816b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465817c, r101.f465817c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465818d, r101.f465818d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465819e, r101.f465819e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465820f, r101.f465820f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f465815a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f465816b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f465817c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f465818d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f465819e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f465820f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasCostTime(multimodal=" + this.f465815a + ", llm=" + this.f465816b + ", prePromptReview=" + this.f465817c + ", preReview=" + this.f465818d + ", creation=" + this.f465819e + ", blockCostTime=" + this.f465820f + ')';
    }

    public d(Long r100, Long r101, Long r102, Long r103, Long r104, Long r105) {
        this.f465815a = r100;
        this.f465816b = r101;
        this.f465817c = r102;
        this.f465818d = r103;
        this.f465819e = r104;
        this.f465820f = r105;
    }
}
