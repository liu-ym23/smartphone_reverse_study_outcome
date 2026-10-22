package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class x0 extends SettingKey<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f561414a = null;

    static {
        f561414a = new x0();
    }

    public x0() {
        super("gamecp_detail_preload_diff_filter_keys", "游戏详情页预加载新老数据diff过滤条件", new ArrayList(), new ArrayList());
    }
}
