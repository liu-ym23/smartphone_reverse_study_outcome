package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class u0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u0 f536266a = null;

    static {
        f536266a = new u0();
    }

    public u0() {
        Boolean r100 = Boolean.FALSE;
        super("live_input_panel_enable_mention_list", "输入面板是否支持触发mention列表", r100, r100);
    }
}
