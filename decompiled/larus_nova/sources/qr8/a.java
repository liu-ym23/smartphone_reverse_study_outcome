package qr8;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.video.ItemType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f534622a = 0;

    static {
    }

    public a() {
    }

    public static void b(Integer r110, String r111, String r112, int r113, int r114, Message r115, boolean r116, String r117, int r118) {
        if ((r118 & 128) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r118 & 512) == 0) goto L9;
        String r101 = null;
    L10:
        if (r115 == null) goto L14;
        o.f365780a.reportEvent(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_CARD, a(r110, r111, r112, r113, r114, r115, null, r100, false, r101));
        return;
    L14:
        return;
    L9:
        r101 = r117;
        goto L10
    L5:
        r100 = r116;
        goto L7
    }

    public static /* synthetic */ void d(Integer r110, String r111, String r112, int r113, int r114, Message r115, boolean r116, String r117, int r118) {
        if ((r118 & 256) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r118 & 1024) == 0) goto L9;
        String r101 = null;
    L10:
        c(r110, r111, r112, r113, r114, r115, null, r100, false, r101);
        return;
    L9:
        r101 = r117;
        goto L10
    L5:
        r100 = r116;
        goto L7
    }

    public static JSONObject a(Integer r100, String r101, String r102, int r103, int r104, Message r105, Integer r110, boolean r111, boolean r112, String r113) {
        if (r112 == false) goto L6;
        if (r111 == false) goto L5;
        String r114 = "wcb_feed";
    L9:
        JSONObject r115 = new JSONObject();
        int r106 = 1;
        r115.put("rank", r103 + 1);
        r115.put("column", r104 + 1);
        ItemType r107 = ItemType.VIDEO;
        int r108 = r107.getValue();
        String r109 = "video";
        if (r100 != null) goto L13;
    L15:
        Object r116 = "graphic";
    L16:
        r115.put("group_type", r116);
        r115.put("bot_id", r105.getSenderId());
        r115.put("chat_type", "default");
        int r117 = r107.getValue();
        if (r100 != null) goto L20;
    L22:
        r109 = "graphic";
    L23:
        r115.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r109);
        r115.put("host_enter_from", r114);
        if (r110 == null) goto L26;
        r106 = r110.intValue();
    L26:
        r115.put("impr_index", r106);
        r115.put("video_id", r101);
        String r118 = r105.getMessageId();
        if (r118 == null) goto L31;
        Long r119 = StringsKt.toLongOrNull(r118);
        if (r119 == null) goto L31;
        String r120 = r119.toString();
    L32:
        r115.put(MusicAppletPage.KEY_MESSAGE_ID, r120);
        r115.put(NoticeInfo.KEY_REPLY_ID, r105.getReplyId());
        r115.put("req_id", r102);
        r115.put("search_id", r113);
        return r115;
    L31:
        r120 = null;
        goto L32
    L20:
        if (r100.intValue() != r117) goto L22;
    L13:
        if (r100.intValue() != r108) goto L15;
        r116 = "video";
        goto L16
    L5:
        r114 = "chat_feed";
        goto L9
    L6:
        if (r111 == false) goto L8;
        r114 = "wcb_first_card";
        goto L9
    L8:
        r114 = "chat_first_card";
        goto L9
    }

    public static void c(Integer r100, String r101, String r102, int r103, int r104, Message r105, Integer r106, boolean r107, boolean r108, String r110) {
        if (r105 != null) goto L4;
        return;
    L4:
        o.f365780a.reportEvent("show_card", a(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110));
    }
}
