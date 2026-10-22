package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class a3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a3 f536149a = null;

    static {
        f536149a = new a3();
    }

    public a3() {
        Boolean r100 = Boolean.FALSE;
        super("live_public_screen_enable_focus_when_move", "公屏上划停止自动滚动开关", r100, r100);
    }
}
