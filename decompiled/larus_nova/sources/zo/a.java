package zo;

import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C8479a f573066m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f573067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f573069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f573070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class<? extends Object> f573071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f573072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f573073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f573074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f573075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PromotionDiscountLabel f573076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f573077k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ECRitTag f573078l;

    /* JADX INFO: renamed from: zo.a$a, reason: collision with other inner class name */
    public static final class C8479a {
        public C8479a() {
        }

        public static a a(ECRitTag r110, String r111, int r112, int r113) {
            Intrinsics.checkNotNullParameter(r110, "tag");
            List<String> r100 = r110.getText();
            List<String> r101 = r100;
            boolean r102 = true;
            if (r101 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L50;
            CharSequence r104 = (CharSequence) CollectionsKt.getOrNull(r100, 0);
            if (r104 != null) goto L13;
        L16:
            boolean r105 = true;
        L17:
            if (r105 == true) goto L52;
            Integer r106 = Integer.valueOf((int) BodyPartID.bodyIdMax);
            ECUIConfig r107 = r110.getUiConfig();
            if (r107 == null) goto L24;
            String r108 = r107.getTextColor();
            if (r108 == null) goto L24;
            int r109 = s.a(r108, r112);
        L25:
            Map<String, String> r114 = r110.getExtraColors();
            if (r114 != null) goto L28;
        L31:
            if (r102 == true) goto L47;
            Map<String, String> r115 = r110.getExtraColors();
            if (r115 == null) goto L37;
            String r116 = r115.get("text_color");
            if (r116 == null) goto L37;
            r109 = s.a(r116, r109);
        L37:
            if (r115 == null) goto L41;
            String r117 = r115.get("border_color");
            if (r117 == null) goto L41;
            int r118 = s.a(r117, r113);
        L42:
            if (r115 == null) goto L46;
            String r119 = r115.get("text_bg_color");
            if (r119 == null) goto L46;
            int r120 = s.f45717a;
            r106 = Integer.valueOf(s.a(r119, r106.intValue()));
        L46:
            Integer r121 = r106;
        L49:
            return new a(null, (String) CollectionsKt.getOrNull(r100, 0), r109, r118, ECRitTag.class, null, null, r121, null, null, r111, r110, 864);
        L41:
            r118 = r113;
            goto L42
        L47:
            r121 = r106;
            r118 = r113;
            goto L49
        L28:
            if (r114.isEmpty() == true) goto L31;
            r102 = false;
        L24:
            r109 = r112;
            goto L25
        L52:
            return null;
        L13:
            if (StringsKt.isBlank(r104) == true) goto L16;
            r105 = false;
            goto L17
        L50:
            return null;
        L5:
            if (r101.isEmpty() == true) goto L8;
            r103 = false;
            goto L9
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
        if (Intrinsics.areEqual(this.f573067a, r101.f573067a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f573068b, r101.f573068b) == true) goto L10;
        return false;
    L10:
        if (this.f573069c == r101.f573069c) goto L12;
        return false;
    L12:
        if (this.f573070d == r101.f573070d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f573071e, r101.f573071e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f573072f, r101.f573072f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f573073g, r101.f573073g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f573074h, r101.f573074h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f573075i, r101.f573075i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f573076j, r101.f573076j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f573077k, r101.f573077k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f573078l, r101.f573078l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f573067a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f573068b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f573069c) * 31) + this.f573070d) * 31;
        Class<? extends Object> r107 = this.f573071e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f573072f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f573073g;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f573074h;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f573075i;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        PromotionDiscountLabel r122 = this.f573076j;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f573077k;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        ECRitTag r128 = this.f573078l;
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
        return "WindowProductTagVO(prefix=" + this.f573067a + ", text=" + this.f573068b + ", textColor=" + this.f573069c + ", strokeColor=" + this.f573070d + ", type=" + this.f573071e + ", tagIcon=" + this.f573072f + ", headerBgColor=" + this.f573073g + ", backgroundColor=" + this.f573074h + ", lineType=" + this.f573075i + ", promotionDiscountLabel=" + this.f573076j + ", tagId=" + this.f573077k + ", ritTag=" + this.f573078l + ")";
    }

    static {
        f573066m = new C8479a();
    }

    public final Class<? extends Object> getType() {
        return this.f573071e;
    }

    public a(String r100, String r101, int r102, int r103, Class r104, String r105, String r106, Integer r110, Integer r111, PromotionDiscountLabel r112, String r113, ECRitTag r114, int r115) {
        if ((r115 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r115 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r115 & 32) == 0) goto L15;
        r105 = null;
    L15:
        if ((r115 & 64) == 0) goto L18;
        r106 = null;
    L18:
        if ((r115 & 128) == 0) goto L21;
        r110 = null;
    L21:
        if ((r115 & 256) == 0) goto L24;
        r111 = null;
    L24:
        if ((r115 & 512) == 0) goto L27;
        r112 = null;
    L27:
        if ((r115 & 1024) == 0) goto L30;
        r113 = null;
    L30:
        if ((r115 & 2048) == 0) goto L32;
        r114 = null;
    L32:
        this.f573067a = r100;
        this.f573068b = r101;
        this.f573069c = r102;
        this.f573070d = r103;
        this.f573071e = r104;
        this.f573072f = r105;
        this.f573073g = r106;
        this.f573074h = r110;
        this.f573075i = r111;
        this.f573076j = r112;
        this.f573077k = r113;
        this.f573078l = r114;
    }
}
