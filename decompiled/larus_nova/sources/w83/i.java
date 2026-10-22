package w83;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes13.dex */
public interface i {

    public static final class a {
        public static /* synthetic */ void b(i r100, ViewGroup r101, ll.a r102, String r103) {
            r100.c(r101, r102, r103, true, null);
        }

        public static /* synthetic */ ll.b a(i r100, ViewGroup r101, ll.a r102, boolean r103, int r104) {
            if ((r104 & 4) == 0) goto L6;
            r103 = false;
        L6:
            return r100.a(r101, r102, r103, null);
        }
    }

    ll.b a(ViewGroup r100, ll.a r101, boolean r102, f r103);

    void b(ViewGroup r100);

    ll.b c(ViewGroup r100, ll.a r101, String r102, boolean r103, f r104);

    void d(ViewGroup r100);
}
