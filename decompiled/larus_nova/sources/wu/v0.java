package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class v0 extends SettingKey<Map<String, String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f561402a = null;

    static {
        f561402a = new v0();
    }

    public v0() {
        super("gamecp_lynx_preload_card_ids_map", "游戏详情页lynx卡片id与schema映射关系", new HashMap(), new HashMap());
    }
}
