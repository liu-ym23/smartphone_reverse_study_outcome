package gj0;

import android.content.Context;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f481492a = 0;

    public h() {
    }

    static {
    }

    public static void a(Context r100, Map r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Long r103 = null;
        u6 r104 = new u6((String) vm2.d.X3.getValue(null, vm2.d.f555776a[255(0xff, float:3.57E-43)]));
        u6 r105 = r104.d("url");
        if (r101 == null) goto L8;
        Iterator r106 = r101.entrySet().iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        Map.Entry r107 = (Map.Entry) r106.next();
        r105.b((String) r107.getKey(), (String) r107.getValue());
    L8:
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.f159183a.put("url", r105);
        m<IRoom> r108 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r108 == null) goto L11;
        IRoom r109 = r108.getValue();
    L12:
        LinkedHashMap r110 = new LinkedHashMap();
        if (r109 == null) goto L15;
        r103 = Long.valueOf(r109.getId());
    L15:
        r110.put("room_id", String.valueOf(r103));
        if (r109 == null) goto L19;
        String r111 = r109.getOwnerUserIdString();
        if (r111 == null) goto L19;
    L20:
        r110.put("anchor_id", r111);
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r112 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r112 == null) goto L24;
        String r113 = String.valueOf(r112.b());
        if (r113 == null) goto L24;
    L25:
        r110.put("user_cnt", r113);
        r110.put("action_from", "start");
        r110.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        if (r109 != null) goto L28;
    L30:
        String r114 = "video_live";
    L31:
        r110.put("live_type", r114);
        r110.put("business_type", "starWish");
        r110.put("user_id", ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n().toString());
        if (r101 == null) goto L38;
        Iterator r115 = r101.entrySet().iterator();
    L35:
        if (r115.hasNext() == false) goto L38;
        Map.Entry r116 = (Map.Entry) r115.next();
        r110.put(r116.getKey(), r116.getValue());
    L38:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L40;
        String r117 = "anchor";
    L41:
        r110.put("user_type", r117);
        Iterator r118 = r110.entrySet().iterator();
    L43:
        if (r118.hasNext() == false) goto L45;
        Map.Entry r119 = (Map.Entry) r118.next();
        r105.b((String) r119.getKey(), (String) r119.getValue());
        goto L43
    L45:
        if (r102 == false) goto L47;
        j0.l().sendLog("livesdk_chatroom_game_starwish_icon_click", r110, new Object[]{IRoom.class});
    L47:
        ((IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class)).handle(r100, r104.c());
        return;
    L40:
        r117 = UserGroupScene.DEFAULT_NAME_SPACE;
        goto L41
    L28:
        if (r109.isLiveTypeAudio() != true) goto L30;
        r114 = "voice_live";
    L24:
        r113 = "0";
    L19:
        r111 = "";
        goto L20
    L11:
        r109 = null;
        goto L12
    }

    public static /* synthetic */ void b(Context r100, Map r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        a(r100, r101, false);
    }
}
