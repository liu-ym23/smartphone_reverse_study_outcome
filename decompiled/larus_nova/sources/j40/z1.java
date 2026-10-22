package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class z1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z1 f497331a = null;

    static {
        f497331a = new z1();
    }

    public z1() {
        Boolean r100 = Boolean.TRUE;
        super("live_popup_strategy_setting_enable", "直播气泡管理策略添加功能开关", r100, r100, new String[]{"true:开启", "false:关闭"});
    }
}
