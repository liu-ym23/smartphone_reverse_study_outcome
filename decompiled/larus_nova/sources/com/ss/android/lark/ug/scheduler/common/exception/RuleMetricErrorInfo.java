package com.ss.android.lark.ug.scheduler.common.exception;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r9c.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/common/exception/RuleMetricErrorInfo;", "Lcom/ss/android/lark/ug/scheduler/common/exception/SchedulerMetricInfo;", "", "code", "", "message", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "MISS_META_RULE", "MISS_EXP_OPERATOR", "ILLEGAL_THRESHOLD", "MISS_LEFT_RULE_ACTION", "MISS_CURRENT_VALUE", "getErrorCode", "getErrorMessage", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RuleMetricErrorInfo extends Enum<RuleMetricErrorInfo> implements a {
    public static final RuleMetricErrorInfo ILLEGAL_THRESHOLD = null;
    public static final RuleMetricErrorInfo MISS_CURRENT_VALUE = null;
    public static final RuleMetricErrorInfo MISS_EXP_OPERATOR = null;
    public static final RuleMetricErrorInfo MISS_LEFT_RULE_ACTION = null;
    public static final RuleMetricErrorInfo MISS_META_RULE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RuleMetricErrorInfo[] f444463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444464b = null;
    private final String code;
    private final String message;

    public static EnumEntries<RuleMetricErrorInfo> getEntries() {
        return f444464b;
    }

    static {
        RuleMetricErrorInfo r100 = new RuleMetricErrorInfo("MISS_META_RULE", 0, BDLocationException.ERROR_UID_IS_EMPTY, "expression tree no meta rule!");
        MISS_META_RULE = r100;
        RuleMetricErrorInfo r101 = new RuleMetricErrorInfo("MISS_EXP_OPERATOR", 1, IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX, "expression tree no exp operator!");
        MISS_EXP_OPERATOR = r101;
        RuleMetricErrorInfo r102 = new RuleMetricErrorInfo("ILLEGAL_THRESHOLD", 2, "104", "expression tree invalid threshold value!");
        ILLEGAL_THRESHOLD = r102;
        RuleMetricErrorInfo r103 = new RuleMetricErrorInfo("MISS_LEFT_RULE_ACTION", 3, "105", "expression tree no ruleAction!");
        MISS_LEFT_RULE_ACTION = r103;
        RuleMetricErrorInfo r104 = new RuleMetricErrorInfo("MISS_CURRENT_VALUE", 4, BDLocationException.ERROR_BLUETOOTh_NOT_AVAILABLE, "current value not exists!");
        MISS_CURRENT_VALUE = r104;
        RuleMetricErrorInfo[] r105 = {r100, r101, r102, r103, r104};
        f444463a = r105;
        f444464b = EnumEntriesKt.enumEntries(r105);
    }

    public static RuleMetricErrorInfo[] values() {
        return (RuleMetricErrorInfo[]) f444463a.clone();
    }

    @Override // r9c.a
    public String getErrorCode() {
        return this.code;
    }

    @Override // r9c.a
    public String getErrorMessage() {
        return this.message;
    }

    public static RuleMetricErrorInfo valueOf(String r100) {
        return (RuleMetricErrorInfo) r27.a.a(RuleMetricErrorInfo.class, r100);
    }

    public RuleMetricErrorInfo(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.message = r103;
    }
}
