package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR&\u0010\u0017\u001a\u00060\u0010j\u0002`\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\u00060\u0010j\u0002`\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\b\u001a\u0004\b\u0018\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001b\u0010\u0004R&\u0010!\u001a\u00060\u0010j\u0002`\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\b\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010$\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\b\u001a\u0004\b\"\u0010\u0004R:\u0010+\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&\u0018\u00010%j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&\u0018\u0001`'8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\b\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/y1;", "Lvh7/c;", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getAppId$annotations", "()V", "appId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlKt;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "getStreamUrl$annotations", "streamUrl", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getGameId", "()J", "setGameId", "(J)V", "getGameId$annotations", "gameId", "getGameType", "getGameType$annotations", "gameType", "getLinkExtra", "getLinkExtra$annotations", "linkExtra", "getLinkGameId", "setLinkGameId", "getLinkGameId$annotations", "linkGameId", "getGameExtra", "getGameExtra$annotations", "gameExtra", "", "Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorGameRoleBridge;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getRoleInfos", "()Ljava/util/Map;", "getRoleInfos$annotations", "roleInfos", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y1 extends vh7.c<y1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "app_id")
    String getAppId();

    @FieldName(name = "game_extra")
    String getGameExtra();

    @FieldName(name = "game_id")
    long getGameId();

    @FieldName(name = "game_type")
    long getGameType();

    @FieldName(name = "linker_extra")
    String getLinkExtra();

    @FieldName(name = "link_game_id")
    long getLinkGameId();

    @FieldName(name = "anchor_open_game_role_infos")
    Map<String, IAnchorGameRoleBridge> getRoleInfos();

    @FieldName(name = "stream_url")
    IBaseStreamUrl getStreamUrl();

    @FieldName(name = "app_id#setter")
    void setAppId(String r1);

    @FieldName(name = "game_id#setter")
    void setGameId(long r1);

    @FieldName(name = "link_game_id#setter")
    void setLinkGameId(long r1);
}
