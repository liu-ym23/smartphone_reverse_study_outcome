package nq1;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends SSettingKey<oq1.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f520089a = null;

    static {
        f520089a = new a();
    }

    public a() {
        super("live_vs_interact_multi_instance_fix", "互动组件存在多个WebView实例修复", new oq1.b(), new oq1.b());
    }
}
