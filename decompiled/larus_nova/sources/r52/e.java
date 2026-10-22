package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f536169a = null;

    public e() {
        super("live_anchor_mention_message_show_style", "主播侧mention消息展示方式 0: 不做差异化，1: mention消息展示后公屏刷新降速 2:置顶展示", 0, 0);
    }

    static {
        f536169a = new e();
    }
}
