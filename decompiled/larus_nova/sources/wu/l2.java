package wu;

import com.bytedance.android.gamecp.common.setting.SettingKey;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
public final class l2 extends SettingKey<Map<String, com.bytedance.android.gamecp.common.setting.config.l2>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l2 f561344a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"wu/l2$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/gamecp/common/setting/config/l2;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, com.bytedance.android.gamecp.common.setting.config.l2>> {
        public a() {
        }
    }

    static {
        f561344a = new l2();
    }

    public l2() {
        super("live_cooperation_partner_explain_card_config", new a().getType(), new HashMap());
    }
}
