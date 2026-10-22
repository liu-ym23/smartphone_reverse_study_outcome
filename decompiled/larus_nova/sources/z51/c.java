package z51;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends SettingKey<LiveScreenRecordGuideConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f570049a = null;

    static {
        f570049a = new c();
    }

    public c() {
        super("live_audience_screen_record_guide_config", "观众侧录屏引导发布", new LiveScreenRecordGuideConfig(), new LiveScreenRecordGuideConfig());
    }
}
