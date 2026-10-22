package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class r2 {
    public static void a(String r100, Integer r101, Integer r102, Integer r103, String r104, String r105, String r106, JSONObject r110, by7.e r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r112 & 4096) == 0) goto L27;
        r110 = new JSONObject();
    L27:
        if ((r112 & 8192) == 0) goto L29;
        r111 = null;
    L29:
        Intrinsics.checkNotNullParameter(r110, "params");
        if (r100 != null) goto L53;
    L34:
        if (r101 == null) goto L36;
        r110.put("file_cnt", r101.intValue());     // Catch: Exception -> L32
    L36:
        if (r102 == null) goto L38;
        r110.put("pic_cnt", r102.intValue());     // Catch: Exception -> L32
    L38:
        if (r103 == null) goto L40;
        r110.put("is_multi_file", r103.intValue());     // Catch: Exception -> L32
    L40:
        if (r104 == null) goto L42;
        r110.put("chat_type", r104);     // Catch: Exception -> L32
    L42:
        if (r105 == null) goto L44;
        r110.put("conversation_id", r105);     // Catch: Exception -> L32
    L44:
        if (r106 == null) goto L48;
        r110.put("message_type", r106);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        FLogger.f375446a.e("PasteContentEventHelper", "error in PasteContentEventHelper " + e.getLocalizedMessage());
    L48:
        TrackParams r107 = new TrackParams().merge(r110);
        by7.a r108 = new by7.a("paste_content");
        if (r111 == null) goto L51;
        r108.f21464b = r111;
    L51:
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L53:
        r110.put("bot_id", r100);     // Catch: Exception -> L32
        goto L34
    }
}
