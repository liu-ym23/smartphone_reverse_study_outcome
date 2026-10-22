package xi2;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lxi2/w;", "", "", "Lxi2/f0;", "titleList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setTitleList", "(Ljava/util/List;)V", "", "cycle", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setCycle", "(J)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "linkIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setLinkIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "businessId", "getBusinessId", "setBusinessId", "Lxi2/m0;", "extra", "Lxi2/m0;", "b", "()Lxi2/m0;", "setExtra", "(Lxi2/m0;)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID)
    private long businessId;

    @SerializedName("cycle")
    private long cycle;

    @SerializedName("extra")
    private m0 extra;

    @SerializedName("link_icon")
    private ECUrlModel linkIcon;

    @SerializedName("titles")
    private List<f0> titleList;

    public w() {
    }

    public final long a() {
        return this.cycle;
    }

    public final m0 b() {
        return this.extra;
    }

    public final ECUrlModel c() {
        return this.linkIcon;
    }

    public final List<f0> d() {
        return this.titleList;
    }
}
