package ue2;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r6, String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r9, "requestPage");
        Intrinsics.checkNotNullParameter(r10, "ktvMidiRecordScene");
        ReadOnlyProperty r0 = h.I0;
        KProperty[] r1 = h.a;
        String r4 = null;
        String r3 = (String) ((Map) r0.getValue(null, r1[85])).get("high_score_song_list_schema");
        if (r3 != null) goto L5;
        r3 = "sslocal://webcast_lynxview?type=popup&gravity=bottom&rate_height=480&hide_loading=0&show_error=1&radius=12/";
    L5:
        u6 r5 = new u6(r3);
        String r2 = (String) ((Map) r0.getValue(null, r1[85])).get("high_score_song_list_url");
        if (r2 != null) goto L8;
        r2 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_ktv_lynx_douyin/pages/high_score_song_list/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=linkmiccharge";
    L8:
        r5.b("url", r2);
        u6 r11 = r5.d("url");
        IBaseUser r12 = k.n(IMiddlewareUserService.class).user().b();
        r11.b("query_user_name", r7);
        r11.b("query_user_id", r8);
        r11.b("ktv_midi_record_scene", r10);
        r11.b("self_user_id", r12.getIdString().toString());
        r11.b("request_page", r9);
        o r13 = o3.f();
        if (r13 == null) goto L17;
        m r14 = r13.getRoom();
        if (r14 == null) goto L17;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L17;
        String r16 = String.valueOf(r15.getLiveRoomMode());
        if (r16 == null) goto L17;
        r11.b("live_room_mode", r16);
    L17:
        Long r17 = KtvLoggerHelper.a;
        r11.b("play_mode", KtvLoggerHelper.E());
        o r18 = o3.f();
        if (r18 == null) goto L22;
        m r19 = r18.getRoom();
        if (r19 == null) goto L22;
        IRoom r20 = (IRoom) r19.getValue();
    L23:
        LinkedHashMap r21 = new LinkedHashMap();
        if (r20 == null) goto L26;
        Long r22 = Long.valueOf(r20.getId());
    L27:
        r21.put("room_id", String.valueOf(r22));
        if (r20 == null) goto L30;
        r4 = r20.getOwnerUserIdString();
    L30:
        r21.put("anchor_id", String.valueOf(r4));
        i r23 = k.n(IInteractService.class).getLinkUserInfoCenter();
        if (r23 == null) goto L34;
        String r24 = String.valueOf(r23.b());
        if (r24 == null) goto L34;
    L35:
        r21.put("user_cnt", r24);
        r21.put("action_from", "start");
        r21.put("function_type", k.n(IInteractService.class).getCurrentFunctionType());
        if (r20 != null) goto L38;
    L40:
        String r25 = "video_live";
    L41:
        r21.put("live_type", r25);
        Iterator r26 = r21.entrySet().iterator();
    L43:
        if (r26.hasNext() == false) goto L45;
        Map.Entry r27 = (Map.Entry) r26.next();
        r11.b((String) r27.getKey(), (String) r27.getValue());
        goto L43
    L45:
        k.n(IBaseLiveActionHandler.class).handle(r6, r5.c());
        return;
    L38:
        if (r20.isLiveTypeAudio() != true) goto L40;
        r25 = "voice_live";
    L34:
        r24 = BDLocationException.ERROR_TIMEOUT;
        goto L35
    L26:
        r22 = null;
    L22:
        r20 = null;
        goto L23
    }
}
