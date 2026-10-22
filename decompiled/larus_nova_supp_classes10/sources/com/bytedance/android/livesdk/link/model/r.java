package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u000201R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011RB\u0010\u001c\u001a*\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014j\u0014\u0012\b\u0012\u00060\u0015j\u0002`\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010!\u001a\u00060\u0015j\u0002`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\b\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010&\u001a\u00020\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\b\u001a\u0004\b#\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010'8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\b\u001a\u0004\b(\u0010)R.\u0010/\u001a\u0016\u0012\u0004\u0012\u00020,\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020,\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\b\u001a\u0004\b-\u0010\u0006¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/r;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/p;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkUsers", "()Ljava/util/List;", "getLinkUsers$annotations", "()V", "linkUsers", "Lcom/bytedance/android/livesdk/link/model/c3;", "getBattleStatsMeta", "()Lcom/bytedance/android/livesdk/link/model/c3;", "getBattleStatsMeta$annotations", "battleStatsMeta", "Lcom/bytedance/android/livesdk/link/model/s5;", "getLinkStatsMeta", "()Lcom/bytedance/android/livesdk/link/model/s5;", "getLinkStatsMeta$annotations", "linkStatsMeta", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "Lcom/bytedance/android/livesdk/link/model/b9;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkerContentMap", "()Ljava/util/Map;", "getLinkerContentMap$annotations", "linkerContentMap", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/VersionNum;", "getVersion", "()J", "getVersion$annotations", "version", "Lcom/bytedance/android/livesdk/link/model/r$b;", "getBizExtra", "()Lcom/bytedance/android/livesdk/link/model/r$b;", "getBizExtra$annotations", "bizExtra", "Lcom/bytedance/android/livesdk/link/model/z;", "getAudioPunishInfo", "()Lcom/bytedance/android/livesdk/link/model/z;", "getAudioPunishInfo$annotations", "audioPunishInfo", "Lcom/bytedance/android/livesdk/link/model/e;", "getAiAssistantList", "getAiAssistantList$annotations", "aiAssistantList", "b", "c", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r extends vh7.c<r> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/r$b;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/e0;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.e0>, com.bytedance.android.livesdk.link.model.bridge.e0 {
        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        /* synthetic */ Object getFlexInstance();

        @FieldName(name = "open_game")
        /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.y1 getOpenGameInfo();

        @FieldName(name = "open_game#setter")
        /* synthetic */ void setOpenGameInfo(com.bytedance.android.livesdk.link.model.bridge.y1 r1);
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/r$c;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/y1;", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.y1>, com.bytedance.android.livesdk.link.model.bridge.y1 {
        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "app_id")
        /* synthetic */ String getAppId();

        /* synthetic */ Object getFlexInstance();

        @FieldName(name = "game_extra")
        /* synthetic */ String getGameExtra();

        @FieldName(name = "game_id")
        /* synthetic */ long getGameId();

        @FieldName(name = "game_type")
        /* synthetic */ long getGameType();

        @FieldName(name = "linker_extra")
        /* synthetic */ String getLinkExtra();

        @FieldName(name = "link_game_id")
        /* synthetic */ long getLinkGameId();

        @FieldName(name = "anchor_open_game_role_infos")
        /* synthetic */ Map<String, IAnchorGameRoleBridge> getRoleInfos();

        @FieldName(name = "stream_url")
        /* synthetic */ IBaseStreamUrl getStreamUrl();

        @FieldName(name = "app_id#setter")
        /* synthetic */ void setAppId(String r1);

        @FieldName(name = "game_id#setter")
        /* synthetic */ void setGameId(long r1);

        @FieldName(name = "link_game_id#setter")
        /* synthetic */ void setLinkGameId(long r1);
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "ai_assistants")
    List<e> getAiAssistantList();

    @FieldName(name = "audio_punish_info")
    z getAudioPunishInfo();

    @FieldName(name = "battle_stats")
    c3 getBattleStatsMeta();

    @FieldName(name = "extra")
    b getBizExtra();

    @FieldName(name = "linker_stats")
    s5 getLinkStatsMeta();

    @FieldName(name = "user")
    List<p> getLinkUsers();

    @FieldName(name = "linker_content_map")
    Map<Long, b9> getLinkerContentMap();

    @FieldName(name = "version")
    long getVersion();
}
