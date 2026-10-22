package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class p1 {
    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("service_name", "list_loader");     // Catch: JSONException -> L5
        r101.put("drive_scene", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("drive_get_service");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("LarkDriveEventHelper", "error in LarkDriveEventHelper mobDriveGetService " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("service_name", "list_loader");     // Catch: JSONException -> L7
        if (r100 == null) goto L9;
        r101.put("drive_scene", r100);     // Catch: JSONException -> L7
    L9:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("drive_get_service_failed");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("LarkDriveEventHelper", "error in LarkDriveEventHelper mobDriveGetServiceFailed " + e.getLocalizedMessage());
        goto L9
    }

    public static void c(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("current_page", "upload_file");     // Catch: JSONException -> L5
        r101.put("button_name", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("file_choose_page_button_click");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("LarkDriveEventHelper", "error in LarkDriveEventHelper mobFileChoosePageButtonClick " + e.getLocalizedMessage());
        goto L7
    }

    public static void d(String r100, String r101, Boolean r102, String r103, String r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L22;
    L7:
        if (r101 == null) goto L9;
        r105.put("collection_name", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 != null) goto L11;
    L15:
        r105.put("upload_type", r103);     // Catch: JSONException -> L5
        if (r104 == null) goto L20;
        r105.put("upload_file_sec_type", r104);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("LarkDriveEventHelper", "error in LarkDriveEventHelper mobUploadStatus " + e.getLocalizedMessage());
    L20:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("upload_status");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L11:
        if (r102.booleanValue() == false) goto L13;
        String r108 = "1";
    L14:
        r105.put("success", r108);     // Catch: JSONException -> L5
        goto L15
    L13:
        r108 = "0";
        goto L14
    L22:
        r105.put("collection_id", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
