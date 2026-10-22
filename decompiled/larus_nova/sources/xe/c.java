package xe;

import com.bytedance.android.ec.base.api.ai.GuiContext;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.MiniAppConfig;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public interface c {

    public static final class a {
        public static Map a() {
            IECAIHostService.Companion.getClass();
            MiniAppConfig r100 = IECAIHostService.a.a().getMiniAppConfig();
            if (r100 != null) goto L7;
            return null;
        L7:
            return MapsKt.mapOf(TuplesKt.to("miniapp_appkey", r100.getAppKey()));
        }

        public static Map b() {
            IECAIHostService.Companion.getClass();
            MiniAppConfig r100 = IECAIHostService.a.a().getMiniAppConfig();
            if (r100 != null) goto L7;
            return null;
        L7:
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("app_name", r100.getAppName()), TuplesKt.to("app_key", r100.getAppKey()), TuplesKt.to("app_type", r100.getAppType())});
        }
    }

    GuiContext a(Map<String, String> r100);

    String b();

    boolean c();

    Map<String, String> getExtra();

    Map<String, String> getLogExtra();

    String getPageName();

    Integer getSource();

    String m();
}
