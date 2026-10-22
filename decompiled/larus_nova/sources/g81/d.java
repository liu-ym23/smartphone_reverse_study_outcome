package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class d extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f480371a = null;

    static {
        f480371a = new d();
    }

    public d() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_room_indicator_countdown", "房间人气加成倒计时", r100, r100);
    }
}
