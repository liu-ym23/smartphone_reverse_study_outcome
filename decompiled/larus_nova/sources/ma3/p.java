package ma3;

import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.StatusCode;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.segment.Segment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lma3/p;", "", "", "statusCode", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", Segment.JsonKey.START, "c", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Lma3/o;", "data", "Lma3/o;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lma3/o;", "Lcom/bytedance/android/ec/model/api/LogPbData;", "logPb", "Lcom/bytedance/android/ec/model/api/LogPbData;", "b", "()Lcom/bytedance/android/ec/model/api/LogPbData;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("data")
    private final o data;

    @SerializedName("log_pb")
    private final LogPbData logPb;

    @SerializedName("msg")
    private final String message;

    /* JADX INFO: renamed from: st, reason: collision with root package name */
    @SerializedName(Segment.JsonKey.START)
    private final Integer f512687st;

    @SerializedName("status_code")
    private final Integer statusCode;

    public final boolean e() {
        Integer r100 = this.statusCode;
        StatusCode r101 = StatusCode.OK;
        int r102 = r101.getValue();
        if (r100 != null) goto L6;
    L7:
        Integer r103 = this.f512687st;
        int r104 = r101.getValue();
        if (r103 != null) goto L11;
    L13:
        return false;
    L11:
        if (r103.intValue() != r104) goto L13;
    L14:
        return true;
    L6:
        if (r100.intValue() == r102) goto L14;
        goto L7
    }

    public p() {
        this.statusCode = null;
        this.f512687st = null;
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
        return this.f512687st;
    }

    public final Integer d() {
        return this.statusCode;
    }
}
