package r43;

import com.bytedance.android.ec.model.api.LogPbData;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.segment.Segment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lr43/f;", "", "", "statusCode", "Ljava/lang/Integer;", "getStatusCode", "()Ljava/lang/Integer;", Segment.JsonKey.START, "getSt", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Lr43/e;", "data", "Lr43/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lr43/e;", "Lcom/bytedance/android/ec/model/api/LogPbData;", "logPb", "Lcom/bytedance/android/ec/model/api/LogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/api/LogPbData;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("data")
    private final e data;

    @SerializedName("log_pb")
    private final LogPbData logPb;

    @SerializedName("msg")
    private final String message;

    /* JADX INFO: renamed from: st, reason: collision with root package name */
    @SerializedName(Segment.JsonKey.START)
    private final Integer f536058st;

    @SerializedName("status_code")
    private final Integer statusCode;

    public f() {
        this(0);
    }

    public final boolean b() {
        Integer r100 = this.statusCode;
        if (r100 != null) goto L6;
    L7:
        Integer r101 = this.f536058st;
        if (r101 != null) goto L11;
    L13:
        return false;
    L11:
        if (r101.intValue() != 0) goto L13;
    L14:
        return true;
    L6:
        if (r100.intValue() == 0) goto L14;
        goto L7
    }

    public final e a() {
        return this.data;
    }

    public f(int r100) {
        this.statusCode = null;
        this.f536058st = null;
        this.message = null;
        this.data = null;
        this.logPb = null;
    }
}
