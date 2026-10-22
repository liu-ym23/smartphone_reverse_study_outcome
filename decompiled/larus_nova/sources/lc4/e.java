package lc4;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.google.gson.annotations.SerializedName;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes45.dex */
public class e {

    @SerializedName("alg_name")
    public String algName;

    @SerializedName("avg")
    public float average;

    @SerializedName("count")
    public int frameCount;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
    public float max;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
    public float min;

    @SerializedName(CloudControlInf.ROUTE)
    public String route;

    public e() {
    }
}
