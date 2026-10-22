package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements com.bytedance.locallife.live.goodsshelves.processor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f474399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f474400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f474401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f474402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e0 f474403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g0 f474404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f474405g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Float f474406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Float f474407b;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f474406a, r101.f474406a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f474407b, r101.f474407b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Float r100 = this.f474406a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Float r104 = this.f474407b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PropsUIData(width=" + this.f474406a + ", height=" + this.f474407b + ')';
        }

        public a(int r100) {
            this.f474406a = null;
            this.f474407b = null;
        }
    }

    public o() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f474399a, r101.f474399a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474400b, r101.f474400b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474401c, r101.f474401c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474402d, r101.f474402d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474403e, r101.f474403e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474404f, r101.f474404f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474405g, r101.f474405g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f474399a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        n r104 = this.f474400b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        n r107 = this.f474401c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        h0 r110 = this.f474402d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        e0 r113 = this.f474403e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        g0 r116 = this.f474404f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f474405g;
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
        return "ShelfProductImgUIData(propsUIData=" + this.f474399a + ", imgInfo=" + this.f474400b + ", imgBorderInfo=" + this.f474401c + ", tagImgInfo=" + this.f474402d + ", serialNumberInfo=" + this.f474403e + ", statusInfo=" + this.f474404f + ", explainingVisible=" + this.f474405g + ')';
    }

    public o(int r100) {
        this.f474399a = null;
        this.f474400b = null;
        this.f474401c = null;
        this.f474402d = null;
        this.f474403e = null;
        this.f474404f = null;
        this.f474405g = null;
    }
}
