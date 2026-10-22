package ma3;

import com.bytedance.android.shopping.buynow.data.remote.LogPB;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lma3/b;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/a;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "yataData", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "i", "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "j", "(Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;)V", "Lla3/d;", "errorForm", "Lla3/d;", "g", "()Lla3/d;", "Lcom/bytedance/android/shopping/buynow/data/remote/LogPB;", "logPb", "Lcom/bytedance/android/shopping/buynow/data/remote/LogPB;", "h", "()Lcom/bytedance/android/shopping/buynow/data/remote/LogPB;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends com.bytedance.kmp.ec.yata.common.protocol.data.a {

    @SerializedName("error_form")
    private final la3.d errorForm;

    @SerializedName("log_pb")
    private final LogPB logPb;

    @SerializedName("yata_data")
    private com.bytedance.kmp.ec.yata.common.protocol.data.c yataData;

    public b() {
        this(null, 7);
    }

    public final la3.d g() {
        return this.errorForm;
    }

    public final LogPB h() {
        return this.logPb;
    }

    public final com.bytedance.kmp.ec.yata.common.protocol.data.c i() {
        return this.yataData;
    }

    public final void j(com.bytedance.kmp.ec.yata.common.protocol.data.c r1) {
        this.yataData = r1;
    }

    public b(com.bytedance.kmp.ec.yata.common.protocol.data.c r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this.yataData = r2;
        this.errorForm = null;
        this.logPb = null;
    }
}
