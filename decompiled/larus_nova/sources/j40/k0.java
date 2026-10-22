package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class k0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f497249a = null;

    static {
        f497249a = new k0();
    }

    public k0() {
        Boolean r100 = Boolean.FALSE;
        super("live_follow_anchorself_enable", "主播观看自己直播间，不展示关注按钮", r100, r100);
    }
}
