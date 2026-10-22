package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes31.dex */
public class f implements Iterable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<String> f461817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f461818b;

    public int a() {
        return this.f461818b.get();
    }

    public void b() {
        this.f461817a.clear();
        this.f461818b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f461817a.iterator();
    }

    public f() {
        this.f461817a = null;
        this.f461818b = null;
        this.f461817a = new ConcurrentLinkedQueue();
        this.f461818b = new AtomicInteger(0);
    }

    public int a(String r100) {
        int r101 = r100.length();
        this.f461817a.add(r100);
        return this.f461818b.addAndGet(r101);
    }

    public void a(Writer[] r110, char[] r111) throws IOException {
        if (r110 == null) goto L66;
        if (r111 != null) goto L5;
        return;
    L5:
        if (r111.length != 0) goto L7;
        return;
    L7:
        if (r110.length < 2) goto L70;
        Writer r100 = r110[0];
        Writer r112 = r110[1];
        int r101 = r111.length;
        Iterator<String> r102 = iterator();
        int r103 = r101;
        int r104 = 0;
    L11:
        if (r102.hasNext() == false) goto L29;
        String r105 = r102.next();
        int r106 = r105.length();
        int r107 = 0;
    L13:
        if (r106 <= 0) goto L11;
        if (r103 <= r106) goto L16;
        int r108 = r106;
    L17:
        r107 = r107 + r108;
        r105.getChars(r107, r107, r111, r104);
        r103 = r103 - r108;
        r104 = r104 + r108;
        r106 = r106 - r108;
        if (r103 != 0) goto L13;
        if (r100 != null) goto L56;
    L23:
        if (r112 != null) goto L50;
    L27:
        r103 = r101;
        r104 = 0;
        goto L13
    L50:
        r112.write(r111, 0, r101);     // Catch: Exception -> L26
        goto L27
    L56:
        r100.write(r111, 0, r101);     // Catch: Exception -> L22
        goto L23
    L16:
        r108 = r103;
        goto L17
    L29:
        if (r104 <= 0) goto L38;
        if (r100 != null) goto L52;
    L34:
        if (r112 == null) goto L38;
        r112.write(r111, 0, r104);     // Catch: Exception -> L37
        goto L38
    L52:
        r100.write(r111, 0, r104);     // Catch: Exception -> L33
    L38:
        if (r100 != null) goto L54;
    L42:
        if (r112 == null) goto L69;
        r112.flush();     // Catch: Exception -> L45
        return;
    L71:
        return;
    L69:
        return;
    L54:
        r100.flush();     // Catch: Exception -> L41
        goto L42
    L70:
        return;
    }
}
