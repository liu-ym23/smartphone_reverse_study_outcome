package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f536158a = null;

    static {
        f536158a = new c0();
    }

    public c0() {
        Boolean r100 = Boolean.TRUE;
        super("live_danmaku_setting_enable", "横屏弹幕模式是否开启弹幕设置开关", r100, r100);
    }
}
