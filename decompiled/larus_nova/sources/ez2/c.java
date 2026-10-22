package ez2;

import android.webkit.WebView;
import bz2.e;
import com.bytedance.android.monitor.webview.h;
import java.lang.ref.SoftReference;
import org.json.JSONObject;
import py2.k;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SoftReference<WebView> f474844j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f474845k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f474846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONObject f474847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final JSONObject f474848n;

    public c() {
        this.f474847m = new JSONObject();
        this.f474848n = new JSONObject();
    }

    @Override // py2.k, ny2.a
    public final void b(JSONObject r100) {
        super.b(r100);
        e.i(r100, "js_dependency_version", "2.2.1");
        e.i(r100, "native_page", this.f474845k);
        e.i(r100, "webview_type", this.f531015d);
        e.a(r100, this.f474847m);
        e.a(r100, this.f474848n);
        JSONObject r101 = r100.optJSONObject("debug_context");
        if (r101 != null) goto L5;
        r101 = new JSONObject();
        e.h(r100, "debug_context", r101);
    L5:
        h.f162933g.getClass();
        e.h(r101, "is_ttweb_enable", Boolean.FALSE);
    }
}
