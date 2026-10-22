package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class q extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f497284a = null;

    static {
        f497284a = new q();
    }

    public q() {
        Boolean r100 = Boolean.TRUE;
        super("live_display_text_view_invalidate", "高级消息是否开启刷新", r100, r100, false);
    }
}
