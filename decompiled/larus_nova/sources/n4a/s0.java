package n4a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/* JADX INFO: loaded from: classes32.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f517656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f517657b;

    public static class a extends l1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f517658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r0 f517659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f517660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<r0> f517661e;

        public a(Context r100, int r101) {
            this.f517658b = r100;
            this.f517660d = r101;
        }

        public a(Context r100, List r101) {
            this(r100, 2);
            this.f517661e = r101;
        }

        public a(Context r100, r0 r101) {
            this(r100, 1);
            this.f517659c = r101;
        }

        @Override // n4a.l1
        public final void a() {
            int r100 = this.f517660d;
            if (r100 != 1) goto L28;
        L25:
            th = th;
            String r101 = "stm";
            String r102 = "as";
        L74:
            r.f(th, r101, r102);
            return;
        L5:
            if (this.f517658b != null) goto L7;
            return;
        L7:
            if (this.f517659c != null) goto L10;
            return;
        L10:
            monitor-enter(s0.class);     // Catch: Throwable -> L25
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L12:
            if (this.f517658b == null) goto L19;
            r0 r103 = this.f517659c;     // Catch: Throwable -> L21
            if (r103 == null) goto L19;
            s0.a(this.f517658b, r103.b());     // Catch: Throwable -> L21
            monitor-exit(s0.class);     // Catch: Throwable -> L21
            return;
        L19:
            monitor-exit(s0.class);     // Catch: Throwable -> L21
            return;
        L28:
            if (r100 != 2) goto L77;
            monitor-enter(s0.class);     // Catch: Throwable -> L72
        L69:
            th = move-exception;
            throw th;     // Catch: Throwable -> L72
        L32:
            if (this.f517661e != null) goto L34;
        L67:
            monitor-exit(s0.class);     // Catch: Throwable -> L69
            return;
        L34:
            if (this.f517658b == null) goto L67;
            byte[] r104 = new byte[0];     // Catch: Throwable -> L69
            ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L51
            Iterator<r0> r106 = this.f517661e.iterator();     // Catch: Throwable -> L49
        L40:
            if (r106.hasNext() == false) goto L44;
            r0 r107 = r106.next();     // Catch: Throwable -> L49
            if (r107 == null) goto L40;
            r105.write(r107.b());     // Catch: Throwable -> L49
            goto L40
        L44:
            r104 = r105.toByteArray();     // Catch: Throwable -> L49
        L109:
            r105.close();     // Catch: Throwable -> L47
        L57:
            s0.a(this.f517658b, r104);     // Catch: Throwable -> L69
            monitor-exit(s0.class);     // Catch: Throwable -> L69
            return;
        L47:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L69
        L49:
            Throwable th10 = th;
        L105:
            r.f(th10, "stm", "aStB");     // Catch: Throwable -> L60
            if (r105 == null) goto L57;
        L60:
            th = move-exception;
            if (r105 != null) goto L97;
        L66:
            throw th;     // Catch: Throwable -> L69
        L97:
            r105.close();     // Catch: Throwable -> L64
        L64:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L69
        L51:
            th = move-exception;
            th10 = th;
            r105 = null;
        L72:
            th = th;
            r101 = "stm";
            r102 = "apb";
            goto L74
        L77:
            if (r100 != 3) goto L117;
        L92:
            th = move-exception;
            r.f(th, "stm", "usd");
            return;
        L79:
            if (this.f517658b != null) goto L81;
            return;
        L81:
            n0 r108 = t0.a();     // Catch: Throwable -> L92
            Context r109 = this.f517658b;     // Catch: Throwable -> L92
            Vector<e5> r110 = p.f517579b;     // Catch: Throwable -> L92
            t0.b(r109, r108, "e", 1000, 307200, "2");     // Catch: Throwable -> L92
            if (r108.f517551g != null) goto L84;
            r108.f517551g = new u0(new z0(this.f517658b, new v0(new a1(new c1()))));     // Catch: Throwable -> L92
        L84:
            r108.f517552h = BaseConstants.Time.HOUR;     // Catch: Throwable -> L92
            if (TextUtils.isEmpty(r108.f517553i) == false) goto L88;
            r108.f517553i = "cKey";     // Catch: Throwable -> L92
        L88:
            if (r108.f517550f != null) goto L90;
            Context r111 = this.f517658b;     // Catch: Throwable -> L92
            r108.f517550f = new g1(r111, r108.f517552h, r108.f517553i, new d1(r108.f517545a, new e1(r111, s0.f517656a, 20480, 20480, "staticUpdate", s0.f517657b * 1024)));     // Catch: Throwable -> L92
        L90:
            o0.b(r108);     // Catch: Throwable -> L92
            return;
        }
    }

    public s0() {
    }

    public static /* synthetic */ void a(Context r100, byte[] r101) throws IOException {
        n0 r102 = t0.a();
        Vector<e5> r103 = p.f517579b;
        t0.b(r100, r102, "e", 1000, 307200, "2");
        if (r102.f517549e != null) goto L11;
        r102.f517549e = new z();
    L11:
        o0.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), r101, r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        r.f(th, "stm", "wts");
    }

    public static synchronized void d(List<r0> r100, Context r101) {
        monitor-enter(s0.class);
        List<r0> r102 = k0.l();     // Catch: Throwable -> L15
        if (r102 == null) goto L18;
        if (r102.size() <= 0) goto L18;
        ((ArrayList) r100).addAll(r102);     // Catch: Throwable -> L15
    L18:
        b(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(s0.class);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(List<r0> r100, Context r101) {
        monitor-enter(s0.class);
        if (r100 != null) goto L15;
    L13:
        monitor-exit(s0.class);
        return;
    L15:
        if (r100.size() == 0) goto L13;
        k1.f517430d.b(new a(r101, r100));     // Catch: Throwable -> L11
        monitor-exit(s0.class);
        return;
    }

    public static synchronized void c(r0 r100, Context r101) {
        monitor-enter(s0.class);
        k1.f517430d.b(new a(r101, r100));     // Catch: Throwable -> L7
        monitor-exit(s0.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
