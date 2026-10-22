package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class h0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f472022a = null;

    static {
        f472022a = new h0();
    }

    public h0() {
        Boolean r100 = Boolean.TRUE;
        super("live_input_panel_enable_activity_emoji", "输入面板是否支持活动表情", r100, r100);
    }
}
