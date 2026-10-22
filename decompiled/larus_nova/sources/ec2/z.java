package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class z extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f472072a = null;

    static {
        f472072a = new z();
    }

    public z() {
        Boolean r100 = Boolean.FALSE;
        super("live_fix_comment_report_scope", "修复评论举报的范围开关", r100, r100);
    }
}
