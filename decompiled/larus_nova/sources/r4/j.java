package r4;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public interface j {

    public static final class a {
        public static /* synthetic */ void a(j r100, e3.d r101) {
            r100.closeView(r101, null, false);
        }

        public static boolean b(j r100, e3.d r101, String r102, Map<String, ? extends Object> r103, Context r104) {
            Intrinsics.checkNotNullParameter(r102, "schema");
            Intrinsics.checkNotNullParameter(r103, "extraParams");
            List<b> r105 = r100.provideRouteOpenHandlerList(r101);
            b r106 = r100.provideRouteOpenExceptionHandler(r101);
            Iterator<T> r107 = r105.iterator();
            b r108 = null;
            b r109 = null;
        L4:
            if (r107.hasNext() == false) goto L11;
            b r110 = (b) r107.next();
            if (r109 != null) goto L8;
            r108 = r110;
        L8:
            if (r109 == null) goto L10;
            r109.f535990a = r110;
        L10:
            r110.f535991b = r106;
            r109 = r110;
            goto L4
        L11:
            boolean r111 = false;
            if (r108 != null) goto L14;
            return false;
        L14:
            if (r111 == true) goto L22;
            if (r108 == null) goto L22;
            r111 = r108.a(r102, r103, r104);     // Catch: Throwable -> L21
            if (r111 == true) goto L22;
            r108 = r108.f535990a;     // Catch: Throwable -> L21
        L21:
            r108 = r108.f535991b;
        L22:
            return r111;
        }
    }

    boolean closeView(e3.d r100, String r101, boolean r102);

    boolean openSchema(e3.d r100, String r101, Map<String, ? extends Object> r102, Context r103);

    b provideRouteOpenExceptionHandler(e3.d r100);

    List<b> provideRouteOpenHandlerList(e3.d r100);
}
