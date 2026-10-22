package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class m0 {
    public static void c(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "itemName");
        Intrinsics.checkNotNullParameter(r101, "currentStatus");
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        Intrinsics.checkNotNullParameter(r104, "params");
    L16:
        e = move-exception;
        FLogger.f375446a.e("CreationEventHelper", "error in CreationEventHelper cueBot " + e.getLocalizedMessage());
    L18:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("creation_function_show");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L4:
        if (com.larus.utils.o0.d(r100) == false) goto L7;
        r104.put("item_name", r100);     // Catch: JSONException -> L16
    L7:
        if (com.larus.utils.o0.d(r101) == false) goto L10;
        r104.put("current_status", r101);     // Catch: JSONException -> L16
    L10:
        if (com.larus.utils.o0.d(r102) == false) goto L13;
        r104.put("current_page", r102);     // Catch: JSONException -> L16
    L13:
        if (com.larus.utils.o0.d(r103) == false) goto L18;
        r104.put("previous_page", r103);     // Catch: JSONException -> L16
        goto L18
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, boolean r105, String r106, String r107, String r110, int r111) {
        JSONObject r108 = null;
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = false;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r111 & 256) == 0) goto L30;
        r110 = "manual";
    L30:
        if ((r111 & 512) == 0) goto L32;
        r108 = new JSONObject();
    L32:
        Intrinsics.checkNotNullParameter(r108, "params");
    L63:
        e = move-exception;
        FLogger.f375446a.e("CreationEventHelper", "error in CreationEventHelper cueBot " + e.getLocalizedMessage());
    L65:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r112 = new by7.a("add_creation");
        r112.f21463a.merge(r109);
        r112.b();
        return;
    L34:
        if (com.larus.utils.o0.d(r100) == false) goto L37;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r100);     // Catch: JSONException -> L63
    L37:
        if (com.larus.utils.o0.d(r101) == false) goto L40;
        r108.put("bot_id", r101);     // Catch: JSONException -> L63
    L40:
        if (com.larus.utils.o0.d(r102) == false) goto L43;
        r108.put("chat_type", r102);     // Catch: JSONException -> L63
    L43:
        if (com.larus.utils.o0.d(r103) == false) goto L46;
        r108.put("previous_page", r103);     // Catch: JSONException -> L63
    L46:
        if (com.larus.utils.o0.d(r104) == false) goto L49;
        r108.put("current_page", r104);     // Catch: JSONException -> L63
    L49:
        if (com.larus.utils.o0.d(r106) == false) goto L52;
        r108.put("creation_id", r106);     // Catch: JSONException -> L63
    L52:
        if (com.larus.utils.o0.d(r107) == false) goto L55;
        r108.put("type", r107);     // Catch: JSONException -> L63
    L55:
        if (com.larus.utils.o0.d(r110) == false) goto L58;
        r108.put("add_method", r110);     // Catch: JSONException -> L63
    L58:
        if (r105 == false) goto L60;
        String r113 = "1";
    L61:
        r108.put("success", r113);     // Catch: JSONException -> L63
        goto L65
    L60:
        r113 = "0";
        goto L61
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, JSONObject r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r111 & 256) == 0) goto L29;
        r110 = new JSONObject();
    L29:
        Intrinsics.checkNotNullParameter(r110, "params");
        r110.putOpt("creation_id", r107);     // Catch: JSONException -> L49
        r110.putOpt("sub_type", r106);     // Catch: JSONException -> L49
        if (com.larus.utils.o0.d(r100) == false) goto L34;
        r110.put(MusicAppletPage.KEY_MESSAGE_ID, r100);     // Catch: JSONException -> L49
    L34:
        if (com.larus.utils.o0.d(r101) == false) goto L37;
        r110.put("bot_id", r101);     // Catch: JSONException -> L49
    L37:
        if (com.larus.utils.o0.d(r102) == false) goto L40;
        r110.put("chat_type", r102);     // Catch: JSONException -> L49
    L40:
        if (com.larus.utils.o0.d(r103) == false) goto L43;
        r110.put("previous_page", r103);     // Catch: JSONException -> L49
    L43:
        if (com.larus.utils.o0.d(r104) == false) goto L46;
        r110.put("current_page", r104);     // Catch: JSONException -> L49
    L46:
        if (com.larus.utils.o0.d(r105) == false) goto L51;
        r110.put("type", r105);     // Catch: JSONException -> L49
    L51:
        TrackParams r108 = new TrackParams().merge(r110);
        by7.a r109 = new by7.a("click_add_creation");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L49:
        e = move-exception;
        FLogger.f375446a.e("CreationEventHelper", "error in CreationEventHelper cueBot " + e.getLocalizedMessage());
        goto L51
    }
}
