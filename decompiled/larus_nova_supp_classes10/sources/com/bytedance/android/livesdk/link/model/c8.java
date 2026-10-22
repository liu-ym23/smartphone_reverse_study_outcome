package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002&'R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001e\u0010\u000e\u001a\u00060\tj\u0002`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u001a\u001a\u00060\tj\u0002`\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0007\u001a\u0004\b\u0018\u0010\fR:\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0007\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b\"\u0010\u0014¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/link/model/c8;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/f2;", "", "getScoreUpdateType", "()I", "getScoreUpdateType$annotations", "()V", "scoreUpdateType", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/TimeInt64;", "getLinkStartTime", "()J", "getLinkStartTime$annotations", "linkStartTime", "getInteractionScoreStatus", "getInteractionScoreStatus$annotations", "interactionScoreStatus", "", "getExtraJson", "()Ljava/lang/String;", "getExtraJson$annotations", "extraJson", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "getChannelId$annotations", "channelId", "", "Lcom/bytedance/android/livesdk/link/model/b8;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getAnchorInfoMap", "()Ljava/util/Map;", "getAnchorInfoMap$annotations", "anchorInfoMap", "getGameExtraJson", "getGameExtraJson$annotations", "gameExtraJson", "Companion", "a", "c", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c8 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.f2>, com.bytedance.android.livesdk.link.model.bridge.f2 {
    public static final a Companion = null;
    public static final int SCORE_STATUS_CLOSE = 2;
    public static final int SCORE_STATUS_PENALTY_END = 0;
    public static final int SCORE_STATUS_UPDATE = 1;
    public static final int SCORE_UPDATE_TYPE_ACTIVE = 1;
    public static final int SCORE_UPDATE_TYPE_PASSIVE = 2;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    public static final class c {
        public String a;
        public String b;

        public c() {
            this.b = "";
        }
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "open_anchor_infos")
    Map<String, b8> getAnchorInfoMap();

    @FieldName(name = "channel_id")
    long getChannelId();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @FieldName(name = "extra")
    String getExtraJson();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "game_extra")
    String getGameExtraJson();

    @FieldName(name = "interaction_score_status")
    int getInteractionScoreStatus();

    @FieldName(name = "start_time")
    long getLinkStartTime();

    @FieldName(name = "interaction_score_action")
    int getScoreUpdateType();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);
}
