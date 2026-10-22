package ez2;

import bz2.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import java.util.Set;
import ny2.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends dz2.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f474849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f474850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f474851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f474852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f474853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONObject f474854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set<String> f474855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public py2.b f474856o;

    public class a extends dz2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f474857c;

        @Override // dz2.a
        public final void c() {
            this.f470571b = false;
        }

        public a(d r100) {
            this.f474857c = r100;
            super("performance");
            this.f470571b = true;
        }

        @Override // ny2.a
        public final void b(JSONObject r100) {
            this.f474857c.getClass();
            e.g(r100, "page_start", 0);
            this.f474857c.getClass();
            e.g(r100, "page_finish", 0);
            this.f474857c.getClass();
            e.g(r100, "page_progress_100", 0);
            this.f474857c.getClass();
            e.g(r100, "show_start", 0);
            e.g(r100, "show_end", this.f474857c.f474851j);
            d r101 = this.f474857c;
            if (r101.f474853l == false) goto L5;
            e.g(r100, "init_time", r101.f474852k);
        L5:
            e.g(r100, "inject_js_time", this.f474857c.f474850i);
            e.h(r100, "event_counts", this.f474857c.f474854m);
            e.g(r100, "load_start", this.f474857c.f470572a.f474846l);
        }
    }

    @Override // ny2.g
    public final f d() {
        return this.f474856o;
    }

    @Override // dz2.c, ny2.g
    public final ny2.b f() {
        return this.f474849h;
    }

    @Override // dz2.c
    public final dz2.a i() {
        return this.f474849h;
    }

    public d(c r100) {
        super(r100, PerfLog.TAG_PERF, r100.f531014c);
        this.f474849h = new a(this);
        this.f474854m = new JSONObject();
        this.f474855n = new HashSet();
    }
}
