package com.bytedance.ee.bear.document.print;

import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public b() {
    }

    public static Map a(oj5.c r6, String r7) {
        String r0 = r6.H();
        if (r6.i() != 22) goto L5;
        int r1 = r6.i();
    L6:
        Pair[] r2 = new Pair[6];
        boolean r3 = false;
        r2[0] = TuplesKt.to("file_id", du5.b.g(r7));
        r2[1] = TuplesKt.to("file_type", sbb.e.c(r1));
        String r8 = r6.b();
        String r5 = "null";
        if (StringsKt.isBlank(r8) == false) goto L9;
        r8 = "null";
    L9:
        r2[2] = TuplesKt.to("sub_file_type", r8);
        String r9 = r6.L();
        if (r9 != null) goto L12;
        r9 = "null";
    L12:
        r2[3] = TuplesKt.to("user_permission", r9);
        r2[4] = TuplesKt.to("is_shortcut", String.valueOf(r6.E()));
        if (r0 != null) goto L15;
    L16:
        r3 = true;
    L17:
        if (r3 == true) goto L20;
        r5 = du5.b.g(r0);
    L20:
        r2[5] = TuplesKt.to("shortcut_id", r5);
        return MapsKt.mapOf(r2);
    L15:
        if (StringsKt.isBlank(r0) == false) goto L17;
    L5:
        r1 = r6.getType();
        goto L6
    }

    public static void c(String r2, oj5.c r3, String r4) {
        b("ccm_space_print_click", r3, r4, MapsKt.mapOf(new Pair[]{TuplesKt.to("click", r2), TuplesKt.to("target", "ccm_docs_page_view")}));
    }

    public static void b(String r3, oj5.c r4, String r5, Map r6) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);     // Catch: Throwable -> L4
        HashMap r1 = new HashMap(r0.m("docCommonParams"));     // Catch: Throwable -> L4
        r1.putAll(a(r4, r5));     // Catch: Throwable -> L4
        r1.putAll(r6);     // Catch: Throwable -> L4
        r0.n(r3, r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        tt5.a.k("PrintAnalytic", "report " + r3 + " failed: " + th.getClass().getSimpleName());
    }
}
