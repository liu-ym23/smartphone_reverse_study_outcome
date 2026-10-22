package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class p0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f472046a = null;

    static {
        f472046a = new p0();
    }

    public p0() {
        Boolean r100 = Boolean.TRUE;
        super("live_interaction_open_more_use_datacenter", "是否使用datacenter打开更多面板", r100, r100);
    }
}
