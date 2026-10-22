package r52;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class j4 extends SettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j4 f536204a = null;

    public j4() {
        super("live_toolbar_sync_type", "toolbar动画加载方式，0 线上，1 评论框和toolbar一起出现，2 toolbar占位蒙层", 0, 0);
    }

    static {
        f536204a = new j4();
    }
}
