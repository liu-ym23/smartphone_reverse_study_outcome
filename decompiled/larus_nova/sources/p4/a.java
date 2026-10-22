package p4;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/BaseApiResponse;", "", "errCode", "", "errMsg", "", "logId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getErrCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrMsg", "()Ljava/lang/String;", "getLogId", "isSuccess", "", "()Z", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class a {

    @SerializedName("err_code")
    private final Integer errCode;

    @SerializedName(LocationMonitorConst.ERR_MSG)
    private final String errMsg;

    @SerializedName("log_id")
    private final String logId;

    public a() {
        this(0);
    }

    public final boolean d() {
        Integer r100 = this.errCode;
        if (r100 == null) goto L10;
        if (r100 != null) goto L7;
    L9:
        return false;
    L7:
        if (r100.intValue() != 0) goto L9;
    L10:
        return true;
    }

    public String toString() {
        return "BaseApiResponse(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", logId=" + this.logId + ')';
    }

    public final Integer a() {
        return this.errCode;
    }

    public final String b() {
        return this.errMsg;
    }

    public final String c() {
        return this.logId;
    }

    public a(int r100) {
        this.errCode = null;
        this.errMsg = null;
        this.logId = null;
    }
}
