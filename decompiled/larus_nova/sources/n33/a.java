package n33;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ln33/a;", "Lr43/a;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "yataData", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", ce.f26391f, "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "h", "(Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;)V", "", "", "", "errorForm", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "setErrorForm", "(Ljava/util/Map;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class a extends r43.a {

    @SerializedName("error_form")
    private Map<String, ? extends Object> errorForm;

    @SerializedName("yata_data")
    private com.bytedance.kmp.ec.yata.common.protocol.data.c yataData;

    public a() {
        this(null, 3);
    }

    public final Map<String, Object> f() {
        return this.errorForm;
    }

    public final com.bytedance.kmp.ec.yata.common.protocol.data.c g() {
        return this.yataData;
    }

    public final void h(com.bytedance.kmp.ec.yata.common.protocol.data.c r100) {
        this.yataData = r100;
    }

    public a(com.bytedance.kmp.ec.yata.common.protocol.data.c r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.yataData = r100;
        this.errorForm = null;
    }
}
