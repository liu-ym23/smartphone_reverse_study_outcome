package dg3;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f468378l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f468379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f468380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f468381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f468382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f468383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f468384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f468385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f468386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f468387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f468388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f468389k;

    /* JADX INFO: renamed from: dg3.a$a, reason: collision with other inner class name */
    public static final class C5665a {
        public static a a(HashMap r110) {
            Object r100 = null;
            if (r110 == null) goto L5;
            Object r101 = r110.get("order_id");
        L7:
            if ((r101 instanceof String) == true) goto L9;
            r101 = null;
        L9:
            String r102 = (String) r101;
            if (r102 == null) goto L12;
            Long r103 = Long.valueOf(CastLongProtector.parseLong(r102));
        L13:
            if (r110 == null) goto L15;
            Object r104 = r110.get("product_id");
        L17:
            if ((r104 instanceof String) == true) goto L19;
            r104 = null;
        L19:
            String r105 = (String) r104;
            if (r105 == null) goto L22;
            Long r106 = Long.valueOf(CastLongProtector.parseLong(r105));
        L23:
            if (r110 == null) goto L25;
            Object r107 = r110.get("content");
        L27:
            if ((r107 instanceof String) == true) goto L29;
            r107 = null;
        L29:
            String r108 = (String) r107;
            if (r110 == null) goto L32;
            Object r109 = r110.get("content_count");
        L34:
            if ((r109 instanceof Integer) == true) goto L36;
            r109 = null;
        L36:
            Integer r111 = (Integer) r109;
            if (r111 == null) goto L39;
            Long r112 = Long.valueOf(r111.intValue());
        L40:
            if (r110 == null) goto L42;
            Object r113 = r110.get("rank_good");
        L44:
            if ((r113 instanceof Integer) == true) goto L46;
            r113 = null;
        L46:
            Integer r114 = (Integer) r113;
            if (r114 == null) goto L49;
            Long r115 = Long.valueOf(r114.intValue());
        L50:
            if (r110 == null) goto L52;
            Object r116 = r110.get("photos");
        L54:
            if ((r116 instanceof List) == true) goto L56;
            r116 = null;
        L56:
            List r117 = (List) r116;
            if (r110 == null) goto L59;
            Object r118 = r110.get("videos");
        L61:
            if ((r118 instanceof List) == true) goto L63;
            r118 = null;
        L63:
            List r119 = (List) r118;
            if (r110 == null) goto L66;
            Object r120 = r110.get(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_PRICE);
        L68:
            if ((r120 instanceof String) == true) goto L70;
            r120 = null;
        L70:
            String r121 = (String) r120;
            if (r110 == null) goto L73;
            Object r122 = r110.get("product_sales");
        L75:
            if ((r122 instanceof String) == true) goto L77;
            r122 = null;
        L77:
            String r123 = (String) r122;
            if (r110 == null) goto L80;
            Object r124 = r110.get("product_images");
        L82:
            if ((r124 instanceof List) == true) goto L84;
            r124 = null;
        L84:
            List r125 = (List) r124;
            if (r110 == null) goto L87;
            Object r126 = r110.get("product_title");
        L89:
            if ((r126 instanceof String) == false) goto L93;
            r100 = r126;
        L93:
            return new a(r103, r106, r108, r112, r115, r117, r119, r121, r123, r125, (String) r100);
        L87:
            r126 = null;
            goto L89
        L80:
            r124 = null;
            goto L82
        L73:
            r122 = null;
            goto L75
        L66:
            r120 = null;
            goto L68
        L59:
            r118 = null;
            goto L61
        L52:
            r116 = null;
            goto L54
        L49:
            r115 = null;
            goto L50
        L42:
            r113 = null;
            goto L44
        L39:
            r112 = null;
            goto L40
        L32:
            r109 = null;
            goto L34
        L25:
            r107 = null;
            goto L27
        L22:
            r106 = null;
            goto L23
        L15:
            r104 = null;
            goto L17
        L12:
            r103 = null;
            goto L13
        L5:
            r101 = null;
            goto L7
        }
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L28;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f468379a, r101.f468379a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468380b, r101.f468380b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468381c, r101.f468381c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468382d, r101.f468382d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f468383e, r101.f468383e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f468384f, r101.f468384f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468385g, r101.f468385g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f468386h, r101.f468386h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f468387i, r101.f468387i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f468388j, r101.f468388j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f468389k, r101.f468389k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f468379a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f468380b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f468381c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f468382d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f468383e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.f468384f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.f468385g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f468386h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f468387i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        List<String> r128 = this.f468388j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f468389k;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
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
        return "CommentStruct(orderId=" + this.f468379a + ", productId=" + this.f468380b + ", content=" + this.f468381c + ", contentCount=" + this.f468382d + ", rankGood=" + this.f468383e + ", photos=" + this.f468384f + ", videos=" + this.f468385g + ", price=" + this.f468386h + ", sales=" + this.f468387i + ", imageUrls=" + this.f468388j + ", productTitle=" + this.f468389k + ")";
    }

    public a(Long r100, Long r101, String r102, Long r103, Long r104, List<String> r105, List<String> r106, String r107, String r108, List<String> r110, String r111) {
        this.f468379a = r100;
        this.f468380b = r101;
        this.f468381c = r102;
        this.f468382d = r103;
        this.f468383e = r104;
        this.f468384f = r105;
        this.f468385g = r106;
        this.f468386h = r107;
        this.f468387i = r108;
        this.f468388j = r110;
        this.f468389k = r111;
    }
}
