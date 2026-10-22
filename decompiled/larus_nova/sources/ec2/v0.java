package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class v0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f472064a = null;

    static {
        f472064a = new v0();
    }

    public v0() {
        Boolean r100 = Boolean.TRUE;
        super("live_message_log_link_mic_enable", "评论信息内是否包含多人连麦信息", r100, r100);
    }
}
