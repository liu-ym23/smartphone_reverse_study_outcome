package y48;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f566085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f566086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f566087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f566088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pair<Float, Float> f566089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f566090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f566091g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f566085a, r101.f566085a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566086b, r101.f566086b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566087c, r101.f566087c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566088d, r101.f566088d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566089e, r101.f566089e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f566090f, r101.f566090f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f566091g, r101.f566091g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f566085a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f566086b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.f566087c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.f566088d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Pair<Float, Float> r113 = this.f566089e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f566090f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f566091g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "ChatSpeakerBlurStyle(circleColor=" + this.f566085a + ", lightCoverColor=" + this.f566086b + ", alpha=" + this.f566087c + ", circleScale=" + this.f566088d + ", highlightGlobalPosition=" + this.f566089e + ", dismissHighlight=" + this.f566090f + ", waveEnabled=" + this.f566091g + ')';
    }

    public e() {
        this.f566085a = null;
        this.f566086b = null;
        this.f566087c = null;
        this.f566088d = null;
        this.f566089e = null;
        this.f566090f = null;
        this.f566091g = null;
    }
}
