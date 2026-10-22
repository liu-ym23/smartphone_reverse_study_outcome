package w82;

import am2.n;
import am2.q;
import am2.x;
import am2.y;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaLinkContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.i;
import e92.m;
import hy.e;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558621a = 0;

    static {
    }

    public static void c(Map r100) {
        r100.put("from_media", "1");
        r100.put("invitee_list", "mutual_follow");
        r100.put("connection_type", "manual_link");
        MediaLinkContext r101 = MediaLinkContext.Companion.getContext();
        if (r101 == null) goto L11;
        i<a> r102 = r101.getLogParams();
        if (r102 == null) goto L11;
        a r103 = r102.getValue();
        if (r103 == null) goto L11;
        String r104 = r103.f558619a;
        if (r104 == null) goto L11;
        r100.put("request_id", r104);
    L11:
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r105 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r105 == null) goto L21;
        e r106 = r105.Np();
        if (r106 == null) goto L22;
        List<AnchorLinkUser> r107 = r106.getOnlineUserList();
        if (r107 == null) goto L23;
        int r108 = r107.size();
        r100.put("anchor_connect_status", String.valueOf(r108));
        if (r108 <= 1) goto L24;
        r100.put("connection_sub_type", "manual_link");
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @JvmStatic
    public static final void e(fy.e r100, Room r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "targetRoom");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("invitee_id", r101.getOwnerUserIdString());
        r102.put("invitee_status", "0");
        r102.put("channel_id", String.valueOf(m.b()));
        if (r100.f479176d != 13) goto L5;
        r102.put("source", "bigevent");
    L5:
        c(r102);
        u.l().sendLog("livesdk_connection_invite", r102, new Object[]{Room.class});
    }

    @JvmStatic
    public static final void a(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "inviteUserId");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("inviter_id", r101.toString());
        r103.put("selection", r100);
        r103.put("channel_id", String.valueOf(r102));
        c(r103);
        u.l().sendLog("livesdk_connection_invited", r103, new Object[]{Room.class});
    }

    public static void b(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "userID");
        Intrinsics.checkNotNullParameter(r101, "requestPage");
        HashMap r103 = new HashMap();
        if (m.f() == false) goto L5;
        String r104 = "1";
    L6:
        r103.put(IPerformanceManager.Params.is_anchor, r104);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r100.toString());
        r103.put("connection_type", "manual_link");
        r103.put("request_page", r101);
        if (r102 == false) goto L9;
        String r105 = "livesdk_follow";
    L10:
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L17;
        i<Boolean> r107 = r106.isAnchor();
        if (r107 == null) goto L17;
        if (r107.getValue().booleanValue() != true) goto L17;
        String r108 = "anchor_to_anchor";
    L18:
        g r109 = u.l();
        FollowLog r110 = new FollowLog(1);
        r110.f153386e = FollowLog.Scene.MULTI_ANCHOR;
        r110.f153388g = r108;
        r110.f153389h = "0";
        r109.sendLog(r105, r103, new Object[]{Room.class, r110, x.class, am2.u.class, y.class, n.f(), q.class});
        return;
    L17:
        r108 = "audience_to_anchor";
        goto L18
    L9:
        r105 = "livesdk_unfollow";
        goto L10
    L5:
        r104 = "0";
        goto L6
    }

    @JvmStatic
    public static final void d(long r100, long r101, int r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("connection_time", String.valueOf((System.currentTimeMillis() - r100) / ((long) 1000)));
        r103.put("connection_anchor_cnt", String.valueOf(r102));
        r103.put("channel_id", String.valueOf(r101));
        r103.put("from_media", "1");
        g r104 = u.l();
        x r105 = new x();
        r105.f4349a = "live";
        r105.f4353e = "other";
        r104.sendLog("livesdk_connection_over", r103, new Object[]{r105, Room.class});
    }
}
