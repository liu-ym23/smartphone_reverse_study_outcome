package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class b3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b3 f536155a = null;

    static {
        f536155a = new b3();
    }

    public b3() {
        Boolean r100 = Boolean.FALSE;
        super("live_public_screen_enable_update_when_height_change", "公屏高度变化时更新数据", r100, r100);
    }
}
