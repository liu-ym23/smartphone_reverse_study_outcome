package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class z3 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z3 f536295a = null;

    static {
        f536295a = new z3();
    }

    public z3() {
        Boolean r100 = Boolean.TRUE;
        super("live_quick_comment_enable", "观众端快捷评论开关", r100, r100);
    }
}
