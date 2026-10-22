package yk7;

import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568235a = 0;

    static {
    }

    public static void a(ILuckyDogCommonSettingsService.Channel r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("channel", r100);
        r103.put("error_code", r101);
        r103.put("fail_reason", r102);
        com.bytedance.ug.sdk.luckydog.api.log.e.a("lucky_dog_common_settings_fail_reason", r103, null);
    }

    public static void b(ILuckyDogCommonSettingsService.Channel r100, boolean r101, int r102, int r103, int r104, int r110, String r111) {
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L18
        int r106 = a.f568234a[r100.ordinal()];     // Catch: Throwable -> L18
        int r107 = 0;
        if (r106 == 1) goto L10;
        if (r106 != 2) goto L6;
        int r108 = 1;
    L11:
        if (r108 != 2) goto L13;
        return;
    L13:
        r105.put("channel", r108);     // Catch: Throwable -> L18
        if (r101 == false) goto L16;
        r107 = 1;
    L16:
        r105.put("success", r107);     // Catch: Throwable -> L18
        r105.put("scene", r102);     // Catch: Throwable -> L18
        r105.put("new_version", r103);     // Catch: Throwable -> L18
        r105.put("ttnet_code", r104);     // Catch: Throwable -> L18
        r105.put("http_code", r110);     // Catch: Throwable -> L18
        r105.put("error_msg", r111);     // Catch: Throwable -> L18
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_settings_update", r105);     // Catch: Throwable -> L18
        return;
    L6:
        if (r106 != 3) goto L10;
        r108 = 2;
    L10:
        r108 = 0;
    L18:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.c("CommonSettingsMonitorHelper", "monitorSettingsRequestResult " + th.getLocalizedMessage(), th);
    }
}
