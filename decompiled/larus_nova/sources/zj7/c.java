package zj7;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lzj7/c;", "", "", "sliceSize", "I", "getSliceSize", "()I", "setSliceSize", "(I)V", "socketNum", "getSocketNum", "setSocketNum", "", "traceId", "Ljava/lang/String;", "getTraceId", "()Ljava/lang/String;", "setTraceId", "(Ljava/lang/String;)V", "<init>", "()V", "luckycat-api_release"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("sliceSize")
    private int sliceSize;

    @SerializedName("socketNum")
    private int socketNum;

    @SerializedName("traceId")
    private String traceId;

    public c() {
        this.traceId = "";
    }
}
