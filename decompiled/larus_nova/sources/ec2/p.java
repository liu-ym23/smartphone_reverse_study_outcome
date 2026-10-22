package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class p extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f472045a = null;

    static {
        f472045a = new p();
    }

    public p() {
        super("ttlive_comment_fold_opt_enabled_scroll_speed", "折叠优化开了之后的滚动速度配置", 550, 550);
    }
}
