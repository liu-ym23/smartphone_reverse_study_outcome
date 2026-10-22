package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class j1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j1 f472029a = null;

    static {
        f472029a = new j1();
    }

    public j1() {
        Boolean r100 = Boolean.FALSE;
        super("live_render_opt", "直播绘制优化", r100, r100);
    }
}
