package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class y1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1 f497326a = null;

    static {
        f497326a = new y1();
    }

    public y1() {
        Boolean r100 = Boolean.TRUE;
        super("live_popup_service_enable", "面板下拉关闭功能开关", r100, r100);
    }
}
