package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomLinkInfoBase;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001e\u0010\u000e\u001a\u00060\tj\u0002`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016R.\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/a9;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomLinkInfoBase;", "", "getGuestId", "()Ljava/lang/String;", "getGuestId$annotations", "()V", "guestId", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "()J", "getChannelId$annotations", "channelId", "Lcom/bytedance/android/livesdk/link/model/i5;", "getChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/i5;", "getChannelInfo$annotations", "channelInfo", "Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSetting;", "getBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSetting;", "getBattleSetting$annotations", "battleSetting", "", "Lcom/bytedance/android/livesdk/link/model/f5;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getBattleScorePairList", "()Ljava/util/List;", "getBattleScorePairList$annotations", "battleScorePairList", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a9 extends vh7.e<IRoomLinkInfoBase>, IRoomLinkInfoBase {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_scores")
    List<f5> getBattleScorePairList();

    @FieldName(name = "battle_settings")
    ILinkMicBattleSetting getBattleSetting();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "channel_info")
    i5 getChannelInfo();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "rival_anchor_open_id")
    String getGuestId();
}
