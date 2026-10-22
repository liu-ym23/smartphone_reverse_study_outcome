package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class j2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j2 f497245a = null;

    static {
        f497245a = new j2();
    }

    public j2() {
        Boolean r100 = Boolean.TRUE;
        super("live_replay_clear_back_stack", "跳转回放清除直播套娃返回逻辑", r100, r100);
    }
}
