package j40;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class m1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f497262a = null;

    static {
        f497262a = new m1();
    }

    public m1() {
        Boolean r100 = Boolean.TRUE;
        super("live_mini_game_image_load_fix", "小玩法子线程加载图片修复", r100, r100);
    }
}
