package rs0;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class s extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f539078a = null;

    static {
        f539078a = new s();
    }

    public s() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_profile_launcher_memory_leak_enable", "是否修复资料卡launcher内存泄漏", r100, r100);
    }
}
