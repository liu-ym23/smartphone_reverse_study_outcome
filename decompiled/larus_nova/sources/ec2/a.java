package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends SettingKey<o72.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f472000a = null;

    static {
        f472000a = new a();
    }

    public a() {
        super("live_cold_room_message_config", "低热直播间判断条件", new o72.b(), new o72.b());
    }
}
