package ef1;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* JADX INFO: loaded from: classes7.dex */
public class d extends Extra {

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    private int maxCount;

    public d() {
    }

    public final int a() {
        return this.maxCount;
    }
}
