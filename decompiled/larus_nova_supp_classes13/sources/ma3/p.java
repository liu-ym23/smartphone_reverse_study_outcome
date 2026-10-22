package ma3;

import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.StatusCode;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lma3/p;", "", "", "statusCode", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "st", "c", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Lma3/o;", "data", "Lma3/o;", "a", "()Lma3/o;", "Lcom/bytedance/android/ec/model/api/LogPbData;", "logPb", "Lcom/bytedance/android/ec/model/api/LogPbData;", "b", "()Lcom/bytedance/android/ec/model/api/LogPbData;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("data")
    private final o data;

    @SerializedName("log_pb")
    private final LogPbData logPb;

    @SerializedName("msg")
    private final String message;

    @SerializedName("st")
    private final Integer st;

    @SerializedName("status_code")
    private final Integer statusCode;

    public final boolean e() {
        Integer r0 = this.statusCode;
        StatusCode r1 = StatusCode.OK;
        int r2 = r1.getValue();
        if (r0 != null) goto L6;
    L7:
        Integer r3 = this.st;
        int r4 = r1.getValue();
        if (r3 != null) goto L11;
    L13:
        return false;
    L11:
        if (r3.intValue() != r4) goto L13;
    L14:
        return true;
    L6:
        if (r0.intValue() == r2) goto L14;
        goto L7
    }

    public p() {
        this.statusCode = null;
        this.st = null;
        this.message = null;
        this.data = null;
        this.logPb = null;
    }

    public final o a() {
        return this.data;
    }

    public final LogPbData b() {
        return this.logPb;
    }

    public final Integer c() {
        return this.st;
    }

    public final Integer d() {
        return this.statusCode;
    }
}
