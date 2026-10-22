package rd3;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lrd3/n;", "", "", "Lrd3/p;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Lrd3/e;", "extra", "Lrd3/e;", "getExtra", "()Lrd3/e;", "Lrd3/m;", "extraV2", "Lrd3/m;", "getExtraV2", "()Lrd3/m;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "base", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "getBase", "()Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("base")
    private final CommerceBaseResponse base;

    @SerializedName("extra")
    private final e extra;

    @SerializedName("extra_v2")
    private final m extraV2;

    @SerializedName("items")
    private final List<p> items;

    public n() {
    }
}
