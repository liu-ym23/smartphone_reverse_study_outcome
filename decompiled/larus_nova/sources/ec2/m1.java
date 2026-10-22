package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class m1 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f472038a = null;

    static {
        f472038a = new m1();
    }

    public m1() {
        super("live_user_enter_queue_max_count", "飘屏消息新逻辑队列最大长度", 100, 100);
    }
}
