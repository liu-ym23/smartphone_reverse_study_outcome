package zv5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f573725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f573726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f573727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f573728e;

    public k() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f573724a, r101.f573724a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573725b, r101.f573725b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f573726c, r101.f573726c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f573727d, r101.f573727d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f573728e, r101.f573728e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f573724a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        j r104 = this.f573725b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f573726c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f573727d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f573728e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "SearchMixedFeedPreview(doubaoConversationId=" + this.f573724a + ", chat=" + this.f573725b + ", updateTime=" + this.f573726c + ", rankLevel=" + this.f573727d + ", onTopRankTime=" + this.f573728e + ')';
    }

    public k(String r100, j r101, Long r102, Integer r103, Long r104) {
        this.f573724a = r100;
        this.f573725b = r101;
        this.f573726c = r102;
        this.f573727d = r103;
        this.f573728e = r104;
    }
}
