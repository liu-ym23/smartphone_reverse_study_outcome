package r17;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f535671a;

    public static class a {
        public a() {
        }

        public final void a(String r100, Object... r101) {
            if (e.f535675a == true) goto L6;
            a r102 = c.f535671a;
            return;
        L6:
            String r103 = String.format(r100, r101);
            if (r103.length() < 4000) goto L12;
            String[] r104 = r103.split("\n", -1);
            int r105 = r104.length;
            int r106 = 0;
        L10:
            if (r106 >= r105) goto L14;
            String r107 = r104[r106];
            r106 = r106 + 1;
            goto L10
        L14:
            return;
        }
    }

    static {
        f535671a = new a();
    }

    public static void b(String r100, Object... r101) {
        f535671a.a(r100, r101);
    }

    public static void a(Throwable r100, String r101, Object... r102) {
        f535671a.a(String.format(r101, r102) + '\n' + Log.getStackTraceString(r100), new Object[0]);
    }
}
