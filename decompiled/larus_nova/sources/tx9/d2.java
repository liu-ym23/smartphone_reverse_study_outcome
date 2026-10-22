package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d2 f547848a = null;

    static {
        f547848a = new d2();
    }

    public d2() {
    }

    public static void c(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "resultScene");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L5
        r103.put("stage", "on_result");     // Catch: Throwable -> L5
        r103.put("result_code", r100);     // Catch: Throwable -> L5
        r103.put("result_scene", r101);     // Catch: Throwable -> L5
        by7.a r104 = new by7.a("rd_photo_picker_result");     // Catch: Throwable -> L5
        TrackParams r105 = new TrackParams().merge(r103);     // Catch: Throwable -> L5
        r104.f21463a.merge(r105);     // Catch: Throwable -> L5
        r104.b();     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void d(boolean r100, boolean r101, boolean r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r103, "params");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        if (r100 == false) goto L6;
        String r105 = "new";
    L7:
        r103.put("photo_picker_version", r105);     // Catch: Throwable -> L17
        if (r101 == false) goto L10;
        String r106 = "bottom";
    L11:
        r103.put("photo_picker_type", r106);     // Catch: Throwable -> L17
        if (r102 == false) goto L14;
        int r107 = 1;
    L15:
        r103.put("is_from_feishu", r107);     // Catch: Throwable -> L17
        by7.a r108 = new by7.a("rd_photo_picker_page_show");     // Catch: Throwable -> L17
        TrackParams r109 = new TrackParams().merge(r103);     // Catch: Throwable -> L17
        r108.f21463a.merge(r109);     // Catch: Throwable -> L17
        r108.b();     // Catch: Throwable -> L17
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        return;
    L14:
        r107 = 0;
        goto L15
    L10:
        r106 = "full_screen";
        goto L11
    L6:
        r105 = "old";
    L17:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void e(boolean r100, boolean r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r102, "resultScene");
        Intrinsics.checkNotNullParameter(r103, "params");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        r103.put("stage", "set_result");     // Catch: Throwable -> L13
        if (r100 == false) goto L6;
        String r105 = "new";
    L7:
        r103.put("photo_picker_version", r105);     // Catch: Throwable -> L13
        if (r101 == false) goto L10;
        int r106 = 1;
    L11:
        r103.put("is_result_empty", r106);     // Catch: Throwable -> L13
        r103.put("result_scene", r102);     // Catch: Throwable -> L13
        by7.a r107 = new by7.a("rd_photo_picker_result");     // Catch: Throwable -> L13
        TrackParams r108 = new TrackParams().merge(r103);     // Catch: Throwable -> L13
        r107.f21463a.merge(r108);     // Catch: Throwable -> L13
        r107.b();     // Catch: Throwable -> L13
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L10:
        r106 = 0;
        goto L11
    L6:
        r105 = "old";
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void a(d2 r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        JSONObject r107 = new JSONObject();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r107, "params");
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L18
        if (r106 == null) goto L6;
        r107.put("spring_guide_card_id", r106);     // Catch: Throwable -> L18
    L6:
        if (r103 == null) goto L8;
        r107.put("bot_id", r103);     // Catch: Throwable -> L18
    L8:
        if (r104 == null) goto L10;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r104);     // Catch: Throwable -> L18
    L10:
        if (r102 == null) goto L12;
        r107.put("click_from", r102);     // Catch: Throwable -> L18
    L12:
        if (r105 == null) goto L14;
        r107.put("is_landing_tab", r105);     // Catch: Throwable -> L18
    L14:
        if (r101 == null) goto L16;
        r107.put("current_page", r101);     // Catch: Throwable -> L18
    L16:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L23;
        FLogger.f375446a.e("MobAlbumEventHelper", "error in MobAlbumEventHelper " + r110.getLocalizedMessage());
    L23:
        TrackParams r111 = new TrackParams().merge(r107);
        by7.a r112 = new by7.a("album_tab_show");
        r112.f21463a.merge(r111);
        r112.b();
        return;
    L18:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public static void b(d2 r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Integer r108) {
        JSONObject r109 = new JSONObject();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r109, "params");
        if (r101 != null) goto L25;
    L7:
        if (r102 == null) goto L9;
        r109.put("chat_type", r102);     // Catch: JSONException -> L5
    L9:
        if (r103 == null) goto L11;
        r109.put("click_from", r103);     // Catch: JSONException -> L5
    L11:
        if (r104 == null) goto L13;
        r109.put("button_name", r104);     // Catch: JSONException -> L5
    L13:
        if (r105 == null) goto L15;
        r109.put("current_page", r105);     // Catch: JSONException -> L5
    L15:
        if (r106 == null) goto L17;
        r109.put("previous_page", r106);     // Catch: JSONException -> L5
    L17:
        if (r107 == null) goto L19;
        r109.put("is_multi_choose_mode", r107);     // Catch: JSONException -> L5
    L19:
        if (r108 == null) goto L23;
        r109.put("is_ai_doc", r108.intValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("MobAlbumEventHelper", "error in MobAlbumEventHelper " + e.getLocalizedMessage());
    L23:
        TrackParams r110 = new TrackParams().merge(r109);
        by7.a r111 = new by7.a("click_album_button");
        r111.f21463a.merge(r110);
        r111.b();
        return;
    L25:
        r109.put("bot_id", r101);     // Catch: JSONException -> L5
        goto L7
    }
}
