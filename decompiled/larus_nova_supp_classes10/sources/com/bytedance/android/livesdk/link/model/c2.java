package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R&\u0010\u000b\u001a\u00060\u0003j\u0002`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\u0010\u001a\u00060\u0003j\u0002`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\n\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\n\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/c2;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/v;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "()J", "setChannelId", "(J)V", "getChannelId$annotations", "()V", "channelId", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/BattleId;", "getBattleId", "setBattleId", "getBattleId$annotations", "battleId", "", "getReverseInfo", "()Ljava/lang/String;", "setReverseInfo", "(Ljava/lang/String;)V", "getReverseInfo$annotations", "reverseInfo", "getBattlePowerContainerInfo", "setBattlePowerContainerInfo", "getBattlePowerContainerInfo$annotations", "battlePowerContainerInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c2 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.v>, com.bytedance.android.livesdk.link.model.bridge.v {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_id")
    long getBattleId();

    @FieldName(name = "container")
    String getBattlePowerContainerInfo();

    @FieldName(name = "channel_id")
    long getChannelId();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "reverse_info")
    String getReverseInfo();

    @FieldName(name = "battle_id#setter")
    void setBattleId(long r1);

    @FieldName(name = "container#setter")
    void setBattlePowerContainerInfo(String r1);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r1);

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r1);

    @FieldName(name = "reverse_info#setter")
    void setReverseInfo(String r1);
}
