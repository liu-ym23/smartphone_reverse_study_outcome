package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class c1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f472008a = null;

    static {
        f472008a = new c1();
    }

    public c1() {
        Boolean r100 = Boolean.FALSE;
        super("live_public_screen_degrade_config", "公屏区动画性能降级", r100, r100);
    }
}
