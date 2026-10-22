package x35;

import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import otb.n;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f562356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f562358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f562359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f562360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f562361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f562362g;

    public h(com.bytedance.ee.bear.contract.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mAnalytics");
        Intrinsics.checkNotNullParameter(r101, "versionType");
        this.f562356a = r100;
        this.f562357b = r101;
        this.f562358c = "StageReport";
        this.f562359d = new LinkedHashMap();
        Lazy<n> r102 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(null);
        this.f562360e = false;
        this.f562361f = ((Boolean) new ml5.b("debug_config").a("show_cache_toast", Boolean.FALSE)).booleanValue();
        this.f562362g = "";
    }
}
