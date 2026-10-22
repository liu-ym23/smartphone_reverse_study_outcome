package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class h1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f536189a = null;

    static {
        f536189a = new h1();
    }

    public h1() {
        Boolean r100 = Boolean.FALSE;
        super("live_message_start_before_room_enter", "直播消息建连在进房之前", r100, r100);
    }
}
