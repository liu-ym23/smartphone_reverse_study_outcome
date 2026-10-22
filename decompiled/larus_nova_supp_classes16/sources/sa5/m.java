package sa5;

import android.app.Activity;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface m extends o {

    public static class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> T a(Activity r1, Class<T> r2) {
            if ((r1 instanceof m) == true) goto L5;
            return null;
        L5:
            return (T) ((m) r1).vb(r2);
        }

        public static <T> T b(Fragment r2, Class<T> r3) {
        L3:
            if (r2 == null) goto L11;
            if ((r2 instanceof o) == true) goto L6;
            r2 = r2.getParentFragment();
            goto L3
        L6:
            T r4 = (T) ((o) r2).vb(r3);
            if (r4 == null) goto L9;
            return r4;
        L9:
            return null;
        L11:
            return null;
        }
    }
}
