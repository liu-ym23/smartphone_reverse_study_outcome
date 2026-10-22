package yvb;

import com.ss.android.lark.widget.span.PrefixSpan;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f569321f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f569322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f569323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f569324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, b> f569325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f569326e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrefixSpan.Type f569327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Float f569328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f569329c;

        public b() {
            this(null, null, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f569327a == r101.f569327a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f569328b, r101.f569328b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f569329c, r101.f569329c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            PrefixSpan.Type r100 = this.f569327a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Float r104 = this.f569328b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f569329c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "LevelStyle(iconType=" + this.f569327a + ", iconSizeDp=" + this.f569328b + ", color=" + this.f569329c + ')';
        }

        public b(PrefixSpan.Type r100, Float r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this.f569327a = r100;
            this.f569328b = r101;
            this.f569329c = null;
        }
    }

    public d() {
        this(0.0f, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Float.compare(this.f569322a, r101.f569322a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f569323b, r101.f569323b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f569324c, r101.f569324c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f569325d, r101.f569325d) == true) goto L21;
        return false;
    L21:
        if (this.f569326e == r101.f569326e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.f569322a) * 31;
        Integer r101 = this.f569323b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f569324c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (((r104 + r102) * 31) + this.f569325d.hashCode()) * 31;
        if (this.f569326e == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmMarkDownStyle(textSizeSp=" + this.f569322a + ", unorderedListColor=" + this.f569323b + ", orderedListColor=" + this.f569324c + ", levelStyles=" + this.f569325d + ", needAnotherLine=" + this.f569326e + ')';
    }

    static {
        PrefixSpan.Type r100 = PrefixSpan.Type.FILL_CIRCLE;
        Float r101 = Float.valueOf(5.0f);
        f569321f = new d(17.0f, MapsKt.mapOf(new Pair[]{TuplesKt.to(1, new b(r100, r101, 4)), TuplesKt.to(2, new b(PrefixSpan.Type.HOLLOW_CIRCLE, r101, 4)), TuplesKt.to(3, new b(PrefixSpan.Type.FILL_RECT, r101, 4)), TuplesKt.to(4, new b(PrefixSpan.Type.HOLLOW_RECT, r101, 4))}), 22);
    }

    public d(float r100, Map r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 16.0f;
    L6:
        if ((r102 & 8) == 0) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        Intrinsics.checkNotNullParameter(r101, "levelStyles");
        this.f569322a = r100;
        this.f569323b = null;
        this.f569324c = null;
        this.f569325d = r101;
        this.f569326e = false;
    }
}
