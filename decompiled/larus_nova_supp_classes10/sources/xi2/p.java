package xi2;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class p extends com.bytedance.android.ec.model.g {

    @SerializedName("allow_set_coupons")
    public boolean allowSetCoupons;

    @SerializedName("countdown")
    public long countdown;

    @SerializedName("im_content")
    public JsonObject imContent;

    @SerializedName("im_ext")
    public JsonObject imExt;

    @SerializedName("server_time")
    public long serverTime;

    public p() {
    }
}
