package ez2;

import bz2.e;
import ny2.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends dz2.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C5834a f474841h;

    /* JADX INFO: renamed from: ez2.a$a, reason: collision with other inner class name */
    public class C5834a extends dz2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONArray f474842c;

        @Override // dz2.a
        public final void c() {
            this.f470571b = false;
        }

        public C5834a() {
            super("falconPerf");
            this.f474842c = new JSONArray();
        }

        @Override // ny2.a
        public final void b(JSONObject r100) {
            e.h(r100, "resource_list", this.f474842c);
        }
    }

    @Override // ny2.g
    public final f d() {
        return null;
    }

    @Override // dz2.c, dz2.b
    public final boolean e() {
        return this.f474841h.f470571b;
    }

    @Override // dz2.c, dz2.b
    public final void reset() {
        this.f474841h.f470571b = false;
    }

    @Override // dz2.c, ny2.g
    public final ny2.b f() {
        return this.f474841h;
    }

    @Override // dz2.c
    public final dz2.a i() {
        return this.f474841h;
    }

    public a(c r100) {
        super(r100, "falconPerf", r100.f531014c);
        this.f474841h = new C5834a();
    }

    @Override // dz2.c, dz2.b
    public final void h(JSONObject r100) {
        C5834a r101 = this.f474841h;
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        r101.f474842c.put(r100);
        r101.f470571b = true;
    }
}
