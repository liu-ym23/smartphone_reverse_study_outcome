package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class u extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f472060a = null;

    static {
        f472060a = new u();
    }

    public u() {
        Boolean r100 = Boolean.TRUE;
        super("live_danmaku_use_outer_frame_task", "弹幕使用独立的FrameTask", r100, r100);
    }
}
