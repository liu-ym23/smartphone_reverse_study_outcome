package tx9;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    public static void b(boolean r100, long r101, String r102, boolean r103, Integer r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.put("is_block", r100);     // Catch: Exception -> L5
        r105.put("scene", r102);     // Catch: Exception -> L5
        r105.put("time_interval_from_cold_start", r101);     // Catch: Exception -> L5
        r105.put("is_improve_asr", r103);     // Catch: Exception -> L5
        r105.put("bot_conversation_type", r104);     // Catch: Exception -> L5
    L7:
        com.larus.platform.service.o.f365780a.reportEvent("rd_add_local_message_start", r105);
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("AddLocalMessageEventHelper", "mobAddLocalMessageStart error: " + e.getLocalizedMessage());
        goto L7
    }

    public static void a(boolean r100, String r101, long r102, Integer r103, String r104, long r105, boolean r110, boolean r111, Integer r112, int r113) {
        JSONObject r106 = null;
        if ((r113 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r113 & 16) == 0) goto L9;
        r104 = null;
    L9:
        if ((r113 & 512) == 0) goto L11;
        r106 = new JSONObject();
    L11:
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("is_block", r110);     // Catch: Exception -> L19
        r106.put("is_success", r100);     // Catch: Exception -> L19
        r106.put("time_interval_from_cold_start", r102);     // Catch: Exception -> L19
        if (r103 == null) goto L15;
        r106.put("error_code", r103.intValue());     // Catch: Exception -> L19
    L15:
        if (r104 == null) goto L17;
        r106.put("error_msg", r104);     // Catch: Exception -> L19
    L17:
        r106.put("duration", r105);     // Catch: Exception -> L19
        r106.put("scene", r101);     // Catch: Exception -> L19
        r106.put("is_improve_asr", r111);     // Catch: Exception -> L19
        r106.put("bot_conversation_type", r112);     // Catch: Exception -> L19
    L21:
        com.larus.platform.service.o.f365780a.reportEvent("rd_add_local_message_end", r106);
        return;
    L19:
        e = move-exception;
        FLogger.f375446a.e("AddLocalMessageEventHelper", "mobAddLocalMessageEnd error: " + e.getLocalizedMessage());
        goto L21
    }
}
