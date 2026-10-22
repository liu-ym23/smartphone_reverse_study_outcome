package ma3;

import com.bytedance.android.ec.model.api.LogPbData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lma3/k;", "", "", "statusCode", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "", "statusMsg", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "Lma3/n;", "errorForm", "Lma3/n;", "a", "()Lma3/n;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "yataData", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "e", "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "Lcom/bytedance/android/ec/model/api/LogPbData;", "logPb", "Lcom/bytedance/android/ec/model/api/LogPbData;", "b", "()Lcom/bytedance/android/ec/model/api/LogPbData;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("error_form")
    private final n errorForm;

    @SerializedName("log_pb")
    private final LogPbData logPb;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    @SerializedName("yata_data")
    private final com.bytedance.kmp.ec.yata.common.protocol.data.c yataData;

    public k() {
        this.statusCode = -1;
        this.statusMsg = null;
        this.errorForm = null;
        this.yataData = null;
        this.logPb = null;
    }

    public final n a() {
        return this.errorForm;
    }

    public final LogPbData b() {
        return this.logPb;
    }

    public final Integer c() {
        return this.statusCode;
    }

    public final String d() {
        return this.statusMsg;
    }

    public final com.bytedance.kmp.ec.yata.common.protocol.data.c e() {
        return this.yataData;
    }
}
