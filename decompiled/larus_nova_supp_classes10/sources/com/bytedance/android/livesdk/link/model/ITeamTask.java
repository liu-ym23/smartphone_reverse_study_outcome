package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0006\u0017\u0018\u0019\u001a\u001b\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR:\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask;", "Lvh7/c;", "", "getTriggerUid", "()Ljava/lang/String;", "getTriggerUid$annotations", "()V", "triggerUid", "Lcom/bytedance/android/livesdk/link/model/q9;", "getTeamTaskConfig", "()Lcom/bytedance/android/livesdk/link/model/q9;", "getTeamTaskConfig$annotations", "teamTaskConfig", "", "Lcom/bytedance/android/livesdk/link/model/r9;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getTeamTaskInfoMap", "()Ljava/util/Map;", "getTeamTaskInfoMap$annotations", "teamTaskInfoMap", "getBattleId", "getBattleId$annotations", "battleId", "Period", "Result", "RewardTeamTaskType", "Role", "TargetTeamTaskType", "Type", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ITeamTask extends vh7.c<ITeamTask> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$Period;", "", "PeriodUndefined", "PeriodTips", "PeriodNotice", "PeriodTask", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Period extends Enum<Period> {
        public static final Period PeriodNotice = null;
        public static final Period PeriodTask = null;
        public static final Period PeriodTips = null;
        public static final Period PeriodUndefined = null;
        public static final /* synthetic */ Period[] a = null;

        static {
            Period r1 = new Period("PeriodUndefined", 0);
            PeriodUndefined = r1;
            Period r2 = new Period("PeriodTips", 1);
            PeriodTips = r2;
            Period r3 = new Period("PeriodNotice", 2);
            PeriodNotice = r3;
            Period r4 = new Period("PeriodTask", 3);
            PeriodTask = r4;
            a = new Period[]{r1, r2, r3, r4};
        }

        public static Period valueOf(String r1) {
            return (Period) r27.a.a(Period.class, r1);
        }

        public static Period[] values() {
            return (Period[]) a.clone();
        }

        public Period(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$Result;", "", "ResultUndefined", "ResultSuccess", "ResultFailed", "ResultNotUpdate", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Result extends Enum<Result> {
        public static final Result ResultFailed = null;
        public static final Result ResultNotUpdate = null;
        public static final Result ResultSuccess = null;
        public static final Result ResultUndefined = null;
        public static final /* synthetic */ Result[] a = null;

        static {
            Result r1 = new Result("ResultUndefined", 0);
            ResultUndefined = r1;
            Result r2 = new Result("ResultSuccess", 1);
            ResultSuccess = r2;
            Result r3 = new Result("ResultFailed", 2);
            ResultFailed = r3;
            Result r4 = new Result("ResultNotUpdate", 3);
            ResultNotUpdate = r4;
            a = new Result[]{r1, r2, r3, r4};
        }

        public static Result valueOf(String r1) {
            return (Result) r27.a.a(Result.class, r1);
        }

        public static Result[] values() {
            return (Result[]) a.clone();
        }

        public Result(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$RewardTeamTaskType;", "", "RewardUndefined", "InstantKill", "BonusBattleScore", "MultipleBattleScore", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RewardTeamTaskType extends Enum<RewardTeamTaskType> {
        public static final RewardTeamTaskType BonusBattleScore = null;
        public static final RewardTeamTaskType InstantKill = null;
        public static final RewardTeamTaskType MultipleBattleScore = null;
        public static final RewardTeamTaskType RewardUndefined = null;
        public static final /* synthetic */ RewardTeamTaskType[] a = null;

        static {
            RewardTeamTaskType r1 = new RewardTeamTaskType("RewardUndefined", 0);
            RewardUndefined = r1;
            RewardTeamTaskType r2 = new RewardTeamTaskType("InstantKill", 1);
            InstantKill = r2;
            RewardTeamTaskType r3 = new RewardTeamTaskType("BonusBattleScore", 2);
            BonusBattleScore = r3;
            RewardTeamTaskType r4 = new RewardTeamTaskType("MultipleBattleScore", 3);
            MultipleBattleScore = r4;
            a = new RewardTeamTaskType[]{r1, r2, r3, r4};
        }

        public static RewardTeamTaskType valueOf(String r1) {
            return (RewardTeamTaskType) r27.a.a(RewardTeamTaskType.class, r1);
        }

        public static RewardTeamTaskType[] values() {
            return (RewardTeamTaskType[]) a.clone();
        }

        public RewardTeamTaskType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$Role;", "", "RoleUndefined", "RoleAttacker", "RoleDefender", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Role extends Enum<Role> {
        public static final Role RoleAttacker = null;
        public static final Role RoleDefender = null;
        public static final Role RoleUndefined = null;
        public static final /* synthetic */ Role[] a = null;

        static {
            Role r1 = new Role("RoleUndefined", 0);
            RoleUndefined = r1;
            Role r2 = new Role("RoleAttacker", 1);
            RoleAttacker = r2;
            Role r3 = new Role("RoleDefender", 2);
            RoleDefender = r3;
            a = new Role[]{r1, r2, r3};
        }

        public static Role valueOf(String r1) {
            return (Role) r27.a.a(Role.class, r1);
        }

        public static Role[] values() {
            return (Role[]) a.clone();
        }

        public Role(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$TargetTeamTaskType;", "", "TargetUndefined", "UserCount", "FansUserCount", "BattleScoreCount", "BattleScoreRatio", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TargetTeamTaskType extends Enum<TargetTeamTaskType> {
        public static final TargetTeamTaskType BattleScoreCount = null;
        public static final TargetTeamTaskType BattleScoreRatio = null;
        public static final TargetTeamTaskType FansUserCount = null;
        public static final TargetTeamTaskType TargetUndefined = null;
        public static final TargetTeamTaskType UserCount = null;
        public static final /* synthetic */ TargetTeamTaskType[] a = null;

        static {
            TargetTeamTaskType r1 = new TargetTeamTaskType("TargetUndefined", 0);
            TargetUndefined = r1;
            TargetTeamTaskType r2 = new TargetTeamTaskType("UserCount", 1);
            UserCount = r2;
            TargetTeamTaskType r3 = new TargetTeamTaskType("FansUserCount", 2);
            FansUserCount = r3;
            TargetTeamTaskType r4 = new TargetTeamTaskType("BattleScoreCount", 3);
            BattleScoreCount = r4;
            TargetTeamTaskType r5 = new TargetTeamTaskType("BattleScoreRatio", 4);
            BattleScoreRatio = r5;
            a = new TargetTeamTaskType[]{r1, r2, r3, r4, r5};
        }

        public static TargetTeamTaskType valueOf(String r1) {
            return (TargetTeamTaskType) r27.a.a(TargetTeamTaskType.class, r1);
        }

        public static TargetTeamTaskType[] values() {
            return (TargetTeamTaskType[]) a.clone();
        }

        public TargetTeamTaskType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTask$Type;", "", "TypeUndefined", "TypeUserCount", "TypeScoreCount", "TypeInstantKill", "TypeFansClubUserCount", "TypeSpecialGiftCount", "TypeTaskCard", "TypeSummitInstantKill", "TypeConfigurableTask", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Type extends Enum<Type> {
        public static final Type TypeConfigurableTask = null;
        public static final Type TypeFansClubUserCount = null;
        public static final Type TypeInstantKill = null;
        public static final Type TypeScoreCount = null;
        public static final Type TypeSpecialGiftCount = null;
        public static final Type TypeSummitInstantKill = null;
        public static final Type TypeTaskCard = null;
        public static final Type TypeUndefined = null;
        public static final Type TypeUserCount = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r1 = new Type("TypeUndefined", 0);
            TypeUndefined = r1;
            Type r2 = new Type("TypeUserCount", 1);
            TypeUserCount = r2;
            Type r3 = new Type("TypeScoreCount", 2);
            TypeScoreCount = r3;
            Type r4 = new Type("TypeInstantKill", 3);
            TypeInstantKill = r4;
            Type r5 = new Type("TypeFansClubUserCount", 4);
            TypeFansClubUserCount = r5;
            Type r6 = new Type("TypeSpecialGiftCount", 5);
            TypeSpecialGiftCount = r6;
            Type r7 = new Type("TypeTaskCard", 6);
            TypeTaskCard = r7;
            Type r8 = new Type("TypeSummitInstantKill", 7);
            TypeSummitInstantKill = r8;
            Type r9 = new Type("TypeConfigurableTask", 8);
            TypeConfigurableTask = r9;
            a = new Type[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_id")
    String getBattleId();

    @FieldName(name = "config")
    q9 getTeamTaskConfig();

    @FieldName(name = LocationMonitorConst.INFO)
    Map<String, r9> getTeamTaskInfoMap();

    @FieldName(name = "trigger_open_id")
    String getTriggerUid();
}
