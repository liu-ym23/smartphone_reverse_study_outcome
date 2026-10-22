package xi2;

import com.bytedance.android.livesdk.livecommerce.network.response.ECEnterRequestData;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lxi2/s;", "Lcom/bytedance/android/ec/model/g;", "", "code", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEnterRequestData;", "data", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEnterRequestData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEnterRequestData;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s extends com.bytedance.android.ec.model.g {

    @SerializedName("code")
    private final String code;

    @SerializedName("data")
    private final ECEnterRequestData data;

    public s() {
    }

    public final ECEnterRequestData a() {
        return this.data;
    }
}
