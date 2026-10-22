package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;

/* JADX INFO: loaded from: classes44.dex */
public final class w1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w1 f561409a = null;

    static {
        f561409a = new w1();
    }

    public w1() {
        Boolean r100 = Boolean.TRUE;
        super("game_detail_enable_fresco_slow_bug", "解决fresco动图缓慢的问题", r100, r100);
    }
}
