package el0;

import am2.x;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.r;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import dl0.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f473002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f473003b = 0;

    public static String e() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.i<Boolean> r101 = r100.isAnchor();
        if (r101 == null) goto L11;
        if (r101.getValue().booleanValue() != true) goto L11;
        return "anchor";
    L11:
        if (((IUserService) k.n(IUserService.class)).user().c() == false) goto L14;
        return "user";
    L14:
        return "guest";
    }

    public static String f() {
        if (((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getMultiDataHolderExternal().getPkId() != 0) goto L5;
        long r100 = f473002a;
    L7:
        return String.valueOf(r100);
    L5:
        r100 = ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getMultiDataHolderExternal().getPkId();
        goto L7
    }

    static {
    }

    public static void a(TextView r100) {
        if (r100 == null) goto L9;
        int r101 = r100.getPaddingStart() + r100.getPaddingEnd();
        r100.measure(0, 0);
        int r102 = r100.getMeasuredWidth() + r101;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L6;
        r103.width = r102;
        Unit r104 = Unit.INSTANCE;
    L7:
        r100.setLayoutParams(r103);
        r100.setBackgroundResource(R.drawable.ttlive_bg_apply_list_friend_host);
        return;
    L6:
        r103 = null;
        goto L7
    }

    @JvmStatic
    public static final void i(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L10;
        m<Room> r102 = r101.getRoom();
        if (r102 == null) goto L11;
        Room r103 = r102.getValue();
        if (r103 == null) goto L12;
        r100.put("anchor_id", r103.getOwnerUserIdString());
        r100.put("room_id", String.valueOf(r103.f162599id));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void k(Map r100) {
        j(r100, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()));
    }

    public static void m(Map r100) {
        l(r100, ((IInteractService) k.n(IInteractService.class)).getCurrentScene());
    }

    @JvmStatic
    public static final void o(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        List<Integer> r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L17;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r103 = r102.getVideoTalkRoomSubScene();
        if (r103 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r104 = r103.getValue();
        if (r104 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r105 = r104.t();
        if (r105 == null) goto L17;
        List<Integer> r106 = r105.f114799b;
        if (r106 == null) goto L17;
        if (r106.contains(1) == false) goto L15;
        r101 = r106;
    L15:
        if (r101 == null) goto L17;
        String r107 = "video_friend";
    L18:
        r100.put("play_type", r107);
        return;
    L17:
        r107 = "";
        goto L18
    }

    @JvmStatic
    public static final void p(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r102 = r101.getVideoTalkRoomSubScene();
        if (r102 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r103 = r102.getValue();
        if (r103 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r104 = r103.t();
        if (r104 != null) goto L11;
        return;
    L11:
        if (d0.e(r104.f114799b) == false) goto L13;
        r100.put("seat_fit_status", "on");
        return;
    L13:
        r100.put("seat_fit_status", "off");
        return;
    L17:
        return;
    L16:
        return;
    }

    @JvmStatic
    public static final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("request_page", r100);
        r102.put(FastStartLiveConfig.PLAY_MODE, w.a());
        int r103 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        l(r102, r103);
        j(r102, Integer.valueOf(r103));
        o(r102);
        p(r102);
        Intrinsics.checkNotNullParameter(r102, "logMap");
        r102.put("guest_connection_type", "live_chat");
        r102.put("user_id", ((IUserService) k.n(IUserService.class)).user().n());
        r102.put("user_type", e());
        if (r101 == null) goto L18;
        String r104 = null;
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r105 == null) goto L14;
        m<Room> r106 = r105.getRoom();
        if (r106 == null) goto L14;
        Room r107 = r106.getValue();
        if (r107 == null) goto L14;
        User r108 = r107.mo8271getOwner();
        if (r108 == null) goto L14;
        r104 = r108.getIdStr();
    L14:
        if (Intrinsics.areEqual(r101, r104) == false) goto L16;
        String r109 = "anchor";
    L17:
        r102.put("mute_user_type", r109);
        goto L18
    L16:
        r109 = "guest";
    L18:
        n(r102, Integer.valueOf(r103));
        u.l().sendLog("livesdk_guest_connection_mute_cancel", r102, new Object[]{x.class, Room.class});
    }

    @JvmStatic
    public static final void j(Map<String, String> r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        if (r101 != null) goto L5;
    L14:
        r100.put("function_type", "");
        r100.put("function_type2", "");
        return;
    L5:
        if (r101.intValue() == 0) goto L14;
        r101.intValue();
        if (r101.intValue() == 1) goto L9;
        String r102 = "radio";
    L13:
        r100.put("function_type", r102);
        r100.put("function_type2", r102);
        return;
    L9:
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == false) goto L11;
        r102 = "new_audience";
        goto L13
    L11:
        r102 = SourceType.DEFAULT;
        goto L13
    }

    @JvmStatic
    public static final void l(Map<String, String> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        if (r101 != 1) goto L5;
    L10:
        r100.put("live_type", "video_live");
        return;
    L5:
        if (r101 == 4) goto L10;
        if (r101 != 8) goto L13;
        r100.put("live_type", "video_live");
        return;
    }

    @JvmStatic
    public static final void n(Map<String, String> r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        if (r101 != null) goto L6;
    L8:
        String r102 = "";
    L9:
        r100.put("pk_id", r102);
        if (r101 != null) goto L13;
    L15:
        String r103 = "0";
    L16:
        r100.put("is_in_pk", r103);
        return;
    L13:
        if (r101.intValue() != 1) goto L15;
        r103 = "1";
        goto L16
    L6:
        if (r101.intValue() != 1) goto L8;
        r102 = f();
        goto L9
    }

    public static void q(Map r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        Intrinsics.checkNotNullParameter(r101, "songList");
        StringBuilder r102 = new StringBuilder();
        StringBuilder r103 = new StringBuilder();
        Iterator r104 = r101.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L12;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        KtvMusic r108 = (KtvMusic) r106;
        if (r105 <= 0) goto L11;
        r102.append(",");
        r103.append(",");
    L11:
        r102.append(r108.getMId());
        r103.append(r108.getMTitle());
        r105 = r107;
        goto L4
    L12:
        r100.put("song_id", r102.toString());
        r100.put("song_name", r103.toString());
    }

    @JvmStatic
    public static final void h(String r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("request_page", r100);
        r103.put(FastStartLiveConfig.PLAY_MODE, w.a());
        int r104 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        l(r103, r104);
        j(r103, Integer.valueOf(r104));
        p(r103);
        Intrinsics.checkNotNullParameter(r103, "logMap");
        r103.put("guest_connection_type", "live_chat");
        r103.put("user_id", ((IUserService) k.n(IUserService.class)).user().n());
        r103.put("user_type", e());
        if (r101 == null) goto L5;
        r103.put("link_cnt", String.valueOf(r101.intValue()));
    L5:
        if (r102 == null) goto L20;
        String r105 = null;
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L16;
        m<Room> r107 = r106.getRoom();
        if (r107 == null) goto L16;
        Room r108 = r107.getValue();
        if (r108 == null) goto L16;
        User r109 = r108.mo8271getOwner();
        if (r109 == null) goto L16;
        r105 = r109.getIdStr();
    L16:
        if (Intrinsics.areEqual(r102, r105) == false) goto L18;
        String r110 = "anchor";
    L19:
        r103.put("mute_user_type", r110);
        goto L20
    L18:
        r110 = "guest";
    L20:
        o(r103);
        n(r103, Integer.valueOf(r104));
        u.l().sendLog("livesdk_guest_connection_mute", r103, new Object[]{x.class, Room.class});
    }

    public static void b(r r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "emoji");
        Intrinsics.checkNotNullParameter(r103, "requestPage");
        LinkedHashMap r104 = new LinkedHashMap();
        if (r101 == false) goto L5;
        String r105 = "anchor";
    L6:
        r104.put("user_type", r105);
        r104.put("user_id", ((IUserService) k.n(IUserService.class)).user().n());
        r104.put("request_page", r103);
        if (r100.isRandomEmoji == false) goto L9;
        String r106 = "random";
    L10:
        r104.put("emoji_type", r106);
        r104.put("emoji_id", String.valueOf(r100.emojiId));
        r104.put("emoji_name", r100.emojiName);
        r104.put("emoji_status", String.valueOf(r100.emojiStatus));
        if (r102 == false) goto L13;
        String r107 = "self";
    L14:
        r104.put("interact_type", r107);
        if (r100.isDigitAvatarEmoji() == false) goto L17;
        String r108 = "1";
    L18:
        r104.put("is_avatar_emoji", r108);
        u.l().sendLog("livesdk_chat_emoji_click", r104, new Object[]{x.class, Room.class});
        return;
    L17:
        r108 = "0";
        goto L18
    L13:
        r107 = "others";
        goto L14
    L9:
        r106 = "normal";
        goto L10
    L5:
        r105 = "guest";
        goto L6
    }

    public static void c(boolean r100, String r101, r r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "requestPage");
        Intrinsics.checkNotNullParameter(r102, "emoji");
        LinkedHashMap r104 = new LinkedHashMap();
        if (r100 == false) goto L5;
        String r105 = "anchor";
    L6:
        r104.put("user_type", r105);
        r104.put("user_id", ((IUserService) k.n(IUserService.class)).user().n());
        r104.put("request_page", r101);
        o(r104);
        if (r102.isRandomEmoji == false) goto L9;
        String r106 = "random";
    L10:
        r104.put("emoji_type", r106);
        r104.put("emoji_id", String.valueOf(r102.emojiId));
        r104.put("emoji_name", r102.emojiName);
        r104.put("emoji_status", String.valueOf(r102.emojiStatus));
        if (r103 == false) goto L13;
        String r107 = "self";
    L14:
        r104.put("interact_type", r107);
        if (r102.isDigitAvatarEmoji() == false) goto L17;
        String r108 = "1";
    L18:
        r104.put("is_avatar_emoji", r108);
        u.l().sendLog("livesdk_chat_emoji_show", r104, new Object[]{x.class, Room.class});
        return;
    L17:
        r108 = "0";
        goto L18
    L13:
        r107 = "others";
        goto L14
    L9:
        r106 = "normal";
        goto L10
    L5:
        r105 = "guest";
        goto L6
    }

    @JvmStatic
    public static final void d(boolean r100, String r101, int r102, r r103, String r104, Boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "requestPage");
        Intrinsics.checkNotNullParameter(r103, "emoji");
        LinkedHashMap r106 = new LinkedHashMap();
        String r107 = "anchor";
        if (r100 == false) goto L5;
        Object r108 = "anchor";
    L6:
        r106.put("user_type", r108);
        r106.put("user_id", ((IUserService) k.n(IUserService.class)).user().n());
        r106.put("request_page", r101);
        l(r106, r102);
        j(r106, Integer.valueOf(r102));
        o(r106);
        if (r103.isRandomEmoji == false) goto L9;
        String r109 = "random";
    L10:
        r106.put("emoji_type", r109);
        r106.put("emoji_id", String.valueOf(r103.emojiId));
        String r110 = r103.emojiName;
        if (r110 == null) goto L14;
        r106.put("emoji_name", r110);
    L14:
        if (r103.isInteractEmoji() == false) goto L16;
        String r111 = "others";
    L17:
        r106.put("interact_type", r111);
        String r112 = "0";
        if (r103.isSoundEmoji() == false) goto L20;
        Object r113 = "1";
    L21:
        r106.put("is_voice", r113);
        if (r104 == null) goto L29;
        r106.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r104);
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == true) goto L27;
        r107 = "guest";
    L27:
        r106.put("to_user_type", r107);
    L29:
        if (r103.isDigitAvatarEmoji() == false) goto L31;
        r112 = "1";
    L31:
        r106.put("is_avatar_emoji", r112);
        r106.put("channel_id", String.valueOf(p.a().getChannelId()));
        r106.put("pk_id", f());
        r106.put("is_in_pk", "1");
        r106.put("voice_mode", "head");
        u.l().sendLog("livesdk_chat_emoji_send", r106, new Object[]{x.class, Room.class});
        return;
    L20:
        r113 = "0";
        goto L21
    L16:
        r111 = "self";
        goto L17
    L9:
        r109 = "normal";
        goto L10
    L5:
        r108 = "guest";
        goto L6
    }
}
