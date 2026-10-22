package zla;

import android.content.Context;
import com.obric.oui.dialog.base.AbstractDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface h {

    public static final class a {
        public static void a(h r100, zla.a r101) {
            Intrinsics.checkNotNullParameter(r100, "this");
            Intrinsics.checkNotNullParameter(r101, "host");
            if ((r101 instanceof com.obric.oui.dialog.v2.alert.c) == false) goto L6;
            r100.b((AbstractDialog) r101);
            return;
        }
    }

    void a(Context r100, f r101);

    void b(AbstractDialog r100);

    void c(zla.a r100);
}
