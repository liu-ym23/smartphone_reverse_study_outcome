package sa5;

import android.app.Activity;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes16.dex */
public interface m extends o {

    public static class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> T a(Activity r100, Class<T> r101) {
            if ((r100 instanceof m) == true) goto L5;
            return null;
        L5:
            return (T) ((m) r100).vb(r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> T b(Fragment r100, Class<T> r101) {
        L3:
            if (r2 == 0) goto L11;
            if ((r2 instanceof o) == true) goto L6;
            Fragment r102 = r102.getParentFragment();
            goto L3
        L6:
            T r103 = (T) ((o) r102).vb(r101);
            if (r103 == null) goto L9;
            return r103;
        L9:
            return null;
        L11:
            return null;
        }
    }
}
