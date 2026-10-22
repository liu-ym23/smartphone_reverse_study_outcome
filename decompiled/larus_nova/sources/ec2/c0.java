package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f472007a = null;

    static {
        f472007a = new c0();
    }

    public c0() {
        Boolean r100 = Boolean.TRUE;
        super("live_ignore_comment_arg_illegal_check_intercept", "跳过评论非法参数检测", r100, r100);
    }
}
