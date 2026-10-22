package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f472015a = null;

    static {
        f472015a = new f();
    }

    public f() {
        Boolean r100 = Boolean.TRUE;
        super("enable_live_emoji_comment", "是否开启表情评论", r100, r100);
    }
}
