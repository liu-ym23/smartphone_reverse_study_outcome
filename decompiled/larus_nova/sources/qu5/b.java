package qu5;

import android.content.Context;
import android.os.Build;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.framework.utils.ApkUtil;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static Map<String, String> a(Context r100, boolean r101, String r102, String r103, Locale r104) {
        HashMap r105 = new HashMap();
        String r106 = du5.b.c(12) + "-" + r103;
        r105.put("doc-version-code", String.valueOf(ApkUtil.getAppVersionCode(r100)));
        r105.put("doc-version-name", ApkUtil.getAppVersionName(r100));
        r105.put("doc-package-name", AppInfoUtils.b(r100));
        r105.put("doc-platform", r100.getString(R.string.ua_app_name));
        r105.put("doc-biz", r100.getString(R.string.ua_app_name));
        r105.put("doc-os", "Android");
        r105.put("doc-os-version", Build.VERSION.RELEASE);
        r105.put("doc-device-model", AppInfoUtils.a());
        r105.put("doc-channel-id", "0");
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        r105.put("doc-device-id", r102);
        r105.put("called_from", "docs");
        r105.put("User-Agent", AppInfoUtils.c(r100));
        r105.put("request-id", r106);
        r105.put(OkHttpEventListener.X_TT_TRACE_ID, r106);
        r105.put("locale", r104.getLanguage() + "_" + r104.getCountry().toUpperCase());
        if (r101 == false) goto L9;
        com.ss.android.lark.storage.a r107 = ay4.b.f16748a;
        Intrinsics.checkNotNullParameter("debug_config", "name");
        String r108 = r106 + ("#" + ay4.b.b("debug_config", true, ay4.b.a("debug_config")).getString("http_request_id", ""));
        r105.put("request-id", r108);
        r105.put("x-request-id", r108);
    L9:
        return r105;
    }
}
