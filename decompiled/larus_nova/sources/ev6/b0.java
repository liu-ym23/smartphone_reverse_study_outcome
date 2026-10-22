package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b0 implements com.bytedance.locallife.live.goodsshelves.processor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f474265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f474266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f474267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f474268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f474269e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f474270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f474271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f474272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f474273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f474274e;

        public a() {
            this(0);
        }

        public final void e() {
            this.f474270a = true;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f474270a == r101.f474270a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f474271b, r101.f474271b) == 0) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f474272c, r101.f474272c) == true) goto L18;
            return false;
        L18:
            if (Float.compare(this.f474273d, r101.f474273d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f474274e, r101.f474274e) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            if (this.f474270a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + Float.floatToIntBits(this.f474271b)) * 31;
            String r102 = this.f474272c;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return ((((r101 + r103) * 31) + Float.floatToIntBits(this.f474273d)) * 31) + Float.floatToIntBits(this.f474274e);
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "PropsUIData(visible=" + this.f474270a + ", height=" + this.f474271b + ", bgColor=" + this.f474272c + ", paddingBottom=" + this.f474273d + ", paddingLeft=" + this.f474274e + ')';
        }

        public a(int r100) {
            this.f474270a = false;
            this.f474271b = 36.0f;
            this.f474272c = null;
            this.f474273d = 0.0f;
            this.f474274e = 0.0f;
        }

        public final void a(String r100) {
            this.f474272c = r100;
        }

        public final void b(float r100) {
            this.f474271b = r100;
        }

        public final void c(float r100) {
            this.f474273d = r100;
        }

        public final void d(float r100) {
            this.f474274e = r100;
        }
    }

    public b0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f474265a, r101.f474265a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474266b, r101.f474266b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474267c, r101.f474267c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474268d, r101.f474268d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474269e, r101.f474269e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f474265a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c0 r104 = this.f474266b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        l r107 = this.f474267c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        v r110 = this.f474268d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        i r113 = this.f474269e;
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
        return "ShelfProductPriceAndBtnUIData(propsUIData=" + this.f474265a + ", priceUIData=" + this.f474266b + ", flashSaleUIData=" + this.f474267c + ", marketingUIData=" + this.f474268d + ", actionAreaUIData=" + this.f474269e + ')';
    }

    public final i a() {
        return this.f474269e;
    }

    public b0(int r100) {
        this.f474265a = null;
        this.f474266b = null;
        this.f474267c = null;
        this.f474268d = null;
        this.f474269e = null;
    }

    public final void b(i r100) {
        this.f474269e = r100;
    }

    public final void c(l r100) {
        this.f474267c = r100;
    }

    public final void d(v r100) {
        this.f474268d = r100;
    }

    public final void e(c0 r100) {
        this.f474266b = r100;
    }

    public final void f(a r100) {
        this.f474265a = r100;
    }
}
