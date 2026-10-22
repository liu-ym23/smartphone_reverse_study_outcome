package r52;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class m0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f536218a = null;

    static {
        f536218a = new m0();
    }

    public m0() {
        Boolean r100 = Boolean.TRUE;
        super("live_first_show_backtrack_traceable", "首播回溯消息使用/webcast/im/fetch/traceable/", r100, r100);
    }
}
