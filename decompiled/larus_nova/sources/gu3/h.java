package gu3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h implements ku3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ku3.a f482775a;

    public class a implements hu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f482776a;

        public a(h r100) {
            this.f482776a = r100;
        }

        @Override // hu3.b
        public final void a(JSONObject r110) {
            h r100 = this.f482776a;
            r100.getClass();
            JSONObject r111 = r110.optJSONObject("performance_modules");
            if (r111 == null) goto L21;
            JSONObject r112 = r111.optJSONObject("memory");
            if (r112 == null) goto L22;
            long r101 = r112.optLong("collect_interval", 120);
            double r102 = r112.optDouble("reach_top_memory_rate", 0.8d);
            boolean r103 = true;
            if (r112.optInt("enable_upload", 0) != 1) goto L11;
            boolean r104 = true;
        L13:
            if (r112.optInt("close_memory_collect") != 1) goto L16;
            r103 = false;
        L16:
            r100.f482775a = new ku3.a(r101, r102, r104, r103);
            if (xu3.a.a() == false) goto L19;
            av3.b.a("APM-Config", "parsed MemoryConfig=" + r100.f482775a);
        L19:
            int r113 = iu3.d.f495774h;
            iu3.d.a.f495782a.c(r100.getConfig());
            return;
        L11:
            r104 = false;
            goto L13
        L22:
            return;
        }
    }

    public h() {
        hu3.a.a().b();
        hu3.a.a().c(new a(this));
    }

    @Override // ku3.b
    public ku3.a getConfig() {
        return this.f482775a;
    }
}
