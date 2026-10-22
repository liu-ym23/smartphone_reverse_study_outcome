package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class w2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w2 f561410a = null;

    static {
        f561410a = new w2();
    }

    public w2() {
        Boolean r100 = Boolean.FALSE;
        super("gamecp_detail_enable_all_data_cache", "详情页是否启用第一页数据全量缓存", r100, r100);
    }
}
