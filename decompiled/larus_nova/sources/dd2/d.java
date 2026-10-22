package dd2;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class d extends Extra {

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    public int maxCount;

    @SerializedName("list")
    public List<e> opStructList;

    @SerializedName("total")
    public int total;

    public d() {
    }
}
