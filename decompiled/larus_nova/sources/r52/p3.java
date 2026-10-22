package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class p3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p3 f536239a = null;

    static {
        f536239a = new p3();
    }

    public p3() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_post_processor_enable", "公屏宽高调整启用PostProcessor", r100, r100);
    }
}
