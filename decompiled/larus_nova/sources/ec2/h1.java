package ec2;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class h1 extends SettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f472023a = null;

    static {
        f472023a = new h1();
    }

    public h1() {
        super("live_public_screen_message_buffer_filter_list", "不进入公屏消息缓存的消息类型", new ArrayList(), new ArrayList());
    }
}
