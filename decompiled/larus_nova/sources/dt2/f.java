package dt2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f470000a = null;

    static {
        f470000a = new f();
    }

    public f() {
        Boolean r100 = Boolean.TRUE;
        super("live_vs_remove_order_value", "vslog增加对order的处理", r100, r100);
    }
}
