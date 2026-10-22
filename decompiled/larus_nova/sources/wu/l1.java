package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class l1 extends SettingKey<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l1 f561343a = null;

    static {
        f561343a = new l1();
    }

    public l1() {
        super("gamecp_load_perf_fmplist_nodes", "游戏详情页真实fmp监控，包含图片加载时长", new ArrayList(), new ArrayList());
    }
}
