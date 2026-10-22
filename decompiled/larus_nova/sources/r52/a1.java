package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class a1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f536147a = null;

    static {
        f536147a = new a1();
    }

    public a1() {
        Boolean r100 = Boolean.TRUE;
        super("live_mark_highlight_release_stream_enable", "预览高光期间是否可以释放stream权限", r100, r100);
    }
}
