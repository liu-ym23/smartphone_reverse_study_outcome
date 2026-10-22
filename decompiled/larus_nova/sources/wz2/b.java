package wz2;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.webview.cache.impl.WebNativeCommon;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends vz2.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f561920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f561921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f561922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f561923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f561924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f561925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f561926j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f561927k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f561928l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f561929m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final JSONObject f561930n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Set<String> f561931o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONObject f561932p;

    public class a extends fz2.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f561933b;

        public a(b r100) {
            this.f561933b = r100;
            super("performance");
        }

        @Override // fz2.a
        public final void fillInJsonObject(JSONObject r100) {
            l.o(r100, "page_start", this.f561933b.f561921e);
            l.o(r100, "page_finish", this.f561933b.f561922f);
            l.o(r100, "page_progress_100", this.f561933b.f561923g);
            l.o(r100, "show_start", this.f561933b.f561925i);
            l.o(r100, "show_end", this.f561933b.f561926j);
            b r101 = this.f561933b;
            if (r101.f561928l == false) goto L5;
            l.o(r100, "init_time", r101.f561927k);
        L5:
            l.o(r100, "inject_js_time", this.f561933b.f561924h);
            l.p(r100, "event_counts", this.f561933b.f561930n);
            l.o(r100, "load_start", this.f561933b.f557698a.getLoadUrlTime());
            l.p(r100, "is_first_page_started", Boolean.valueOf(this.f561933b.f561929m));
            l.p(r100, "ttwebview_timing", this.f561933b.f561932p);
        }
    }

    public b(WebNativeCommon r100) {
        super(r100);
        this.f561920d = new a(this);
        this.f561930n = new JSONObject();
        this.f561931o = new HashSet();
    }

    public final void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        l.n(this.f561930n, r100, l.g(this.f561930n, r100) + 1);
        ((HashSet) this.f561931o).add(r100);
        nz2.b.a("WebPerfReportData", "addCount: " + r100);
    }
}
