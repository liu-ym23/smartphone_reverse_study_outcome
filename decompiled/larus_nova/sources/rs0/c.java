package rs0;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends SettingKey<Map<String, ? extends List<? extends Float>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f539046a = null;

    static {
        f539046a = new c();
    }

    public c() {
        super("live_parallax_avatar_frame_map", "资料卡装扮面板埋点的点击区域", new LinkedHashMap(), new LinkedHashMap());
    }
}
