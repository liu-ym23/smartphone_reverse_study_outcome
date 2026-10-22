package ku1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f506186a = null;

    static {
        f506186a = new h();
    }

    public h() {
        Boolean r100 = Boolean.FALSE;
        super("live_strategy_write_sp_optimize", "存SP放到异步线程", r100, r100);
    }
}
