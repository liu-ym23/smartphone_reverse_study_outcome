package h15;

import com.bytedance.ee.bear.contract.d;
import com.ss.android.cert.manager.constants.EventConstant;
import du5.b;
import oj5.c;
import org.json.JSONException;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f483521a;

    public a() {
        this.f483521a = (d) org.koin.java.a.a(d.class);
    }

    public final void a(c r100, boolean r110, String r111, String r112) {
        JSONObject r101 = new JSONObject();
        String r102 = "100";
        if ("success".equals(r112) == false) goto L6;
        r102 = "0";
    L6:
        String r103 = e.d(r100.getType()).getType();     // Catch: JSONException -> L24
        r101.put("file_id", b.g(r100.getToken()));     // Catch: JSONException -> L24
        r101.put("file_type", r103);     // Catch: JSONException -> L24
        String r104 = "true";
        if (r100.isOwner() == false) goto L10;
        Object r105 = "true";
    L11:
        r101.put("is_owner", r105);     // Catch: JSONException -> L24
        if (r110 == false) goto L14;
        r103 = "space";
    L14:
        r101.put(EventConstant.Key.MODULE, r103);     // Catch: JSONException -> L24
        if (r110 == false) goto L17;
        String r113 = "context_menu";
    L18:
        r101.put("source", r113);     // Catch: JSONException -> L24
        if (r100.n() == true) goto L22;
        r104 = "false";
    L22:
        r101.put("is_editor", r104);     // Catch: JSONException -> L24
        r101.put("export_file_type", r111);     // Catch: JSONException -> L24
        r101.put("export_file_amount", "1");     // Catch: JSONException -> L24
        r101.put("status_code", r102);     // Catch: JSONException -> L24
        r101.put("status_name", r112);     // Catch: JSONException -> L24
    L26:
        tt5.a.b("ExportReporter", "reportExportClickResult, params = " + r101);
        this.f483521a.a("click_export", r101);
        return;
    L17:
        r113 = "top_menu";
        goto L18
    L10:
        r105 = "false";
    L24:
        e = move-exception;
        tt5.a.e("ExportReporter", "create JSONObject fail", e, false);
        goto L26
    }
}
