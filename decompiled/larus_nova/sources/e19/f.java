package e19;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f470726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntRange f470727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntRange f470728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IntRange f470729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IntRange f470730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f470731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Float f470732g;

    public static final class a {
    }

    static {
    }

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f470726a == r101.f470726a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470727b, r101.f470727b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470728c, r101.f470728c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470729d, r101.f470729d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f470730e, r101.f470730e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f470731f, r101.f470731f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f470732g, r101.f470732g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f470726a * 31;
        IntRange r101 = this.f470727b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        IntRange r105 = this.f470728c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        IntRange r108 = this.f470729d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        IntRange r111 = this.f470730e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f470731f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Float r117 = this.f470732g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FullScreenWindowConfig(peekWidth=" + this.f470726a + ", dragHotArea=" + this.f470727b + ", dragHotAreaX=" + this.f470728c + ", clickHotArea=" + this.f470729d + ", clickHotAreaX=" + this.f470730e + ", dragThreshold=" + this.f470731f + ", quickDragVelocity=" + this.f470732g + ')';
    }

    public /* synthetic */ f(int r100) {
        this(16, null, null, null, null, null, null);
    }

    public f(int r100, IntRange r101, IntRange r102, IntRange r103, IntRange r104, Integer r105, Float r106) {
        this.f470726a = r100;
        this.f470727b = r101;
        this.f470728c = r102;
        this.f470729d = r103;
        this.f470730e = r104;
        this.f470731f = r105;
        this.f470732g = r106;
    }
}
