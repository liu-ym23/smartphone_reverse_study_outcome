package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class f0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f536176a = null;

    static {
        f536176a = new f0();
    }

    public f0() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_anchor_toolbar_comment", "主播侧底bar上是否允许展示评论入口", r100, r100);
    }
}
