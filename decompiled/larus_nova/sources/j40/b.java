package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f497169a = null;

    static {
        f497169a = new b();
    }

    public b() {
        Boolean r100 = Boolean.FALSE;
        super("disable_enter_effect_in_pk_mode", "PK场景下是否禁用进场特效", r100, r100);
    }
}
