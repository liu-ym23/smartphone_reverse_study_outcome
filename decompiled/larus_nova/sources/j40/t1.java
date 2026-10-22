package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class t1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t1 f497301a = null;

    static {
        f497301a = new t1();
    }

    public t1() {
        Boolean r100 = Boolean.TRUE;
        super("live_paid_scope_lazy_init", "付费Scope服务按需加载", r100, r100);
    }
}
