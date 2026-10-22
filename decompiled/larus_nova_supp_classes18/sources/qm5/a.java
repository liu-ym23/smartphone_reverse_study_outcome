package qm5;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemEnum;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static boolean b;
    public BearUrl a;

    /* JADX INFO: renamed from: qm5.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0298a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToolbarItemEnum.values().length];
            a = r0;
            r0[ToolbarItemEnum.text.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[ToolbarItemEnum.number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[ToolbarItemEnum.date.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public a() {
    }

    public final Map<String, String> a(String r4) {
        HashMap r0 = new HashMap();
        r0.put("action", r4);
        BearUrl r5 = this.a;
        String r1 = "ERR";
        if (r5 != null) goto L6;
    L7:
        String r6 = "ERR";
    L9:
        r0.put("file_id", r6);
        r0.put("file_type", sbb.e.h.getType());
        BearUrl r7 = this.a;
        if (r7 != null) goto L13;
    L16:
        r0.put("module", r1);
        r0.put("eventType", "click");
        return r0;
    L13:
        if (TextUtils.isEmpty(r7.a) == true) goto L16;
        r1 = r7.a;
        goto L16
    L6:
        if (TextUtils.isEmpty(r5.b) == true) goto L7;
        r6 = du5.b.g(r5.b);
        goto L9
    }

    public final void b(String r3) {
        Map<String, String> r4 = a(r3);
        tt5.a.b("SheetAnalytic", "report: params = " + r4);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("sheet_opration", r4);
    }

    public final void d(String r4) {
        Map<String, String> r5 = a(r4);
        ((HashMap) r5).put("source", "sheet_toolbar");
        tt5.a.b("SheetAnalytic", "report: params = " + r5);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("sheet_opration", r5);
    }

    public final void f(String r3) {
        HashMap r0 = new HashMap();
        r0.put("source", r3);
        c("export_image_fail", r0);
    }

    public final void i(ToolbarItemEnum r2) {
        int r3 = C0298a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        b("switch_text_tab");
        return;
    L5:
        if (r3 != 2) goto L7;
        b("switch_number_tab");
        return;
    L7:
        if (r3 != 3) goto L15;
        b("switch_date_tab");
        return;
    }

    public final void c(String r2, Map<String, String> r3) {
        Map<String, String> r4 = a(r2);
        ((HashMap) r4).putAll(r3);
        tt5.a.b("SheetAnalytic", "report: params = " + r4);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("sheet_opration", r4);
    }

    public final void e(String r3, String r4) {
        HashMap r0 = new HashMap();
        r0.put("source", r3);
        r0.put("fab_type", null);
        r0.put("op_item", r4);
        c("click_share_export_image", r0);
    }

    public final void g(String r4, boolean r5) {
        Map<String, String> r0 = a("input");
        HashMap r1 = (HashMap) r0;
        r1.put("keyboard_type", r4);
        if (b == false) goto L5;
        String r6 = "card_view";
    L8:
        r1.put("mode", r6);
        tt5.a.b("SheetAnalytic", "report: params = " + r0);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("edit_cell_content", r0);
        return;
    L5:
        if (r5 == false) goto L7;
        r6 = "cell_expand";
        goto L8
    L7:
        r6 = "default";
        goto L8
    }

    public final void h(boolean r3, boolean r4) {
        HashMap r0 = new HashMap();
        if (r4 == false) goto L5;
        String r5 = "keyboard";
    L6:
        r0.put("source", r5);
        if (b == false) goto L9;
        String r6 = "card_view";
    L12:
        r0.put("mode", r6);
        c("line_feed", r0);
        return;
    L9:
        if (r3 == false) goto L11;
        r6 = "cell_expand";
        goto L12
    L11:
        r6 = "default";
        goto L12
    L5:
        r5 = "sheet_toolbar";
        goto L6
    }
}
