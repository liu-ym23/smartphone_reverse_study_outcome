package w83;

import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface i {

    public static final class a {
        public static /* synthetic */ void b(i r6, ViewGroup r7, ll.a r8, String r9) {
            r6.c(r7, r8, r9, true, null);
        }

        public static /* synthetic */ ll.b a(i r0, ViewGroup r1, ll.a r2, boolean r3, int r4) {
            if ((r4 & 4) == 0) goto L6;
            r3 = false;
        L6:
            return r0.a(r1, r2, r3, null);
        }
    }

    ll.b a(ViewGroup r1, ll.a r2, boolean r3, f r4);

    void b(ViewGroup r1);

    ll.b c(ViewGroup r1, ll.a r2, String r3, boolean r4, f r5);

    void d(ViewGroup r1);
}
