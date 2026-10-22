package di;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Ldi/n;", "", "", "code", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "receivedBytes", "c", "setReceivedBytes", "sentBytes", "d", "setSentBytes", "connectionInfo", "b", "setConnectionInfo", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("code")
    private Integer code;

    @SerializedName("connection_info")
    private Integer connectionInfo;

    @SerializedName(StreamTrafficObservable.STREAM_RECEIVEDBYTES)
    private Integer receivedBytes;

    @SerializedName(StreamTrafficObservable.STREAM_SENTBYTES)
    private Integer sentBytes;

    public n() {
    }

    public final Integer a() {
        return this.code;
    }

    public final Integer b() {
        return this.connectionInfo;
    }

    public final Integer c() {
        return this.receivedBytes;
    }

    public final Integer d() {
        return this.sentBytes;
    }
}
