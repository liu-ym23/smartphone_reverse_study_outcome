package g81;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f480370a = null;

    static {
        f480370a = new c();
    }

    public c() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_components_inner_subload", "组件内部分批加载", r100, r100);
    }
}
