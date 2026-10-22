package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class m extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f472036a = null;

    static {
        f472036a = new m();
    }

    public m() {
        Boolean r100 = Boolean.FALSE;
        super("live_carnival_message_mock_support", "收到CarnivalMessage时不校验seqId", r100, r100);
    }
}
