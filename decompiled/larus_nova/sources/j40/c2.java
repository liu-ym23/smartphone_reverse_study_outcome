package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;

/* JADX INFO: loaded from: classes45.dex */
public final class c2 extends SettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c2 f497178a = null;

    static {
        f497178a = new c2();
    }

    public c2() {
        super("live_privacy_room_uid_log_prefix", "隐私直播间上报uid埋点前缀", SchemaHandlerHostConstants.WEBCAST_SCHEMA_HOST);
    }
}
