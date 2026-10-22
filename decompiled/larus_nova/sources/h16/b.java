package h16;

import android.view.Menu;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface b {

    public static final class a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "CustomSelectMenuItem(title=null, clickListener=null)";
        }
    }

    List<a> Z0(Menu r100);

    void g0(String r100);
}
