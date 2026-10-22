package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class s extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f472054a = null;

    static {
        f472054a = new s();
    }

    public s() {
        super("live_comment_words_count_limit", "评论最大字数限制", 50, 50);
    }
}
