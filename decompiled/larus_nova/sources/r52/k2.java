package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class k2 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k2 f536208a = null;

    static {
        f536208a = new k2();
    }

    public k2() {
        Boolean r100 = Boolean.TRUE;
        super("live_ai_clone_enable", "ai进公屏功能总开关", r100, r100);
    }
}
