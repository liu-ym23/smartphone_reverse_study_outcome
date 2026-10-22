package vo3;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.bytedance.tools.kcp.ultrasettings.runtime.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    @JvmStatic
    public static final void a() {
        ConcurrentHashMap<String, c> r100 = UltraSettingsManager.f271014a;
        Class r101 = Boolean.TYPE;
        UltraSettingsManager.b("revenue_text_piece_parse_opt", new c("revenue_text_piece_parse_opt", Reflection.getOrCreateKotlinClass(r101), "营收的富文本解析耗时优化", "null"));
        UltraSettingsManager.b("enable_initial_props_setting_cache", new c("enable_initial_props_setting_cache", Reflection.getOrCreateKotlinClass(r101), "InitialProps读取setting缓存开关", "null"));
    }

    static {
    }
}
