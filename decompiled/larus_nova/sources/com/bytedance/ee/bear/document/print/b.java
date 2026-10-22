package com.bytedance.ee.bear.document.print;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f221152a = 0;

    static {
    }

    public b() {
    }

    public static Map a(oj5.c r100, String r101) {
        String r102 = r100.H();
        if (r100.i() != 22) goto L5;
        int r103 = r100.i();
    L6:
        Pair[] r104 = new Pair[6];
        boolean r105 = false;
        r104[0] = TuplesKt.to("file_id", du5.b.g(r101));
        r104[1] = TuplesKt.to("file_type", sbb.e.c(r103));
        String r106 = r100.b();
        String r107 = "null";
        if (StringsKt.isBlank(r106) == false) goto L9;
        r106 = "null";
    L9:
        r104[2] = TuplesKt.to("sub_file_type", r106);
        String r108 = r100.L();
        if (r108 != null) goto L12;
        r108 = "null";
    L12:
        r104[3] = TuplesKt.to("user_permission", r108);
        r104[4] = TuplesKt.to("is_shortcut", String.valueOf(r100.E()));
        if (r102 != null) goto L15;
    L16:
        r105 = true;
    L17:
        if (r105 == true) goto L20;
        r107 = du5.b.g(r102);
    L20:
        r104[5] = TuplesKt.to("shortcut_id", r107);
        return MapsKt.mapOf(r104);
    L15:
        if (StringsKt.isBlank(r102) == false) goto L17;
    L5:
        r103 = r100.getType();
        goto L6
    }

    public static void c(String r100, oj5.c r101, String r102) {
        b("ccm_space_print_click", r101, r102, MapsKt.mapOf(new Pair[]{TuplesKt.to("click", r100), TuplesKt.to(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view")}));
    }

    public static void b(String r100, oj5.c r101, String r102, Map r103) {
        com.bytedance.ee.bear.contract.d r104 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);     // Catch: Throwable -> L4
        HashMap r105 = new HashMap(r104.m("docCommonParams"));     // Catch: Throwable -> L4
        r105.putAll(a(r101, r102));     // Catch: Throwable -> L4
        r105.putAll(r103);     // Catch: Throwable -> L4
        r104.n(r100, r105);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        tt5.a.k("PrintAnalytic", "report " + r100 + " failed: " + th.getClass().getSimpleName());
    }
}
