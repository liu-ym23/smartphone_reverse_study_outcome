package gu3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements bu3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bu3.a f482767a;

    public class a implements hu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f482768a;

        public a(d r100) {
            this.f482768a = r100;
        }

        @Override // hu3.b
        public final void a(JSONObject r110) {
            d r100 = this.f482768a;
            r100.getClass();
            JSONObject r111 = r110.optJSONObject("performance_modules");
            if (xu3.a.a() == false) goto L5;
            av3.b.a("APM-FD", "parseConfig:" + r111);
        L5:
            if (r111 == null) goto L25;
            JSONObject r112 = r111.optJSONObject("fd");
            if (r112 != null) goto L11;
            return;
        L11:
            if (xu3.a.a() == false) goto L14;
            av3.b.a("APM-FD", "parseConfig:" + r112);
        L14:
            if (r112.optInt("enable_upload", 0) != 1) goto L16;
            boolean r113 = true;
        L17:
            long r101 = r112.optInt("fd_count_threshold", 800);
            long r102 = r112.optLong("collect_interval", 10) * 60000;
            if (r102 >= 10) goto L20;
            r102 = 600000;
        L20:
            bu3.a r114 = new bu3.a(r101, r102, r113);
            if (xu3.a.a() == false) goto L23;
            av3.b.a("APM-FD", "parseConfig:" + r114);
        L23:
            r100.f482767a = r114;
            au3.b.f16304g.b(r114);
            return;
        L16:
            r113 = false;
            goto L17
        }
    }

    public d() {
        if (xu3.a.a() == false) goto L5;
        av3.b.a("APM-FD", "FdConfigManager:");
    L5:
        hu3.a.a().b();
        hu3.a.a().c(new a(this));
    }

    @Override // bu3.b
    public final bu3.a getConfig() {
        return this.f482767a;
    }
}
