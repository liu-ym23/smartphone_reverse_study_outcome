package ec2;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f472021a = null;

    static {
        f472021a = new h();
    }

    public h() {
        Boolean r100 = Boolean.FALSE;
        super("live_answer_question_support_audience", "答题支持观众评论参与", r100, r100);
    }
}
