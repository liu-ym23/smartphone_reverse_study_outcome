package qi6;

import com.bytedance.live.livelink.kmp.api.base.video.Status;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class e {
    public static void a(f r100) {
        r100.l(Status.READY);
    }

    public static void b(f r100) {
        r100.l(Status.PAUSED);
    }

    public static void d(f r100) {
        r100.l(Status.UNDEFINED);
    }

    public static void e(f r100) {
        r100.l(Status.RESUMED);
    }

    public static void f(f r100) {
        r100.l(Status.STARTED);
    }

    public static void g(f r100) {
        r100.l(Status.STOPPED);
    }

    public static void c(f r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "frame");
        Iterator<f> r102 = r100.k().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().m(r101);
        goto L4
    }
}
