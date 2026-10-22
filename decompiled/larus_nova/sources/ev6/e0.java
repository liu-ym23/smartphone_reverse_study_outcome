package ev6;

import android.graphics.Typeface;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f474304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f474305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f474306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Typeface f474307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f474308e;

    public e0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f474304a, r101.f474304a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474305b, r101.f474305b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474306c, r101.f474306c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474307d, r101.f474307d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474308e, r101.f474308e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474304a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f474305b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f474306c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Typeface r110 = this.f474307d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        float[] r113 = this.f474308e;
        if (r113 == null) goto L23;
        r101 = Arrays.hashCode(r113);
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
        return "ShelfProductSerialNumberInfoUIData(text=" + this.f474304a + ", bgColor=" + this.f474305b + ", textColor=" + this.f474306c + ", fontStyle=" + this.f474307d + ", radius=" + Arrays.toString(this.f474308e) + ')';
    }

    public e0(int r100) {
        this.f474304a = null;
        this.f474305b = null;
        this.f474306c = null;
        this.f474307d = null;
        this.f474308e = null;
    }
}
