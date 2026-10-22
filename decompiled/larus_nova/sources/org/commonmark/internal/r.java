package org.commonmark.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes42.dex */
public final class r implements xvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f525755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f525756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<xvc.a> f525757c;

    @Override // xvc.a
    public final int a() {
        return this.f525756b;
    }

    @Override // xvc.a
    public final char b() {
        return this.f525755a;
    }

    @Override // xvc.a
    public final char c() {
        return this.f525755a;
    }

    public r(char r100) {
        this.f525756b = 0;
        this.f525757c = new LinkedList();
        this.f525755a = r100;
    }

    public final void f(xvc.a r100) {
        int r101 = r100.a();
        ListIterator<xvc.a> r102 = this.f525757c.listIterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        int r103 = r102.next().a();
        if (r101 > r103) goto L7;
        if (r101 != r103) goto L4;
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.f525755a + "' and minimum length " + r101);
    L7:
        r102.previous();
        r102.add(r100);
        boolean r104 = true;
    L13:
        if (r104 == true) goto L20;
        this.f525757c.add(r100);
        this.f525756b = r101;
        return;
    L20:
        return;
    L12:
        r104 = false;
        goto L13
    }

    public final xvc.a g(int r100) {
        Iterator<xvc.a> r101 = this.f525757c.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        xvc.a r102 = r101.next();
        if (r102.a() > r100) goto L4;
        return r102;
    L9:
        return this.f525757c.getFirst();
    }

    @Override // xvc.a
    public final int d(f r100, f r101) {
        return g(r100.f525685g).d(r100, r101);
    }

    @Override // xvc.a
    public final void e(Text r100, Text r101, int r102) {
        g(r102).e(r100, r101, r102);
    }
}
