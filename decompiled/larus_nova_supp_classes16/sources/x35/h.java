package x35;

import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public final com.bytedance.ee.bear.contract.d a;
    public final String b;
    public final String c;
    public final Map<String, Long> d;
    public final boolean e;
    public final boolean f;
    public String g;

    public h(com.bytedance.ee.bear.contract.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mAnalytics");
        Intrinsics.checkNotNullParameter(r3, "versionType");
        this.a = r2;
        this.b = r3;
        this.c = "StageReport";
        this.d = new LinkedHashMap();
        Lazy r4 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(null);
        this.e = false;
        this.f = ((Boolean) new ml5.b("debug_config").a("show_cache_toast", Boolean.FALSE)).booleanValue();
        this.g = "";
    }
}
