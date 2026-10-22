package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class i1 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f472026a = null;

    static {
        f472026a = new i1();
    }

    public i1() {
        super("live_message_display_track_interval", "公屏区消息展现上报埋点时间间隔", 60, 60);
    }
}
