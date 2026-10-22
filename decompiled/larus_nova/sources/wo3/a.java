package wo3;

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
        UltraSettingsManager.b("live_kmp_initializer_enable_switch", new c("live_kmp_initializer_enable_switch", Reflection.getOrCreateKotlinClass(Boolean.TYPE), "是否开启KMP Scope 初始化拆分", "lifengji"));
    }

    static {
    }
}
