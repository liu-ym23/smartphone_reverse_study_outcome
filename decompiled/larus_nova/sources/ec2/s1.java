package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class s1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1 f472056a = null;

    static {
        f472056a = new s1();
    }

    public s1() {
        Boolean r100 = Boolean.TRUE;
        super("suppress_gift_text_messages", "开启时根据 Room 字段决定是否不展示评论区礼物消息，关闭时永远展示", r100, r100);
    }
}
