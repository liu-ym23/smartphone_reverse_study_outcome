package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class r extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f539076a = null;

    static {
        f539076a = new r();
    }

    public r() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_profile_dialog_memory_leak_enable", "是否修复资料卡面板内存泄漏", r100, r100);
    }
}
