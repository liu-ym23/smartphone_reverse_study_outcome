package pj1;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.config.ba1;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.minigame.SeiMessage;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.common.utility.Logger;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.bytedance.android.livesdk.room.c<ls2.c> {
    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public e() {
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void i(com.bytedance.android.livesdk.room.b r100) {
        if (r100.f157611t == null) goto L5;
        x6.f114300a = 0;
        x6.f114302c = true;
        x6.f114303d = 1.0f;
        x6.f114304e = false;
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager onExitRoom");
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void s(com.bytedance.android.livesdk.room.b r100) {
        ((yj1.a) r100.b("RoomDataConst_live_room_player_context")).f568057d.getEventHub().getSeiUpdate().observe(r100.f510501h, new d(this, r100));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void u(com.bytedance.android.livesdk.room.b r100) {
        RoomSession r101 = jk1.a.c(r100).f490211d;
        if (r101 == null) goto L5;
        LandscapeLiveMonitor.setCurRoomId(r101.getRoomId());
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public static void z(com.bytedance.android.livesdk.room.b r100, String r101) {
        ik1.c r102 = jk1.a.c(r100);
        if (r102.f490211d.getStreamType() == LiveMode.SCREEN_RECORD) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L13;
        return;
    L13:
        if (ba1.f119852a.getValue().b() == true) goto L17;
        Logger.d("sei_for_mini_game", "小游戏直播已关闭 SEI 消息，不再解析展示");
        return;
    L17:
        if (v.a() == false) goto L19;
        Logger.d("sei_for_mini_game", String.format(Locale.CHINESE, "sei json param=%s", new Object[]{r101}));
    L19:
        if (r103 == false) goto L21;
        if (r101 == null) goto L38;
        if (r101.contains(SeiMessageConst.SEI_KEY_TIMOR_LIVE) == false) goto L39;
        JSONObject r104 = new JSONObject(r101).optJSONObject(SeiMessageConst.SEI_KEY_TIMOR_LIVE);     // Catch: JSONException -> L34
        String r105 = r104.optString("action_type");     // Catch: JSONException -> L34
        int r106 = r104.optInt(SeiMessageConst.MSG_TYPE);     // Catch: JSONException -> L34
        String r107 = r104.optString("msg");     // Catch: JSONException -> L34
        SeiMessage r108 = new SeiMessage(r106, r105, r107);     // Catch: JSONException -> L34
        if (r102.f490211d.getDataCenter() == null) goto L31;
        r102.f490211d.getDataCenter().put("data_sei_message", r108);     // Catch: JSONException -> L34
    L31:
        if (v.a() == false) goto L40;
        Logger.d("sei_for_mini_game", String.format(Locale.CHINESE, "action=%s, type=%d, msg=%s", new Object[]{r105, Integer.valueOf(r106), r107}));     // Catch: JSONException -> L34
        return;
    L40:
        return;
    L39:
        return;
    L41:
        return;
    L38:
        return;
    L21:
        if (v.a() == false) goto L37;
        Logger.d("sei_for_mini_game", "当前不是小游戏直播间，不处理");
        return;
    L37:
        return;
    L5:
        if (r102.f490211d.f110610w == null) goto L9;
        if (TextUtils.equals(r102.f490211d.f110610w.getLivePlatformSource(), "timor_game") == false) goto L9;
        r103 = true;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void t(final com.bytedance.android.livesdk.room.b r100, ts2.f r101) {
        r100.f157617z.add(xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r100), new c()));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
