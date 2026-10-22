package p29;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: p29.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C7144a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f527468a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.AVATAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ResourceType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ResourceType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f527468a = r100;
        }
    }

    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("current_page", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_create_button");
        r103.f21463a.merge(r102);
        r103.b();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        g.f365738a.monitorEventForSlardar("click_create_button", r101, null, null);     // Catch: Throwable -> L10
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L21;
        FLogger.f375446a.e("CommunityEventHelper", "slardar report error,  click_create_button " + r106.getLocalizedMessage());
        return;
    L21:
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        e = move-exception;
        FLogger.f375446a.e("CommunityEventHelper", "error in CommunityEventHelper mobClickCreateButton " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, int r107) {
        if ((r107 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r107 & 128) == 0) goto L9;
        r106 = null;
    L9:
        if ((r107 & 256) == 0) goto L11;
        JSONObject r108 = new JSONObject();
    L12:
        Intrinsics.checkNotNullParameter(r102, "tabId");
        Intrinsics.checkNotNullParameter(r103, "tabName");
        Intrinsics.checkNotNullParameter(r105, "enterMethod");
        Intrinsics.checkNotNullParameter(r108, "params");
        r108.putOpt("template_page_type", r106);     // Catch: JSONException -> L15
        r108.put("current_page", r100);     // Catch: JSONException -> L15
        r108.put("bot_id", r101);     // Catch: JSONException -> L15
        r108.put("tab_id", r102);     // Catch: JSONException -> L15
        r108.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r103);     // Catch: JSONException -> L15
        r108.put("from_tab_id", r104);     // Catch: JSONException -> L15
        r108.put("tab_type", null);     // Catch: JSONException -> L15
        r108.put("enter_method", r105);     // Catch: JSONException -> L15
    L17:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r110 = new by7.a("enter_ai_generate_tab_category_page");
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e("CommunityEventHelper", "error in CommunityEventHelper mobEnterAIGenerateTabCategoryPage " + e.getLocalizedMessage());
        goto L17
    L11:
        r108 = null;
        goto L12
    }

    public static void c(String r100, String r101, String r102, String r103, String r104, Integer r105, Boolean r106, String r107, String r110, int r111) {
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
        r105 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r106 = Boolean.FALSE;
    L24:
        if ((r111 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r111 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r111 & 512) == 0) goto L32;
        r108 = new JSONObject();
    L32:
        Intrinsics.checkNotNullParameter(r108, "params");
        r108.putOpt("recommend_from", r100);     // Catch: JSONException -> L35
        r108.putOpt("current_page", r101);     // Catch: JSONException -> L35
        r108.putOpt("is_image_reference_public", r106);     // Catch: JSONException -> L35
        r108.putOpt("creation_sub_type", r104);     // Catch: JSONException -> L35
        r108.putOpt("creation_id", r102);     // Catch: JSONException -> L35
        r108.putOpt("image_reference_cnt", r105);     // Catch: JSONException -> L35
        r108.putOpt("creator_id", r107);     // Catch: JSONException -> L35
        r108.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r103);     // Catch: JSONException -> L35
        r108.putOpt("template_rec_req_id", r110);     // Catch: JSONException -> L35
    L37:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r112 = new by7.a("long_press_creation_prompt");
        r112.f21463a.merge(r109);
        r112.b();
        return;
    L35:
        e = move-exception;
        FLogger.f375446a.e("CommunityEventHelper", "error in CommunityEventHelper mobLongPressCreationPrompt " + e.getLocalizedMessage());
        goto L37
    }
}
