package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class a0 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f472001a = null;

    static {
        f472001a = new a0();
    }

    public a0() {
        super("live_force_stop_audio2text_duration", "自动停止语音转文字的时长（单位s）", 300, 300);
    }
}
