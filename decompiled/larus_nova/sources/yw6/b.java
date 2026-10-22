package yw6;

import com.bytedance.apm.constant.UploadTypeInf;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lyw6/b;", "Lyw6/x;", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "logId", "getLogId", "apiPath", "getApiPath", "responseBody", "getResponseBody", "params", "getParams", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b extends x {

    @SerializedName("api_path")
    private final String apiPath;

    @SerializedName("error_msg")
    private final String errorMsg;

    @SerializedName("log_id")
    private final String logId;

    @SerializedName("params")
    private final String params;

    @SerializedName("response_body")
    private final String responseBody;

    public b() {
        super(UploadTypeInf.API_ERROR, 6);
        this.errorMsg = null;
        this.logId = null;
        this.apiPath = null;
        this.responseBody = null;
        this.params = null;
    }
}
