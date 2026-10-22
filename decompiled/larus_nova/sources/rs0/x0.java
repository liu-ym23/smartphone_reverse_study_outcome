package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class x0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f539089a = null;

    static {
        f539089a = new x0();
    }

    public x0() {
        Boolean r100 = Boolean.TRUE;
        super("new_profile_portrait_width_height_regress_enable", "新版资料卡竖屏某些情况下宽高错乱纠正开关", r100, r100);
    }
}
