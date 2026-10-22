package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class n1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n1 f472041a = null;

    static {
        f472041a = new n1();
    }

    public n1() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_muliti_reopen", "VR多机位重新打开", r100, r100);
    }
}
