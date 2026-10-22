package dt2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends SettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f470001a = null;

    static {
        f470001a = new g();
    }

    public g() {
        super("saas_mock_ad_raw_string_content", String.class, "SaaS 模拟内流广告数据下发.仅线下mock使用，线上为空，不关注内容.", "", "");
    }
}
