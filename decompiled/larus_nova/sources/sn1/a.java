package sn1;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f542649a = null;

    static {
        f542649a = new a();
    }

    public a() {
        Boolean r100 = Boolean.TRUE;
        super("live_vs_multi_camera_optimize_fold_screen", "折叠屏手机多机位入口移动到Toolbar", r100, r100);
    }
}
