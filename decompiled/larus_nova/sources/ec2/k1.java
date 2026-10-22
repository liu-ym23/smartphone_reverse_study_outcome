package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class k1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f472032a = null;

    static {
        f472032a = new k1();
    }

    public k1() {
        Boolean r100 = Boolean.FALSE;
        super("live_useless_frame_task_optimize", "无效FrameTask优化", r100, r100);
    }
}
