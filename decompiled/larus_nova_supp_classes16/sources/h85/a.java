package h85;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements com.bytedance.ee.bear.f {
    public a() {
    }

    public final void a(BaseOpenEntity r4) {
        com.bytedance.ee.bear.drive.report.c r0 = o75.b.a().Ke();
        String r1 = r4.getMountPoint();
        HashMap<String, Object> r5 = r0.g(r4);
        r5.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r1);
        r5.put("click", "download");
        r5.put("target", "none");
        r0.A("ccm_drive_download_begin_click", r5);
    }

    public final String c(int r2) {
        if (sbb.e.g.b != r2) goto L7;
        return "doc_image";
    L7:
        if (sbb.e.o.b != r2) goto L11;
        return "docx_image";
    L11:
        if (sbb.e.h.b != r2) goto L15;
        return "sheet_image";
    L15:
        if (sbb.e.k.b != r2) goto L19;
        return "mindnote_image";
    L19:
        if (sbb.e.n.b != r2) goto L22;
        return "wiki_cover";
    L22:
        return "";
    }

    public final String d(String r3) {
        if (r3 != null) goto L6;
        return "";
    L6:
        if (sbb.e.g.getType().equals(r3) == false) goto L10;
        return "doc_image";
    L10:
        if (sbb.e.o.getType().equals(r3) == false) goto L14;
        return "docx_image";
    L14:
        if (sbb.e.h.getType().equals(r3) == false) goto L18;
        return "sheet_image";
    L18:
        if (sbb.e.k.getType().equals(r3) == false) goto L22;
        return "mindnote_image";
    L22:
        if (sbb.e.n.getType().equals(r3) == false) goto L25;
        return "wiki_cover";
    L25:
        return "";
    }

    public final void e(String r6, String r7) {
        JSONObject r2 = new JSONObject();
    L12:
        e = move-exception;
        tt5.a.d("DriveReport", "reportDownloadFinish()...error = " + e);
        return;
    L4:
        if (TextUtils.isEmpty(r6) == false) goto L6;
        String r8 = "none";
    L7:
        r2.put("file_id", r8);     // Catch: JSONException -> L12
        r2.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r7);     // Catch: JSONException -> L12
        com.bytedance.ee.bear.contract.d r9 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);     // Catch: JSONException -> L12
        if (r9 == null) goto L10;
        r9.i("ccm_drive_download_finish_view", r2);     // Catch: JSONException -> L12
    L10:
        tt5.a.b("DriveReport", "report ccm_drive_download_finish_view, params: " + r2.toString());     // Catch: JSONException -> L12
        return;
    L6:
        r8 = du5.b.g(r6);     // Catch: JSONException -> L12
        goto L7
    }

    public final void b(String r6, String r7, boolean r8, Integer r9) {
        JSONObject r2 = new JSONObject();
    L12:
        e = move-exception;
        tt5.a.d("DriveReport", "reportUploadFinish()...error = " + e);
        return;
    L4:
        if (TextUtils.isEmpty(r6) == false) goto L6;
        String r10 = "none";
    L7:
        r2.put("file_id", r10);     // Catch: JSONException -> L12
        r2.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r7);     // Catch: JSONException -> L12
        r2.put("is_successful", String.valueOf(r8));     // Catch: JSONException -> L12
        r2.put("file_num", r9);     // Catch: JSONException -> L12
        com.bytedance.ee.bear.contract.d r11 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);     // Catch: JSONException -> L12
        if (r11 == null) goto L10;
        r11.i("ccm_drive_upload_finish_view", r2);     // Catch: JSONException -> L12
    L10:
        tt5.a.b("DriveReport", "report ccm_drive_upload_finish_view, params: " + r2.toString());     // Catch: JSONException -> L12
        return;
    L6:
        r10 = du5.b.g(r6);     // Catch: JSONException -> L12
        goto L7
    }

    public final void f(String r8, String r9, String r10, String r11) {
        JSONObject r3 = new JSONObject();
    L27:
        e = move-exception;
        tt5.a.d("DriveReport", "reportFileChooseClick()...error = " + e);
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L9;
        r3.put("module", r8);     // Catch: JSONException -> L27
        lc5.f.a r5 = lc5.f.a;     // Catch: JSONException -> L27
        String r12 = lc5.f.a.i(r8);     // Catch: JSONException -> L27
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r3.put("target", r12);     // Catch: JSONException -> L27
    L11:
        if (TextUtils.isEmpty(r9) == false) goto L14;
        r9 = "none";
    L14:
        r3.put("sub_module", r9);     // Catch: JSONException -> L27
        r3.put("file_id", "none");     // Catch: JSONException -> L27
        sbb.e r13 = sbb.e.l;     // Catch: JSONException -> L27
        r3.put("file_type", r13.getType());     // Catch: JSONException -> L27
        r3.put("sub_file_type", "none");     // Catch: JSONException -> L27
        boolean r14 = TextUtils.isEmpty(r10);     // Catch: JSONException -> L27
        if (r14 == true) goto L17;
        String r16 = du5.b.e(r10);     // Catch: JSONException -> L27
    L18:
        r3.put("container_id", r16);     // Catch: JSONException -> L27
        if (r14 == true) goto L21;
        String r17 = sbb.e.f.getType();     // Catch: JSONException -> L27
    L22:
        r3.put("container_type", r17);     // Catch: JSONException -> L27
        r3.put("app_form", "none");     // Catch: JSONException -> L27
        r3.put("click", r11);     // Catch: JSONException -> L27
        r3.put("choose_type", r13.getType());     // Catch: JSONException -> L27
        r3.put("add_mode", "click_upload");     // Catch: JSONException -> L27
        r3.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, FileInfoPuller.CALLER_EXPLORER);     // Catch: JSONException -> L27
        com.bytedance.ee.bear.contract.d r18 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);     // Catch: JSONException -> L27
        if (r18 == null) goto L25;
        r18.i("ccm_space_file_choose_click", r3);     // Catch: JSONException -> L27
    L25:
        tt5.a.b("DriveReport", "report ccm_space_file_choose_click, params: " + r3.toString());     // Catch: JSONException -> L27
        return;
    L21:
        r17 = "none";
        goto L22
    L17:
        r16 = "none";
        goto L18
    L9:
        r3.put("module", "none");     // Catch: JSONException -> L27
        goto L11
    }
}
