package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f472009a = null;

    static {
        f472009a = new d();
    }

    public d() {
        Boolean r100 = Boolean.TRUE;
        super("ec_live_report_comment_slide_append_component_type", "评论区滑动埋点补充挂载组件类型", r100, r100);
    }
}
