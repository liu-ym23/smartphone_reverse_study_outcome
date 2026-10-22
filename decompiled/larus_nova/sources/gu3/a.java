package gu3;

import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements kt3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile kt3.a f482760a;

    /* JADX INFO: renamed from: gu3.a$a, reason: collision with other inner class name */
    public class C6068a implements hu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f482761a;

        public C6068a(a r100) {
            this.f482761a = r100;
        }

        @Override // hu3.b
        public final void a(JSONObject r100) {
            a r101 = this.f482761a;
            r101.getClass();
            JSONObject r102 = r100.optJSONObject("custom_event_settings");
            if (r102 == null) goto L29;
            JSONObject r103 = r102.optJSONObject("allow_service_name");
            HashSet r104 = new HashSet();
            if (r103 == null) goto L10;
            Iterator<String> r105 = r103.keys();
        L8:
            if (r105.hasNext() == false) goto L10;
            r104.add(r105.next());
        L10:
            HashSet r106 = new HashSet();
            JSONObject r107 = r102.optJSONObject("allow_log_type");
            if (r107 == null) goto L18;
            Iterator<String> r108 = r107.keys();
        L14:
            if (r108.hasNext() == false) goto L18;
            String r109 = r108.next();
            if (r107.optInt(r109) != 1) goto L14;
            r106.add(r109);
        L18:
            r101.f482760a = new kt3.a(r104, r106);
            if (xu3.a.a() == false) goto L21;
            av3.b.a("APM-Config", "received customEventSettings=" + r102);
            av3.b.a("APM-Config", "parsed CommonEventConfig=" + r101.f482760a);
        L21:
            jt3.a.h(r101.f482760a);
            return;
        }
    }

    public a() {
        hu3.a.a().b();
        hu3.a.a().c(new C6068a(this));
    }

    @Override // kt3.b
    public final kt3.a getConfig() {
        return this.f482760a;
    }
}
