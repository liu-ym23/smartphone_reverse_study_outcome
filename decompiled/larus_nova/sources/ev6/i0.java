package ev6;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i0 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f474337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f474338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f474339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f474340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f474341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f474342g;

    public i0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f474337b, r101.f474337b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474338c, r101.f474338c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474339d, r101.f474339d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474340e, r101.f474340e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474341f, r101.f474341f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474342g, r101.f474342g) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f474337b;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f474338c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f474339d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        float[] r110 = this.f474340e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f474341f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f474342g;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = Arrays.hashCode(r110);
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
        return "ShelfProductTextLabelItemUIData(textColor=" + this.f474337b + ", textSize=" + this.f474338c + ", text=" + this.f474339d + ", margin=" + Arrays.toString(this.f474340e) + ", maxWidth=" + this.f474341f + ", bgColor=" + this.f474342g + ')';
    }

    @Override // ev6.a
    public final Integer a() {
        return this.f474342g;
    }

    public i0(int r100) {
        super(null);
        this.f474337b = null;
        this.f474338c = null;
        this.f474339d = null;
        this.f474340e = null;
        this.f474341f = null;
        this.f474342g = null;
    }
}
