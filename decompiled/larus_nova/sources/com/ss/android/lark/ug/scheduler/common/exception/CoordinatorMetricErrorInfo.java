package com.ss.android.lark.ug.scheduler.common.exception;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r9c.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/common/exception/CoordinatorMetricErrorInfo;", "Lcom/ss/android/lark/ug/scheduler/common/exception/SchedulerMetricInfo;", "", "code", "", "message", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "INVALID_DATA", "MISS_NODE", "MISS_SCENARIO", "CYCLIC_GRAPH", "UNKNOWN", "getErrorCode", "getErrorMessage", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CoordinatorMetricErrorInfo extends Enum<CoordinatorMetricErrorInfo> implements a {
    public static final CoordinatorMetricErrorInfo CYCLIC_GRAPH = null;
    public static final CoordinatorMetricErrorInfo INVALID_DATA = null;
    public static final CoordinatorMetricErrorInfo MISS_NODE = null;
    public static final CoordinatorMetricErrorInfo MISS_SCENARIO = null;
    public static final CoordinatorMetricErrorInfo UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CoordinatorMetricErrorInfo[] f444461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444462b = null;
    private final String code;
    private final String message;

    public static EnumEntries<CoordinatorMetricErrorInfo> getEntries() {
        return f444462b;
    }

    static {
        CoordinatorMetricErrorInfo r100 = new CoordinatorMetricErrorInfo("INVALID_DATA", 0, "101", "ug entity data is invalid!");
        INVALID_DATA = r100;
        CoordinatorMetricErrorInfo r101 = new CoordinatorMetricErrorInfo("MISS_NODE", 1, BDLocationException.ERROR_UID_IS_EMPTY, "ug node in missed!");
        MISS_NODE = r101;
        CoordinatorMetricErrorInfo r102 = new CoordinatorMetricErrorInfo("MISS_SCENARIO", 2, IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX, "scenario missed!");
        MISS_SCENARIO = r102;
        CoordinatorMetricErrorInfo r103 = new CoordinatorMetricErrorInfo("CYCLIC_GRAPH", 3, "201", "there is circle dependency in graph!");
        CYCLIC_GRAPH = r103;
        CoordinatorMetricErrorInfo r104 = new CoordinatorMetricErrorInfo("UNKNOWN", 4, "500", "other error.");
        UNKNOWN = r104;
        CoordinatorMetricErrorInfo[] r105 = {r100, r101, r102, r103, r104};
        f444461a = r105;
        f444462b = EnumEntriesKt.enumEntries(r105);
    }

    public static CoordinatorMetricErrorInfo[] values() {
        return (CoordinatorMetricErrorInfo[]) f444461a.clone();
    }

    @Override // r9c.a
    public String getErrorCode() {
        return this.code;
    }

    @Override // r9c.a
    public String getErrorMessage() {
        return this.message;
    }

    public static CoordinatorMetricErrorInfo valueOf(String r100) {
        return (CoordinatorMetricErrorInfo) r27.a.a(CoordinatorMetricErrorInfo.class, r100);
    }

    public CoordinatorMetricErrorInfo(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.message = r103;
    }
}
