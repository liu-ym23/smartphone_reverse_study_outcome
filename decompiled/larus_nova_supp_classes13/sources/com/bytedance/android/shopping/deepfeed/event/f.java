package com.bytedance.android.shopping.deepfeed.event;

import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import he3.e1;
import he3.k0;
import he3.m0;
import he3.n0;
import he3.p0;
import he3.z0;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(InFeedProductV2 r9) {
        String r0 = b(r9);
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        String r4 = null;
        if (r3 == false) goto L12;
        return null;
    L12:
        String[] r5 = new String[3];
        r5[0] = r0;
        if (r9 == null) goto L16;
        String r1 = r9.getCardType();
        if (r1 == null) goto L16;
    L19:
        if (r1 != null) goto L23;
        if (r9 == null) goto L22;
        r1 = r9.getCardSubtype();
        goto L23
    L22:
        r1 = null;
    L23:
        String r2 = "";
        if (r1 != null) goto L26;
        r1 = "";
    L26:
        r5[1] = r1;
        if (r9 == null) goto L31;
        z0 r10 = r9.getRespExtra();
        if (r10 == null) goto L31;
        r4 = r10.c();
    L31:
        if (r4 == null) goto L34;
        r2 = r4;
    L34:
        r5[2] = r2;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r5), "_", null, null, 0, null, null, 62, null);
    L16:
        if (r9 == null) goto L18;
        r1 = r9.getCardName();
        goto L19
    L18:
        r1 = null;
        goto L19
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public static String b(InFeedProductV2 r2) {
        if (r2 == null) goto L8;
        e1 r1 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r2);
        if (r1 == null) goto L8;
        String r3 = r1.a();
        if (r3 == null) goto L8;
    L21:
        if (r3 != null) goto L35;
        if (r2 == null) goto L36;
        InFeedProductPackData r4 = r2.getPackData();
        if (r4 == null) goto L37;
        InFeedProductPackDataElements r5 = r4.getElements();
        if (r5 == null) goto L38;
        n0 r6 = r5.getSliceCard();
        if (r6 == null) goto L39;
        k0 r7 = r6.e();
        if (r7 == null) goto L40;
        e1 r8 = r7.b();
        if (r8 != null) goto L42;
        return null;
    L42:
        return r8.a();
    L40:
        return null;
    L39:
        return null;
    L38:
        return null;
    L37:
        return null;
    L36:
        return null;
    L35:
        return r3;
    L8:
        if (r2 == null) goto L20;
        InFeedProductPackData r9 = r2.getPackData();
        if (r9 == null) goto L20;
        InFeedProductPackDataElements r10 = r9.getElements();
        if (r10 == null) goto L20;
        List<p0> r11 = r10.getProducts();
        if (r11 == null) goto L20;
        p0 r12 = (p0) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L20;
        e1 r13 = r12.b();
        if (r13 == null) goto L20;
        r3 = r13.a();
    L20:
        r3 = null;
        goto L21
    }

    public static int c(InFeedProductV2 r2, String r3) {
        Object r0 = null;
        if (r2 == null) goto L10;
        n0 r1 = r2.slcCard();
        if (r1 == null) goto L10;
        Map<String, ? extends Object> r4 = r1.b;
        if (r4 == null) goto L10;
        Object r5 = r4.get(r3);
        if (r5 == null) goto L10;
    L19:
        if (r5 != null) goto L29;
        if (r2 == null) goto L28;
        n0 r6 = r2.slcCard();
        if (r6 == null) goto L28;
        m0 r7 = r6.g();
        if (r7 == null) goto L28;
        Map<String, Object> r8 = r7.b();
        if (r8 == null) goto L28;
        r5 = r8.get(r3);
    L28:
        r5 = null;
    L29:
        if (r5 != null) goto L42;
        if (r2 == null) goto L41;
        Intrinsics.checkNotNullParameter(r2, "$this$product");
        InFeedProductPackDataElements r9 = com.bytedance.android.shopping.deepfeed.utlis.a.d(r2);
        if (r9 == null) goto L36;
        List<p0> r10 = r9.getProducts();
        if (r10 == null) goto L36;
        p0 r11 = (p0) CollectionsKt.firstOrNull(r10);
    L37:
        if (r11 == null) goto L41;
        Map<String, Object> r12 = r11.a();
        if (r12 == null) goto L41;
        r5 = r12.get(r3);
    L36:
        r11 = null;
    L41:
        r5 = null;
    L42:
        if (r5 != null) goto L51;
        if (r2 == null) goto L53;
        InFeedProductPackData r13 = r2.getPackData();
        if (r13 == null) goto L53;
        InFeedProductPackDataElements r14 = r13.getElements();
        if (r14 == null) goto L53;
        Map<String, Object> r15 = com.bytedance.android.shopping.deepfeed.utlis.a.l(r14);
        if (r15 == null) goto L53;
        r0 = r15.get(r3);
    L53:
        if ((r0 instanceof Number) == false) goto L58;
        if (((Number) r0).intValue() != 0) goto L71;
    L69:
        return 0;
    L71:
        return 1;
    L58:
        if ((r0 instanceof Boolean) == false) goto L63;
        if (((Boolean) r0).booleanValue() == false) goto L69;
        return 1;
    L63:
        if ((r0 instanceof String) == false) goto L69;
        if (Intrinsics.areEqual(r0, "1") == false) goto L67;
        return 1;
    L67:
        if (StringsKt.equals((String) r0, "true", true) == false) goto L69;
        return 1;
    L51:
        r0 = r5;
    L10:
        if (r2 == null) goto L18;
        n0 r16 = r2.slcCard();
        if (r16 == null) goto L18;
        m0 r17 = r16.g();
        if (r17 == null) goto L18;
        Map<String, Object> r18 = r17.c();
        if (r18 == null) goto L18;
        r5 = r18.get(r3);
    L18:
        r5 = null;
        goto L19
    }

    public static String d(List r0, List r1, String r2, boolean r3) {
        if (r3 == false) goto L4;
    L26:
        return "live";
    L4:
        if (k.c(r2) == true) goto L26;
        List r4 = r0;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        return "video";
    L15:
        if (r1 == null) goto L19;
        InFeedUrlModel r6 = (InFeedUrlModel) CollectionsKt.firstOrNull(r1);
        if (r6 == null) goto L19;
        Integer r7 = r6.getUrlType();
    L20:
        if (r7 != null) goto L23;
    L25:
        return "11_pic";
    L23:
        if (r7.intValue() != 2) goto L25;
        return "34_long_pic";
    L19:
        r7 = null;
        goto L20
    L9:
        if (r4.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    }
}
