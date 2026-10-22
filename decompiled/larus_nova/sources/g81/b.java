package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f480369a = null;

    static {
        f480369a = new b();
    }

    public b() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_anchor_info_flip_element", "左上角使用新轮播组件", r100, r100);
    }
}
