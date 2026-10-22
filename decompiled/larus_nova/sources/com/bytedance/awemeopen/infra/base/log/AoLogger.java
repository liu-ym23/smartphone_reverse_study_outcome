package com.bytedance.awemeopen.infra.base.log;

import android.app.Application;
import android.os.Process;
import android.util.Log;
import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes46.dex */
public final class AoLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f198646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f198647b = null;

    public interface a {
        void a();
    }

    public static final class b implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public b(String r100) {
        }
    }

    public static final class c implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public c(String r100) {
        }
    }

    public static final class d implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public d(String r100) {
        }
    }

    public static final class e implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public e(String r100) {
        }
    }

    public static final class f implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public f(String r100) {
        }
    }

    static {
        f198647b = LazyKt.lazy(AoLogger$enableLogcatPrint$2.INSTANCE);
    }

    public static boolean e() {
        return ((Boolean) f198647b.getValue()).booleanValue();
    }

    public static AoLogService f() {
        int r100 = j64.b.f497514a;
        return (AoLogService) j64.b.a(AoLogService.class);
    }

    public static String a(Object[] r100) {
        StringBuilder r101 = new StringBuilder();
        if (AoDebug.b() == false) goto L21;
        StackTraceElement[] r102 = new Throwable().getStackTrace();
        String r103 = "unknown";
        String r104 = "";
        if (r102.length <= 2) goto L16;
        StackTraceElement r105 = r102[2];
        if (r105 == null) goto L16;
        String r106 = r105.getMethodName();
        if (r106 == null) goto L12;
        r103 = r106;
    L12:
        int r107 = r105.getLineNumber();
        String r108 = r105.getFileName();
        if (r108 == null) goto L17;
        r104 = r108;
    L17:
        r101.append(r104);
        r101.append(" (");
        if (f198646a > 0) goto L20;
        f198646a = Process.myPid();
    L20:
        r101.append(f198646a);
        r101.append(") [");
        r101.append(r103);
        r101.append(':');
        r101.append(r107);
        r101.append(']');
    L16:
        r107 = -1;
    L21:
        int r109 = r100.length;
        int r110 = 0;
    L22:
        if (r110 >= r109) goto L32;
        Object r111 = r100[r110];
        r101.append(' ');
        if (r111 != null) goto L26;
        r101.append("null");
    L30:
        r110 = r110 + 1;
        goto L22
    L26:
        if ((r111 instanceof Throwable) == false) goto L28;
        r101.append(Log.getStackTraceString((Throwable) r111));
        goto L30
    L28:
        r101.append(r111);
        goto L30
    L32:
        return r101.toString();
    }

    public static String d(String r100) {
        if (r100 != null) goto L6;
        return "ao_";
    L6:
        if (StringsKt.startsWith$default(r100, "ao_", false, 2, null) == false) goto L8;
        return r100;
    L8:
        return "ao_".concat(r100);
    }

    @JvmStatic
    public static final void i(Object... r100) {
        Intrinsics.checkNotNullParameter("AoAppMonitor", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = d("AoAppMonitor");
        String r102 = a(r100);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().e(r101, r102);
        if (AoDebug.c() == false) goto L11;
        Application r103 = y54.a.a();
        Lazy r104 = ToastUtils.f198954a;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "text");
        ToastUtils.d(r103, r102, 1, null);
        return;
    L11:
        return;
    L5:
        if (e() == false) goto L7;
        k(r102, new com.bytedance.awemeopen.infra.base.log.a(r101));
        goto L7
    }

    @JvmStatic
    public static final void j(Throwable r100) {
        if (AoDebug.c() == false) goto L6;
        r100.printStackTrace();
        return;
    }

    @JvmStatic
    public static final void b(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        String r102 = d(r100);
        String r103 = a(r101);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().d(r102, r103);
        return;
    L5:
        if (e() == false) goto L7;
        k(r103, new b(r102));
        goto L7
    }

    @JvmStatic
    public static final void c(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        String r102 = d(r100);
        String r103 = a(r101);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().e(r102, r103);
        return;
    L5:
        if (e() == false) goto L7;
        k(r103, new c(r102));
        goto L7
    }

    @JvmStatic
    public static final void g(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        String r102 = d(r100);
        String r103 = a(r101);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().i(r102, r103);
        return;
    L5:
        if (e() == false) goto L7;
        k(r103, new d(r102));
        goto L7
    }

    @JvmStatic
    public static final void h(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        String r102 = d(r100);
        String r103 = a(r101);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().e(r102, r103);
        if (AoDebug.c() == true) goto L10;
        return;
    L10:
        if (r101.length <= 0) goto L17;
        Object r104 = r101[r101.length - 1];
        if ((r104 instanceof Throwable) == false) goto L18;
        Throwable r105 = (Throwable) r104;
        r105.printStackTrace();
        throw new RuntimeException(r105);
    L18:
        return;
    L17:
        return;
    L5:
        if (e() == false) goto L7;
        k(r103, new e(r102));
        goto L7
    }

    public static void k(String r100, a r101) {
        int r102 = r100.length();
        if (r102 > 3800) goto L6;
        r101.a();
        return;
    L6:
        String r103 = "<continue_" + ((System.nanoTime() / ((long) 100)) % ((long) 100000)) + Typography.greater;
        StringBuilder r104 = new StringBuilder((r103.length() * 2) + 3800);
        ArrayList r105 = new ArrayList((r102 / 3800) + 1);
        int r106 = 0;
    L7:
        if (r106 >= r102) goto L16;
        r104.setLength(0);
        if (r106 <= 0) goto L11;
        r104.append(r103);
    L11:
        int r107 = r106 + 3800;
        if (r107 < r102) goto L14;
        r104.append(r100, r106, r102);
    L15:
        r105.add(r104.toString());
        r106 = r107;
        goto L7
    L14:
        r104.append(r100, r106, r107);
        r104.append(r103);
        goto L15
    L16:
        Iterator r108 = r105.iterator();
    L18:
        if (r108.hasNext() == false) goto L20;
        String r109 = (String) r108.next();
        r101.a();
        goto L18
    }

    @JvmStatic
    public static final void l(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        String r102 = d(r100);
        String r103 = a(r101);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().w(r102, r103);
        return;
    L5:
        if (e() == false) goto L7;
        k(r103, new f(r102));
        goto L7
    }
}
