package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class n2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n2 f497269a = null;

    static {
        f497269a = new n2();
    }

    public n2() {
        Boolean r100 = Boolean.FALSE;
        super("live_saas_toolbar_interact_entrance_enable", "直播 saas 完全同构适配是否展示互动 toolbar 入口, 不影响非 saas", r100, r100);
    }
}
