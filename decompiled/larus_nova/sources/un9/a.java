package un9;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f550881a = 0;

    static {
    }

    public a() {
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r110, String r111) {
        o r106 = o.f365780a;
        JSONObject r107 = new JSONObject();
        String r108 = "aisheet";
        if ((!StringsKt.isBlank("aisheet")) == false) goto L5;
        String r109 = "aisheet";
    L6:
        if (r109 == null) goto L9;
        r108 = r109;
    L9:
        r107.put("content_type", r108);
        if (r102 == null) goto L12;
        r107.put("resource_id", r102);
    L12:
        if (r100 == null) goto L14;
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r100);
    L14:
        if (r103 == null) goto L16;
        r107.put("resource_type", r103);
    L16:
        if (r105 == null) goto L18;
        r107.put("artifact_type", r105);
    L18:
        if (r104 == null) goto L20;
        r107.put("artifact_meta_id", r104);
    L20:
        r107.put("open_method", r110);
        if (r111 == null) goto L23;
        r107.put("open_from", r111);
    L23:
        if (r101 == null) goto L25;
        r107.put("spreadsheet_id", r101);
    L25:
        Unit r112 = Unit.INSTANCE;
        r106.reportEvent("aisheet_task_artifact_click", r107);
        return;
    L5:
        r109 = null;
        goto L6
    }

    public static void b(Message r110, ChatParam r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        o r114 = o.f365780a;
        JSONObject r115 = new JSONObject();
        r115.put("current_page", r111.f296892d);
        r115.put("previous_page", r111.f296891c);
        r115.put(MusicAppletPage.KEY_MESSAGE_ID, r110.getMessageId());
        r115.put("conversation_id", r110.getConversationId());
        r115.put("bot_id", r211);
        r115.put("chat_type", "default");
        r115.put(NoticeInfo.KEY_REPLY_ID, r110.getReplyId());
        if (r112 == null) goto L5;
        r115.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r112);
    L5:
        if (r113 == null) goto L7;
        r115.put("progress_status", r113);
    L7:
        if (r210 == null) goto L9;
        r115.put("click_effect", r210);
    L9:
        if (r212 == null) goto L11;
        r115.put("aippt_task_id", r212);
    L11:
        if (r213 == null) goto L13;
        r115.put("presentation_id", r213);
    L13:
        if (r214 == null) goto L15;
        r115.put("resource_id", r214);
    L15:
        if (r215 == null) goto L17;
        r115.put("resource_type", r215);
    L17:
        if (r216 == null) goto L19;
        r115.put("artifact_type", r216);
    L19:
        if (r217 == null) goto L21;
        r115.put("artifact_meta_id", r217);
    L21:
        if (r218 == null) goto L23;
        r115.put("spreadsheet_id", r218);
    L23:
        Unit r100 = Unit.INSTANCE;
        r114.reportEvent(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_CARD, r115);
    }

    public static void c(Message r110, ChatParam r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, int r219) {
        String r100 = "";
        if ((r219 & 4) == 0) goto L5;
        String r101 = "";
    L6:
        String r102 = null;
        if ((r219 & 8) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r219 & 32) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r219 & 64) != 0) goto L19;
        r100 = r211;
    L19:
        if ((r219 & 128) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r219 & 256) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r219 & 512) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r219 & 1024) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r219 & 2048) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r219 & 4096) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r219 & 8192) != 0) goto L46;
        r102 = r218;
    L46:
        Intrinsics.checkNotNullParameter(r110, "msg");
        o r108 = o.f365780a;
        JSONObject r117 = new JSONObject();
        r117.put("current_page", r111.f296892d);
        r117.put("previous_page", r111.f296891c);
        r117.put(MusicAppletPage.KEY_MESSAGE_ID, r110.getMessageId());
        r117.put("conversation_id", r110.getConversationId());
        r117.put("bot_id", r100);
        r117.put("chat_type", "default");
        r117.put(NoticeInfo.KEY_REPLY_ID, r110.getReplyId());
        if (r103 == null) goto L49;
        r117.put("progress_status", r103);
    L49:
        if (r104 == null) goto L51;
        r117.put("status", r104);
    L51:
        if (r105 == null) goto L53;
        r117.put("aippt_task_id", r105);
    L53:
        if (r106 == null) goto L55;
        r117.put("presentation_id", r106);
    L55:
        if (r107 == null) goto L57;
        r117.put("resource_id", r107);
    L57:
        if (r114 == null) goto L59;
        r117.put("resource_type", r114);
    L59:
        if (r115 == null) goto L61;
        r117.put("artifact_type", r115);
    L61:
        if (r116 == null) goto L63;
        r117.put("artifact_meta_id", r116);
    L63:
        if (r101 == null) goto L65;
        r117.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r101);
    L65:
        if (r102 == null) goto L67;
        r117.put("spreadsheet_id", r102);
    L67:
        Unit r109 = Unit.INSTANCE;
        r108.reportEvent("show_card", r117);
        return;
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r107 = r214;
        goto L31
    L25:
        r106 = r213;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L13:
        r104 = r210;
        goto L15
    L9:
        r103 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L6
    }
}
