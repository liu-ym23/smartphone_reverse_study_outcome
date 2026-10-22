package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class m extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f539066a = null;

    static {
        f539066a = new m();
    }

    public m() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_profile_fans_group_create", "资料卡中是否可展示粉丝群管理和创建", r100, r100, true);
    }
}
