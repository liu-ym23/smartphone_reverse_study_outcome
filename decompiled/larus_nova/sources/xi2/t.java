package xi2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lxi2/t;", "Lcom/bytedance/android/ec/model/g;", "", "", "barCodeList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setBarCodeList", "(Ljava/util/List;)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t extends com.bytedance.android.ec.model.g {

    @SerializedName("barcode")
    private List<String> barCodeList;

    public t() {
    }

    public final List<String> a() {
        return this.barCodeList;
    }
}
