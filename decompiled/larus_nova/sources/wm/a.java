package wm;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C8131a f560254m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f560257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f560258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class<? extends Object> f560259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f560260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f560261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f560262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f560263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PromotionDiscountLabel f560264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f560265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ECRitTag f560266l;

    /* JADX INFO: renamed from: wm.a$a, reason: collision with other inner class name */
    public static final class C8131a {
        public C8131a() {
        }
    }

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L30;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f560255a, r101.f560255a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f560256b, r101.f560256b) == true) goto L10;
        return false;
    L10:
        if (this.f560257c == r101.f560257c) goto L12;
        return false;
    L12:
        if (this.f560258d == r101.f560258d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f560259e, r101.f560259e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f560260f, r101.f560260f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f560261g, r101.f560261g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f560262h, r101.f560262h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f560263i, r101.f560263i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f560264j, r101.f560264j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f560265k, r101.f560265k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f560266l, r101.f560266l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f560255a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f560256b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f560257c) * 31) + this.f560258d) * 31;
        Class<? extends Object> r107 = this.f560259e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f560260f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f560261g;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f560262h;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f560263i;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        PromotionDiscountLabel r122 = this.f560264j;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f560265k;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        ECRitTag r128 = this.f560266l;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductTagVO(prefix=" + this.f560255a + ", text=" + this.f560256b + ", textColor=" + this.f560257c + ", strokeColor=" + this.f560258d + ", type=" + this.f560259e + ", tagIcon=" + this.f560260f + ", headerBgColor=" + this.f560261g + ", backgroundColor=" + this.f560262h + ", lineType=" + this.f560263i + ", promotionDiscountLabel=" + this.f560264j + ", tagId=" + this.f560265k + ", ritTag=" + this.f560266l + ")";
    }

    static {
        f560254m = new C8131a();
    }

    public final Class<? extends Object> getType() {
        return this.f560259e;
    }

    public a(String r100, String r101, int r102, int r103, Class r104, String r105, String r106, Integer r110, Integer r111, PromotionDiscountLabel r112, ECRitTag r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r114 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r114 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r114 & 32) == 0) goto L15;
        r105 = null;
    L15:
        if ((r114 & 64) == 0) goto L18;
        r106 = null;
    L18:
        if ((r114 & 128) == 0) goto L21;
        r110 = null;
    L21:
        if ((r114 & 256) == 0) goto L24;
        r111 = null;
    L24:
        if ((r114 & 512) == 0) goto L27;
        r112 = null;
    L27:
        if ((r114 & 2048) == 0) goto L29;
        r113 = null;
    L29:
        this.f560255a = r100;
        this.f560256b = r101;
        this.f560257c = r102;
        this.f560258d = r103;
        this.f560259e = r104;
        this.f560260f = r105;
        this.f560261g = r106;
        this.f560262h = r110;
        this.f560263i = r111;
        this.f560264j = r112;
        this.f560265k = null;
        this.f560266l = r113;
    }
}
