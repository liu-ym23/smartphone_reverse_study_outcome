package com.google.archivepatcher.shared;

import iv7.l;
import iv7.m;
import iv7.n;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jv7.b;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static List<n<Object>> b(List<m> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<m> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        m r103 = r102.next();
        r103.getClass();
        r101.add(new n(r103, null));
        goto L4
    L6:
        return r101;
    }

    public static void a(List r100, b r101, l r110) throws IOException {
        List<n<Object>> r102 = b(r100);
        PartiallyUncompressingPipe r103 = new PartiallyUncompressingPipe(r110);
        Iterator r104 = ((ArrayList) r102).iterator();     // Catch: Throwable -> L60
        long r105 = 0;
    L5:
        if (r104.hasNext() == false) goto L42;
        n r111 = (n) r104.next();     // Catch: Throwable -> L60
        long r106 = r111.b() - r105;     // Catch: Throwable -> L60
        if (r106 > 0) goto L74;
    L27:
        long r107 = r103.f274681b.f495948a;     // Catch: Throwable -> L60
        InputStream r108 = r101.e(r111.b(), r111.a()).c();     // Catch: Throwable -> L60
        r103.a(r108, PartiallyUncompressingPipe.Mode.UNCOMPRESS_NOWRAP);     // Catch: Throwable -> L33
        if (r108 == null) goto L32;
        r108.close();     // Catch: Throwable -> L60
    L32:
        r105 = r111.b() + r111.a();
        goto L5
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        if (r108 != null) goto L90;
    L41:
        throw th;     // Catch: Throwable -> L60
    L90:
        r108.close();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L60
        goto L41
    L74:
        InputStream r109 = r101.e(r105, r106).c();     // Catch: Throwable -> L23
        r103.a(r109, PartiallyUncompressingPipe.Mode.COPY);     // Catch: Throwable -> L14
        if (r109 == null) goto L27;
        r109.close();     // Catch: Throwable -> L23
        goto L27
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r109 != null) goto L70;
    L22:
        throw th;     // Catch: Throwable -> L23
    L70:
        r109.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60
    L42:
        long r112 = r101.b() - r105;     // Catch: Throwable -> L60
        if (r112 <= 0) goto L58;
        InputStream r113 = r101.e(r105, r112).c();     // Catch: Throwable -> L60
        r103.a(r113, PartiallyUncompressingPipe.Mode.COPY);     // Catch: Throwable -> L49
        if (r113 == null) goto L58;
        r113.close();     // Catch: Throwable -> L60
        goto L58
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        if (r113 != null) goto L72;
    L57:
        throw th;     // Catch: Throwable -> L60
    L72:
        r113.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L60
    L58:
        r103.close();
        return;
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L65
    L67:
        throw th;
    L65:
        th = move-exception;
        th.addSuppressed(th);
        goto L67
    }
}
