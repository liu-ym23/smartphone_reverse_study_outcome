package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class t extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f472057a = null;

    static {
        f472057a = new t();
    }

    public t() {
        Boolean r100 = Boolean.TRUE;
        super("live_danmaku_invalidate_after_render", "弹幕render完后invalidate", r100, r100);
    }
}
