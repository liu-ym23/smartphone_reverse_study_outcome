package h15;

import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import du5.b;
import oj5.c;
import org.json.JSONException;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final d a;

    public a() {
        this.a = (d) org.koin.java.a.a(d.class);
    }

    public final void a(c r9, boolean r10, String r11, String r12) {
        JSONObject r1 = new JSONObject();
        String r2 = "100";
        if ("success".equals(r12) == false) goto L6;
        r2 = DiagramData$RESULT.FAIL;
    L6:
        String r3 = e.d(r9.getType()).getType();     // Catch: JSONException -> L24
        r1.put("file_id", b.g(r9.getToken()));     // Catch: JSONException -> L24
        r1.put("file_type", r3);     // Catch: JSONException -> L24
        String r6 = "true";
        if (r9.isOwner() == false) goto L10;
        Object r5 = "true";
    L11:
        r1.put("is_owner", r5);     // Catch: JSONException -> L24
        if (r10 == false) goto L14;
        r3 = "space";
    L14:
        r1.put("module", r3);     // Catch: JSONException -> L24
        if (r10 == false) goto L17;
        String r13 = "context_menu";
    L18:
        r1.put("source", r13);     // Catch: JSONException -> L24
        if (r9.n() == true) goto L22;
        r6 = "false";
    L22:
        r1.put("is_editor", r6);     // Catch: JSONException -> L24
        r1.put("export_file_type", r11);     // Catch: JSONException -> L24
        r1.put("export_file_amount", DiagramData$RESULT.SUCCESS);     // Catch: JSONException -> L24
        r1.put("status_code", r2);     // Catch: JSONException -> L24
        r1.put("status_name", r12);     // Catch: JSONException -> L24
    L26:
        tt5.a.b("ExportReporter", "reportExportClickResult, params = " + r1);
        this.a.a("click_export", r1);
        return;
    L17:
        r13 = "top_menu";
        goto L18
    L10:
        r5 = "false";
    L24:
        e = move-exception;
        tt5.a.e("ExportReporter", "create JSONObject fail", e, false);
        goto L26
    }
}
