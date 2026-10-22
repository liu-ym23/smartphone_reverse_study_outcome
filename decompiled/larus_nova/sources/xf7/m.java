package xf7;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class m implements yf7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f563484a = null;

    public static class a extends n<yf7.g> {
        public a() {
        }

        @Override // xf7.n
        public final yf7.g a(Object[] r100) {
            return new m();
        }
    }

    public m() {
    }

    static {
        f563484a = new a();
    }

    public static yf7.g c() {
        return f563484a.b(new Object[0]);
    }

    @Override // yf7.g
    public final void a(boolean r100) {
        JSONObject r101 = new JSONObject();
        eg7.a.a(r101, "login", r100 ? 1 : 0);
        t.a("sync_account_status", r101, null, null);
    }

    @Override // yf7.g
    public final void b(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        eg7.a.c(r102, "config", r100);
        eg7.a.c(r102, "error", r101);
        t.a("sync_config", r102, null, null);
    }

    @Override // yf7.g
    public final void ensureNotReachHere(Throwable r100, String r101) {
        t.d(r100, r101);
    }
}
