package tn9;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f546879a = 0;

    static {
    }

    public a() {
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111) {
        o r107 = o.f365780a;
        JSONObject r108 = new JSONObject();
        if (r100 == null) goto L5;
        r108.put("aippt_task_id", r100);
    L5:
        if (r101 == null) goto L7;
        r108.put("presentation_id", r101);
    L7:
        if (r102 == null) goto L9;
        r108.put("resource_id", r102);
    L9:
        if (r103 == null) goto L11;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r103);
    L11:
        if (r104 == null) goto L13;
        r108.put("resource_type", r104);
    L13:
        if (r105 == null) goto L15;
        r108.put("artifact_type", r105);
    L15:
        if (r106 == null) goto L17;
        r108.put("artifact_meta_id", r106);
    L17:
        r108.put("open_method", r110);
        if (r111 == null) goto L20;
        r108.put("open_from", r111);
    L20:
        r108.put("content_type", "aippt_new");
        Unit r109 = Unit.INSTANCE;
        r107.reportEvent("aippt_task_artifact_click", r108);
    }

    public static void b(Message r100, ChatParam r101, String r102, String r103, String r104, String r105, String r110, String r111, String r112, String r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        o r106 = o.f365780a;
        JSONObject r107 = new JSONObject();
        r107.put("current_page", r101.f296892d);
        r107.put("previous_page", r101.f296891c);
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r100.getMessageId());
        r107.put("conversation_id", r100.getConversationId());
        r107.put("bot_id", r105);
        r107.put("chat_type", "default");
        r107.put(NoticeInfo.KEY_REPLY_ID, r100.getReplyId());
        if (r102 == null) goto L5;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r102);
    L5:
        if (r103 == null) goto L7;
        r107.put("progress_status", r103);
    L7:
        r107.put("click_effect", r104);
        if (r110 == null) goto L10;
        r107.put("aippt_task_id", r110);
    L10:
        if (r111 == null) goto L12;
        r107.put("presentation_id", r111);
    L12:
        if (r112 == null) goto L14;
        r107.put("resource_id", r112);
    L14:
        if (r113 == null) goto L16;
        r107.put("resource_type", r113);
    L16:
        if (r114 == null) goto L18;
        r107.put("artifact_type", r114);
    L18:
        if (r115 == null) goto L20;
        r107.put("artifact_meta_id", r115);
    L20:
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_CARD, r107);
    }

    public static void c(Message r100, ChatParam r101, String r102, String r103, String r104, String r105, String r110, String r111, String r112, String r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        o r106 = o.f365780a;
        JSONObject r107 = new JSONObject();
        r107.put("current_page", r101.f296892d);
        r107.put("previous_page", r101.f296891c);
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r100.getMessageId());
        r107.put("conversation_id", r100.getConversationId());
        r107.put("bot_id", r105);
        r107.put("chat_type", "default");
        r107.put(NoticeInfo.KEY_REPLY_ID, r100.getReplyId());
        if (r103 == null) goto L5;
        r107.put("progress_status", r103);
    L5:
        if (r104 == null) goto L7;
        r107.put("status", r104);
    L7:
        if (r110 == null) goto L9;
        r107.put("aippt_task_id", r110);
    L9:
        if (r111 == null) goto L11;
        r107.put("presentation_id", r111);
    L11:
        if (r112 == null) goto L13;
        r107.put("resource_id", r112);
    L13:
        if (r113 == null) goto L15;
        r107.put("resource_type", r113);
    L15:
        if (r114 == null) goto L17;
        r107.put("artifact_type", r114);
    L17:
        if (r115 == null) goto L19;
        r107.put("artifact_meta_id", r115);
    L19:
        if (r102 == null) goto L21;
        r107.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r102);
    L21:
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent("show_card", r107);
    }
}
