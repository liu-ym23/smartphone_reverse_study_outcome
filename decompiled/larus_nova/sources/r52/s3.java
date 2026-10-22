package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class s3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s3 f536257a = null;

    static {
        f536257a = new s3();
    }

    public s3() {
        Boolean r100 = Boolean.FALSE;
        super("live_public_screen_show_new_hot_msg_tray", "公屏展示新热评托盘开关", r100, r100);
    }
}
