package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class l0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f497255a = null;

    static {
        l0 r100 = new l0();
        f497255a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public l0() {
        Boolean r100 = Boolean.FALSE;
        super("live_follow_cover_pre_pullstream", "关注天窗首次滑动预拉流优化", r100, r100, new String[]{"true:使用预拉流", "false:不使用预拉流"});
    }
}
