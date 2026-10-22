package gu3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.bytedance.apm6.java_alloc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.apm6.java_alloc.b f482773a;

    public class a implements hu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f482774a;

        public a(g r100) {
            this.f482774a = r100;
        }

        @Override // hu3.b
        public final void a(JSONObject r100) {
            g r101 = this.f482774a;
            r101.getClass();
            JSONObject r102 = r100.optJSONObject("performance_modules");
            if (r102 == null) goto L20;
            JSONObject r103 = r102.optJSONObject("memory");
            if (r103 == null) goto L21;
            boolean r104 = true;
            if (r103.optInt("enable_alloc_collect", 0) == 1) goto L12;
            r104 = false;
        L12:
            r103.optInt("enable_alloc_upload", 0);
            r103.optInt("alloc_collect_per_thousand_alloc", 0);
            r103.optInt("alloc_dump_per_thousand_collect", 0);
            r103.optInt("alloc_threshold_alloc_frequency", 0);
            r103.optLong("alloc_threshold_alloc_size", 0);
            r101.f482773a = new com.bytedance.apm6.java_alloc.b(r104);
            if (xu3.a.a() == false) goto L15;
            av3.b.a("APM-Config", "parsed JavaAllocConfig=" + r101.f482773a);
        L15:
            com.bytedance.apm6.java_alloc.a r105 = com.bytedance.apm6.java_alloc.a.C2768a.f190833a;
            com.bytedance.apm6.java_alloc.b r106 = r101.f482773a;
            if (r106 == null) goto L22;
            r105.f190831a = r106;
            return;
        L22:
            return;
        L21:
            return;
        }
    }

    public g() {
        hu3.a.a().b();
        hu3.a.a().c(new a(this));
    }

    @Override // com.bytedance.apm6.java_alloc.c
    public final com.bytedance.apm6.java_alloc.b getConfig() {
        return this.f482773a;
    }
}
