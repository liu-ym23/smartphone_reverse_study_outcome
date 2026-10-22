package qm5;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemEnum;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f533873b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BearUrl f533874a;

    /* JADX INFO: renamed from: qm5.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C7358a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f533875a = null;

        static {
            int[] r100 = new int[ToolbarItemEnum.values().length];
            f533875a = r100;
            r100[ToolbarItemEnum.text.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f533875a[ToolbarItemEnum.number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f533875a[ToolbarItemEnum.date.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public a() {
    }

    public final Map<String, String> a(String r100) {
        HashMap r101 = new HashMap();
        r101.put("action", r100);
        BearUrl r102 = this.f533874a;
        String r103 = "ERR";
        if (r102 != null) goto L6;
    L7:
        String r104 = "ERR";
    L9:
        r101.put("file_id", r104);
        r101.put("file_type", sbb.e.f541297h.getType());
        BearUrl r105 = this.f533874a;
        if (r105 != null) goto L13;
    L16:
        r101.put(EventConstant.Key.MODULE, r103);
        r101.put("eventType", "click");
        return r101;
    L13:
        if (TextUtils.isEmpty(r105.f222560a) == true) goto L16;
        r103 = r105.f222560a;
        goto L16
    L6:
        if (TextUtils.isEmpty(r102.f222561b) == true) goto L7;
        r104 = du5.b.g(r102.f222561b);
        goto L9
    }

    public final void b(String r100) {
        Map<String, String> r101 = a(r100);
        tt5.a.b("SheetAnalytic", "report: params = " + r101);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("sheet_opration", r101);
    }

    public final void d(String r100) {
        Map<String, String> r101 = a(r100);
        ((HashMap) r101).put("source", "sheet_toolbar");
        tt5.a.b("SheetAnalytic", "report: params = " + r101);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("sheet_opration", r101);
    }

    public final void f(String r100) {
        HashMap r101 = new HashMap();
        r101.put("source", r100);
        c("export_image_fail", r101);
    }

    public final void i(ToolbarItemEnum r100) {
        int r101 = C7358a.f533875a[r100.ordinal()];
        if (r101 != 1) goto L5;
        b("switch_text_tab");
        return;
    L5:
        if (r101 != 2) goto L7;
        b("switch_number_tab");
        return;
    L7:
        if (r101 != 3) goto L15;
        b("switch_date_tab");
        return;
    }

    public final void c(String r100, Map<String, String> r101) {
        Map<String, String> r102 = a(r100);
        ((HashMap) r102).putAll(r101);
        tt5.a.b("SheetAnalytic", "report: params = " + r102);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("sheet_opration", r102);
    }

    public final void e(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("source", r100);
        r102.put("fab_type", null);
        r102.put("op_item", r101);
        c("click_share_export_image", r102);
    }

    public final void g(String r100, boolean r101) {
        Map<String, String> r102 = a("input");
        HashMap r103 = (HashMap) r102;
        r103.put("keyboard_type", r100);
        if (f533873b == false) goto L5;
        String r104 = "card_view";
    L8:
        r103.put("mode", r104);
        tt5.a.b("SheetAnalytic", "report: params = " + r102);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("edit_cell_content", r102);
        return;
    L5:
        if (r101 == false) goto L7;
        r104 = "cell_expand";
        goto L8
    L7:
        r104 = "default";
        goto L8
    }

    public final void h(boolean r100, boolean r101) {
        HashMap r102 = new HashMap();
        if (r101 == false) goto L5;
        String r103 = ObricActionBarTrackType.KEY_BOARD;
    L6:
        r102.put("source", r103);
        if (f533873b == false) goto L9;
        String r104 = "card_view";
    L12:
        r102.put("mode", r104);
        c("line_feed", r102);
        return;
    L9:
        if (r100 == false) goto L11;
        r104 = "cell_expand";
        goto L12
    L11:
        r104 = "default";
        goto L12
    L5:
        r103 = "sheet_toolbar";
        goto L6
    }
}
