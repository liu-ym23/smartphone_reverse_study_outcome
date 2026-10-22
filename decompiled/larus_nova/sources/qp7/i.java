package qp7;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes22.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qp7.b f534360a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedInputStream f534361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f534362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C7377a f534363c;

        /* JADX INFO: renamed from: qp7.i$a$a, reason: collision with other inner class name */
        public static class C7377a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f534364a;

            public C7377a() {
                this.f534364a = 1;
            }
        }

        public final String a() throws IOException {
        L2:
            int r100 = this.f534361a.read();
            if (r100 < 0) goto L4;
            char r101 = (char) r100;
            C7377a r102 = this.f534363c;
            int r103 = r102.f534364a;
            if (r103 == 1) goto L19;
            if (r103 == 2) goto L16;
            if (r103 != 3) goto L14;
            if (r101 != '\r') goto L12;
            r102.f534364a = 2;
        L21:
            int r104 = r102.f534364a;
            if (r104 != 1) goto L23;
            this.f534362b.append(r101);
            goto L2
        L23:
            if (r104 != 3) goto L2;
            String r105 = this.f534362b.toString();
            this.f534362b.setLength(0);
            return r105;
        L12:
            r102.f534364a = 1;
            goto L21
        L14:
            throw new IllegalArgumentException("Unknown state: " + r102.f534364a);
        L16:
            if (r101 != '\n') goto L18;
            r102.f534364a = 3;
            goto L21
        L18:
            r102.f534364a = 1;
            goto L21
        L19:
            if (r101 != '\r') goto L21;
            r102.f534364a = 2;
            goto L21
        L4:
            return null;
        }

        public a(pp7.b r100) {
            this.f534362b = new StringBuilder();
            this.f534363c = new C7377a();
            this.f534361a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final byte[] f534365b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedOutputStream f534366a;

        static {
            f534365b = "\r\n".getBytes();
        }

        public b(BufferedOutputStream r100) {
            this.f534366a = r100;
        }
    }

    public i(qp7.b r100) {
        this.f534360a = r100;
    }

    public final void a(pp7.e r110) throws IOException {
        pp7.b r100 = new pp7.b(r110.f530224b.a());
        OutputStream r101 = r110.f530223a.getOutputStream();
        a r102 = new a(r100);
        b r103 = new b(new BufferedOutputStream(r101));
        pp7.e r104 = new pp7.e(r110.f530223a, r100);
        g r111 = new g();
        h r105 = new h();
    L3:
        r111.b();
        String r106 = r102.a();
        boolean r107 = true;
        int r108 = 0;
        c r109 = null;
        if (r106 != null) goto L6;
        g r112 = null;
    L14:
        if (r112 == null) goto L48;
        r105.b();
        qp7.b r113 = this.f534360a;
        String r114 = r112.f534356c.getPath();
        monitor-enter(r113);
        int r115 = r113.f534350a.size();     // Catch: Throwable -> L45
    L18:
        if (r108 >= r115) goto L25;
        if (((j) ListProtector.get(r113.f534350a, r108)).a(r114) == true) goto L21;
        r108 = r108 + 1;
        goto L18
    L21:
        r109 = (c) ListProtector.get(r113.f534351b, r108);     // Catch: Throwable -> L45
        monitor-exit(r113);
    L26:
        if (r109 != null) goto L58;
        r105.f534357c = 404;
        r105.f534358d = "Not found";
        r105.f534359e = e.a("No handler found\n", "text/plain");
    L34:
        if (r107 == false) goto L76;
        e r116 = r105.f534359e;
        if (r116 == null) goto L39;
        r105.a("Content-Type", ((d) r116).f534352a);
        r105.a("Content-Length", String.valueOf(((d) r105.f534359e).f534353b.length));
    L39:
        b(r105, r103);
        e r117 = r105.f534359e;
        if (r117 == null) goto L3;
        r101.write(((d) r117).f534353b);
        goto L3
    L76:
        return;
    L58:
        r107 = r109.a(r104, r112, r105);     // Catch: RuntimeException -> L30
    L30:
        e = move-exception;
        r105.f534357c = 500;
        r105.f534358d = "Internal Server Error";
        StringWriter r118 = new StringWriter();
        PrintWriter r119 = new PrintWriter(r118);
        e.printStackTrace(r119);     // Catch: Throwable -> L42
        r119.close();
        r105.f534359e = e.a(r118.toString(), "text/plain");
    L42:
        th = move-exception;
        r119.close();
        throw th;
    L25:
        monitor-exit(r113);
    L45:
        th = move-exception;
        throw th;
    L48:
        return;
    L6:
        String[] r120 = r106.split(" ", 3);
        if (r120.length != 3) goto L57;
        String r121 = r120[0];
        r111.f534356c = UriProtector.parse(r120[1]);
        String r122 = r120[2];
    L9:
        String r123 = r102.a();
        if (r123 == null) goto L55;
        if ("".equals(r123) == true) goto L13;
        String[] r124 = r123.split(": ", 2);
        if (r124.length != 2) goto L53;
        String r125 = r124[0];
        String r126 = r124[1];
        r111.f534354a.add(r125);
        r111.f534355b.add(r126);
        goto L9
    L53:
        throw new IOException("Malformed header: ".concat(r123));
    L13:
        r112 = r111;
        goto L14
    L55:
        throw new EOFException();
    L57:
        throw new IOException("Invalid request line: ".concat(r106));
    }

    public static void b(h r100, b r101) throws IOException {
        String r102 = "HTTP/1.1 " + r100.f534357c + " " + r100.f534358d;
        int r103 = r102.length();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.f534366a.write(r102.charAt(r104));
        r104 = r104 + 1;
        goto L3
    L5:
        r101.f534366a.write(b.f534365b);
        int r105 = r100.f534354a.size();
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L11;
        String r107 = ((String) ListProtector.get(r100.f534354a, r106)) + ": " + ((String) ListProtector.get(r100.f534355b, r106));
        int r108 = r107.length();
        int r109 = 0;
    L8:
        if (r109 >= r108) goto L10;
        r101.f534366a.write(r107.charAt(r109));
        r109 = r109 + 1;
        goto L8
    L10:
        r101.f534366a.write(b.f534365b);
        r106 = r106 + 1;
        goto L6
    L11:
        r101.f534366a.write(b.f534365b);
        r101.f534366a.flush();
    }
}
