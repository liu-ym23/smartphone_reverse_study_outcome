package ev1;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class i extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f474219a = null;

    static {
        f474219a = new i();
    }

    public i() {
        Boolean r100 = Boolean.FALSE;
        super("live_dsl_ignore_debug_view", "隐藏dsl debug view", r100, r100);
    }
}
