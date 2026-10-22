package hk6;

import android.graphics.drawable.Drawable;
import ek6.b;

/* JADX INFO: loaded from: classes19.dex */
public interface b<T extends ek6.b> {

    public interface a {

        /* JADX INFO: renamed from: hk6.b$a$a, reason: collision with other inner class name */
        public static final class C6158a {
            public static /* synthetic */ void a(a r100, String r101, Throwable r102, int r103) {
                if ((r103 & 1) == 0) goto L6;
                r101 = null;
            L6:
                if ((r103 & 2) == 0) goto L8;
                r102 = null;
            L8:
                r100.a(r101, r102);
            }
        }

        void a(String r100, Throwable r101);

        void b(Drawable r100);
    }
}
