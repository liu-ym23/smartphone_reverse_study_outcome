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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class k {
    public static boolean a;
    public static volatile int b;
    public static volatile boolean c;
    public static final List<a> d = null;

    public static final class a {
        public final int a;
        public final String b;
        public final String c;
        public final Throwable d;
        public final long e;

        public a(int r4, String r5, String r6, Throwable r7) {
            long r0 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r5, "tag");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r0;
        }
    }

    static {
        a = true;
        b = 2;
        d = new ArrayList();
    }

    public static void e() {
        ArrayList r0 = new ArrayList();
        List<a> r1 = d;
        monitor-enter(r1);
        r0.addAll(r1);     // Catch: Throwable -> L37
        ((ArrayList) r1).clear();     // Catch: Throwable -> L37
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r1);
        Iterator r3 = r0.iterator();
    L8:
        if (r3.hasNext() == false) goto L36;
        a r4 = (a) r3.next();
        String r5 = r4.c + ", <pending:" + (System.currentTimeMillis() - r4.e) + "ms>";
        int r6 = r4.a;
        if (r6 != 2) goto L12;
        String r7 = r4.b;
        Intrinsics.checkNotNullParameter(r7, "tag");
        if (c == false) goto L32;
        if (r5 != null) goto L35;
        r5 = XmlPullParser.NO_NAMESPACE;
    L35:
        ALog.v(r7, r5);
        goto L8
    L32:
        a(2, r7, r5, null);
        goto L8
    L12:
        if (r6 != 3) goto L14;
        b(r4.b, r5);
        goto L8
    L14:
        if (r6 != 4) goto L16;
        d(r4.b, r5);
        goto L8
    L16:
        if (r6 != 5) goto L18;
        String r8 = r4.b;
        Throwable r9 = r4.d;
        Intrinsics.checkNotNullParameter(r8, "tag");
        if (c == false) goto L24;
        if (r5 != null) goto L27;
        r5 = XmlPullParser.NO_NAMESPACE;
    L27:
        ALog.w(r8, r5, r9);
        goto L8
    L24:
        a(5, r8, r5, r9);
        goto L8
    L18:
        if (r6 != 6) goto L21;
        c(r4.b, r5, r4.d);
        goto L8
    L21:
        throw new IllegalArgumentException(r4.toString());
    L36:
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public static void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if (c == true) goto L6;
        a(3, r2, r3, null);
        return;
    L6:
        if (r3 != null) goto L8;
        r3 = XmlPullParser.NO_NAMESPACE;
    L8:
        ALog.d(r2, r3);
    }

    public static void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if (c == true) goto L6;
        a(4, r2, r3, null);
        return;
    L6:
        if (r3 != null) goto L8;
        r3 = XmlPullParser.NO_NAMESPACE;
    L8:
        ALog.i(r2, r3);
    }

    public static void c(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        if (c == true) goto L6;
        a(6, r1, r2, r3);
        return;
    L6:
        if (r2 != null) goto L8;
        r2 = XmlPullParser.NO_NAMESPACE;
    L8:
        ALog.e(r1, r2, r3);
    }

    public static void a(int r4, String r5, String r6, Throwable r7) {
        List<a> r0 = d;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (ObricAlogServiceDelegate.b.g() == true) goto L7;
    L9:
        a r1 = new a(r4, r5, r6, r7);     // Catch: Throwable -> L12
        ((ArrayList) r0).add(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L7:
        if (((ArrayList) r0).size() < 10000) goto L9;
        ArrayList r2 = (ArrayList) r0;     // Catch: Throwable -> L12
        r2.subList(0, Math.min(2000, ((ArrayList) r0).size())).clear();     // Catch: Throwable -> L12
        goto L9
    }

    public static void f(String r9, long r10, long r12, Function1 r14, Function3 r15) {
        ALogConfig r0 = ALog.sConfig;
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0.getLogDirPath()) == true) goto L8;
        ApmAgent.activeUploadAlog(ALog.sConfig.getLogDirPath(), r10, r12, r9, new i(r14, r15), new j(r14, r15));
        return;
    L8:
        if (ALog.sConfig != null) goto L13;
        if (r14 == null) goto L11;
        r14.invoke(Boolean.FALSE);
    L11:
        if (r15 == null) goto L19;
        r15.invoke(Boolean.FALSE, 0, "log config is null");
        return;
    L19:
        return;
    L13:
        if (r14 == null) goto L15;
        r14.invoke(Boolean.FALSE);
    L15:
        if (r15 == null) goto L21;
        r15.invoke(Boolean.FALSE, 4, "log file is null");
        return;
    }
}
