package us1;

import com.bytedance.android.livesdk.config.link.SwitchCameraFrequencyConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes8.dex */
@JsonAdapter(SwitchCameraFrequencyConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lus1/c;", "Lvh7/j;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends j<c> {

    @JsonAdapter(SwitchCameraFrequencyConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    int getMaxCount();

    @FieldName(name = "cd_time")
    int p8();

    @FieldName(name = "gap_time")
    int z2();
}
