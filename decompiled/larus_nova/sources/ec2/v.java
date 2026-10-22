package ec2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class v extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f472063a = null;

    static {
        f472063a = new v();
    }

    public v() {
        Boolean r100 = Boolean.FALSE;
        super("live_debug_contour", "画出人像轮廓", r100, r100);
    }
}
