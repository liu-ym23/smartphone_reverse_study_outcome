package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;

/* JADX INFO: loaded from: classes45.dex */
public final class e3 extends SettingKey<String[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e3 f497191a = null;

    static {
        f497191a = new e3();
    }

    public e3() {
        super("live_strategy_handle_room_async_array", "handle room 异步列表", new String[]{"float_video_resolution", GearStrategy.GEAR_STRATEGY_KEY_VIDEO_RESOLUTION, "preview_video_resolution", "resolution_memory_enable", "small_window_resolution", "float_video_resolution_inner", "use_new_resolution"}, new String[]{"float_video_resolution", GearStrategy.GEAR_STRATEGY_KEY_VIDEO_RESOLUTION, "preview_video_resolution", "resolution_memory_enable", "small_window_resolution", "float_video_resolution_inner", "use_new_resolution"});
    }
}
