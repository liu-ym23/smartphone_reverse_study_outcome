package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class a1 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f472002a = null;

    public a1() {
        super("live_privilege_danmaku_emoji_limit", "特权弹幕emoji数量限制", 3, 3);
    }

    static {
        f472002a = new a1();
    }
}
