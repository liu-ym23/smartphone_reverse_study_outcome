package p63;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrice;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.ImageTips;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.SingleSkuSpecInfo;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f527889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f527890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f527891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f527892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECUrlModel f527893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f527894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f527895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f527896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PromotionProductPrice f527897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f527898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f527899k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageTips f527900l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SingleSkuSpecInfo f527901m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f527902n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f527903o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Long f527904p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Long f527905q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L38;
        e r101 = (e) r100;
        if (this.f527890b == r101.f527890b) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527891c, r101.f527891c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f527892d, r101.f527892d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527893e, r101.f527893e) == true) goto L14;
        return false;
    L14:
        if (this.f527894f == r101.f527894f) goto L16;
        return false;
    L16:
        if (this.f527895g == r101.f527895g) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f527896h, r101.f527896h) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f527897i, r101.f527897i) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f527898j, r101.f527898j) == true) goto L24;
        return false;
    L24:
        if (this.f527899k == r101.f527899k) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f527900l, r101.f527900l) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f527901m, r101.f527901m) == true) goto L30;
        return false;
    L30:
        if (this.f527902n == r101.f527902n) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f527903o, r101.f527903o) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f527904p, r101.f527904p) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f527905q, r101.f527905q) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    public final int hashCode() {
        boolean r100 = this.f527890b;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f527891c;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f527892d;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        ECUrlModel r111 = this.f527893e;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f527894f;
        ?? r115 = r114;
        if (r114 == false) goto L20;
        r115 = 1;
    L20:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f527895g;
        ?? r118 = r117;
        if (r117 == false) goto L23;
        r118 = 1;
    L23:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f527896h;
        if (r120 == null) goto L26;
        int r121 = r120.hashCode();
    L27:
        int r122 = (r119 + r121) * 31;
        PromotionProductPrice r123 = this.f527897i;
        if (r123 == null) goto L30;
        int r124 = r123.hashCode();
    L31:
        int r125 = (r122 + r124) * 31;
        f r126 = this.f527898j;
        if (r126 == null) goto L34;
        int r127 = r126.hashCode();
    L35:
        int r128 = (r125 + r127) * 31;
        boolean r129 = this.f527899k;
        ?? r130 = r129;
        if (r129 == false) goto L38;
        r130 = 1;
    L38:
        int r131 = (r128 + r130) * 31;
        ImageTips r132 = this.f527900l;
        if (r132 == null) goto L41;
        int r133 = r132.hashCode();
    L42:
        int r134 = (r131 + r133) * 31;
        SingleSkuSpecInfo r135 = this.f527901m;
        if (r135 == null) goto L45;
        int r136 = r135.hashCode();
    L46:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.f527902n;
        if (r138 == true) goto L50;
        r101 = r138;
    L50:
        int r139 = (r137 + r101) * 31;
        String r140 = this.f527903o;
        if (r140 == null) goto L53;
        int r141 = r140.hashCode();
    L54:
        int r142 = (r139 + r141) * 31;
        Long r143 = this.f527904p;
        if (r143 == null) goto L57;
        int r144 = r143.hashCode();
    L58:
        int r145 = (r142 + r144) * 31;
        Long r146 = this.f527905q;
        if (r146 == null) goto L62;
        r105 = r146.hashCode();
    L62:
        return r145 + r105;
    L57:
        r144 = 0;
        goto L58
    L53:
        r141 = 0;
        goto L54
    L45:
        r136 = 0;
        goto L46
    L41:
        r133 = 0;
        goto L42
    L34:
        r127 = 0;
        goto L35
    L30:
        r124 = 0;
        goto L31
    L26:
        r121 = 0;
        goto L27
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 1;
    }

    public final String toString() {
        return "SingleProductSkuVO(firstBind=" + this.f527890b + ", productId=" + this.f527891c + ", promotionId=" + this.f527892d + ", picture=" + this.f527893e + ", needCheck=" + this.f527894f + ", isChecked=" + this.f527895g + ", productTitle=" + this.f527896h + ", price=" + this.f527897i + ", selectedSkuInfo=" + this.f527898j + ", onSale=" + this.f527899k + ", tips=" + this.f527900l + ", singleSpecInfo=" + this.f527901m + ", needEmphasize=" + this.f527902n + ", schema=" + this.f527903o + ", channelId=" + this.f527904p + ", channelType=" + this.f527905q + ")";
    }

    public static e b(e r210, boolean r211, f r212, boolean r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        boolean r100 = r210.f527890b;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r210.f527891c;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r210.f527892d;
    L15:
        if ((r214 & 8) == 0) goto L17;
        ECUrlModel r103 = r210.f527893e;
    L19:
        if ((r214 & 16) == 0) goto L21;
        boolean r104 = r210.f527894f;
    L23:
        if ((r214 & 32) == 0) goto L25;
        boolean r110 = r210.f527895g;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r111 = r210.f527896h;
    L31:
        if ((r214 & 128) == 0) goto L33;
        PromotionProductPrice r112 = r210.f527897i;
    L35:
        if ((r214 & 256) == 0) goto L37;
        f r113 = r210.f527898j;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r114 = r210.f527899k;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        ImageTips r115 = r210.f527900l;
    L47:
        if ((r214 & 2048) == 0) goto L49;
        SingleSkuSpecInfo r116 = r210.f527901m;
    L51:
        if ((r214 & 4096) == 0) goto L53;
        boolean r117 = r210.f527902n;
    L55:
        if ((r214 & 8192) == 0) goto L57;
        String r118 = r210.f527903o;
    L59:
        if ((r214 & 16384) == 0) goto L61;
        Long r119 = r210.f527904p;
    L63:
        if ((r214 & 32768) == 0) goto L65;
        Long r215 = r210.f527905q;
    L66:
        r210.getClass();
        return new e(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r215);
    L65:
        r215 = null;
        goto L66
    L61:
        r119 = null;
        goto L63
    L57:
        r118 = null;
        goto L59
    L53:
        r117 = r213;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = false;
        goto L43
    L37:
        r113 = r212;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = r211;
        goto L27
    L21:
        r104 = false;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public e(boolean r100, String r101, String r102, ECUrlModel r103, boolean r104, boolean r105, String r106, PromotionProductPrice r110, f r111, boolean r112, ImageTips r113, SingleSkuSpecInfo r114, boolean r115, String r116, Long r117, Long r118) {
        this.f527890b = r100;
        this.f527891c = r101;
        this.f527892d = r102;
        this.f527893e = r103;
        this.f527894f = r104;
        this.f527895g = r105;
        this.f527896h = r106;
        this.f527897i = r110;
        this.f527898j = r111;
        this.f527899k = r112;
        this.f527900l = r113;
        this.f527901m = r114;
        this.f527902n = r115;
        this.f527903o = r116;
        this.f527904p = r117;
        this.f527905q = r118;
    }
}
