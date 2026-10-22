package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f472012a = null;

    static {
        f472012a = new e();
    }

    public e() {
        Boolean r100 = Boolean.TRUE;
        super("ec_live_report_comment_slide_down", "上报评论区下滑埋点", r100, r100);
    }
}
