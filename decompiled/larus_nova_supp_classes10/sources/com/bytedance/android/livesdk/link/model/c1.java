package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/c1;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/api/IBaseBattleSetting;", "", "getInitiatorId", "()Ljava/lang/String;", "getInitiatorId$annotations", "()V", "initiatorId", "", "getFinished", "()J", "getFinished$annotations", "finished", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c1 extends vh7.c<c1>, IBaseBattleSetting {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ String getActivityType();

    /* synthetic */ String getBannerUrl();

    /* synthetic */ IBattleBarConfig getBarConfig();

    /* synthetic */ String getBattleConfig();

    /* synthetic */ IBattleConfigSetting getBattleConfigSetting();

    /* synthetic */ long getBattleId();

    /* synthetic */ int getBattleType();

    /* synthetic */ long getChannelId();

    /* synthetic */ String getDisconnectToastContent();

    /* synthetic */ boolean getDisplayLastResult();

    /* synthetic */ long getDuration();

    @FieldName(name = "finished")
    long getFinished();

    /* synthetic */ IBattleBarConfig getHotsoonBarConfig();

    /* synthetic */ String getHotsoonNotifySchemeUrl();

    @FieldName(name = "initiator_open_id")
    String getInitiatorId();

    /* synthetic */ int getInviteType();

    /* synthetic */ String getLynxData();

    /* synthetic */ long getMatchType();

    /* synthetic */ int getMode();

    /* synthetic */ boolean getNeedCloseLinkmic();

    /* synthetic */ String getNotifySchemeUrl();

    /* synthetic */ int getOptimizeVersion();

    /* synthetic */ List<Integer> getPlayTags();

    /* synthetic */ h3 getPunishConfig();

    /* synthetic */ long getPunishDuration();

    /* synthetic */ boolean getPunishOptimizeOn();

    /* synthetic */ long getPunishStartTimeMs();

    /* synthetic */ long getStartTimeMs();

    /* synthetic */ long getStatusDisplayDuration();

    /* synthetic */ long getStealTowerDuration();

    /* synthetic */ String getTheme();

    /* synthetic */ h3 getTitleConfig();

    /* synthetic */ long get_bloodDisplayDuration();

    /* synthetic */ void setPunishDuration(long r1);
}
