package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class j1 extends SettingKey<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f561331a = null;

    static {
        f561331a = new j1();
    }

    public j1() {
        super("gamecp_load_perf_blacklist_nodes", "游戏详情页，fmp监控是否可用", new ArrayList(), new ArrayList());
    }
}
