package xi2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lxi2/e0;", "Lcom/bytedance/android/ec/model/g;", "", "mStatusMessage", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "mStatusCode", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "", "rewardTextList", "Ljava/util/List;", "c", "()Ljava/util/List;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 extends com.bytedance.android.ec.model.g {

    @SerializedName("Extra")
    private final Map<String, String> extra;

    @SerializedName("StatusCode")
    private final int mStatusCode;

    @SerializedName("StatusMessage")
    private final String mStatusMessage;

    @SerializedName("RewardTexts")
    private final List<String> rewardTextList;

    public e0() {
        this.mStatusCode = -1;
    }

    public final int a() {
        return this.mStatusCode;
    }

    public final String b() {
        return this.mStatusMessage;
    }

    public final List<String> c() {
        return this.rewardTextList;
    }
}
