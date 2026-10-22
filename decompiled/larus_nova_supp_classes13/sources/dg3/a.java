package dg3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int l = 0;
    public final Long a;
    public final Long b;
    public final String c;
    public final Long d;
    public final Long e;
    public final List<String> f;
    public final List<String> g;
    public final String h;
    public final String i;
    public final List<String> j;
    public final String k;

    /* JADX INFO: renamed from: dg3.a$a, reason: collision with other inner class name */
    public static final class C0190a {
        public static a a(HashMap r13) {
            Object r0 = null;
            if (r13 == null) goto L5;
            Object r1 = r13.get("order_id");
        L7:
            if ((r1 instanceof String) == true) goto L9;
            r1 = null;
        L9:
            String r2 = (String) r1;
            if (r2 == null) goto L12;
            Long r3 = Long.valueOf(CastLongProtector.parseLong(r2));
        L13:
            if (r13 == null) goto L15;
            Object r4 = r13.get(PdpOpenThirdParam.KEY_PRODUCT_ID);
        L17:
            if ((r4 instanceof String) == true) goto L19;
            r4 = null;
        L19:
            String r5 = (String) r4;
            if (r5 == null) goto L22;
            Long r6 = Long.valueOf(CastLongProtector.parseLong(r5));
        L23:
            if (r13 == null) goto L25;
            Object r7 = r13.get("content");
        L27:
            if ((r7 instanceof String) == true) goto L29;
            r7 = null;
        L29:
            String r8 = (String) r7;
            if (r13 == null) goto L32;
            Object r9 = r13.get("content_count");
        L34:
            if ((r9 instanceof Integer) == true) goto L36;
            r9 = null;
        L36:
            Integer r10 = (Integer) r9;
            if (r10 == null) goto L39;
            Long r11 = Long.valueOf(r10.intValue());
        L40:
            if (r13 == null) goto L42;
            Object r12 = r13.get("rank_good");
        L44:
            if ((r12 instanceof Integer) == true) goto L46;
            r12 = null;
        L46:
            Integer r14 = (Integer) r12;
            if (r14 == null) goto L49;
            Long r15 = Long.valueOf(r14.intValue());
        L50:
            if (r13 == null) goto L52;
            Object r16 = r13.get("photos");
        L54:
            if ((r16 instanceof List) == true) goto L56;
            r16 = null;
        L56:
            List r17 = (List) r16;
            if (r13 == null) goto L59;
            Object r18 = r13.get("videos");
        L61:
            if ((r18 instanceof List) == true) goto L63;
            r18 = null;
        L63:
            List r19 = (List) r18;
            if (r13 == null) goto L66;
            Object r20 = r13.get("product_price");
        L68:
            if ((r20 instanceof String) == true) goto L70;
            r20 = null;
        L70:
            String r21 = (String) r20;
            if (r13 == null) goto L73;
            Object r22 = r13.get("product_sales");
        L75:
            if ((r22 instanceof String) == true) goto L77;
            r22 = null;
        L77:
            String r23 = (String) r22;
            if (r13 == null) goto L80;
            Object r110 = r13.get("product_images");
        L82:
            if ((r110 instanceof List) == true) goto L84;
            r110 = null;
        L84:
            List r111 = (List) r110;
            if (r13 == null) goto L87;
            Object r112 = r13.get("product_title");
        L89:
            if ((r112 instanceof String) == false) goto L93;
            r0 = r112;
        L93:
            return new a(r3, r6, r8, r11, r15, r17, r19, r21, r23, r111, (String) r0);
        L87:
            r112 = null;
            goto L89
        L80:
            r110 = null;
            goto L82
        L73:
            r22 = null;
            goto L75
        L66:
            r20 = null;
            goto L68
        L59:
            r18 = null;
            goto L61
        L52:
            r16 = null;
            goto L54
        L49:
            r15 = null;
            goto L50
        L42:
            r12 = null;
            goto L44
        L39:
            r11 = null;
            goto L40
        L32:
            r9 = null;
            goto L34
        L25:
            r7 = null;
            goto L27
        L22:
            r6 = null;
            goto L23
        L15:
            r4 = null;
            goto L17
        L12:
            r3 = null;
            goto L13
        L5:
            r1 = null;
            goto L7
        }
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L28;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        List<String> r28 = this.j;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 == null) goto L46;
        r1 = r31.hashCode();
    L46:
        return r30 + r1;
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentStruct(orderId=" + this.a + ", productId=" + this.b + ", content=" + this.c + ", contentCount=" + this.d + ", rankGood=" + this.e + ", photos=" + this.f + ", videos=" + this.g + ", price=" + this.h + ", sales=" + this.i + ", imageUrls=" + this.j + ", productTitle=" + this.k + ")";
    }

    public a(Long r1, Long r2, String r3, Long r4, Long r5, List<String> r6, List<String> r7, String r8, String r9, List<String> r10, String r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
