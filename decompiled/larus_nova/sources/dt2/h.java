package dt2;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends SettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f470002a = null;

    static {
        f470002a = new h();
    }

    public h() {
        super("saas_mock_item_log_pb_string_content", String.class, "SaaS 模拟内流专门进房参数下发，用在埋点和电商（itemlogpb）.仅线下mock使用，线上为空，不关注内容.", "", "");
    }
}
