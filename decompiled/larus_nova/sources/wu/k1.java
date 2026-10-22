package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class k1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f561337a = null;

    static {
        f561337a = new k1();
    }

    public k1() {
        super("gamecp_load_perf_enable", "游戏详情页，fmp监控是否可用", Boolean.FALSE, Boolean.TRUE);
    }
}
