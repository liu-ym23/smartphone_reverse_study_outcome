package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class e1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f472014a = null;

    static {
        f472014a = new e1();
    }

    public e1() {
        Boolean r100 = Boolean.TRUE;
        super("ttlive_public_screen_fading_edge_enable", "公屏区底部遮罩", r100, r100);
    }
}
