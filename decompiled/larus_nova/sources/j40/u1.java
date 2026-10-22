package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class u1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f497306a = null;

    static {
        f497306a = new u1();
    }

    public u1() {
        Boolean r100 = Boolean.TRUE;
        super("ttlive_panel_exception_info_enable", "面板异常信息Id抓捕开关", r100, r100);
    }
}
