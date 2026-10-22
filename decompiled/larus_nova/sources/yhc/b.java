package yhc;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f567684a;

    public static class a implements e {
        public a() {
        }

        @Override // yhc.e
        public final void onEvent(String r100, JSONObject r101) {
        }
    }

    static {
        f567684a = new a();
    }

    public static void a(String r100, JSONObject r101) {
        f567684a.onEvent(r100, r101);
    }
}
