package tf0;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.api.FailedBinderCallBack;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Ltf0/r;", "", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "strategyName", "c", "strategyConfig", "getStrategyConfig", FailedBinderCallBack.CALLER_ID, "b", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class r {

    @SerializedName("action_type")
    private final String actionType;

    @SerializedName("call_id")
    private final String callId;

    @SerializedName("strategy_biz")
    private final String strategyConfig;

    @SerializedName("strategy_name")
    private final String strategyName;

    public final String toString() {
        return "PerfRegisterConfig(actionType='" + this.actionType + "', strategyName='" + this.strategyName + "', strategyConfig='" + this.strategyConfig + "', callId='" + this.callId + "')";
    }

    public final String a() {
        return this.actionType;
    }

    public final String b() {
        return this.callId;
    }

    public final String c() {
        return this.strategyName;
    }
}
