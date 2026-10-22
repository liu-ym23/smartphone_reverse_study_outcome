package ec2;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class o1 extends SettingKey<List<? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o1 f472044a = null;

    static {
        f472044a = new o1();
    }

    public o1() {
        super("live_word_associate_ban_list", "直播间禁止文字联想的评论类型", new ArrayList(), new ArrayList());
    }
}
