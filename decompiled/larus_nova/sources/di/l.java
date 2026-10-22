package di;

import com.amap.api.col.s.ce;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R$\u0010#\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016¨\u0006("}, d2 = {"Ldi/l;", "", "", "requestLog", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setRequestLog", "(Ljava/lang/String;)V", "Ldi/e;", "metrics", "Ldi/e;", "c", "()Ldi/e;", "setMetrics", "(Ldi/e;)V", "", RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT, "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "setReceivedByteCount", "(Ljava/lang/Long;)V", RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT, "h", "setSentByteCount", "appLevelRequestStart", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAppLevelRequestStart", "beforeAllInterceptors", "b", "setBeforeAllInterceptors", "requestStart", ce.f26391f, "setRequestStart", "requestEnd", "e", "setRequestEnd", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f468712a;

    @SerializedName("appLevelRequestStart")
    private Long appLevelRequestStart;

    @SerializedName("beforeAllInterceptors")
    private Long beforeAllInterceptors;

    @SerializedName("metrics")
    private e metrics;

    @SerializedName(RetrofitMetrics.ExtraKeys.RECEIVED_BYTE_COUNT)
    private Long receivedByteCount;

    @SerializedName("requestEnd")
    private Long requestEnd;

    @SerializedName("requestLog")
    private String requestLog;

    @SerializedName("requestStart")
    private Long requestStart;

    @SerializedName(RetrofitMetrics.ExtraKeys.SENT_BYTE_COUNT)
    private Long sentByteCount;

    public l() {
    }

    public final Long a() {
        return this.appLevelRequestStart;
    }

    public final Long b() {
        return this.beforeAllInterceptors;
    }

    public final e c() {
        return this.metrics;
    }

    public final Long d() {
        return this.receivedByteCount;
    }

    public final Long e() {
        return this.requestEnd;
    }

    public final String f() {
        return this.requestLog;
    }

    public final Long g() {
        return this.requestStart;
    }

    public final Long h() {
        return this.sentByteCount;
    }
}
