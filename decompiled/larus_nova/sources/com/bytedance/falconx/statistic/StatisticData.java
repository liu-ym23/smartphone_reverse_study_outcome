package com.bytedance.falconx.statistic;

import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class StatisticData {
    public static final String ERROR_CODE_IO_ERROR = "101";
    public static final String ERROR_CODE_NOT_FOUND = "100";

    @SerializedName("common")
    public Common mCommon;

    @SerializedName(OperationName.OPERATION_OFFLINE_AVAILABLE)
    public List<InterceptorModel> offline;

    public StatisticData() {
    }
}
