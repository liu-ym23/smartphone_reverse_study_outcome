package a84;

import android.os.Build;
import i84.p;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface a {

    /* JADX INFO: renamed from: a84.a$a, reason: collision with other inner class name */
    public static class C0000a implements a {
        public C0000a() {
        }

        @Override // a84.a
        public long a() {
            return 100;
        }

        @Override // a84.a
        public final boolean b() {
            p.a r0 = p.a;
            String r1 = Build.BRAND;
            if (r1 != null) goto L5;
            boolean r2 = false;
        L7:
            return !r2;
        L5:
            r2 = r1.toLowerCase(Locale.ENGLISH).contains("meizu");
            goto L7
        }
    }

    long a();

    boolean b();
}
