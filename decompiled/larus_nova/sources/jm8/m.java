package jm8;

import defpackage.AndroidUnique;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @AndroidUnique
    public final String f499689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pair<Integer, Integer> f499690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f499691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f499692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f499693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f499694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f499695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f499696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f499697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f499698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f499699k;

    public m() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f499689a, r101.f499689a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499690b, r101.f499690b) == true) goto L15;
        return false;
    L15:
        if (this.f499691c == r101.f499691c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f499692d, r101.f499692d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f499693e, r101.f499693e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f499694f, r101.f499694f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f499695g, r101.f499695g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f499696h, r101.f499696h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f499697i, r101.f499697i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f499698j, r101.f499698j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f499699k, r101.f499699k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f499689a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Pair<Integer, Integer> r104 = this.f499690b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f499691c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        Integer r109 = this.f499692d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        Boolean r112 = this.f499693e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f499694f;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f499695g;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f499696h;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        Boolean r124 = this.f499697i;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.f499698j;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.f499699k;
        if (r130 == null) goto L43;
        r101 = r130.hashCode();
    L43:
        return r129 + r101;
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryViewInput(messageId=" + this.f499689a + ", topAndBottomMarginPair=" + this.f499690b + ", tipDismissDuration=" + this.f499691c + ", cardPosition=" + this.f499692d + ", memoryLoadingHide=" + this.f499693e + ", memoryIconUrlDark=" + this.f499694f + ", memoryIconUrl=" + this.f499695g + ", memoryTitle=" + this.f499696h + ", memoryLoading=" + this.f499697i + ", memoryTipTitle=" + this.f499698j + ", memoryTipSubTitle=" + this.f499699k + ')';
    }

    public /* synthetic */ m(int r110) {
        this(null, null, 0, null, null, null, null, null, null, null, null);
    }

    public m(String r100, Pair<Integer, Integer> r101, long r102, Integer r103, Boolean r104, String r105, String r106, String r107, Boolean r110, String r111, String r112) {
        this.f499689a = r100;
        this.f499690b = r101;
        this.f499691c = r102;
        this.f499692d = r103;
        this.f499693e = r104;
        this.f499694f = r105;
        this.f499695g = r106;
        this.f499696h = r107;
        this.f499697i = r110;
        this.f499698j = r111;
        this.f499699k = r112;
    }
}
