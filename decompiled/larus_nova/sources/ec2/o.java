package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class o extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f472042a = null;

    static {
        f472042a = new o();
    }

    public o() {
        super("ttlive_comment_fold_time_ms", "公屏折叠的阈值控制ms", 500, 500);
    }
}
