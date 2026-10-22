package yr;

import android.util.Log;
import bw.k;
import bw.m;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final String d(Throwable r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
        if (r100 != null) goto L7;
        Thread r103 = ThreadMethodProxy.currentThread();
        StringBuilder r104 = new StringBuilder();
        r104.append(r103);
        r104.append('-');
        r104.append(r103.getId());
        r101.append(r104.toString());
        r101.append("\n");
        StackTraceElement[] r105 = r103.getStackTrace();
        int r106 = r105.length;
    L5:
        if (r102 >= r106) goto L11;
        r101.append(r105[r102].toString());
        r101.append("\n");
        r102 = r102 + 1;
    L11:
        return r101.toString();
    L7:
        r101.append(r100.getMessage());
        r101.append("\n");
        StackTraceElement[] r107 = r100.getStackTrace();
        int r108 = r107.length;
    L8:
        if (r102 >= r108) goto L11;
        r101.append(r107[r102].toString());
        r101.append("\n");
        r102 = r102 + 1;
        goto L8
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.b(3, "GameCP_" + r100, r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.b(6, "GameCP_" + r100, r101);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.b(4, "GameCP_" + r100, r101);
    }

    @JvmStatic
    public static final void f(Throwable r100, String r101) {
        b.d("GameCP_exception", r101, r100);
        m r102 = com.bytedance.android.gamecp.host_api.a.b();
        if (r102 == null) goto L8;
        k r103 = r102.getHostMonitorService();
        if (r103 == null) goto L9;
        r103.T1("GameCP_exception");
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.b(5, "GameCP_" + r100, r101);
    }

    @JvmStatic
    public static final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "t");
        b.b(6, "GameCP_".concat(r100), r101 + Log.getStackTraceString(r102));
    }
}
