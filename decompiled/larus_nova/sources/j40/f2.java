package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class f2 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f2 f497196a = null;

    static {
        f497196a = new f2();
    }

    public f2() {
        Boolean r100 = Boolean.TRUE;
        super("live_read_preview_params_in_schema_enable", "直播间内读取schema字段后再放置到bundle中的端上兜底开关", r100, r100);
    }
}
