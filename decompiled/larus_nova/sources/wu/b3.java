package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class b3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b3 f561285a = null;

    static {
        f561285a = new b3();
    }

    public b3() {
        super("game_detail_pad_adapt", "是否开启详情页ipad优化", Boolean.FALSE, Boolean.TRUE);
    }
}
