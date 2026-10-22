package com.obric.oui.common.style;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q f399591h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f399592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f399593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f399594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f399595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f399596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f399597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f399598g;

    public static final class a {
        @JvmStatic
        public static q a(com.obric.oui.shadow.b r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            q r102 = new q(r100.f402810d, pla.d.h(r100.f402809c, r101), pla.d.h(r100.f402807a, r101), pla.d.h(r100.f402808b, r101), pla.d.h(r100.f402811e, r101));
            if (r102.f399593b <= 0.0f) goto L5;
            r102.f399597f.setMaskFilter(new BlurMaskFilter(r102.f399593b, BlurMaskFilter.Blur.NORMAL));
        L6:
            return r102;
        L5:
            r102.f399597f.setMaskFilter(null);
            goto L6
        }

        @JvmStatic
        public static List b(float r110, List r111, List r112) {
            if (Float.isInfinite(r110) == false) goto L5;
        L7:
            boolean r100 = false;
        L9:
            if (r100 == true) goto L12;
            r110 = 0.0f;
        L12:
            float r113 = RangesKt.coerceIn(r110, 0.0f, 1.0f);
            if (r111 == null) goto L27;
            if (r112 != null) goto L16;
            return r111;
        L16:
            if (r111.size() != r112.size()) goto L29;
            List r114 = r111;
            Iterator r101 = r114.iterator();
            List r115 = r112;
            Iterator r102 = r115.iterator();
            ArrayList r103 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r114, 10), CollectionsKt.collectionSizeOrDefault(r115, 10)));
        L19:
            if (r101.hasNext() == false) goto L24;
            if (r102.hasNext() == false) goto L24;
            Object r116 = r101.next();
            q r117 = (q) r102.next();
            q r118 = (q) r116;
            int r104 = r118.f399592a;
            int r105 = r117.f399592a;
            int r106 = vma.b.f556350a;
            int r107 = (r104 >> 24) & 255;
            int r108 = (r104 >> 16) & 255;
            int r109 = (r104 >> 8) & 255;
            int r119 = r104 & 255;
            int r120 = (int) (r119 + (((r105 & 255) - r119) * r113));
            int r121 = (((((int) (r107 + ((((r105 >> 24) & 255) - r107) * r113))) << 24) | (((int) (r108 + ((((r105 >> 16) & 255) - r108) * r113))) << 16)) | (((int) (r109 + ((((r105 >> 8) & 255) - r109) * r113))) << 8)) | r120;
            float r122 = r118.f399593b;
            float r123 = ((r117.f399593b - r122) * r113) + r122;
            float r124 = r118.f399594c;
            float r125 = ((r117.f399594c - r124) * r113) + r124;
            float r126 = r118.f399595d;
            float r127 = ((r117.f399595d - r126) * r113) + r126;
            float r128 = r118.f399596e;
            r103.add(new q(r121, r123, r125, r127, r128 + ((r117.f399596e - r128) * r113)));
        L24:
            return r103;
        L29:
            return r111;
        L27:
            return r111;
        L5:
            if (Float.isNaN(r110) == true) goto L7;
            r100 = true;
            goto L9
        }
    }

    public final int hashCode() {
        return (((((((((((this.f399592a * 31) + Float.floatToIntBits(this.f399593b)) * 31) + Float.floatToIntBits(this.f399594c)) * 31) + Float.floatToIntBits(this.f399595d)) * 31) + Float.floatToIntBits(this.f399596e)) * 31) + this.f399597f.hashCode()) * 31) + Float.floatToIntBits(this.f399598g);
    }

    public final String toString() {
        return "Shadow(color=" + this.f399592a + ", radius=" + this.f399593b + ", offsetX=" + this.f399594c + ", offsetY=" + this.f399595d + ", spread=" + this.f399596e + ", paint=" + this.f399597f + ", cornerRadius=" + this.f399598g + ')';
    }

    static {
        f399591h = new q(0, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final q a() {
        int r100 = this.f399592a;
        float r101 = this.f399593b;
        float r102 = this.f399594c;
        float r103 = this.f399595d;
        float r104 = this.f399596e;
        Paint r105 = new Paint(this.f399597f);
        r105.set(this.f399597f);
        Unit r106 = Unit.INSTANCE;
        return new q(r100, r101, r102, r103, r104, r105, this.f399598g);
    }

    public final boolean e() {
        if (this.f399594c != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return true;
    L8:
        if (this.f399595d != 0.0f) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L13;
        return true;
    L13:
        if (this.f399593b != 0.0f) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == true) goto L18;
        return true;
    L18:
        if (this.f399596e != 0.0f) goto L20;
        boolean r103 = true;
    L21:
        if (r103 == false) goto L28;
        return false;
    L28:
        return true;
    L20:
        r103 = false;
        goto L21
    L15:
        r102 = false;
        goto L16
    L10:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    @JvmStatic
    public static final q b(com.obric.oui.shadow.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        q r101 = new q(r100.f402804d, r100.f402803c, r100.f402801a, r100.f402802b, r100.f402805e);
        if (r101.f399593b <= 0.0f) goto L5;
        r101.f399597f.setMaskFilter(new BlurMaskFilter(r101.f399593b, BlurMaskFilter.Blur.NORMAL));
    L6:
        return r101;
    L5:
        r101.f399597f.setMaskFilter(null);
        goto L6
    }

    public final void c(com.obric.oui.shadow.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        com.obric.oui.shadow.b r101 = r100.b();
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f399592a = r101.f402810d;
        this.f399594c = r101.f402807a;
        this.f399595d = r101.f402808b;
        this.f399596e = r101.f402811e;
        float r102 = this.f399593b;
        float r103 = r101.f402809c;
        if (r102 != r103) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L12;
        this.f399593b = r103;
        if (r103 <= 0.0f) goto L10;
        this.f399597f.setMaskFilter(new BlurMaskFilter(this.f399593b, BlurMaskFilter.Blur.NORMAL));
        return;
    L10:
        this.f399597f.setMaskFilter(null);
        return;
    L12:
        return;
    L5:
        r104 = false;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        Class<?> r101 = null;
    L10:
        if (Intrinsics.areEqual(q.class, r101) == true) goto L12;
        return false;
    L12:
        if (r100 == null) goto L51;
        q r102 = (q) r100;
        if (this.f399592a == r102.f399592a) goto L17;
        return false;
    L17:
        if (this.f399593b != r102.f399593b) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == true) goto L23;
        return false;
    L23:
        if (this.f399594c != r102.f399594c) goto L25;
        boolean r104 = true;
    L26:
        if (r104 == true) goto L29;
        return false;
    L29:
        if (this.f399595d != r102.f399595d) goto L31;
        boolean r105 = true;
    L32:
        if (r105 == true) goto L35;
        return false;
    L35:
        if (this.f399596e != r102.f399596e) goto L37;
        boolean r106 = true;
    L38:
        if (r106 == true) goto L41;
        return false;
    L41:
        if (Intrinsics.areEqual(this.f399597f, r102.f399597f) == true) goto L44;
        return false;
    L44:
        if (this.f399598g != r102.f399598g) goto L46;
        boolean r107 = true;
    L47:
        if (r107 == true) goto L49;
        return false;
    L49:
        return true;
    L46:
        r107 = false;
        goto L47
    L37:
        r106 = false;
        goto L38
    L31:
        r105 = false;
        goto L32
    L25:
        r104 = false;
        goto L26
    L19:
        r103 = false;
        goto L20
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.Shadow");
    L8:
        r101 = r100.getClass();
        goto L10
    }

    public final void update(q r100) {
        boolean r101 = false;
        if (r100 == null) goto L12;
        this.f399592a = r100.f399592a;
        this.f399594c = r100.f399594c;
        this.f399595d = r100.f399595d;
        this.f399596e = r100.f399596e;
        float r102 = this.f399593b;
        float r103 = r100.f399593b;
        if (r102 != r103) goto L7;
        r101 = true;
    L7:
        if (r101 == true) goto L14;
        this.f399593b = r103;
        if (r103 <= 0.0f) goto L11;
        this.f399597f.setMaskFilter(new BlurMaskFilter(this.f399593b, BlurMaskFilter.Blur.NORMAL));
        return;
    L11:
        this.f399597f.setMaskFilter(null);
        return;
    L14:
        return;
    L12:
        this.f399592a = 0;
        this.f399593b = 0.0f;
        this.f399594c = 0.0f;
        this.f399595d = 0.0f;
        this.f399596e = 0.0f;
        this.f399598g = 0.0f;
        this.f399597f.setMaskFilter(null);
    }

    public final void d(com.obric.oui.shadow.b r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f399592a = r100.f402810d;
        this.f399594c = pla.d.h(r100.f402807a, r101);
        this.f399595d = pla.d.h(r100.f402808b, r101);
        this.f399596e = r100.f402811e;
        float r102 = this.f399593b;
        float r103 = r100.f402809c;
        if (r102 != (r103 * r101)) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L12;
        float r105 = r103 * r101;
        this.f399593b = r105;
        if (r105 <= 0.0f) goto L10;
        this.f399597f.setMaskFilter(new BlurMaskFilter(this.f399593b, BlurMaskFilter.Blur.NORMAL));
        return;
    L10:
        this.f399597f.setMaskFilter(null);
        return;
    L12:
        return;
    L5:
        r104 = false;
        goto L6
    }

    public /* synthetic */ q(int r100, float r110, float r111, float r112, float r113) {
        this(r100, r110, r111, r112, r113, new Paint(1), 0.0f);
    }

    public q(int r100, float r101, float r102, float r103, float r104, Paint r105, float r106) {
        Intrinsics.checkNotNullParameter(r105, "paint");
        this.f399592a = r100;
        this.f399593b = r101;
        this.f399594c = r102;
        this.f399595d = r103;
        this.f399596e = r104;
        this.f399597f = r105;
        this.f399598g = r106;
    }
}
