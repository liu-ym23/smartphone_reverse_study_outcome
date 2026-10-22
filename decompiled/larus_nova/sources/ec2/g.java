package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f472018a = null;

    static {
        f472018a = new g();
    }

    public g() {
        super("hot_live_message_size", "高热直播间消息数", 80, 80);
    }
}
