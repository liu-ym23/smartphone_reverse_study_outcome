package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class j0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f536200a = null;

    static {
        f536200a = new j0();
    }

    public j0() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_load_history_v2", "历史评论功能客户端兜底开关", r100, r100);
    }
}
