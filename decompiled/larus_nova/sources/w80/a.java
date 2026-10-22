package w80;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.adapter.internal.CommonCode;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class a {

    @SerializedName(EventConstant.Key.AGE_LARGER_14)
    public int ageLargerFourteen;

    @SerializedName("api_request_params")
    public Map<String, String> apiRequestParams;

    @SerializedName(LocationMonitorConst.CERT_TOKEN)
    public String certToken;

    @SerializedName("cert_type")
    public int certType;

    @SerializedName("children_cert_token")
    public String childrenCertToken;

    @SerializedName("merchant_id")
    public String merchantId;

    @SerializedName("msg")
    public String message;

    @SerializedName("status_code")
    public int statusCode;

    @SerializedName("ticket")
    public String ticket;

    @SerializedName(CommonCode.MapKey.TRANSACTION_ID)
    public String transactionId;

    @SerializedName("url")
    public String url;

    @SerializedName("verified_page_source")
    public String verifiedPageSource;

    @SerializedName("youth_cert_scene")
    public int youthCertScene;

    @SerializedName("zhima_token")
    public String zhimaToken;

    public a() {
    }
}
