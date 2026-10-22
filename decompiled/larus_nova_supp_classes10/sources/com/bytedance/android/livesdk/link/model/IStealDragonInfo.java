package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004$%&'R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010#\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u0004¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo;", "Lvh7/c;", "", "getBattleId", "()Ljava/lang/String;", "getBattleId$annotations", "()V", "battleId", "", "getInitDragonLevel", "()J", "getInitDragonLevel$annotations", "initDragonLevel", "", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$b;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPeriodList", "()Ljava/util/List;", "getPeriodList$annotations", "periodList", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$d;", "getStealInfo", "()Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$d;", "getStealInfo$annotations", "stealInfo", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$c;", "getSettleInfo", "()Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$c;", "getSettleInfo$annotations", "settleInfo", "getUiResource", "getUiResource$annotations", "uiResource", "getLynxData", "getLynxData$annotations", "lynxData", "b", "c", "StealDragonStage", "d", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IStealDragonInfo extends vh7.c<IStealDragonInfo> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$StealDragonStage;", "", "UnknownStage", "Notice", "Steal", "Settle", "Cool", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum StealDragonStage extends Enum<StealDragonStage> {
        public static final StealDragonStage Cool = null;
        public static final StealDragonStage Notice = null;
        public static final StealDragonStage Settle = null;
        public static final StealDragonStage Steal = null;
        public static final StealDragonStage UnknownStage = null;
        public static final /* synthetic */ StealDragonStage[] a = null;

        static {
            StealDragonStage r1 = new StealDragonStage("UnknownStage", 0);
            UnknownStage = r1;
            StealDragonStage r2 = new StealDragonStage("Notice", 1);
            Notice = r2;
            StealDragonStage r3 = new StealDragonStage("Steal", 2);
            Steal = r3;
            StealDragonStage r4 = new StealDragonStage("Settle", 3);
            Settle = r4;
            StealDragonStage r5 = new StealDragonStage("Cool", 4);
            Cool = r5;
            a = new StealDragonStage[]{r1, r2, r3, r4, r5};
        }

        public static StealDragonStage valueOf(String r1) {
            return (StealDragonStage) r27.a.a(StealDragonStage.class, r1);
        }

        public static StealDragonStage[] values() {
            return (StealDragonStage[]) a.clone();
        }

        public StealDragonStage(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$b;", "Lvh7/c;", "", "getStage", "()I", "getStage$annotations", "()V", "stage", "", "getStart_time_sec", "()J", "getStart_time_sec$annotations", "start_time_sec", "getDuration_sec", "getDuration_sec$annotations", "duration_sec", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "duration_sec")
        long getDuration_sec();

        @FieldName(name = "stage")
        int getStage();

        @FieldName(name = "start_time_sec")
        long getStart_time_sec();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$c;", "Lvh7/c;", "", "getCur_top_anchor_id", "()Ljava/lang/String;", "getCur_top_anchor_id$annotations", "()V", "cur_top_anchor_id", "", "getDragonLevel", "()J", "getDragonLevel$annotations", "dragonLevel", "getCur_top_anchor_open_id", "getCur_top_anchor_open_id$annotations", "cur_top_anchor_open_id", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.c<c> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "cur_top_anchor_id")
        String getCur_top_anchor_id();

        @FieldName(name = "cur_top_anchor_open_id")
        String getCur_top_anchor_open_id();

        @FieldName(name = "dragon_level")
        long getDragonLevel();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0012\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$d;", "Lvh7/c;", "", "getCur_top_anchor_id", "()Ljava/lang/String;", "getCur_top_anchor_id$annotations", "()V", "cur_top_anchor_id", "", "getVersion", "()J", "getVersion$annotations", "version", "getDragonLevel", "getDragonLevel$annotations", "dragonLevel", "getCur_top_anchor_open_id", "getCur_top_anchor_open_id$annotations", "cur_top_anchor_open_id", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface d extends vh7.c<d> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "cur_top_anchor_id")
        String getCur_top_anchor_id();

        @FieldName(name = "cur_top_anchor_open_id")
        String getCur_top_anchor_open_id();

        @FieldName(name = "dragon_level")
        long getDragonLevel();

        @FieldName(name = "version")
        long getVersion();
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "battle_id")
    String getBattleId();

    @FieldName(name = "init_dragon_level")
    long getInitDragonLevel();

    @FieldName(name = "lynx_data")
    String getLynxData();

    @FieldName(name = "period_list")
    List<b> getPeriodList();

    @FieldName(name = "settle_info")
    c getSettleInfo();

    @FieldName(name = "steal_info")
    d getStealInfo();

    @FieldName(name = "ui_resource")
    String getUiResource();
}
