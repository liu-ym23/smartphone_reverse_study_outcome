package kq9;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/larus/platform/model/album/CreationImageUploadReuseConfig;", "", "enableReusePreprocessResult", "", "maxCount", "", "version", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEnableReusePreprocessResult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVersion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("enable_reuse_preprocess_result")
    private final Boolean enableReusePreprocessResult;

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    private final Integer maxCount;

    @SerializedName("version")
    private final Integer version;

    public h() {
        this(0);
    }

    public final Boolean a() {
        return this.enableReusePreprocessResult;
    }

    public final Integer b() {
        return this.maxCount;
    }

    public final Integer c() {
        return this.version;
    }

    public h(int r100) {
        this.enableReusePreprocessResult = Boolean.FALSE;
        this.maxCount = 50;
        this.version = null;
    }
}
