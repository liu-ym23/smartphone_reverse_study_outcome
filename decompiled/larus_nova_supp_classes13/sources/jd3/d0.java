package jd3;

import com.bytedance.android.shopping.anchorv4.schemav2.PdpSchemaProcessor;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d0 extends c {
    public Integer a;
    public String b;
    public PdpSchemaProcessor c;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        Integer r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = String.valueOf(r0.intValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r3 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("statusCode", r2, r3);
        appendParam("statusMsg", this.b, r3);
        appendParam("shop_id", null, r3);
        PdpSchemaProcessor r4 = this.c;
        if (r4 == null) goto L11;
        com.bytedance.android.shopping.anchorv4.schemav2.d r5 = r4.g();
        if (r5 == null) goto L11;
        String r6 = r5.d;
    L12:
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, r6, r3);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail", r3);
        PdpSchemaProcessor r7 = this.c;
        if (r7 != null) goto L15;
    L17:
        String r8 = "video";
    L18:
        appendParam("ecom_group_type", r8, r3);
        PdpSchemaProcessor r9 = this.c;
        if (r9 == null) goto L23;
        com.bytedance.android.shopping.anchorv4.schemav2.c r10 = r9.f();
        if (r10 == null) goto L23;
        String r11 = r10.d;
    L24:
        appendParam("group_id", r11, r3);
        PdpSchemaProcessor r12 = this.c;
        if (r12 == null) goto L29;
        com.bytedance.android.shopping.anchorv4.schemav2.c r13 = r12.f();
        if (r13 == null) goto L29;
        String r14 = r13.e;
    L30:
        appendParam("author_id", r14, r3);
        PdpSchemaProcessor r15 = this.c;
        if (r15 == null) goto L35;
        com.bytedance.android.shopping.anchorv4.schemav2.l r16 = r15.m();
        if (r16 == null) goto L35;
        String r17 = r16.d;
    L36:
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, r17, r3);
        PdpSchemaProcessor r18 = this.c;
        if (r18 == null) goto L43;
        com.bytedance.android.shopping.anchorv4.schemav2.p r19 = r18.o();
        if (r19 == null) goto L43;
        Integer r20 = r19.d;
        if (r20 == null) goto L43;
        String r21 = String.valueOf(r20.intValue());
    L44:
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, r21, r3);
        PdpSchemaProcessor r22 = this.c;
        if (r22 == null) goto L49;
        com.bytedance.android.shopping.anchorv4.schemav2.c r23 = r22.f();
        if (r23 == null) goto L49;
        String r24 = r23.f;
    L50:
        appendParam("room_id", r24, r3);
        PdpSchemaProcessor r25 = this.c;
        if (r25 == null) goto L55;
        com.bytedance.android.shopping.anchorv4.schemav2.e r26 = r25.h();
        if (r26 == null) goto L55;
        Boolean r27 = r26.d;
    L57:
        if (Intrinsics.areEqual(r27, Boolean.TRUE) == false) goto L59;
        String r28 = "full_screen";
    L60:
        appendParam("page_type", r28, r3);
        PdpSchemaProcessor r29 = this.c;
        if (r29 == null) goto L67;
        com.bytedance.android.shopping.anchorv4.schemav2.f r30 = r29.i();
        if (r30 == null) goto L67;
        if (r30.f != true) goto L67;
        String r31 = String.valueOf(1);
    L68:
        appendParam("is_ad", r31, r3);
        PdpSchemaProcessor r32 = this.c;
        if (r32 == null) goto L73;
        com.bytedance.android.shopping.anchorv4.schemav2.i r33 = r32.k();
        if (r33 == null) goto L73;
        JSONObject r34 = r33.c;
    L74:
        a(r34);
        PdpSchemaProcessor r35 = this.c;
        if (r35 == null) goto L79;
        com.bytedance.android.shopping.anchorv4.schemav2.d r36 = r35.g();
        if (r36 == null) goto L79;
        r1 = r36.n;
    L79:
        appendParam("ecom_entrance_form", r1, r3);
        return;
    L73:
        r34 = null;
    L67:
        r31 = String.valueOf(0);
        goto L68
    L59:
        r28 = "half_screen";
    L55:
        r27 = null;
    L49:
        r24 = null;
    L43:
        r21 = null;
    L35:
        r17 = null;
    L29:
        r14 = null;
    L23:
        r11 = null;
        goto L24
    L15:
        if (r7.p() != true) goto L17;
        r8 = "live";
    L11:
        r6 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public d0() {
    }
}
