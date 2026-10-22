package z51;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f570048a = null;

    static {
        f570048a = new b();
    }

    public b() {
        Boolean r100 = Boolean.TRUE;
        super("live_record_publish_release_stream_enable", "录屏发布预览期间是否可以释放stream权限", r100, r100);
    }
}
