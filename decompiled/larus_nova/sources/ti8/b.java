package ti8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f546241m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f546242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f546243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f546244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f546245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f546246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f546247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f546248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f546249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f546250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f546251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f546252k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f546253l;

    public static final class a {

        /* JADX INFO: renamed from: ti8.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C7731a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f546254a = null;

            static {
                int[] r100 = new int[ExpandCardViewMode.values().length];
                r100[ExpandCardViewMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[ExpandCardViewMode.EXPAND_PIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[ExpandCardViewMode.NORMAL_PIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[ExpandCardViewMode.EXPAND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[ExpandCardViewMode.NORMAL_SHARE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[ExpandCardViewMode.EXPAND_SHARE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f546254a = r100;
            }
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f546242a == r101.f546242a) goto L12;
        return false;
    L12:
        if (this.f546243b == r101.f546243b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f546244c, r101.f546244c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f546245d, r101.f546245d) == true) goto L21;
        return false;
    L21:
        if (this.f546246e == r101.f546246e) goto L24;
        return false;
    L24:
        if (this.f546247f == r101.f546247f) goto L27;
        return false;
    L27:
        if (this.f546248g == r101.f546248g) goto L30;
        return false;
    L30:
        if (this.f546249h == r101.f546249h) goto L33;
        return false;
    L33:
        if (this.f546250i == r101.f546250i) goto L36;
        return false;
    L36:
        if (this.f546251j == r101.f546251j) goto L39;
        return false;
    L39:
        if (this.f546252k == r101.f546252k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f546253l, r101.f546253l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f546242a * 31) + this.f546243b) * 31;
        String r101 = this.f546244c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f546245d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f546246e) * 31) + this.f546247f) * 31;
        int r108 = 1231;
        if (this.f546248g == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f546249h == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        if (this.f546250i == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.f546251j == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f546252k == true) goto L30;
        r108 = 1237;
    L30:
        int r117 = (r116 + r108) * 31;
        String r118 = this.f546253l;
        if (r118 == null) goto L35;
        r102 = r118.hashCode();
    L35:
        return r117 + r102;
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchImageCardViewData(width=" + this.f546242a + ", height=" + this.f546243b + ", imageUrl=" + this.f546244c + ", imageUri=" + this.f546245d + ", foldCount=" + this.f546246e + ", cornerRadius=" + this.f546247f + ", roundTopLeft=" + this.f546248g + ", roundTopRight=" + this.f546249h + ", roundBottomLeft=" + this.f546250i + ", roundBottomRight=" + this.f546251j + ", needShowSourceIcon=" + this.f546252k + ", mainSiteUrl=" + this.f546253l + ')';
    }

    public b(int r100, int r101, String r102, String r103, int r104, int r105, boolean r106, boolean r107, boolean r108, boolean r110, boolean r111, String r112) {
        this.f546242a = r100;
        this.f546243b = r101;
        this.f546244c = r102;
        this.f546245d = r103;
        this.f546246e = r104;
        this.f546247f = r105;
        this.f546248g = r106;
        this.f546249h = r107;
        this.f546250i = r108;
        this.f546251j = r110;
        this.f546252k = r111;
        this.f546253l = r112;
    }
}
