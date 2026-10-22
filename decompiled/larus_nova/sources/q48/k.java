package q48;

import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f531692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f531693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f531694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<a> f531695d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f531696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f531697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f531698c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Throwable f531699d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f531700e;

        public a(int r100, String r101, String r102, Throwable r103) {
            long r104 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r101, "tag");
            this.f531696a = r100;
            this.f531697b = r101;
            this.f531698c = r102;
            this.f531699d = r103;
            this.f531700e = r104;
        }
    }

    static {
        f531692a = true;
        f531693b = 2;
        f531695d = new ArrayList();
    }

    public static void e() {
        ArrayList r100 = new ArrayList();
        List<a> r101 = f531695d;
        monitor-enter(r101);
        r100.addAll(r101);     // Catch: Throwable -> L37
        ((ArrayList) r101).clear();     // Catch: Throwable -> L37
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r101);
        Iterator r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L36;
        a r104 = (a) r103.next();
        String r105 = r104.f531698c + ", <pending:" + (System.currentTimeMillis() - r104.f531700e) + "ms>";
        int r106 = r104.f531696a;
        if (r106 != 2) goto L12;
        String r107 = r104.f531697b;
        Intrinsics.checkNotNullParameter(r107, "tag");
        if (f531694c == false) goto L32;
        if (r105 != null) goto L35;
        r105 = "";
    L35:
        ALog.v(r107, r105);
        goto L8
    L32:
        a(2, r107, r105, null);
        goto L8
    L12:
        if (r106 != 3) goto L14;
        b(r104.f531697b, r105);
        goto L8
    L14:
        if (r106 != 4) goto L16;
        d(r104.f531697b, r105);
        goto L8
    L16:
        if (r106 != 5) goto L18;
        String r108 = r104.f531697b;
        Throwable r109 = r104.f531699d;
        Intrinsics.checkNotNullParameter(r108, "tag");
        if (f531694c == false) goto L24;
        if (r105 != null) goto L27;
        r105 = "";
    L27:
        ALog.w(r108, r105, r109);
        goto L8
    L24:
        a(5, r108, r105, r109);
        goto L8
    L18:
        if (r106 != 6) goto L21;
        c(r104.f531697b, r105, r104.f531699d);
        goto L8
    L21:
        throw new IllegalArgumentException(r104.toString());
    L36:
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (f531694c == true) goto L6;
        a(3, r100, r101, null);
        return;
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        ALog.d(r100, r101);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (f531694c == true) goto L6;
        a(4, r100, r101, null);
        return;
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        ALog.i(r100, r101);
    }

    public static void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (f531694c == true) goto L6;
        a(6, r100, r101, r102);
        return;
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        ALog.e(r100, r101, r102);
    }

    public static void a(int r100, String r101, String r102, Throwable r103) {
        List<a> r104 = f531695d;
        monitor-enter(r104);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (ObricAlogServiceDelegate.f387841b.g() == true) goto L7;
    L9:
        a r105 = new a(r100, r101, r102, r103);     // Catch: Throwable -> L12
        ((ArrayList) r104).add(r105);     // Catch: Throwable -> L12
        monitor-exit(r104);
        return;
    L7:
        if (((ArrayList) r104).size() < 10000) goto L9;
        ArrayList r106 = (ArrayList) r104;     // Catch: Throwable -> L12
        r106.subList(0, Math.min(2000, ((ArrayList) r104).size())).clear();     // Catch: Throwable -> L12
        goto L9
    }

    public static void f(String r100, long r110, long r111, final Function1 r112, final Function3 r113) {
        ALogConfig r101 = ALog.sConfig;
        if (r101 == null) goto L8;
        if (TextUtils.isEmpty(r101.getLogDirPath()) == true) goto L8;
        ApmAgent.activeUploadAlog(ALog.sConfig.getLogDirPath(), r110, r111, r100, new i(r112, r113), new j(r112, r113));
        return;
    L8:
        if (ALog.sConfig != null) goto L13;
        if (r112 == null) goto L11;
        r112.invoke(Boolean.FALSE);
    L11:
        if (r113 == null) goto L19;
        r113.invoke(Boolean.FALSE, 0, "log config is null");
        return;
    L19:
        return;
    L13:
        if (r112 == null) goto L15;
        r112.invoke(Boolean.FALSE);
    L15:
        if (r113 == null) goto L21;
        r113.invoke(Boolean.FALSE, 4, "log file is null");
        return;
    }
}
