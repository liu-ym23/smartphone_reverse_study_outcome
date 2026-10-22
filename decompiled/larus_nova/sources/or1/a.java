package or1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a, com.bytedance.android.scope.o {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final boolean enable() {
        int r100 = ft1.b.f478750a;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final void a(int r100) {
        ft1.d.d(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final void c(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Map<String, String> r101 = ft1.d.f478752a;
        ft1.d.c(r100, hashCode());
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final Map<String, String> d(Episode r100) {
        Intrinsics.checkNotNullParameter(r100, "episode");
        int r101 = ft1.c.f478751a;
        LinkedHashMap r102 = new LinkedHashMap();
        String r103 = r100.seasonId;     // Catch: Exception -> L36
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        r102.put("live_season_id", r103);     // Catch: Exception -> L36
        r102.put(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID, String.valueOf(r100.roomId));     // Catch: Exception -> L36
        r102.put("live_anchor_id", EpisodeExtKt.getOwnerIdString(r100));     // Catch: Exception -> L36
        EpisodeMod r104 = r100.episodeMod;     // Catch: Exception -> L36
        if (r104 == null) goto L11;
        String r105 = ft1.c.a(Integer.valueOf(r104.episodeStage));     // Catch: Exception -> L36
        if (r105 == null) goto L11;
        r102.put("live_episode_stage", r105);     // Catch: Exception -> L36
    L11:
        EpisodeMod r106 = r100.episodeMod;     // Catch: Exception -> L36
        String r107 = null;
        if (r106 == null) goto L14;
        Integer r108 = Integer.valueOf(r106.episodeSubType);     // Catch: Exception -> L36
    L15:
        int r109 = EpisodeMod.EpisodeSubType.UNKNOWN;     // Catch: Exception -> L36
        if (r108 != null) goto L19;
    L21:
        int r110 = EpisodeMod.EpisodeSubType.NORMAL;     // Catch: Exception -> L36
        if (r108 != null) goto L25;
    L27:
        int r111 = EpisodeMod.EpisodeSubType.GUIDE;     // Catch: Exception -> L36
        if (r108 != null) goto L31;
    L33:
        if (r107 == null) goto L38;
        r102.put("live_episode_sub_type", r107);     // Catch: Exception -> L36
        Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L36
    L38:
        return r102;
    L31:
        if (r108.intValue() != r111) goto L33;
        r107 = "GUIDE";
        goto L33
    L25:
        if (r108.intValue() != r110) goto L27;
        r107 = EffectConstants.NORMAL;
        goto L33
    L19:
        if (r108.intValue() != r109) goto L21;
    L14:
        r108 = null;
    L36:
        e = move-exception;
        ALogger.e("LiveCrashTag", "get episode info map error:" + e.toString());
        Unit r113 = Unit.INSTANCE;
        goto L38
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.a
    public final void f(int r100) {
        ft1.d.a(r100);
    }
}
