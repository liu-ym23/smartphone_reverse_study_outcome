package xe0;

import am2.x;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f563345a = false;

    public k() {
    }

    static {
        f563345a = ((IKtvService) jc1.k.n(IKtvService.class)).isUserSelectMusic(((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e() {
        HashMap r100 = new HashMap();
        if (f563345a == false) goto L5;
        String r101 = "1";
    L6:
        r100.put("is_song_order", r101);
        Integer r102 = (Integer) hd0.c.f().f481009b;
        if (r102 != null) goto L10;
    L12:
        if (r102 != null) goto L15;
    L17:
        String r103 = "other";
    L18:
        r100.put("link_status", r103);
        j0.l().sendLog("livesdk_audience_apply_reserve_cancel", r100, new Object[]{IRoom.class, x.class});
        return;
    L15:
        if (r102.intValue() != 1) goto L17;
        r103 = e1.REPLY_ACTION_APPLY;
        goto L18
    L10:
        if (r102.intValue() != 2) goto L12;
        r103 = "link";
        goto L18
    L5:
        r101 = "0";
        goto L6
    }

    public static void a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "clickButton");
        HashMap r102 = new HashMap();
        if (r100 == false) goto L5;
        String r103 = "1";
    L6:
        r102.put("is_auto_confirm", r103);
        r102.put("trigger_scene", WsConstants.KEY_CONNECTION);
        r102.put(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON, r101);
        j0.l().sendLog("livesdk_mini_window_popup_click", r102, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r103 = "0";
        goto L6
    }

    public static void b(int r100, int r101, String r102, HashMap r103) {
        Intrinsics.checkNotNullParameter(r102, "functionType");
        HashMap r104 = new HashMap();
        if (f563345a == false) goto L5;
        String r105 = "1";
    L6:
        r104.put("is_song_order", r105);
        r104.put("trigger_scene", WsConstants.KEY_CONNECTION);
        r104.put("windows_type", "in");
        r104.put("initial_page", "content");
        if (vm2.d.v0() == false) goto L9;
        r104.put("function_type", r102);
        r104.put("function_type2", r102);
    L10:
        r104.putAll(r103);
        j0.l().sendLog("livesdk_mini_window_close", r104, new Object[]{IRoom.class, x.class});
        return;
    L9:
        TalkRoomLogUtils.A0(r104, Integer.valueOf(r100), Integer.valueOf(r101));
        goto L10
    L5:
        r105 = "0";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(int r100, int r101, String r102, HashMap r103) {
        Intrinsics.checkNotNullParameter(r102, "functionType");
        HashMap r104 = new HashMap();
        if (f563345a == false) goto L5;
        String r105 = "1";
    L6:
        r104.put("is_song_order", r105);
        Integer r106 = (Integer) hd0.c.f().f481009b;
        if (r106 != null) goto L10;
    L12:
        if (r106 != null) goto L15;
    L17:
        String r107 = "other";
    L18:
        r104.put("link_status", r107);
        r104.put("trigger_scene", WsConstants.KEY_CONNECTION);
        r104.put("windows_type", "in");
        r104.put("initial_page", "content");
        if (vm2.d.v0() == false) goto L21;
        r104.put("function_type", r102);
        r104.put("function_type2", r102);
    L22:
        r104.putAll(r103);
        j0.l().sendLog("livesdk_mini_window_live_play", r104, new Object[]{IRoom.class, x.class});
        return;
    L21:
        TalkRoomLogUtils.A0(r104, Integer.valueOf(r100), Integer.valueOf(r101));
        goto L22
    L15:
        if (r106.intValue() != 1) goto L17;
        r107 = e1.REPLY_ACTION_APPLY;
        goto L18
    L10:
        if (r106.intValue() != 2) goto L12;
        r107 = "link";
        goto L18
    L5:
        r105 = "0";
        goto L6
    }

    public static void c(int r100, int r101, String r102, long r103, HashMap r104) {
        Intrinsics.checkNotNullParameter(r102, "functionType");
        HashMap r105 = new HashMap();
        if (f563345a == false) goto L5;
        String r106 = "1";
    L6:
        r105.put("is_song_order", r106);
        r105.put("trigger_scene", WsConstants.KEY_CONNECTION);
        r105.put("windows_type", "in");
        r105.put("initial_page", "content");
        r105.put("duration", String.valueOf(r103));
        if (vm2.d.v0() == false) goto L9;
        r105.put("function_type", r102);
        r105.put("function_type2", r102);
    L10:
        r105.putAll(r104);
        j0.l().sendLog("livesdk_mini_window_live_duration", r105, new Object[]{IRoom.class, x.class});
        return;
    L9:
        TalkRoomLogUtils.A0(r105, Integer.valueOf(r100), Integer.valueOf(r101));
        goto L10
    L5:
        r106 = "0";
        goto L6
    }

    public static void f(int r100, int r101, String r102, String r103, HashMap r104) {
        Intrinsics.checkNotNullParameter(r102, "functionType");
        Intrinsics.checkNotNullParameter(r103, "returnMethod");
        HashMap r105 = new HashMap();
        if (f563345a == false) goto L5;
        String r106 = "1";
    L6:
        r105.put("is_song_order", r106);
        r105.put("return_method", r103);
        r105.put("trigger_scene", WsConstants.KEY_CONNECTION);
        r105.put("windows_type", "in");
        r105.put("initial_page", "content");
        if (vm2.d.v0() == false) goto L9;
        r105.put("function_type", r102);
        r105.put("function_type2", r102);
    L10:
        r105.putAll(r104);
        j0.l().sendLog("livesdk_mini_window_return_full", r105, new Object[]{IRoom.class, x.class});
        return;
    L9:
        TalkRoomLogUtils.A0(r105, Integer.valueOf(r100), Integer.valueOf(r101));
        goto L10
    L5:
        r106 = "0";
        goto L6
    }
}
