package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements com.bytedance.locallife.live.goodsshelves.processor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f474275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f474276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n0 f474277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n0 f474278d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f474279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f474280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f474281c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f474282d;

        public a() {
            int r100 = 0;
            this(r100, r100, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f474279a == r101.f474279a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f474280b, r101.f474280b) == 0) goto L15;
            return false;
        L15:
            if (this.f474281c == r101.f474281c) goto L18;
            return false;
        L18:
            if (this.f474282d == r101.f474282d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.f474279a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((((r100 * 31) + Float.floatToIntBits(this.f474280b)) * 31) + this.f474281c) * 31) + this.f474282d;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "PropsUIData(visible=" + this.f474279a + ", paddingTop=" + this.f474280b + ", groupOrder=" + this.f474281c + ", groupCount=" + this.f474282d + ')';
        }

        public /* synthetic */ a(int r100, int r101, int r102) {
            if ((r102 & 4) == 0) goto L6;
            r100 = 1;
        L6:
            if ((r102 & 8) == 0) goto L8;
            r101 = 1;
        L8:
            this(false, 0.0f, r100, r101);
        }

        public a(boolean r100, float r101, int r102, int r103) {
            this.f474279a = r100;
            this.f474280b = r101;
            this.f474281c = r102;
            this.f474282d = r103;
        }
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f474275a, r101.f474275a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474276b, r101.f474276b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474277c, r101.f474277c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474278d, r101.f474278d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f474275a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        f r104 = this.f474276b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        n0 r107 = this.f474277c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        n0 r110 = this.f474278d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ShelfBrandUIData(propsUIData=" + this.f474275a + ", brandIcon=" + this.f474276b + ", brandNameUIData=" + this.f474277c + ", specialIdUIData=" + this.f474278d + ')';
    }

    public c(int r100) {
        this.f474275a = null;
        this.f474276b = null;
        this.f474277c = null;
        this.f474278d = null;
    }
}
