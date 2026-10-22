package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class n extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f539068a = null;

    static {
        f539068a = new n();
    }

    public n() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_profile_owner_center", "资料卡中是否可展示个人中心", r100, r100, true);
    }
}
