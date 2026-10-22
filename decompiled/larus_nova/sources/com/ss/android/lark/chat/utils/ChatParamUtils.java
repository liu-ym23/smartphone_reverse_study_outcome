package com.ss.android.lark.chat.utils;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.obric.assistant.WakeupSoundEffectSettings;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.tencent.open.im.IM;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatParamUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f416599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Chat f416600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f416601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Chatter f416602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f416603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f416604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f416605g = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f416606a = null;

        static {
            int[] r100 = new int[Message.Type.values().length];
            r100[Message.Type.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L85:
            r100[Message.Type.TEXT_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L99:
            r100[Message.Type.POST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[Message.Type.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L65:
            r100[Message.Type.TEXT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L79:
            r100[Message.Type.IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L93:
            r100[Message.Type.SYSTEM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L71:
            r100[Message.Type.AUDIO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L87:
            r100[Message.Type.EMAIL.ordinal()] = 9;     // Catch: NoSuchFieldError -> L37
        L89:
            r100[Message.Type.SHARE_GROUP_CHAT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L38
        L55:
            r100[Message.Type.STICKER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L39
        L83:
            r100[Message.Type.MERGE_FORWARD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L40
        L97:
            r100[Message.Type.CALENDAR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L41
        L53:
            r100[Message.Type.CARD.ordinal()] = 14;     // Catch: NoSuchFieldError -> L42
        L67:
            r100[Message.Type.MEDIA.ordinal()] = 15;     // Catch: NoSuchFieldError -> L43
        L95:
            r100[Message.Type.SHARE_CALENDAR_EVENT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L44
        L59:
            r100[Message.Type.RED_PACKET.ordinal()] = 17;     // Catch: NoSuchFieldError -> L45
        L63:
            r100[Message.Type.GENERAL_CALENDAR.ordinal()] = 18;     // Catch: NoSuchFieldError -> L46
        L81:
            r100[Message.Type.VIDEO_CHAT.ordinal()] = 19;     // Catch: NoSuchFieldError -> L47
        L57:
            r100[Message.Type.LOCATION.ordinal()] = 20;     // Catch: NoSuchFieldError -> L48
        L75:
            r100[Message.Type.COMMERCIALIZED_HONGBAO.ordinal()] = 21;     // Catch: NoSuchFieldError -> L49
        L77:
            r100[Message.Type.SHARE_USER_CARD.ordinal()] = 22;     // Catch: NoSuchFieldError -> L50
        L91:
            r100[Message.Type.TODO.ordinal()] = 23;     // Catch: NoSuchFieldError -> L51
        L69:
            r100[Message.Type.FOLDER.ordinal()] = 24;     // Catch: NoSuchFieldError -> L52
        L27:
            f416606a = r100;
        }
    }

    static {
        f416605g = LazyKt.lazy(ChatParamUtils$statistics$2.INSTANCE);
    }

    @Deprecated(message = "not have correct chat in some case", replaceWith = @ReplaceWith(expression = "getChatParamMap", imports = {}))
    @JvmStatic
    public static final Map<String, Object> e() {
        return f(f416599a);
    }

    @JvmStatic
    public static final String c(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isP2PChat() == false) goto L6;
        return "single";
    L6:
        if (r100.isThread() == false) goto L8;
        return "topic";
    L8:
        return "group";
    }

    @JvmStatic
    public static final String d(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isMeeting() == false) goto L6;
        return "meeting";
    L6:
        if (r100.is_department() == false) goto L9;
        return "department";
    L9:
        if (r100.isTenant() == false) goto L12;
        return "all_staff";
    L12:
        if (r100.isOnCall() == false) goto L15;
        return "on_call";
    L15:
        if (r100.isCustomerService() == false) goto L18;
        return "customer_service";
    L18:
        if (r100.isThread() == false) goto L20;
        return "topic";
    L20:
        boolean r101 = true;
        if (r100.isGroup() == false) goto L26;
        if (r100.getMemberCount() != 1) goto L26;
        return "to_myself_group";
    L26:
        if (r100.isSoloChat() == false) goto L29;
        return "to_myself_single";
    L29:
        if (r100.isAIChat() == false) goto L31;
        return "single_ai";
    L31:
        Chatter r102 = f416602d;
        if (r102 != null) goto L34;
    L36:
        r101 = false;
    L37:
        if (r101 == false) goto L40;
        return INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE_BOT;
    L40:
        if (r100.isP2PChat() == false) goto L42;
        return "single_normal";
    L42:
        return WakeupSoundEffectSettings.CLASSIC;
    L34:
        if (r102.isBot() != true) goto L36;
        goto L36
    }

    @JvmStatic
    public static final Map<String, Object> f(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r100, f416599a) == false) goto L19;
        Chat r102 = f416600b;
        if (r102 == null) goto L21;
        if (r102 != null) goto L18;
        return null;
    L18:
        return a(r102, f416601c, f416602d);
    L21:
        return null;
    L19:
        return null;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }

    public static Map g(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Pair[] r101 = new Pair[3];
        r101[0] = TuplesKt.to("msg_id", r100.getId());
        String r102 = r100.getcId();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101[1] = TuplesKt.to("cid", r102);
        r101[2] = TuplesKt.to(SeiMessageConst.MSG_TYPE, k(r100.getType()));
        return MapsKt.mapOf(r101);
    }

    public static Map h(y6b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "absMessageVO");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("msg_id", r100.getId()), TuplesKt.to("cid", r100.getcId()), TuplesKt.to(SeiMessageConst.MSG_TYPE, k(r100.getType()))});
    }

    public static Map i(y6b.c r100) {
        Intrinsics.checkNotNullParameter(r100, "chatMessageVO");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("msg_id", r100.f566482c), TuplesKt.to("cid", r100.f566483d), TuplesKt.to(SeiMessageConst.MSG_TYPE, k(r100.getType()))});
    }

    public static String k(Message.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(a.f416606a[r100.ordinal()]) {
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            case 13: goto L16;
            case 14: goto L15;
            case 15: goto L14;
            case 16: goto L13;
            case 17: goto L12;
            case 18: goto L11;
            case 19: goto L10;
            case 20: goto L9;
            case 21: goto L8;
            case 22: goto L7;
            case 23: goto L6;
            case 24: goto L5;
            default: goto L27;
        };
    L5:
        return DocumentType.FOLDER_NAME;
    L6:
        return IOfflineExtraParser.ParserType.TODO;
    L7:
        return "shareUserCard";
    L8:
        return "commercializedHongbao";
    L9:
        return "location";
    L10:
        return IM.CHAT_TYPE_VIDEO_CHAT;
    L11:
        return "generalCalendar";
    L12:
        return "hongbao";
    L13:
        return "shareCalendarEvent";
    L14:
        return "media";
    L15:
        return BrowserDependency.UrlClickType.CARD;
    L16:
        return "calendar";
    L17:
        return "mergeForward";
    L18:
        return "sticker";
    L19:
        return "shareGroupChat";
    L20:
        return "email";
    L21:
        return "audio";
    L22:
        return CameraParam.TYPE_SYSTEM_CAMERA;
    L23:
        return "image";
    L24:
        return "text";
    L25:
        return "file";
    L26:
        return UGCMonitor.TYPE_POST;
    L27:
        return "unknown";
    }

    @JvmStatic
    public static final void l(Chatter r100) {
        Intrinsics.checkNotNullParameter(r100, "chatter");
        Chat r101 = f416600b;
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = r101.isP2PChat();
    L6:
        if (r103 == false) goto L14;
        Chat r104 = f416600b;
        if (r104 == null) goto L10;
        String r105 = r104.getP2pChatterId();
    L12:
        if (Intrinsics.areEqual(r105, r100.getId()) == false) goto L14;
        r102 = true;
        goto L14
    L10:
        r105 = null;
    L14:
        if (r102 == false) goto L17;
        f416602d = r100;
        return;
    L17:
        return;
    L5:
        r103 = false;
        goto L6
    }

    @JvmStatic
    public static final Map<String, Object> a(Chat r100, String r101, Chatter r102) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        Pair[] r103 = new Pair[10];
        int r104 = 0;
        r103[0] = TuplesKt.to("chat_id", r100.getId());
        r103[1] = TuplesKt.to("chat_type", c(r100));
        r103[2] = TuplesKt.to("chat_type_detail", d(r100));
        if (r100.isGroup() == false) goto L8;
        if (Intrinsics.areEqual(r101, r100.getOwnerId()) == false) goto L8;
        String r105 = "group_owner";
    L11:
        r103[3] = TuplesKt.to("member_type", r105);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r106 = "true";
        if (r100.isCrossTenant() == true) goto L14;
        Object r107 = "true";
    L15:
        r103[4] = TuplesKt.to("is_inner_group", r107);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isPublic() == true) goto L19;
        r106 = "false";
    L19:
        r103[5] = TuplesKt.to("is_public_group", r106);
        if (r102 != null) goto L23;
        r102 = f416602d;
    L23:
        if (r100.isP2PChat() == false) goto L29;
        if (r102 == null) goto L29;
        if (r102.isBot() == false) goto L29;
        r104 = 1;
    L32:
        r103[6] = TuplesKt.to("bot_count", Integer.valueOf(r104));
        if (r100.getChatDisplayModeSetting() != ChatDisplayModeSetting.THREAD) goto L35;
        String r108 = "thread";
    L36:
        r103[7] = TuplesKt.to("group_mode", r108);
        String r109 = f416603e;
        if (r109 != null) goto L39;
        r109 = "im_chat_view";
    L39:
        r103[8] = TuplesKt.to("scene", r109);
        String r110 = f416604f;
        if (r110 != null) goto L42;
        r110 = "other";
    L42:
        r103[9] = TuplesKt.to("app_name", r110);
        Map<String, Object> r111 = MapsKt.mutableMapOf(r103);
        if (r100.isAIChat() == false) goto L45;
        r111.put("shadow_id", r100.getP2pChatterId());
    L45:
        return r111;
    L35:
        r108 = "normal";
    L29:
        if (r100.isP2PChat() == true) goto L32;
        r104 = r100.getMemberCount() - r100.getUserCount();
        goto L32
    L14:
        r107 = "false";
    L8:
        if (r100.isAdmin() == false) goto L10;
        r105 = "group_admin";
        goto L11
    L10:
        r105 = "normal_member";
        goto L11
    }

    public static /* synthetic */ Map b(Chat r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return a(r100, r101, null);
    }

    @JvmStatic
    public static final void j(String r100, String r101, Chat r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        boolean r105 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(f416599a, r100) == false) goto L13;
        return;
    L13:
        if (r101.length() != 0) goto L15;
        r105 = true;
    L15:
        if (r105 == true) goto L21;
        f416599a = r100;
        f416601c = r101;
        f416600b = r102;
        f416603e = r103;
        f416604f = r104;
        return;
    L21:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r106 = false;
        goto L9
    }
}
