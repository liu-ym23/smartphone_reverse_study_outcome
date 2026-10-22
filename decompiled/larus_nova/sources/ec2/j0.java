package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class j0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f472028a = null;

    static {
        f472028a = new j0();
    }

    public j0() {
        Boolean r100 = Boolean.TRUE;
        super("live_input_panel_remove_repeat_live_event", "输入面板移除多余的liveEvent回调", r100, r100);
    }
}
