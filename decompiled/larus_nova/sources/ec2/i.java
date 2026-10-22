package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f472024a = null;

    static {
        f472024a = new i();
    }

    public i() {
        super("live_message_voice_comment_duration", "直播间语音评论配置", 15, 15);
    }
}
