package e01;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Le01/a;", "", "", "compressFormat", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "", "compressQuality", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "d", "(Ljava/lang/Integer;)V", "<init>", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.live_stream.CaptureVideoFrameRequest")
public final class a {

    @SerializedName("compress_format")
    private String compressFormat;

    @SerializedName("compress_quality")
    private Integer compressQuality;

    public a() {
    }

    public final String a() {
        return this.compressFormat;
    }

    public final Integer b() {
        return this.compressQuality;
    }

    public final void c(String r100) {
        this.compressFormat = r100;
    }

    public final void d(Integer r100) {
        this.compressQuality = r100;
    }
}
