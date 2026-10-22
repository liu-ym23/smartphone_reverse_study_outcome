package hq9;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/CreationDownloaderConfig;", "", "callbackTimeoutMs", "", DBDefinition.RETRY_COUNT, "", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "Ljava/lang/Long;", "Ljava/lang/Integer;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t0 {

    @SerializedName("callback_timeout_ms")
    public final Long callbackTimeoutMs;

    @SerializedName("retry_count")
    public final Integer retryCount;

    public t0() {
        this(0);
    }

    public /* synthetic */ t0(int r100) {
        this(null, 3);
    }

    public t0(Long r100, Integer r101) {
        this.callbackTimeoutMs = r100;
        this.retryCount = r101;
    }
}
