package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0003-./R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001e\u0010\f\u001a\u00060\u0003j\u0002`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\n\u0010\u0005R\u001a\u0010\u000f\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\r\u0010\u0005R\u001e\u0010\u0013\u001a\u00060\u0003j\u0002`\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u0005R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\u00060\u0003j\u0002`\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001a\u0010\u0005R\u001a\u0010\u001f\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001d\u0010\u0005R\"\u0010$\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\u0007\u001a\u0004\b \u0010\u0005\"\u0004\b!\u0010\"R\"\u0010(\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\u0007\u001a\u0004\b%\u0010\u0005\"\u0004\b&\u0010\"R\"\u0010,\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\u0007\u001a\u0004\b)\u0010\u0005\"\u0004\b*\u0010\"¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSetting;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkMicBattleSetting;", "", "getFinished", "()J", "getFinished$annotations", "()V", "finished", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "getChannelId$annotations", "channelId", "getDuration", "getDuration$annotations", "duration", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/TimeInt64;", "getStartTimeMs", "getStartTimeMs$annotations", "startTimeMs", "", "getTheme", "()Ljava/lang/String;", "getTheme$annotations", "theme", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/BattleId;", "getBattleId", "getBattleId$annotations", "battleId", "getMatchType", "getMatchType$annotations", "matchType", "getPlayMode", "setPlayMode", "(J)V", "getPlayMode$annotations", "playMode", "getTeamMode", "setTeamMode", "getTeamMode$annotations", "teamMode", "getActivityMode", "setActivityMode", "getActivityMode$annotations", "activityMode", "BaseActivityMode", "BasePlayMode", "BaseTeamMode", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkMicBattleSetting extends vh7.e<com.bytedance.android.livesdkapi.depend.model.live.ILinkMicBattleSetting>, com.bytedance.android.livesdkapi.depend.model.live.ILinkMicBattleSetting {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSetting$BaseActivityMode;", "", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "ActivityMode_Empty", "ActivityMode_FlexActivity", "ActivityMode_PkSeason", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BaseActivityMode extends Enum<BaseActivityMode> {
        public static final BaseActivityMode ActivityMode_Empty = null;
        public static final BaseActivityMode ActivityMode_FlexActivity = null;
        public static final BaseActivityMode ActivityMode_PkSeason = null;
        public static final /* synthetic */ BaseActivityMode[] a = null;
        private final int type;

        static {
            BaseActivityMode r1 = new BaseActivityMode("ActivityMode_Empty", 0, 0);
            ActivityMode_Empty = r1;
            BaseActivityMode r2 = new BaseActivityMode("ActivityMode_FlexActivity", 1, 1);
            ActivityMode_FlexActivity = r2;
            BaseActivityMode r3 = new BaseActivityMode("ActivityMode_PkSeason", 2, 2);
            ActivityMode_PkSeason = r3;
            a = new BaseActivityMode[]{r1, r2, r3};
        }

        public static BaseActivityMode valueOf(String r1) {
            return (BaseActivityMode) r27.a.a(BaseActivityMode.class, r1);
        }

        public static BaseActivityMode[] values() {
            return (BaseActivityMode[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public BaseActivityMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSetting$BasePlayMode;", "", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "BattlePlayMode_PK", "BattlePlayMode_SelfPK", "BattlePlayMode_CustomPK", "BattlePlayMode_Vote", "BattlePlayMode_Breakthrough", "BattlePlayMode_Compete", "BattlePlayMode_SpecifyGift", "BattlePlayMode_Season", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BasePlayMode extends Enum<BasePlayMode> {
        public static final BasePlayMode BattlePlayMode_Breakthrough = null;
        public static final BasePlayMode BattlePlayMode_Compete = null;
        public static final BasePlayMode BattlePlayMode_CustomPK = null;
        public static final BasePlayMode BattlePlayMode_PK = null;
        public static final BasePlayMode BattlePlayMode_Season = null;
        public static final BasePlayMode BattlePlayMode_SelfPK = null;
        public static final BasePlayMode BattlePlayMode_SpecifyGift = null;
        public static final BasePlayMode BattlePlayMode_Vote = null;
        public static final /* synthetic */ BasePlayMode[] a = null;
        private final int type;

        public static BasePlayMode valueOf(String r1) {
            return (BasePlayMode) r27.a.a(BasePlayMode.class, r1);
        }

        public static BasePlayMode[] values() {
            return (BasePlayMode[]) a.clone();
        }

        static {
            BasePlayMode r1 = new BasePlayMode("BattlePlayMode_PK", 0, 0);
            BattlePlayMode_PK = r1;
            BasePlayMode r2 = new BasePlayMode("BattlePlayMode_SelfPK", 1, 10);
            BattlePlayMode_SelfPK = r2;
            BasePlayMode r3 = new BasePlayMode("BattlePlayMode_CustomPK", 2, 11);
            BattlePlayMode_CustomPK = r3;
            BasePlayMode r4 = new BasePlayMode("BattlePlayMode_Vote", 3, 101);
            BattlePlayMode_Vote = r4;
            BasePlayMode r5 = new BasePlayMode("BattlePlayMode_Breakthrough", 4, 102);
            BattlePlayMode_Breakthrough = r5;
            BasePlayMode r6 = new BasePlayMode("BattlePlayMode_Compete", 5, 201);
            BattlePlayMode_Compete = r6;
            BasePlayMode r7 = new BasePlayMode("BattlePlayMode_SpecifyGift", 6, MonitorLevel.WARN);
            BattlePlayMode_SpecifyGift = r7;
            BasePlayMode r8 = new BasePlayMode("BattlePlayMode_Season", 7, 501);
            BattlePlayMode_Season = r8;
            a = new BasePlayMode[]{r1, r2, r3, r4, r5, r6, r7, r8};
        }

        public final int getType() {
            return this.type;
        }

        public BasePlayMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleSetting$BaseTeamMode;", "", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "TeamMode_Person", "TeamMode_Team", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BaseTeamMode extends Enum<BaseTeamMode> {
        public static final BaseTeamMode TeamMode_Person = null;
        public static final BaseTeamMode TeamMode_Team = null;
        public static final /* synthetic */ BaseTeamMode[] a = null;
        private final int type;

        static {
            BaseTeamMode r1 = new BaseTeamMode("TeamMode_Person", 0, 0);
            TeamMode_Person = r1;
            BaseTeamMode r2 = new BaseTeamMode("TeamMode_Team", 1, 1);
            TeamMode_Team = r2;
            a = new BaseTeamMode[]{r1, r2};
        }

        public static BaseTeamMode valueOf(String r1) {
            return (BaseTeamMode) r27.a.a(BaseTeamMode.class, r1);
        }

        public static BaseTeamMode[] values() {
            return (BaseTeamMode[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public BaseTeamMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "activity_mode")
    long getActivityMode();

    @FieldName(name = "battle_id")
    long getBattleId();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "finished")
    long getFinished();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "match_type")
    long getMatchType();

    @FieldName(name = "play_mode")
    long getPlayMode();

    @FieldName(name = "start_time_ms")
    long getStartTimeMs();

    @FieldName(name = "team_mode")
    long getTeamMode();

    @FieldName(name = "theme")
    String getTheme();

    @FieldName(name = "activity_mode#setter")
    void setActivityMode(long r1);

    @FieldName(name = "play_mode#setter")
    void setPlayMode(long r1);

    @FieldName(name = "team_mode#setter")
    void setTeamMode(long r1);
}
